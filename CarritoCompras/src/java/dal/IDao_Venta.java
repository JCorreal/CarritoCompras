package dal;

import modelo.DetalleVenta;
import modelo.Venta;
import java.util.ArrayList;

// Interfaz que expone los métodos para el Dao de Venta
public interface IDao_Venta {
    public ArrayList<DetalleVenta> obtenerVentas(); 
    public int guardarVenta(Venta venta);   
}
