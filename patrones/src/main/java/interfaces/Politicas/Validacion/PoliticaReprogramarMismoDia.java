package interfaces.Politicas.Validacion;

import java.time.LocalDateTime;

import Dominio.Turno;

public class PoliticaReprogramarMismoDia implements IPoliticaReprogramacionTurno {

    @Override
    public void validarReprogramacion(Turno t, LocalDateTime nuevaFechaHora) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validarReprogramacion'");
    }

}
