package SimulacroExamen;

//Es abstracta porque no existen 'simples' tarjetas
public abstract class Tarjeta {
    
    //Atributo:
    private String nifCliente;
    private int pinCliente;
    private String nombreCliente;
    private String apellidoCliente;
    
    //Constructores:
    public Tarjeta() {
    }

    public Tarjeta(String nifCliente, int pinCliente, String nombreCliente, String apellidoCliente) {
        this.nifCliente = nifCliente;
        this.pinCliente = pinCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }
    
    public Tarjeta(Tarjeta t1) {
        this.nifCliente = t1.nifCliente;
        this.pinCliente = t1.pinCliente;
        this.nombreCliente = t1.nombreCliente;
        this.apellidoCliente = t1.apellidoCliente;
    }
    
    //Métodos:
    public void mostrarTarjeta() {
        System.out.println("Cliente: " + this.getNombreCliente() + " " + this.getApellidoCliente());
        System.out.println("NIF cliente: " + this.getNifCliente());
        System.out.println("Pin cliente: " + this.getPinCliente());
    }
    
    public abstract boolean comprobarSaldoDisponible(int cantidad);
    
    public abstract void disminuirSaldoDisponible(int cantidad);

    //Getters y setters:
    public String getNifCliente() {
        return nifCliente;
    }

    public void setNifCliente(String nifCliente) {
        this.nifCliente = nifCliente;
    }

    public int getPinCliente() {
        return pinCliente;
    }

    public void setPinCliente(int pinCliente) {
        this.pinCliente = pinCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }
    
}
