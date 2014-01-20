package br.com.fox.util;

import br.com.fox.db.Alarme;
import br.com.fox.db.Authorities;
import br.com.fox.db.Cliente;
import br.com.fox.db.Contato;
import br.com.fox.db.Cuc;
import br.com.fox.db.Horario;
import br.com.fox.db.Ipos;
import br.com.fox.db.Os;
import br.com.fox.db.Protocolo;
import br.com.fox.db.SinalRouter;
import br.com.fox.db.Users;
import br.com.fox.db.Usuario;
import br.com.fox.db.Zona;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author VAN
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    
    //This block is executed before the instantiation of the class
    static {
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Alarme.class);
        cfg.addAnnotatedClass(Cliente.class);
        cfg.addAnnotatedClass(Protocolo.class);
        cfg.addAnnotatedClass(Users.class);
        cfg.addAnnotatedClass(Cuc.class);
        cfg.addAnnotatedClass(Contato.class);
        cfg.addAnnotatedClass(Horario.class);
        cfg.addAnnotatedClass(Os.class);
        cfg.addAnnotatedClass(SinalRouter.class);
        cfg.addAnnotatedClass(Usuario.class);
        cfg.addAnnotatedClass(Zona.class);
        cfg.addAnnotatedClass(Authorities.class);
        cfg.addAnnotatedClass(Ipos.class);
        
        cfg.configure("/META-INF/hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        
        try {
            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        } catch(HibernateException ex) {
            ex.printStackTrace();
        }
    }
     
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session getSession() {
        return sessionFactory.openSession();
    }
    
    public static StatelessSession getStatelessSession() {
        return sessionFactory.openStatelessSession();
    }
}
