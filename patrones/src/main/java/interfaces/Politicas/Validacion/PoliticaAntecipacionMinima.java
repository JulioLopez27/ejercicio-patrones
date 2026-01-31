package interfaces.Politicas.Validacion;

import Dominio.Turno;
import Exceptions.CancelacionInvalidaException;

import java.time.LocalDateTime;

public class PoliticaAntecipacionMinima implements IPoliticaCancelarTurno {

    public void validarCancelacionTurno(Turno turno) {
        if (turno.getFechaYHora().minusHours(24).isBefore(LocalDateTime.now())) {
            throw new CancelacionInvalidaException(
                    "No se puede cancelar el turno con menos de 24 horas de anticipación");
        }
    }

}
