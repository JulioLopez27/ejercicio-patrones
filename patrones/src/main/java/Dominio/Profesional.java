package Dominio;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Profesional {
    private int idProfesional;
    private String nombre;
    private String correo;
    protected List<Turno> turnos;


    protected Profesional(String p_nombre, String p_correo) {
        this.nombre = p_nombre;
        this.correo = p_correo;
        this.turnos = new ArrayList<>();
    }

    public boolean estaDisponible(LocalDateTime fechaHora){
        for(Turno t: turnos){
            if(t.getEstado().ocupaHorario() && t.getFechaYHora().equals(fechaHora)){
                return false;
            }
        }
        return true;
    }

    public abstract void verificiarDisponibilidad();

    public abstract void asignarTurno();

    public int getId() {
        return this.idProfesional;
    }

}
