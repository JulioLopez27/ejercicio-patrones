package Persistencia;

import Dominio.Turno;

import java.util.List;
import java.util.ArrayList;

public class RepositorioTurnos {

    private List<Turno> turnos = new ArrayList<>();

    public void guardar(Turno nuevoTurno) {
        turnos.add(nuevoTurno);
    }

    public Turno buscarPorId(int idTurno) {
        for (Turno t : turnos) {
            if (t.getIdTurno() == idTurno) {
                return t;
            }
        }
        return null;
    }

    public List<Turno> obtenerTurnos() {
        return turnos;
    }

}
