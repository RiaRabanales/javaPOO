package practica4e1;

import java.util.Scanner;

public class Pelicula {
    
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
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.anyo = anyo;
        this.disponibilidad = disponibilidad;
        this.copiasTotal = copiasTotal;
        this.copiasReserva = copiasReserva;
    }
    
    //Getters y setters:
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
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
        System.out.println("Título: " + this.getTitulo());
        System.out.println("Director: " + this.getDirector());
        System.out.println("Género: " + this.getGenero());
        System.out.println("Duración: " + this.getDuracion());
        System.out.println("Año: " + this.getAnyo());
        //TODO: completar
    }
    
    
    
}
