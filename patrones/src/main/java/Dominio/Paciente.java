package Dominio;

public class Paciente {
    private String nombre;
    private String apellido;
    private String correo;
    private String numSocio; //num identificador unico

    // Constructor
    public Paciente(String nombre, String apellido, String correo, String numSocio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.numSocio = numSocio;
    }

    public void ingresarPaciente() {
        // Lógica para ingresar el paciente en el sistema
    }

    public void actualizarPaciente() {
        // Lógica para actualizar la información del paciente
    }

    public void bajaPaciente() {
        // Lógica para dar de baja al paciente en el sistema
    }

    // Getters
    // #region
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNumSocio() {
        return numSocio;
    }
    // #endregion
}
