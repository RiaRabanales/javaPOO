package practica5e2;

public class Vehiculo {
    //campo para controlar el num. de instancias totales
    private static int numVehiculos = 0;
    
    private int id;
    private String matricula;
    private String modelo;
    private int potencia;

    public Vehiculo() {
    }

    public Vehiculo(int id, String matricula, String modelo, int potencia) {
        this.id = id;
        this.matricula = matricula;
        this.modelo = modelo;
        this.potencia = potencia;
    }
    
    public Vehiculo(Vehiculo v1) {
        this.id = v1.id;
        this.matricula = v1.matricula;
        this.modelo = v1.modelo;
        this.potencia = v1.potencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int numVehiculos) {
        numVehiculos += 1;
        this.id = numVehiculos;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    
    public void altaVehiculo() {
        this.setId(numVehiculos);
        System.out.println("Introducir:");
        System.out.println("  -matrícula:");
        this.setMatricula(MenuPrincipal.lector.nextLine());
        System.out.println("  -modelo:");
        this.setModelo(MenuPrincipal.lector.nextLine());
        System.out.println("  -potencia:");
        this.setPotencia(Integer.parseInt(MenuPrincipal.lector.nextLine()));
    }
    
    public void mostrarVehiculo() {
        System.out.println("Vehículo con id " + this.getId());
        System.out.println("  -matrícula: " + this.getMatricula());
        System.out.println("  -modelo: " + this.getModelo());
        System.out.println("  -potencia: " + this.getPotencia());
    }
}
