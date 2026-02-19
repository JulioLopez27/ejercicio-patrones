package Utils;

import Dominio.*;
import Persistencia.RepositorioPacientes;
import Persistencia.RepositorioProfesionales;

public class CargaDatos {
    private RepositorioPacientes repoPacientes;
    private RepositorioProfesionales repoProfesionales;

    public CargaDatos(RepositorioPacientes p_repoPacientes, RepositorioProfesionales p_repoProfesionales) {
        this.repoPacientes = p_repoPacientes;
        this.repoProfesionales = p_repoProfesionales;
        cargarDatosTemporarios();
    }

    Paciente paciente1 = new Paciente(123, "Juan Perez", "Calle Falsa 123", "555-1234");
    Paciente paciente2 = new Paciente(456, "Maria Gomez", "Avenida Siempre Viva 456", "555-5678");
    Paciente paciente3 = new Paciente(789, "Carlos Lopez", "Boulevard de los Sueños Rotos 789", "555-9012");
    Paciente paciente4 = new Paciente(321, "Ana Martinez", "Calle Luna 321", "555-3456");
    Paciente paciente5 = new Paciente(654, "Luis Rodriguez", "Avenida Sol 654", "555-7890");

    Profesional profesional1 = new Profesional(1, "Dr. Smith", "profesional1@", TipoEspecialidad.Cardiologo);
    Profesional profesional2 = new Profesional(2, "Dra. Johnson", "profesional2@", TipoEspecialidad.Dermatologo);
    Profesional profesional3 = new Profesional(3, "Dr. Brown", "profesional3@", TipoEspecialidad.Pediatra);
    Profesional profesional4 = new Profesional(4, "Dra. Davis", "profesional4@", TipoEspecialidad.Ginecologo);
    Profesional profesional5 = new Profesional(5, "Dr. Wilson", "profesional5@", TipoEspecialidad.Reumatologo);

    private void cargarDatosTemporarios() {
        repoPacientes.guardar(paciente1);
        repoPacientes.guardar(paciente2);
        repoPacientes.guardar(paciente3);
        repoPacientes.guardar(paciente4);
        repoPacientes.guardar(paciente5);

        repoProfesionales.guardar(profesional1);
        repoProfesionales.guardar(profesional2);
        repoProfesionales.guardar(profesional3);
        repoProfesionales.guardar(profesional4);
        repoProfesionales.guardar(profesional5);

    }

}
