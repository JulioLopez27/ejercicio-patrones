package Persistencia.Interfaces;

import java.util.Optional;

import Dominio.Paciente;

public interface IRepositorioPaciente extends IRepositorio<Paciente> {

    Optional<Paciente> buscarPorId(int id);
    Optional<Paciente> buscarPorDocumento(int documento);
}
