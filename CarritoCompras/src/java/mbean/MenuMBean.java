package mbean;

import java.util.ArrayList;
import modelo.Producto;
import bll.ControladorProducto;
import bll.Error;
import bll.Funciones;

public class MenuMBean {
    
     private ArrayList<Producto> listadoGeneral;
    
    public MenuMBean()
    {
      Error.ElMensaje="";  
      Funciones.ParametroBuscar = null;  
      ControladorProducto controlador = Funciones.crearControladorProducto();
      listadoGeneral = controlador.obtenerProductos();
    }
    
    public String forma(String Valor, String Codigo)
    {    
      if (!"N".equals(Codigo))
      {
        Funciones.ParametroBuscar = Codigo;
      }
      else
      {
       Funciones.ParametroBuscar = null;
      }  
      return Valor;
    }

    public ArrayList<Producto> getListadoGeneral() {
        return listadoGeneral;
    }

    public void setListadoGeneral(ArrayList<Producto> listadoGeneral) {
        this.listadoGeneral = listadoGeneral;
    }    
}

    

