package br.com.fox.view;

import br.com.fox.controller.exceptions.PreexistingEntityException;
import br.com.fox.eventos.CaptureSnapShots;
import br.com.fox.eventos.CoresEventos;
import br.com.fox.eventos.FindEventos;
import br.com.fox.controller.AlarmeJpaController;
import br.com.fox.controller.ClienteJpaController;
import br.com.fox.controller.OsJpaController;
import br.com.fox.controller.ProtocoloJpaController;
import br.com.fox.controller.SinalRouterJpaController;
import br.com.fox.controller.exceptions.NonexistentEntityException;
import br.com.fox.db.Alarme;
import br.com.fox.db.Cliente;
import br.com.fox.db.Contato;
import br.com.fox.db.Horario;
import br.com.fox.db.Os;
import br.com.fox.db.SinalRouter;
import br.com.fox.db.Users;
import br.com.fox.db.Usuario;
import br.com.fox.db.Zona;
import br.com.fox.util.Config;
import br.com.fox.util.DBConnectionFactory;
import br.com.fox.util.FixedLengthDocument;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import com.towel.swing.table.TableFilter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;

/**
 *
 * @author Dvr
 */
public class PMonitoramentoView extends javax.swing.JPanel {

    private Config config = new Config();
    private Users users;
    private Cliente selectedCliente = null;
    private SinalRouter selectedRouter = null;
    private Alarme selectedAlarme = null;
    private ClienteJpaController jpaCliente = new ClienteJpaController();
    private SinalRouterJpaController jpaSinalRouter = new SinalRouterJpaController();
    private AlarmeJpaController jpaAlarme = new AlarmeJpaController();
    private ProtocoloJpaController jpaProtocol = new ProtocoloJpaController();
    private OsJpaController jpaOs = new OsJpaController();
    private CaptureSnapShots snapShots = null;    
    private String ip;

    public PMonitoramentoView() {
        initComponents();
        findSinalRouter();
        mostraListaObs();
        carregaConfig();     
        //carregarTableFilter();
    }
    
