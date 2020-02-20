package practica5e2;

public class Vtc extends Vehiculo {
    private int maxHoras;
    private int kmRadio;
    private String ciudad;

    public Vtc() {
    }

    public Vtc(int maxHoras, int kmRadio, String ciudad, int id, String matricula, String modelo, int potencia) {
        super(id, matricula, modelo, potencia);
        this.maxHoras = maxHoras;
        this.kmRadio = kmRadio;
        this.ciudad = ciudad;
    }
    
    public Vtc(Vtc vtc1) {
        super(vtc1);
        this.maxHoras = vtc1.maxHoras;
        this.kmRadio = vtc1.kmRadio;
        this.ciudad = vtc1.ciudad;
    }

    public int getMaxHoras() {
        return maxHoras;
    }

    public void setMaxHoras(int maxHoras) {
        this.maxHoras = maxHoras;
    }

    public int getKmRadio() {
        return kmRadio;
    }

    public void setKmRadio(int kmRadio) {
        this.kmRadio = kmRadio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    @Override
    public void altaVehiculo() {
        super.altaVehiculo();
        do {System.out.println("  -horas máximas trabajadas:");
            this.setMaxHoras(Integer.parseInt(MenuPrincipal.lector.nextLine()));
        } while (this.getMaxHoras() > 24);
        do {
            System.out.println("  -radio de acción en km:");
            this.setKmRadio(Integer.parseInt(MenuPrincipal.lector.nextLine()));
        } while (this.getKmRadio() > 50);
        System.out.println("  -ciudad:");
        this.setCiudad(MenuPrincipal.lector.nextLine());
    }
    
    @Override
    public void mostrarVehiculo() {
        super.mostrarVehiculo();
        System.out.println("  -horas máximas trabajadas: " + this.getMaxHoras());
        System.out.println("  -radio de acción en km: " + this.getKmRadio());
        System.out.println("  -ciudad: " + this.getCiudad());
    }
}
