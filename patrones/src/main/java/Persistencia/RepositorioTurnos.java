package Persistencia;

import Dominio.Turno;
import Exceptions.Persistencia.GuardadoException;
import Persistencia.Interfaces.IRepositorioProfesional;
import Persistencia.Interfaces.IRepositorioTurno;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class RepositorioTurnos implements IRepositorioTurno{

    private List<Turno> turnos = new ArrayList<>();

    public void guardar(Turno nuevoTurno) {
        try {
            turnos.add(nuevoTurno);
        } catch (Exception e) {
            throw new GuardadoException("Error al guardar el turno. " + e);
        }
    }
    @Override
    public Optional<Turno> buscarPorId(int idTurno) {
        for (Turno t : turnos) {
            if (t.getIdTurno() == idTurno) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    public List<Turno> listar() {
        return turnos;
    }

}
