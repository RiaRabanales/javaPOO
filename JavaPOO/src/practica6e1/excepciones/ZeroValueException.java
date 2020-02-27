package practica6e1.excepciones;

public class ZeroValueException extends Exception{
    
    @Override
    public String getMessage() {
        return "El valor no puede ser 0.";
    }
    
}
