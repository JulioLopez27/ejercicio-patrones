package Dominio;

import java.util.List;
import java.util.ArrayList;

public abstract class Profesional {
    private String nombre;
    private String correo;
    private List<Turno> turnos;

    public Profesional() {}

    public Profesional(String p_nombre, String p_correo) {
        this.nombre = p_nombre;
        this.correo = p_correo;
        this.turnos = new ArrayList<>();
    }

public abstract void verificiarDisponibilidad();
public abstract void asignarTurno();
}
