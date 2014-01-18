package br.com.fox.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Dvr
 */
public class DBConnectionFactory {

    private EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JCMPU");
    private Connection conn;
    
    public DBConnectionFactory() {
    }
 
    public Connection getConnection(){
        String driver = (String) emf.getProperties().get("javax.persistence.jdbc.driver");
        String url = (String) emf.getProperties().get("javax.persistence.jdbc.url");
        String user = (String) emf.getProperties().get("javax.persistence.jdbc.user");
        String password = (String) emf.getProperties().get("javax.persistence.jdbc.password");
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return conn;
    }
    
    public void close(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
