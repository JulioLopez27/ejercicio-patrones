package interfaces.Politicas.Validacion;

import Dominio.Paciente;
import Dominio.Profesional;

import java.time.LocalDateTime;

public class PoliticaHorarioLaboral implements IPoliticaCreacionTurno {

    @Override
    public void validarCreacionTurno(Paciente paciente, Profesional profesional, LocalDateTime fechaHora) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validarCreacionTurno'");
    }

}
