package Exceptions;

public class ProfesionalNoEncontradoException extends ServicioException {
    public ProfesionalNoEncontradoException(String mensaje) {
        super("Profesional no encontrado.");
    }

}
