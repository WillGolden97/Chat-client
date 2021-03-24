/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

import ConnectionFactory.Server;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Communication;

/**
 *
 * @author William
 */
public class SendMessage implements Runnable {

    private TreatFiles currentFile;
    private Message msg;
    Server server;
    Communication communication;

    public SendMessage(Message Message, TreatFiles currentFile) throws IOException, ClassNotFoundException {
        this.server = new Server();
        communication = new Communication("CHECKFILE");
        this.msg = Message;
        this.currentFile = currentFile;
    }
       

    @Override
    public void run() {
        try {
            String hashName = "";
            try {
                msg.setNomeArquivo(currentFile.getFileName());
                hashName = currentFile.getHashedNameFile() + "." + currentFile.getFileFormat();
                msg.setHashArquivo(hashName);
            } catch (NullPointerException ex) {
                System.out.println("Sem anexo");
            }
            try {
                communication.setParam("nomeHash", hashName);
                communication = server.outPut_inPut(communication);
                int checkFile = (int) communication.getParam("CHECKFILEREPLY");
                if (checkFile == 0) {
                    msg.setArquivo(currentFile.getBytes());
                }
                communication = new Communication("CREATEMESSAGE");
                communication.setParam("SENDEDMESSAGE", msg);
                communication = server.outPut_inPut(communication);
                System.out.println(communication.getParam("STATUSMESSAGE"));
            } catch (IOException ex) {
                Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

