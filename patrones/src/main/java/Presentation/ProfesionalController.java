package Presentation;

import java.util.List;
import java.util.Scanner;

import Dominio.Profesional;
import Dominio.TipoEspecialidad;
import Services.FachadaSistema;

public class ProfesionalController {

    private final FachadaSistema fachada;
    private final Scanner sc;

    public ProfesionalController(FachadaSistema p_fachada, Scanner p_sc) {
        this.fachada = p_fachada;
        this.sc = p_sc;
    }
//TODO: corregir return tipo
    public List<TipoEspecialidad> mostrarTiposEspecialidad() {
        List<TipoEspecialidad> tipos = fachada.obtenerTiposEspecialidad();

        System.out.println("Tipos de especialidad: ");
        for (int i = 0; i < tipos.size(); i++) {
            System.out.println((i + 1) + " - " + tipos.get(i));
        }
        return tipos;
    }

    public void listarProfesionales() {
        System.out.println("\n=== LISTA DE PROFESIONALES ===");
        List<Profesional> profesionales = fachada.listarProfesionales();
        if (profesionales.isEmpty()) {
            System.out.println("Aún no hay profesionales registrados.");
        } else {
            for (Profesional p : profesionales) {
                System.out.println(p);
            }
        }
    }

    public void altaProfesional() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Documento: ");
        int documento = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        List<TipoEspecialidad> tiposEspecialidad = this.mostrarTiposEspecialidad();
        TipoEspecialidad especialidad = null;

        while (especialidad == null) {
            System.out.println("Seleccione el tipo de especialidad:");
            int opcion = sc.nextInt();
            sc.nextLine();

            if (opcion >= 1 && opcion <= tiposEspecialidad.size()) {
                especialidad = tiposEspecialidad.get(opcion - 1);
            } else {
                System.out.println("Opcion invalida, intente nuevamente.");
            }
        }
        fachada.altaProfesional(documento, nombre, correo, especialidad);
    }

}
