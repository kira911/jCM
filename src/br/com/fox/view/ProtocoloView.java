package br.com.fox.view;

import br.com.fox.controller.CucJpaController;
import br.com.fox.controller.ProtocoloJpaController;
import br.com.fox.controller.exceptions.PreexistingEntityException;
import br.com.fox.db.Cuc;
import br.com.fox.db.Protocolo;
import br.com.fox.util.FixedLengthDocument;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import com.towel.swing.table.TableFilter;
import java.awt.Component;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Dvr
 */
public class ProtocoloView extends javax.swing.JFrame {

    private CucJpaController jpaCuc = new CucJpaController();
    private ProtocoloJpaController jpaProtocol = new ProtocoloJpaController();
    private Cuc selectedCuc = null;
    private Protocolo selectedProtocol = null;

    public ProtocoloView() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private class ColorTableCucRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (table.getValueAt(row, 2).equals("BAIXA")) {
                comp.setForeground(new java.awt.Color(0, 0, 204));
            } else {
                if (table.getValueAt(row, 2).equals("NORMAL")) {
                    comp.setForeground(new java.awt.Color(153, 153, 0));
                } else {
                    if (table.getValueAt(row, 2).equals("MÉDIA")) {
                        comp.setForeground(new java.awt.Color(0, 153, 0));
                    } else {
                        if (table.getValueAt(row, 2).equals("ALTA")) {
                            comp.setForeground(new java.awt.Color(204, 0, 0));
                        } else {
                            if (table.getValueAt(row, 2).equals("CRÍTICA")) {
                                comp.setForeground(new java.awt.Color(0, 0, 0));
                            }
                        }
                    }
                }
            }

