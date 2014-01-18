package br.com.fox.view;


import br.com.fox.controller.IposJpaController;
import br.com.fox.controller.OsJpaController;
import br.com.fox.controller.exceptions.NonexistentEntityException;
import br.com.fox.db.*;
import br.com.fox.util.DBConnectionFactory;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import com.towel.swing.table.TableFilter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Dvr
 */
public class POs extends javax.swing.JPanel {

    private OsJpaController jpaOs = new OsJpaController();
    private IposJpaController jpaIp = new IposJpaController();
    private Os selectedOs = null;
    private Users selectedUsers;

    public POs() {
        initComponents();
        
        ObjectTableModel<Os> tableModelOs = new ObjectTableModel(
                new AnnotationResolver(Os.class), "idos,data,idcliente.nome,verificar,solicitado,username.username,dataChegada,dataTermino,status,tecnico");  
        tbOs.setModel(tableModelOs);
        //TableFilter filterOs = new TableFilter(tbOs.getTableHeader(), tableModelOs);
        //tbOs.setModel(filterOs);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popMenu = new javax.swing.JPopupMenu();
        itemVisu = new javax.swing.JMenuItem();
        itemEditar = new javax.swing.JMenuItem();
        dlgEdit = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        txtIdOs = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JEditorPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbIp = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtResponsavel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTecnico = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        dataChegada = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtHoraChegada = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        dataTermino = new com.toedter.calendar.JDateChooser();
        txtHoraTermino = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        btnFinal = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnAddLinha = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbOs = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        cboxTabela = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtValue = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        ckSolicitado = new javax.swing.JCheckBox();
        ckFinalizado = new javax.swing.JCheckBox();

        itemVisu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Adobe-PDF-Document-icon.png"))); // NOI18N
        itemVisu.setText("Visualizar");
        itemVisu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVisuActionPerformed(evt);
            }
        });
        popMenu.add(itemVisu);

        itemEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Text-Edit-icon.png"))); // NOI18N
        itemEditar.setText("Editar");
        itemEditar.setEnabled(false);
        itemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarActionPerformed(evt);
            }
        });
        popMenu.add(itemEditar);

        dlgEdit.setTitle("Finalizar OS");

        jLabel4.setText("Chamado técnico Nº ");

        txtIdOs.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIdOs.setEnabled(false);

        txtDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));
        jScrollPane2.setViewportView(txtDescricao);

        tbIp.setModel(new ObjectTableModel(Ipos.class, "qtd,descricao,valor,valorTotal"));
        tbIp.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbIp);

        jLabel2.setText("Equipamentos Utilizados");

        jLabel3.setText("Responsável:");

        jLabel5.setText("Técnico:");

        jLabel6.setText("Cliente:");

        txtCliente.setEnabled(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Data/Hora Chegada"));

        jLabel7.setText("Data:");

        dataChegada.setDate(new Date());

        jLabel8.setText("Hora:");

        txtHoraChegada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataChegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHoraChegada)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataChegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtHoraChegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Data/Hora Término"));

        jLabel9.setText("Data:");

        dataTermino.setDate(new Date());

        txtHoraTermino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));

        jLabel10.setText("Hora:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHoraTermino)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtHoraTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnFinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Ok-icon.png"))); // NOI18N
        btnFinal.setText("Finalizar");
        btnFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/door-in-icon.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnAddLinha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Actions-list-add-icon.png"))); // NOI18N
        btnAddLinha.setText("Adicionar produto");
        btnAddLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLinhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgEditLayout = new javax.swing.GroupLayout(dlgEdit.getContentPane());
        dlgEdit.getContentPane().setLayout(dlgEditLayout);
        dlgEditLayout.setHorizontalGroup(
            dlgEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(dlgEditLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdOs, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                    .addGroup(dlgEditLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                        .addComponent(btnAddLinha))
                    .addGroup(dlgEditLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTecnico, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
                    .addGroup(dlgEditLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnSair)))
                .addContainerGap())
        );

        dlgEditLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel3, jPanel4});

        dlgEditLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnFinal, btnSair});

        dlgEditLayout.setVerticalGroup(
            dlgEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dlgEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(btnAddLinha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dlgEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dlgEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dlgEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSair)
                        .addComponent(btnFinal)))
                .addContainerGap())
        );

        tbOs.setFont(new java.awt.Font("Tahoma", 1, 14));
        tbOs.setModel(new ObjectTableModel(Os.class, "idos,data,idcliente.nome,verificar,solicitado,username.username,dataChegada,dataTermino,status,tecnico"));
        tbOs.getTableHeader().setReorderingAllowed(false);
        tbOs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbOsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbOs);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        cboxTabela.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nº OS", "Cliente", "Operador" }));

        jLabel1.setText("Pesquisar por:");

        btnFind.setText("Pesquisar");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));

        ckSolicitado.setText("Solicitado");

        ckFinalizado.setText("Finalizado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ckSolicitado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(ckFinalizado)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(ckSolicitado)
                .addComponent(ckFinalizado))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cboxTabela, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFind)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(btnFind)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
    int index = cboxTabela.getSelectedIndex();
    String tabela = "";
    String value = txtValue.getText().trim().toUpperCase();
    String status = "";
    String status2 = "";

    if (index == 0) {
        tabela = "idos";
        if (value.equals("")) {
            value = "0";
        }
    }

    if (index == 1) {
        tabela = "cliente";
    }

    if (index == 2) {
        tabela = "operador";
    }

    if (ckSolicitado.isSelected()) {
        status = "solicitado";
    }

    if (ckFinalizado.isSelected()) {
        status2 = "finalizado";
    }

    /*if (!ckSolicitado.isSelected() && !ckFinalizado.isSelected()) {
    status = "%";
    status2 = "%";
    }*/

    List<Os> list = jpaOs.findOs(value, tabela, status, status2);

    if (list.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Chamado técnico não encontrado");
    } else {
        ObjectTableModel<Os> model = (ObjectTableModel<Os>) tbOs.getModel();
        model.clear();
        for (Os os : list) {
            model.add(os);
        }
    }


}//GEN-LAST:event_btnFindActionPerformed

