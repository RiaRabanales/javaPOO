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
    
    
}
