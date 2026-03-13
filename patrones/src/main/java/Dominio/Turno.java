package Dominio;

import java.time.LocalDateTime;

import Observer.Observable;

public class Turno extends Observable {
    private static int contadorId = 1;
    private int idTurno;
    private EstadoTurno estado;
    private LocalDateTime fechaYHora;
    // TODO: no olvidar: cambiar a dinamico a futuro.
    private static int DURACION_TURNO_MINUTOS = 30;
    private Paciente paciente;
    private Profesional profesional;

    public Turno(Paciente paciente, Profesional p_profesional, LocalDateTime fechaYHora) {
        this.estado = EstadoTurno.CONFIRMADO; // estado inicial
        this.fechaYHora = fechaYHora;
        this.paciente = paciente;
        this.profesional = p_profesional;
        this.idTurno = contadorId++;

        //al crear un turno, este mismo se asigna al profesional seleccionado(automatico)
        this.profesional.asignarTurno(this);
    }

    // Comportamientos del turno
    public void confirmar() {
        this.estado = estado.confirmar();
    };

    public void cancelar() {
        this.estado = estado.cancelar();
        this.notificar(Evento.Turno_Cancelado);
    };

    public void reprogramar() {
        this.estado = estado.reprogramar();
        this.notificar(Evento.Turno_Reprogramado);
    };

    // getters
    public int getIdTurno() {
        return this.idTurno;
    }

    public EstadoTurno getEstado() {
        return this.estado;
    }

    public LocalDateTime getFechaInicio() {
        return fechaYHora;
    }

    public LocalDateTime getFechaFin() {
        return this.fechaYHora.plusMinutes(getDuracionDelTurno());
    }

    public static int getDuracionDelTurno() {
        return DURACION_TURNO_MINUTOS;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public Profesional getProfesional() {
        return this.profesional;
    }

    public void nuevaFecha(LocalDateTime nuevaFecha) {
        this.modificarPorNuevaFecha(nuevaFecha);
    }

    private void modificarPorNuevaFecha(LocalDateTime nf) {
        this.fechaYHora = nf;
    }

    public boolean seSuperpone(LocalDateTime nuevoInicio, LocalDateTime nuevoFin) {
        return this.getFechaInicio().isBefore(nuevoFin) && nuevoInicio.isBefore(getFechaFin());
    }

    @Override
    public String toString() {
        return "Turno { " +
                "id = '" + this.getIdTurno() + '\'' +
                "paciente = '" + paciente.getNombre() + '\'' +
                ", profesional = '" + profesional.getNombre() + '\'' +
                ", fecha = '" + this.getFechaInicio() + '\'' +
                ", estado= '" + this.getEstado() +
                '}';

    }

}