private void tbOsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbOsMouseClicked
    if (evt.getButton() == 3) {

        List<Authorities> list = selectedUsers.getAuthoritiesList();

        for (Authorities a : list) {
            if (a.getAuthority().equals("administrador")) {
                itemEditar.setEnabled(true);
            } 
        }

        popMenu.show(tbOs, evt.getX(), evt.getY());
    }
}//GEN-LAST:event_tbOsMouseClicked

private void itemVisuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVisuActionPerformed
    int row = tbOs.getSelectedRow();
    ObjectTableModel<Os> model = (ObjectTableModel<Os>) tbOs.getModel();
    Os os = model.getValue(row);

    if (os.getStatus().equals("SOLICITADO")) {
        //Gerando Relatorio
        String jasper = "src/br/com/fox/relatorios/os.jasper";
        //String jasper = getClass().getResource("/br/com/fox/relatorios/os.jasper").getFile();
        //String jasper = getClass().getResource("/relatorios/os.jasper").getFile();  
        

        Map parameters = new HashMap();
        parameters.put("IDOS", os.getIdos());
        parameters.put("IMG", "src/br/com/fox/relatorios/logo.png");
        //parameters.put("IMG", "/relatorios/logo.png");

        DBConnectionFactory factory = new DBConnectionFactory();

        Connection conn = factory.getConnection();

        JasperPrint jasperPrint;
        try {
            jasperPrint = JasperFillManager.fillReport(jasper,
                    parameters,
                    conn);
            factory.close();

            JasperViewer jv = new JasperViewer(jasperPrint);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(POs.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        //Gerando Relatorio
        String jasper = "src/br/com/fox/relatorios/os_flz.jasper";
        //String jasper = getClass().getResource("/br/com/fox/relatorios/os_flz.jasper").getFile();
        //String jasper = getClass().getResource("/relatorios/os_flz.jasper").getFile();    

        Map parameters = new HashMap();
        parameters.put("IDOS", os.getIdos());
        parameters.put("IMG", "src/br/com/fox/relatorios/logo.png");
        //parameters.put("IMG", "/relatorios/logo.png");

        DBConnectionFactory factory = new DBConnectionFactory();

        Connection conn = factory.getConnection();

        JasperPrint jasperPrint;
        try {
            jasperPrint = JasperFillManager.fillReport(jasper,
                    parameters,
                    conn);
            factory.close();

            JasperViewer jv = new JasperViewer(jasperPrint);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(POs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}//GEN-LAST:event_itemVisuActionPerformed

private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
    limpaDlgEdit();
    dlgEdit.dispose();
}//GEN-LAST:event_btnSairActionPerformed

private void itemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarActionPerformed
    int row = tbOs.getSelectedRow();
    ObjectTableModel<Os> model = (ObjectTableModel<Os>) tbOs.getModel();
    Os os = model.getValue(row);

    if (os.getStatus().equals("SOLICITADO")) {
        selectedOs = os;
        txtIdOs.setText(String.format("%05d", selectedOs.getIdos()));
        txtCliente.setText(selectedOs.getIdcliente().getNome());
        txtDescricao.setText(selectedOs.getDescricao());

        dlgEdit.pack();
        dlgEdit.setModal(true);
        dlgEdit.setLocationRelativeTo(null);
        dlgEdit.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Esse chamado já foi finalizado");
    }
}//GEN-LAST:event_itemEditarActionPerformed

private void btnAddLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLinhaActionPerformed
    ObjectTableModel<Ipos> model = (ObjectTableModel<Ipos>) tbIp.getModel();
    model.setEditableDefault(true);
    model.add(new Ipos());
}//GEN-LAST:event_btnAddLinhaActionPerformed

private void btnFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalActionPerformed
    SimpleDateFormat fdate = new SimpleDateFormat("dd/MM/yyyy");
    String descricao = txtDescricao.getText();
    String responsavel = txtResponsavel.getText().trim().toUpperCase();
    String tecnico = txtTecnico.getText().trim().toUpperCase();
    Date dChegada = null;
    Date dTermino = null;

    try {
        dChegada = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(fdate.format(dataChegada.getDate()) + " " + txtHoraChegada.getText());
        dTermino = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(fdate.format(dataTermino.getDate()) + " " + txtHoraTermino.getText());
    } catch (ParseException ex) {
        System.out.println(ex.getMessage());
    }

    if (descricao.length() < 5) {
        JOptionPane.showMessageDialog(dlgEdit, "Digite a descrição");
        txtDescricao.requestFocusInWindow();
    } else {
        if (responsavel.length() < 3) {
            JOptionPane.showMessageDialog(dlgEdit, "Digite o responsável");
            txtResponsavel.requestFocusInWindow();
        } else {
            if (tecnico.length() < 3) {
                JOptionPane.showMessageDialog(dlgEdit, "Digite o nome do técnico");
                txtTecnico.requestFocusInWindow();
            } else {
                if (dChegada == null || dTermino == null) {
                    JOptionPane.showMessageDialog(dlgEdit, "Datas inválidas");
                } else {
                    selectedOs.setDescricao(descricao);
                    selectedOs.setResponsavel(responsavel);
                    selectedOs.setTecnico(tecnico);
                    selectedOs.setDataChegada(dChegada);
                    selectedOs.setDataTermino(dTermino);
                    selectedOs.setStatus("FINALIZADO");

                    try {

                        ObjectTableModel<Ipos> model = (ObjectTableModel<Ipos>) tbIp.getModel();
                        if (model.getRowCount() > 0) {
                            List<Ipos> list = model.getData();
                            for (Ipos ipos : list) {
                                ipos.setIdos(selectedOs);
                                jpaIp.create(ipos);
                            }
                        }

                        jpaOs.edit(selectedOs);
                        JOptionPane.showMessageDialog(dlgEdit, "OS atualizado com sucesso");
                        limpaDlgEdit();
                        dlgEdit.dispose();

                        //Gerando Relatorio
                        String jasper = "src/br/com/fox/relatorios/os_flz.jasper";

                        Map parameters = new HashMap();
                        parameters.put("IDOS", selectedOs.getIdos());
                        parameters.put("IMG", "src/br/com/fox/relatorios/logo.png");

                        DBConnectionFactory factory = new DBConnectionFactory();

                        Connection conn = factory.getConnection();

                        JasperPrint jasperPrint;
                        try {
                            jasperPrint = JasperFillManager.fillReport(jasper,
                                    parameters,
                                    conn);
                            factory.close();

                            JasperViewer jv = new JasperViewer(jasperPrint);
                            JasperViewer.viewReport(jasperPrint, false);
                        } catch (JRException ex) {
                            Logger.getLogger(POs.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } catch (NonexistentEntityException ex) {
                        JOptionPane.showMessageDialog(dlgEdit, ex.getMessage());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(dlgEdit, ex.getMessage());
                    }
                }
            }
        }
    }

}//GEN-LAST:event_btnFinalActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddLinha;
    private javax.swing.JButton btnFinal;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox cboxTabela;
    private javax.swing.JCheckBox ckFinalizado;
    private javax.swing.JCheckBox ckSolicitado;
    private com.toedter.calendar.JDateChooser dataChegada;
    private com.toedter.calendar.JDateChooser dataTermino;
    private javax.swing.JDialog dlgEdit;
    private javax.swing.JMenuItem itemEditar;
    private javax.swing.JMenuItem itemVisu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu popMenu;
    private javax.swing.JTable tbIp;
    private javax.swing.JTable tbOs;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JEditorPane txtDescricao;
    private javax.swing.JFormattedTextField txtHoraChegada;
    private javax.swing.JFormattedTextField txtHoraTermino;
    private javax.swing.JTextField txtIdOs;
    private javax.swing.JTextField txtResponsavel;
    private javax.swing.JTextField txtTecnico;
    private javax.swing.JTextField txtValue;
    // End of variables declaration//GEN-END:variables

    private void limpaDlgEdit() {
        txtIdOs.setText("");
        txtCliente.setText("");
        txtDescricao.setText("");
        ObjectTableModel<Ipos> model = (ObjectTableModel<Ipos>) tbIp.getModel();
        model.clear();
        txtResponsavel.setText("");
        txtTecnico.setText("");
        dataChegada.setDate(null);
        txtHoraChegada.setValue(null);
        dataTermino.setDate(null);
        txtHoraTermino.setValue(null);
    }

    public void setSelectedUsers(Users selectedUsers) {
        this.selectedUsers = selectedUsers;
    }
    
}
