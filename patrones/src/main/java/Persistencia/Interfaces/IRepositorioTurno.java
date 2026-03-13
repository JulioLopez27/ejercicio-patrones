package Persistencia.Interfaces;

import java.util.List;
import java.util.Optional;

import Dominio.Turno;

public interface IRepositorioTurno extends IRepositorio<Turno> {
    Optional<Turno> buscarPorId(int idTurno);

    List<Turno> obtenerTurnosDelPaciente(int idPaciente);
}
