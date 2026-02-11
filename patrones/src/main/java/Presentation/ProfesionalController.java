package Presentation;

import java.util.List;

import Dominio.TipoEspecialidad;
import Services.FachadaSistema;

public class ProfesionalController {
    private FachadaSistema fachada = new FachadaSistema();

    public void altaProfesional(int dni, String nombre, String correo, TipoEspecialidad tipo) {
        fachada.altaProfesional(dni, nombre, correo, tipo);
    }

    public List<TipoEspecialidad> mostrarTiposEspecialidad() {
        List<TipoEspecialidad> tipos = fachada.obtenerTiposEspecialidad();

        System.out.println("Tipos de especialidad: ");
        for (int i = 0; i < tipos.size(); i++) {
            System.out.println((i + 1) + " - " + tipos.get(i));
        }
        return tipos;
    }
}
