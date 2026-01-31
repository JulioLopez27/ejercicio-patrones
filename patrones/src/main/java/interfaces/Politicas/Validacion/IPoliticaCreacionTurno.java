package interfaces.Politicas.Validacion;

import Dominio.Paciente;
import Dominio.Profesional;
import java.time.LocalDateTime;

public interface IPoliticaCreacionTurno {

    void validarCreacionTurno(Paciente paciente, Profesional profesional, LocalDateTime fechaHora);
}
