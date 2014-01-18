package br.com.fox.camera;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Dvr
 */
public class SomEventos implements Runnable {

    private AudioClip clip;
    private int qtdNot = 0;
    private int qtdItem;
    private File file;

    public SomEventos() {
    }

    public int getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(int qtdItem) {
        this.qtdItem = qtdItem;
    }

    public int getQtdNot() {
        return qtdNot;
    }

    public void setQtdNot(int qtdNot) {
        this.qtdNot = qtdNot;
    }
    
    @Override
    public void run() {
        while (true) {
            try {

                if (qtdItem > 0 && qtdNot >= 0 && qtdNot <= 1) {
                    file = new File("sons/alm1.wav");

                    clip = Applet.newAudioClip(file.toURL());

                    clip.play();

                    Thread.sleep(4000);

                    qtdNot++;
                } else {
                    if (qtdItem > 0 && qtdNot >= 2 && qtdNot <= 3) {
                        file = new File("sons/alm2.wav");

                        clip = Applet.newAudioClip(file.toURL());

                        clip.play();

                        Thread.sleep(6000);

                        qtdNot++;
                    } else {
                        if (qtdItem > 0 && qtdNot >= 4) {
                            file = new File("sons/alm3.wav");

                            clip = Applet.newAudioClip(file.toURL());

                            clip.play();

                            Thread.sleep(8000);

                            qtdNot++;
                        }
                    }
                }

                if (qtdItem == 0) {
                    qtdNot = 0;
                }



            } catch (InterruptedException ex) {
                Logger.getLogger(SomEventos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(SomEventos.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
        }
    }
}
