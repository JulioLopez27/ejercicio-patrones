package Exceptions.Dominio;

public class TurnoVencidoException extends DominioException {
    public TurnoVencidoException() {
        super("El turno ha vencido.");
    }

}
