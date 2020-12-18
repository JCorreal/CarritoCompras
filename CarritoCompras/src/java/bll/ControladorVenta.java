package bll;

import dal.IDao_Venta;
import modelo.DetalleVenta;
import modelo.Venta;
import java.util.ArrayList;

// Controlador para Venta
public class ControladorVenta {
    protected IDao_Venta _ventabd; 

    public ControladorVenta(IDao_Venta ventabd)
    {
       _ventabd = ventabd;
    }
    
    public ArrayList<DetalleVenta> obtenerVentas()
    {
       return _ventabd.obtenerVentas();
    }
   
    public int guardarVenta(Object objeto) 
    {   
        return _ventabd.guardarVenta((Venta) objeto);        
    }
}