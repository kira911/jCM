package testes;

import br.com.fox.Hibernate.DAO.TesteDAO;
import br.com.fox.db.Alarme;
import br.com.fox.util.HibernateUtil;
import java.util.List;

/**
 *
 * @author VAN
 */
public class Main {

    public static void main(String[] args) {
        TesteDAO testeDAO = new TesteDAO(new HibernateUtil().getSession());
        List<Alarme> listaAlarmes = testeDAO.getAlarmes();
        
        for(Alarme alarme :listaAlarmes) {
            System.out.println("alarme == " + alarme.getUsername());
        }
        
        System.out.println("Rodou");
    }
    
}
