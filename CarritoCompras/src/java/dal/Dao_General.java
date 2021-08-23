package dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao_General {
   public  CallableStatement cst;  // Procedimientos Almacenados   
   public  Connection con;         // Alias para la Conexión
   public  ResultSet rst;          // Cursor
   
   public synchronized void Consultar(String tipo_Consulta, int datoBuscar)
   {  
       try
            {  
                con=Conexion.getConexion();
                cst = con.prepareCall("{call SPR_R_CONSULTAS (?,?)}");
                cst.setString(1, tipo_Consulta);
                cst.setInt(2, datoBuscar);                    
                rst = cst.executeQuery();
            }            
            catch (SQLException ex) {
                  System.out.println("Error " +ex); 
                  liberarRecursos();
            }           
            catch (Exception ex) {
                   System.out.println("Error " +ex);
                   liberarRecursos();
            }
   } 
   
  public synchronized void liberarRecursos()
  { // Garantizar que se cierren todos los objetos asociados a la Conexion
        try {            
            cst.close();
            con.close();            
        } catch (SQLException ex) {
           System.out.println("Error Liberando Recursos: " +ex);           
        }              
  }
}
