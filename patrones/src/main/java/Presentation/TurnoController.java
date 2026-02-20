package Presentation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import Dominio.Turno;
import Services.FachadaSistema;
import Utils.ValidadorFechas;

public class TurnoController {

    private final FachadaSistema fachada;
    private final Scanner sc;

    public TurnoController(FachadaSistema p_fachada, Scanner p_sc) {
        this.fachada = p_fachada;
        this.sc = p_sc;
    }

    public void crearTurno() {
        System.out.println("\n === CREAR TURNO ===");
        try {
            System.out.println("Ingrese documento de identificación del paciente: ");
            int numSocio = sc.nextInt();
            sc.nextLine();

            System.out.println("ID del médico: ");
            int idMedico = sc.nextInt();
            sc.nextLine();

            LocalDateTime fechaHora = leerFechaValida();

            Turno t = fachada.crearTurno(numSocio, idMedico, fechaHora);
            System.out.println("Turno creado con éxito: " + t);
        } catch (Exception e) {
            // Manejo de excepciones (por ejemplo, mostrar un mensaje de error al usuario)
            System.out.println("Error al crear el turno: " + e.getMessage());
        }
    }

    public void cancelarTurno() {
        System.out.println("\n === Cancelar turno===");
        try {

            System.out.println("Ingrese el identificador del turno a cancelar");
            int idTurno = sc.nextInt();
            sc.nextLine();
            fachada.cancelarTurno(idTurno);
            System.out.println("Turno cancelado con éxito.");
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }

    }

    public void confirmarTurno() {
        // Lógica para confirmar un turno
    }

    public void listarTurnos() {
        System.out.println("\n === LISTA DE TURNOS ===");
        List<Turno> turnos = fachada.listarTurnos();
        if (turnos.isEmpty()) {
            System.out.println("Aún no hay turnos registrados.");
        } else {
            for (Turno t : turnos) {
                System.out.println(t);
            }
        }
    }

    // metodo auxuliar
    private LocalDateTime leerFechaValida() {
        while (true) {
            try {
                System.out.println("Fecha y hora (formato: dd-MM-yyyy HH:mm): ");
                return ValidadorFechas.leerFecha(sc.nextLine());

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
