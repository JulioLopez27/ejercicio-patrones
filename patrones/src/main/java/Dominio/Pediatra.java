package Dominio;

import java.time.LocalDateTime;

public class Pediatra extends Profesional {

    public Pediatra(String p_nombre, String p_correo) {
        super(p_nombre, p_correo);
    }

    @Override
    public void verificiarDisponibilidad() {

    }

    @Override
    public void asignarTurno() {

    }

    @Override
    public boolean estaDisponible(LocalDateTime fechaHora) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'estaDisponible'");
    }

}
