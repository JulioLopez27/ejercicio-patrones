package Dominio;

import java.time.LocalDateTime;

public class Turno {
    private int idTurno;
    private EstadoTurno estado;
    private LocalDateTime FechaYHora;
    private Paciente paciente;
    private Profesional doctor;

    public Turno(Paciente paciente, Profesional doctor, LocalDateTime fechaYHora) {
        this.estado = EstadoTurno.CONFIRMADO; //estado inicial
        FechaYHora = fechaYHora;
        this.paciente = paciente;
        this.doctor = doctor;
    }

    // Comportamientos del turno
    public void confirmar() {
        this.estado = estado.confirmar();
    };

    public void cancelar() {
        this.estado = estado.cancelar();
    };

    public void reprogramar() {
        this.estado = estado.reprogramar();
    };

    public void consultarEstado() {
    };

    private void notificarObservadores() {
    };

    private void agregarObservador() {
    };
    // #region
    public int getIdTurno() {
        return idTurno;
    }
    public EstadoTurno getEstado() {
        return estado;
    }

    public LocalDateTime getFechaYHora() {
        return FechaYHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Profesional getDoctor() {
        return doctor;
    }
    // #endregion

}
