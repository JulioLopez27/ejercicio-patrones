package Exceptions.Dominio;

public class TurnoYaCanceladoException extends DominioException {
   
    public TurnoYaCanceladoException() {
        super("El turno ya ha sido cancelado previamente.");
    }

}
