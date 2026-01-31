package interfaces.Politicas.Validacion;

import Dominio.Turno;
import java.time.LocalDateTime;

public interface IPoliticaReprogramacionTurno {
    void validarReprogramacion(Turno t, LocalDateTime nuevaFechaHora);
}
