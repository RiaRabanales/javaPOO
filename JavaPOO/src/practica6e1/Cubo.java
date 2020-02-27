package practica6e1;

public class Cubo implements Figura {

    private double altura;

    public Cubo() {
    }

    public Cubo(double altura) {
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public void calcularArea() {
        System.out.println("  -Area: " + (6 * Math.pow(this.getAltura(), 2)));
    }

    @Override
    public void calcularVolumen() {
        System.out.println("  -Volumen: " + (Math.pow(this.getAltura(), 3)));
    }

    @Override
    public void imprimirCaracteristicas() {
        System.out.println("Calculadora de M. Rabanales:");
        System.out.println("CUBO:");
        System.out.println("  -Altura: " + getAltura());   
        this.calcularArea();
        this.calcularVolumen();
    }

    @Override
    public void calcularCaracteristicasPorArea(double valor) {
        this.setAltura(Math.sqrt(valor / 6));
        System.out.println("  -Radio: " + getAltura());
    }

    @Override
    public void calcularCaracteristicasPorVolumen(double valor) {
        this.setAltura(Math.cbrt(valor));
        System.out.println("  -Radio: " + getAltura());    }

}
