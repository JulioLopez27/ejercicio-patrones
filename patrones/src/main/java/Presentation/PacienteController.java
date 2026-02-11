package Presentation;

import java.util.List;
import java.util.Scanner;

import Dominio.Paciente;
import Services.FachadaSistema;

public class PacienteController {

    private final FachadaSistema fachada;
    private final Scanner sc;

    public PacienteController(FachadaSistema p_fachada, Scanner p_sc) {
        this.fachada = p_fachada;
        this.sc = p_sc;
    }

    public void altaPaciente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Direccion: ");
        String direccion = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Documento: ");
        // TODO: validar que el documento sea un valor numerico
        int documento = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        fachada.altaPaciente(documento, nombre, direccion, correo);
    }

    public void listarPacientes() {
        System.out.println("\n=== LISTA DE PACIENTES ===");
        List<Paciente> pacientes = fachada.listarPacientes();
        if (pacientes.isEmpty()) {
            System.out.println("Aún no hay pacientes registrados.");
        } else {
            for (Paciente p : pacientes) {
                System.out.println(p);
            }
        }
    }

}
