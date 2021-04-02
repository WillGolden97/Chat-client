/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import util.Communication;

/**
 *
 * @author William
 */
public class Server {

    private Socket socket;
    private ObjectOutputStream outPut;
    private ObjectInputStream input;
    private static String address;
    private static int door;

    public Server(String address, int door) {
        this.address = address;
        this.door = door;
    }

    public Server() {

    }

    public Communication outPut_inPut(Communication m) {
        Communication messages = null;
        try {
            socket = new Socket(address, door);
            outPut = new ObjectOutputStream(socket.getOutputStream());
            outPut.writeObject(m);
            outPut.flush();
            input = new ObjectInputStream(socket.getInputStream());
            messages = (Communication) input.readObject();
            close();
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! \n" + ex);
        }
        return messages;
    }

    public void outPut(Communication m) {
        try {
            socket = new Socket(address, door);
            outPut = new ObjectOutputStream(socket.getOutputStream());
            outPut.writeObject(m);
            outPut.flush();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! \n" + ex);
        }

    }

    public Communication inPut(Communication m) {
        Communication messages = null;
        try {
            input = new ObjectInputStream(socket.getInputStream());
            messages = (Communication) input.readObject();
            close();
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! \n" + ex);
        }
        return messages;
    }

    public void close() throws IOException, ClassNotFoundException {
        outPut.close();
        input.close();
        socket.close();
    }
}
