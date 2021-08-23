package bll;

import dal.IDao_Producto;
import dal.IDao_Venta;
import dal.ProductoBD;
import dal.VentaBD;

/*  Aquí emplearemos el patrón de Creación: Factory Method al cual
    le pasaremos como argumento las Interfaces IDao_Producto o 
    IDao_Venta, e invocaremos dependiendo del DAO requerido los 
    métodos: CrearControladorProducto o CrearControladorVenta 
    alojados en la clase Funciones que nos devolverá, el DAO 
    solicitado ya sea ProductoDB o VentaDB.
  
    Este patrón nos ahorra trabajo, puesto que nos libera sobre la forma 
    correcta de crear objetos, dada su flexibilidad al utilizar una clase 
    constructora (al estilo del Abstract Factory). 
 */
 
public class AccesoDatosFactory {
    
    public static IDao_Producto getDao_ProductoBD()
    {
        return new ProductoBD();
    }
    
    public static IDao_Venta getDao_VentaBD()
    {
        return new VentaBD();
    }
}
