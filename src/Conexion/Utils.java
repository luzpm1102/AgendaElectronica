/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marco
 */
public class Utils {
          public static DefaultTableModel queryTabla( String nombreT, String [] columnas, String buscar, int condicion, String id  ) {
      DefaultTableModel tabla = new DefaultTableModel();
      int numCol = columnas.length;
      try {
          String tsql = "select * from " + nombreT + " where "+ columnas[condicion] +" like '%" + buscar + "%'" ;
          tsql += " and " + id;
          System.out.println(tsql);
          Conexion conex = new Conexion();
          ResultSet res;
          Statement st = null;
          Connection conn = conex.getConexion();
          
          st = conn.createStatement();
          res = conex.Listar(tsql);
          
          
          tabla.setColumnIdentifiers(columnas);
          
          while (res.next()) {
              Object obj[] = new Object[numCol];
              for( int i = 0 ; i < numCol ; i ++) {
                  obj[i] = res.getString( columnas[i] );
              }
              tabla.addRow(obj);
          }
          
          
          
      }
      catch (Exception e) {
          
      }
      
      
      return tabla;
  }
    
  
    public static DefaultTableModel queryTabla( String nombreT, String [] columnas, String buscar, int condicion  ) {
      DefaultTableModel tabla = new DefaultTableModel();
      int numCol = columnas.length;
      try {
          String tsql = "select * from " + nombreT + " where "+ columnas[condicion] +" like '%" + buscar + "%'" ;
          System.out.println(tsql);
          Conexion conex = new Conexion();
          ResultSet res;
          Statement st = null;
          Connection conn = conex.getConexion();
          
          st = conn.createStatement();
          res = conex.Listar(tsql);
          
          
          tabla.setColumnIdentifiers(columnas);
          
          while (res.next()) {
              Object obj[] = new Object[numCol];
              for( int i = 0 ; i < numCol ; i ++) {
                  obj[i] = res.getString( columnas[i] );
              }
              tabla.addRow(obj);
          }
          
          
          
      }
      catch (Exception e) {
          System.out.println(e);
      }
      
      
      return tabla;
  }
    
  public static DefaultTableModel queryTablaAll( String nombreT, String [] columnas ) {
      DefaultTableModel tabla = new DefaultTableModel();
      int numCol = columnas.length;
      try {
          String tsql = "select * from " + nombreT ;
          Conexion conex = new Conexion();
          ResultSet res;
          Statement st = null;
          Connection conn = conex.getConexion();
          
          st = conn.createStatement();
          res = conex.Listar(tsql);
          String [] remappedColumnas = columnas;
          for (int i = 0; i < remappedColumnas.length; i += 1) {
              remappedColumnas[i] = remappedColumnas[i].substring(0, 1).toUpperCase() + remappedColumnas[i].substring(1);
          }
          
          tabla.setColumnIdentifiers(remappedColumnas);
          
          while (res.next()) {
              Object obj[] = new Object[numCol];
              for( int i = 0 ; i < numCol ; i ++) {
                  obj[i] = res.getString( remappedColumnas[i] );
              }
              tabla.addRow(obj);
          }
          
          
          
      }
      catch (Exception e) {
          
      }
      
      return tabla;
  }
  
  public static int actualizarTabla ( String nombreT, String valores, String id ) {
      int band = 0;
      Conexion conex = new Conexion();
      int rs;
      Statement st = null;
      Connection conn = conex.getConexion();
      
      String consulta = "Update "+ nombreT + " set " + valores + " where " + id ;
      
      System.out.println(consulta);
      
      
 
      try {
          st = conn.createStatement();
          rs = st.executeUpdate(consulta);
          conn.commit();
          if ( rs==1 ) {
              band=1;
          }
      }
      catch (Exception owo) {
          System.out.println(owo.getMessage());
          
      }
      return band;
  
  } 
  public static int eliminarTabla( String nombreT, String condicion) {
      
       int band = 0;
      Conexion conex = new Conexion();
      int rs;
      Statement st = null;
      Connection conn = conex.getConexion();
      
      String consulta = "delete from "+ nombreT + " where " + condicion ;
      
      System.out.println(consulta);
      
      
 
      try {
          st = conn.createStatement();
          rs = st.executeUpdate(consulta);
          conn.commit();
          if ( rs==1 ) {
              band=1;
          }
      }
      catch (Exception owo) {
          System.out.println(owo.getMessage());
          
      }
      return band;
      
      
  }
  
  public static int insertarTabla ( String nombreT, String columnas [], String valores[] ) {
      int band = -1;
      Conexion conex = new Conexion();
      int rs;
      Statement st = null;
      Connection conn = conex.getConexion();
      
      String consulta = "Insert into "+ nombreT + " (" ;
      
      for (int i = 0; i < columnas.length; i++) {
          if ( i > 0 ) {
               consulta += ", ";
          }
           consulta += columnas[i];
      }
      consulta+=") values (";
      
      for (int i = 0; i < valores.length; i++) {
          if ( i > 0 ) {
               consulta += ", ";
          }
           consulta += "'";
           consulta += valores[i];
           consulta += "'";
          
      }
      consulta+=")";
      
      
      
     System.out.println(consulta);
      try {
          st = conn.createStatement();
          rs = st.executeUpdate(consulta, Statement.RETURN_GENERATED_KEYS);
          if ( rs==1 ) {
              band = 0;
            try (ResultSet llave = st.getGeneratedKeys()) {
                if (llave.next()) {
                   band = llave.getInt(1);
               }
            }
            conn.commit();  
          }
          
      }
      catch (Exception owo) {
          System.out.println(owo.getMessage());
          
      }
      return band;
  
  } 
}


