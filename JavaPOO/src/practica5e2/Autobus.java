package practica5e2;

public class Autobus extends Vehiculo {
    private int numPlazas;
    private int numParadas;

    public Autobus() {
    }

    public Autobus(int numPlazas, int numParadas, int id, String matricula, String modelo, int potencia) {
        super(id, matricula, modelo, potencia);
        this.numPlazas = numPlazas;
        this.numParadas = numParadas;
    }
    
    public Autobus(Autobus a1) {
        super(a1);
        this.numPlazas = a1.numPlazas;
        this.numParadas = a1.numParadas;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    public int getNumParadas() {
        return numParadas;
    }

    public void setNumParadas(int numParadas) {
        this.numParadas = numParadas;
    }
    
    @Override
    public void altaVehiculo() {
        super.altaVehiculo();
        System.out.println("  -número de plazas:");
        this.setNumPlazas(Integer.parseInt(MenuPrincipal.lector.nextLine()));
        do {
            System.out.println("  -número de paradas:");
            this.setNumParadas(Integer.parseInt(MenuPrincipal.lector.nextLine()));
        } while (this.getNumParadas() >= 3 && this.getNumParadas() <= 20);
    }
    
    @Override
    public void mostrarVehiculo() {
        super.mostrarVehiculo();
        System.out.println("  -número de licencia: " + this.getNumPlazas());
        System.out.println("  -número de taxistas con esta licencia: " + this.getNumParadas());
    }
}
