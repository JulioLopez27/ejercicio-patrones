package Persistencia.Interfaces;

import java.util.Optional;

import Dominio.Turno;

public interface IRepositorioTurno extends IRepositorio<Turno> {
Optional<Turno> buscarPorId(int idTurno); 
}
