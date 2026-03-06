package Services;

import java.util.List;

import Dominio.Paciente;
import Exceptions.Dominio.PacienteNoEncontradoException;
import Exceptions.Dominio.PacienteRegistradoException;
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
            throw new PacienteRegistradoException(documento);

        Paciente nuevoPaciente = new Paciente(documento, nombre, correo, direccion);
        repoPacientes.guardar(nuevoPaciente);
        return nuevoPaciente;
    }

    // TODO: implementar try-catch
    public List<Paciente> listarPacientes() {
        return repoPacientes.listar();
    }

    public Paciente buscarPorId(int identificadorSis) {
        return repoPacientes.buscarPorId(identificadorSis)
                .orElseThrow(() -> new PacienteNoEncontradoException("número de socio: " + identificadorSis));
    }

}
