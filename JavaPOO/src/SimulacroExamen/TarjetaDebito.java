package SimulacroExamen;

public class TarjetaDebito extends Tarjeta {

    //Atributos:
    private int saldo;

    //Constructores:
    public TarjetaDebito() {
    }

    public TarjetaDebito(String nifCliente, int pinCliente, String nombreCliente, String apellidoCliente, int saldo) {
        super(nifCliente, pinCliente, nombreCliente, apellidoCliente);
        this.saldo = saldo;
    }

    public TarjetaDebito(TarjetaDebito td1) {
        super(td1);
        this.saldo = td1.saldo;
    }

    //Métodos:
    @Override
    public void mostrarTarjeta() {
        super.mostrarTarjeta();
        System.out.println("Saldo : " + this.getSaldo());
    }

    @Override
    public boolean comprobarSaldoDisponible(int cantidad) {
        System.out.println("Saldo actual de la tarjeta: " + this.getSaldo() + " €.");
        if (cantidad > this.getSaldo()) {
            System.out.println("No hay saldo suficiente.");
            return false;
        }
        return true;
    }

    @Override
    public void disminuirSaldoDisponible(int cantidad) {
        this.setSaldo(this.getSaldo() - cantidad);
        System.out.println("Saldo de la tarjeta tras la operación: " + this.getSaldo() + " €.");
    }

    //Getters y setters:
    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

}
