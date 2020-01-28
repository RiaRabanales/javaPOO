package ejercicio3;

public class Cuenta {
    
    //Atributos:
    String nombreCliente;
    String numeroCuenta;
    double tipoInteres;
    double saldoCuenta;

    //Constructores:
    public Cuenta() {
    }
    
    public Cuenta(String nombreCliente, String numeroCuenta, double tipoInteres, double saldoCuenta) {
        this.nombreCliente = nombreCliente;
        this.numeroCuenta = numeroCuenta;
        this.tipoInteres = tipoInteres;
        this.saldoCuenta = saldoCuenta;
    }

    public Cuenta(Cuenta c1) {
        this.nombreCliente = c1.nombreCliente;
        this.numeroCuenta = c1.numeroCuenta;
        this.tipoInteres = c1.tipoInteres;
        this.saldoCuenta = c1.saldoCuenta;
    }

    //Setters y getters:
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }
    
    //Métodos:    
    public boolean ingresar (double ingreso) {
        if (ingreso >= 0) {
            /* lo de abajo es igual a:
            double nuevoSaldo = this.getSaldoCuenta();
            nuevoSaldo += ingreso;
            this.setSaldoCuenta(nuevoSaldo);
            */
            this.setSaldoCuenta(this.getSaldoCuenta() + ingreso);
            return true;
        } else {
            System.out.println("No se pueden ingresar cantidades negativas.");
            return false;
        }
    }
        
    public boolean reintegrar (double reintegro) {
        if (this.getSaldoCuenta() - reintegro >= 0) {
            /* double nuevoSaldo = this.getSaldoCuenta();
            nuevoSaldo -= reintegro;
            this.setSaldoCuenta(nuevoSaldo); */
            this.setSaldoCuenta(this.getSaldoCuenta() - reintegro);
            return true;
        } else {
            System.out.println("No hay saldo suficiente.");
            return false;
        }
    }
    
    public void transferir (Cuenta cuentaDestino, double importe) {
        if (this.getSaldoCuenta() - importe >= 0) {
            reintegrar(importe);
            cuentaDestino.ingresar(importe);
            System.out.println("Transferencia realizada.");
        } else {
            System.out.println("No hay saldo suficiente.");
        }
    }
    
}
