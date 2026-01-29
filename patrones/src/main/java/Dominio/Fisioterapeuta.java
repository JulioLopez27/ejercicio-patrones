package Dominio;

import java.time.LocalDateTime;

public class Fisioterapeuta extends Profesional {
public Fisioterapeuta(String p_nombre, String p_correo) {
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
