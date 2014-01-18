/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fox.controller;

import br.com.fox.controller.exceptions.NonexistentEntityException;
import br.com.fox.db.Alarme;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.fox.db.Users;
import br.com.fox.db.Protocolo;
import br.com.fox.db.Cliente;
import com.sun.jna.platform.win32.OaIdl;
import java.util.Date;

/**
 *
 * @author Dvr
 */
public class AlarmeJpaController implements Serializable {

    public AlarmeJpaController() {
    }

    public AlarmeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JCMPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Alarme alarme) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users username = alarme.getUsername();
            if (username != null) {
                username = em.getReference(username.getClass(), username.getUsername());
                alarme.setUsername(username);
            }
            Protocolo idprotocolo = alarme.getIdprotocolo();
            if (idprotocolo != null) {
                idprotocolo = em.getReference(idprotocolo.getClass(), idprotocolo.getIdprotocolo());
                alarme.setIdprotocolo(idprotocolo);
            }
            Cliente idcliente = alarme.getIdcliente();
            if (idcliente != null) {
                idcliente = em.getReference(idcliente.getClass(), idcliente.getIdcliente());
                alarme.setIdcliente(idcliente);
            }
            em.persist(alarme);
            if (username != null) {
                username.getAlarmeList().add(alarme);
                username = em.merge(username);
            }
            if (idprotocolo != null) {
                idprotocolo.getAlarmeList().add(alarme);
                idprotocolo = em.merge(idprotocolo);
            }
            if (idcliente != null) {
                idcliente.getAlarmeList().add(alarme);
                idcliente = em.merge(idcliente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Alarme alarme) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
                        
            
            Alarme persistentAlarme = em.find(Alarme.class, alarme.getIdalarme());
            Users usernameOld = persistentAlarme.getUsername();
            Users usernameNew = alarme.getUsername();
            Protocolo idprotocoloOld = persistentAlarme.getIdprotocolo();
            Protocolo idprotocoloNew = alarme.getIdprotocolo();
            Cliente idclienteOld = persistentAlarme.getIdcliente();
            Cliente idclienteNew = alarme.getIdcliente();
            if (usernameNew != null) {
                usernameNew = em.getReference(usernameNew.getClass(), usernameNew.getUsername());
                alarme.setUsername(usernameNew);
            }
            if (idprotocoloNew != null) {
                idprotocoloNew = em.getReference(idprotocoloNew.getClass(), idprotocoloNew.getIdprotocolo());
                alarme.setIdprotocolo(idprotocoloNew);
            }
            if (idclienteNew != null) {
                idclienteNew = em.getReference(idclienteNew.getClass(), idclienteNew.getIdcliente());
                alarme.setIdcliente(idclienteNew);
            }
            alarme = em.merge(alarme);
            if (usernameOld != null && !usernameOld.equals(usernameNew)) {
                usernameOld.getAlarmeList().remove(alarme);
                usernameOld = em.merge(usernameOld);
            }
            if (usernameNew != null && !usernameNew.equals(usernameOld)) {
                usernameNew.getAlarmeList().add(alarme);
                usernameNew = em.merge(usernameNew);
            }
            if (idprotocoloOld != null && !idprotocoloOld.equals(idprotocoloNew)) {
                idprotocoloOld.getAlarmeList().remove(alarme);
                idprotocoloOld = em.merge(idprotocoloOld);
            }
            if (idprotocoloNew != null && !idprotocoloNew.equals(idprotocoloOld)) {
                idprotocoloNew.getAlarmeList().add(alarme);
                idprotocoloNew = em.merge(idprotocoloNew);
            }
            if (idclienteOld != null && !idclienteOld.equals(idclienteNew)) {
                idclienteOld.getAlarmeList().remove(alarme);
                idclienteOld = em.merge(idclienteOld);
            }
            if (idclienteNew != null && !idclienteNew.equals(idclienteOld)) {
                idclienteNew.getAlarmeList().add(alarme);
                idclienteNew = em.merge(idclienteNew);
            }
            
            
            em.merge(alarme);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = alarme.getIdalarme();
                if (findAlarme(id) == null) {
                    throw new NonexistentEntityException("The alarme with id " + id + " no longer exists.");
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
            Alarme alarme;
            try {
                alarme = em.getReference(Alarme.class, id);
                alarme.getIdalarme();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alarme with id " + id + " no longer exists.", enfe);
            }
            Users username = alarme.getUsername();
            if (username != null) {
                username.getAlarmeList().remove(alarme);
                username = em.merge(username);
            }
            Protocolo idprotocolo = alarme.getIdprotocolo();
            if (idprotocolo != null) {
                idprotocolo.getAlarmeList().remove(alarme);
                idprotocolo = em.merge(idprotocolo);
            }
            Cliente idcliente = alarme.getIdcliente();
            if (idcliente != null) {
                idcliente.getAlarmeList().remove(alarme);
                idcliente = em.merge(idcliente);
            }
            em.remove(alarme);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Alarme> findAlarmeEntities() {
        return findAlarmeEntities(true, -1, -1);
    }

    public List<Alarme> findAlarmeEntities(int maxResults, int firstResult) {
        return findAlarmeEntities(false, maxResults, firstResult);
    }

    private List<Alarme> findAlarmeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Alarme.class));
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

    public Alarme findAlarme(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Alarme.class, id);
        } finally {
            em.close();
        }
    }

    public List<Alarme> findAlarme(String tpEvento, Integer limit, Integer idcliente) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM Alarme a "
                    + "WHERE a.idprotocolo.cuc.tipoEvento like '" + tpEvento + "' AND "
                    + "a.idcliente.idcliente = " + idcliente + " "
                    + "ORDER BY 1 DESC");

            q.setMaxResults(limit);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List getEventosSensor(Integer idCliente, Date startDate, Date endDate) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT " +
                    "alarme.data_recebimento AS alarme_data_recebimento, " +
                    "protocolo.evento AS protocolo_evento, " +
                    "protocolo.descricao AS protocolo_descricao, " +
                    "alarme.receiver, " +
                    "alarme.linha, " +
                    "alarme.particao, " +
                    "CASE cuc.auxiliar " +
                        "WHEN " +
                            "'Zona' " +
                        "THEN " +
                            "(SELECT " +
                                "CASE count(num_zona) " +
                                    "WHEN 0 THEN alarme.zona " +
                                    "ELSE num_zona " +
                                "END as num_zona " +
                            "FROM " +
                                "zona " +
                            "WHERE " +
                                "num_zona = alarme.zona and idcliente = alarme.idcliente " +
                                "LIMIT 1) " +
                        "WHEN " +
                            "'Usuário' " +
                        "THEN " +
                            "(select " +
                                "CASE count(codigo) " +
                                    "WHEN 0 THEN alarme.zona " +
                                        "else codigo " +
                                    "END as codigo " +
                                "FROM " +
                                     "usuario " +
                                "WHERE " +
                                    "codigo = alarme.zona and idcliente = alarme.idcliente " +
                                "LIMIT 1) " +
                        "WHEN 'Nenhum' THEN '' " +
                    "END as id_auxiliar, " +
                    "CASE cuc.auxiliar " +
                        "WHEN " +
                            "'Zona' " +
                        "THEN " +
                            "(select " +
                                    "CASE count(areas) " +
                                        "WHEN 0 THEN 'Zona não cadastrada' " +
                                        "else areas " +
                                    "END as codigo " +
                            "FROM " +
                                "zona " +
                            "WHERE " +
                                "num_zona = alarme.zona and idcliente = alarme.idcliente " +
                            "LIMIT 1) " +
                    "WHEN " +
                        "'Usuário' " +
                    "THEN " +
                         "(select " +
                            "CASE count(nome) " +
                                "WHEN 0 THEN 'Usuário não cadastrado' " +
                                "else nome " +
                        "END as codigo " +
                "FROM " +
                    "usuario " +
                "WHERE " +
                    "codigo = alarme.zona and idcliente = alarme.idcliente " +
                "LIMIT 1) " +
                    "WHEN 'Nenhum' THEN '' " +
                "END as auxiliar, " +
                "alarme.status AS alarme_status, " +
                "users.username AS users_username, " +
                "alarme.duracao AS alarme_duracao, " +
                 "alarme.log AS alarme_log " +
            "FROM " +
                 "protocolo protocolo " +
                 "INNER JOIN alarme alarme ON protocolo.idprotocolo = alarme.idprotocolo " +
                 "INNER JOIN cuc cuc ON protocolo.cuc = cuc.idcuc " +
                 "INNER JOIN users users ON alarme.username = users.username " +
                 "INNER JOIN cliente cliente ON alarme.idcliente = cliente.idcliente " +
                 "INNER JOIN usuario usuario ON cliente.idcliente = usuario.idcliente " +
                 "INNER JOIN zona zona ON cliente.idcliente = zona.idcliente " +
             "WHERE alarme.idcliente = 21 " +
                 " AND cast(alarme.data_recebimento as DATE) >= '2011-17-01 09:47:40' " +
                 "AND cast(alarme.data_recebimento as DATE) <= '2014-17-01 20:40:38' " +
            "GROUP BY alarme.idalarme " +
            "ORDER BY alarme.data_recebimento ");
            
            List lista = query.getResultList();
            
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    /*public List<Alarme> findAlarmeByDay(int day) {
    
    Calendar c = Calendar.getInstance();
    c.add(Calendar.DAY_OF_MONTH, -day);
    
    String data = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
    
    EntityManager em = getEntityManager();
    try {
    Query q = em.createNativeQuery("select * from alarme "
    + "where CAST(data_hora as date) >= '" + data + "' and CAST(data_hora as date) <= " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    
    
    System.out.println(q.getResultList());
    return q.getResultList();
    } finally {
    em.close();
    }
    }*/
    public List<Alarme> findAlarmeNaoAtendido() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM Alarme a "
                    + "WHERE a.status = 'NÃO ATENDIDO'");

            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Alarme> findAlarmeEmEspera() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM Alarme a "
                    + "WHERE a.status like 'EM ESPERA'");

            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Alarme> findAlarmeObservacao() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM Alarme a "
                    + "WHERE a.status like 'OBSERVAÇÃO'");

            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public int getAlarmeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Alarme> rt = cq.from(Alarme.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
