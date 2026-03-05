package Persistencia.Interfaces;

import java.util.Optional;

import Dominio.Profesional;

public interface IRepositorioProfesional extends IRepositorio<Profesional> {
    Optional<Profesional> buscarPorIdentificadorSis(int id);

    Optional<Profesional> buscarPorDocumento(int documento);
}
