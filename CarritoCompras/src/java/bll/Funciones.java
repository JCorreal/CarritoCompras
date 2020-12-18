package bll;

import dal.ProductoBD;
import dal.VentaBD;
import modelo.DetalleVenta;
import java.util.ArrayList;

// Clase Transversal que contiene mensajes informativos
public class Funciones {  
    private static ProductoBD productobd;
    private static VentaBD ventabd;
    public static String Pagina = null;        
    public static String ParametroBuscar= null;    
    public static String NombreUsuario;
    public static String UsuarioConectado;
    public static int PerfilAcceso = 0;
    public static String MensajePrecio = "Debe ingresar el precio";
    public static String MensajeGrabaProducto = "Se registro el producto de manera correcta";    
    public static String MensajeActualizaProducto = "Se actualizo el producto de manera correcta";
    public static String MensajeErrorProducto  = "fallo en la transaccion del producto";
    public static String MensajeGrabaVenta = "Se registro la venta de manera correcta";
    public static String MensajeErrorVenta = "No se registro la venta";
    public static String MensajeErrorDatos = "No hay datos para registrar ventas";
    public static ArrayList<DetalleVenta> carrito; 
    
    public static ControladorProducto crearControladorProducto()
    {
        productobd = (ProductoBD) AccesoDatosFactory.getDao_ProductoBD();
        return new ControladorProducto(productobd);
    }
    
    public static ControladorVenta crearControladorVenta()
    {
        ventabd = (VentaBD) AccesoDatosFactory.getDao_VentaBD();
        return new ControladorVenta(ventabd);
    }
}

