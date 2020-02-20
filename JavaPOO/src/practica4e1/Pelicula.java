package practica4e1;

import java.util.Scanner;

public class Pelicula {

    //Esta constante me sirve para ir sumando los id. La creo aquí y no en la clase.
    private static int contadorId = 0;
    //Atributos:
    private int id;
    private String titulo;
    private String director;
    private int duracion;
    private String genero;
    private int anyo;
    private boolean disponibilidad;
    private int copiasTotal;
    private int copiasReserva;

    //Constructores:
    public Pelicula() {
    }

    public Pelicula(int id, String titulo, String director, int duracion, String genero, int anyo, boolean disponibilidad, int copiasTotal, int copiasReserva) {
        this.setId();
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.anyo = anyo;
        this.setDisponibilidad();
        this.copiasTotal = copiasTotal;
        this.copiasReserva = copiasReserva;
    }

    //Este constructor es al que llamo en añadirPeliculas:
    public Pelicula(int copiasTotal, int copiasReserva) {
        this.setId();
        this.copiasTotal = copiasTotal;
        this.copiasReserva = copiasReserva;
        this.setDisponibilidad();
    }

    //Getters y setters:
    public int getId() {
        return id;
    }

    public void setId() {
        contadorId += 1;
        this.id = contadorId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    //voy a llamar a este set muchas veces
    public void setDisponibilidad() {
        if (this.getCopiasTotal() - this.getCopiasReserva() > 0) {
            this.disponibilidad = true;
        } else {
            this.disponibilidad = false;
        }
    }

    public int getCopiasTotal() {
        return copiasTotal;
    }

    public void setCopiasTotal(int copiasTotal) {
        this.copiasTotal = copiasTotal;
    }

    public int getCopiasReserva() {
        return copiasReserva;
    }

    public void setCopiasReserva(int copiasReserva) {
        this.copiasReserva = copiasReserva;
    }

    //Métodos:
    public void introducirPelicula(Scanner lector) {
        System.out.println("Introducir título:");
        this.setTitulo(lector.nextLine());
        System.out.println("Introducir director:");
        this.setDirector(lector.nextLine());
        System.out.println("Introducir género:");
        this.setGenero(lector.nextLine());
        System.out.println("Introducir año:");
        this.setAnyo(Integer.parseInt(lector.nextLine()));
        System.out.println("Introducir duración:");
        this.setDuracion(Integer.parseInt(lector.nextLine()));
    }

    public void imprimirPelicula() {
        System.out.println("ID: " + this.getId());
        System.out.println("    Título: " + this.getTitulo());
        System.out.println("    Director: " + this.getDirector());
        System.out.println("    Género: " + this.getGenero());
        System.out.println("    Duración: " + this.getDuracion());
        System.out.println("    Año: " + this.getAnyo());
        System.out.println("    Copias totales: " + this.getCopiasTotal());
        System.out.println("    Copias en reserva: " + this.getCopiasReserva());
        if (this.isDisponibilidad() == true) {
            System.out.println("    Disponible.");
        } else {
            System.out.println("    No disponible.");
        }
    }

    public void reservarPelicula() {
        this.setCopiasReserva(this.getCopiasReserva() + 1);
        this.setDisponibilidad();
    }

}
