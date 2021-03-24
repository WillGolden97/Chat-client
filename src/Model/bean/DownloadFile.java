/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

import ConnectionFactory.Server;
import View.Chat;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Communication;

/**
 *
 * @author William
 */
public class DownloadFile implements Runnable {
    private final String hash; 
    private String pathName;    
    
    public DownloadFile (String hash) {
       this.hash = hash;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    @Override
    public void run() {
        //Instanciando objeto que manipula arquivos
        TreatFiles tf = new TreatFiles();
        setPathName("");
        try {
            // Abrir conexão socket
            Server server = new Server();
            // Instanciando objeto de comunicação com o servidor
            Communication communication = new Communication("DOWNLOADFILE");
            //Instanciando objeto que receber propriedade dos arquivo
            Arquivos arquivos;
            //Coletando nome hash do arquivo
            String hashName = hash;
            // Setando valor como paramento para coleta com o BD
            communication.setParam("nomeHash", hashName);
            // Enviado comunicação parametrada, para servidor
            communication = server.outPut_inPut(communication);
            // Coletando informações retornada do servidor
            arquivos = (Arquivos) communication.getParam("DOWNLOADFILEREPLY");
            // Setando valor retornado do para o objeto de manipulação de arquivos
            tf.setNomeArquivo(arquivos.getNomeArquivo());
            tf.setHashArquivo(arquivos.getHashArquivo());
            tf.setArquivo(arquivos.getArquivo());
            // Salvando arquivo em diretorio responsável pelo download de arquivo do cliente
            tf.saveRenomedFile();
            // Abrindo arquivo
            setPathName(tf.getPathName());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
}
