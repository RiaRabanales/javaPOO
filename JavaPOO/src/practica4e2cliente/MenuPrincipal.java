package practica4e2cliente;

import java.util.ArrayList;
import java.util.Scanner;

//TODO funciones: mostrar todas las pelis reservadas con su numero de copia, mostrar todas las reservas de un cliente, eliminar a un cliente, ACABAR cancelar reserva
//FALLO EN CASO 2: me coge dni de cliente q no existe (no lo puedo replicar wtf? debug?)

public class MenuPrincipal {

    //Primero declaro la constante de película:
    private static final int MAXPELICULAS = 3000;
    //Y pruebo a crearme el lector estático para poder llamarlo por todos lados sin pasar parámetro.
    public static Scanner lector = new Scanner(System.in);

    //En el método main tengo el menú principal:
    public static void main(String[] args) {
        //declaro las dos listas que necesitaré:
        ArrayList<Pelicula> filmoteca = new ArrayList<>();
        ArrayList<Cliente> clientela = new ArrayList<>();

        boolean salir = false;

        while (salir == false) {
            System.out.println("=========================");
            System.out.println("       = MENU =");
            System.out.println("=========================");
            System.out.println("  1- añadir nueva película");
            System.out.println("  2- reservar película");
            System.out.println("  3- cancelar reserva");
            System.out.println("  4- buscar película");
            System.out.println("  5- ver copias disponibles");
            System.out.println("  6- añadir nuevo cliente");
            System.out.println("  0- salir");
            String opcion = lector.nextLine().trim();
            System.out.println("=========================");

            switch (opcion) {
                case "1":       //añadir pelicula nueva
                    anadirPelicula(filmoteca);
                    break;
                case "2":       //reservar una película
                    int indiceCliente = comprobarCliente(clientela);
                    if (indiceCliente != 1) {
                        reservarPeliculas(indiceCliente, filmoteca, clientela);
                    } else {
                        System.out.println("Cliente inexistente.");
                    }
                    break;
                case "3":        //cancelar reserva
                    indiceCliente = comprobarCliente(clientela);
                    if (indiceCliente != 1) {
                        cancelarReservaPelicula(indiceCliente, filmoteca, clientela);
                    } else {
                        System.out.println("Cliente inexistente.");
                    }
                    break;
                case "4":        //buscar una película
                    buscarPelicula(filmoteca);
                    break;
                case "5":        //ver peliculas con copias disponibles
                    listarPeliculasDisponibles(filmoteca);
                    break;
                case "6":        //crear un cliente nuevo
                    anadirCliente(clientela);
                    break;
                case "0":
                    salir = true;
                    System.out.println("Adiós.");
                    break;
                default:
                    System.out.println("Esta opción no es correcta.");
            }
        }
    }

