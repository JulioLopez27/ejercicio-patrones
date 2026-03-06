package Persistencia;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import Dominio.Profesional;
import Dominio.TipoEspecialidad;
import Exceptions.Persistencia.GuardadoException;
import Persistencia.Interfaces.IRepositorioProfesional;

public class RepositorioProfesionales implements IRepositorioProfesional {

    private List<Profesional> profesionales = new ArrayList<>();

    @Override
    public void guardar(Profesional p) {
        try {
            profesionales.add(p);
        } catch (Exception e) {
            throw new GuardadoException("No se pudo registrar el profesional: " + e.getMessage());
        }
    }

    @Override
    public Optional<Profesional> buscarPorIdentificadorSis(int id) {
        return profesionales.stream()
                .filter(p -> p.getIdentificadorSis() == id)
                .findFirst();
    }

    @Override
    public Optional<Profesional> buscarPorDocumento(int documento) {
        return profesionales.stream()
        .filter(p->p.getDocumento()==documento)
        .findFirst();
    }

    @Override
    public List<TipoEspecialidad> listarTipoEspecialidad() {
        return List.of(TipoEspecialidad.values());
    }

    @Override
    public List<Profesional> listar() {
        return this.profesionales;
    }

}
