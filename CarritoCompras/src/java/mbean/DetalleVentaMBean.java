package mbean;

import bll.ControladorProducto;
import bll.Funciones;
import bll.Error;
import modelo.DetalleVenta;
import modelo.Producto;
import java.util.ArrayList;

// Managed Bean para controlar los Detalles de la venta
public class DetalleVentaMBean {
    private DetalleVenta detalleventa = new DetalleVenta();
    private Producto producto;
        
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public DetalleVenta getDetalleventa() {
        return detalleventa;
    }

    public void setDetalleventa(DetalleVenta detalleventa) {
        this.detalleventa = detalleventa;
    }

    
    
    public boolean verificar()
    {
       boolean grabar=true;  
       if (this.detalleventa.getCantidad() == 0)
       {
           grabar = false;
           Error.ElMensaje="Cantidad debe ser mayor de cero";
       }
       return grabar;
    }
    
    public String anadirCarrito()
    {   
        if (verificar())
        {
        // Si no existe la sesion se crea el carrito de compras
        if (Funciones.carrito == null) {
            Funciones.carrito = new ArrayList<DetalleVenta>();
        }
        ControladorProducto controlador = Funciones.crearControladorProducto();
        Producto producto = (Producto) controlador.obtenerProducto();
        // Se obtienen los valores de la caja de texto
        detalleventa.setCodigoProducto(Integer.parseInt(Funciones.ParametroBuscar));
        detalleventa.setProducto(producto);
        
     /* Se calcula el descuento, donde si subtotal es mayor a 50 se le hace 
        un descuento del 5%, aca es donde se encuentra la logica del negocio 
        Esto, originalmente se estaba haciendo acá en el front, por lo menos
        el ejemplo inicialmente lo hacía de esa forma, yo lo que hice fue comentar
        este pedazo de código y hacerlo directamente en BD porque es más eficiente.
        
        double subTotal = producto.getPrecio() * detalleventa.getCantidad();
        if (subTotal > 50) {
            detalleventa.setDescuento(subTotal * (5D / 100D));
        } else {
            detalleventa.setDescuento(0);
        }*/
        
        // Sirve para saber si tenemos agregado el producto al carrito de compras
        int indice = -1;
        // Recorremos todo el carrito de compras
        for (int i = 0; i < Funciones.carrito.size(); i++) {
            DetalleVenta det = Funciones.carrito.get(i);
            if (det.getCodigoProducto() == producto.getCodigoProducto()) {                            
                /* Si el producto ya esta en el carrito, obtengo el indice dentro del arreglo para
                   actualizar al carrito de compras e incrementar la cantidad comprada de ese producto */
                indice = i;
                double Cantidad = det.getCantidad();
                Cantidad = (Cantidad + detalleventa.getCantidad());             
                det.setCantidad(Cantidad);
                break;
            }
        }
        if (indice == -1) {
            // Si es -1 es porque voy a agregar un nuevo item o producto al carro
            Funciones.carrito.add(detalleventa);
        } 
            
        
        return "Reg_Venta";
        }
        else
        {
            return "cantidad";
        }
    }
}