    //A partir de aquí están los métodos específicos
    public static void anadirPelicula(ArrayList<Pelicula> filmoteca) {
        System.out.println("¿Cuántas copias de la película quieres añadir?");
        int copiasNuevaPelicula = Integer.parseInt(lector.nextLine());
        if (contarPeliculas(filmoteca) + copiasNuevaPelicula >= MAXPELICULAS) {
            System.out.println("El videoclub no puede almacenar estas copias.");
        } else {
            Pelicula nuevaPelicula = new Pelicula(copiasNuevaPelicula, 0);
            nuevaPelicula.introducirPelicula();
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
    
    public static void listarPeliculasDisponibles(ArrayList<Pelicula> filmoteca) {
        System.out.println("Películas / copias disponibles:");
        for (int i = 0; i < filmoteca.size(); i++) {
            if (filmoteca.get(i).isDisponibilidad() == true) {
                System.out.println(filmoteca.get(i).getTitulo() + ": " + (filmoteca.get(i).getCopiasTotal() - filmoteca.get(i).getCopiasReserva()) + " copias.");
            }
        }
    }

    public static void anadirCliente(ArrayList<Cliente> clientela) {
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.insertarCliente();
        clientela.add(nuevoCliente);
    }

    public static int comprobarCliente(ArrayList<Cliente> clientela) {
        System.out.println("DNI del cliente:");
        String posibleCliente = lector.nextLine();
        for (int i = 0; i < clientela.size(); i++) {
            if (clientela.get(i).getDniCliente().equals(posibleCliente)) {
                return i;
            }
        }
        return -1;
    }

    //Este a su vez me llamará al reservarPelicula de la otra clase; antes me comprobará el cliente
    //Al final me añadirá la película a la listas de reservas del cliente
    public static void reservarPeliculas(int indiceCliente, ArrayList<Pelicula> filmoteca, ArrayList<Cliente> clientela) {
        System.out.println("Películas en nuestro videoclub:");
        listarPeliculas(filmoteca);
        int encontradoId = buscarPeliculaId(filmoteca);
        //entiendo que solo se puede reservar una copia cada vez
        //quiero garantizar que no me peta por fuera de rango:
        if (encontradoId != -1) {
            if (!filmoteca.get(encontradoId).isDisponibilidad()) {
                System.out.println("Esta película no está disponible en estos momentos.");
            } else {
                filmoteca.get(encontradoId).reservarPelicula();
                clientela.get(indiceCliente).introducirReserva(filmoteca.get(encontradoId));
                System.out.println("Has reservado tu película.");
            }
        }
    }
    
    public static void cancelarReservaPelicula(int indiceCliente, ArrayList<Pelicula> filmoteca, ArrayList<Cliente> clientela) {
        System.out.println("Películas reservadas por :" + clientela.get(indiceCliente).getNombreCliente() + ":");
        if (clientela.get(indiceCliente).getReservasCliente().size() == 0) {
            System.out.println("No hay ninguna película reservada.");
        } else {
            for (int i = 0; i < clientela.get(indiceCliente).getReservasCliente().size(); i++) {
                clientela.get(indiceCliente).getReservasCliente().get(i).imprimirPelicula();
            }
            System.out.println("Introducir ID de la película a cancelar:");
            int posibleId = buscarPeliculaId(filmoteca);
            if (posibleId != -1) {
                filmoteca.get(posibleId).cancelarPelicula();
                //TODO: QUITARLO DE LA LISTA DE RESERVAS DEL CLIENTE
            }
        }
    }

    //Este método muestra información de todos los títulos
    public static void listarPeliculas(ArrayList<Pelicula> filmoteca) {
        for (int i = 0; i < filmoteca.size(); i++) {
            filmoteca.get(i).imprimirPelicula();
        }
        if (filmoteca.size() == 0) {
            System.out.println("No hay ninguna película.");
        }
    }

    //A partir de aquí incluyo todos mis métodos de búsqueda:
    public static void buscarPelicula(ArrayList<Pelicula> filmoteca) {
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
                buscarPeliculaId(filmoteca);
                break;
            case "2":
                buscarPeliculaTitulo(filmoteca);
                break;
            case "3":
                buscarPeliculaDirector(filmoteca);
                break;
            case "4":
                buscarPeliculaGenero(filmoteca);
                break;
            case "5":
                buscarPeliculaDuracion(filmoteca);
                break;
            case "6":
                buscarPeliculaDisponibilidad(filmoteca);
                break;
            default:
                System.out.println("Esta búsqueda no es posible.");
        }
    }

    //Entiendo que la búsqueda por ID tiene que ser exacta:
    public static int buscarPeliculaId(ArrayList<Pelicula> filmoteca) {
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

    public static void buscarPeliculaTitulo(ArrayList<Pelicula> filmoteca) {
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

    public static void buscarPeliculaDirector(ArrayList<Pelicula> filmoteca) {
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

    public static void buscarPeliculaGenero(ArrayList<Pelicula> filmoteca) {
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
    public static void buscarPeliculaDuracion(ArrayList<Pelicula> filmoteca) {
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
    public static void buscarPeliculaDisponibilidad(ArrayList<Pelicula> filmoteca) {
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
