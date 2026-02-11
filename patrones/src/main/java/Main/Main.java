package Main;

import java.util.List;
import java.util.Scanner;

import Dominio.TipoEspecialidad;
import Presentation.ProfesionalController;
import Services.FachadaSistema;

public class Main {
    public static void main(String[] args) {
        FachadaSistema fachada = new FachadaSistema();
        ProfesionalController pc = new ProfesionalController();
        Scanner sc = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Alta Paciente");
            System.out.println("2 - Alta Profesional");
            System.out.println("3 - Reservar Turno (pendiente)");
            System.out.println("4 - Listar Pacientes");
            System.out.println("5 - Listar especialidades");
            System.out.println("10 - Salir");
            System.out.print("Opcion: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Direccion: ");
                    String direccion = sc.nextLine();
                    System.out.print("Correo: ");
                    String correo = sc.nextLine();
                    System.out.print("DNI: ");
                    // TODO: validar que el dni sea un numero entero
                    int dni = sc.nextInt();
                    sc.nextLine(); // limpiar buffer

                    fachada.altaPaciente(dni, nombre, direccion, correo);
                }

                case 2 -> altaProfesional(pc, sc);

                case 3 -> {
                    System.out.println("Reservar turno - NO IMPLEMENTADO");
                }

                // case 4 -> fachada.listarPacientes();

                case 5 -> pc.mostrarTiposEspecialidad();

                case 10 -> salir = true;

                default -> System.out.println("Opcion invalida");
            }
        }

        sc.close();
    }

    private static void altaProfesional(ProfesionalController pc, Scanner sc) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("DNI: ");
        int dni = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        List<TipoEspecialidad> tiposEspecialidad = pc.mostrarTiposEspecialidad();
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
        pc.altaProfesional(dni, nombre, correo, especialidad);
    }
}