            return comp;
        }
    }

    private class ColorTableProtocolRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            ObjectTableModel<Protocolo> tableModel = (ObjectTableModel<Protocolo>) table.getModel();

            if (tableModel.getValue(row).getCuc().getPrioridade().equals("BAIXA")) {
                comp.setForeground(new java.awt.Color(0, 0, 204));
            } else {
                if (tableModel.getValue(row).getCuc().getPrioridade().equals("NORMAL")) {
                    comp.setForeground(new java.awt.Color(153, 153, 0));
                } else {
                    if (tableModel.getValue(row).getCuc().getPrioridade().equals("MÉDIA")) {
                        comp.setForeground(new java.awt.Color(0, 153, 0));
                    } else {
                        if (tableModel.getValue(row).getCuc().getPrioridade().equals("ALTA")) {
                            comp.setForeground(new java.awt.Color(204, 0, 0));
                        } else {
                            if (tableModel.getValue(row).getCuc().getPrioridade().equals("CRÍTICA")) {
                                comp.setForeground(new java.awt.Color(0, 0, 0));
                            }
                        }
                    }
                }
            }

            return comp;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPrioridade = new javax.swing.ButtonGroup();
        bgTipoEvento = new javax.swing.ButtonGroup();
        fileSom = new javax.swing.JFileChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCuc = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCuc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescricaoCuc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSomCuc = new javax.swing.JTextField();
        btnSelecionaSomCuc = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        rbCriticaCuc = new javax.swing.JRadioButton();
        rbAltaCuc = new javax.swing.JRadioButton();
        rbMediaCuc = new javax.swing.JRadioButton();
        rbNormalCuc = new javax.swing.JRadioButton();
        rbBaixaCuc = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        rbAlarmeCuc = new javax.swing.JRadioButton();
        rbArmadoCuc = new javax.swing.JRadioButton();
        rbTesteAutoCuc = new javax.swing.JRadioButton();
        rbDesarmadoCuc = new javax.swing.JRadioButton();
        rbSemControleCuc = new javax.swing.JRadioButton();
        rbRondaCuc = new javax.swing.JRadioButton();
        btnAtualizarCuc = new javax.swing.JButton();
        btnSalvarCuc = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cboxAux = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProtocol = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtEventoProtocol = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDescProtocol = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboxCucProtocol = new javax.swing.JComboBox();
        btnNovoProtocol = new javax.swing.JButton();
        btnAtualizarProtocol = new javax.swing.JButton();
        btnSalvarProtocol = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cboxTipoProtocol = new javax.swing.JComboBox();

        bgPrioridade.add(rbBaixaCuc);
        bgPrioridade.add(rbNormalCuc);
        bgPrioridade.add(rbMediaCuc);
        bgPrioridade.add(rbAltaCuc);
        bgPrioridade.add(rbCriticaCuc);

        bgTipoEvento.add(rbAlarmeCuc);
        bgTipoEvento.add(rbArmadoCuc);
        bgTipoEvento.add(rbDesarmadoCuc);
        bgTipoEvento.add(rbRondaCuc);
        bgTipoEvento.add(rbSemControleCuc);
        bgTipoEvento.add(rbTesteAutoCuc);

        fileSom.addChoosableFileFilter(new FileNameExtensionFilter("Arquivos de áudio (wma, mp3, wav)", "wma", "mp3", "wav"));
        fileSom.setAcceptAllFileFilterUsed(false);
        fileSom.setDialogTitle("Selecione o arquivo de áudio");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de protocolo");
        setIconImage(new ImageIcon(getClass().getResource("/br/com/icones/Alerts-icon64.png")).getImage());
        setResizable(false);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        tbCuc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbCuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CUC", "Descrição", "Prioridade", "Tipo do evento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCuc.setRowHeight(20);
        tbCuc.setSelectionBackground(new java.awt.Color(191, 205, 219));
        tbCuc.getTableHeader().setReorderingAllowed(false);
        tbCuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCucMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCuc);

        jLabel1.setText("CUC:");

        txtCuc.setDocument(new FixedLengthDocument(3));

        jLabel2.setText("Descrição:");

        txtDescricaoCuc.setDocument(new FixedLengthDocument(100));

        jLabel3.setText("Arquivo de áudio:");

        txtSomCuc.setEditable(false);

        btnSelecionaSomCuc.setText("Selecionar arquivo");
        btnSelecionaSomCuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionaSomCucActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Prioridade"));

        rbCriticaCuc.setText("Crítica");

        rbAltaCuc.setForeground(new java.awt.Color(204, 0, 0));
        rbAltaCuc.setText("Alta");

        rbMediaCuc.setForeground(new java.awt.Color(0, 153, 0));
        rbMediaCuc.setText("Média");

        rbNormalCuc.setForeground(new java.awt.Color(153, 153, 0));
        rbNormalCuc.setSelected(true);
        rbNormalCuc.setText("Normal");

        rbBaixaCuc.setForeground(new java.awt.Color(0, 0, 204));
        rbBaixaCuc.setText("Baixa");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbCriticaCuc)
                .addGap(18, 18, 18)
                .addComponent(rbAltaCuc)
                .addGap(18, 18, 18)
                .addComponent(rbMediaCuc)
                .addGap(18, 18, 18)
                .addComponent(rbNormalCuc)
                .addGap(18, 18, 18)
                .addComponent(rbBaixaCuc)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbNormalCuc)
                        .addComponent(rbBaixaCuc))
                    .addComponent(rbMediaCuc)
                    .addComponent(rbAltaCuc)
                    .addComponent(rbCriticaCuc))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo do evento"));

        rbAlarmeCuc.setSelected(true);
        rbAlarmeCuc.setText("Alarme");

        rbArmadoCuc.setText("Armado");

        rbTesteAutoCuc.setText("Teste automático");

        rbDesarmadoCuc.setText("Desarmado");

        rbSemControleCuc.setText("Sem controle");

        rbRondaCuc.setText("Ronda");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(rbAlarmeCuc)
                        .addGap(38, 38, 38)
                        .addComponent(rbArmadoCuc)
                        .addGap(42, 42, 42)
                        .addComponent(rbTesteAutoCuc))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(rbDesarmadoCuc)
                        .addGap(18, 18, 18)
                        .addComponent(rbSemControleCuc)
                        .addGap(18, 18, 18)
                        .addComponent(rbRondaCuc)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAlarmeCuc)
                    .addComponent(rbTesteAutoCuc)
                    .addComponent(rbArmadoCuc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbDesarmadoCuc)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbSemControleCuc)
                        .addComponent(rbRondaCuc)))
                .addContainerGap())
        );

        btnAtualizarCuc.setText("Atualizar");
        btnAtualizarCuc.setEnabled(false);
        btnAtualizarCuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarCucActionPerformed(evt);
            }
        });

        btnSalvarCuc.setText("Salvar");
        btnSalvarCuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarCucActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        jLabel10.setText("Auxiliar...........:");

        cboxAux.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nenhum", "Usuário", "Zona", "Horários" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addComponent(btnSalvarCuc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizarCuc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovo))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCuc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricaoCuc, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboxAux, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSomCuc, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelecionaSomCuc)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel4, jPanel5});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAtualizarCuc, btnNovo, btnSalvarCuc});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricaoCuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSomCuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSelecionaSomCuc)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboxAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNovo)
                        .addComponent(btnAtualizarCuc)
                        .addComponent(btnSalvarCuc)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("CUC", jPanel1);

        tbProtocol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbProtocol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Evento", "Descrição", "CUC", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProtocol.setRowHeight(20);
        tbProtocol.setSelectionBackground(new java.awt.Color(191, 205, 219));
        tbProtocol.getTableHeader().setReorderingAllowed(false);
        tbProtocol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProtocolMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbProtocol);

        jLabel4.setText("Evento:");

        jLabel5.setText("Descrição:");

        jLabel6.setText("CUC:");

        btnNovoProtocol.setText("Novo");
        btnNovoProtocol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProtocolActionPerformed(evt);
            }
        });

        btnAtualizarProtocol.setText("Atualizar");
        btnAtualizarProtocol.setEnabled(false);
        btnAtualizarProtocol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarProtocolActionPerformed(evt);
            }
        });

        btnSalvarProtocol.setText("Salvar");
        btnSalvarProtocol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarProtocolActionPerformed(evt);
            }
        });

        jLabel7.setText("Tipo:");

        cboxTipoProtocol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Contact ID", "4/2" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEventoProtocol, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtDescProtocol, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(63, 63, 63)
                                .addComponent(jLabel7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cboxCucProtocol, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboxTipoProtocol, 0, 237, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSalvarProtocol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizarProtocol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovoProtocol)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAtualizarProtocol, btnNovoProtocol, btnSalvarProtocol});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEventoProtocol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescProtocol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboxCucProtocol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxTipoProtocol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoProtocol)
                    .addComponent(btnAtualizarProtocol)
                    .addComponent(btnSalvarProtocol))
                .addContainerGap())
        );

        txtEventoProtocol.setDocument(new FixedLengthDocument(4));
        List<Cuc> list = jpaCuc.findCucEntities();

        if (list.size() > 0) {
            for (Cuc cuc : list) {
                cboxCucProtocol.addItem(cuc);
            }
        }

        jTabbedPane1.addTab("Protocolo", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnSalvarCucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarCucActionPerformed
    String sigla = txtCuc.getText().trim().toUpperCase();
    String desc = txtDescricaoCuc.getText().trim().toUpperCase();
    String som = txtSomCuc.getText().trim();
    String prioridade = "normal";

    if (sigla.length() != 3) {
        JOptionPane.showMessageDialog(null, "Digite o CUC");
        txtCuc.requestFocusInWindow();
    } else {
        if (desc.length() < 5) {
            JOptionPane.showMessageDialog(null, "Digite a descrição");
            txtDescricaoCuc.requestFocusInWindow();
        } else {
            if (rbBaixaCuc.isSelected()) {
                prioridade = "baixa";
            }
            if (rbNormalCuc.isSelected()) {
                prioridade = "normal";
            }
            if (rbMediaCuc.isSelected()) {
                prioridade = "média";
            }
            if (rbAltaCuc.isSelected()) {
                prioridade = "alta";
            }
            if (rbCriticaCuc.isSelected()) {
                prioridade = "crítica";
            }

            String tpEvento = "alarme";

            if (rbAlarmeCuc.isSelected()) {
                tpEvento = "alarme";
            }
            if (rbArmadoCuc.isSelected()) {
                tpEvento = "armado";
            }
            if (rbTesteAutoCuc.isSelected()) {
                tpEvento = "teste automático";
            }
            if (rbDesarmadoCuc.isSelected()) {
                tpEvento = "desarmado";
            }
            if (rbSemControleCuc.isSelected()) {
                tpEvento = "sem controle";
            }
            if (rbRondaCuc.isSelected()) {
                tpEvento = "ronda";
            }

            Cuc cuc = new Cuc();
            cuc.setSigla(sigla);
            cuc.setDescricao(desc);
            cuc.setSom(som);
            cuc.setPrioridade(prioridade.toUpperCase());
            cuc.setTipoEvento(tpEvento.toUpperCase());
            cuc.setAuxiliar(cboxAux.getSelectedItem().toString());

            try {
                jpaCuc.create(cuc);

                JOptionPane.showMessageDialog(null, "CUC cadastrado com sucesso");

                btnNovoActionPerformed(evt);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}//GEN-LAST:event_btnSalvarCucActionPerformed

private void btnSelecionaSomCucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionaSomCucActionPerformed
    if (fileSom.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
        txtSomCuc.setText(fileSom.getSelectedFile().getAbsolutePath());
    }

}//GEN-LAST:event_btnSelecionaSomCucActionPerformed

private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

    Thread t = new Thread(new Runnable() {

        @Override
        public void run() {
            AnnotationResolver resolver = new AnnotationResolver(Cuc.class);
            ObjectTableModel<Cuc> tableModel = new ObjectTableModel<Cuc>(
                    resolver, "sigla,descricao,prioridade,tipoEvento");

            List<Cuc> list = jpaCuc.findCucEntities();

            cboxCucProtocol.removeAllItems();

            if (list.size() > 0) {
                for (Cuc cuc : list) {
                    tableModel.add(cuc);
                    cboxCucProtocol.addItem(cuc);
                }
                //TableFilter filter = new TableFilter(tbCuc.getTableHeader(), tableModel);
                //tbCuc.setModel(filter);
                tbCuc.setModel(tableModel);
                tbCuc.setDefaultRenderer(Object.class, new ColorTableCucRenderer());
            }
        }
    });
    t.start();

    txtCuc.setText("");
    txtCuc.requestFocusInWindow();
    txtDescricaoCuc.setText("");
    txtSomCuc.setText("");
    bgPrioridade.setSelected(rbNormalCuc.getModel(), true);
    bgTipoEvento.setSelected(rbAlarmeCuc.getModel(), true);
    cboxAux.setSelectedIndex(0);

    selectedCuc = null;

    btnSalvarCuc.setEnabled(true);
    btnAtualizarCuc.setEnabled(false);

}//GEN-LAST:event_btnNovoActionPerformed

private void tbCucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCucMouseClicked

    if (evt.getClickCount() == 1) {
        int row = tbCuc.getSelectedRow();

        ObjectTableModel<Cuc> tableModel = (ObjectTableModel<Cuc>) tbCuc.getModel();
        Cuc cuc = tableModel.getValue(row);

        txtCuc.setText(cuc.getSigla());
        txtDescricaoCuc.setText(cuc.getDescricao());
        txtSomCuc.setText(cuc.getSom());
        cboxAux.setSelectedItem(cuc.getAuxiliar());

        Enumeration ePrioridade = bgPrioridade.getElements();

        while (ePrioridade.hasMoreElements()) {
            AbstractButton button = (AbstractButton) ePrioridade.nextElement();
            if (button.getText().toUpperCase().equals(cuc.getPrioridade())) {
                bgPrioridade.setSelected(button.getModel(), true);
            }
        }

        Enumeration eTipoEvento = bgTipoEvento.getElements();

        while (eTipoEvento.hasMoreElements()) {
            AbstractButton button = (AbstractButton) eTipoEvento.nextElement();
            if (button.getText().toUpperCase().equals(cuc.getTipoEvento())) {
                bgTipoEvento.setSelected(button.getModel(), true);
            }
        }

        selectedCuc = cuc;

        btnSalvarCuc.setEnabled(false);
        btnAtualizarCuc.setEnabled(true);
    }

}//GEN-LAST:event_tbCucMouseClicked

