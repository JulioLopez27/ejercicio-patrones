package Persistencia;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import Dominio.Profesional;

public class RepositorioProfesionales {

    private List<Profesional> profesionales = new ArrayList<>();

    public void guardar(Profesional p) {
        profesionales.add(p);
    }

    public Optional<Profesional> buscarPorId(int idProfesional) {
        for (Profesional p : profesionales) {
            if (p.getId() == idProfesional) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public List<Profesional> obtenerTodos(){
        return profesionales;
    }
}
