
package mbean;

import bll.ControladorVenta;
import bll.Funciones;
import modelo.DetalleVenta;
import bll.Error;
import modelo.Venta;
import java.util.ArrayList;

// Managed Bean Formulario Resgistrar las ventas
public class RegistrarVentaMBean {
    private ArrayList<DetalleVenta> listadoGeneral;
    private Venta venta = new Venta();
    
    public RegistrarVentaMBean()
    {
       listadoGeneral = Funciones.carrito;      
    }

    
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    public ArrayList<DetalleVenta> getListadoGeneral() {
        return listadoGeneral;
    }

    public void setListadoGeneral(ArrayList<DetalleVenta> listadoGeneral) {
        this.listadoGeneral = listadoGeneral;
    }
    
    public String guardar() 
    {  
       if (this.listadoGeneral != null) 
       {
            String resultado = "NO";
            int rpta=0;       
            ControladorVenta controlador = Funciones.crearControladorVenta();         
            rpta = controlador.guardarVenta(venta);
            if (rpta == 1)
            {          
               Error.ElMensaje=Funciones.MensajeGrabaVenta;   
               Funciones.carrito=null;
               resultado = "SI";
            }
            else
            {          
               Error.ElMensaje=Funciones.MensajeErrorVenta;   
               resultado = "SI";
            }    
            Funciones.ParametroBuscar=null;            
            return resultado;
       }
       else
       {
           Error.ElMensaje=Funciones.MensajeErrorDatos;
           return "SinDatos";
       }
    }
}
