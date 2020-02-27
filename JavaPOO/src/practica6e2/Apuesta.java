package practica6e2;

public abstract class Apuesta {
    
    //Atributos:
    private String nombre;
    private String apellidos;
    private int numeroApuesta;
    private static int contadorApuesta = 0;
    
    //Constructores:
    public Apuesta() {
    }
    
    public Apuesta(String nombre, String apellidos, int numeroApuesta) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroApuesta = numeroApuesta;
    }
    
    public Apuesta(Apuesta a1) {
        this.nombre = a1.nombre;
        this.apellidos = a1.apellidos;
        this.numeroApuesta = a1.numeroApuesta;
    }
    
    //Métodos:
    public void mostrarApuesta() {
        System.out.println("Apostador: " + this.getNombre() + " " + this.getApellidos());
        System.out.println("      con número de apuesta: " + this.getNumeroApuesta());
    }
    
    public void rellenarApuesta() {
        System.out.println("Introduce tus datos:");
        System.out.println("  -nombre:");
        this.setNombre(SimulacionLoteria.lector.nextLine().trim());
        System.out.println("  -apellidos:");
        this.setApellidos(SimulacionLoteria.lector.nextLine().trim());
        contadorApuesta += 1;
        this.setNumeroApuesta(contadorApuesta);
    }
    
    //Getters y setters:
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getNumeroApuesta() {
        return numeroApuesta;
    }

    public void setNumeroApuesta(int numeroApuesta) {
        this.numeroApuesta = numeroApuesta;
    }

    public static int getContadorApuesta() {
        return contadorApuesta;
    }

    public static void setContadorApuesta(int contadorApuesta) {
        Apuesta.contadorApuesta = contadorApuesta;
    }
    
}
