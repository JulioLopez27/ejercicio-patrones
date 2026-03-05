package Dominio;

import Observer.Observable;
import Observer.Observable.Evento;
import Observer.Observador;

public class Paciente implements Observador {

    private String nombre, correo, direccion;
    private int numSocio, documento; // num identificador unico
    private static int contadorSocios = 1;

    // Constructor
    public Paciente(int documento, String nombre, String correo, String direccion) {
        this.documento = documento;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.numSocio = contadorSocios++;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getIdentificadorSis() {
        return numSocio;
    }

    public int getDocumento() {
        return documento;
    }

    @Override
    public String toString() {
        return "Paciente { " +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numSocio=" + numSocio +
                '}';
    }

    @Override
    public void update(Observable o, Evento e) {
       if(e == Evento.Turno_Cancelado){
        System.out.println("Paciente notificado: turno cancelado. ");
       }
       if(e == Evento.Turno_Reprogramado){
        System.out.println("Paciente notificado: turno reprogramado. ");
       }
    }
}
