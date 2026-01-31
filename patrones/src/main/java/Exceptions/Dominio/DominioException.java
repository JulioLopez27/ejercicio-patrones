package Exceptions.Dominio;

public abstract class DominioException extends RuntimeException {
   
    public DominioException(String msg) {
        super(msg);
    }

    public DominioException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
