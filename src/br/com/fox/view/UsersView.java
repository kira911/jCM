package br.com.fox.view;

import br.com.fox.controller.AuthoritiesJpaController;
import br.com.fox.controller.UsersJpaController;
import br.com.fox.controller.exceptions.PreexistingEntityException;
import br.com.fox.db.Authorities;
import br.com.fox.db.Users;
import br.com.fox.util.Config;
import br.com.fox.util.MailJava;
import br.com.fox.util.MailJavaSender;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class UsersView extends javax.swing.JFrame {

    private Config config;
    private UsersJpaController jpaUsers = new UsersJpaController();
    private AuthoritiesJpaController jpaAuthorities = new AuthoritiesJpaController();

    public UsersView(Config config) {
        this.config = config;
        
        initComponents();
        this.setLocationRelativeTo(null);
        bgAutho.add(rbAdmin);
        bgAutho.add(rbOperador);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgAutho = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        rbAdmin = new javax.swing.JRadioButton();
        rbOperador = new javax.swing.JRadioButton();
        btnSalvar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de usuários");
        setIconImage(new ImageIcon(getClass().getResource("/br/com/icones/Office64.png")).getImage());
        setResizable(false);

        jLabel1.setText("Username:");

        jLabel2.setText("Senha:");

        jLabel3.setText("Email:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Permissões"));

        rbAdmin.setText("Administrador");

        rbOperador.setSelected(true);
        rbOperador.setText("Operador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(rbOperador)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAdmin)
                    .addComponent(rbOperador))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.setEnabled(false);

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(btnSair)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAtualizar, btnSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAtualizar)
                        .addComponent(btnSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
    dispose();
}//GEN-LAST:event_btnSairActionPerformed

private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
    String username = txtUsername.getText().trim().toLowerCase();
    String senha = String.valueOf(txtSenha.getPassword());
    String email = txtEmail.getText().trim();

    Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
    Matcher m = p.matcher(email);
    boolean matchFound = m.matches();

    if (matchFound) {
        if (username.length() < 3) {
            JOptionPane.showMessageDialog(null, "Digite o username");
            txtUsername.requestFocusInWindow();
        } else {
            if (senha.length() < 5) {
                JOptionPane.showMessageDialog(null, "Digite no mínimo 6 caracteres");
                txtSenha.requestFocusInWindow();
            } else {
                Users u = new Users();
                u.setUsername(username);
                u.setEmail(email);

                MessageDigest md;
                try {
                    md = MessageDigest.getInstance("MD5");
                    md.update(senha.getBytes());
                    byte[] bytes = md.digest();

                    StringBuilder s = new StringBuilder();
                    for (int i = 0; i < bytes.length; i++) {
                        int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
                        int parteBaixa = bytes[i] & 0xf;
                        if (parteAlta == 0) {
                            s.append('0');
                        }
                        s.append(Integer.toHexString(parteAlta | parteBaixa));
                    }

                    u.setPassword(s.toString());

                } catch (NoSuchAlgorithmException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Ocorreu um erro ao criar sua senha\nUma nova senha foi criada",
                            "ERRO",
                            JOptionPane.ERROR_MESSAGE);

                    senha = "123456";
                    u.setPassword("e10adc3949ba59abbe56e057f20f883e");
                }

                Authorities a = new Authorities();
                a.setUsername(u);

                if (rbOperador.isSelected()) {
                    a.setAuthority("operador");
                } else {
                    a.setAuthority("administrador");
                }
                try {
                    jpaUsers.create(u);
                    jpaAuthorities.create(a);

                    MailJava mj = new MailJava();
                    mj.setTypeTextMail(MailJava.TYPE_TEXT_PLAIN);
                    mj.setSmtpHostMail(config.getSmtpHostEmail());
                    mj.setSmtpPortMail(String.valueOf(config.getSmtpPortEmail()));
                    mj.setSmtpAuth("true");
                    mj.setSmtpStarttls("true");
                    mj.setUserMail(config.getUserEmail());
                    mj.setPassMail(config.getPassEmail());
                    mj.setSubjectMail("Senha do sistema");
                    mj.setBodyMail("Senha de acesso: " + senha + "\nPermissao: " + a.getAuthority());

                    HashMap<String, String> listDest = new HashMap<String, String>();
                    listDest.put(email, username);

                    mj.setToMailsUsers(listDest);

                    MailJavaSender sender = new MailJavaSender();
                    sender.senderMail(mj);

                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");

                    txtUsername.setText("");
                    txtSenha.setText("");
                    rbAdmin.setSelected(false);
                    rbOperador.setSelected(true);
                    txtUsername.requestFocusInWindow();

                } catch (PreexistingEntityException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Email inválido");
        txtEmail.requestFocusInWindow();
    }

}//GEN-LAST:event_btnSalvarActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UsersView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsersView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsersView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsersView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new UsersView(new Config()).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgAutho;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbAdmin;
    private javax.swing.JRadioButton rbOperador;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

}
