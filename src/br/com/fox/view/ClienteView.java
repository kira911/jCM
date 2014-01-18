package br.com.fox.view;

import br.com.fox.controller.ClienteJpaController;
import br.com.fox.controller.ContatoJpaController;
import br.com.fox.controller.HorarioJpaController;
import br.com.fox.controller.UsuarioJpaController;
import br.com.fox.controller.ZonaJpaController;
import br.com.fox.db.Cliente;
import br.com.fox.db.Contato;
import br.com.fox.db.Horario;
import br.com.fox.db.Usuario;
import br.com.fox.db.Zona;
import br.com.fox.util.FixedLengthDocument;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import com.towel.swing.table.TableFilter;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.lavieri.modelutil.cep.WebServiceCep;

/**
 *
 * @author Dvr
 */
public class ClienteView extends javax.swing.JFrame {

    private ClienteJpaController jpaCli = new ClienteJpaController();
    private UsuarioJpaController jpaUser = new UsuarioJpaController();
    private ContatoJpaController jpaContato = new ContatoJpaController();
    private ZonaJpaController jpaZona = new ZonaJpaController();
    private HorarioJpaController jpaHorario = new HorarioJpaController();
    private Cliente selectedCliente = null;
    private ListModel lm;

    public ClienteView() {
        initComponents();
        txtCodCli.requestFocusInWindow();
        setLocationRelativeTo(null);
        txtClienteCount.setText("Clientes cadastrados: " + clienteCount());
    }

