package Exceptions.Persistencia;

public class GuardadoException extends PersistenciaException {
    public GuardadoException(String message) {
        super(message);
    }

    public GuardadoException(String message, Throwable cause) {
        super(message, cause);
    }
}
