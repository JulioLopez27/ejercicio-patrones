package Services;

import java.util.List;

import Dominio.Paciente;
import Persistencia.RepositorioPacientes;

public class ServicioPaciente {

    private RepositorioPacientes repoPacientes;

    public ServicioPaciente(RepositorioPacientes servicioPaciente) {
        this.repoPacientes = servicioPaciente;
    }

    public Paciente altaPaciente(int documento, String nombre, String correo, String direccion) {
        // validaciones de datos

        // busqueda por numSocio, si existe, lanza una excepcion
        if (repoPacientes.buscarPorDocumento(documento).isPresent())
            throw new RuntimeException("El paciente con el documento: " + documento + " ya existe.");

        Paciente nuevoPaciente = new Paciente(documento, nombre, correo, direccion);
        repoPacientes.guardar(nuevoPaciente);
        return nuevoPaciente;
    }


    public List<Paciente> listarPacientes(){
        return repoPacientes.listarPacientes();
    }

}
