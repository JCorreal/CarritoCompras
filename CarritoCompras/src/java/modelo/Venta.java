package modelo;

import java.sql.Timestamp;

// Clase que representa la estructura en BD para Venta
public class Venta {
    
    //Las columnas que tiene la tabla Venta
    private int codigoVenta;
    private String cliente;
    private Timestamp fecha;
    
    //Constructor de la clase sin parametros
    public Venta() {}
    
    //Metodos get y set de la clase
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

}
