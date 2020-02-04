package practica3e2;

import java.util.Scanner;

public class Libro {
    //Atributos:
    private String tituloLibro;
    private int ISBN;
    private Autor autorLibro = new Autor();
    private int numPaginas;
    private String editorial;

    public Libro() {
    }

    public Libro(String tituloLibro, Autor autorLibro, int numPaginas, int ISBN, String editorial) {
        this.tituloLibro = tituloLibro;
        this.autorLibro = autorLibro;
        this.numPaginas = numPaginas;
        this.ISBN = ISBN;
        this.editorial = editorial;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public Autor getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(Autor autorLibro) {
        this.autorLibro = autorLibro;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    public void introducirLibro(Autor autor) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Título: ");
        this.setTituloLibro(lector.nextLine());
        this.setAutorLibro(autor);
        System.out.println("ISBN: ");
        this.setISBN(Integer.parseInt(lector.nextLine()));
        System.out.println("Número de páginas: ");
        this.setNumPaginas(Integer.parseInt(lector.nextLine()));
        System.out.println("Editorial: ");
        this.setEditorial(lector.nextLine());
    }
    
    public void imprimirLibro() {
        System.out.println("Título: " + this.getTituloLibro());
        this.getAutorLibro().imprimirAutor();
        System.out.println("ISBN: " + this.getISBN());
        System.out.println("Páginas: " + this.getNumPaginas());
        System.out.println("Editorial: " + this.getEditorial());
    }
    
}
