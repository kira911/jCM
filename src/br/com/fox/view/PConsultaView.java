package br.com.fox.view;

import br.com.fox.Hibernate.DAO.EventosSensorDAO;
import br.com.fox.controller.AlarmeJpaController;
import br.com.fox.controller.ClienteJpaController;
import br.com.fox.controller.SinalRouterJpaController;
import br.com.fox.db.Alarme;
import br.com.fox.db.Cliente;
import br.com.fox.db.Contato;
import br.com.fox.db.SinalRouter;
import br.com.fox.db.Usuario;
import br.com.fox.db.Zona;
import br.com.fox.util.EventosSensor;
import br.com.fox.util.HibernateUtil;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import com.towel.swing.table.TableFilter;
import java.awt.Component;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Dvr
 */
public class PConsultaView extends javax.swing.JPanel {

    private Cliente selectedCliente = null;
    private ClienteJpaController jpaCliente = new ClienteJpaController();
    private AlarmeJpaController jpaAlarme = new AlarmeJpaController();
    private SinalRouterJpaController jpaRouter = new SinalRouterJpaController();

    public PConsultaView() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboxPesquisarPor = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCentral = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtSenha = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtResp = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbContato = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbZona = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboxTpEvento = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        spnLimit = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        dInicial = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        dFinal = new com.toedter.calendar.JDateChooser();
        btnFiltrar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbEventoSensor = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JEditorPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cboxTpEventoRouter = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        spnLimitRouter = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        dInicialRouter = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        dFinalRouter = new com.toedter.calendar.JDateChooser();
        btnFiltrarRouter = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbEventoRouter = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtLogRouter = new javax.swing.JEditorPane();

        jLabel1.setText("Pesquisar por:");

        cboxPesquisarPor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nº Central", "Razão Social", "Fantasia", "Endereço", "Telefone" }));

        jLabel2.setText("Descrição da consulta:");

        txtDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tbCentral.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tbCentral.setModel(new ObjectTableModel(Cliente.class, "codCli,nome,fantasia,foneLocal,foneLocal2,endereco,bairro,cidade,uf"));
        tbCentral.setIntercellSpacing(new java.awt.Dimension(5, 1));
        tbCentral.setRowHeight(20);
        tbCentral.setSelectionBackground(new java.awt.Color(153, 180, 209));
        tbCentral.getTableHeader().setReorderingAllowed(false);
        tbCentral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCentralMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCentral);

        jLabel11.setText("Pergunta chave:");

        txtSenha.setColumns(20);
        txtSenha.setRows(5);
        jScrollPane9.setViewportView(txtSenha);

        jLabel12.setText("Resposta chave:");

        txtResp.setColumns(20);
        txtResp.setRows(5);
        jScrollPane10.setViewportView(txtResp);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cboxPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                            .addComponent(jLabel11))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
                        .addGap(10, 10, 10)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesquisar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pesquisa de Central", jPanel1);

        tbContato.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tbContato.setModel(new ObjectTableModel(Contato.class, "nome,fone,fone2,prioridade,funcao"));
        tbContato.setRowHeight(20);
        tbContato.setSelectionBackground(new java.awt.Color(153, 180, 209));
        jScrollPane2.setViewportView(tbContato);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane2.addTab("Contatos", jPanel3);

        tbUsuario.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tbUsuario.setModel(new ObjectTableModel(Usuario.class, "nome,cargo,codigo"));
        tbUsuario.setRowHeight(20);
        tbUsuario.setSelectionBackground(new java.awt.Color(153, 180, 209));
        jScrollPane3.setViewportView(tbUsuario);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        jTabbedPane2.addTab("Usuários", jPanel4);

        tbZona.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tbZona.setModel(new ObjectTableModel(Zona.class, "areas,camera,numZona"));
        tbZona.setRowHeight(20);
        tbZona.setSelectionBackground(new java.awt.Color(153, 180, 209));
        jScrollPane4.setViewportView(tbZona);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );

        jTabbedPane2.addTab("Zonas", jPanel5);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        jLabel3.setText("Tipo de evento:");

        cboxTpEvento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Alarme", "Teste Automático", "Armado", "Desarmado", "Sem Controle" }));

        jLabel4.setText("Últimos:");

        spnLimit.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel5.setText("De:");

        dInicial.setDate(new Date());
        dInicial.setEnabled(false);

        jLabel6.setText("Até:");

        dFinal.setDate(new Date());
        dFinal.setEnabled(false);

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboxTpEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(spnLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(dFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFiltrar)
                    .addComponent(dFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxTpEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(26, 26, 26)))
                .addContainerGap())
        );

        tbEventoSensor.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tbEventoSensor.setModel(new ObjectTableModel(Alarme.class, "dataRecebimento,idprotocolo.descricao,receiver,linha,particao,zona,status,username.username,duracao"));
        tbEventoSensor.setRowHeight(20);
        tbEventoSensor.setSelectionBackground(new java.awt.Color(153, 180, 209));
        tbEventoSensor.getTableHeader().setReorderingAllowed(false);
        tbEventoSensor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEventoSensorMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbEventoSensor);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Log"));

        txtLog.setContentType("text/html"); // NOI18N
        txtLog.setEditable(false);
        txtLog.setText("");
        jScrollPane6.setViewportView(txtLog);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane5)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Eventos Sensor", jPanel6);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        jLabel7.setText("Tipo de evento:");

        cboxTpEventoRouter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "VIPER", "TRAVA", "Teste" }));

        jLabel8.setText("Últimos:");

        spnLimitRouter.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel9.setText("De:");

        dInicialRouter.setDate(new Date());
        dInicialRouter.setEnabled(false);

        jLabel10.setText("Até:");

        dFinalRouter.setDate(new Date());
        dFinalRouter.setEnabled(false);

        btnFiltrarRouter.setText("Filtrar");
        btnFiltrarRouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarRouterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboxTpEventoRouter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(spnLimitRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dInicialRouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(dFinalRouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(btnFiltrarRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFiltrarRouter)
                    .addComponent(dFinalRouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dInicialRouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnLimitRouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxTpEventoRouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(26, 26, 26)))
                .addContainerGap())
        );

        tbEventoRouter.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tbEventoRouter.setModel(new ObjectTableModel(SinalRouter.class, "dat,nuc,apl,org,sub,status,username.username,duracao"));
        tbEventoRouter.setRowHeight(20);
        tbEventoRouter.setSelectionBackground(new java.awt.Color(153, 180, 209));
        tbEventoRouter.getTableHeader().setReorderingAllowed(false);
        tbEventoRouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEventoRouterMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbEventoRouter);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Log"));

        txtLogRouter.setContentType("text/html"); // NOI18N
        txtLogRouter.setEditable(false);
        txtLogRouter.setText("");
        jScrollPane8.setViewportView(txtLogRouter);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Eventos Router", jPanel9);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dados da Central", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
    String value = txtDesc.getText().trim().toUpperCase();
    int index = cboxPesquisarPor.getSelectedIndex();

    if (value.length() < 0) {
        JOptionPane.showMessageDialog(null, "Digite a descrição");
        txtDesc.requestFocusInWindow();
    } else {
        String tabela = "";

        if (index == 0) {
            tabela = "codCli";
        }
        
        if (index == 1) {
            tabela = "nome";
        }
        
        if (index == 2) {
            tabela = "fantasia";
        }
        
        if (index == 3) {
            tabela = "endereco";
        }
        
        if (index == 4) {
            tabela = "telefone";
        }

        List<Cliente> list = jpaCliente.findCliente(value, tabela);

        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Central não encontrada");
        } else {
            ObjectTableModel<Cliente> model = (ObjectTableModel<Cliente>) tbCentral.getModel();
            model.clear();
            for (Cliente c : list) {
                model.add(c);
            }
        }
    }
}//GEN-LAST:event_btnPesquisarActionPerformed

