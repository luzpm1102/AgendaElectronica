/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author LUZPM1102
 */
public class Contacto {
    
    private int idContacto; 
    private String Nombres; 
    private String Apellidos; 
    private String Dirección; 
    private String Telefono; 
    private String Móvil; 
    private String Email;

    public Contacto() {
    }

    public Contacto(int idContacto, String Nombres, String Apellidos, String Dirección, String Telefono, String Móvil, String Email) {
        this.idContacto = idContacto;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Dirección = Dirección;
        this.Telefono = Telefono;
        this.Móvil = Móvil;
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDirección() {
        return Dirección;
    }

    public void setDirección(String Dirección) {
        this.Dirección = Dirección;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getMóvil() {
        return Móvil;
    }

    public void setMóvil(String Móvil) {
        this.Móvil = Móvil;
    }
    
}
