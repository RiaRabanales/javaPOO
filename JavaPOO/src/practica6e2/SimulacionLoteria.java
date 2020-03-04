package practica6e2;

import java.util.Scanner;

public class SimulacionLoteria {

    public static Scanner lector = new Scanner(System.in);

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
        Quiniela miQuiniela = new Quiniela();
        miQuiniela.rellenarApuesta();
        
    }

    public static void iniciarApuestaQuiniela() {

    }

    public static void realizarSimulación() {
        //TODO
    }
}
