package practica6e1;

public class Esfera implements Figura {

    private double radio;

    public Esfera() {
    }

    public Esfera(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public void calcularArea() {
        System.out.println("  -Area: " + (4 * Math.PI * Math.pow(this.getRadio(), 2)));
    }

    @Override
    public void calcularVolumen() {
        System.out.println("  -Volumen: " + ((4 / 3) * Math.PI * Math.pow(this.getRadio(), 3)));
    }

    @Override
    public void imprimirCaracteristicas() {
        System.out.println("Calculadora de M. Rabanales:");
        System.out.println("ESFERA:");
        System.out.println("  -Radio: " + getRadio());
        this.calcularArea();
        this.calcularVolumen();
    }

    @Override
    public void calcularCaracteristicasPorArea(double valor) {
        this.setRadio(Math.sqrt(valor / (4 * Math.PI)));
        System.out.println("  -Radio: " + getRadio());
    }

    @Override
    public void calcularCaracteristicasPorVolumen(double valor) {
        this.setRadio(Math.cbrt(valor / ((4 / 3) * Math.PI)));
        System.out.println("  -Radio: " + getRadio());
    }

}
