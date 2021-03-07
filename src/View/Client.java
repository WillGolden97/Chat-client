/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Message;

/**
 *
 * @author William
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Chat chat = new Chat();

            while (true) {
                Socket socket = new Socket("localhost", 2134);
                ObjectOutputStream outPut = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                String msg = "HELLO";
                outPut.writeUTF(msg);

                outPut.flush();

                Message message = (Message) input.readObject();
                msg = message.getMessage();
                chat.setVisible(true);
                chat.setCaixadeEntrada("Resposta : " + msg);

                outPut.close();
                input.close();
                socket.close();
            }               

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//          } catch (ClassNotFoundException ex) {
//          Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
    }

}
