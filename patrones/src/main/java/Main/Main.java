package Main;

import java.util.Scanner;

import Services.FachadaSistema;
import Presentation.PacienteController;
import Presentation.ProfesionalController;
import Presentation.TurnoController;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FachadaSistema fachada = new FachadaSistema();

        ProfesionalController profesionalController = new ProfesionalController(fachada, sc);
        PacienteController pacienteController = new PacienteController(fachada, sc);
        @SuppressWarnings("unused")
        TurnoController turnoController = new TurnoController(fachada, sc);

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Alta Paciente");
            System.out.println("2 - Alta Profesional");
            System.out.println("3 - Reservar Turno (pendiente)");
            System.out.println("4 - Listar Pacientes");
            System.out.println("5 - Listar Profesionales");
            System.out.println(" - Listar especialidades");
            System.out.println("10 - Salir");
            System.out.print("Opcion: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> pacienteController.altaPaciente();

                case 2 -> profesionalController.altaProfesional();

                case 3 -> {
                    System.out.println("Reservar turno - NO IMPLEMENTADO");
                }

                case 4 -> pacienteController.listarPacientes();

                // case 5 -> profesionalController.listarProfesionales();

                case 6 -> profesionalController.mostrarTiposEspecialidad();

                case 10 -> salir = true;

                default -> System.out.println("Opcion invalida");
            }
        }

        sc.close();
    }

}