package practica6e2;

import java.util.Arrays;

public class Primitiva extends Apuesta {
    //Atributos:
    private int[] listaNumeros = new int[6];
    private int aciertos = 0;
    
    //Constructores:
    public Primitiva() {
    }

    public Primitiva(String nombre, String apellidos, int numeroApuesta, int[] listaNumeros, int aciertos) {
        super(nombre, apellidos, numeroApuesta);
        this.listaNumeros = listaNumeros;
        this.aciertos = aciertos;
    }

    public Primitiva(Primitiva p1) {
        super(p1);
        this.listaNumeros = p1.listaNumeros;
        this.aciertos = p1.aciertos;
    }
    
    //Métodos:
    @Override
    public void mostrarApuesta() {
        super.mostrarApuesta();
        System.out.println("      Números de primitiva: " + Arrays.toString(this.getListaNumeros()));
        //TODO plantear para imprimir esto bonito
        System.out.println("      Aciertos: " + this.getAciertos());
    }
    
    @Override
    public void rellenarApuesta() {
        super.rellenarApuesta();
        //TODO porque lo que había aquí va en crearApuestaPrimitiva
    }
    
    public void crearApuestaPrimitiva() {
        
        for (int i = 0; i < listaNumeros.length; i++) {
            int miApuesta;
            do {
            System.out.println("Apuesta un número entre 1 y 49 (número " + (i + 1) + ":");
            miApuesta = Integer.parseInt(SimulacionLoteria.lector.nextLine().trim());
            } while ((1 > miApuesta) || (49 < miApuesta));
            listaNumeros[i] = miApuesta;
        }
    }
    
    //Getters y setters:
    public int[] getListaNumeros() {
        return listaNumeros;
    }

    public void setListaNumeros(int[] listaNumeros) {
        this.listaNumeros = listaNumeros;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }
        
}
