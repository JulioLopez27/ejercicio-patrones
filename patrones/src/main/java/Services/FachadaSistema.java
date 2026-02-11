package Services;

import java.time.LocalDateTime;
import java.util.List;

import Dominio.Paciente;
import Dominio.Profesional;
import Dominio.TipoEspecialidad;
import Persistencia.RepositorioPacientes;
import Persistencia.RepositorioProfesionales;
import Persistencia.RepositorioTurnos;

public class FachadaSistema {
    // inicializacion de los repositorios
    private RepositorioPacientes repoPacientes = new RepositorioPacientes();
    private RepositorioProfesionales repoProfesionales = new RepositorioProfesionales();
    private RepositorioTurnos repoTurnos = new RepositorioTurnos();

    // inicializacion de los servicios
    private ServicioTurno servicioTurno = new ServicioTurno(repoPacientes, repoProfesionales, repoTurnos);
    private ServicioPaciente servicioPaciente = new ServicioPaciente(repoPacientes);
    private ServicioProfesional servicioProfesional = new ServicioProfesional(repoProfesionales);

    // // singleton pattern
    // private static FachadaSistema fachada = null;

    // public static FachadaSistema getFachada() {
    // if (fachada == null) {
    // fachada = new FachadaSistema();
    // }
    // return fachada;
    // }

    // TURNOS
    public void crearTurno(int numSocio, int idMedico, LocalDateTime fechaHora) {
        servicioTurno.crearTurno(numSocio, idMedico, fechaHora);
    }

    public void cancelarTurno(int idTurno) {
        servicioTurno.cancelarTurno(idTurno);
    }
    // -----------------

    // Pacientes
    public void altaPaciente(int dni, String nombre, String correo, String direccion) {
        Paciente p = servicioPaciente.altaPaciente(dni, nombre, correo, direccion);
        System.out.println("Paciente creado con el N° de socio: " + p.getNumSocio());
    }

    // Profesionales
    public void altaProfesional(int dni, String nombre, String correo, TipoEspecialidad tipo) {
        Profesional p = servicioProfesional.altaProfesional(dni, nombre, correo, tipo);
        System.out.println("Profesional creado con el identificador: " + p.getId());
    }

    public List<TipoEspecialidad> obtenerTiposEspecialidad() {
        return servicioProfesional.obtenerTiposEspecialidad();
    }
}
