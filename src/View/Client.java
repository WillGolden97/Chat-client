/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.formdev.flatlaf.FlatDarkLaf;
import java.util.logging.Level;
import java.io.IOException; 
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
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
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }        
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

        } catch (ConnectException ex) {
            JOptionPane.showMessageDialog(null,"Erro na conexão!");
            System.exit(0);
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
