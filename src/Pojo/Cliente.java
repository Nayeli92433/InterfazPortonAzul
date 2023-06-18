package Pojo;

public class Cliente {
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String telefono ;
    private String correo;
    private String estado;
    private String ciudad;
    private String colonia;
    private String codigoPostal;

    public Cliente(String nombre, String apellidoP, String direccion, String telefono, String correo, String estado, String ciudad, String colonia, String codigoPostal) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return
                nombre + "  " + apellidoP +
                "  " + apellidoM + "  " + telefono + " " + estado + "  "+ ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

}

