package br.com.fox.camera;

import br.com.fox.controller.AlarmeJpaController;
import br.com.fox.controller.SinalRouterJpaController;
import br.com.fox.db.Alarme;
import br.com.fox.db.SinalRouter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Dvr
 */
public class FindSinalRouter implements Runnable {

    private SinalRouterJpaController jpaSinal = new SinalRouterJpaController();
    private AlarmeJpaController jpaAlarme = new AlarmeJpaController();
    private JList list;

    public FindSinalRouter() {
    }

    public FindSinalRouter(JList list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            DefaultListModel<Object> listModel = new DefaultListModel<Object>();

            List<SinalRouter> listSr = jpaSinal.findSinalRouterNaoAtendido();
            List<Alarme> listAlm = jpaAlarme.findAlarmeNaoAtendido();

            for (Alarme alarme : listAlm) {
                listModel.addElement(alarme);
            }
            
            for (SinalRouter sr : listSr) {
                listModel.addElement(sr);
            }

            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(FindSinalRouter.class.getName()).log(Level.SEVERE, null, ex);
            }

            list.setCellRenderer(new CoresAlert());
            list.setModel(listModel);
        }
    }
}
