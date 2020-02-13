package practica5e2;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {
    public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

        boolean salir = false;
        while (salir == false) {
            System.out.println(" ");
            System.out.println("Menú principal:");
            System.out.println("  1- Alta vehiculo");
            System.out.println("  2- Buscar vehiculos");
            System.out.println("  3- Solicitar taxi");
            System.out.println("  4- Mostrar vehiculos");
            System.out.println("  0- Salir");
            int opcionPrincipal = Integer.parseInt(lector.nextLine().trim());
            System.out.println(" ");

            switch (opcionPrincipal) {
                case 1:
                    //TODO: completar
                    break;
                case 2:
                    //TODO: completar
                    break;
                case 3:
                    //TODO: completar
                    break;
                case 4:
                    //TODO: completar
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        }
    }
}
