/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

public class Evento {
    
    private int idEvento; 
    private String Lugar; 
    private String Fecha; 
    private String Hora; 


    public Evento() {
    }

    public Evento(int idEvento, String Lugar, String Fecha, String Hora) {
        this.idEvento = idEvento;
        this.Lugar = Lugar;
        this.Fecha = Fecha;
        this.Hora = Hora;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String Lugar) {
        this.Lugar = Lugar;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

   
    
}
