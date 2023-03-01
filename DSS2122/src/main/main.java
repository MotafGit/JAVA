/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Presentation.Login;
import Java.Carro;
import Java.Despesa;
import Java.Utilizador;
import java.sql.SQLException;
import javax.swing.JFrame;



public class main {
    
    public static void main(String args[]) throws SQLException {
        Carro a = new Carro();
        Login f = new Login(a);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
        
    }
}
