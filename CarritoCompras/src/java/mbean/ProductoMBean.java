package mbean;

import bll.ControladorProducto;
import bll.Funciones;
import modelo.Producto;
import bll.Error;

// Managed Bean Formulario Productos
public class ProductoMBean {
    private Producto producto = new Producto();

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public ProductoMBean()
    {
      if (Funciones.ParametroBuscar==null)
      {
        this.producto = new Producto ();   
      }
      else
      {
          ControladorProducto controlador = Funciones.crearControladorProducto();
          Producto tmp_producto = (Producto) controlador.obtenerProducto();
          if (tmp_producto != null)
          {           
              this.producto = tmp_producto ;              
          }
      }     
    }
    
    public String guardar() 
    {    
       String resultado = "NO"; 
       if (this.producto.getPrecio() > 1) 
       {
            ControladorProducto controlador = Funciones.crearControladorProducto();
            int rpta =  controlador.guardarProducto(producto);
            if (rpta == 1)
            {          
               Error.ElMensaje=Funciones.MensajeGrabaProducto;   
               resultado = "SI";
            }
            else if (rpta == 2)
            {          
               Error.ElMensaje=Funciones.MensajeActualizaProducto;   
               resultado = "SI";
            }    
            else
            {          
               Error.ElMensaje=Funciones.MensajeErrorProducto;                           
            }
            Funciones.ParametroBuscar=null;         
       }
       else
       {
          Error.ElMensaje=Funciones.MensajePrecio; 
          resultado = "PRECIO";          
       }
       return resultado;
    }
}
