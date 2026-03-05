package Persistencia;

import Dominio.Paciente;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

public class RepositorioPacientes {

    private List<Paciente> pacientes = new ArrayList<>();

    public void guardar(Paciente p) {
        try {
            pacientes.add(p);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el paciente: " + e.getMessage());
        }
    }

    // TODO: optimizar a futuro
    public Optional<Paciente> buscarPorId(int numSocio) {
        for (Paciente p : pacientes) {
            if (p.getNumSocio() == numSocio) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public Optional<Paciente> buscarPorDocumento(int documento) {
        for (Paciente p : pacientes) {
            if (p.getDocumento() == documento) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

}