    private int clienteCount() {
        return jpaCli.getClienteCount();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        dlgFindCli = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtRazaoFindCli = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtFantasiaFindCli = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtCodCliFindCli = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbFindCli = new javax.swing.JTable();
        btnContinuar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnFiltrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCodCli = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRazao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFantasia = new javax.swing.JTextField();
        txtClienteCount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEnd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboxUf = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txtCep = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txtRef = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPergunta = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtResposta = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTpEquip = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbContatos = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        txtNomeContatos = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtFoneContatos = new javax.swing.JFormattedTextField();
        btnAddContatos = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txtFone2Contatos = new javax.swing.JFormattedTextField();
        jLabel24 = new javax.swing.JLabel();
        spPrioridadeContato = new javax.swing.JSpinner();
        jLabel25 = new javax.swing.JLabel();
        txtFuncaoContato = new javax.swing.JTextField();
        btnExcluirContato = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        txtNomeUsuarios = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtCargoUsuarios = new javax.swing.JTextField();
        btnAddUsuarios = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtCodUsuarios = new javax.swing.JFormattedTextField();
        btnExcluirUsuario = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbZona = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtAreaZona = new javax.swing.JTextField();
        spnCameraZona = new javax.swing.JSpinner();
        btnAddZona = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        spnNumZona = new javax.swing.JSpinner();
        btnExcluirZona = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        txtDataExpObs = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbHorario = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        cboxDiaSemana = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        txtAbertura = new javax.swing.JFormattedTextField();
        txtFechamento = new javax.swing.JFormattedTextField();
        jLabel37 = new javax.swing.JLabel();
        btnAddHorario = new javax.swing.JButton();
        btnExcluirHorario = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtDataAtiv = new com.toedter.calendar.JDateChooser();
        txtDataCanc = new com.toedter.calendar.JDateChooser();
        jLabel31 = new javax.swing.JLabel();
        txtFoneLocal = new javax.swing.JFormattedTextField();
        txtFoneLocal2 = new javax.swing.JFormattedTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        ckboxViatura = new javax.swing.JCheckBox();
        jLabel34 = new javax.swing.JLabel();
        txtResposavel = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        ckboxAtivo = new javax.swing.JCheckBox();
        jLabel39 = new javax.swing.JLabel();
        txtIP = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jTextField1.setText("jTextField1");

        jLabel6.setText("jLabel6");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        dlgFindCli.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dlgFindCli.setTitle("Busca de clientes");
        dlgFindCli.setResizable(false);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por:"));

        jLabel20.setText("Razão Social:");

        txtRazaoFindCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazaoFindCliActionPerformed(evt);
            }
        });

        jLabel21.setText("Nome Fantasia:");

        txtFantasiaFindCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFantasiaFindCliActionPerformed(evt);
            }
        });

        jLabel22.setText("Conta:");

        txtCodCliFindCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodCliFindCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodCliFindCli, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFantasiaFindCli, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(txtRazaoFindCli, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtCodCliFindCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtRazaoFindCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtFantasiaFindCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        tbFindCli.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbFindCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Conta", "Razão Social", "Nome Fantasia", "Endereço", "Bairro", "Cidade", "UF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbFindCli.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbFindCli.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tbFindCli);
        tbFindCli.getColumnModel().getColumn(1).setPreferredWidth(200);
        tbFindCli.getColumnModel().getColumn(2).setPreferredWidth(150);
        tbFindCli.getColumnModel().getColumn(3).setPreferredWidth(200);
        tbFindCli.getColumnModel().getColumn(4).setPreferredWidth(100);
        tbFindCli.getColumnModel().getColumn(5).setPreferredWidth(100);
        tbFindCli.getColumnModel().getColumn(6).setPreferredWidth(50);

        btnContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/forward-icon.png"))); // NOI18N
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/button-cancel-icon.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/filter-icon.png"))); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgFindCliLayout = new javax.swing.GroupLayout(dlgFindCli.getContentPane());
        dlgFindCli.getContentPane().setLayout(dlgFindCliLayout);
        dlgFindCliLayout.setHorizontalGroup(
            dlgFindCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgFindCliLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgFindCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgFindCliLayout.createSequentialGroup()
                        .addComponent(btnContinuar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addComponent(btnFiltrar)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
        );
        dlgFindCliLayout.setVerticalGroup(
            dlgFindCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgFindCliLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dlgFindCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgFindCliLayout.createSequentialGroup()
                        .addComponent(btnFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addComponent(btnContinuar))
                    .addGroup(dlgFindCliLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(btnCancelar)))
                .addContainerGap())
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de clientes");
        setIconImage(new ImageIcon(getClass().getResource("/br/com/icones/vcard_add.png")).getImage());
        setResizable(false);

        jLabel1.setText("Conta:");

        jLabel2.setText("Razão Social:");

        txtRazao.setDocument(new FixedLengthDocument(45));

        jLabel3.setText("Nome Fantasia:");

        txtFantasia.setDocument(new FixedLengthDocument(45));

        txtClienteCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClienteCount.setText("Clientes cadastrados: 0");
        txtClienteCount.setEnabled(false);

        jLabel4.setText("Endereço:");

        txtEnd.setDocument(new FixedLengthDocument(100));

        jLabel5.setText("Bairro:");

        txtBairro.setDocument(new FixedLengthDocument(45));

        jLabel7.setText("Cidade:");

        txtCidade.setDocument(new FixedLengthDocument(45));

        jLabel8.setText("UF:");

        cboxUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));
        cboxUf.setSelectedIndex(25);

        jLabel9.setText("CEP:");

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCepFocusLost(evt);
            }
        });

        jLabel10.setText("Referencia de localização:");

        txtRef.setDocument(new FixedLengthDocument(45));

        jLabel11.setText("Pergunta chave:");

        txtPergunta.setDocument(new FixedLengthDocument(100));

        jLabel13.setText("Resposta chave:");

        txtResposta.setDocument(new FixedLengthDocument(100));

        jLabel14.setText("Tipo de equipamento:");

        txtTpEquip.setDocument(new FixedLengthDocument(45));

        tbContatos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbContatos.setModel(new ObjectTableModel(Contato.class, "nome,fone,fone2,prioridade,funcao"));
        tbContatos.getTableHeader().setReorderingAllowed(false);
        tbContatos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbContatosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbContatos);

        jLabel15.setText("Nome:");

        txtNomeContatos.setDocument(new FixedLengthDocument(100));

        jLabel16.setText("Telefone:");

        try {
            txtFoneContatos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnAddContatos.setText("Adicionar contato");
        btnAddContatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddContatosActionPerformed(evt);
            }
        });

        jLabel23.setText("Telefone 2:");

        try {
            txtFone2Contatos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel24.setText("Prioridade:");

        spPrioridadeContato.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jLabel25.setText("Função:");

        txtFuncaoContato.setDocument(new FixedLengthDocument(45));

        btnExcluirContato.setText("Excluir Contato");
        btnExcluirContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirContatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeContatos, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                            .addComponent(txtFoneContatos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spPrioridadeContato, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFuncaoContato, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                            .addComponent(txtFone2Contatos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAddContatos)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirContato)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtNomeContatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtFoneContatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtFone2Contatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(spPrioridadeContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtFuncaoContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddContatos)
                    .addComponent(btnExcluirContato))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Contatos", jPanel1);

        tbUsuarios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbUsuarios.setModel(new ObjectTableModel(Usuario.class, "nome,cargo,codigo"));
        tbUsuarios.getTableHeader().setReorderingAllowed(false);
        tbUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbUsuariosKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tbUsuarios);

        jLabel17.setText("Nome:");

        txtNomeUsuarios.setDocument(new FixedLengthDocument(45));

        jLabel18.setText("Cargo:");

        txtCargoUsuarios.setDocument(new FixedLengthDocument(45));

        btnAddUsuarios.setText("Adicionar usuário");
        btnAddUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUsuariosActionPerformed(evt);
            }
        });

        jLabel26.setText("Código:");

        txtCodUsuarios.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        btnExcluirUsuario.setText("Excluir usuário");
        btnExcluirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCargoUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomeUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                            .addComponent(txtCodUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAddUsuarios)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirUsuario)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtNomeUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtCargoUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtCodUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddUsuarios)
                    .addComponent(btnExcluirUsuario))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Usuários", jPanel2);

        tbZona.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbZona.setModel(new ObjectTableModel(Zona.class, "areas,camera,numZona"));
        tbZona.getTableHeader().setReorderingAllowed(false);
        tbZona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbZonaKeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(tbZona);

        jLabel12.setText("Área:");

        jLabel19.setText("Câmera:");

        txtAreaZona.setDocument(new FixedLengthDocument(250));

        spnCameraZona.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        btnAddZona.setText("Adicionar zona");
        btnAddZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddZonaActionPerformed(evt);
            }
        });

        jLabel30.setText("Nº Zona");

        spnNumZona.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        btnExcluirZona.setText("Excluir Zona");
        btnExcluirZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirZonaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtAreaZona, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel30)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spnNumZona))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spnCameraZona, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnAddZona)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluirZona)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtAreaZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(spnCameraZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(spnNumZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddZona)
                    .addComponent(btnExcluirZona))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Zonas", jPanel4);

        txtObs.setColumns(20);
        txtObs.setLineWrap(true);
        txtObs.setRows(5);
        jScrollPane7.setViewportView(txtObs);

        jLabel27.setText("Data de expiração:");

        txtDataExpObs.setDate(new Date());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataExpObs, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(txtDataExpObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Observação", jPanel6);

        tbHorario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbHorario.setModel(new ObjectTableModel(Horario.class, "diaSemana,horaAbre,horaFecha"));
        tbHorario.getTableHeader().setReorderingAllowed(false);
        tbHorario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbHorarioKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(tbHorario);

        jLabel35.setText("Dia da semana:");

        cboxDiaSemana.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Segunda a Sexta", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo" }));

        jLabel36.setText("Horário de abertura:");

        txtAbertura.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        txtAbertura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAbertura.setText("00:00");

        txtFechamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        txtFechamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechamento.setText("00:00");

        jLabel37.setText("Horário de fechamento:");

        btnAddHorario.setText("Adicionar Horário");
        btnAddHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHorarioActionPerformed(evt);
            }
        });

        btnExcluirHorario.setText("Excluir Horário");
        btnExcluirHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirHorarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddHorario)
                .addGap(18, 18, 18)
                .addComponent(btnExcluirHorario)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechamento)
                .addGap(21, 21, 21))
            .addComponent(jScrollPane4)
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtAbertura, txtFechamento});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(cboxDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(txtAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(txtFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddHorario)
                    .addComponent(btnExcluirHorario))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Horários", jPanel3);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Floppy-Drive-icon.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Apps-system-software-update-icon.png"))); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setEnabled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Actions-edit-clear-icon.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/door-in-icon.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel28.setText("Data de ativação:");

        jLabel29.setText("Data de cancelamento:");

        jLabel31.setText("Telefone local:");

        try {
            txtFoneLocal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFoneLocal.setValue("(00) 0000-0000");

        try {
            txtFoneLocal2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFoneLocal2.setValue("(00) 0000-0000");

        jLabel32.setText("Telefone local 2:");

        jLabel33.setText("viatura?");

        ckboxViatura.setText("Sim");
        ckboxViatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckboxViaturaActionPerformed(evt);
            }
        });

        jLabel34.setText("Responsável:");

        jLabel38.setText("Conta ativa?");

        ckboxAtivo.setText("Sim");

        jLabel39.setText("IP/DNS:");

        txtBairro.setDocument(new FixedLengthDocument(45));

        jMenu1.setText("Arquivos");

        jMenuItem1.setText("Buscar clientes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39)
                                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ckboxAtivo)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDataCanc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel29))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ckboxViatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtResposavel)
                                    .addComponent(jLabel34)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtBairro, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCep, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(34, 34, 34))
                                            .addComponent(cboxUf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(txtRef)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtFantasia, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEnd, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtRazao, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(txtCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtClienteCount, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtTpEquip, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel11)
                                                .addComponent(txtPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel13)
                                                    .addGap(70, 70, 70))
                                                .addComponent(txtResposta))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel31)
                                            .addComponent(txtFoneLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel32)
                                            .addComponent(txtFoneLocal2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel28)
                                            .addComponent(txtDataAtiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnLimpar, btnSair, btnSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClienteCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRazao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtResposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTpEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFoneLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFoneLocal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataAtiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jTabbedPane1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDataCanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ckboxViatura)
                        .addComponent(txtResposavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel39)
                        .addGap(4, 4, 4)
                        .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ckboxAtivo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnSalvar)
                    .addComponent(btnAtualizar)
                    .addComponent(btnLimpar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
    dispose();
}//GEN-LAST:event_btnSairActionPerformed

