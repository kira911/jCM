package br.com.fox.view;

import br.com.fox.controller.AlarmeJpaController;
import br.com.fox.controller.SinalRouterJpaController;
import br.com.fox.controller.exceptions.NonexistentEntityException;
import br.com.fox.db.Alarme;
import br.com.fox.db.Authorities;
import br.com.fox.db.SinalRouter;
import br.com.fox.db.Users;
import br.com.fox.util.Config;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Dvr
 */
public class View extends javax.swing.JFrame {

    private AlarmeJpaController jpaAlarme = new AlarmeJpaController();
    private SinalRouterJpaController jpaRouter = new SinalRouterJpaController();
    private Config config = new Config();
    private Users users;
    private PMonitoramentoView pnMonit = new PMonitoramentoView();
    private POs os = new POs();

    public View() {
        initComponents();
        carregaConfig();
        setExtendedState(MAXIMIZED_BOTH);
    }

    public void setUsers(Users users) {
        this.users = users;

        pnMonit.setUsers(this.users);
        os.setSelectedUsers(this.users);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Central de Monitoramento");
        setIconImage(new ImageIcon(getClass().getResource("/br/com/icones/Apps-utilities-system-monitor-icon.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());
        jTabbedPane1.addTab("Estação de monitoramento", new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Security-Camera-icon.png")), jPanel1); // NOI18N
        jPanel1.add(pnMonit, BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());
        jTabbedPane1.addTab("Consultas", new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Search-Male-User-icon.png")), jPanel2); // NOI18N
        PConsultaView c = new PConsultaView();
        jPanel2.add(c, BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.BorderLayout());
        jTabbedPane1.addTab("Chamado Técnico", new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Occupations-Technical-Support-Representative-Female-Light-icon.png")), jPanel3); // NOI18N
        jPanel3.add(os, BorderLayout.CENTER);

        jMenu1.setText("Cadastro");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Actions-list-add-user-icon.png"))); // NOI18N
        jMenuItem1.setText("Cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Alerts-icon16.png"))); // NOI18N
        jMenuItem4.setText("Protocolo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Office.png"))); // NOI18N
        jMenuItem2.setText("Usuário");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Relatórios");

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Adobe-PDF-Document-icon.png"))); // NOI18N
        jMenuItem5.setText("Visualizar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Sistema");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Actions-system-shutdown-icon.png"))); // NOI18N
        jMenuItem3.setText("Logoff");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    logoff();
}//GEN-LAST:event_jMenuItem3ActionPerformed

private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

    List<Authorities> list = users.getAuthoritiesList();

    for (Authorities a : list) {
        if (a.getAuthority().equals("administrador")) {
            ClienteView view = new ClienteView();
            view.pack();
            view.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

}//GEN-LAST:event_jMenuItem1ActionPerformed

private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

    List<Authorities> list = users.getAuthoritiesList();

    for (Authorities a : list) {
        if (a.getAuthority().equals("administrador")) {
            UsersView uv = new UsersView(config);
            uv.pack();
            uv.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

}//GEN-LAST:event_jMenuItem2ActionPerformed

private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
    List<Authorities> list = users.getAuthoritiesList();

    for (Authorities a : list) {
        if (a.getAuthority().equals("administrador")) {
            ProtocoloView pv = new ProtocoloView();
            pv.pack();
            pv.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

}//GEN-LAST:event_jMenuItem4ActionPerformed

private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
    List<Authorities> list = users.getAuthoritiesList();

    for (Authorities a : list) {
        if (a.getAuthority().equals("administrador")) {
            RelatorioView view = new RelatorioView();
            view.pack();
            view.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}//GEN-LAST:event_jMenuItem5ActionPerformed

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    logoff();

}//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;


                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new View().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    private void carregaConfig() {
        try {
            File file = new File("config.xml");
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(file);
            Element root = doc.getRootElement();
            List list = root.getChildren();
            Iterator i = list.iterator();

            while (i.hasNext()) {
                Element xml = (Element) i.next();

                config.setPathRouterSnapshot(xml.getChildText("pathRouterSnapshot"));
                config.setPathDestSnapshot(xml.getChildText("pathDestSnapshot"));
                config.setSmtpHostEmail(xml.getChildText("smtpHostEmail"));
                config.setSmtpPortEmail(Integer.parseInt(xml.getChildText("smtpPortEmail")));
                config.setUserEmail(xml.getChildText("userEmail"));
                config.setPassEmail(xml.getChildText("passEmail"));
                config.setHostFTP(xml.getChildText("hostFTP"));
                config.setPortaFTP(Integer.parseInt(xml.getChildText("portaFTP")));
                config.setUserFTP(xml.getChildText("userFTP"));
                config.setPassFTP(xml.getChildText("passFTP"));
                config.setPathDestFTP(xml.getChildText("pathDestFTP"));
            }
        } catch (JDOMException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Arquivo de configuração não encontrado", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void logoff() {
        int logoff = JOptionPane.showConfirmDialog(this, "Deseja efetuar LOGOFF?");

        if (logoff == 0) {
            List<SinalRouter> listSrt = jpaRouter.findSinalRouterEmEspera();
            List<Alarme> listAlm = jpaAlarme.findAlarmeEmEspera();

            if (listSrt.size() > 0 || listAlm.size() > 0) {
                boolean alrUser = false;

                for (SinalRouter sr : listSrt) {
                    if (sr.getUsername().equals(users)) {
                        alrUser = true;
                        break;
                    }
                }

                for (Alarme alarme : listAlm) {
                    if (alarme.getUsername().getUsername().equals(users.getUsername())) {
                        alrUser = true;
                        break;
                    }
                }

                if (alrUser) {
                    int r = JOptionPane.showConfirmDialog(this, "Existe alarmes em espera\nDeseja prosseguir?");

                    if (r == 0) {
                        for (SinalRouter sr : listSrt) {
                            if (sr.getUsername().equals(users)) {
                                sr.setStatus("NÃO ATENDIDO");
                                try {
                                    jpaRouter.edit(sr);
                                } catch (NonexistentEntityException ex) {
                                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (Exception ex) {
                                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }

                        for (Alarme alarme : listAlm) {
                            if (alarme.getUsername().getUsername().equals(users.getUsername())) {
                                alarme.setStatus("NÃO ATENDIDO");
                                try {
                                    jpaAlarme.edit(alarme);
                                } catch (NonexistentEntityException ex) {
                                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (Exception ex) {
                                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        System.exit(EXIT_ON_CLOSE);
                    }
                } else {
                    System.exit(EXIT_ON_CLOSE);
                }

            } else {
                System.exit(EXIT_ON_CLOSE);
            }
        }
    }
}
