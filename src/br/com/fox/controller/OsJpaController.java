/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fox.controller;

import br.com.fox.controller.exceptions.NonexistentEntityException;
import br.com.fox.controller.exceptions.PreexistingEntityException;
import br.com.fox.db.Os;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.fox.db.Users;
import br.com.fox.db.Cliente;
import br.com.fox.db.Ipos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dvr
 */
public class OsJpaController implements Serializable {

    public OsJpaController() {
    }

    public OsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JCMPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Os os) throws PreexistingEntityException, Exception {
        if (os.getIposList() == null) {
            os.setIposList(new ArrayList<Ipos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users username = os.getUsername();
            if (username != null) {
                username = em.getReference(username.getClass(), username.getUsername());
                os.setUsername(username);
            }
            Cliente idcliente = os.getIdcliente();
            if (idcliente != null) {
                idcliente = em.getReference(idcliente.getClass(), idcliente.getIdcliente());
                os.setIdcliente(idcliente);
            }
            List<Ipos> attachedIposList = new ArrayList<Ipos>();
            for (Ipos iposListIposToAttach : os.getIposList()) {
                iposListIposToAttach = em.getReference(iposListIposToAttach.getClass(), iposListIposToAttach.getIdipos());
                attachedIposList.add(iposListIposToAttach);
            }
            os.setIposList(attachedIposList);
            em.persist(os);
            if (username != null) {
                username.getOsList().add(os);
                username = em.merge(username);
            }
            if (idcliente != null) {
                idcliente.getOsList().add(os);
                idcliente = em.merge(idcliente);
            }
            for (Ipos iposListIpos : os.getIposList()) {
                Os oldIdosOfIposListIpos = iposListIpos.getIdos();
                iposListIpos.setIdos(os);
                iposListIpos = em.merge(iposListIpos);
                if (oldIdosOfIposListIpos != null) {
                    oldIdosOfIposListIpos.getIposList().remove(iposListIpos);
                    oldIdosOfIposListIpos = em.merge(oldIdosOfIposListIpos);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOs(os.getIdos()) != null) {
                throw new PreexistingEntityException("Os " + os + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Os os) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Os persistentOs = em.find(Os.class, os.getIdos());
            Users usernameOld = persistentOs.getUsername();
            Users usernameNew = os.getUsername();
            Cliente idclienteOld = persistentOs.getIdcliente();
            Cliente idclienteNew = os.getIdcliente();
            List<Ipos> iposListOld = persistentOs.getIposList();
            List<Ipos> iposListNew = os.getIposList();
            if (usernameNew != null) {
                usernameNew = em.getReference(usernameNew.getClass(), usernameNew.getUsername());
                os.setUsername(usernameNew);
            }
            if (idclienteNew != null) {
                idclienteNew = em.getReference(idclienteNew.getClass(), idclienteNew.getIdcliente());
                os.setIdcliente(idclienteNew);
            }
            List<Ipos> attachedIposListNew = new ArrayList<Ipos>();
            for (Ipos iposListNewIposToAttach : iposListNew) {
                iposListNewIposToAttach = em.getReference(iposListNewIposToAttach.getClass(), iposListNewIposToAttach.getIdipos());
                attachedIposListNew.add(iposListNewIposToAttach);
            }
            iposListNew = attachedIposListNew;
            os.setIposList(iposListNew);
            os = em.merge(os);
            if (usernameOld != null && !usernameOld.equals(usernameNew)) {
                usernameOld.getOsList().remove(os);
                usernameOld = em.merge(usernameOld);
            }
            if (usernameNew != null && !usernameNew.equals(usernameOld)) {
                usernameNew.getOsList().add(os);
                usernameNew = em.merge(usernameNew);
            }
            if (idclienteOld != null && !idclienteOld.equals(idclienteNew)) {
                idclienteOld.getOsList().remove(os);
                idclienteOld = em.merge(idclienteOld);
            }
            if (idclienteNew != null && !idclienteNew.equals(idclienteOld)) {
                idclienteNew.getOsList().add(os);
                idclienteNew = em.merge(idclienteNew);
            }
            for (Ipos iposListOldIpos : iposListOld) {
                if (!iposListNew.contains(iposListOldIpos)) {
                    iposListOldIpos.setIdos(null);
                    iposListOldIpos = em.merge(iposListOldIpos);
                }
            }
            for (Ipos iposListNewIpos : iposListNew) {
                if (!iposListOld.contains(iposListNewIpos)) {
                    Os oldIdosOfIposListNewIpos = iposListNewIpos.getIdos();
                    iposListNewIpos.setIdos(os);
                    iposListNewIpos = em.merge(iposListNewIpos);
                    if (oldIdosOfIposListNewIpos != null && !oldIdosOfIposListNewIpos.equals(os)) {
                        oldIdosOfIposListNewIpos.getIposList().remove(iposListNewIpos);
                        oldIdosOfIposListNewIpos = em.merge(oldIdosOfIposListNewIpos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = os.getIdos();
                if (findOs(id) == null) {
                    throw new NonexistentEntityException("The os with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Os os;
            try {
                os = em.getReference(Os.class, id);
                os.getIdos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The os with id " + id + " no longer exists.", enfe);
            }
            Users username = os.getUsername();
            if (username != null) {
                username.getOsList().remove(os);
                username = em.merge(username);
            }
            Cliente idcliente = os.getIdcliente();
            if (idcliente != null) {
                idcliente.getOsList().remove(os);
                idcliente = em.merge(idcliente);
            }
            List<Ipos> iposList = os.getIposList();
            for (Ipos iposListIpos : iposList) {
                iposListIpos.setIdos(null);
                iposListIpos = em.merge(iposListIpos);
            }
            em.remove(os);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Os> findOsEntities() {
        return findOsEntities(true, -1, -1);
    }

    public List<Os> findOsEntities(int maxResults, int firstResult) {
        return findOsEntities(false, maxResults, firstResult);
    }

    private List<Os> findOsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Os.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Os findOs(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Os.class, id);
        } finally {
            em.close();
        }
    }

    public Os maxOs() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT os FROM Os os "
                    + "ORDER BY os.idos DESC");

            q.setMaxResults(1);

            return (Os) q.getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<Os> findOs(String value, String tabela, String status, String status2) {
        EntityManager em = getEntityManager();
        Query q = null;

        if (tabela.equals("idos")) {
            q = em.createQuery("SELECT os FROM Os os "
                    + "WHERE os.idos = " + value + " AND os.status LIKE '" + status.toUpperCase() + "%' "
                    + "AND os.status LIKE '" + status2.toUpperCase() + "%' "
                    + "ORDER BY os.data DESC");
        }
        
        if (tabela.equals("cliente")) {
            q = em.createQuery("SELECT os FROM Os os "
                    + "WHERE os.idcliente.nome LIKE '" + value + "%' AND os.status LIKE '" + status.toUpperCase() + "%' "
                    + "AND os.status LIKE '" + status2.toUpperCase() + "%' "
                    + "ORDER BY os.data DESC");
        }
        
        if (tabela.equals("operador")) {
            q = em.createQuery("SELECT os FROM Os os "
                    + "WHERE os.username.username LIKE '" + value + "%' AND os.status LIKE '" + status.toUpperCase() + "%' "
                    + "AND os.status LIKE '" + status2.toUpperCase() + "%' "
                    + "ORDER BY os.data DESC");
        }

        return q.getResultList();
    }

    public int getOsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Os> rt = cq.from(Os.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
