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
        TurnoController turnoController = new TurnoController(fachada, sc);

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Alta Paciente");
            System.out.println("2 - Alta Profesional");
            System.out.println("3 - Reservar Turno");
            System.out.println("4 - Cancelar turno");
            System.out.println("7 - Listar Pacientes");
            System.out.println("8 - Listar Profesionales");
            System.out.println("9 - Listar Turnos");
            System.out.println("10 - Listar especialidades");
            System.out.println("11.5 - Caca");
            System.out.println("11 - Salir");
            System.out.print("Opcion: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> pacienteController.altaPaciente();

                case 2 -> profesionalController.altaProfesional();

                case 3 -> turnoController.crearTurno();

                case 4 -> turnoController.cancelarTurno();

                case 7 -> pacienteController.listarPacientes();

                case 8 -> profesionalController.listarProfesionales();

                case 9 -> turnoController.listarTurnos();

                case 10 -> profesionalController.mostrarTiposEspecialidad();

                case 11 -> salir = true;

                default -> System.out.println("Opcion invalida");
            }
        }

        sc.close();
    }

}