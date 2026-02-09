package Main;

import java.util.Scanner;

import Services.FachadaSistema;

public class Main {
    public static void main(String[] args) {
        FachadaSistema fachada = new FachadaSistema();
        Scanner sc = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Alta Paciente");
            System.out.println("2 - Alta Profesional");
            System.out.println("3 - Reservar Turno (pendiente)");
            System.out.println("4 - Listar Pacientes");
            System.out.println("5 - Salir");
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
                    //TODO: validar que el dni sea un numero entero
                    int dni = sc.nextInt();
                    sc.nextLine(); // limpiar buffer

                    fachada.altaPaciente(dni, nombre, direccion, correo);
                }

                case 2 -> {
                    System.out.print("Nombre del profesional: ");
                    String nombre = sc.nextLine();
                    // fachada.altaProfesional(nombre);
                }

                case 3 -> {
                    System.out.println("Reservar turno - NO IMPLEMENTADO");
                }

                // case 4 -> fachada.listarPacientes();

                case 5 -> salir = true;

                default -> System.out.println("Opcion invalida");
            }
        }

        sc.close();
    }

}