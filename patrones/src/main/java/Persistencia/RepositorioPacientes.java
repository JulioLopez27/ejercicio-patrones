package Persistencia;

import Dominio.Paciente;
import Exceptions.Persistencia.GuardadoException;
import Persistencia.Interfaces.IRepositorioPaciente;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

public class RepositorioPacientes implements IRepositorioPaciente {

    private List<Paciente> pacientes = new ArrayList<>();

    public void guardar(Paciente p) {
        try {
            pacientes.add(p);
        } catch (Exception e) {
            throw new GuardadoException("Error al guardar el paciente: " + e.getMessage());
        }
    }

    @Override
    public Optional<Paciente> buscarPorId(int identificadorSis) {
        return pacientes.stream()
                .filter(p -> p.getIdentificadorSis() == identificadorSis)
                .findFirst();
    }

    @Override
    public Optional<Paciente> buscarPorDocumento(int documento) {
        return pacientes.stream()
                .filter(p -> p.getDocumento() == documento)
                .findFirst();
    }

    @Override
    public List<Paciente> listar() {
        return pacientes;
    }

}
