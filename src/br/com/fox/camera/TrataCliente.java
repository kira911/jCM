/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fox.camera;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author Dvr
 */
class TrataCliente extends Thread {

    private Socket client;

    public TrataCliente(Socket s) {
        client = s;
    }

    public void run() {
        try {
            // aqui vai a sua comunicacao com o cliente  
            ObjectInputStream oi = new ObjectInputStream(client.getInputStream());

            System.out.println("Chegou isso:" + oi.readObject());

            client.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
