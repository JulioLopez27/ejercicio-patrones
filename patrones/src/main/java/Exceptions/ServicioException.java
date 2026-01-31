package Exceptions;

public class ServicioException extends RuntimeException {

    public ServicioException(String mensaje) {
        super(mensaje);
    }

    public ServicioException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }

}
