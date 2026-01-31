package Exceptions;

public class TransicionEstadoInvalidaException extends DominioException {

    public TransicionEstadoInvalidaException(String mensaje) {
        super(mensaje);
    }

    // expresa que reglas de negocio impiden que un objeto cambie de estado
    public TransicionEstadoInvalidaException(String estadoActuar, String estadoDestino) {
        super("No se puede cambiar el estado " + estadoActuar + " a " + estadoDestino);
    }

}
