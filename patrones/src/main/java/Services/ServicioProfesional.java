package Services;

import java.time.LocalDateTime;
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

    public Profesional altaProfesional(int documento, String nombre, String correo, TipoEspecialidad tipo) {
        if (repoProfesionales.buscarPorDocumento(documento).isPresent())
            throw new RuntimeException("El profesional con el dni: " + documento + "ya existe.");
        Profesional nuevoProfesional = new Profesional(documento, nombre, correo, tipo);
        repoProfesionales.guardar(nuevoProfesional);
        return nuevoProfesional;
    }

    public List<Profesional> listarProfesionales() {
        return repoProfesionales.listar();
    }

    public List<TipoEspecialidad> obtenerTiposEspecialidad() {
        return repoProfesionales.listarTipoEspecialidad();
    }

    public Profesional buscarPorId(int id) {
        return repoProfesionales.buscarPorIdentificadorSis(id)
                .orElseThrow(
                        () -> new ProfesionalNoEncontradoException("Profesional con el id: " + id + " no encontrado."));
    }

    public boolean disponibilidadDelProfesional(Profesional p, LocalDateTime fechaHora) {
        return p.tieneDisponible(fechaHora);
    }
}
