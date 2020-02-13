package practica5e1;

public final class Comercial extends Empleado{
    private int ventasRealizadas;
    private double comision;

    public Comercial() {
    }

    public Comercial(int ventasRealizadas, double comision, String nombre, String apellido1, String apellido2, String nif, int edad, double salario) {
        super(nombre, apellido1, apellido2, nif, edad, salario);
        this.ventasRealizadas = ventasRealizadas;
        this.comision = comision;
    }
    
    public Comercial(Comercial c1) {
        super(c1);
        this.ventasRealizadas = c1.ventasRealizadas;
        this.comision = c1.comision;
    }

    public int getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(int ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
    
    @Override
    public void mostrarAtributos() {
        super.mostrarAtributos();
        System.out.println("Comisión: " + this.getComision());
        System.out.println("Ventas realizadas: " + this.getVentasRealizadas());
    }
    
    @Override
    public void pedirAlta() {
        super.pedirAlta();
        System.out.println("Comisión:");
        this.setComision(Double.parseDouble(MenuPrincipal.lector.nextLine()));
        System.out.println("Ventas realizadas:");
        this.setVentasRealizadas(Integer.parseInt(MenuPrincipal.lector.nextLine()));
    }
    
}
