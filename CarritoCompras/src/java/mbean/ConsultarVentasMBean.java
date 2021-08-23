package mbean;

import bll.ControladorVenta;
import bll.Funciones;
import modelo.DetalleVenta;
import java.util.ArrayList;

// Managed Bean Formulario Consulta de Ventas
public class ConsultarVentasMBean {
    
 private ArrayList<DetalleVenta> listadoGeneral;
 
    public ConsultarVentasMBean()
    {
      ControladorVenta controlador = Funciones.crearControladorVenta();         
      listadoGeneral = controlador.obtenerVentas();
    }

    public ArrayList<DetalleVenta> getListadoGeneral() {
        return listadoGeneral;
    }

    public void setListadoGeneral(ArrayList<DetalleVenta> listadoGeneral) {
        this.listadoGeneral = listadoGeneral;
    }
    
    
}
