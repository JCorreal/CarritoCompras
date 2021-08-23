package modelo;

// Clase que representa la estructura en BD para DetalleVenta
public class DetalleVenta {
    
    //Las columnas que tiene la tabla DetalleVenta
    private int codigoVenta;
    private int codigoProducto;
    private double cantidad =1;
    private double descuento;
    private Producto producto;
    private Venta venta;

    //Constructor Default sin parametros
    public DetalleVenta() {}
    
    //Metodos Get y Set de la clase
    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }    
}
