package practica6e2;

import java.util.Arrays;

public class Primitiva extends Apuesta {

    //Constantes:
    public static final int NUMMIN = 1;
    public static final int NUMMAX = 49;
    public static final int ARRAYLEN = 6;

    //Atributos:
    private int[] listaNumeros = new int[ARRAYLEN];
    private int aciertos = 0;

    //Constructores:
    public Primitiva() {
    }

    public Primitiva(String nombre, String apellidos, int[] listaNumeros, int aciertos) {
        super(nombre, apellidos);
        this.listaNumeros = listaNumeros;
        this.aciertos = aciertos;
    }

    public Primitiva(String nombre, String apellidos) {
        super(nombre, apellidos);
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

    public void rellenarApuestaPrimitiva() {
        int[] miListaNumeros = new int[ARRAYLEN];
        for (int i = 0; i < ARRAYLEN; i++) {
            int miApuesta;
            do {
                System.out.println("Apuesta un número entre 1 y 49 (valor " + (i + 1) + " de " + ARRAYLEN + "):");
                miApuesta = Integer.parseInt(SimulacionLoteria.lector.nextLine().trim());
            } while ((NUMMIN > miApuesta) || (NUMMAX < miApuesta));
            miListaNumeros[i] = miApuesta;
        }
        this.setListaNumeros(miListaNumeros);
    }
    
    //genero una lista primitiva aleatoria:
    public static int[] generarPrimitiva() {
        int[] miArray = new int[ARRAYLEN];
        for (int i = 0; i < ARRAYLEN; i++) {
            int valor;
            //CUIDADO: los valores en una primitiva no se pueden repetir
            do {
                valor = (int)(Math.random() * (NUMMAX - NUMMIN + 1) + NUMMIN);
            } while (Arrays.asList(miArray).contains(valor));
            miArray[i] = valor;
        }
        return miArray;
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
