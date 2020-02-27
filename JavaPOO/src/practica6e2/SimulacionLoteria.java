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
            
            switch(opcion) {
                case "1":
                    crearApuestaPrimitiva();
                    break;
                case "2":
                    crearApuestaQuiniela();
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
    
    public static void crearApuestaPrimitiva() {
        Primitiva miPrimitiva = new Primitiva();
        miPrimitiva.rellenarApuesta();
        //Aquí pido los valores para rellenar
        int[] listaPrimitiva = new int[6];
        for (int i = 0; i < listaPrimitiva.length; i++) {
            listaPrimitiva[i] = solicitarNumeroPrimitiva();
        }
        
        
        //TODO completar
    }
    
    public static void crearApuestaQuiniela() {
        //TODO
    }
    
    public static int solicitarNumeroPrimitiva() {
        //TODO: controlar excepciones para metodos solicitar numero
        System.out.println("Introduce el primer número:");
        int numero = Integer.parseInt(lector.nextLine().trim());
        return numero;
    }
    
    public static String solicitarValorQuiniela() {
        System.out.println("Introduce uno de:");
        System.out.println("   1- gana el equipo de la casa");
        System.out.println("   x- empate");
        System.out.println("   2- gana el equipo visitante");
        String valor = lector.nextLine().trim().toLowerCase();
        return valor;
        //TODO controlar respuesta
    }
    
    public static void realizarSimulación() {
        //TODO
    }
}
