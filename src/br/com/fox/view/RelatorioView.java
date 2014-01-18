package br.com.fox.view;

import br.com.fox.util.DBConnectionFactory;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Dvr
 */
public class RelatorioView extends javax.swing.JFrame {

    private String selectedNode = "";

    public RelatorioView() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        startDate = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        endDate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        spCodCli = new javax.swing.JSpinner();
        btnView = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatórios");
        setIconImage(new ImageIcon(getClass().getResource("/br/com/icones/folder-documents-icon.png")).getImage());
        setResizable(false);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Relatórios de Eventos");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Alarme");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Sensor");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Router");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        tree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(tree);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 16))); // NOI18N

        jLabel1.setText("Data inicial:");

        startDate.setDate(new Date());

        jLabel2.setText("Data Final:");

        endDate.setDate(new Date());

        jLabel3.setText("Código do cliente:");

        spCodCli.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spCodCli))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Actions-media-record-icon.png"))); // NOI18N
        btnView.setText("Visualizar");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnView)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160)
                .addComponent(btnView)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void treeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeValueChanged
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

    if (node == null) {
        return;
    }

    Object nodeInfo = node.getUserObject();
    if (node.isLeaf()) {
        selectedNode = nodeInfo.toString();
    }
}//GEN-LAST:event_treeValueChanged

private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
    if (selectedNode.equals("")) {
        JOptionPane.showMessageDialog(this, "Nenhum relatório selecionado");
    } else {
        String codCli = String.valueOf(spCodCli.getValue());
        
        if (codCli.equals("0")) {
            codCli = "%";
        }
        
        if (selectedNode.equals("Sensor")) {
            try {
                String jasper = "src/br/com/fox/relatorios/detalhado.jasper";               
                //String jasper = getClass().getResource("/br/com/fox/relatorios/detalhado.jasper").getFile();
                //String jasper = getClass().getResource("/relatorios/detalhado.jasper").getFile();

                Map parameters = new HashMap();
                parameters.put("SUBREPORT_DIR", "/src/br/com/fox/relatorios/");
                //parameters.put("SUBREPORT_DIR", "/relatorios/");
                parameters.put("START_DATE", new SimpleDateFormat("yyyy-MM-dd").format(startDate.getDate()));
                parameters.put("END_DATE", new SimpleDateFormat("yyyy-MM-dd").format(endDate.getDate()));
                parameters.put("CODCLI", codCli);

                DBConnectionFactory factory = new DBConnectionFactory();

                Connection conn = factory.getConnection();

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasper,
                        parameters,
                        conn);

                factory.close();

                JasperViewer jv = new JasperViewer(jasperPrint);
                JasperViewer.viewReport(jasperPrint, false);

            } catch (JRException ex) {
                Logger.getLogger(RelatorioView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (selectedNode.equals("Router")) {
                try {
                    String jasper = "src/br/com/fox/relatorios/router.jasper";
                    //String jasper = getClass().getResource("/br/com/fox/relatorios/router.jasper").getFile();
                    //String jasper = getClass().getResource("/relatorios/router.jasper").getFile();                    

                    Map parameters = new HashMap();
                    parameters.put("SUBREPORT_DIR", "/src/br/com/fox/relatorios/");
                    //parameters.put("SUBREPORT_DIR", "/relatorios/");
                    parameters.put("DATE_START", new SimpleDateFormat("yyyy-MM-dd").format(startDate.getDate()));
                    parameters.put("DATE_END", new SimpleDateFormat("yyyy-MM-dd").format(endDate.getDate()));
                    parameters.put("COD_CLI", codCli);

                    DBConnectionFactory factory = new DBConnectionFactory();

                    Connection conn = factory.getConnection();

                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasper,
                            parameters,
                            conn);

                    factory.close();

                    JasperViewer jv = new JasperViewer(jasperPrint);
                    JasperViewer.viewReport(jasperPrint, false);

                } catch (JRException ex) {
                    Logger.getLogger(RelatorioView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}//GEN-LAST:event_btnViewActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(RelatorioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new RelatorioView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnView;
    private com.toedter.calendar.JDateChooser endDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spCodCli;
    private com.toedter.calendar.JDateChooser startDate;
    private javax.swing.JTree tree;
    // End of variables declaration//GEN-END:variables
}
