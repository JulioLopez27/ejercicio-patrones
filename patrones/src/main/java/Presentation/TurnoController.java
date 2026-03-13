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
//TODO: separar UI de la logica
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

    // -------------------------------------------------------------------------------------
    public void reprogramarTurnoUI() {
        System.out.println("\n === Reprogramar Turno ===");
        System.out.println("\n == Ingrese su número de socio ==");
        try {
            int idPaciente = sc.nextInt();
            sc.nextLine();
            this.reprogramarTurnoLogica(idPaciente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void reprogramarTurnoLogica(int idPaciente) {
        // busco los turnos
        List<Turno> turnos = this.getTurnosDelPaciente(idPaciente);
        if (turnos.isEmpty()) {
            System.out.println("El usuario no posee turnos activos. ");
            return;
        }
        // los muestro en consola
        this.mostrarTurnosDelPaciente(turnos);
        // el usuario selecciona el turno

        Turno t = this.seleccionTurnoDelPaciente(turnos);
        // ingreso la nueva fecha para el turno

        LocalDateTime nuevaFecha = leerFechaValida();
        fachada.reprogramarTurno(t, nuevaFecha);
        System.out.println("Se reprogramó el turno exitosamente. ");
    }

    private List<Turno> getTurnosDelPaciente(int idPaciente) {
        return fachada.obtenerTurnosDelPaciente(idPaciente);
    }

    private void mostrarTurnosDelPaciente(List<Turno> t) {
        System.out.println("\n == Turnos del paciente == ");
        for (int i = 0; i < t.size(); i++) {
            System.out.println((i + 1) + " - " + t.get(i));
        }
    }

    private Turno seleccionTurnoDelPaciente(List<Turno> p_turno) {
        Turno t = null;
        while (t == null) {
            System.out.println("\n == Seleccione el turno ==");
            int opcion = sc.nextInt();
            sc.nextLine();

            if (opcion >= 1 && opcion <= p_turno.size()) {
                t = p_turno.get(opcion - 1);
            } else {
                System.out.println("Opción invalida, intente nuevamente. ");
            }
        }
        return t;
    }

    // ---------------------------------------------------------------------------
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

    // metodos auxuliar
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
