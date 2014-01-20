package br.com.fox.Hibernate.DAO;

import br.com.fox.db.Alarme;
import br.com.fox.db.Authorities;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.TransactionException;

/**
 *
 * @author VAN
 */
public class TesteDAO {
    private Session session;
    
    public TesteDAO(Session session) {
        this.session = session;
    }
    
    public List<Authorities> getAuthorities() {
        String sql = "FROM Authorities";
        try {
            this.session.beginTransaction();
            Query query = this.session.createQuery(sql);
            
            return query.list();
        }catch(HibernateException ex) {
            ex.printStackTrace();
            return null;
        }finally {
            try {
                this.session.getTransaction().commit();
            }catch(TransactionException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
