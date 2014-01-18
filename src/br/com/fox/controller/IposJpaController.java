/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fox.controller;

import br.com.fox.controller.exceptions.NonexistentEntityException;
import br.com.fox.controller.exceptions.PreexistingEntityException;
import br.com.fox.db.Ipos;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.fox.db.Os;

/**
 *
 * @author Dvr
 */
public class IposJpaController implements Serializable {

    public IposJpaController() {
    }

    public IposJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JCMPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ipos ipos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Os idos = ipos.getIdos();
            if (idos != null) {
                idos = em.getReference(idos.getClass(), idos.getIdos());
                ipos.setIdos(idos);
            }
            em.persist(ipos);
            if (idos != null) {
                idos.getIposList().add(ipos);
                idos = em.merge(idos);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findIpos(ipos.getIdipos()) != null) {
                throw new PreexistingEntityException("Ipos " + ipos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ipos ipos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ipos persistentIpos = em.find(Ipos.class, ipos.getIdipos());
            Os idosOld = persistentIpos.getIdos();
            Os idosNew = ipos.getIdos();
            if (idosNew != null) {
                idosNew = em.getReference(idosNew.getClass(), idosNew.getIdos());
                ipos.setIdos(idosNew);
            }
            ipos = em.merge(ipos);
            if (idosOld != null && !idosOld.equals(idosNew)) {
                idosOld.getIposList().remove(ipos);
                idosOld = em.merge(idosOld);
            }
            if (idosNew != null && !idosNew.equals(idosOld)) {
                idosNew.getIposList().add(ipos);
                idosNew = em.merge(idosNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ipos.getIdipos();
                if (findIpos(id) == null) {
                    throw new NonexistentEntityException("The ipos with id " + id + " no longer exists.");
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
            Ipos ipos;
            try {
                ipos = em.getReference(Ipos.class, id);
                ipos.getIdipos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ipos with id " + id + " no longer exists.", enfe);
            }
            Os idos = ipos.getIdos();
            if (idos != null) {
                idos.getIposList().remove(ipos);
                idos = em.merge(idos);
            }
            em.remove(ipos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ipos> findIposEntities() {
        return findIposEntities(true, -1, -1);
    }

    public List<Ipos> findIposEntities(int maxResults, int firstResult) {
        return findIposEntities(false, maxResults, firstResult);
    }

    private List<Ipos> findIposEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ipos.class));
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

    public Ipos findIpos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ipos.class, id);
        } finally {
            em.close();
        }
    }

    public int getIposCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ipos> rt = cq.from(Ipos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