private void btnAddContatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddContatosActionPerformed
    String nome = txtNomeContatos.getText().trim().toUpperCase();
    try {
        String fone = txtFoneContatos.getValue().toString();
        String fone2 = txtFone2Contatos.getValue().toString();
        String funcao = txtFuncaoContato.getText().trim().toUpperCase();
        if (nome.length() < 3) {
            JOptionPane.showMessageDialog(null, "Digite o nome do contato");
            txtNomeContatos.requestFocusInWindow();
        } else {
            if (funcao.length() < 3) {
                JOptionPane.showMessageDialog(null, "Digite a função do contato");
                txtFuncaoContato.requestFocusInWindow();
            } else {
                AnnotationResolver resolver = new AnnotationResolver(Contato.class);
                ObjectTableModel<Contato> tableModel = new ObjectTableModel<Contato>(
                        resolver, "nome,fone,fone2,prioridade,funcao");

                List<Contato> list = new ArrayList<Contato>();

                Contato contato = new Contato();
                contato.setNome(nome);
                contato.setFone(fone);
                contato.setFone2(fone2);
                contato.setPrioridade(Integer.parseInt(spPrioridadeContato.getValue().toString()));
                contato.setFuncao(funcao);

                if (selectedCliente != null) {
                    contato.setIdcliente(selectedCliente);
                    jpaContato.create(contato);
                }

                if (tbContatos.getRowCount() == 0) {
                    list.add(contato);
                } else {
                    ObjectTableModel model = (ObjectTableModel) tbContatos.getModel();
                    list.addAll(model.getData());
                    list.add(contato);
                }

                tableModel.setEditableDefault(true);
                tableModel.setData(list);
                
                tbContatos.setModel(tableModel);                
                //TableFilter filter = new TableFilter(tbContatos.getTableHeader(), tableModel);
                //tbContatos.setModel(filter);

                txtNomeContatos.setText("");
                txtFoneContatos.setValue(null);
                txtFone2Contatos.setValue(null);
                spPrioridadeContato.setValue(1);
                txtFuncaoContato.setText("");
            }
        }
    } catch (NullPointerException e) {
        JOptionPane.showMessageDialog(null, "Digite o numero do telefone");
        txtFoneContatos.requestFocusInWindow();
    }
}//GEN-LAST:event_btnAddContatosActionPerformed

private void btnAddUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUsuariosActionPerformed
    String nome = txtNomeUsuarios.getText().trim().toUpperCase();
    String cargo = txtCargoUsuarios.getText().trim().toUpperCase();
    Integer cod = Integer.parseInt(txtCodUsuarios.getValue().toString());

    if (nome.length() < 3) {
        JOptionPane.showMessageDialog(null, "Digite o nome do usuário");
        txtNomeUsuarios.requestFocusInWindow();
    } else {
        if (cargo.length() < 3) {
            JOptionPane.showMessageDialog(null, "Digite o cargo do usuário");
            txtCargoUsuarios.requestFocusInWindow();
        } else {
            if (cod == null) {
                JOptionPane.showMessageDialog(null, "Digite o código do usuario");
                txtCodUsuarios.requestFocusInWindow();
            } else {
                AnnotationResolver resolver = new AnnotationResolver(Usuario.class);
                ObjectTableModel<Usuario> tableModel = new ObjectTableModel<Usuario>(
                        resolver, "nome,cargo,codigo");

                List<Usuario> list = new ArrayList<Usuario>();

                Usuario user = new Usuario();
                user.setNome(nome);
                user.setCargo(cargo);
                user.setCodigo(cod);

                if (selectedCliente != null) {
                    user.setIdcliente(selectedCliente);
                    jpaUser.create(user);
                }

                if (tbUsuarios.getRowCount() == 0) {
                    list.add(user);
                } else {
                    ObjectTableModel model = (ObjectTableModel) tbUsuarios.getModel();
                    list.addAll(model.getData());
                    list.add(user);
                }

                tableModel.setEditableDefault(true);
                tableModel.setData(list);

                tbUsuarios.setModel(tableModel);
                //TableFilter filter = new TableFilter(tbUsuarios.getTableHeader(), tableModel);
                //tbUsuarios.setModel(filter);

                txtNomeUsuarios.setText("");
                txtCargoUsuarios.setText("");
                txtCodUsuarios.setText("");
            }
        }
    }
}//GEN-LAST:event_btnAddUsuariosActionPerformed

private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed

    int r = JOptionPane.showConfirmDialog(this, "Deseja limpar todos os dados?");

    if (r == 0) {
        txtCodCli.setText("");
        txtRazao.setText("");
        txtFantasia.setText("");
        txtEnd.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        cboxUf.setSelectedItem("SP");
        txtCep.setValue(null);
        txtRef.setText("");
        txtPergunta.setText("");
        txtResposta.setText("");
        txtTpEquip.setText("");
        txtObs.setText("");
        txtDataExpObs.setDate(new Date());
        txtDataAtiv.setDate(null);
        txtDataCanc.setDate(null);
        txtFoneLocal.setValue("(00) 0000-0000");
        txtFoneLocal2.setValue("(00) 0000-0000");
        ckboxViatura.setSelected(false);
        txtResposavel.setText("");
        ckboxAtivo.setSelected(false);
        txtIP.setText("");

        try {
            ObjectTableModel<Object> modelo = (ObjectTableModel<Object>) tbContatos.getModel();
            modelo.clear();

            modelo = (ObjectTableModel<Object>) tbUsuarios.getModel();
            modelo.clear();

            modelo = (ObjectTableModel<Object>) tbZona.getModel();
            modelo.clear();

            modelo = (ObjectTableModel<Object>) tbHorario.getModel();
            modelo.clear();
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }

        selectedCliente = null;

        txtClienteCount.setText("Clientes cadastrados: " + clienteCount());

        btnAtualizar.setEnabled(false);
        btnSalvar.setEnabled(true);

        txtCodCli.requestFocusInWindow();
    }

}//GEN-LAST:event_btnLimparActionPerformed