private void btnAtualizarCucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarCucActionPerformed
    String sigla = txtCuc.getText().trim().toUpperCase();
    String desc = txtDescricaoCuc.getText().trim().toUpperCase();
    String som = txtSomCuc.getText().trim();
    String prioridade = "normal";

    if (rbBaixaCuc.isSelected()) {
        prioridade = "baixa";
    }
    if (rbNormalCuc.isSelected()) {
        prioridade = "normal";
    }
    if (rbMediaCuc.isSelected()) {
        prioridade = "média";
    }
    if (rbAltaCuc.isSelected()) {
        prioridade = "alta";
    }
    if (rbCriticaCuc.isSelected()) {
        prioridade = "crítica";
    }

    String tpEvento = "alarme";

    if (rbAlarmeCuc.isSelected()) {
        tpEvento = "alarme";
    }
    if (rbArmadoCuc.isSelected()) {
        tpEvento = "armado";
    }
    if (rbTesteAutoCuc.isSelected()) {
        tpEvento = "teste automático";
    }
    if (rbDesarmadoCuc.isSelected()) {
        tpEvento = "desarmado";
    }
    if (rbSemControleCuc.isSelected()) {
        tpEvento = "sem controle";
    }
    if (rbRondaCuc.isSelected()) {
        tpEvento = "ronda";
    }

    selectedCuc.setSigla(sigla);
    selectedCuc.setDescricao(desc);
    selectedCuc.setSom(som);
    selectedCuc.setPrioridade(prioridade.toUpperCase());
    selectedCuc.setTipoEvento(tpEvento.toUpperCase());
    selectedCuc.setAuxiliar(cboxAux.getSelectedItem().toString());

    try {
        jpaCuc.edit(selectedCuc);

        JOptionPane.showMessageDialog(null, "CUC atualizado com sucesso");

        btnNovoActionPerformed(evt);

    } catch (PreexistingEntityException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_btnAtualizarCucActionPerformed

private void btnSalvarProtocolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarProtocolActionPerformed
    String evento = txtEventoProtocol.getText().trim().toUpperCase();
    String desc = txtDescProtocol.getText().trim().toUpperCase();
    Cuc cuc = (Cuc) cboxCucProtocol.getSelectedItem();

    if (evento.length() < 2) {
        JOptionPane.showMessageDialog(null, "Digite o código do evento");
        txtEventoProtocol.requestFocusInWindow();
    } else {
        if (desc.length() < 5) {
            JOptionPane.showMessageDialog(null, "Digite a descrição");
            txtDescProtocol.requestFocusInWindow();
        } else {
            if (cuc == null) {
                JOptionPane.showMessageDialog(null, "Cadastre um CUC");
            } else {
                Protocolo p = new Protocolo();
                p.setEvento(evento);
                p.setDescricao(desc);
                p.setCuc(cuc);
                p.setTipo(cboxTipoProtocol.getSelectedItem().toString());

                try {
                    jpaProtocol.create(p);

                    JOptionPane.showMessageDialog(null, "Protocolo cadastrado com sucesso");

                    btnNovoProtocolActionPerformed(evt);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}//GEN-LAST:event_btnSalvarProtocolActionPerformed

private void btnNovoProtocolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProtocolActionPerformed
    Thread t = new Thread(new Runnable() {

        @Override
        public void run() {
            AnnotationResolver resolver = new AnnotationResolver(Protocolo.class);
            ObjectTableModel<Protocolo> tableModel = new ObjectTableModel<Protocolo>(
                    resolver, "evento,descricao,cuc,tipo");

            List<Protocolo> list = jpaProtocol.findProtocoloEntities();

            for (Protocolo p : list) {
                tableModel.add(p);
            }
            //TableFilter filter = new TableFilter(tbProtocol.getTableHeader(), tableModel);
            //tbProtocol.setModel(filter);
            tbProtocol.setModel(tableModel);
            tbProtocol.setDefaultRenderer(Object.class, new ColorTableProtocolRenderer());
        }
    });
    t.start();

    txtEventoProtocol.setText("");
    txtEventoProtocol.requestFocusInWindow();
    txtDescProtocol.setText("");
    cboxCucProtocol.setSelectedIndex(0);
    cboxTipoProtocol.setSelectedIndex(0);

    selectedProtocol = null;

    btnSalvarProtocol.setEnabled(true);
    btnAtualizarProtocol.setEnabled(false);

}//GEN-LAST:event_btnNovoProtocolActionPerformed

private void tbProtocolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProtocolMouseClicked
    if (evt.getClickCount() == 1) {
        int row = tbProtocol.getSelectedRow();

        ObjectTableModel<Protocolo> tableModel = (ObjectTableModel<Protocolo>) tbProtocol.getModel();
        Protocolo p = tableModel.getValue(row);

        txtEventoProtocol.setText(p.getEvento());
        txtDescProtocol.setText(p.getDescricao());
        cboxCucProtocol.setSelectedItem(p.getCuc());
        cboxTipoProtocol.setSelectedItem(p.getTipo());

        selectedProtocol = p;

        btnSalvarProtocol.setEnabled(false);
        btnAtualizarProtocol.setEnabled(true);
    }
}//GEN-LAST:event_tbProtocolMouseClicked

private void btnAtualizarProtocolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarProtocolActionPerformed
    String evento = txtEventoProtocol.getText().trim().toUpperCase();
    String desc = txtDescProtocol.getText().trim().toUpperCase();
    Cuc cuc = (Cuc) cboxCucProtocol.getSelectedItem();

    if (evento.length() < 2) {
        JOptionPane.showMessageDialog(null, "Digite o código do evento");
        txtEventoProtocol.requestFocusInWindow();
    } else {
        if (desc.length() < 5) {
            JOptionPane.showMessageDialog(null, "Digite a descrição");
            txtDescProtocol.requestFocusInWindow();
        } else {
            if (cuc == null) {
                JOptionPane.showMessageDialog(null, "Cadastre um CUC");
            } else {
                selectedProtocol.setEvento(evento);
                selectedProtocol.setDescricao(desc);
                selectedProtocol.setCuc(cuc);
                selectedProtocol.setTipo(cboxTipoProtocol.getSelectedItem().toString());

                try {
                    jpaProtocol.edit(selectedProtocol);

                    JOptionPane.showMessageDialog(null, "Protocolo atualizado com sucesso");

                    btnNovoProtocolActionPerformed(evt);
                } catch (PreexistingEntityException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}//GEN-LAST:event_btnAtualizarProtocolActionPerformed

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
            java.util.logging.Logger.getLogger(ProtocoloView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProtocoloView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProtocoloView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProtocoloView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ProtocoloView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgPrioridade;
    private javax.swing.ButtonGroup bgTipoEvento;
    private javax.swing.JButton btnAtualizarCuc;
    private javax.swing.JButton btnAtualizarProtocol;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnNovoProtocol;
    private javax.swing.JButton btnSalvarCuc;
    private javax.swing.JButton btnSalvarProtocol;
    private javax.swing.JButton btnSelecionaSomCuc;
    private javax.swing.JComboBox cboxAux;
    private javax.swing.JComboBox cboxCucProtocol;
    private javax.swing.JComboBox cboxTipoProtocol;
    private javax.swing.JFileChooser fileSom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rbAlarmeCuc;
    private javax.swing.JRadioButton rbAltaCuc;
    private javax.swing.JRadioButton rbArmadoCuc;
    private javax.swing.JRadioButton rbBaixaCuc;
    private javax.swing.JRadioButton rbCriticaCuc;
    private javax.swing.JRadioButton rbDesarmadoCuc;
    private javax.swing.JRadioButton rbMediaCuc;
    private javax.swing.JRadioButton rbNormalCuc;
    private javax.swing.JRadioButton rbRondaCuc;
    private javax.swing.JRadioButton rbSemControleCuc;
    private javax.swing.JRadioButton rbTesteAutoCuc;
    private javax.swing.JTable tbCuc;
    private javax.swing.JTable tbProtocol;
    private javax.swing.JTextField txtCuc;
    private javax.swing.JTextField txtDescProtocol;
    private javax.swing.JTextField txtDescricaoCuc;
    private javax.swing.JTextField txtEventoProtocol;
    private javax.swing.JTextField txtSomCuc;
    // End of variables declaration//GEN-END:variables
}
