package Services;

import java.time.LocalDateTime;
import java.util.List;

import Dominio.Paciente;
import Dominio.Profesional;
import Dominio.TipoEspecialidad;
import Dominio.Turno;
import Observer.Observable;
import Persistencia.RepositorioPacientes;
import Persistencia.RepositorioProfesionales;
import Persistencia.RepositorioTurnos;
import Utils.CargaDatos;

public class FachadaSistema extends Observable {
    // inicializacion de los repositorios
    private RepositorioPacientes repoPacientes = new RepositorioPacientes();
    private RepositorioProfesionales repoProfesionales = new RepositorioProfesionales();
    private RepositorioTurnos repoTurnos = new RepositorioTurnos();

    // inicializacion de los servicios
    private ServicioPaciente servicioPaciente = new ServicioPaciente(repoPacientes);
    private ServicioProfesional servicioProfesional = new ServicioProfesional(repoProfesionales);
    private ServicioTurno servicioTurno = new ServicioTurno(repoTurnos, servicioPaciente, servicioProfesional);

    public FachadaSistema() {
        cargaDatosDummy();
    }

    private void cargaDatosDummy() {
        new CargaDatos(repoPacientes, repoProfesionales, repoTurnos);
    }

    // TURNOS
    public Turno crearTurno(int numSocio, int idMedico, LocalDateTime fechaHora) {
        Turno t = servicioTurno.crearTurno(numSocio, idMedico, fechaHora);
        t.suscribir(t.getPaciente());
        t.suscribir(t.getProfesional());
        return t;
    }

    public void cancelarTurno(int idTurno) {
        servicioTurno.cancelarTurno(idTurno);
    }

    public List<Turno> listarTurnos() {
        return servicioTurno.listarTurnos();
    }

    // -----------------

    // Pacientes---------------------------------------------------------------------------
    public void altaPaciente(int documento, String nombre, String correo, String direccion) {
        Paciente p = servicioPaciente.altaPaciente(documento, nombre, correo, direccion);
        System.out.println("Paciente creado con el N° de socio: " + p.getNumSocio());
    }

    // TODO: refactorizar
    public List<Paciente> listarPacientes() {
        List<Paciente> pacientes = servicioPaciente.listarPacientes();
        return pacientes;
    }

    // Profesionales---------------------------------------------------------------------------------
    public void altaProfesional(int documento, String nombre, String correo, TipoEspecialidad tipo) {
        Profesional p = servicioProfesional.altaProfesional(documento, nombre, correo, tipo);
        System.out.println("Profesional creado con el identificador: " + p.getId());
    }

    public List<Profesional> listarProfesionales() {
        return servicioProfesional.listarProfesionales();
    }

    public List<TipoEspecialidad> obtenerTiposEspecialidad() {
        return servicioProfesional.obtenerTiposEspecialidad();
    }
}
