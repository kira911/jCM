package br.com.fox.factory;

import br.com.fox.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionException;

/**
 *
 * @author VAN
 */
public class SessionFactory {
    
    public static Session openSession() {
        return HibernateUtil.getSession();
    }
    
    public static void closeSession(Session session) {
        try {
            session.close();
        }catch(  NullPointerException | SessionException ex) {
            ex.printStackTrace();
        }
    }
    
}
