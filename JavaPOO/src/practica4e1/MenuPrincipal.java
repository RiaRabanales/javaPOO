package practica4e1;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {
    
    //En el método main tengo el menú principal:
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        ArrayList<Pelicula> filmoteca = new ArrayList<>();
        boolean salir = false;
        while (salir == false) {
            System.out.println("=========================");
            System.out.println("       = MENU =");
            System.out.println("=========================");
            System.out.println("  1- añadir película");
            System.out.println("  2- reservar película");
            System.out.println("  3- buscar película");
            System.out.println("  4- salir");
            String opcion = lector.nextLine();
            switch (opcion) {
                case "1":
                    //TODO: comprobar lo del numero de copias
                    //me interesaria crear un constructor majo
                    Pelicula nuevaPelicula = new Pelicula();
                    nuevaPelicula.introducirPelicula(lector);
                    filmoteca.add(nuevaPelicula);
                    break;
                case "2":
                    reservarPeliculaProceso();
                    break;
                case "3":
                    buscarPelicula();
                    break;
                case "4":
                    salir = true;
                    System.out.println("Adiós.");
                    break;
                default:
                    System.out.println("Esta opción no es correcta.");
            }
        }
        
    }
    
    
    //A partir de aquí están los métodos específicos
    
    //Este a su vez me llamará al reservarPelicula de la otra clase
    public static void reservarPeliculaProceso() {
        //TODO: completar
    }
    
    
    public static void buscarPelicula() {
        //TODO: completar
    }
}
