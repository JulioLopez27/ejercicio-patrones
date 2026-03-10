package Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidadorFechas {
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    private ValidadorFechas() {}

    public static LocalDateTime leerFecha(String input) {
        try {
            return LocalDateTime.parse(input, formato);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido. Use el formato: dd-MM-yyyy HH:mm", e);
        }
    }
}
