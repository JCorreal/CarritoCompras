package bll;

public class Error {
    
    private String MensajeError;
    public static String ElMensaje ;
    
    public Error() {     
        this.MensajeError =ElMensaje ;
    }

    public String getMensajeError() {
        return MensajeError;
    }

    public  void setMensajeError(String MensajeError) {
       this.MensajeError = MensajeError;
    }

       
    
}
