package Services;

import Dominio.Paciente;
import Persistencia.RepositorioPacientes;

public class ServicioPaciente {

    private RepositorioPacientes repoPacientes;

    public ServicioPaciente(RepositorioPacientes servicioPaciente) {
        this.repoPacientes = servicioPaciente;
    }

    public void altaPaciente(int numSocio, String nombre, String correo, String direccion) {
        // validaciones de datos

        // busqueda por numSocio, si existe, lanza una excepcion
        if (repoPacientes.buscarPorId(numSocio).isPresent())
            throw new RuntimeException("El paciente con numSocio: " + numSocio + " ya existe.");

        Paciente nuevoPaciente = new Paciente(nombre, correo, direccion, numSocio);
        repoPacientes.guardar(nuevoPaciente);

    }

}
