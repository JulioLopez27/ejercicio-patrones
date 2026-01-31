package Services;

import java.time.LocalDateTime;

import Persistencia.RepositorioPacientes;
import Persistencia.RepositorioProfesionales;
import Persistencia.RepositorioTurnos;

public class FachadaSistema {
    //inicializacion de los repositorios
    private RepositorioPacientes repoPacientes= new RepositorioPacientes();
    private RepositorioProfesionales repoProfesionales = new RepositorioProfesionales();
    private RepositorioTurnos repoTurnos = new RepositorioTurnos();

    // inicializacion de los servicios
    private ServicioTurno servicioTurno = new ServicioTurno(repoPacientes, repoProfesionales, repoTurnos);
    private ServicioPaciente servicioPaciente = new ServicioPaciente();
    private ServicioProfesional servicioProfesional = new ServicioProfesional();

    // // singleton pattern
    // private static FachadaSistema fachada = null;

    // public static FachadaSistema getFachada() {
    //     if (fachada == null) {
    //         fachada = new FachadaSistema();
    //     }
    //     return fachada;
    // }

    public void crearTurno(int numSocio, int idMedico, LocalDateTime fechaHora) {
        servicioTurno.crearTurno(numSocio, idMedico, fechaHora);
    }

    public void cancelarTurno(int idTurno){
        servicioTurno.cancelarTurno(idTurno);
    }

}
