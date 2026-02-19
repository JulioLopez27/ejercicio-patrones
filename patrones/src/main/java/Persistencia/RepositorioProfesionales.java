package Persistencia;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import Dominio.Profesional;
import Dominio.TipoEspecialidad;

public class RepositorioProfesionales {

    private List<Profesional> profesionales = new ArrayList<>();

    public void guardar(Profesional p) {
        try {
            profesionales.add(p);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo registrar el profesional: " + e.getMessage());
        }
    }

    public Optional<Profesional> buscarPorId(int idProfesional) {
        for (Profesional p : profesionales) {
            if (p.getId() == idProfesional) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public Optional<Profesional> buscarPorDni(int dni) {
        for (Profesional p : profesionales) {
            if (p.getId() == dni) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public List<Profesional> listarProfesionales() {
        return profesionales;
    }

    public List<TipoEspecialidad> obtenerTipoEspecialidad() {
        return List.of(TipoEspecialidad.values());
    }
}
