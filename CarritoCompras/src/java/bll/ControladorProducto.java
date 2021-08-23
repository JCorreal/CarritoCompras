package bll;

import dal.IDao_Producto;
import modelo.Producto;
import java.util.ArrayList;

// Controlador para Producto
public class ControladorProducto {
    protected IDao_Producto _productobd; 
    
    public ControladorProducto(IDao_Producto productobd)
    {
       _productobd = productobd;
    }
  
    public ArrayList<Producto> obtenerProductos()
    {
       return _productobd.obtenerProductos();
    }
    
    public Producto obtenerProducto()
    {
       return  _productobd.obtenerProducto(Integer.parseInt(Funciones.ParametroBuscar));
    }
    
    public int guardarProducto(Object objeto) 
    {   
        return _productobd.guardarProducto((Producto) objeto);        
    }
}
