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
import util.Messages;

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

    public Server(String address, int door) throws IOException, ClassNotFoundException {
        this.address = address;
        this.door = door;  
    }
    
    public Server() throws IOException, ClassNotFoundException {
    
    }   

    public Messages outPut_inPut(Messages m) throws IOException, ClassNotFoundException {
        socket = new Socket(address, door);          
        outPut = new ObjectOutputStream(socket.getOutputStream());
        outPut.writeObject(m);
        outPut.flush();
        Messages messages;
        input = new ObjectInputStream(socket.getInputStream());
        messages = (Messages) input.readObject();
        close();   
        return messages;        
    }
    
    public void outPut(Messages m) throws IOException, ClassNotFoundException {
        socket = new Socket(address, door);  
        outPut = new ObjectOutputStream(socket.getOutputStream());
        outPut.writeObject(m);
        outPut.flush();      
    } 
    
    public Messages inPut(Messages m) throws IOException, ClassNotFoundException {
        Messages messages;
        input = new ObjectInputStream(socket.getInputStream());
        messages = (Messages) input.readObject();
        close();   
        return messages;        
    }    

    private void close() throws IOException, ClassNotFoundException {
        outPut.close();
        input.close();
        socket.close();
    }
}
