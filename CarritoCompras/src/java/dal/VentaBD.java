package dal;

import bll.Funciones;
import modelo.DetalleVenta;
import modelo.Producto;
import modelo.Venta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Types;

// DAO para Venta
public class VentaBD extends Dao_General implements IDao_Venta{    
    
    //Metodo utilizado para insertar una Venta y su respectivo Detalle a nuestra Base de datos
    @Override
    public synchronized int guardarVenta(Venta venta)
    {
        // Construir una variable donde vaciamos el contenido del carro separado por comas 
        String ContenidoCarro = "";
        for(int i=0; i<Funciones.carrito.size(); i++) {            
            ContenidoCarro = ContenidoCarro+String.valueOf(Funciones.carrito.get(i).getCodigoProducto())+",";
            ContenidoCarro = ContenidoCarro+String.valueOf(Funciones.carrito.get(i).getCantidad())+",";
            ContenidoCarro = ContenidoCarro+String.valueOf(Funciones.carrito.get(i).getDescuento())+",";
        }
        int resultado = -1;
        try {
            con = Conexion.getConexion();
            cst = con.prepareCall("{CALL SPR_I_VENTA(?,?,?)}");         
            cst.setString(1, venta.getCliente());
            cst.setString(2, ContenidoCarro.trim());
            cst.registerOutParameter(3, Types.INTEGER);
            cst.executeUpdate();
            resultado = cst.getByte(3);          
            cst.close();
            con.close();       
            Funciones.carrito = null;
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

    //Metodo utilizado para obtener todos las ventas de nuestra base de datos
    @Override
    public synchronized ArrayList<DetalleVenta> obtenerVentas() {
        ArrayList<DetalleVenta> lista = new ArrayList<>();        
        try {
            Consultar("venta_all",  0);
            while (rst.next()) {
                Venta venta=new Venta();
                Producto producto=new Producto();
                DetalleVenta detalleventa=new DetalleVenta();
                venta.setCodigoVenta(rst.getInt("CodigoVenta"));
                venta.setCliente(rst.getString("Cliente"));
                venta.setFecha(rst.getTimestamp("Fecha"));
                producto.setCodigoProducto(rst.getInt("CodigoProducto"));
                producto.setNombre(rst.getString("Nombre"));
                producto.setPrecio(rst.getDouble("Precio"));
                detalleventa.setCantidad(rst.getDouble("Cantidad"));
                detalleventa.setDescuento(rst.getDouble("Descuento"));
                detalleventa.setVenta(venta);
                detalleventa.setProducto(producto);                
                lista.add(detalleventa);
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
}
