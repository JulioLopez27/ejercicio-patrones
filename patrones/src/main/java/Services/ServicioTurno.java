package Services;

import Dominio.Turno;
import Dominio.Paciente;
import Dominio.Profesional;
import Exceptions.ProfesionalNoDisponibleException;
import Exceptions.Dominio.TurnoNoEncontradoException;
import interfaces.Politicas.Atencion.PoliticaMutualista;
import interfaces.Politicas.Atencion.PoliticaParticular;
import interfaces.Politicas.Atencion.PoliticaUrgencia;
import interfaces.Politicas.Validacion.IPoliticaCancelarTurno;
import interfaces.Politicas.Validacion.IPoliticaCreacionTurno;
import interfaces.Politicas.Validacion.PoliticaAntecipacionMinima;

import Persistencia.RepositorioTurnos;

import java.time.LocalDateTime;
import java.util.List;

public class ServicioTurno {
    // Tiene la coleccion de todos los turnos en el sistema
    // en caso de no encontrar el turno, devuelve TurnoNoEncontradoException
    private List<IPoliticaCreacionTurno> politicaCreacion;
    private List<IPoliticaCancelarTurno> politicasCancelacion;

    private ServicioPaciente servicioPaciente;
    private ServicioProfesional servicioProfesional;
    private RepositorioTurnos repoTurnos;

    public ServicioTurno(RepositorioTurnos p_repoTurnos, ServicioPaciente p_servicePaciente,
            ServicioProfesional p_serviceProfesional) {

        this.servicioPaciente = p_servicePaciente;
        this.servicioProfesional = p_serviceProfesional;
        this.repoTurnos = p_repoTurnos;
        this.politicaCreacion = List.of(
                new PoliticaParticular(),
                new PoliticaMutualista(),
                new PoliticaUrgencia());

        this.politicasCancelacion = List.of(
                new PoliticaAntecipacionMinima());
    }

    public Turno crearTurno(int numSocio, int IdProfesional, LocalDateTime fechaHora) {
        // Lógica para crear un turno
        // Verificar si el paciente y profesional existen
        Paciente paciente = servicioPaciente.buscarPorId(numSocio);

        Profesional profesional = servicioProfesional.buscarPorId(IdProfesional);

        // Verificar si el profesional está disponible en la fecha y hora solicitada
        if (!profesional.estaDisponible(fechaHora)) {
            throw new ProfesionalNoDisponibleException(
                    "El profesional con id: " + IdProfesional + " no esta disponible en la fecha y hora solicitada.");
        }

        // TODO: verificar politicas
        // aplica la politica de atencion
        // for (IPoliticaCreacionTurno politica : politicaCreacion) {
        // politica.validarCreacionTurno(paciente, profesional, fechaHora);
        // }

        // Crear y guardar el turno en el repositorio
        Turno nuevoTurno = new Turno(paciente, profesional, fechaHora);
        repoTurnos.guardar(nuevoTurno);
        profesional.asignarTurno(nuevoTurno);
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
    }

    public List<Turno> listarTurnos() {
        return repoTurnos.listar();
    }

}
