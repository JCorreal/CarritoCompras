package mbean;

import bll.ControladorProducto;
import bll.Funciones;
import modelo.Producto;

// Managed Bean Formulario Anadir Carrito
public class AnadirCarritoMBean {    
    private Producto producto = new Producto();
    
    public AnadirCarritoMBean() {        
        ControladorProducto controlador = Funciones.crearControladorProducto();
        producto = (Producto) controlador.obtenerProducto(); 
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }        
}
