package practica6e1;

import practica6e1.excepciones.NoVolumeException;

public class Circulo implements Figura {

    //Originalmente tenía cono. Cambio por círculo para enfrentarme al volumen.
    private double radio;

    public Circulo() {
    }

    public Circulo(double radio) {
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
        System.out.println("  -Area: " + (Math.PI * Math.pow(this.getRadio(), 2)));
    }

    @Override
    public void calcularVolumen(){
        System.out.println("  -Volumen: no tiene.");;
    }
    
    @Override
    public void imprimirCaracteristicas() {
        System.out.println("Calculadora de M. Rabanales:");
        System.out.println("CIRCULO:");
        System.out.println("  -Radio: " + getRadio());
        this.calcularArea();
        this.calcularVolumen();
    }
    
    @Override
    public void calcularCaracteristicasPorArea(double valor) {
        this.setRadio(Math.sqrt(valor / Math.PI));
        System.out.println("  -Radio: " + getRadio());
    }
    
    @Override
        //Parece que puedo lanzar un throw aunque el padre no lo tenga
    public void calcularCaracteristicasPorVolumen(double valor) throws NoVolumeException{
        throw new NoVolumeException();
    }

}
