package Dominio;

import java.time.LocalDateTime;

public class Turno {
    private static int contadorId = 1;
    private int idTurno;
    private EstadoTurno estado;
    private LocalDateTime fechaYHora;
    private Paciente paciente;
    private Profesional profesional;

    public Turno(Paciente paciente, Profesional p_profesional, LocalDateTime fechaYHora) {
        this.estado = EstadoTurno.CONFIRMADO; // estado inicial
        this.fechaYHora = fechaYHora;
        this.paciente = paciente;
        this.profesional = p_profesional;
        this.idTurno = contadorId++;
    }

    // Comportamientos del turno
    public void confirmar() {
        this.estado = estado.confirmar();
    };

    public void cancelar() {
        this.estado = estado.cancelar();
        this.notificar(Eventos.Turno_Cancelado);
    };

    public void reprogramar() {
        this.estado = estado.reprogramar();
        this.notificar(Eventos.Turno_Reprogramado);
    };

    // getters
    public int getIdTurno() {
        return this.idTurno;
    }

    public EstadoTurno getEstado() {
        return this.estado;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public Profesional getProfesional() {
        return this.profesional;
    }

    @Override
    public String toString() {
        return "Turno { " +
                "paciente = '" + paciente.getNombre() + '\'' +
                ", profesional = '" + profesional.getNombre() + '\'' +
                ", fecha = '" + this.getFechaYHora() + '\'' +
                ", estado= '" + this.getEstado() +
                '}';

    }

    // Implementacion OBSERVER


}
