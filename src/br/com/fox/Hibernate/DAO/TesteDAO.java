package br.com.fox.Hibernate.DAO;

import br.com.fox.db.Alarme;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author VAN
 */
public class TesteDAO {
    private Session session;
    
    public TesteDAO(Session session) {
        this.session = session;
    }
    
    public List<Alarme> getAlarmes() {
        try {
            this.session.beginTransaction();
            
            return this.session.createCriteria(Alarme.class).list();
        }catch(HibernateException ex) {
            ex.printStackTrace();
            return null;
        }finally {
            this.session.getTransaction().commit();
        }
    }
    
}
