package practica2;

public class GestionarPersonas {
    public static void main(String[] args) {
        Persona personaje = new Persona();
        personaje.solicitarDatos();
        personaje.mostrarAtributos();
        //otra opción, aunque menos encapsulada: hacer aquí 
        //Nif nif1 = new Nif();
        //persona.getNif().solicitarDatos();
    }
}
