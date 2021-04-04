/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import ConnectionFactory.Server;
import View.Login;
import static java.awt.Color.GREEN;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Communication;

/**
 *
 * @author William
 */
public class CreateNewAccount implements Runnable {

    private Server server;
    private String replyLogin = "";
    private final byte[] picture;
    private final String format;
    private final String name;
    private final String nickName;
    private final String password;

    public CreateNewAccount(byte[] picture, String format, String name, String nickName, String password) {
        this.picture = picture;
        this.format = format;
        this.name = name;
        this.nickName = nickName;
        this.password = password;
    }

    public static String getHashMd5(String value) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        BigInteger hash = new BigInteger(1, md.digest(value.getBytes()));
        return hash.toString(16);
    }

    @Override
    public void run() {
        String hashPassword;
        server = new Server();
        Communication message = new Communication("CREATEACCOUNT");
        hashPassword = getHashMd5(nickName + password);
        try {
            message.setParam("picture", picture);
            message.setParam("format", format);
        } catch (NullPointerException ex) {
            System.out.print("Sem foto :" + ex);
        }
        message.setParam("name", name);
        message.setParam("nickName", nickName);
        message.setParam("password", hashPassword);
        replyLogin = (String) server.outPut_inPut(message).getParam("CREATEACCOUNTREPLY");
        if (replyLogin.equals("OK")) {
            try {
                Login l = new Login();
                l.setMessageLogin("Conta criada com sucesso!");
                l.setMessageLoginColor(GREEN);
                l.setVisible(true);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CreateNewAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                Login l = new Login();
                l.setMessageLogin(replyLogin);
                l.setVisible(true);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CreateNewAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