private void tbCentralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCentralMouseClicked
    if (evt.getClickCount() == 2) {
        ObjectTableModel<Cliente> tableModelCli = (ObjectTableModel<Cliente>) tbCentral.getModel();
        int row = tbCentral.getSelectedRow();
        selectedCliente = tableModelCli.getValue(row);

        List<Contato> listContato = selectedCliente.getContatoList();
        ObjectTableModel mContato = (ObjectTableModel) tbContato.getModel();
        mContato.clear();

        for (Contato contato : listContato) {
            mContato.add(contato);
        }

        List<Usuario> listUsuario = selectedCliente.getUsuarioList();
        ObjectTableModel mUsuario = (ObjectTableModel) tbUsuario.getModel();
        mUsuario.clear();

        for (Usuario usuario : listUsuario) {
            mUsuario.add(usuario);
        }

        List<Zona> listZona = selectedCliente.getZonaList();
        ObjectTableModel mZona = (ObjectTableModel) tbZona.getModel();
        mZona.clear();

        for (Zona zona : listZona) {
            mZona.add(zona);
        }

        ObjectTableModel model = (ObjectTableModel) tbEventoSensor.getModel();
        model.clear();
        txtLog.setText("");
        
        model = (ObjectTableModel) tbEventoRouter.getModel();
        model.clear();
        txtLogRouter.setText("");

        jTabbedPane1.setSelectedIndex(1);
    }else{
        int row = tbCentral.getSelectedRow();
        ObjectTableModel<Cliente> model = (ObjectTableModel) tbCentral.getModel();
        txtSenha.setText(model.getValue(row).getPergunta());
        txtResp.setText(model.getValue(row).getResposta());
    }
}//GEN-LAST:event_tbCentralMouseClicked

private void createTable(List<EventosSensor> listaEventos) {
    AnnotationResolver resolver = new AnnotationResolver(EventosSensor.class);
    ObjectTableModel<EventosSensor> model = new ObjectTableModel<>(resolver, "alarmeDataRecebimento,protocoloEvento,protocoloDescricao,receiver,linha,particao,idAuxiliar,auxiliar,alarmeStatus,usersUsername,alarmeDuracao,alarmeLog");
    TableFilter filter = new TableFilter(tbEventoSensor.getTableHeader(), model);
    
    for(EventosSensor eventoSensor : listaEventos) {
        model.add(eventoSensor);        
    }
    
    tbEventoSensor.setModel(filter);
}

private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed

    if (selectedCliente != null) {
        String tpEvento = cboxTpEvento.getSelectedItem().toString().toUpperCase();
        Integer limit = (Integer) spnLimit.getValue();
        Date dini = dInicial.getDate();
        Date dfin = dFinal.getDate();

        if (tpEvento.equals("TODOS")) {
            tpEvento = "%";
        }
        
        this.createTable(new EventosSensorDAO(HibernateUtil.getSession()).getListEventosSensor(selectedCliente.getIdcliente(), dini, dfin, limit));

//        List<Alarme> list = jpaAlarme.findAlarme(tpEvento, limit, selectedCliente.getIdcliente());
//        ObjectTableModel model = (ObjectTableModel) tbEventoSensor.getModel();
//        model.clear();
//
//        for (Alarme alarme : list) {
//            model.add(alarme);
//        }
//
//        tbEventoSensor.setDefaultRenderer(Object.class, new ColorTableRenderer());

    } else {
        JOptionPane.showMessageDialog(null, "Nenhuma central selecionada");
        jTabbedPane1.setSelectedIndex(0);
    }

}//GEN-LAST:event_btnFiltrarActionPerformed

private void tbEventoSensorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEventoSensorMouseClicked
//Aqui é o evento de clique da lista de EVENTOS SENSOR que o Felipe disse que não terá ação nenhuma para o clique.
//    int row = tbEventoSensor.getSelectedRow();
//    ObjectTableModel<Alarme> model = (ObjectTableModel) tbEventoSensor.getModel();
//    txtLog.setText(model.getValue(row).getLog());
}//GEN-LAST:event_tbEventoSensorMouseClicked

