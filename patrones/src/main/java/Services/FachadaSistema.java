package Services;

import java.time.LocalDateTime;

import Dominio.Paciente;
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
    private ServicioProfesional servicioProfesional = new ServicioProfesional();

    // // singleton pattern
    // private static FachadaSistema fachada = null;

    // public static FachadaSistema getFachada() {
    // if (fachada == null) {
    // fachada = new FachadaSistema();
    // }
    // return fachada;
    // }

    public void crearTurno(int numSocio, int idMedico, LocalDateTime fechaHora) {
        servicioTurno.crearTurno(numSocio, idMedico, fechaHora);
    }

    public void cancelarTurno(int idTurno) {
        servicioTurno.cancelarTurno(idTurno);
    }

    public void altaPaciente(int dni, String nombre, String correo, String direccion) {
        Paciente p = servicioPaciente.altaPaciente(dni, nombre, correo, direccion);
        System.out.println("Paciente creado con el N° de socio: " + p.getNumSocio());
    }
}
