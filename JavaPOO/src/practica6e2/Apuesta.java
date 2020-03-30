package practica6e2;

public abstract class Apuesta {
    
    //Atributos:
    private String nombre;
    private String apellidos;
    private int numeroApuesta;
    //creo que aquí también tendría que poner 'aciertos', porque las dos tienen, pero el enunciado me indica que no.
    private static int contadorApuesta = 0;

    //Constructores:
    public Apuesta() {
    }

    public Apuesta(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.setNumeroApuesta();
    }

    public Apuesta(Apuesta a1) {
        this.nombre = a1.nombre;
        this.apellidos = a1.apellidos;
        this.setNumeroApuesta();
    }
    
    //Métodos:
    public void mostrarApuesta() {
        System.out.println("Apostador: " + this.getNombre() + " " + this.getApellidos());
        System.out.println("      con número de apuesta: " + this.getNumeroApuesta());
    }
    
    //Getters y setters:
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getApellidos() {
        return apellidos.toUpperCase();
        //Realmente esto no es necesario por el error
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getNumeroApuesta() {
        return numeroApuesta;
    }

    public void setNumeroApuesta() {
        contadorApuesta++;
        this.numeroApuesta = contadorApuesta;
    }


    
}
