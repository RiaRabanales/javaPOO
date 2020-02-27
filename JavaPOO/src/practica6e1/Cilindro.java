package practica6e1;

public class Cilindro implements Figura {

    private double altura;
    private double radio;

    public Cilindro() {
    }

    public Cilindro(double altura, double radio) {
        this.altura = altura;
        this.radio = radio;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    @Override
    public void calcularArea() {
        //Realmente no me haría falta crear esta variable. Sólo voy a mantener esto aquí por comprensión.
        double area = (2 * Math.PI * this.getRadio() * this.getAltura()) + (2 * Math.PI * Math.pow(this.getRadio(), 2));
        System.out.println("  -Area: " + area);
    }

    @Override
    public void calcularVolumen() {
        System.out.println("  -Volumen: " + (Math.PI * this.getAltura() * Math.pow(this.getRadio(), 2)));
    }

    @Override
    public void imprimirCaracteristicas() {
        System.out.println("Calculadora de M. Rabanales:");
        System.out.println("CILINDRO:");
        System.out.println("  -Radio: " + getRadio());
        System.out.println("  -Altura: " + getAltura());
        this.calcularArea();
        this.calcularVolumen();
    }

    @Override
    public void calcularCaracteristicasPorArea(double valor) {
        System.out.println("¡Necesito demasiados datos!");
    }

    @Override
    public void calcularCaracteristicasPorVolumen(double valor) {
        System.out.println("¡Necesito demasiados datos!");
    }

}
