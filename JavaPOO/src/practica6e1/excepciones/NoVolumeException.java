package practica6e1.excepciones;

//Esta igual quiero evitarme el throw así que hereda de Runtime
//Pero quiero coger el mensaje del padre
public class NoVolumeException extends RuntimeException{
    
    @Override
    public String getMessage() {
        return "Esta figura es 2D. No tiene volumen. Zopenco.";
    }
}
