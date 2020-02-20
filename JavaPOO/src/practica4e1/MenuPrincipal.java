package practica4e1;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {

    //Primero declaro la constante de película:
    private static final int MAXPELICULAS = 3000;

    //En el método main tengo el menú principal:
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        ArrayList<Pelicula> filmoteca = new ArrayList<>();

        boolean salir = false;

        while (!salir) {
            System.out.println("=========================");
            System.out.println("       = MENU =");
            System.out.println("=========================");
            System.out.println("  1- añadir película");
            System.out.println("  2- reservar película");
            System.out.println("  3- buscar película");
            System.out.println("  4- salir");
            String opcion = lector.nextLine().trim();
            System.out.println("=========================");

            switch (opcion) {
                case "1":
                    anadirPelicula(lector, filmoteca);
                    break;
                case "2":
                    reservarPeliculas(filmoteca, lector);
                    break;
                case "3":
                    buscarPelicula(filmoteca, lector);
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
    public static void anadirPelicula(Scanner lector, ArrayList<Pelicula> filmoteca) {
        System.out.println("¿Cuántas copias de la película quieres añadir?");
        int copiasNuevaPelicula = Integer.parseInt(lector.nextLine());
        if (contarPeliculas(filmoteca) + copiasNuevaPelicula >= MAXPELICULAS) {
            System.out.println("El videoclub no puede almacenar estas copias.");
        } else {
            Pelicula nuevaPelicula = new Pelicula(copiasNuevaPelicula, 0);
            nuevaPelicula.introducirPelicula(lector);
            filmoteca.add(nuevaPelicula);
        }
    }

    //Este método me calcula el total de películas cada vez; no quiero crear variable aparte.
    public static int contarPeliculas(ArrayList<Pelicula> filmoteca) {
        int totalPeliculas = 0;
        for (int i = 0; i < filmoteca.size(); i++) {
            totalPeliculas += filmoteca.get(i).getCopiasTotal();
        }
        return totalPeliculas;
    }

    //Este a su vez me llamará al reservarPelicula de la otra clase
    public static void reservarPeliculas(ArrayList<Pelicula> filmoteca, Scanner lector) {
        System.out.println("Películas en nuestro videoclub:");
        listarPeliculas(filmoteca);
        int encontradoId = buscarPeliculaId(filmoteca, lector);
        //entiendo que solo se puede reservar una copia cada vez
        //quiero garantizar que no me peta por fuera de rango:
        if (encontradoId != -1) {
            if (!filmoteca.get(encontradoId).isDisponibilidad()) {
                System.out.println("Esta película no está disponible en estos momentos.");
            } else {
                filmoteca.get(encontradoId).reservarPelicula();
                System.out.println("Has reservado tu película.");
            }
        }
    }

    //Este método muestra información de todos los títulos
    public static void listarPeliculas(ArrayList<Pelicula> filmoteca) {
        for (int i = 0; i < filmoteca.size(); i++) {
            filmoteca.get(i).imprimirPelicula();
        }
    }

    //A partir de aquí incluyo todos mis métodos de búsqueda:
    public static void buscarPelicula(ArrayList<Pelicula> filmoteca, Scanner lector) {
        System.out.println("¿Qué tipo de búsqueda quieres realizar?");
        System.out.println("  -1. Por ID");
        System.out.println("  -2. Por título");
        System.out.println("  -3. Por director");
        System.out.println("  -4. Por género");
        System.out.println("  -5. Por duración");
        System.out.println("  -6. Por disponibilidad");
        String opcionBusqueda = lector.nextLine().trim();
        System.out.println("=========================");
        switch (opcionBusqueda) {
            case "1":
                buscarPeliculaId(filmoteca, lector);
                break;
            case "2":
                buscarPeliculaTitulo(filmoteca, lector);
                break;
            case "3":
                buscarPeliculaDirector(filmoteca, lector);
                break;
            case "4":
                buscarPeliculaGenero(filmoteca, lector);
                break;
            case "5":
                buscarPeliculaDuracion(filmoteca, lector);
                break;
            case "6":
                buscarPeliculaDisponibilidad(filmoteca, lector);
                break;
            default:
                System.out.println("Esta búsqueda no es posible.");
        }
    }

    //Entiendo que la búsqueda por ID tiene que ser exacta:
    public static int buscarPeliculaId(ArrayList<Pelicula> filmoteca, Scanner lector) {
        System.out.println("Introduce el ID de la película que quieras:");
        int posibleId = Integer.parseInt(lector.nextLine());
        for (int i = 0; i < filmoteca.size(); i++) {
            if (filmoteca.get(i).getId() == posibleId) {
                filmoteca.get(i).imprimirPelicula();
                return i;
            }
        }
        System.out.println("No se ha encontrado esta película.");
        return -1;
    }

    public static void buscarPeliculaTitulo(ArrayList<Pelicula> filmoteca, Scanner lector) {
        System.out.println("Introduce el título que buscas:");
        String posibleTexto = lector.nextLine();
        boolean peliculaEncontrada = false;
        for (int i = 0; i < filmoteca.size(); i++) {
            if (filmoteca.get(i).getTitulo().contains(posibleTexto)) {
                filmoteca.get(i).imprimirPelicula();
                peliculaEncontrada = true;
            }
        }
        if (!peliculaEncontrada) {
            System.out.println("No se ha encontrado ninguna película.");
        }
    }

    public static void buscarPeliculaDirector(ArrayList<Pelicula> filmoteca, Scanner lector) {
        System.out.println("Introduce el director que buscas:");
        String posibleTexto = lector.nextLine();
        boolean peliculaEncontrada = false;
        for (int i = 0; i < filmoteca.size(); i++) {
            if (filmoteca.get(i).getDirector().contains(posibleTexto)) {
                filmoteca.get(i).imprimirPelicula();
                peliculaEncontrada = true;
            }
        }
        if (!peliculaEncontrada) {
            System.out.println("No se ha encontrado ninguna película.");
        }
    }

    public static void buscarPeliculaGenero(ArrayList<Pelicula> filmoteca, Scanner lector) {
        System.out.println("Introduce el género que buscas:");
        String posibleTexto = lector.nextLine();
        boolean peliculaEncontrada = false;
        for (int i = 0; i < filmoteca.size(); i++) {
            if (filmoteca.get(i).getGenero().contains(posibleTexto)) {
                filmoteca.get(i).imprimirPelicula();
                peliculaEncontrada = true;
            }
        }
        if (!peliculaEncontrada) {
            System.out.println("No se ha encontrado ninguna película.");
        }
    }

    //Entiendo que la búsqueda por minutos tiene que ser exacta:
    public static void buscarPeliculaDuracion(ArrayList<Pelicula> filmoteca, Scanner lector) {
        System.out.println("Introduce la duración en minutos:");
        int posibleId = Integer.parseInt(lector.nextLine());
        boolean peliculaEncontrada = false;
        for (int i = 0; i < filmoteca.size(); i++) {
            if (filmoteca.get(i).getDuracion() == posibleId) {
                filmoteca.get(posibleId).imprimirPelicula();
                peliculaEncontrada = true;
            }
        }
        if (!peliculaEncontrada) {
            System.out.println("No se ha encontrado esta película.");
        }
    }

    //Entiendo que sólo quiero las películas disponibles:
    public static void buscarPeliculaDisponibilidad(ArrayList<Pelicula> filmoteca, Scanner lector) {
        boolean peliculaEncontrada = false;
        for (int i = 0; i < filmoteca.size(); i++) {
            if (filmoteca.get(i).isDisponibilidad()) {
                filmoteca.get(i).imprimirPelicula();
                peliculaEncontrada = true;
            }
        }
        if (!peliculaEncontrada) {
            System.out.println("No se ha encontrado esta película.");
        }
    }
}
