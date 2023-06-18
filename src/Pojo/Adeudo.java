package Pojo;

public class Adeudo {
    private String nombreCliente;
    private String apellidoP;
    private String apellidoM;
    private String tipoAdeudo;
    private String concepto;
    private String monto;
    private String fecha;
    private String descripcion;

    public Adeudo(String nombreCliente, String apellidoP, String apellidoM, String tipoAdeudo, String concepto, String monto, String fecha, String descripcion) {
        this.nombreCliente = nombreCliente;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.tipoAdeudo = tipoAdeudo;
        this.concepto = concepto;
        this.monto = monto;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public String getTipoAdeudo() {
        return tipoAdeudo;
    }

    public String getConcepto() {
        return concepto;
    }

    public String getMonto() {
        return monto;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombreCliente +" "+ apellidoP +" "+ apellidoM +
                "   ----Tipo de adeudo: " + tipoAdeudo + "  $ " + monto;
    }
}