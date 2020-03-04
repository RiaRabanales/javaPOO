package SimulacroExamen;

public class TarjetaCredito extends Tarjeta {

    //Atributos:
    private int saldoDisponible;
    private int creditoDisponible;

    //Constructores:
    public TarjetaCredito() {
    }

    public TarjetaCredito(String nifCliente, int pinCliente, String nombreCliente, String apellidoCliente, int saldoDisponible, int creditoDisponible) {
        super(nifCliente, pinCliente, nombreCliente, apellidoCliente);
        this.saldoDisponible = saldoDisponible;
        this.creditoDisponible = creditoDisponible;
    }

    public TarjetaCredito(TarjetaCredito tc1) {
        super(tc1);
        this.saldoDisponible = tc1.saldoDisponible;
        this.creditoDisponible = tc1.creditoDisponible;
    }

    //Métodos:
    @Override
    public void mostrarTarjeta() {
        super.mostrarTarjeta();
        System.out.println("Saldo disponible: " + this.getSaldoDisponible());
        System.out.println("Crédito disponible: " + this.getCreditoDisponible());
    }

    //Estos dos métodos me comprueban el saldo y luego me lo descuentan
    @Override
    public boolean comprobarSaldoDisponible(int cantidad) {
        System.out.println("Saldo actual de la tarjeta: " + this.getSaldoDisponible() + " €.");
        System.out.println("Crédito disponible: " + this.getCreditoDisponible() + " €.");
        if (cantidad > (this.getSaldoDisponible() + this.getCreditoDisponible())) {
            System.out.println("No hay saldo+crédito suficiente.");
            return false;
        }
        return true;
    }

    @Override
    public void disminuirSaldoDisponible(int cantidad) {
        this.setSaldoDisponible(this.getSaldoDisponible() - cantidad);
        if (this.getSaldoDisponible() < 0) {
            this.setCreditoDisponible(this.getCreditoDisponible() - this.getSaldoDisponible());
            this.setSaldoDisponible(0);
            System.out.println("Saldo de la tarjeta tras la operación: " + this.getSaldoDisponible() + " €.");
            System.out.println("Crédito disponible: " + this.getCreditoDisponible() + " €.");
        }

    }

    //Getters y setters:
    public int getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(int saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public int getCreditoDisponible() {
        return creditoDisponible;
    }

    public void setCreditoDisponible(int creditoDisponible) {
        this.creditoDisponible = creditoDisponible;
    }

}
