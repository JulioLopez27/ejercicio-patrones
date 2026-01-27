package interfaces.PoliticasDeAtencion;

import java.time.LocalDateTime;

import Dominio.Paciente;
import Dominio.Profesional;
import Dominio.Turno;

public class PoliticaUrgencia implements IPoliticaAtencion {

    @Override
    public void validarCreacionTurno(Paciente paciente, Profesional profesional, LocalDateTime fechaHora) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validarCreacionTurno'");
    }

    @Override
    public void validarCancelacionTurno(Turno turno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validarCancelacionTurno'");
    }

    @Override
    public void validarReprogramacionTurno(Turno turno, LocalDateTime nuevaFechaHora) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validarReprogramacionTurno'");
    }

}
