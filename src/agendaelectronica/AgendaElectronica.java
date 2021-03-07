/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaelectronica;

import GUI.Login;
import Conexion.Conexion;
import java.sql.Connection;
/**
 *
 * @author LUZPM1102
 */
public class AgendaElectronica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       Login l = new Login();
       l.setVisible(true);
       // Conexion conex = new Conexion();
       // Connection conn = conex.getConexion();
        
        
    }
    
}
