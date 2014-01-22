package testes;

import br.com.fox.Hibernate.DAO.EventosSensorDAO;
import br.com.fox.util.EventosSensor;
import br.com.fox.util.HibernateUtil;
import java.util.List;

/**
 *
 * @author VAN
 */
public class Main {

    public static void main(String[] args) {
        EventosSensorDAO evtSensorDAO = new EventosSensorDAO(HibernateUtil.getSession());
        evtSensorDAO.getListEventosSensor();
        //List<EventosSensor> eventosSensor = evtSensorDAO.getListEventosSensor();        
        
        System.out.println("Rodou");
//        TesteDAO testeDAO = new TesteDAO(new HibernateUtil().getSession());
//        List<Authorities> listaAuthorities = testeDAO.getAuthorities();
//        int i = 0;
//        
//        for(Authorities authority : listaAuthorities) {
//            System.out.println("Volta == " + i + "usuario == " + authority.getUsername().getUsername());            
//            ++i;
//        }
    }
    
}
