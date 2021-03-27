/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

import View.Chat;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William
 */
public class TreatFiles extends Arquivos {

    private String pathName;
    private String fileName;     
    private byte[] fileBytes = null;
    
    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }


    //Não usado ainda private String fileName; public String getFileName() {
     public void setFileName(String fileName) { 
        String[] pointArr = fileName.split("[.]");
        String withoutFormat = pointArr[pointArr.length-1];
        withoutFormat = fileName.replace("."+withoutFormat,"");
        this.fileName = withoutFormat;
     }
      
    public String getFileName() {      
        return fileName;
    }    

    // Gerar soma hash de arquivo 
    public String getHashedNameFile() {
        String hash = "";
        try {
            MessageDigest md;
            md = MessageDigest.getInstance("MD5");
            md.update(fileBytes);
            System.out.println();
            BigInteger hashInt = new BigInteger(1, md.digest());
            hash = hashInt.toString(16);
        } catch (NullPointerException | NoSuchAlgorithmException e) {

        } 
        return hash;
    }

    // Pegar formato do arquivo a partir do seu endereço de máquina local
    public String getFileFormat() {
        String[] fomartFile = pathName.split("[.]");
        String format = fomartFile[fomartFile.length - 1];
        return format;
    }

    // Pegar formato do arquivo a partir do seu nome que foi transformado em hash
    public String getFileHashedFormat() {
        String[] fomartFile = getHashArquivo().split("[.]");
        String format = fomartFile[fomartFile.length - 1];
        return format;
    }

    // Salvar arquivo renomeado para o nome original
    public void saveRenomedFile() throws IOException {
        // Nome
        String name = getNomeArquivo();
        // Formato
        String format = getFileHashedFormat();
        // Arquivo
        byte[] file = getArquivo();

        new File("Files").mkdir();
        new File("Files/Received").mkdir();
        new File("Files/Received/" + format).mkdir();
        Path path = Paths.get("Files/Received/" + format + "/" + name + "." + format);
        setPathName(path.toString());
        System.out.println(path);

        try {
            java.nio.file.Files.write(path, file);
        } catch (IOException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Coletar bytes[] a partir de arquivo localizado na própria maquina
    public void setBytes(String pathName) throws IOException {
        this.pathName = pathName;
            this.fileBytes = java.nio.file.Files.readAllBytes(Paths.get(pathName));
    }
    
    public byte[] getBytes() {
        return fileBytes;
    }        

}
