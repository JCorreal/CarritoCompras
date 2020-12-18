package dal;

import dal.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao_Variables {
   public  CallableStatement cst;  // Procedimientos Almacenados   
   public  Connection con;         // Alias para la Conexión
   public  ResultSet rst;          // Cursor
   
   public synchronized void Consultar(String Tipo_Consulta, int DatoBuscar)
   {  
       try
            {  
                con=Conexion.getConexion();
                cst = con.prepareCall("{call SPR_R_CONSULTAS (?,?)}");
                cst.setString(1, Tipo_Consulta);
                cst.setInt(2, DatoBuscar);                    
                rst = cst.executeQuery();
            }            
            catch (SQLException ex) {
                  System.out.println("Error " +ex); 
                  LiberarRecursos();
            }           
            catch (Exception ex) {
                   System.out.println("Error " +ex);
                   LiberarRecursos();
            }
   } 
   
  public synchronized void LiberarRecursos()
  { // Garantizar que se cierren todos los objetos asociados a la Conexion
        try {            
            cst.close();
            con.close();            
        } catch (SQLException ex) {
           System.out.println("Error Liberando Recursos: " +ex);           
        }              
  }
}
