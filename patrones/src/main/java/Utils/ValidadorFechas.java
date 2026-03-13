package Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class ValidadorFechas {
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    private ValidadorFechas() {
    }

    public static LocalDateTime leerFecha(String input) {
        try {
            LocalDateTime fecha = LocalDateTime.parse(input, formato);
            fecha = fecha.truncatedTo(ChronoUnit.MINUTES);
            if(fecha.isBefore(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES)))
            {
                throw new IllegalArgumentException("No se puede ingresar fechas pasadas. ");
            }
            return fecha;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido. Use el formato: dd-MM-yyyy HH:mm", e);
        }
    }
}
