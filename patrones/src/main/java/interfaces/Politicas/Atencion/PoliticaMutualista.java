package interfaces.Politicas.Atencion;

import java.time.LocalDateTime;

import Dominio.Paciente;
import Dominio.Profesional;
import interfaces.Politicas.Validacion.IPoliticaCreacionTurno;

public class PoliticaMutualista implements IPoliticaCreacionTurno {

    @Override
    public void validarCreacionTurno(Paciente paciente, Profesional profesional, LocalDateTime fechaHora) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validarCreacionTurno'");
    }

}
