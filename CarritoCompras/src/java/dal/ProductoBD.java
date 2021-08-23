package dal;

import modelo.Producto;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

// DAO para Producto
public class ProductoBD extends Dao_General implements IDao_Producto {
    
    //Metodo utilizado para insertar y/o actualizar un Producto a nuestra Base de datos    
    @Override
    public synchronized int guardarProducto(Producto producto) {           
        int resultado = 0;
        try {            
            con = Conexion.getConexion();
            cst = con.prepareCall("{CALL SPR_IU_PRODUCTO(?,?,?,?)}");            
            cst.setInt(1, producto.getCodigoProducto());
            cst.setString(2, producto.getNombre());
            cst.setDouble(3, producto.getPrecio());
            cst.registerOutParameter(4, Types.INTEGER);
            cst.executeUpdate();
            resultado = cst.getByte(4);  
	    cst.close();
            con.close();
        }
        catch (SQLException ex) {
               System.out.println("Error : " +ex);
               liberarRecursos();
        }
       catch (Exception ex) {
               System.out.println("Error : " +ex);
               liberarRecursos();
        }
        finally{
	      liberarRecursos();
	    }
        return resultado;
    }

    //Metodo utilizado para obtener todos los productos de nuestra base de datos
    @Override
    public synchronized ArrayList<Producto> obtenerProductos() {
        ArrayList<Producto> lista = new ArrayList<>();        
        try {
            Consultar("producto_all",  0);
            while (rst.next()) {
                Producto producto = new Producto();
                producto.setCodigoProducto(rst.getInt("codigoProducto"));
                producto.setNombre(rst.getString("nombre"));
                producto.setPrecio(rst.getDouble("precio"));
                producto.setFoto(rst.getString("foto"));
                lista.add(producto);
            }
            rst.close();     
        }
        catch (SQLException ex) {
               System.out.println("Error : " +ex);
               liberarRecursos();
        }
       catch (Exception ex) {
               System.out.println("Error : " +ex);
               liberarRecursos();
        }
        finally{
	      liberarRecursos();
	    }
        return lista;
    }

    //Metodo utilizado para obtener un Producto de nuestra base de datos
    @Override
    public synchronized Producto obtenerProducto(int codigo) {
        Producto producto = new Producto();        
        try {
            Consultar("producto_one",  codigo);
            if (rst.next ())
            {
                producto.setCodigoProducto(rst.getInt("codigoProducto"));
                producto.setNombre(rst.getString("nombre"));
                producto.setPrecio(rst.getDouble("precio"));
            }
            else
            {
                producto = null;
            }
            rst.close();                 
        }        
        catch (SQLException ex) {
               System.out.println("Error : " +ex);
               liberarRecursos();
        }
       catch (Exception ex) {
               System.out.println("Error : " +ex);
               liberarRecursos();
        }
        finally{
	      liberarRecursos();
	    }    
        return producto;
    }    
    
}
