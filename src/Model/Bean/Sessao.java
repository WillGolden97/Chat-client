/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Bean;


/**
 *
 * @author William
 */
public class Sessao {
    private static String token;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        Sessao.token = token;
    }
    
}