    private void carregarTableFilter() {
        ObjectTableModel<Alarme> tableModelAlarme = new ObjectTableModel(
                new AnnotationResolver(Alarme.class), "dataRecebimento,idprotocolo.descricao,status,username.username,duracao");
        TableFilter filterAlarme = new TableFilter(tbEvtSensor.getTableHeader(), tableModelAlarme);
        tbEvtSensor.setModel(filterAlarme);        
        
        ObjectTableModel<SinalRouter> tableModelSR = new ObjectTableModel(
                new AnnotationResolver(SinalRouter.class), "dat,nuc,apl,org,sub,status,username.username,duracao");
        TableFilter filterSR = new TableFilter(tbEvtRouter.getTableHeader(), tableModelSR);
        tbEvtRouter.setModel(filterSR);         
        
        //listNaoAtendidos.setCellRenderer(new CoresEventos());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgX8 = new javax.swing.JDialog();
        txtDesc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboxPesquisarPor = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        tbCentral = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        dlgOs = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        txtDescOs = new javax.swing.JTextField();
        cboxPesquisarPorOs = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        btnPesquisarOs = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        tbCentralOs = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtVerificarOs = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSolicitadoOs = new javax.swing.JTextField();
        btnSolicitarOs = new javax.swing.JButton();
        btnSairOs = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        txtDescricaoOs = new javax.swing.JEditorPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listNaoAtendidos = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        listEspera = new javax.swing.JList();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        lblIdCliente = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblRazaoCliente = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblFantCliente = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbContatos = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbEvtSensor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnFiltroEvtSensor = new javax.swing.JButton();
        spLimiteEvtSensor = new javax.swing.JSpinner();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtLogEvtSensor = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tbEvtRouter = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnFiltroEvtRouter = new javax.swing.JButton();
        spLimiteEvtRouter = new javax.swing.JSpinner();
        jScrollPane11 = new javax.swing.JScrollPane();
        txtLogEvtRouter = new javax.swing.JTextPane();
        pnMapa = new javax.swing.JPanel();
        btnViewMap = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnSalveLog = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JEditorPane();
        jLabel28 = new javax.swing.JLabel();
        lblEndCliente = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtPerguntaCliente = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtRespCliente = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lblFone1 = new javax.swing.JLabel();
        lblFone2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        pnAoVivo = new javax.swing.JPanel();
        pnSnapshots = new javax.swing.JPanel();
        lblSnapshots = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblUsers = new javax.swing.JLabel();
        pnInfo = new javax.swing.JPanel();
        iconViatura = new javax.swing.JLabel();
        iconViatura1 = new javax.swing.JLabel();
        iconOS = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        listObs = new javax.swing.JList();

        dlgX8.setTitle("Gerar alarme manualmente");
        dlgX8.setResizable(false);

        txtDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescActionPerformed(evt);
            }
        });

        jLabel5.setText("Descrição da consulta:");

        cboxPesquisarPor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nº Central", "Razão Social", "Fantasia", "Endereço", "Telefone" }));

        jLabel6.setText("Pesquisar por:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tbCentral.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tbCentral.setModel(new ObjectTableModel(Cliente.class, "codCli,nome,fantasia"));
        tbCentral.setIntercellSpacing(new java.awt.Dimension(5, 1));
        tbCentral.setRowHeight(20);
        tbCentral.setSelectionBackground(new java.awt.Color(153, 180, 209));
        tbCentral.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbCentral.getTableHeader().setReorderingAllowed(false);
        jScrollPane12.setViewportView(tbCentral);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Alarm-Burn-icon.png"))); // NOI18N
        jButton2.setText("Gerar alarme");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/door-in-icon.png"))); // NOI18N
        jButton3.setText("Sair");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgX8Layout = new javax.swing.GroupLayout(dlgX8.getContentPane());
        dlgX8.getContentPane().setLayout(dlgX8Layout);
        dlgX8Layout.setHorizontalGroup(
            dlgX8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgX8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgX8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                    .addGroup(dlgX8Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5))
                    .addGroup(dlgX8Layout.createSequentialGroup()
                        .addComponent(cboxPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar))
                    .addGroup(dlgX8Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        dlgX8Layout.setVerticalGroup(
            dlgX8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgX8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgX8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addGroup(dlgX8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgX8Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cboxPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dlgX8Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(dlgX8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dlgOs.setTitle("Chamado técnico");
        dlgOs.setResizable(false);

        jLabel7.setText("Descrição da consulta:");

        txtDescOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescOsActionPerformed(evt);
            }
        });

        cboxPesquisarPorOs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nº Central", "Razão Social", "Fantasia", "Endereço", "Telefone" }));

        jLabel8.setText("Pesquisar por:");

        btnPesquisarOs.setText("Pesquisar");
        btnPesquisarOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarOsActionPerformed(evt);
            }
        });

        tbCentralOs.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tbCentralOs.setModel(new ObjectTableModel(Cliente.class, "codCli,nome,fantasia"));
        tbCentralOs.setRowHeight(20);
        tbCentralOs.setSelectionBackground(new java.awt.Color(153, 180, 209));
        tbCentralOs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbCentralOs.getTableHeader().setReorderingAllowed(false);
        jScrollPane13.setViewportView(tbCentralOs);

        jLabel9.setText("Verificar:");

        jLabel10.setText("Solicitado por:");

        btnSolicitarOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Occupations-Technical-Support-Representative-Female-Light-icon.png"))); // NOI18N
        btnSolicitarOs.setText("Solicitar chamado");
        btnSolicitarOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarOsActionPerformed(evt);
            }
        });

        btnSairOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/door-in-icon.png"))); // NOI18N
        btnSairOs.setText("Sair");
        btnSairOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairOsActionPerformed(evt);
            }
        });

        txtDescricaoOs.setDocument(new FixedLengthDocument(300));
        txtDescricaoOs.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));
        jScrollPane14.setViewportView(txtDescricaoOs);

        javax.swing.GroupLayout dlgOsLayout = new javax.swing.GroupLayout(dlgOs.getContentPane());
        dlgOs.getContentPane().setLayout(dlgOsLayout);
        dlgOsLayout.setHorizontalGroup(
            dlgOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgOsLayout.createSequentialGroup()
                .addGroup(dlgOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgOsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dlgOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dlgOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVerificarOs, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                            .addComponent(txtSolicitadoOs, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)))
                    .addGroup(dlgOsLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cboxPesquisarPorOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDescOs, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisarOs))
                    .addGroup(dlgOsLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel7))
                    .addGroup(dlgOsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSolicitarOs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addComponent(btnSairOs))
                    .addGroup(dlgOsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgOsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dlgOsLayout.setVerticalGroup(
            dlgOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgOsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(6, 6, 6)
                .addGroup(dlgOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgOsLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cboxPesquisarPorOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dlgOsLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtDescOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPesquisarOs))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dlgOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtVerificarOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dlgOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSolicitadoOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(dlgOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSolicitarOs)
                    .addComponent(btnSairOs))
                .addContainerGap())
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1252, 693));

        listNaoAtendidos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Não Atendidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.blue));
        listNaoAtendidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listNaoAtendidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listNaoAtendidos.setSelectionBackground(new java.awt.Color(153, 180, 209));
        listNaoAtendidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listNaoAtendidosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listNaoAtendidos);

        listEspera.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Em Espera", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.blue));
        listEspera.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listEspera.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listEspera.setSelectionBackground(new java.awt.Color(153, 180, 209));
        listEspera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listEsperaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listEspera);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 153, 0));
        jLabel21.setText("Fantasia:");

        lblIdCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 153, 0));
        jLabel23.setText("Central:");

        lblRazaoCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 153, 0));
        jLabel25.setText("Endereço:");

        lblFantCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 153, 0));
        jLabel27.setText("Razão Social:");

        jTabbedPane3.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        tbContatos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbContatos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbContatos.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tbContatos);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Contatos", jPanel10);

        tbUsuarios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbUsuarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tbUsuarios);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Usuários", jPanel11);

        tbEvtSensor.setModel(new ObjectTableModel(Alarme.class, "dataRecebimento,idprotocolo.descricao,status,username.username,duracao"));
        tbEvtSensor.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbEvtSensor.getTableHeader().setReorderingAllowed(false);
        tbEvtSensor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEvtSensorMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbEvtSensor);

        jLabel1.setText("Mostrar últimos:");

        jLabel2.setText("registro(s)");

        btnFiltroEvtSensor.setText("Filtrar");
        btnFiltroEvtSensor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroEvtSensorActionPerformed(evt);
            }
        });

        spLimiteEvtSensor.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        txtLogEvtSensor.setBorder(javax.swing.BorderFactory.createTitledBorder("Log"));
        txtLogEvtSensor.setContentType("text/html");
        txtLogEvtSensor.setEditable(false);
        txtLogEvtSensor.setText("<html>\r\n  <head>\r\n\r\n  </head>\r\n  <body>\r\n    <p style=\"margin-top: 0\">\r\n\n    </p>\r\n  </body>\r\n</html>\r\n");
        jScrollPane9.setViewportView(txtLogEvtSensor);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spLimiteEvtSensor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addComponent(btnFiltroEvtSensor)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spLimiteEvtSensor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnFiltroEvtSensor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Evt. Sensor", jPanel2);

        tbEvtRouter.setModel(new ObjectTableModel(SinalRouter.class, "dat,nuc,apl,org,sub,status,username.username,duracao"));
        tbEvtRouter.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbEvtRouter.getTableHeader().setReorderingAllowed(false);
        tbEvtRouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEvtRouterMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tbEvtRouter);

        jLabel3.setText("Mostrar últimos:");

        jLabel4.setText("registro(s)");

        btnFiltroEvtRouter.setText("Filtrar");
        btnFiltroEvtRouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroEvtRouterActionPerformed(evt);
            }
        });

        spLimiteEvtRouter.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        txtLogEvtRouter.setBorder(javax.swing.BorderFactory.createTitledBorder("Log"));
        txtLogEvtRouter.setContentType("text/html");
        txtLogEvtRouter.setEditable(false);
        txtLogEvtRouter.setText("<html>\r\n  <head>\r\n\r\n  </head>\r\n  <body>\r\n    <p style=\"margin-top: 0\">\r\n\n    </p>\r\n  </body>\r\n</html>\r\n");
        jScrollPane11.setViewportView(txtLogEvtRouter);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spLimiteEvtRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addComponent(btnFiltroEvtRouter)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spLimiteEvtRouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnFiltroEvtRouter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Evt. Router", jPanel3);

        btnViewMap.setText("Visualizar mapa");
        btnViewMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewMapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnMapaLayout = new javax.swing.GroupLayout(pnMapa);
        pnMapa.setLayout(pnMapaLayout);
        pnMapaLayout.setHorizontalGroup(
            pnMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMapaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnViewMap)
                .addContainerGap(337, Short.MAX_VALUE))
        );
        pnMapaLayout.setVerticalGroup(
            pnMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMapaLayout.createSequentialGroup()
                .addContainerGap(227, Short.MAX_VALUE)
                .addComponent(btnViewMap)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Mapa", pnMapa);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnSalveLog.setText("Salvar LOG");
        btnSalveLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalveLogActionPerformed(evt);
            }
        });

        jScrollPane15.setViewportView(txtLog);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalveLog)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnSalveLog))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Log", jPanel13);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 153, 0));
        jLabel28.setText("Contra Senha (Resposta)");

        lblEndCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEndCliente.setToolTipText("");

        txtPerguntaCliente.setColumns(20);
        txtPerguntaCliente.setEditable(false);
        txtPerguntaCliente.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtPerguntaCliente.setLineWrap(true);
        txtPerguntaCliente.setRows(5);
        jScrollPane8.setViewportView(txtPerguntaCliente);

        txtRespCliente.setColumns(20);
        txtRespCliente.setEditable(false);
        txtRespCliente.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtRespCliente.setLineWrap(true);
        txtRespCliente.setRows(5);
        jScrollPane7.setViewportView(txtRespCliente);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 153, 0));
        jLabel30.setText("Senha (Pergunta):");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 153, 0));
        jLabel29.setText("Telefone:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 153, 0));
        jLabel31.setText("Telefone 2:");

        lblFone1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFone1.setText("(00) 0000-0000");

        lblFone2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFone2.setText("(00) 0000-0000");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblIdCliente))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblFantCliente))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel27)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblRazaoCliente))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblEndCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblFone1)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblFone2)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lblIdCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lblFantCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lblRazaoCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lblEndCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel31)
                    .addComponent(lblFone1)
                    .addComponent(lblFone2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, 0, 55, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, 0, 55, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3))
        );

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        pnAoVivo.setBackground(new java.awt.Color(0, 0, 0));
        pnAoVivo.setPreferredSize(new java.awt.Dimension(320, 240));

        javax.swing.GroupLayout pnAoVivoLayout = new javax.swing.GroupLayout(pnAoVivo);
        pnAoVivo.setLayout(pnAoVivoLayout);
        pnAoVivoLayout.setHorizontalGroup(
            pnAoVivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );
        pnAoVivoLayout.setVerticalGroup(
            pnAoVivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        pnSnapshots.setBackground(new java.awt.Color(0, 0, 0));
        pnSnapshots.setPreferredSize(new java.awt.Dimension(320, 240));

        lblSnapshots.setFocusable(false);
        lblSnapshots.setPreferredSize(new java.awt.Dimension(320, 240));

        javax.swing.GroupLayout pnSnapshotsLayout = new javax.swing.GroupLayout(pnSnapshots);
        pnSnapshots.setLayout(pnSnapshotsLayout);
        pnSnapshotsLayout.setHorizontalGroup(
            pnSnapshotsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSnapshotsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSnapshots, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnSnapshotsLayout.setVerticalGroup(
            pnSnapshotsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSnapshotsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSnapshots, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnAoVivo, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                    .addComponent(pnSnapshots, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnAoVivo, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnSnapshots, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("Visualizar Câmeras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblUsers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsers.setText("Usuário:");

        pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alarme Câmera", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 24), java.awt.Color.red)); // NOI18N

        javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
        pnInfo.setLayout(pnInfoLayout);
        pnInfoLayout.setHorizontalGroup(
            pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 778, Short.MAX_VALUE)
        );
        pnInfoLayout.setVerticalGroup(
            pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        iconViatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Police-Car-icon.png"))); // NOI18N
        iconViatura.setEnabled(false);

        iconViatura1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Alarm-Burn-icon.png"))); // NOI18N
        iconViatura1.setToolTipText("Gerar alarme manualmente");
        iconViatura1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconViatura1MouseClicked(evt);
            }
        });

        iconOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Occupations-Technical-Support-Representative-Female-Light-icon.png"))); // NOI18N
        iconOS.setToolTipText("Chamado técnico");
        iconOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconOSMouseClicked(evt);
            }
        });

        listObs.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.blue));
        listObs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listObs.setSelectionBackground(new java.awt.Color(153, 180, 209));
        listObs.setSelectionForeground(new java.awt.Color(51, 51, 51));
        listObs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listObsMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(listObs);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, 0, 213, Short.MAX_VALUE)
                            .addComponent(lblUsers, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(iconViatura)
                                .addGap(18, 18, 18)
                                .addComponent(iconViatura1)
                                .addGap(18, 18, 18)
                                .addComponent(iconOS))
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(pnInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(iconViatura1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(iconViatura, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblUsers, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(iconOS, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jButton1))
                .addGap(11, 11, 11))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1257, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

private void listNaoAtendidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listNaoAtendidosMouseClicked
    if (evt.getClickCount() == 1) {
        //listNaoAtendidos.setEnabled(true);
        Object value = listNaoAtendidos.getSelectedValue();

        //ObjectTableModel model = (ObjectTableModel) tbEvtRouter.getModel();
        //model.clear();

        //model = (ObjectTableModel) tbEvtSensor.getModel();
        //model.clear();
        
        if (value != null) {
        
            //carregarTableFilter();

            if (value instanceof SinalRouter) {
                SinalRouter router = (SinalRouter) value;
                selectedAlarme = null;

                if (jpaSinalRouter.findSinalRouter(router.getIdsinalRouter()).getStatus().equals("EM ESPERA")) {
                    JOptionPane.showMessageDialog(this, "Este alarme já esta sendo tratado", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    router.setDataEspera(new Date());
                    router.setStatus("EM ESPERA");
                    router.setUsername(users);
                    txtLog.setText(router.getLog());

                    try {
                        selectedRouter = router;
                        selectedCliente = router.getCodCli();

                        painelInfo();           
                        
                        ((DefaultListModel) listNaoAtendidos.getModel()).removeElement(router);
                        ((DefaultListModel) listEspera.getModel()).addElement(router);                        
                                                
                        //Atualizando sinal router
                        jpaSinalRouter.edit(router);

//                        try {
//                            ip = router.getIps();
//
//                            Component[] comps = pnAoVivo.getComponents();
//
//                            for (int i = 0; i < comps.length; i++) {
//                                if (comps[i] instanceof EmbeddedMediaPlayerComponent) {
//                                    EmbeddedMediaPlayerComponent component = (EmbeddedMediaPlayerComponent) comps[i];
//                                    pnAoVivo.remove(component);
//                                    component.release();
//                                }
//                            }
//
//                            EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
//                            mediaPlayerComponent.setSize(pnAoVivo.getSize());
//
//                            pnAoVivo.add(mediaPlayerComponent);
//
//                            mediaPlayerComponent.getMediaPlayer().playMedia("HTTP://" + ip + ":" + router.getPos() + "/IPLLREDIR:" + router.getNuc());
//
//                            if (snapShots == null) {
//                                snapShots = new CaptureSnapShots(lblSnapshots, router, selectedCliente, config);
//                                Thread t = new Thread(snapShots);
//                                t.start();
//                            } else {
//                                snapShots.setStopThread(false);
//                                snapShots = new CaptureSnapShots(lblSnapshots, router, selectedCliente, config);
//                                Thread t = new Thread(snapShots);
//                                t.start();
//                            }
//
//
//                        } catch (Exception ex) {
//                            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
//                            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
//                        }
//
//                        ((DefaultListModel) listNaoAtendidos.getModel()).removeElement(router);
//                        ((DefaultListModel) listEspera.getModel()).addElement(router);
//
//                        listaEmEspera();

                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoResultException e) {
                        JOptionPane.showMessageDialog(this, "Cliente não cadastrado", "Aviso", JOptionPane.WARNING_MESSAGE);
                    } catch (Exception ex) {
                        Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                Alarme alarme = (Alarme) value;
                selectedRouter = null;


                //if (jpaAlarme.findAlarme(alarme.getIdalarme()).getStatus().equals("EM ESPERA")) {
                //    JOptionPane.showMessageDialog(this, "Este alarme já esta sendo tratado", "Aviso", JOptionPane.WARNING_MESSAGE);
                //} else {
                    alarme.setDataEspera(new Date());
                    alarme.setStatus("EM ESPERA");
                    alarme.setUsername(users);
                    txtLog.setText(alarme.getLog());

                    try {
                        
                        selectedAlarme = alarme;
                        selectedCliente = alarme.getIdcliente();

                        painelInfo();                        
                        
                        ((DefaultListModel) listNaoAtendidos.getModel()).removeElement(alarme);
                        ((DefaultListModel) listEspera.getModel()).addElement(alarme);                        
                        
                        jpaAlarme.edit(alarme);                                                                 

                        //listaEmEspera();

                        //=========================================================
//                        Component[] comps = pnAoVivo.getComponents();
//
//                        for (int i = 0; i < comps.length; i++) {
//                            if (comps[i] instanceof EmbeddedMediaPlayerComponent) {
//                                EmbeddedMediaPlayerComponent component = (EmbeddedMediaPlayerComponent) comps[i];
//                                pnAoVivo.remove(component);
//                                component.release();
//                            }
//                        }
//
//                        if (snapShots != null) {
//                            snapShots.setStopThread(false);
//                            lblSnapshots.setIcon(null);
//                        }

                        //=========================================================

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                //}

            }

//            if (selectedCliente != null) {
//
//                lblIdCliente.setText(String.valueOf(selectedCliente.getCodCli()));
//                lblFantCliente.setText(selectedCliente.getFantasia());
//                lblRazaoCliente.setText(selectedCliente.getNome());
//                lblEndCliente.setText(selectedCliente.getEndereco() + " - " + selectedCliente.getBairro() + " - " + selectedCliente.getCidade() + " - " + selectedCliente.getUf());
//                lblEndCliente.setToolTipText(lblEndCliente.getText());
//                lblFone1.setText(selectedCliente.getFoneLocal());
//                lblFone2.setText(selectedCliente.getFoneLocal2());
//                txtPerguntaCliente.setText(selectedCliente.getPergunta());
//                txtRespCliente.setText(selectedCliente.getResposta());
//
//                Boolean isViatura = Boolean.valueOf(selectedCliente.getViatura());
//
//                iconViatura.setEnabled(isViatura);
//
//                List<Contato> listContato = selectedCliente.getContatoList();
//
//                AnnotationResolver resolverContato = new AnnotationResolver(Contato.class);
//                ObjectTableModel<Contato> tableModelContato = new ObjectTableModel<Contato>(
//                        resolverContato, "prioridade,nome,fone,fone2,funcao");
//
//                tableModelContato.setData(listContato);
//                tableModelContato.setEditableDefault(false);
//                tbContatos.setModel(tableModelContato);
//                //TableFilter filterContato = new TableFilter(tbContatos.getTableHeader(), tableModelContato);
//                //tbContatos.setModel(filterContato);
//
//                int lrgNome = 0;
//                int lrgFunc = 0;
//
//                for (Contato contato : tableModelContato) {
//
//                    if (contato.getNome().length() > lrgNome) {
//                        lrgNome = contato.getNome().length();
//                        tbContatos.getColumnModel().getColumn(1).setPreferredWidth(lrgNome * 7);
//                    }
//
//                    if (contato.getFuncao().length() > lrgFunc) {
//                        lrgFunc = contato.getFuncao().length();
//                        tbContatos.getColumnModel().getColumn(4).setPreferredWidth(lrgFunc * 7);
//                    }
//
//                }
//                tbContatos.getColumnModel().getColumn(2).setPreferredWidth(98);
//                tbContatos.getColumnModel().getColumn(3).setPreferredWidth(98);
//
//                List<Usuario> listUsuario = selectedCliente.getUsuarioList();
//
//                AnnotationResolver resolverUsuario = new AnnotationResolver(Usuario.class);
//                ObjectTableModel<Usuario> tableModelUsuario = new ObjectTableModel<Usuario>(
//                        resolverUsuario, "nome,cargo,codigo");
//
//                tableModelUsuario.setData(listUsuario);
//                tableModelUsuario.setEditableDefault(false);
//                tbUsuarios.setModel(tableModelUsuario);
//                //TableFilter filterUsuario = new TableFilter(tbUsuarios.getTableHeader(), tableModelUsuario);
//                //tbUsuarios.setModel(filterUsuario);
//
//                jTabbedPane3.setSelectedIndex(5);
//
//                if (selectedAlarme != null) {
//                    if (selectedAlarme.getIdprotocolo().getCuc().getPrioridade().equals("ALTA") || selectedAlarme.getIdprotocolo().getCuc().getPrioridade().equals("CRÍTICA")) {
//                        jTabbedPane3.setSelectedIndex(0);
//                    }
//                } else {
//                    if (selectedRouter.getOrg().equals("VIPER")) {
//                        jTabbedPane3.setSelectedIndex(0);
//                    }
//                }
//            }
        }
    }
}//GEN-LAST:event_listNaoAtendidosMouseClicked

private void listEsperaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listEsperaMouseClicked

    listEspera.setSelectionBackground(new Color(153, 180, 209));
    List<Object> list = listObs.getSelectedValuesList();
    for (Object object : list) {
        listObs.setSelectionBackground(Color.WHITE);
    }

    if (evt.getButton() == 3) {
        //Colocando em observação
        Object value = listEspera.getSelectedValue();

        if (value instanceof SinalRouter) {
            selectedAlarme = null;
            selectedRouter = (SinalRouter) value;
            selectedRouter.setStatus("OBSERVAÇÃO");
            try {
                jpaSinalRouter.edit(selectedRouter);
                limpaTela();
                selectedRouter = null;
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(PMonitoramentoView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(PMonitoramentoView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            selectedRouter = null;
            selectedAlarme = (Alarme) value;
            selectedAlarme.setStatus("OBSERVAÇÃO");
            try {
                jpaAlarme.edit(selectedAlarme);
                limpaTela();
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(PMonitoramentoView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(PMonitoramentoView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    } else {
        Object value = listEspera.getSelectedValue();

        ObjectTableModel model = (ObjectTableModel) tbEvtRouter.getModel();
        model.clear();

        model = (ObjectTableModel) tbEvtSensor.getModel();
        model.clear();
        
        //carregarTableFilter();

        if (value instanceof SinalRouter) {
            selectedRouter = (SinalRouter) value;
            if( selectedRouter.getLog() != null )
                txtLog.setText(selectedRouter.getLog());
            selectedAlarme = null;


            try {
                selectedCliente = selectedRouter.getCodCli();

                painelInfo();

                try {
                    ip = selectedRouter.getIps();

                    Component[] comps = pnAoVivo.getComponents();

                    for (int i = 0; i < comps.length; i++) {
                        if (comps[i] instanceof EmbeddedMediaPlayerComponent) {
                            EmbeddedMediaPlayerComponent component = (EmbeddedMediaPlayerComponent) comps[i];
                            pnAoVivo.remove(component);
                            component.release();
                        }
                    }

                    EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
                    mediaPlayerComponent.setSize(pnAoVivo.getSize());

                    pnAoVivo.add(mediaPlayerComponent);

                    mediaPlayerComponent.getMediaPlayer().playMedia("HTTP://" + ip + ":" + selectedRouter.getPos() + "/IPLLREDIR:" + selectedRouter.getNuc());

                    if (snapShots == null) {
                        snapShots = new CaptureSnapShots(lblSnapshots, selectedRouter, selectedCliente, config);
                        Thread t = new Thread(snapShots);
                        t.start();
                    } else {
                        snapShots.setStopThread(false);
                        snapShots = new CaptureSnapShots(lblSnapshots, selectedRouter, selectedCliente, config);
                        Thread t = new Thread(snapShots);
                        t.start();
                    }


                } catch (Exception ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }

                //=======================================================

            } catch (NoResultException e) {
                JOptionPane.showMessageDialog(this, "Cliente não cadastrado", "Aviso", JOptionPane.WARNING_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alarme alarme = (Alarme) value;
            selectedRouter = null;

            selectedAlarme = alarme;
            if( selectedAlarme.getLog() != null )
                txtLog.setText(selectedAlarme.getLog());    
            selectedCliente = alarme.getIdcliente();

            painelInfo();

            //=========================================================
            Component[] comps = pnAoVivo.getComponents();

            for (int i = 0; i < comps.length; i++) {
                if (comps[i] instanceof EmbeddedMediaPlayerComponent) {
                    EmbeddedMediaPlayerComponent component = (EmbeddedMediaPlayerComponent) comps[i];
                    pnAoVivo.remove(component);
                    component.release();
                }
            }

            if (snapShots != null) {
                snapShots.setStopThread(false);
                lblSnapshots.setIcon(null);
            }
            //=========================================================
        }

        if (selectedCliente != null) {

            lblIdCliente.setText(String.valueOf(selectedCliente.getCodCli()));
            lblFantCliente.setText(selectedCliente.getFantasia());
            lblRazaoCliente.setText(selectedCliente.getNome());
            lblEndCliente.setText(selectedCliente.getEndereco() + " - " + selectedCliente.getBairro() + " - " + selectedCliente.getCidade() + " - " + selectedCliente.getUf());
            lblEndCliente.setToolTipText(lblEndCliente.getText());
            lblFone1.setText(selectedCliente.getFoneLocal());
            lblFone2.setText(selectedCliente.getFoneLocal2());
            txtPerguntaCliente.setText(selectedCliente.getPergunta());
            txtRespCliente.setText(selectedCliente.getResposta());

            Boolean isViatura = Boolean.valueOf(selectedCliente.getViatura());

            iconViatura.setEnabled(isViatura);

            List<Contato> listContato = selectedCliente.getContatoList();

            AnnotationResolver resolverContato = new AnnotationResolver(Contato.class);
            ObjectTableModel<Contato> tableModelContato = new ObjectTableModel<Contato>(
                    resolverContato, "prioridade,nome,fone,fone2,funcao");

            tableModelContato.setData(listContato);
            tableModelContato.setEditableDefault(false);
            tbContatos.setModel(tableModelContato);
            //TableFilter filterContato = new TableFilter(tbContatos.getTableHeader(), tableModelContato);
            //tbContatos.setModel(filterContato);

            int lrgNome = 0;
            int lrgFunc = 0;

            for (Contato contato : tableModelContato) {

                if (contato.getNome().length() > lrgNome) {
                    lrgNome = contato.getNome().length();
                    tbContatos.getColumnModel().getColumn(1).setPreferredWidth(lrgNome * 7);
                }

                if (contato.getFuncao().length() > lrgFunc) {
                    lrgFunc = contato.getFuncao().length();
                    tbContatos.getColumnModel().getColumn(4).setPreferredWidth(lrgFunc * 7);
                }

            }
            tbContatos.getColumnModel().getColumn(2).setPreferredWidth(98);
            tbContatos.getColumnModel().getColumn(3).setPreferredWidth(98);


            List<Usuario> listUsuario = selectedCliente.getUsuarioList();

            AnnotationResolver resolverUsuario = new AnnotationResolver(Usuario.class);
            ObjectTableModel<Usuario> tableModelUsuario = new ObjectTableModel<Usuario>(
                    resolverUsuario, "nome,cargo,codigo");

            tableModelUsuario.setData(listUsuario);
            tableModelUsuario.setEditableDefault(false);
            tbUsuarios.setModel(tableModelUsuario);
            //TableFilter filterUsuario = new TableFilter(tbUsuarios.getTableHeader(), tableModelUsuario);
            //tbUsuarios.setModel(filterUsuario);

            jTabbedPane3.setSelectedIndex(5);

            if (selectedAlarme != null) {
                if (selectedAlarme.getIdprotocolo().getCuc().getPrioridade().equals("ALTA") || selectedAlarme.getIdprotocolo().getCuc().getPrioridade().equals("CRÍTICA")) {
                    jTabbedPane3.setSelectedIndex(0);
                }
            } else {
                if (selectedRouter.getOrg().equals("VIPER")) {
                    jTabbedPane3.setSelectedIndex(0);
                }
            }
        }
    }

}//GEN-LAST:event_listEsperaMouseClicked

private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

    int r = JOptionPane.showConfirmDialog(this, "Deseja registrar este alarme?");

    if (r == 0) {
        String log = txtLog.getText().trim();

        if (selectedRouter != null) {
            if (log.length() < 5) {
                JOptionPane.showMessageDialog(this, "Digite o log");
                txtLog.requestFocusInWindow();
            } else {
                selectedRouter.setDataEncerramento(new Date());
                selectedRouter.setStatus("ATENDIDO");
                selectedRouter.setLog(log);

                //calculando duração
                DateTime start = new DateTime(selectedRouter.getDat());
                DateTime end = new DateTime(new Date());

                Duration duration = new Duration(start, end);

                String days = String.format("%3d", duration.getStandardDays() % 365);
                String hours = String.format("%02d", duration.getStandardHours() % 24);
                String minutes = String.format("%02d", duration.getStandardMinutes() % 60);
                String seconds = String.format("%02d", duration.getStandardSeconds() % 60);

                StringBuilder tempo = new StringBuilder();
                tempo.append(days).append("d ").append(hours).append(":").append(minutes).append(":").append(seconds);

                selectedRouter.setDuracao(tempo.toString().trim());
                //fim do calculo

                try {
                    jpaSinalRouter.edit(selectedRouter);
                    JOptionPane.showMessageDialog(this, "Alarme registrado com sucesso");
                    limpaTela();
                } catch (NonexistentEntityException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            if (selectedAlarme != null) {
                if (log.length() < 5) {
                    JOptionPane.showMessageDialog(this, "Digite o log");
                    txtLog.requestFocusInWindow();
                } else {
                    selectedAlarme.setDataEncerramento(new Date());
                    selectedAlarme.setStatus("ATENDIDO");
                    selectedAlarme.setLog(log);

                    //calculando duração
                    DateTime start = new DateTime(selectedAlarme.getDataRecebimento());
                    DateTime end = new DateTime(new Date());

                    Duration duration = new Duration(start, end);

                    String days = String.format("%3d", duration.getStandardDays() % 365);
                    String hours = String.format("%02d", duration.getStandardHours() % 24);
                    String minutes = String.format("%02d", duration.getStandardMinutes() % 60);
                    String seconds = String.format("%02d", duration.getStandardSeconds() % 60);

                    StringBuilder tempo = new StringBuilder();
                    tempo.append(days).append("d ").append(hours).append(":").append(minutes).append(":").append(seconds);

                    selectedAlarme.setDuracao(tempo.toString().trim());
                    //fim do calculo

                    try {
                        jpaAlarme.edit(selectedAlarme);
                        JOptionPane.showMessageDialog(this, "Alarme registrado com sucesso");
                        limpaTela();
                    } catch (NonexistentEntityException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum alarme selecionado");
            }
        }
    }

}//GEN-LAST:event_btnRegistrarActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
        // Obs: como está só funciona se for um sinal router (porta 9540 ou GPRS)
        BufferedWriter br = new BufferedWriter(new FileWriter(new File("jCameraView.bat")));

        br.write("cd C:\\jCameraView");
        br.newLine();
        br.write("java -jar jCameraView.jar " + ip + " " + selectedCliente.getIdcliente() + " " + selectedRouter.getIdsinalRouter());
        br.close();
        

        String comando = "jCameraView.bat";
        Process processo = Runtime.getRuntime().exec(comando);
    } catch (IOException ex) {
        Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_jButton1ActionPerformed

private void btnFiltroEvtSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroEvtSensorActionPerformed
    if (selectedCliente != null) {
        String tpEvento = "TODOS";
        Integer limit = (Integer) spLimiteEvtSensor.getValue();

        if (tpEvento.equals("TODOS")) {
            tpEvento = "%";
        }

        List<Alarme> list = jpaAlarme.findAlarme(tpEvento, limit, selectedCliente.getIdcliente());
        ObjectTableModel model = (ObjectTableModel) tbEvtSensor.getModel();
        model.clear();

        for (Alarme alarme : list) {
            model.add(alarme);
        }

    } else {
        JOptionPane.showMessageDialog(this, "Nenhuma alarme selecionado");
    }
}//GEN-LAST:event_btnFiltroEvtSensorActionPerformed

private void tbEvtSensorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEvtSensorMouseClicked
    int row = tbEvtSensor.getSelectedRow();
    ObjectTableModel<Alarme> model = (ObjectTableModel) tbEvtSensor.getModel();
    txtLogEvtSensor.setText(model.getValue(row).getLog());
}//GEN-LAST:event_tbEvtSensorMouseClicked

private void tbEvtRouterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEvtRouterMouseClicked
    int row = tbEvtRouter.getSelectedRow();
    ObjectTableModel<SinalRouter> model = (ObjectTableModel) tbEvtRouter.getModel();
    txtLogEvtRouter.setText(model.getValue(row).getLog());
}//GEN-LAST:event_tbEvtRouterMouseClicked

private void btnFiltroEvtRouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroEvtRouterActionPerformed
    if (selectedCliente != null) {
        String tpEvento = "TODOS";
        Integer limit = (Integer) spLimiteEvtRouter.getValue();

        if (tpEvento.equals("TODOS")) {
            tpEvento = "%";
        }

        List<SinalRouter> list = jpaSinalRouter.findSinalRouter(tpEvento, limit, selectedCliente.getIdcliente());
        ObjectTableModel model = (ObjectTableModel) tbEvtRouter.getModel();
        model.clear();

        for (SinalRouter sinal : list) {
            model.add(sinal);
        }

    } else {
        JOptionPane.showMessageDialog(this, "Nenhum alarme selecionado");
    }
}//GEN-LAST:event_btnFiltroEvtRouterActionPerformed

private void btnSalveLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalveLogActionPerformed
    String log = txtLog.getText().trim();

    if (selectedRouter != null) {

        selectedRouter.setLog(log);

        try {
            jpaSinalRouter.edit(selectedRouter);
            JOptionPane.showMessageDialog(this, "LOG salvo com sucesso");
            listaEmEspera();
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
        }

    } else {
        if (selectedAlarme != null) {

            selectedAlarme.setLog(log);

            try {
                jpaAlarme.edit(selectedAlarme);
                JOptionPane.showMessageDialog(this, "LOG salvo com sucesso");
                listaObservacao();
            } catch (NonexistentEntityException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Nenhum alarme selecionado");
        }
    }

}//GEN-LAST:event_btnSalveLogActionPerformed

private void iconViatura1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconViatura1MouseClicked
    dlgX8.pack();
    dlgX8.setModal(true);
    dlgX8.setLocationRelativeTo(null);
    dlgX8.setVisible(true);
}//GEN-LAST:event_iconViatura1MouseClicked

private void txtDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescActionPerformed
    btnPesquisarActionPerformed(evt);
}//GEN-LAST:event_txtDescActionPerformed

private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
    String value = txtDesc.getText().trim().toUpperCase();
    int index = cboxPesquisarPor.getSelectedIndex();

    if (value.length() < 0) {
        JOptionPane.showMessageDialog(this, "Digite a descrição");
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
            JOptionPane.showMessageDialog(this, "Central não encontrada");
        } else {
            ObjectTableModel<Cliente> model = (ObjectTableModel<Cliente>) tbCentral.getModel();
            model.clear();
            for (Cliente c : list) {
                model.add(c);
            }
        }
    }
}//GEN-LAST:event_btnPesquisarActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    dlgX8.dispose();
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    int row = tbCentral.getSelectedRow();

    ObjectTableModel<Cliente> model = (ObjectTableModel<Cliente>) tbCentral.getModel();
    Cliente c = model.getValue(row);

    Alarme alarme = new Alarme();
    alarme.setDataRecebimento(new Date());
    alarme.setReceiver(0);
    alarme.setLinha(0);
    alarme.setIdcliente(c);
    alarme.setIdprotocolo(jpaProtocol.findProtocolo(242));
    alarme.setParticao(0);
    alarme.setStatus("NÃO ATENDIDO");
    alarme.setZona(0);
    alarme.setLog("");

    jpaAlarme.create(alarme);

    JOptionPane.showMessageDialog(this, "Alarme gerado com sucesso");
    dlgX8.dispose();
}//GEN-LAST:event_jButton2ActionPerformed

private void iconOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconOSMouseClicked
    dlgOs.pack();
    dlgOs.setModal(true);
    dlgOs.setLocationRelativeTo(null);
    dlgOs.setVisible(true);
}//GEN-LAST:event_iconOSMouseClicked

private void txtDescOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescOsActionPerformed
    btnPesquisarOsActionPerformed(evt);
}//GEN-LAST:event_txtDescOsActionPerformed

private void btnPesquisarOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarOsActionPerformed
    String value = txtDescOs.getText().trim().toUpperCase();
    int index = cboxPesquisarPorOs.getSelectedIndex();

    if (value.length() < 0) {
        JOptionPane.showMessageDialog(this, "Digite a descrição");
        txtDescOs.requestFocusInWindow();
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
            JOptionPane.showMessageDialog(this, "Central não encontrada");
        } else {
            ObjectTableModel<Cliente> model = (ObjectTableModel<Cliente>) tbCentralOs.getModel();
            model.clear();
            for (Cliente c : list) {
                model.add(c);
            }
        }
    }
}//GEN-LAST:event_btnPesquisarOsActionPerformed

private void btnSairOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairOsActionPerformed
    dlgOs.dispose();
}//GEN-LAST:event_btnSairOsActionPerformed

private void btnSolicitarOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarOsActionPerformed
    int row = 0;
    Cliente c = null;
    try {
        row = tbCentralOs.getSelectedRow();
        ObjectTableModel<Cliente> model = (ObjectTableModel<Cliente>) tbCentralOs.getModel();
        c = model.getValue(row);
    } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        System.out.println("nenhuma linha selecionada");
    }

    String verificar = txtVerificarOs.getText().trim().toUpperCase();
    String solicitado = txtSolicitadoOs.getText().trim().toUpperCase();
    String desc = txtDescricaoOs.getText().trim();

    if (verificar.length() < 3) {
        JOptionPane.showMessageDialog(dlgOs, "Digite o que o técnico tera que verificar");
        txtVerificarOs.requestFocusInWindow();
    } else {
        if (solicitado.length() < 3) {
            JOptionPane.showMessageDialog(dlgOs, "Digite quem solicitou");
            txtSolicitadoOs.requestFocusInWindow();
        } else {
            if (c == null) {
                JOptionPane.showMessageDialog(dlgOs, "Nenhum cliente selecionado");
            } else {
                Os os = new Os();
                os.setIdcliente(c);
                os.setUsername(users);
                os.setVerificar(verificar);
                os.setSolicitado(solicitado);
                os.setStatus("SOLICITADO");
                os.setData(new Date());
                os.setDescricao(verificar);
                os.setDescricao(desc);

                try {
                    jpaOs.create(os);
                    JOptionPane.showMessageDialog(dlgOs, "Chamado técnico realizado com sucesso");
                    ObjectTableModel<Cliente> model = (ObjectTableModel<Cliente>) tbCentralOs.getModel();
                    model.clear();
                    txtDescOs.setText("");
                    txtVerificarOs.setText("");
                    txtSolicitadoOs.setText("");
                    txtDescricaoOs.setText("");

                    dlgOs.dispose();

                    //Gerando Relatorio
                    String jasper = "src/br/com/fox/relatorios/os.jasper";
                    //String jasper = getClass().getResource("/br/com/fox/relatorios/os.jasper").getFile();

                    Map parameters = new HashMap();
                    parameters.put("IDOS", jpaOs.maxOs().getIdos());
                    parameters.put("IMG", "src/br/com/fox/relatorios/logo.png");

                    DBConnectionFactory factory = new DBConnectionFactory();

                    Connection conn = factory.getConnection();

                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasper,
                            parameters,
                            conn);

                    factory.close();

                    JasperViewer jv = new JasperViewer(jasperPrint);
                    JasperViewer.viewReport(jasperPrint, false);

                } catch (PreexistingEntityException ex) {
                    Logger.getLogger(PMonitoramentoView.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(dlgOs, ex.getMessage());
                } catch (Exception ex) {
                    Logger.getLogger(PMonitoramentoView.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(dlgOs, ex.getMessage());
                }
            }
        }
    }
}//GEN-LAST:event_btnSolicitarOsActionPerformed

