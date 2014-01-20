package testes;

import br.com.fox.Hibernate.DAO.TesteDAO;
import br.com.fox.db.Authorities;
import br.com.fox.util.HibernateUtil;
import java.util.List;

/**
 *
 * @author VAN
 */
public class Main {

    public static void main(String[] args) {
        TesteDAO testeDAO = new TesteDAO(new HibernateUtil().getSession());
        List<Authorities> listaAuthorities = testeDAO.getAuthorities();
        int i = 0;
        
        for(Authorities authority : listaAuthorities) {
            System.out.println("Volta == " + i + "usuario == " + authority.getUsername().getUsername());            
            ++i;
        }
        
        System.out.println("Rodou");
    }
    
}
