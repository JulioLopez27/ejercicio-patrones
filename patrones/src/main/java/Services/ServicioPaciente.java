package Services;

import Dominio.Paciente;
import Persistencia.RepositorioPacientes;

public class ServicioPaciente {

    private RepositorioPacientes repoPacientes;

    public ServicioPaciente(RepositorioPacientes servicioPaciente) {
        this.repoPacientes = servicioPaciente;
    }

    public Paciente altaPaciente(int dni, String nombre, String correo, String direccion) {
        // validaciones de datos

        // busqueda por numSocio, si existe, lanza una excepcion
        if (repoPacientes.buscarPorDni(dni).isPresent())
            throw new RuntimeException("El paciente con el dni: " + dni + " ya existe.");

        Paciente nuevoPaciente = new Paciente(dni, nombre, correo, direccion);
        repoPacientes.guardar(nuevoPaciente);
        return nuevoPaciente;
    }

}
