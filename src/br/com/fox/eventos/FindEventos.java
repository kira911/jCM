package br.com.fox.eventos;

import br.com.fox.controller.AlarmeJpaController;
import br.com.fox.controller.SinalRouterJpaController;
import br.com.fox.controller.exceptions.NonexistentEntityException;
import br.com.fox.db.Alarme;
import br.com.fox.db.SinalRouter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author Dvr
 */
public class FindEventos implements Runnable {

    private SinalRouterJpaController jpaSinal = new SinalRouterJpaController();
    private AlarmeJpaController jpaAlarme = new AlarmeJpaController();
    private JList listNaoAtendido;
    private JList listEspera;
    private JList listObs;
    private SomEventos som = new SomEventos();

    public FindEventos() {
    }

    public FindEventos(JList listNaoAtendido, JList listEspera, JList listObs) {
        this.listNaoAtendido = listNaoAtendido;
        this.listEspera = listEspera;
        this.listObs = listObs;
    }

    @Override
    public void run() {

        Thread t = new Thread(som);
        t.start();

        int qtdAntItem = 0;

        while (true) {
            DefaultListModel<Object> listModel = new DefaultListModel<Object>();
            //ListModel listModel = (DefaultListModel) listNaoAtendido.getModel();
            //DefaultListModel<Object> listModel = (DefaultListModel<Object>) listNaoAtendido.getModel();
                    
            List<SinalRouter> listSr = jpaSinal.findSinalRouterNaoAtendido();
            List<Alarme> listAlm = jpaAlarme.findAlarmeNaoAtendido();
            
                                   
            
            for (Alarme alarme : listAlm) {
                                          
                //Tratando alarmes repetidos em espera automaticamente
                int qtdItem = listEspera.getModel().getSize();

                listModel.addElement(alarme);

                /*
                if (qtdItem > 0) {
                    for (int i = 0; i < qtdItem; i++) {

                        if (listEspera.getModel().getElementAt(i) instanceof Alarme) {
                            Alarme almEspera = (Alarme) listEspera.getModel().getElementAt(i);

                            if (alarme.equals(almEspera)) {
                                listModel.removeElement(alarme);
                                alarme.setStatus("ATENDIDO");
                                alarme.setLog("Evento já está sendo controlado desde " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(almEspera.getDataRecebimento()) + ". Fechado automaticamente. ");
                                alarme.setUsername(almEspera.getUsername());
                                try {
                                    jpaAlarme.edit(alarme);
                                } catch (NonexistentEntityException ex) {
                                    Logger.getLogger(FindEventos.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (Exception ex) {
                                    Logger.getLogger(FindEventos.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                }
                
                //Tratando alarmes repetidos em observação automaticamente
                qtdItem = listObs.getModel().getSize();

                //listModel.addElement(alarme);

                if (qtdItem > 0) {
                    for (int i = 0; i < qtdItem; i++) {

                        if (listObs.getModel().getElementAt(i) instanceof Alarme) {
                            Alarme almObs = (Alarme) listObs.getModel().getElementAt(i);

                            if (alarme.equals(almObs)) {
                                listModel.removeElement(alarme);
                                alarme.setStatus("ATENDIDO");
                                alarme.setLog("Evento já está sendo controlado desde " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(almObs.getDataRecebimento()) + ". Fechado automaticamente. ");
                                alarme.setUsername(almObs.getUsername());
                                try {
                                    jpaAlarme.edit(alarme);
                                } catch (NonexistentEntityException ex) {
                                    Logger.getLogger(FindEventos.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (Exception ex) {
                                    Logger.getLogger(FindEventos.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                } 
                * 
                */
            }
  
            
            /*
            //Tratando alarmes repetidos em observação automaticamente
            for (Alarme alarme : listAlm) {
                int qtdItem = listObs.getModel().getSize();

                //listModel.addElement(alarme);

                if (qtdItem > 0) {
                    for (int i = 0; i < qtdItem; i++) {

                        if (listObs.getModel().getElementAt(i) instanceof Alarme) {
                            Alarme almObs = (Alarme) listObs.getModel().getElementAt(i);

                            if (alarme.equals(almObs)) {
                                listModel.removeElement(alarme);
                                alarme.setStatus("ATENDIDO");
                                alarme.setLog("Evento já está sendo controlado desde " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(almObs.getDataRecebimento()) + ". Fechado automaticamente. ");
                                alarme.setUsername(almObs.getUsername());
                                try {
                                    jpaAlarme.edit(alarme);
                                } catch (NonexistentEntityException ex) {
                                    Logger.getLogger(FindEventos.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (Exception ex) {
                                    Logger.getLogger(FindEventos.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                }
            }
            */
            
            for (SinalRouter sr : listSr) {
                listModel.addElement(sr);
            }

            //Som de alerta
            som.setQtdItem(listModel.size());

            if (qtdAntItem == 0) {
                qtdAntItem = listModel.size();
            } else {
                if (qtdAntItem != listModel.size()) {
                    som.setQtdNot(0);
                    qtdAntItem = listModel.size();
                }
            }
            
            listNaoAtendido.setCellRenderer(new CoresEventos());
            listNaoAtendido.setModel(listModel);

            try {
                Thread.sleep(2000);
                //Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FindEventos.class.getName()).log(Level.SEVERE, null, ex);
            }

            ////listNaoAtendido.setCellRenderer(new CoresEventos());
            //listNaoAtendido.setModel(listModel);
        }
    }
}
