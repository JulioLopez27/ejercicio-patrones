package Exceptions;

public class ProfesionalNoDisponibleException extends ServicioException {
    public ProfesionalNoDisponibleException(String message) {
        super("El profesional solicitado no está disponible.");
    }

}
