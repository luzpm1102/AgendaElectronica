/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author marco
 */
public class Conexion {
           // Connection to database
    public Connection getConexion() {
       // String url = "jdbc:sqlserver://mssql.db.server\\\\mssql_instance;databaseName=AgendaPoo2";
       try{
        String url = "jdbc:sqlserver://localhost:1433;" +
                                   "Databasename=AgendaPoo2; " +
                                   "user=sa; password=123456789asd; ";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.out.println("Connected to Database");
        return(DriverManager.getConnection(url));
       } catch (Exception e) {
        System.err.format("Err State: %s\n%s", e.getMessage());
        System.out.println("Could not connect to database");
       }
       return null;
    }
    public ResultSet Listar (String sql){
        Statement st = null;
        ResultSet rs = null;
        
        try {
            Connection conn = this.getConexion();
            st =conn.createStatement();
            rs=st.executeQuery(sql);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rs;
    }
}
