package Dominio;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Profesional {
    private int idProfesional;
    private String nombre;
    private String correo;
    private List<Turno> turnos;

    public Profesional() {
    }

    public Profesional(String p_nombre, String p_correo) {
        this.nombre = p_nombre;
        this.correo = p_correo;
        this.turnos = new ArrayList<>();
    }

    public abstract boolean estaDisponible(LocalDateTime fechaHora);

    public abstract void verificiarDisponibilidad();

    public abstract void asignarTurno();

    public int getId() {
        return this.idProfesional;
    }

}