private void btnFiltrarRouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarRouterActionPerformed
    if (selectedCliente != null) {
        String tpEvento = cboxTpEventoRouter.getSelectedItem().toString().toUpperCase();
        Integer limit = (Integer) spnLimitRouter.getValue();
        Date dini = dInicial.getDate();
        Date dfin = dFinal.getDate();

        if (tpEvento.equals("TODOS")) {
            tpEvento = "%";
        }

        List<SinalRouter> list = jpaRouter.findSinalRouter(tpEvento, limit, selectedCliente.getIdcliente());
        ObjectTableModel model = (ObjectTableModel) tbEventoRouter.getModel();
        model.clear();

        for (SinalRouter sinal : list) {
            model.add(sinal);
        }

        //tbEventoRouter.setDefaultRenderer(Object.class, new ColorTableRenderer());

    } else {
        JOptionPane.showMessageDialog(null, "Nenhuma central selecionada");
        jTabbedPane1.setSelectedIndex(0);
    }
}//GEN-LAST:event_btnFiltrarRouterActionPerformed

private void tbEventoRouterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEventoRouterMouseClicked
    int row = tbEventoRouter.getSelectedRow();
    ObjectTableModel<SinalRouter> model = (ObjectTableModel) tbEventoRouter.getModel();
    txtLogRouter.setText(model.getValue(row).getLog());
}//GEN-LAST:event_tbEventoRouterMouseClicked

private void txtDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescActionPerformed
    btnPesquisarActionPerformed(evt);
}//GEN-LAST:event_txtDescActionPerformed

    private class ColorTableRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            ObjectTableModel<Alarme> tableModel = (ObjectTableModel<Alarme>) table.getModel();

            if (tableModel.getValue(row).getIdprotocolo().getCuc().getPrioridade().equals("BAIXA")) {
                comp.setForeground(new java.awt.Color(0, 0, 204));
            } else {
                if (tableModel.getValue(row).getIdprotocolo().getCuc().getPrioridade().equals("NORMAL")) {
                    comp.setForeground(new java.awt.Color(153, 153, 0));
                } else {
                    if (tableModel.getValue(row).getIdprotocolo().getCuc().getPrioridade().equals("MÉDIA")) {
                        comp.setForeground(new java.awt.Color(0, 153, 0));
                    } else {
                        if (tableModel.getValue(row).getIdprotocolo().getCuc().getPrioridade().equals("ALTA")) {
                            comp.setForeground(new java.awt.Color(204, 0, 0));
                        } else {
                            if (tableModel.getValue(row).getIdprotocolo().getCuc().getPrioridade().equals("CRÍTICA")) {
                                comp.setForeground(new java.awt.Color(0, 0, 0));
                            }
                        }
                    }
                }
            }

            return comp;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnFiltrarRouter;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox cboxPesquisarPor;
    private javax.swing.JComboBox cboxTpEvento;
    private javax.swing.JComboBox cboxTpEventoRouter;
    private com.toedter.calendar.JDateChooser dFinal;
    private com.toedter.calendar.JDateChooser dFinalRouter;
    private com.toedter.calendar.JDateChooser dInicial;
    private com.toedter.calendar.JDateChooser dInicialRouter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JSpinner spnLimit;
    private javax.swing.JSpinner spnLimitRouter;
    private javax.swing.JTable tbCentral;
    private javax.swing.JTable tbContato;
    private javax.swing.JTable tbEventoRouter;
    private javax.swing.JTable tbEventoSensor;
    private javax.swing.JTable tbUsuario;
    private javax.swing.JTable tbZona;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JEditorPane txtLog;
    private javax.swing.JEditorPane txtLogRouter;
    private javax.swing.JTextArea txtResp;
    private javax.swing.JTextArea txtSenha;
    // End of variables declaration//GEN-END:variables
}
