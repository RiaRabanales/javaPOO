package practica3e2;

import java.util.ArrayList;
import java.util.Scanner;

//To format all the code in NetBeans, press Alt + Shift + F. 
//If you want to indent lines, select the lines and press Alt + Shift + right arrow key, and to unindent, Alt + Shift + left arrow key.
//para completar cosas: ctrl+espacio
public class MenuPrincipal {

    public static void main(String[] args) {
        ArrayList<Libro> biblioteca = new ArrayList<>();
        ArrayList<Autor> listaAutor = new ArrayList<>();
        Scanner lector = new Scanner(System.in);
        boolean salir = false;
        while (salir == false) {
            System.out.println("Elige:");
            System.out.println("  1- Introducir un libro");
            System.out.println("  2- Consultar libro");
            System.out.println("  3- Eliminar libro");
            System.out.println("  4- Introducir autor");
            System.out.println("  5- Consultar autor"); //no veo sentido en 'eliminar actor'
            System.out.println("  0- Salir");
            String opcion = lector.nextLine().trim();
            
            
            switch (opcion) {
                //Nuevo libro:
                case "1":
                    System.out.println("¿Es de un autor nuevo o de un autor ya existente en la biblioteca?");
                    System.out.println("  1- Nuevo");
                    System.out.println("  2- Existente");
                    String opcionAutor = lector.nextLine().trim();
                    Autor autorLibro = new Autor();
                    if (opcionAutor.equals("1")) {
                        System.out.println("Apellido del autor:");
                        String consultarApellido = lector.nextLine().trim();
                        consultarAutor(listaAutor, consultarApellido);
                    } else if (opcionAutor.equals("2")) {
                        autorLibro = introducirAutor(listaAutor);
                    } else {
                        System.out.println("Opción imposible.");
                    }
                    introducirLibro(biblioteca, autorLibro);
                    break;
                //Consultar libro:
                case "2":
                    System.out.println("Título a buscar:");
                    String t1 = lector.nextLine();
                    Libro libroEncontrado = consultarLibro(biblioteca, t1);
                    if (libroEncontrado == null) {
                        System.out.println("Este libro no existe en nuestra biblioteca.");
                    } else {
                        libroEncontrado.imprimirLibro();
                    }
                    break;
                //Eliminar libro:
                case "3":
                    System.out.println("Título a eliminar:");
                    String t2 = lector.nextLine();
                    biblioteca.remove(consultarLibro(biblioteca, t2));
                    break;
                //Nuevo autor:
                case "4":
                    introducirAutor(listaAutor);
                    break;
                //Introducir autor:
                case "5":
                    System.out.println("Apellido del autor:");
                    String consultarApellido = lector.nextLine().trim();
                    consultarAutor(listaAutor, consultarApellido);
                case "0":
                    salir = true;
                    System.out.println("Adiós.");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
            //TODO pensar más opciones
        }
        lector.close();
    }

    public static void introducirLibro(ArrayList<Libro> biblioteca, Autor autorLibro) {
        Libro l1 = new Libro();
        l1.introducirLibro(autorLibro);
        biblioteca.add(l1);
    }

    public static Libro consultarLibro(ArrayList<Libro> biblioteca, String titulo) {
        for (int i = 0; i < biblioteca.size(); i++) {
            if (biblioteca.get(i).getTituloLibro().equals(titulo)) {
                return biblioteca.get(i);    //así devuelvo el dato entero que busco
            }
        }
        return null;
    }
    
    public static Autor introducirAutor(ArrayList<Autor> lista) {
        Autor a1 = new Autor();
        a1.introducirAutor();
        lista.add(a1);
        return a1;
    }
    
    public static Autor consultarAutor(ArrayList<Autor> lista, String apellido) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getApellidosAutor().equals(apellido)) {
                return lista.get(i);
            }
        }
        return null;  //para decir que no he encontrado nada
    }

}
