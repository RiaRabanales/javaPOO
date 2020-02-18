package practica3e1;

public class Cuenta {
    
    //Atributos:
    private String nombreCliente;
    private String numeroCuenta;
    private double tipoInteres;
    private double saldoCuenta;
    private String contrasena;

    //Constructores:
    public Cuenta() {
    }
    
    public Cuenta(String nombreCliente, String numeroCuenta, double tipoInteres, double saldoCuenta, String contrasena) {
        this.nombreCliente = nombreCliente;
        this.numeroCuenta = numeroCuenta;
        this.tipoInteres = tipoInteres;
        this.saldoCuenta = saldoCuenta;
        this.contrasena = contrasena;
    }

    public Cuenta(Cuenta c1) {
        this.nombreCliente = c1.nombreCliente;
        this.numeroCuenta = c1.numeroCuenta;
        this.tipoInteres = c1.tipoInteres;
        this.saldoCuenta = c1.saldoCuenta;
        this.contrasena = c1.contrasena;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    //Métodos:    
    //Nota: la creación de cuenta la he querido hacer por el menú principal y constructor
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
    
    public void imprimirCuenta() {
        System.out.println("Datos solicitados para la cuenta " + this.getNumeroCuenta() + ":");
        System.out.println("Nombre cliente: " + this.getNombreCliente());
        System.out.println("Tipo de interés: " + this.getTipoInteres());
        System.out.println("Saldo cuenta: " + this.getSaldoCuenta());
        System.out.println("Por motivos legales no se puede facilitar la contraseña por esta vía.");
    }
    
}
