package dal;

import modelo.Producto;
import java.util.ArrayList;

// Interfaz que expone los métodos para el Dao de Producto
public interface IDao_Producto {
    public ArrayList<Producto> obtenerProductos();
    public Producto obtenerProducto (int datoBuscar);
    public int guardarProducto(Producto producto);    
}
