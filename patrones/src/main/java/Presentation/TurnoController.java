package Presentation;

import java.time.LocalDateTime;
import java.util.Scanner;

import Services.FachadaSistema;

public class TurnoController {

    private final FachadaSistema fachada;
    private final Scanner sc;

    public TurnoController(FachadaSistema p_fachada, Scanner p_sc) {
        this.fachada = p_fachada;
        this.sc = p_sc;
    }

    public void crearTurno(int numSocio, int idMedico, LocalDateTime fechaHora) {
        try {
            fachada.crearTurno(numSocio, idMedico, fechaHora);
        } catch (Exception e) {
            // Manejo de excepciones (por ejemplo, mostrar un mensaje de error al usuario)
            System.out.println("Error al crear el turno: " + e.getMessage());
        }

    }

    public String cancelarTurno(int idTurno) {
        try {
            fachada.cancelarTurno(idTurno);
            return "Turno cancelado correctamente";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void confirmarTurno() {
        // Lógica para confirmar un turno
    }

    public void listarTurnos() {
        // Lógica para listar todos los turnos
    }

}
