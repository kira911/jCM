package br.com.fox.camera;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Dvr
 */
public class ServerSocketRouter implements Runnable {

    private BufferedReader read = null;
    private Socket socket = null;
    private ServerSocket server = null;
    private JList list;
    
    public ServerSocketRouter() {
    }

    public ServerSocketRouter(JList list) {
        this.list = list;
    }
    
    @Override
    public void run() {
        try {
            server = new ServerSocket(9545, 1, InetAddress.getLocalHost());

            System.out.println("Servidor aguardando conexao..");

            DefaultListModel<SinalRouter> listModel = new DefaultListModel<SinalRouter>();
            while (true) {
                socket = server.accept();

                InputStream entrada = socket.getInputStream();
                read = new BufferedReader(new InputStreamReader(entrada));

                String sinal = read.readLine();

                String ini = sinal.substring(0, 10);
                String ori = sinal.substring(10, 11);
                String idr = sinal.substring(11, 17);
                String nor = sinal.substring(17, 67);
                String cod = sinal.substring(67, 77);
                String dat = sinal.substring(77, 97);
                String nuc = sinal.substring(97, 100);
                String apl = sinal.substring(100, 110);
                String ins = sinal.substring(110, 112);
                String org = sinal.substring(112, 117);
                String ext = sinal.substring(117);

                SinalRouter sr = new SinalRouter();
                sr.setIni(ini.trim());
                sr.setOri(ori.trim());
                sr.setIdr(idr.trim());
                sr.setNor(nor.trim());
                sr.setCod(cod.trim());
                sr.setDat(dat.trim());
                sr.setNuc(nuc.trim());
                sr.setApl(apl.trim());
                sr.setIns(ins.trim());
                sr.setOrg(org.trim());
                sr.setExt(ext.trim());

                listModel.addElement(sr);
                
                list.setModel(listModel);                
            }

        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerSocketRouter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerSocketRouter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                read.close();
                socket.close();
                server.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerSocketRouter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