private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
    try {
        Integer codCli = Integer.parseInt(txtCodCli.getText().trim());
        String razao = txtRazao.getText().trim().toUpperCase();
        String fantasia = txtFantasia.getText().trim().toUpperCase();
        String end = txtEnd.getText().trim().toUpperCase();
        String bairro = txtBairro.getText().trim().toUpperCase();
        String cidade = txtCidade.getText().trim().toUpperCase();
        String uf = cboxUf.getSelectedItem().toString();
        String cep = "";
        try {
            cep = txtCep.getValue().toString();
        } catch (Exception e) {
            cep = "00000-000";
        }
        String ref = txtRef.getText().trim().toUpperCase();
        String perg = txtPergunta.getText().trim().toUpperCase();
        String resp = txtResposta.getText().trim().toUpperCase();
        String tpEquip = txtTpEquip.getText().trim().toUpperCase();
        String obs = txtObs.getText().trim();
        Date dataExpObs = txtDataExpObs.getDate();
        Date dataAtiv = txtDataAtiv.getDate();
        Date dataCanc = txtDataCanc.getDate();
        String foneLocal = txtFoneLocal.getValue().toString();
        String foneLocal2 = txtFoneLocal2.getValue().toString();
        String responsavel = txtResposavel.getText().trim().toUpperCase();

        if (razao.length() < 3) {
            JOptionPane.showMessageDialog(null,
                    "Digite a razão social",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            txtRazao.requestFocusInWindow();
        } else {
            if (end.length() < 3) {
                JOptionPane.showMessageDialog(null,
                        "Digite o endereço",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                txtEnd.requestFocusInWindow();
            } else {
                if (bairro.length() < 3) {
                    JOptionPane.showMessageDialog(null,
                            "Digite o bairro",
                            "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                    txtBairro.requestFocusInWindow();
                } else {
                    if (cidade.length() < 3) {
                        JOptionPane.showMessageDialog(null,
                                "Digite a cidade",
                                "Aviso",
                                JOptionPane.WARNING_MESSAGE);
                        txtCidade.requestFocusInWindow();
                    } else {
                        if (ref.length() < 3) {
                            JOptionPane.showMessageDialog(null,
                                    "Digite uma referencia de localização",
                                    "Aviso",
                                    JOptionPane.WARNING_MESSAGE);
                            txtRef.requestFocusInWindow();
                        } else {
                            if (perg.length() < 3) {
                                JOptionPane.showMessageDialog(null,
                                        "Digite uma pergunta chave",
                                        "Aviso",
                                        JOptionPane.WARNING_MESSAGE);
                                txtPergunta.requestFocusInWindow();
                            } else {
                                if (resp.length() < 3) {
                                    JOptionPane.showMessageDialog(null,
                                            "Digite uma resposta chave",
                                            "Aviso",
                                            JOptionPane.WARNING_MESSAGE);
                                    txtResposta.requestFocusInWindow();
                                } else {
                                    if (tbContatos.getRowCount() == 0) {
                                        JOptionPane.showMessageDialog(null,
                                                "Adicione um contato",
                                                "Aviso",
                                                JOptionPane.WARNING_MESSAGE);
                                        jTabbedPane1.setSelectedIndex(0);
                                        txtNomeContatos.requestFocusInWindow();
                                    } else {
                                        if (tbUsuarios.getRowCount() == 0) {
                                            JOptionPane.showMessageDialog(null,
                                                    "Adicione um usuário",
                                                    "Aviso",
                                                    JOptionPane.WARNING_MESSAGE);
                                            jTabbedPane1.setSelectedIndex(1);
                                            txtNomeUsuarios.requestFocusInWindow();
                                        } else {
                                            if (tbZona.getRowCount() == 0) {
                                                JOptionPane.showMessageDialog(null,
                                                        "Adicione uma zona",
                                                        "Aviso",
                                                        JOptionPane.WARNING_MESSAGE);
                                                jTabbedPane1.setSelectedIndex(2);
                                                txtAreaZona.requestFocusInWindow();
                                            } else {
                                                Cliente c = new Cliente();
                                                c.setCodCli(codCli);
                                                c.setNome(razao);
                                                c.setFantasia(fantasia);
                                                c.setEndereco(end);
                                                c.setBairro(bairro);
                                                c.setCidade(cidade);
                                                c.setUf(uf);
                                                c.setCep(cep);
                                                c.setReferencia(ref);
                                                c.setPergunta(perg);
                                                c.setResposta(resp);
                                                c.setTpEquipamento(tpEquip);
                                                c.setObs(obs);
                                                c.setDataExpObs(dataExpObs);
                                                c.setDataAtiv(dataAtiv);
                                                c.setDataCanc(dataCanc);
                                                c.setFoneLocal(foneLocal);
                                                c.setFoneLocal2(foneLocal2);
                                                c.setResponsavel(responsavel);

                                                String stBoolean = ((Boolean) ckboxViatura.isSelected()).toString();
                                                c.setViatura(stBoolean);
                                                
                                                String stBoolean2 = ((Boolean) ckboxAtivo.isSelected()).toString();
                                                c.setAtivo(stBoolean2);                                                

                                                jpaCli.create(c);

                                                ObjectTableModel modelo = (ObjectTableModel) tbContatos.getModel();
                                                List<Contato> listContato = modelo.getData();

                                                for (Contato contato : listContato) {
                                                    contato.setIdcliente(c);
                                                    jpaContato.create(contato);
                                                }

                                                modelo = (ObjectTableModel) tbUsuarios.getModel();
                                                List<Usuario> listUser = modelo.getData();

                                                for (Usuario user : listUser) {
                                                    user.setIdcliente(c);
                                                    jpaUser.create(user);
                                                }

                                                modelo = (ObjectTableModel) tbZona.getModel();
                                                List<Zona> listZona = modelo.getData();

                                                for (Zona zona : listZona) {
                                                    zona.setIdcliente(c);
                                                    jpaZona.create(zona);
                                                }

                                                modelo = (ObjectTableModel) tbHorario.getModel();
                                                List<Horario> listHorario = modelo.getData();

                                                for (Horario horario : listHorario) {
                                                    horario.setIdcliente(c);
                                                    jpaHorario.create(horario);
                                                }

                                                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
                                                btnLimparActionPerformed(evt);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Conta inválido", "Aviso", JOptionPane.WARNING_MESSAGE);
        txtCodCli.requestFocusInWindow();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null,
                ex.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_btnSalvarActionPerformed

private void btnAddZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddZonaActionPerformed
    String area = txtAreaZona.getText().trim().toUpperCase();
    Integer camera = (Integer) spnCameraZona.getValue();
    Integer numZona = (Integer) spnNumZona.getValue();

    if (area.length() < 3) {
        JOptionPane.showMessageDialog(null,
                "Digite a área",
                "Aviso",
                JOptionPane.WARNING_MESSAGE);
        txtAreaZona.requestFocusInWindow();
    } else {
        AnnotationResolver resolver = new AnnotationResolver(Zona.class);
        ObjectTableModel<Zona> tableModel = new ObjectTableModel<Zona>(
                resolver, "areas,camera,numZona");

        List<Zona> list = new ArrayList<Zona>();

        Zona zona = new Zona();
        zona.setAreas(area);
        zona.setCamera(camera);
        zona.setNumZona(numZona);

        if (selectedCliente != null) {
            zona.setIdcliente(selectedCliente);
            jpaZona.create(zona);
        }

        if (tbZona.getRowCount() == 0) {
            list.add(zona);
        } else {
            ObjectTableModel model = (ObjectTableModel) tbZona.getModel();
            list.addAll(model.getData());
            list.add(zona);
        }

        tableModel.setEditableDefault(true);
        tableModel.setData(list);

        tbZona.setModel(tableModel);
        //TableFilter filter = new TableFilter(tbZona.getTableHeader(), tableModel);
        //tbZona.setModel(filter);

        txtAreaZona.setText("");
        spnCameraZona.setValue(0);
        spnNumZona.setValue(0);
    }
}//GEN-LAST:event_btnAddZonaActionPerformed

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    dlgFindCli.dispose();
}//GEN-LAST:event_btnCancelarActionPerformed

private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    dlgFindCli.pack();
    dlgFindCli.setModal(true);
    dlgFindCli.setLocationRelativeTo(null);
    dlgFindCli.setVisible(true);
}//GEN-LAST:event_jMenuItem1ActionPerformed

private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
    String codCli = txtCodCliFindCli.getText().trim();
    String razao = txtRazaoFindCli.getText().trim().toUpperCase();
    String fantasia = txtFantasiaFindCli.getText().trim().toUpperCase();

    List<Cliente> list = jpaCli.findCliente(codCli, razao, fantasia);

    AnnotationResolver resolver = new AnnotationResolver(Cliente.class);
    ObjectTableModel<Cliente> tableModel = new ObjectTableModel<Cliente>(
            resolver, "codCli,nome,fantasia,endereco,bairro,cidade,uf");

    tableModel.setData(list);

    tbFindCli.setModel(tableModel);
    //TableFilter filter = new TableFilter(tbFindCli.getTableHeader(), tableModel);
    //tbFindCli.setModel(filter);

    tbFindCli.getColumnModel().getColumn(1).setPreferredWidth(200);
    tbFindCli.getColumnModel().getColumn(2).setPreferredWidth(150);
    tbFindCli.getColumnModel().getColumn(3).setPreferredWidth(200);
    tbFindCli.getColumnModel().getColumn(4).setPreferredWidth(100);
    tbFindCli.getColumnModel().getColumn(5).setPreferredWidth(100);
    tbFindCli.getColumnModel().getColumn(6).setPreferredWidth(50);

    if (tbFindCli.getRowCount() == 0) {
        JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado");
    }
}//GEN-LAST:event_btnFiltrarActionPerformed

private void txtCodCliFindCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodCliFindCliActionPerformed
    btnFiltrarActionPerformed(evt);
}//GEN-LAST:event_txtCodCliFindCliActionPerformed

private void txtRazaoFindCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazaoFindCliActionPerformed
    btnFiltrarActionPerformed(evt);
}//GEN-LAST:event_txtRazaoFindCliActionPerformed

private void txtFantasiaFindCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFantasiaFindCliActionPerformed
    btnFiltrarActionPerformed(evt);
}//GEN-LAST:event_txtFantasiaFindCliActionPerformed

private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
    try {
        ObjectTableModel<Cliente> tableModelCli = (ObjectTableModel<Cliente>) tbFindCli.getModel();
        int row = tbFindCli.getSelectedRow();
        selectedCliente = tableModelCli.getValue(row);


        txtCodCli.setText(String.valueOf(selectedCliente.getCodCli()));
        txtRazao.setText(selectedCliente.getNome());
        txtFantasia.setText(selectedCliente.getFantasia());
        txtEnd.setText(selectedCliente.getEndereco());
        txtBairro.setText(selectedCliente.getBairro());
        txtCidade.setText(selectedCliente.getCidade());
        cboxUf.setSelectedItem(selectedCliente.getUf());
        txtCep.setText(selectedCliente.getCep());
        txtRef.setText(selectedCliente.getReferencia());
        txtPergunta.setText(selectedCliente.getPergunta());
        txtResposta.setText(selectedCliente.getResposta());
        txtTpEquip.setText(selectedCliente.getTpEquipamento());
        txtObs.setText(selectedCliente.getObs());
        txtDataExpObs.setDate(selectedCliente.getDataExpObs());
        txtDataAtiv.setDate(selectedCliente.getDataAtiv());
        txtDataCanc.setDate(selectedCliente.getDataCanc());
        txtFoneLocal.setValue(selectedCliente.getFoneLocal());
        txtFoneLocal2.setValue(selectedCliente.getFoneLocal2());
        ckboxViatura.setSelected(Boolean.valueOf(selectedCliente.getViatura()));
        txtResposavel.setText(selectedCliente.getResponsavel());
        ckboxAtivo.setSelected(Boolean.valueOf(selectedCliente.getAtivo()));
        txtIP.setText(selectedCliente.getIp());

        List<Contato> listContato = selectedCliente.getContatoList();

        AnnotationResolver resolverContato = new AnnotationResolver(Contato.class);
        ObjectTableModel<Contato> tableModelContato = new ObjectTableModel<Contato>(
                resolverContato, "nome,fone,fone2,prioridade,funcao");

        tableModelContato.setData(listContato);
        tableModelContato.setEditableDefault(true);        
        tbContatos.setModel(tableModelContato);
        //TableFilter filterContatos = new TableFilter(tbContatos.getTableHeader(), tableModelContato);
        //tbContatos.setModel(filterContatos);

        List<Usuario> listUsuario = selectedCliente.getUsuarioList();

        AnnotationResolver resolverUsuario = new AnnotationResolver(Usuario.class);
        ObjectTableModel<Usuario> tableModelUsuario = new ObjectTableModel<Usuario>(
                resolverUsuario, "nome,cargo,codigo");

        tableModelUsuario.setData(listUsuario);
        tableModelUsuario.setEditableDefault(true);
        tbUsuarios.setModel(tableModelUsuario);
        //TableFilter filterUsuarios = new TableFilter(tbUsuarios.getTableHeader(), tableModelUsuario);
        //tbUsuarios.setModel(filterUsuarios);

        List<Zona> listZona = selectedCliente.getZonaList();

        AnnotationResolver resolverZona = new AnnotationResolver(Zona.class);
        ObjectTableModel<Zona> tableModelZona = new ObjectTableModel<Zona>(
                resolverZona, "areas,camera,numZona");

        tableModelZona.setData(listZona);
        tableModelZona.setEditableDefault(true);
        tbZona.setModel(tableModelZona);
        //TableFilter filterZona = new TableFilter(tbZona.getTableHeader(), tableModelZona);
        //tbZona.setModel(filterZona);

        List<Horario> listHorario = selectedCliente.getHorarioList();

        AnnotationResolver resolverHorario = new AnnotationResolver(Horario.class);
        ObjectTableModel<Horario> tableModelHorario = new ObjectTableModel<Horario>(
                resolverHorario, "diaSemana,horaAbre,horaFecha");

        tableModelHorario.setData(listHorario);
        tableModelHorario.setEditableDefault(true);
        tbHorario.setModel(tableModelHorario);
        //TableFilter filterHorario = new TableFilter(tbHorario.getTableHeader(), tableModelHorario);
        //tbHorario.setModel(filterHorario);

        btnAtualizar.setEnabled(true);
        btnSalvar.setEnabled(false);

        dlgFindCli.dispose();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,
                "Selecione um item da tabela",
                "Aviso",
                JOptionPane.WARNING_MESSAGE);
    }
}//GEN-LAST:event_btnContinuarActionPerformed

private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
    try {
        Integer codCli = Integer.parseInt(txtCodCli.getText().trim());
        String razao = txtRazao.getText().trim().toUpperCase();
        String fantasia = txtFantasia.getText().trim().toUpperCase();
        String end = txtEnd.getText().trim().toUpperCase();
        String bairro = txtBairro.getText().trim().toUpperCase();
        String cidade = txtCidade.getText().trim().toUpperCase();
        String uf = cboxUf.getSelectedItem().toString();
        String cep = "";
        try {
            cep = txtCep.getValue().toString();
        } catch (Exception e) {
            cep = "00000-000";
        }
        String ref = txtRef.getText().trim().toUpperCase();
        String perg = txtPergunta.getText().trim().toUpperCase();
        String resp = txtResposta.getText().trim().toUpperCase();
        String tpEquip = txtTpEquip.getText().trim().toUpperCase();
        String obs = txtObs.getText().trim();
        Date dataExpObs = txtDataExpObs.getDate();
        Date dataAtiv = txtDataAtiv.getDate();
        Date dataCanc = txtDataCanc.getDate();
        String foneLocal = txtFoneLocal.getValue().toString();
        String foneLocal2 = txtFoneLocal2.getValue().toString();
        String responsalvel = txtResposavel.getText().trim().toUpperCase();
        String ip = txtIP.getText();

        if (razao.length() < 3) {
            JOptionPane.showMessageDialog(null,
                    "Digite a razão social",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            txtRazao.requestFocusInWindow();
        } else {
            if (end.length() < 3) {
                JOptionPane.showMessageDialog(null,
                        "Digite o endereço",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                txtEnd.requestFocusInWindow();
            } else {
                if (bairro.length() < 3) {
                    JOptionPane.showMessageDialog(null,
                            "Digite o bairro",
                            "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                    txtBairro.requestFocusInWindow();
                } else {
                    if (cidade.length() < 3) {
                        JOptionPane.showMessageDialog(null,
                                "Digite a cidade",
                                "Aviso",
                                JOptionPane.WARNING_MESSAGE);
                        txtCidade.requestFocusInWindow();
                    } else {
                        if (ref.length() < 3) {
                            JOptionPane.showMessageDialog(null,
                                    "Digite uma referencia de localização",
                                    "Aviso",
                                    JOptionPane.WARNING_MESSAGE);
                            txtRef.requestFocusInWindow();
                        } else {
                            if (perg.length() < 3) {
                                JOptionPane.showMessageDialog(null,
                                        "Digite uma pergunta chave",
                                        "Aviso",
                                        JOptionPane.WARNING_MESSAGE);
                                txtPergunta.requestFocusInWindow();
                            } else {
                                if (resp.length() < 3) {
                                    JOptionPane.showMessageDialog(null,
                                            "Digite uma resposta chave",
                                            "Aviso",
                                            JOptionPane.WARNING_MESSAGE);
                                    txtResposta.requestFocusInWindow();
                                } else {
                                    if (tbContatos.getRowCount() == 0) {
                                        JOptionPane.showMessageDialog(null,
                                                "Adicione um contato",
                                                "Aviso",
                                                JOptionPane.WARNING_MESSAGE);
                                        jTabbedPane1.setSelectedIndex(0);
                                        txtNomeContatos.requestFocusInWindow();
                                    } else {
                                        if (tbUsuarios.getRowCount() == 0) {
                                            JOptionPane.showMessageDialog(null,
                                                    "Adicione um usuário",
                                                    "Aviso",
                                                    JOptionPane.WARNING_MESSAGE);
                                            jTabbedPane1.setSelectedIndex(1);
                                            txtNomeUsuarios.requestFocusInWindow();
                                        } else {
                                            if (tbZona.getRowCount() == 0) {
                                                JOptionPane.showMessageDialog(null,
                                                        "Adicione uma zona",
                                                        "Aviso",
                                                        JOptionPane.WARNING_MESSAGE);
                                                jTabbedPane1.setSelectedIndex(2);
                                                txtAreaZona.requestFocusInWindow();
                                            } else {
                                                Cliente c = selectedCliente;
                                                c.setCodCli(codCli);
                                                c.setNome(razao);
                                                c.setFantasia(fantasia);
                                                c.setEndereco(end);
                                                c.setBairro(bairro);
                                                c.setCidade(cidade);
                                                c.setUf(uf);
                                                c.setCep(cep);
                                                c.setReferencia(ref);
                                                c.setPergunta(perg);
                                                c.setResposta(resp);
                                                c.setTpEquipamento(tpEquip);
                                                c.setObs(obs);
                                                c.setDataExpObs(dataExpObs);
                                                c.setDataAtiv(dataAtiv);
                                                c.setDataCanc(dataCanc);
                                                c.setFoneLocal(foneLocal);
                                                c.setFoneLocal2(foneLocal2);
                                                c.setResponsavel(responsalvel);
                                                c.setIp(ip);

                                                String stBoolean = ((Boolean) ckboxViatura.isSelected()).toString();
                                                c.setViatura(stBoolean);
                                                
                                                String stBoolean2 = ((Boolean) ckboxAtivo.isSelected()).toString();
                                                c.setAtivo(stBoolean2);                                                

                                                jpaCli.edit(c);

                                                ObjectTableModel<Contato> modelContato = (ObjectTableModel<Contato>) tbContatos.getModel();
                                                List<Contato> listContato = modelContato.getData();

                                                for (Contato contato : listContato) {
                                                    contato.setNome(contato.getNome().trim().toUpperCase());
                                                    jpaContato.edit(contato);
                                                }

                                                ObjectTableModel<Usuario> modelUsuario = (ObjectTableModel<Usuario>) tbUsuarios.getModel();
                                                List<Usuario> listUsuario = modelUsuario.getData();

                                                for (Usuario user : listUsuario) {
                                                    user.setNome(user.getNome().trim().toUpperCase());
                                                    user.setCargo(user.getCargo().trim().toUpperCase());
                                                    jpaUser.edit(user);
                                                }

                                                ObjectTableModel<Zona> modelZona = (ObjectTableModel<Zona>) tbZona.getModel();
                                                List<Zona> listZona = modelZona.getData();

                                                for (Zona zona : listZona) {
                                                    zona.setAreas(zona.getAreas().trim().toUpperCase());
                                                    jpaZona.edit(zona);
                                                }

                                                ObjectTableModel<Horario> modelHorario = (ObjectTableModel<Horario>) tbHorario.getModel();
                                                List<Horario> listHorario = modelHorario.getData();

                                                for (Horario horario : listHorario) {
                                                    jpaHorario.edit(horario);
                                                }

                                                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
                                                btnLimparActionPerformed(evt);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Conta inválido", "Aviso", JOptionPane.WARNING_MESSAGE);
        txtCodCli.requestFocusInWindow();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null,
                ex.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_btnAtualizarActionPerformed

private void txtCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCepFocusLost
    if (txtEnd.getText().trim().length() == 0) {
        WebServiceCep webServiceCep = WebServiceCep.searchCep(txtCep.getText());

        if (webServiceCep.wasSuccessful()) {
            txtEnd.setText(webServiceCep.getLogradouroFull());
            txtBairro.setText(webServiceCep.getBairro());
            txtCidade.setText(webServiceCep.getCidade());
            cboxUf.setSelectedItem(webServiceCep.getUf());

            txtEnd.setText(txtEnd.getText().concat(", "));
            txtEnd.requestFocusInWindow();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Erro numero: " + webServiceCep.getResulCode() + "\n"
                    + "Descrição do erro: " + webServiceCep.getResultText(),
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}//GEN-LAST:event_txtCepFocusLost

private void tbZonaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbZonaKeyPressed
//    if (selectedCliente != null) {
//        if (evt.getKeyCode() == 127) {
//            int row = tbZona.getSelectedRow();
//            ObjectTableModel<Zona> model = (ObjectTableModel<Zona>) tbZona.getModel();
//
//            model.remove(row);
//        }
//    }
}//GEN-LAST:event_tbZonaKeyPressed

private void tbContatosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbContatosKeyPressed
//    if (selectedCliente != null) {
//        if (evt.getKeyCode() == 127) {
//            int row = tbContatos.getSelectedRow();
//            ObjectTableModel<Contato> model = (ObjectTableModel<Contato>) tbContatos.getModel();
//
//            model.remove(row);
//        }
//    }
}//GEN-LAST:event_tbContatosKeyPressed

private void tbUsuariosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbUsuariosKeyPressed
//    if (selectedCliente != null) {
//        if (evt.getKeyCode() == 127) {
//            int row = tbUsuarios.getSelectedRow();
//            ObjectTableModel<Usuario> model = (ObjectTableModel<Usuario>) tbUsuarios.getModel();
//
//            model.remove(row);
//        }
//    }
}//GEN-LAST:event_tbUsuariosKeyPressed

private void btnAddHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHorarioActionPerformed
    try {
        Date horaAbre = new SimpleDateFormat("HH:mm").parse(txtAbertura.getText());
        Date horaFecha = new SimpleDateFormat("HH:mm").parse(txtFechamento.getText());

        AnnotationResolver resolver = new AnnotationResolver(Horario.class);
        ObjectTableModel<Horario> tableModel = new ObjectTableModel<Horario>(
                resolver, "diaSemana,horaAbre,horaFecha");

        tableModel.addAll(((ObjectTableModel) tbHorario.getModel()).getData());

        String diaSemana = "";

        if (cboxDiaSemana.getSelectedIndex() == 0) {

            for (int i = 0; i <= 4; i++) {
                if (i == 0) {
                    diaSemana = "Segunda";

                    Horario horario = new Horario();
                    horario.setDiaSemana(diaSemana);
                    horario.setHoraAbre(horaAbre);
                    horario.setHoraFecha(horaFecha);
                    horario.setEnable("true");

                    tableModel.add(horario);

                    if (selectedCliente != null) {
                        horario.setIdcliente(selectedCliente);
                        jpaHorario.create(horario);
                    }
                }
                if (i == 1) {
                    diaSemana = "Terça";

                    Horario horario = new Horario();
                    horario.setDiaSemana(diaSemana);
                    horario.setHoraAbre(horaAbre);
                    horario.setHoraFecha(horaFecha);
                    horario.setEnable("true");

                    tableModel.add(horario);

                    if (selectedCliente != null) {
                        horario.setIdcliente(selectedCliente);
                        jpaHorario.create(horario);
                    }
                }
                if (i == 2) {
                    diaSemana = "Quarta";

                    Horario horario = new Horario();
                    horario.setDiaSemana(diaSemana);
                    horario.setHoraAbre(horaAbre);
                    horario.setHoraFecha(horaFecha);
                    horario.setEnable("true");

                    tableModel.add(horario);

                    if (selectedCliente != null) {
                        horario.setIdcliente(selectedCliente);
                        jpaHorario.create(horario);
                    }
                }
                if (i == 3) {
                    diaSemana = "Quinta";

                    Horario horario = new Horario();
                    horario.setDiaSemana(diaSemana);
                    horario.setHoraAbre(horaAbre);
                    horario.setHoraFecha(horaFecha);
                    horario.setEnable("true");

                    tableModel.add(horario);

                    if (selectedCliente != null) {
                        horario.setIdcliente(selectedCliente);
                        jpaHorario.create(horario);
                    }
                }
                if (i == 4) {
                    diaSemana = "Sexta";

                    Horario horario = new Horario();
                    horario.setDiaSemana(diaSemana);
                    horario.setHoraAbre(horaAbre);
                    horario.setHoraFecha(horaFecha);
                    horario.setEnable("true");

                    tableModel.add(horario);

                    if (selectedCliente != null) {
                        horario.setIdcliente(selectedCliente);
                        jpaHorario.create(horario);
                    }
                }
            }

        } else {
            diaSemana = cboxDiaSemana.getSelectedItem().toString();
            Horario horario = new Horario();
            horario.setDiaSemana(diaSemana);
            horario.setHoraAbre(horaAbre);
            horario.setHoraFecha(horaFecha);
            horario.setEnable("true");

            tableModel.add(horario);

            if (selectedCliente != null) {
                horario.setIdcliente(selectedCliente);
                jpaHorario.create(horario);
            }
        }

        tbHorario.setModel(tableModel);
        //TableFilter filterHorario = new TableFilter(tbHorario.getTableHeader(), tableModel);
        //tbHorario.setModel(filterHorario);

    } catch (ParseException ex) {
        JOptionPane.showMessageDialog(this, "Horário inválido");
    }
}//GEN-LAST:event_btnAddHorarioActionPerformed

private void tbHorarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbHorarioKeyPressed
//    if (selectedCliente != null) {
//        if (evt.getKeyCode() == 127) {
//            int row = tbHorario.getSelectedRow();
//            ObjectTableModel<Horario> model = (ObjectTableModel<Horario>) tbHorario.getModel();
//
//            model.remove(row);
//        }
//    }
}//GEN-LAST:event_tbHorarioKeyPressed

    private void btnExcluirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirUsuarioActionPerformed
        if (selectedCliente != null) {                                     

            int row = tbUsuarios.getSelectedRow();
            ObjectTableModel<Usuario> model = (ObjectTableModel<Usuario>) tbUsuarios.getModel();

            model.remove(row);          
        }
    }//GEN-LAST:event_btnExcluirUsuarioActionPerformed

    private void btnExcluirHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirHorarioActionPerformed
        if (selectedCliente != null) {                                     

            int row = tbHorario.getSelectedRow();
            ObjectTableModel<Usuario> model = (ObjectTableModel<Usuario>) tbHorario.getModel();

            model.remove(row);          
        }
    }//GEN-LAST:event_btnExcluirHorarioActionPerformed

    private void btnExcluirContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirContatoActionPerformed
        if (selectedCliente != null) {                                     

            int row = tbContatos.getSelectedRow();
            ObjectTableModel<Contato> model = (ObjectTableModel<Contato>) tbContatos.getModel();

            model.remove(row);          
        }        
    }//GEN-LAST:event_btnExcluirContatoActionPerformed

    private void btnExcluirZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirZonaActionPerformed
        if (selectedCliente != null) {                                     

            int row = tbZona.getSelectedRow();
            ObjectTableModel<Contato> model = (ObjectTableModel<Contato>) tbZona.getModel();

            model.remove(row);          
        }                
    }//GEN-LAST:event_btnExcluirZonaActionPerformed

    private void ckboxViaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckboxViaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckboxViaturaActionPerformed

    private class CheckBoxRenderer extends JCheckBox implements TableCellRenderer {

        CheckBoxRenderer() {
            setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (((Boolean) value) == true) {
                setBackground(Color.ORANGE);
            } else {
                setBackground(table.getBackground());
            }
            setSelected((value != null && ((Boolean) value).booleanValue()));
            return this;
        }
    }

    class RowHeaderRenderer extends JLabel implements ListCellRenderer {

        RowHeaderRenderer(JTable table) {
            JTableHeader header = table.getTableHeader();
            setOpaque(true);
            setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            setHorizontalAlignment(CENTER);
            setForeground(header.getForeground());
            setBackground(header.getBackground());
            setFont(header.getFont());
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

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
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ClienteView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddContatos;
    private javax.swing.JButton btnAddHorario;
    private javax.swing.JButton btnAddUsuarios;
    private javax.swing.JButton btnAddZona;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnExcluirContato;
    private javax.swing.JButton btnExcluirHorario;
    private javax.swing.JButton btnExcluirUsuario;
    private javax.swing.JButton btnExcluirZona;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cboxDiaSemana;
    private javax.swing.JComboBox cboxUf;
    private javax.swing.JCheckBox ckboxAtivo;
    private javax.swing.JCheckBox ckboxViatura;
    private javax.swing.JDialog dlgFindCli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JSpinner spPrioridadeContato;
    private javax.swing.JSpinner spnCameraZona;
    private javax.swing.JSpinner spnNumZona;
    private javax.swing.JTable tbContatos;
    private javax.swing.JTable tbFindCli;
    private javax.swing.JTable tbHorario;
    private javax.swing.JTable tbUsuarios;
    private javax.swing.JTable tbZona;
    private javax.swing.JFormattedTextField txtAbertura;
    private javax.swing.JTextField txtAreaZona;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCargoUsuarios;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtClienteCount;
    private javax.swing.JTextField txtCodCli;
    private javax.swing.JTextField txtCodCliFindCli;
    private javax.swing.JFormattedTextField txtCodUsuarios;
    private com.toedter.calendar.JDateChooser txtDataAtiv;
    private com.toedter.calendar.JDateChooser txtDataCanc;
    private com.toedter.calendar.JDateChooser txtDataExpObs;
    private javax.swing.JTextField txtEnd;
    private javax.swing.JTextField txtFantasia;
    private javax.swing.JTextField txtFantasiaFindCli;
    private javax.swing.JFormattedTextField txtFechamento;
    private javax.swing.JFormattedTextField txtFone2Contatos;
    private javax.swing.JFormattedTextField txtFoneContatos;
    private javax.swing.JFormattedTextField txtFoneLocal;
    private javax.swing.JFormattedTextField txtFoneLocal2;
    private javax.swing.JTextField txtFuncaoContato;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtNomeContatos;
    private javax.swing.JTextField txtNomeUsuarios;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JTextField txtPergunta;
    private javax.swing.JTextField txtRazao;
    private javax.swing.JTextField txtRazaoFindCli;
    private javax.swing.JTextField txtRef;
    private javax.swing.JTextField txtResposavel;
    private javax.swing.JTextField txtResposta;
    private javax.swing.JTextField txtTpEquip;
    // End of variables declaration//GEN-END:variables
}
