package Exceptions.Dominio;

public class PacienteNoEncontradoException extends DominioException {
    public PacienteNoEncontradoException(String criterio) {
        super("Paciente no encontrado (" + criterio + ") no encontrado. ");
    }
}
