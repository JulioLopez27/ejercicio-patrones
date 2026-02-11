package Services;

import java.util.List;

import Dominio.Profesional;
import Dominio.TipoEspecialidad;

import Persistencia.RepositorioProfesionales;

public class ServicioProfesional {
    private RepositorioProfesionales repoProfesionales;

    public ServicioProfesional(RepositorioProfesionales p_repoProfesionales) {
        this.repoProfesionales = p_repoProfesionales;
    }

    public Profesional altaProfesional(int dni, String nombre, String correo, TipoEspecialidad tipo) {
        if (repoProfesionales.buscarPorDni(dni).isPresent())
            throw new RuntimeException("El profesional con el dni: " + dni + "ya existe.");
        Profesional nuevoProfesional = new Profesional(dni, nombre, correo, tipo);
        repoProfesionales.guardar(nuevoProfesional);
        return nuevoProfesional;
    }

    public List<TipoEspecialidad> obtenerTiposEspecialidad() {
        return repoProfesionales.obtenerTipoEspecialidad();
    }
}
