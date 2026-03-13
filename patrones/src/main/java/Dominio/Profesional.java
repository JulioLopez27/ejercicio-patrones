package Dominio;

import java.util.List;

import Observer.Observable;
import Observer.Observable.Evento;
import Observer.Observador;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Profesional implements Observador {
    private static int idCounter = 1;
    private int idProfesional, documento;
    private String nombre, correo;
    private TipoEspecialidad tipo;
    protected List<Turno> turnos;

    public Profesional(int p_documento, String p_nombre, String p_correo, TipoEspecialidad p_tipo) {
        this.idProfesional = idCounter++;
        this.documento = p_documento;
        this.nombre = p_nombre;
        this.correo = p_correo;
        this.tipo = p_tipo;
        this.turnos = new ArrayList<>();
    }

    public boolean tieneDisponible(LocalDateTime fechaHora) {
        LocalDateTime inicioNuevo = fechaHora.truncatedTo(ChronoUnit.MINUTES);
        LocalDateTime finNuevo = inicioNuevo.plusMinutes(Turno.getDuracionDelTurno());

        for (Turno t : turnos) {
            if (t.getEstado().ocupaHorario()) {
                LocalDateTime inicioExistente = t.getFechaInicio().truncatedTo(ChronoUnit.MINUTES);
                LocalDateTime finExistente = inicioExistente.plusMinutes(Turno.getDuracionDelTurno());

                if (inicioExistente.isBefore(finNuevo) && inicioNuevo.isBefore(finExistente)) {
                    return false;
                }
            }
        }
        return true;
    }

    // el método valida que los nuevos datos de fecha y hora no se choquen entre
    // los datos de hora ya ingresados al turno
    public boolean tieneDisponible(LocalDateTime nuevaFecha, Turno turnoActual) {
        LocalDateTime inicioNuevaFecha = nuevaFecha.truncatedTo(ChronoUnit.MINUTES);
        LocalDateTime finNuevaFecha = inicioNuevaFecha.plusMinutes(Turno.getDuracionDelTurno());
        return turnos.stream()
                .filter(t -> t != turnoActual)
                .filter(t -> t.getEstado().ocupaHorario())
                .noneMatch(t -> t.seSuperpone(inicioNuevaFecha, finNuevaFecha));
    }

    public void asignarTurno(Turno t) {
        this.turnos.add(t);
    }

    public int getIdentificadorSis() {
        return this.idProfesional;
    }

    public int getDocumento() {
        return this.documento;
    }

    public String getNombre() {
        return this.nombre;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    @Override
    public String toString() {
        return "Profesional { " +
                "idProfesional =" + idProfesional +
                ", documento =" + documento +
                ", nombre ='" + nombre + '\'' +
                ", correo ='" + correo + '\'' +
                ", tipo =" + tipo +
                '}';
    }

    @Override
    public void update(Observable o, Evento e) {
        if (e == Evento.Turno_Cancelado) {
            System.out.println("Profesional notificado: turno cancelado. ");
        }
        if (e == Evento.Turno_Reprogramado) {
            System.out.println("Profesional notificado: turno reprogramado. ");
        }
    }

}
