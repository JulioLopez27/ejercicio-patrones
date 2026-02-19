package Exceptions.Dominio;

public class PacienteRegistradoException extends DominioException {
    public PacienteRegistradoException(int doc) {
        super("El paciente con el documento: " + doc + " ya existe.");
    }

}
