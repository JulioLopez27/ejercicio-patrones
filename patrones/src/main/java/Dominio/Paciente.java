package Dominio;

public class Paciente {

    private String nombre, correo, direccion;
    private int numSocio; // num identificador unico

    // Constructor
    public Paciente(String nombre, String correo, String direccion, int numSocio) {
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
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

    public String getCorreo() {
        return correo;
    }
    public String getDireccion() {
        return direccion;
    }
    public int getNumSocio() {
        return numSocio;
    }
    // #endregion
}
