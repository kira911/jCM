package br.com.fox.eventos;

import br.com.fox.db.Cliente;
import br.com.fox.db.SinalRouter;
import br.com.fox.util.Config;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Dvr
 */
public class CaptureSnapShots implements Runnable {

    private Config config;
    private JLabel snapshots;
    private SinalRouter sr;
    private Cliente cliente;
    private boolean stopThread = true;

    public CaptureSnapShots(JLabel snapshots, SinalRouter sr, Cliente cliente, Config config) {
        this.snapshots = snapshots;
        this.sr = sr;
        this.cliente = cliente;
        this.config = config;
    }

    public void setStopThread(boolean stopThread) {
        this.stopThread = stopThread;
    }

    @Override
    public void run() {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        String fdate = dateFormat.format(sr.getDat()).replace("/", "").replace(":", "").substring(0, 8);
        String fhora = dateFormat.format(sr.getDat()).replace("/", "").replace(":", "").substring(9);
        int i = 0;
        boolean save = true;

        while (stopThread) {
            try {
                String path = config.getPathRouterSnapshot() + "\\"
                        + sr.getCodCli().getCodCli() + "_0"
                        + sr.getIns() + "_"
                        + fdate + "_"
                        + fhora + "_"
                        + String.format ("%02d", sr.getNuc())
                        + "_0"
                        + i + ".JPG";
                
                BufferedImage imagem = ImageIO.read(new File(path));
                snapshots.setIcon(new ImageIcon(imagem));
                Thread.sleep(500);

                if (save) {
                    String pasta = config.getPathDestSnapshot();
                    File dir = new File(pasta + "\\" + cliente.getNome());
                    dir.mkdirs();
                    File subDir = new File(dir.getPath() + "/" + fdate);
                    subDir.mkdirs();

                    FileOutputStream file = new FileOutputStream(new File(subDir, fhora + "_" + i + ".jpg"));
                    file.write(getData(imagem));
                    file.close();
                }

                if (i < 4) {
                    i++;
                } else {
                    save = false;
                    i = 0;
                }

            } catch (InterruptedException ex) {
                //System.out.println(ex.getMessage());
            } catch (java.lang.NullPointerException ex) {
                //System.out.println(ex.getMessage());
            } catch (IOException ex) {
                //System.out.println(ex.getMessage());
            }
        }
    }

    private byte[] getData(BufferedImage bi) {
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        try {
            ImageIO.write(bi, "JPG", buff);
        } catch (IOException ex) {
            Logger.getLogger(CaptureSnapShots.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] bytes = buff.toByteArray();

        return bytes;
    }
}
