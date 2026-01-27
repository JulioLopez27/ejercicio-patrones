package interfaces.PoliticasDeAtencion;

import java.time.LocalDateTime;

import Dominio.Paciente;
import Dominio.Profesional;
import Dominio.Turno;
public interface IPoliticaAtencion {
    
void validarCreacionTurno(Paciente paciente, Profesional profesional, LocalDateTime fechaHora);
void validarCancelacionTurno(Turno turno);
void validarReprogramacionTurno(Turno turno, LocalDateTime nuevaFechaHora);



}
