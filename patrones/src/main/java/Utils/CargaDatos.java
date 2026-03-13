package Utils;

import java.time.LocalDateTime;
import java.util.List;

import Dominio.*;
import Persistencia.RepositorioPacientes;
import Persistencia.RepositorioProfesionales;
import Persistencia.RepositorioTurnos;
import java.time.temporal.ChronoUnit;

public class CargaDatos {
    private final RepositorioPacientes repoPacientes;
    private final RepositorioProfesionales repoProfesionales;
    private final RepositorioTurnos repoTurnos;

    public CargaDatos(RepositorioPacientes p_repoPacientes, RepositorioProfesionales p_repoProfesionales,
            RepositorioTurnos p_repoTurnos) {
        this.repoPacientes = p_repoPacientes;
        this.repoProfesionales = p_repoProfesionales;
        this.repoTurnos = p_repoTurnos;

        inicializacionDeDatos();
    }

    private void inicializacionDeDatos() {

        List<Paciente> pacientes = List.of(
                new Paciente(123, "Juan Perez", "Calle Falsa 123", "555-1234"),
                new Paciente(456, "Maria Gomez", "Avenida Siempre Viva 456", "555-5678"),
                new Paciente(789, "Carlos Lopez", "Boulevard de los Sueños Rotos 789", "555-9012"),
                new Paciente(321, "Ana Martinez", "Calle Luna 321", "555-3456"),
                new Paciente(654, "Luis Rodriguez", "Avenida Sol 654", "555-7890"));
        pacientes.forEach(repoPacientes::guardar);

        List<Profesional> profesionales = List.of(
                new Profesional(1, "Dr. Smith", "profesional1@", TipoEspecialidad.Cardiologo),
                new Profesional(2, "Dra. Johnson", "profesional2@", TipoEspecialidad.Dermatologo),
                new Profesional(3, "Dr. Brown", "profesional3@", TipoEspecialidad.Pediatra),
                new Profesional(4, "Dra. Davis", "profesional4@", TipoEspecialidad.Ginecologo),
                new Profesional(5, "Dr. Wilson", "profesional5@", TipoEspecialidad.Reumatologo));
        profesionales.forEach(repoProfesionales::guardar);

        List<Turno> turnos = List.of(
                new Turno(pacientes.get(0), profesionales.get(0), normalizado().plusDays(2)),
                new Turno(pacientes.get(1), profesionales.get(1), normalizado().plusDays(3)),
                new Turno(pacientes.get(2), profesionales.get(2), normalizado().plusDays(5)),
                new Turno(pacientes.get(3), profesionales.get(3), normalizado().plusDays(9)),
                new Turno(pacientes.get(4), profesionales.get(4), normalizado().plusDays(7)));

        helpSuscribir(turnos.get(2));
        helpSuscribir(turnos.get(3));
        helpSuscribir(turnos.get(4));

        turnos.forEach(repoTurnos::guardar);
    }

    private void helpSuscribir(Turno t) {
        t.suscribir(t.getPaciente());
        t.suscribir(t.getProfesional());
    }

    private static LocalDateTime normalizado() {
        return LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
    }

}
