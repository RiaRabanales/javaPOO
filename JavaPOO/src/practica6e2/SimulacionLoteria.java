package practica6e2;

import java.util.ArrayList;
import java.util.Scanner;

public class SimulacionLoteria {

    public static Scanner lector = new Scanner(System.in);
    private static ArrayList<Apuesta> listaApuestas = new ArrayList<>();

    public static void main(String[] args) {

        boolean salir = false;
        while (salir == false) {
            System.out.println("");
            System.out.println("SIMULADOR DE LOTERÍA");
            System.out.println("");
            System.out.println("  1- crear apuesta primitiva");
            System.out.println("  2- crear apuesta quiniela");
            System.out.println("  3- realizar simulación");
            System.out.println("  0- salir");

            String opcion = lector.nextLine().trim();

            switch (opcion) {
                case "1":
                    iniciarApuestaPrimitiva();
                    //TODO comprobar porq no va
                    break;
                case "2":
                    iniciarApuestaQuiniela();
                    break;
                case "3":
                    realizarSimulación();
                    break;
                case "0":
                    salir = true;
                    break;
                default:
                    System.out.println("ERROR. Elige de nuevo.");
                //TODO: ver si esto lo podría arreglar con una excepcion
            }
        }
    }

    public static void iniciarApuestaPrimitiva() {
        Primitiva miPrimitiva = new Primitiva();
        miPrimitiva.rellenarApuesta();
        listaApuestas.add(miPrimitiva);
        boolean repetir = true;
        do {
            System.out.println("¿Otra quiniela más? S/N");
            String opcionrepetir = lector.nextLine().trim().toUpperCase();
            if (opcionrepetir.equals("S")) {
                repetirApuestaPrimitiva(miPrimitiva);
            } else {
                System.out.println("Vuelta al menú principal.");        //paso de hacer un default
                repetir = false;
            }
        } while (repetir == true);
    }

    public static void repetirApuestaPrimitiva(Primitiva miPrimitiva) {
        Primitiva nuevaPrimitiva = new Primitiva(miPrimitiva);
        nuevaPrimitiva.setListaNumeros(null);
        nuevaPrimitiva.rellenarApuesta();
        listaApuestas.add(nuevaPrimitiva);
    }

public static void iniciarApuestaQuiniela() {
        Quiniela miQuiniela = new Quiniela();
        miQuiniela.rellenarApuesta();
        listaApuestas.add(miQuiniela);
        boolean repetir = true;
        do {
            System.out.println("¿Otra quiniela más? S/N");
            String opcionrepetir = lector.nextLine().trim().toUpperCase();
            if (opcionrepetir.equals("S")) {
                repetirApuestaQuiniela(miQuiniela);
            } else {
                System.out.println("Vuelta al menú principal.");        //paso de hacer un default
                repetir = false;
            }
        }
        while (repetir == true);        
    }
    
    public static void repetirApuestaQuiniela(Quiniela miQuiniela) {
        Quiniela nuevaQuiniela = new Quiniela(miQuiniela);
        nuevaQuiniela.setListaQuiniela(null);
        nuevaQuiniela.rellenarApuesta();
        listaApuestas.add(nuevaQuiniela);
    }


    public static void realizarSimulación() {
        //TODO
    }
}
