package Persistencia.Interfaces;

import java.util.List;
import java.util.Optional;

import Dominio.Profesional;
import Dominio.TipoEspecialidad;

public interface IRepositorioProfesional extends IRepositorio<Profesional> {
    Optional<Profesional> buscarPorIdentificadorSis(int id);

    Optional<Profesional> buscarPorDocumento(int documento);

    List<TipoEspecialidad> listarTipoEspecialidad();
}
