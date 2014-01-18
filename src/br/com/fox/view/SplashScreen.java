package br.com.fox.view;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.awt.*;
import javax.swing.*;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author Dvr
 */
public class SplashScreen extends JWindow {

    private int duration;

    public SplashScreen(int d) {
        duration = d;
    }

// Este é um método simples para mostrar uma tela de apresentção
// no centro da tela durante a quantidade de tempo passada no construtor
    public void showSplash() {
        JPanel content = (JPanel) getContentPane();
        content.setBackground(Color.white);

        // Configura a posição e o tamanho da janela
        int width = 608;
        int height = 385;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

        // Constrói o splash screen
        JLabel label = new JLabel(new ImageIcon(getClass().getResource("/br/com/icones/splash.png")));
        JLabel copyrt = new JLabel("Copyright 2012, Grupo Fox", JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        Color oraRed = Color.BLUE;
        content.setBorder(BorderFactory.createLineBorder(oraRed, 1));
        // Torna visível
        setVisible(true);

        // Espera ate que os recursos estejam carregados
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
        }
        setVisible(false);
    }

    public void showSplashAndExit() {
        showSplash();
        dispose();
    }

    public static void main(String[] args) {

        NativeInterface.open();
        
        NativeLibrary.addSearchPath(
                RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files (x86)\\VideoLAN\\VLC");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        
        System.setProperty("jna.dump_memory", "false");
        
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

        // Mostra uma imagem com o título da aplicação
        SplashScreen splash = new SplashScreen(2000);
        splash.showSplashAndExit();
        
        Login l = new Login();
        l.pack();
        l.setVisible(true);
        
        NativeInterface.runEventPump();
    }
}
