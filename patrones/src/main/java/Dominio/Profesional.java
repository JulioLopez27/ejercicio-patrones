package Dominio;

import java.util.List;

import Observer.Observable;
import Observer.Observable.Evento;
import Observer.Observador;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Profesional implements Observador{
    private static int idCounter = 1;
    private int idProfesional, dni;
    private String nombre, correo;
    private TipoEspecialidad tipo;
    protected List<Turno> turnos;

    public Profesional(int p_dni, String p_nombre, String p_correo, TipoEspecialidad p_tipo) {
        this.idProfesional = idCounter++;
        this.dni = p_dni;
        this.nombre = p_nombre;
        this.correo = p_correo;
        this.tipo = p_tipo;
        this.turnos = new ArrayList<>();
    }

    public boolean estaDisponible(LocalDateTime fechaHora) {
        for (Turno t : turnos) {
            if (t.getEstado().ocupaHorario() && t.getFechaYHora().equals(fechaHora)) {
                return false;
            }
        }
        return true;
    }

    public void verificiarDisponibilidad() {

    }

    public void asignarTurno(Turno t) {
        this.turnos.add(t);
    }

    public int getId() {
        return this.idProfesional;
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return "Profesional { " +
                "idProfesional=" + idProfesional +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", tipo=" + tipo +
                '}';
    }

      @Override
    public void update(Observable o, Evento e) {
       if(e == Evento.Turno_Cancelado){
        System.out.println("Profesional notificado: turno cancelado. ");
       }
       if(e == Evento.Turno_Reprogramado){
        System.out.println("Profesional notificado: turno reprogramado. ");
       }
    }

}
