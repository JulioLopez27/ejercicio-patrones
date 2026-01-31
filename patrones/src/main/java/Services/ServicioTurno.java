package Services;

import Dominio.Turno;
import Dominio.Paciente;
import Dominio.Profesional;

import interfaces.PoliticasDeAtencion.IPoliticaAtencion;
import interfaces.PoliticasDeAtencion.PoliticaParticular;
import interfaces.PoliticasDeAtencion.PoliticaMutualista;
import interfaces.PoliticasDeAtencion.PoliticaUrgencia;
import interfaces.PoliticasDeAtencion.IPoliticaCancelarTurno;
import interfaces.PoliticasDeAtencion.PoliticaAntecipacionMinima;
import Exceptions.PacienteNoEncontradoException;
import Exceptions.ProfesionalNoDisponibleException;
import Exceptions.ProfesionalNoEncontradoException;
import Exceptions.TurnoNoEncontradoException;

import Persistencia.RepositorioTurnos;
import Persistencia.RepositorioPacientes;
import Persistencia.RepositorioProfesionales;

import java.time.LocalDateTime;
import java.util.List;

public class ServicioTurno {
    // Tiene la coleccion de todos los turnos en el sistema
    // en caso de no encontrar el turno, devuelve TurnoNoEncontradoException
    private List<IPoliticaAtencion> politicasAtencion;
    private List<IPoliticaCancelarTurno> politicasCancelacion;
    private RepositorioPacientes repoPacientes;
    private RepositorioProfesionales repoProfesionales;
    private RepositorioTurnos repoTurnos;

    public ServicioTurno(RepositorioPacientes p_repoPaciente, RepositorioProfesionales p_repoProfesionales,
            RepositorioTurnos p_repoTurnos) {
        this.repoPacientes = p_repoPaciente;
        this.repoProfesionales = p_repoProfesionales;
        this.repoTurnos = p_repoTurnos;
        this.politicasAtencion = List.of(new PoliticaParticular(), new PoliticaMutualista(), new PoliticaUrgencia());
        this.politicasCancelacion = List.of(new PoliticaAntecipacionMinima());
    }

    public Turno crearTurno(int numSocio, int IdProfesional, LocalDateTime fechaHora) {
        // Lógica para crear un turno
        // Verificar si el paciente y profesional existen
        Paciente paciente = repoPacientes.buscarPorId(numSocio).orElseThrow(
                () -> new PacienteNoEncontradoException("No se encontro el paciente con id: " + numSocio));

        Profesional profesional = repoProfesionales.buscarPorId(IdProfesional).orElseThrow(
                () -> new ProfesionalNoEncontradoException("No se encontro el profesional con id: " + IdProfesional));

        // Verificar si el profesional está disponible en la fecha y hora solicitada
        if (!profesional.estaDisponible(fechaHora)) {
            throw new ProfesionalNoDisponibleException(
                    "El profesional con id: " + IdProfesional + " no esta disponible en la fecha y hora solicitada.");
        }

        // aplica la politica de atencion
        for (IPoliticaAtencion politica : politicasAtencion) {
            politica.validarCreacionTurno(paciente, profesional, fechaHora);
        }

        // Crear y guardar el turno en el repositorio
        Turno nuevoTurno = new Turno(paciente, profesional, fechaHora);
        repoTurnos.guardar(nuevoTurno);
        // Devolver el turno creado
        return nuevoTurno;
    }

    public void cancelarTurno(int idTurno) {
        // Lógica para cancelar un turno
        Turno turno = repoTurnos.buscarPorId(idTurno)
                .orElseThrow(() -> new TurnoNoEncontradoException());
        for (IPoliticaCancelarTurno p : politicasCancelacion) {
            p.validarCancelacionTurno(turno);
        }
        turno.cancelar();
        repoTurnos.guardar(turno);
    }

}
