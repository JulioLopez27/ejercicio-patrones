package Services;

import java.util.List;

import Dominio.Profesional;
import Dominio.TipoEspecialidad;
import Exceptions.ProfesionalNoEncontradoException;
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

    public List<Profesional> listarProfesionales() {
            return repoProfesionales.listarProfesionales();
    }

    public List<TipoEspecialidad> obtenerTiposEspecialidad() {
        return repoProfesionales.obtenerTipoEspecialidad();
    }

    public Profesional buscarPorId(int id) {
        return repoProfesionales.buscarPorId(id)
                .orElseThrow(() -> new ProfesionalNoEncontradoException("Profesional con el id: " + id + " no encontrado."));
    }
}
