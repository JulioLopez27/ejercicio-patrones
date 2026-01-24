package Dominio;

public class Turno {
    private int idTurno;
    private EstadoTurno estado;
    private String FechaYHora;
    private Paciente paciente;
    private Profesional doctor;

    public Turno(EstadoTurno estado, String fechaYHora, Paciente paciente, Profesional doctor) {
        this.estado = estado;
        FechaYHora = fechaYHora;
        this.paciente = paciente;
        this.doctor = doctor;
    }

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
    public EstadoTurno getEstado() {
        return estado;
    }

    public String getFechaYHora() {
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
