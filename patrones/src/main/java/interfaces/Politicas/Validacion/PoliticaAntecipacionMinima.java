package interfaces.Politicas.Validacion;

import Dominio.Turno;
import Exceptions.Dominio.CancelacionInvalidaException;

import java.time.LocalDateTime;

public class PoliticaAntecipacionMinima implements IPoliticaCancelarTurno {

    public void validarCancelacionTurno(Turno turno) {
        LocalDateTime limiteCancelacion = LocalDateTime.now().plusHours(24);
        if (!turno.getFechaInicio().isAfter(limiteCancelacion)) {
            throw new CancelacionInvalidaException(
                    "No se puede cancelar el turno con menos de 24 horas de anticipación");
        }
    }

}
