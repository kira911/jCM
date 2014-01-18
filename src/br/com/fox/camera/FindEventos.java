package br.com.fox.camera;

import br.com.fox.controller.AlarmeJpaController;
import br.com.fox.controller.SinalRouterJpaController;
import br.com.fox.controller.exceptions.NonexistentEntityException;
import br.com.fox.db.Alarme;
import br.com.fox.db.SinalRouter;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Dvr
 */
public class FindEventos implements Runnable {

    private SinalRouterJpaController jpaSinal = new SinalRouterJpaController();
    private AlarmeJpaController jpaAlarme = new AlarmeJpaController();
    private JList listNaoAtendido;
    private JList listEspera;
    private SomEventos som = new SomEventos();

    public FindEventos() {
    }

    public FindEventos(JList listNaoAtendido, JList listEspera) {
        this.listNaoAtendido = listNaoAtendido;
        this.listEspera = listEspera;
    }

    @Override
    public void run() {

        Thread t = new Thread(som);
        t.start();

        int qtdAntItem = 0;

        while (true) {
            DefaultListModel<Object> listModel = new DefaultListModel<Object>();

            List<SinalRouter> listSr = jpaSinal.findSinalRouterNaoAtendido();
            List<Alarme> listAlm = jpaAlarme.findAlarmeNaoAtendido();

            for (Alarme alarme : listAlm) {
                int qtdItem = listEspera.getModel().getSize();

                if (qtdItem > 0) {
                    for (int i = 0; i < qtdItem; i++) {
                        Alarme almEspera = (Alarme) listEspera.getModel().getElementAt(i);

                        if (alarme.equals(almEspera)) {
                            /*
                            alarme.setStatus("ATENDIDO");
                            alarme.setLog("Evento sendo tratado.");
                            alarme.setUsername(almEspera.getUsername());
                            try {
                                jpaAlarme.edit(alarme);
                            } catch (NonexistentEntityException ex) {
                                Logger.getLogger(FindEventos.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                Logger.getLogger(FindEventos.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            * 
                            */
                        } else {
                            listModel.addElement(alarme);
                        }
                    }

                } else {
                    listModel.addElement(alarme);
                }

            }

            for (SinalRouter sr : listSr) {
                listModel.addElement(sr);
            }

            som.setQtdItem(listModel.size());

            if (qtdAntItem == 0) {
                qtdAntItem = listModel.size();
            } else {
                if (qtdAntItem != listModel.size()) {
                    som.setQtdNot(0);
                    qtdAntItem = listModel.size();
                }
            }

            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(FindEventos.class.getName()).log(Level.SEVERE, null, ex);
            }

            listNaoAtendido.setCellRenderer(new CoresEventos());
            listNaoAtendido.setModel(listModel);
        }
    }
}
