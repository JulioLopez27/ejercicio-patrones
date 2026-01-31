package Exceptions.Dominio;

import Exceptions.ServicioException;

public class TurnoNoEncontradoException extends ServicioException {
    // excepcion de aplicacion/servicio
    // ya que se encarga de ir a buscar informacion a la base de datos
    public TurnoNoEncontradoException() {
        super("No se encontró el turno solicitado.");
    }

}
