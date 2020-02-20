package practica5e2;

public class Taxi extends Vehiculo {
    
    private static int contadorLicencia = 100;
    
    private int numLicencia;
    private boolean ocupado;   //entiendo true ocupado, false libre
    //VER: enums para poder llamarla Estado?????
    private int numTaxistas;

    public Taxi() {
    }

    public Taxi(int numLicencia, boolean ocupado, int numTaxistas, int id, String matricula, String modelo, int potencia) {
        super(id, matricula, modelo, potencia);
        this.setNumLicencia();
        this.ocupado = ocupado;
        this.numTaxistas = numTaxistas;
    }
    
    public Taxi(Taxi t1) {
        super(t1);
        //esta copia me implicaría que el número de licencia no es único
        this.numLicencia = t1.numLicencia;
        this.ocupado = t1.ocupado;
        this.numTaxistas = t1.numTaxistas;
    }

    public int getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia() {
        contadorLicencia += 1;
        this.numLicencia = contadorLicencia;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public int getNumTaxistas() {
        return numTaxistas;
    }

    public void setNumTaxistas(int numTaxistas) {
        this.numTaxistas = numTaxistas;
    }
    
    @Override
    public void altaVehiculo() {
        super.altaVehiculo();
        this.setOcupado(false);
        this.setNumLicencia();
        System.out.println("  -número de taxistas con esta licencia:");
        this.setNumTaxistas(Integer.parseInt(MenuPrincipal.lector.nextLine()));
    }
    
    @Override
    public void mostrarVehiculo() {
        super.mostrarVehiculo();
        System.out.println("  -número de licencia: " + this.getNumLicencia());
        System.out.println("  -número de taxistas con esta licencia: " + this.getNumTaxistas());
        if (this.isOcupado() == true) {
            System.out.println("  -estado: ocupado");
        } else {
            System.out.println("  -estado: libre");
        }
    }
    
    public void marcarOcupado() {
        this.setOcupado(true);
    }
    
    public void marcarDesocupado() {
        this.setOcupado(false);
    }
}
