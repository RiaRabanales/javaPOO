package practica6e2;

public class NoCapslockException extends Exception {
    
    @Override
    public String getMessage() {
        return "El nombre y los apellidos deben introducirse en mayúsculas.";
    }
}