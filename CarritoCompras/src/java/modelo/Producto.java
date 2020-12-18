package modelo;


// Clase que representa la estructura en BD para Producto
public class Producto {
    
    //Las columnas que tiene la tabla Producto
    private int codigoProducto;
    private String nombre;
    private double precio;
    private String foto;
    
    //Constructor de la clase sin parametros
    public Producto() {}
         
    //Metodos get y set de la clase
    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    
}

