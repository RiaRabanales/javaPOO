package SimulacroExamen;

public class ExcepcionCajero extends Exception{
    private String mensajeExcepcion;
    
    //Constructor
    public ExcepcionCajero(int cantidad) {
        this.mensajeExcepcion = "Actualmente el cajero no dispone de efectivo suficiente para satisfacer la cantidad de " + cantidad + " € de su tarjeta.";
    }
    
    //Getter para poder imprimirlo:
    //TODO: ver si puedo hacer override a getMessage de Throwable
    public String getMensajeExcepcion() {
        return mensajeExcepcion;
    }
       
}