private void listObsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listObsMouseClicked

    listObs.setSelectionBackground(new Color(153, 180, 209));
    List<Object> list = listEspera.getSelectedValuesList();
    for (Object object : list) {
        listEspera.setSelectionBackground(Color.WHITE);
    }

    Object value = listObs.getSelectedValue();

    ObjectTableModel model = (ObjectTableModel) tbEvtRouter.getModel();
    model.clear();

    model = (ObjectTableModel) tbEvtSensor.getModel();
    model.clear();
    
    //carregarTableFilter();

    if (value instanceof SinalRouter) {
        selectedRouter = (SinalRouter) value;

        if (selectedRouter.getStatus().equals("ATENDIDO")) {
            JOptionPane.showMessageDialog(this, "Este alarme já foi registrado");
        } else {
            txtLog.setText(selectedRouter.getLog());
            selectedAlarme = null;


            try {
                selectedCliente = selectedRouter.getCodCli();

                painelInfo();

                try {
                    ip = selectedRouter.getIps();

                    Component[] comps = pnAoVivo.getComponents();

                    for (int i = 0; i < comps.length; i++) {
                        if (comps[i] instanceof EmbeddedMediaPlayerComponent) {
                            EmbeddedMediaPlayerComponent component = (EmbeddedMediaPlayerComponent) comps[i];
                            pnAoVivo.remove(component);
                            component.release();
                        }
                    }

                    EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
                    mediaPlayerComponent.setSize(pnAoVivo.getSize());

                    pnAoVivo.add(mediaPlayerComponent);

                    mediaPlayerComponent.getMediaPlayer().playMedia("HTTP://" + ip + ":" + selectedRouter.getPos() + "/IPLLREDIR:" + selectedRouter.getNuc());

                    if (snapShots == null) {
                        snapShots = new CaptureSnapShots(lblSnapshots, selectedRouter, selectedCliente, config);
                        Thread t = new Thread(snapShots);
                        t.start();
                    } else {
                        snapShots.setStopThread(false);
                        snapShots = new CaptureSnapShots(lblSnapshots, selectedRouter, selectedCliente, config);
                        Thread t = new Thread(snapShots);
                        t.start();
                    }


                } catch (Exception ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }

                //=======================================================

            } catch (NoResultException e) {
                JOptionPane.showMessageDialog(this, "Cliente não cadastrado", "Aviso", JOptionPane.WARNING_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    } else {
        Alarme alarme = (Alarme) value;
        selectedRouter = null;

        selectedAlarme = alarme;

        if (selectedAlarme.getStatus().equals("ATENDIDO")) {
        } else {
            txtLog.setText(selectedAlarme.getLog());
            selectedCliente = alarme.getIdcliente();

            painelInfo();

            //=========================================================
            Component[] comps = pnAoVivo.getComponents();

            for (int i = 0; i < comps.length; i++) {
                if (comps[i] instanceof EmbeddedMediaPlayerComponent) {
                    EmbeddedMediaPlayerComponent component = (EmbeddedMediaPlayerComponent) comps[i];
                    pnAoVivo.remove(component);
                    component.release();
                }
            }

            if (snapShots != null) {
                snapShots.setStopThread(false);
                lblSnapshots.setIcon(null);
            }
            //=========================================================
        }
    }

    if (selectedCliente != null) {

        lblIdCliente.setText(String.valueOf(selectedCliente.getCodCli()));
        lblFantCliente.setText(selectedCliente.getFantasia());
        lblRazaoCliente.setText(selectedCliente.getNome());
        lblEndCliente.setText(selectedCliente.getEndereco() + " - " + selectedCliente.getBairro() + " - " + selectedCliente.getCidade() + " - " + selectedCliente.getUf());
        lblEndCliente.setToolTipText(lblEndCliente.getText());
        lblFone1.setText(selectedCliente.getFoneLocal());
        lblFone2.setText(selectedCliente.getFoneLocal2());
        txtPerguntaCliente.setText(selectedCliente.getPergunta());
        txtRespCliente.setText(selectedCliente.getResposta());

        Boolean isViatura = Boolean.valueOf(selectedCliente.getViatura());

        iconViatura.setEnabled(isViatura);

        List<Contato> listContato = selectedCliente.getContatoList();

        AnnotationResolver resolverContato = new AnnotationResolver(Contato.class);
        ObjectTableModel<Contato> tableModelContato = new ObjectTableModel<Contato>(
                resolverContato, "prioridade,nome,fone,fone2,funcao");

        tableModelContato.setData(listContato);
        tableModelContato.setEditableDefault(false);
        tbContatos.setModel(tableModelContato);
        //TableFilter filterContato = new TableFilter(tbContatos.getTableHeader(), tableModelContato);
        //tbContatos.setModel(filterContato);

        int lrgNome = 0;
        int lrgFunc = 0;

        for (Contato contato : tableModelContato) {

            if (contato.getNome().length() > lrgNome) {
                lrgNome = contato.getNome().length();
                tbContatos.getColumnModel().getColumn(1).setPreferredWidth(lrgNome * 7);
            }

            if (contato.getFuncao().length() > lrgFunc) {
                lrgFunc = contato.getFuncao().length();
                tbContatos.getColumnModel().getColumn(4).setPreferredWidth(lrgFunc * 7);
            }

        }
        tbContatos.getColumnModel().getColumn(2).setPreferredWidth(98);
        tbContatos.getColumnModel().getColumn(3).setPreferredWidth(98);


        List<Usuario> listUsuario = selectedCliente.getUsuarioList();

        AnnotationResolver resolverUsuario = new AnnotationResolver(Usuario.class);
        ObjectTableModel<Usuario> tableModelUsuario = new ObjectTableModel<Usuario>(
                resolverUsuario, "nome,cargo,codigo");

        tableModelUsuario.setData(listUsuario);
        tableModelUsuario.setEditableDefault(false);
        tbUsuarios.setModel(tableModelUsuario);
        //TableFilter filterUsuario = new TableFilter(tbUsuarios.getTableHeader(), tableModelUsuario);
        //tbUsuarios.setModel(filterUsuario);

        jTabbedPane3.setSelectedIndex(5);

        if (selectedAlarme != null) {
            if (selectedAlarme.getIdprotocolo().getCuc().getPrioridade().equals("ALTA") || selectedAlarme.getIdprotocolo().getCuc().getPrioridade().equals("CRÍTICA")) {
                jTabbedPane3.setSelectedIndex(0);
            }
        } else {
            if (selectedRouter.getOrg().equals("VIPER")) {
                jTabbedPane3.setSelectedIndex(0);
            }
        }
    }
}//GEN-LAST:event_listObsMouseClicked

private void btnViewMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewMapActionPerformed

    if (selectedCliente != null) {
        String rua = selectedCliente.getEndereco();
        String html = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\" />\n"
                + "        <style type=\"text/css\">\n"
                + "            html { height: 100% }\n"
                + "            body { height: 100%; margin: 0px; padding: 0px }\n"
                + "            #map_canvas { height: 100% }\n"
                + "        </style>\n"
                + "        <script type=\"text/javascript\"\n"
                + "                src=\"https://maps.google.com/maps/api/js?sensor=true\">\n"
                + "        </script>\n"
                + "        <script type=\"text/javascript\">\n"
                + "            var geocoder;\n"
                + "            var map;\n"
                + "            function initialize() {\n"
                + "                geocoder = new google.maps.Geocoder();\n"
                + "                var latlng = new google.maps.LatLng(0,0);\n"
                + "                var myOptions = {\n"
                + "                    zoom: 15,\n"
                + "                    center: latlng,\n"
                + "                    mapTypeId: google.maps.MapTypeId.ROADMAP\n"
                + "                }\n"
                + "                map = new google.maps.Map(document.getElementById(\"map_canvas\"), myOptions);\n"
                + "            }\n"
                + "            function codeAddress() {\n"
                + "                geocoder.geocode( { 'address': '" + rua + "'}, function(results, status) {\n"
                + "                    if (status == google.maps.GeocoderStatus.OK) {\n"
                + "                        map.setCenter(results[0].geometry.location);\n"
                + "                        var marker = new google.maps.Marker({\n"
                + "                            map: map,\n"
                + "                            position: results[0].geometry.location\n"
                + "                        });\n"
                + "                    } else {\n"
                //+ "                        alert(\"Não foi possível localizar o endereço\");\n"
                + "                    }\n"
                + "                });\n"
                + "            }\n"
                + "        </script>\n"
                + "    </head>\n"
                + "    <body onload=\"initialize();codeAddress()\">\n"
                + "        <div id=\"map_canvas\"></div>\n"
                + "    </body>\n"
                + "</html>";

        Component[] comps = pnMapa.getComponents();

        for (int i = 0; i < comps.length; i++) {
            if (comps[i] instanceof JWebBrowser) {
                JWebBrowser component = (JWebBrowser) comps[i];
                component.disposeNativePeer();
                pnMapa.remove(component);
            }
        }

        JWebBrowser webBrowser = new JWebBrowser();
        webBrowser.setBarsVisible(false);
        webBrowser.setHTMLContent(html);
        webBrowser.setVisible(true);

        pnMapa.setLayout(new BorderLayout());
        pnMapa.add(webBrowser, BorderLayout.CENTER);
    }

}//GEN-LAST:event_btnViewMapActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltroEvtRouter;
    private javax.swing.JButton btnFiltroEvtSensor;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnPesquisarOs;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSairOs;
    private javax.swing.JButton btnSalveLog;
    private javax.swing.JButton btnSolicitarOs;
    private javax.swing.JButton btnViewMap;
    private javax.swing.JComboBox cboxPesquisarPor;
    private javax.swing.JComboBox cboxPesquisarPorOs;
    private javax.swing.JDialog dlgOs;
    private javax.swing.JDialog dlgX8;
    private javax.swing.JLabel iconOS;
    private javax.swing.JLabel iconViatura;
    private javax.swing.JLabel iconViatura1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lblEndCliente;
    private javax.swing.JLabel lblFantCliente;
    private javax.swing.JLabel lblFone1;
    private javax.swing.JLabel lblFone2;
    private javax.swing.JLabel lblIdCliente;
    private javax.swing.JLabel lblRazaoCliente;
    private javax.swing.JLabel lblSnapshots;
    private javax.swing.JLabel lblUsers;
    private javax.swing.JList listEspera;
    private javax.swing.JList listNaoAtendidos;
    private javax.swing.JList listObs;
    private javax.swing.JPanel pnAoVivo;
    private javax.swing.JPanel pnInfo;
    private javax.swing.JPanel pnMapa;
    private javax.swing.JPanel pnSnapshots;
    private javax.swing.JSpinner spLimiteEvtRouter;
    private javax.swing.JSpinner spLimiteEvtSensor;
    private javax.swing.JTable tbCentral;
    private javax.swing.JTable tbCentralOs;
    private javax.swing.JTable tbContatos;
    private javax.swing.JTable tbEvtRouter;
    private javax.swing.JTable tbEvtSensor;
    private javax.swing.JTable tbUsuarios;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtDescOs;
    private javax.swing.JEditorPane txtDescricaoOs;
    private javax.swing.JEditorPane txtLog;
    private javax.swing.JTextPane txtLogEvtRouter;
    private javax.swing.JTextPane txtLogEvtSensor;
    private javax.swing.JTextArea txtPerguntaCliente;
    private javax.swing.JTextArea txtRespCliente;
    private javax.swing.JTextField txtSolicitadoOs;
    private javax.swing.JTextField txtVerificarOs;
    // End of variables declaration//GEN-END:variables

    private void painelInfo() {

        pnInfo.removeAll();

        if (selectedRouter != null) {
            pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alarme Câmera", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 24), java.awt.Color.red)); // NOI18N

            JLabel lblCodigo = new JLabel("Código:");
            JLabel lblOrigem = new JLabel("Origem:");
            JLabel lblData = new JLabel("Data:");
            JLabel lblAplicacao = new JLabel("Aplicação:");
            JLabel lblCamera = new JLabel("Câmera:");
            JLabel lblSubtipo = new JLabel("Subtipo:");

            lblCodigo.setFont(new java.awt.Font("Tahoma", 1, 14));
            lblCodigo.setForeground(new java.awt.Color(51, 153, 0));

            lblOrigem.setFont(new java.awt.Font("Tahoma", 1, 14));
            lblOrigem.setForeground(new java.awt.Color(51, 153, 0));

            lblData.setFont(new java.awt.Font("Tahoma", 1, 14));
            lblData.setForeground(new java.awt.Color(51, 153, 0));

            lblAplicacao.setFont(new java.awt.Font("Tahoma", 1, 14));
            lblAplicacao.setForeground(new java.awt.Color(51, 153, 0));

            lblCamera.setFont(new java.awt.Font("Tahoma", 1, 14));
            lblCamera.setForeground(new java.awt.Color(51, 153, 0));

            lblSubtipo.setFont(new java.awt.Font("Tahoma", 1, 14));
            lblSubtipo.setForeground(new java.awt.Color(51, 153, 0));

            JLabel lblCodigoInfo = new JLabel();
            JLabel lblOrigemInfo = new JLabel();
            JLabel lblDataInfo = new JLabel();
            JLabel lblAplicacaoInfo = new JLabel();
            JLabel lblCameraInfo = new JLabel();
            JLabel lblSubtipoInfo = new JLabel();

            lblCodigoInfo.setFont(new java.awt.Font("Tahoma", 1, 14));
            lblCodigoInfo.setText(selectedRouter.getCod().toString());

            lblOrigemInfo.setFont(new java.awt.Font("Tahoma", 1, 14));
            lblOrigemInfo.setText(selectedRouter.getOrg());

            lblDataInfo.setFont(new java.awt.Font("Tahoma", 1, 14));
            lblDataInfo.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(selectedRouter.getDat()));

            lblAplicacaoInfo.setFont(new java.awt.Font("Tahoma", 1, 14));
            lblAplicacaoInfo.setText(selectedRouter.getApl());

            lblCameraInfo.setFont(new java.awt.Font("Tahoma", 1, 14));
            lblCameraInfo.setText(selectedRouter.getNuc().toString());

            lblSubtipoInfo.setFont(new java.awt.Font("Tahoma", 1, 14));
            lblSubtipoInfo.setText(selectedRouter.getSub());

            pnInfo.setLayout(new MigLayout("wrap 6"));
            pnInfo.add(lblCodigo);
            pnInfo.add(lblCodigoInfo);

            pnInfo.add(lblOrigem, "gapleft 30");
            pnInfo.add(lblOrigemInfo);

            pnInfo.add(lblData, "gapleft 30");
            pnInfo.add(lblDataInfo);

            pnInfo.add(lblAplicacao);
            pnInfo.add(lblAplicacaoInfo);

            pnInfo.add(lblCamera, "gapleft 30");
            pnInfo.add(lblCameraInfo);

            pnInfo.add(lblSubtipo, "gapleft 30");
            pnInfo.add(lblSubtipoInfo);
        } else {
            if (selectedAlarme != null) {
                pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alarme Sensor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 24), java.awt.Color.red)); // NOI18N

                JLabel lblData = new JLabel("Data:");
                JLabel lblReceiver = new JLabel("Receiver:");
                JLabel lblLinha = new JLabel("Linha:");
                JLabel lblEvento = new JLabel("Evento:");
                JLabel lblParticao = new JLabel("Partição:");
                JLabel lblZona = new JLabel("");

                lblData.setFont(new java.awt.Font("Tahoma", 1, 14));
                lblData.setForeground(new java.awt.Color(51, 153, 0));

                lblReceiver.setFont(new java.awt.Font("Tahoma", 1, 14));
                lblReceiver.setForeground(new java.awt.Color(51, 153, 0));

                lblLinha.setFont(new java.awt.Font("Tahoma", 1, 14));
                lblLinha.setForeground(new java.awt.Color(51, 153, 0));

                lblEvento.setFont(new java.awt.Font("Tahoma", 1, 14));
                lblEvento.setForeground(new java.awt.Color(51, 153, 0));

                lblParticao.setFont(new java.awt.Font("Tahoma", 1, 14));
                lblParticao.setForeground(new java.awt.Color(51, 153, 0));

                lblZona.setFont(new java.awt.Font("Tahoma", 1, 14));
                lblZona.setForeground(new java.awt.Color(51, 153, 0));

                JLabel lblDataInfo = new JLabel();
                JLabel lblReceiverInfo = new JLabel();
                JLabel lblLinhaInfo = new JLabel();
                JLabel lblEventoInfo = new JLabel();
                JLabel lblParticaoInfo = new JLabel();
                JLabel lblZonaInfo = new JLabel();

                lblDataInfo.setFont(new java.awt.Font("Tahoma", 1, 14));
                lblDataInfo.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(selectedAlarme.getDataRecebimento()));

                lblReceiverInfo.setFont(new java.awt.Font("Tahoma", 1, 14));
                lblReceiverInfo.setText(selectedAlarme.getReceiver().toString());

                lblLinhaInfo.setFont(new java.awt.Font("Tahoma", 1, 14));
                lblLinhaInfo.setText(selectedAlarme.getLinha().toString());

                lblEventoInfo.setFont(new java.awt.Font("Tahoma", 1, 14));
                lblEventoInfo.setText( selectedAlarme.getIdprotocolo().getEvento()+" - "+selectedAlarme.getIdprotocolo().getDescricao());

                lblParticaoInfo.setFont(new java.awt.Font("Tahoma", 1, 14));
                lblParticaoInfo.setText(selectedAlarme.getParticao().toString());

                String auxiliar = selectedAlarme.getIdprotocolo().getCuc().getAuxiliar();

                if (auxiliar.equals("Usuário")) {
                    List<Usuario> list = selectedAlarme.getIdcliente().getUsuarioList();

                    for (Usuario u : list) {
                        if (u.getCodigo().equals(selectedAlarme.getZona())) {
                            lblZona.setText("Usuário:");
                            lblZonaInfo.setFont(new java.awt.Font("Tahoma", 1, 14));
                            lblZonaInfo.setText(u.getCodigo() + " - " + u.getNome());
                            break;
                        } else {
                            lblZona.setText("Usuário:");
                            lblZonaInfo.setFont(new java.awt.Font("Tahoma", 1, 14));
                            lblZonaInfo.setText(selectedAlarme.getZona() + " - Usuário não cadastrado");
                        }
                    }
                }

                if (auxiliar.equals("Zona")) {
                    List<Zona> list = selectedAlarme.getIdcliente().getZonaList();

                    for (Zona z : list) {
                        if (z.getNumZona().equals(selectedAlarme.getZona())) {
                            lblZona.setText("Zona:");
                            lblZonaInfo.setFont(new java.awt.Font("Tahoma", 1, 14));
                            lblZonaInfo.setText(z.getNumZona() + " - " + z.getAreas());
                            break;
                        } else {
                            lblZona.setText("Zona:");
                            lblZonaInfo.setFont(new java.awt.Font("Tahoma", 1, 14));
                            lblZonaInfo.setText(selectedAlarme.getZona() + " - Zona não cadastrada");
                        }
                    }
                }

                /*if (auxiliar.equals("Horários")) {
                    List<Horario> list = selectedAlarme.getIdcliente().getHorarioList();

                    for (Horario h : list) {
                        if (h.getIdhorario().equals(selectedAlarme.getZona())) {
                            lblZona.setText("Zona:");
                            lblZonaInfo.setFont(new java.awt.Font("Tahoma", 1, 14));
                            lblZonaInfo.setText(h.getDiaSemana() + " " + new SimpleDateFormat("HH:mm").format(h.getHora()));
                        }
                    }
                }*/

                pnInfo.setLayout(new MigLayout("wrap 6"));
                pnInfo.add(lblData);
                pnInfo.add(lblDataInfo);

                pnInfo.add(lblReceiver, "gapleft 30");
                pnInfo.add(lblReceiverInfo);

                pnInfo.add(lblLinha, "gapleft 30");
                pnInfo.add(lblLinhaInfo);

                pnInfo.add(lblEvento);
                pnInfo.add(lblEventoInfo);

                pnInfo.add(lblParticao, "gapleft 30");
                pnInfo.add(lblParticaoInfo);

                pnInfo.add(lblZona, "gapleft 30");
                pnInfo.add(lblZonaInfo);

                paintComponents(this.getGraphics());
            }
        }

    }

    private void limpaTela() {

        lblIdCliente.setText("");
        lblFantCliente.setText("");
        lblRazaoCliente.setText("");
        lblEndCliente.setText("");
        lblFone1.setText("(00) 0000-0000");
        lblFone2.setText("(00) 0000-0000");
        txtPerguntaCliente.setText("");
        txtRespCliente.setText("");
        iconViatura.setEnabled(false);


        ObjectTableModel model = (ObjectTableModel) tbEvtRouter.getModel();
        model.clear();

        model = (ObjectTableModel) tbEvtSensor.getModel();
        model.clear();
        
        //carregarTableFilter();

        model = (ObjectTableModel) tbContatos.getModel();
        model.clear();

        model = (ObjectTableModel) tbUsuarios.getModel();
        model.clear();        
        
        //tbContatos.setModel(new DefaultTableModel());
        //tbUsuarios.setModel(new DefaultTableModel());      
        
        txtLog.setText("");

        Component[] comps = pnAoVivo.getComponents();

        for (int i = 0; i < comps.length; i++) {
            if (comps[i] instanceof EmbeddedMediaPlayerComponent) {
                EmbeddedMediaPlayerComponent component = (EmbeddedMediaPlayerComponent) comps[i];
                pnAoVivo.remove(component);
                component.release();
            }
        }

        comps = pnMapa.getComponents();

        for (int i = 0; i < comps.length; i++) {
            if (comps[i] instanceof JWebBrowser) {
                JWebBrowser component = (JWebBrowser) comps[i];
                component.disposeNativePeer();
                pnMapa.remove(component);
            }
        }

        if (snapShots != null) {
            snapShots.setStopThread(false);
            lblSnapshots.setIcon(null);
        }

        selectedRouter = null;
        selectedAlarme = null;

        painelInfo();

        listaEmEspera();
        listaObservacao();
    }

    private void listaEmEspera() {
        List<SinalRouter> list = jpaSinalRouter.findSinalRouterEmEspera();
        List<Alarme> listAlm = jpaAlarme.findAlarmeEmEspera();

        DefaultListModel<Object> listModel = new DefaultListModel<Object>();

        for (SinalRouter sr : list) {
            if (sr.getUsername().equals(users)) {
                listModel.addElement(sr);
            }
        }

        for (Alarme alarme : listAlm) {
            if (alarme.getUsername().getUsername().equals(users.getUsername())) {
                listModel.addElement(alarme);
            }
        }

        listEspera.setCellRenderer(new CoresEventos());
        listEspera.setModel(listModel);
    }

    private void listaObservacao() {
        List<SinalRouter> list = jpaSinalRouter.findSinalRouterObservacao();
        List<Alarme> listAlm = jpaAlarme.findAlarmeObservacao();

        DefaultListModel<Object> listModel = new DefaultListModel<Object>();

        for (SinalRouter sr : list) {
            listModel.addElement(sr);
        }

        for (Alarme alarme : listAlm) {
            listModel.addElement(alarme);
        }

        listObs.setCellRenderer(new CoresEventos());
        listObs.setModel(listModel);
    }

    private void findSinalRouter() {
        Thread t = new Thread(new FindEventos(listNaoAtendidos, listEspera, listObs));
        t.start();
    }

    public void setUsers(Users users) {
        this.users = users;
        lblUsers.setText(lblUsers.getText() + " " + users.getUsername().toUpperCase());
        listaEmEspera();
        listaObservacao();
    }

    private void mostraListaObs() {
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    listaObservacao();
                    try {
                        Thread.sleep(20000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PMonitoramentoView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        t.start();
    }

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
        }
    }
}
