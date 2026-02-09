package Dominio;

public class Paciente {

    private String nombre, correo, direccion;
    private int numSocio, dni; // num identificador unico
    private static int contadorSocios = 1;

    // Constructor
    public Paciente(int dni, String nombre, String correo, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.numSocio = contadorSocios++;
    }

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

    public int getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numSocio=" + numSocio +
                '}';
    }
}
