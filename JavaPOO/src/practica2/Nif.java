package practica2;

import java.util.Scanner;

public class Nif {

    private String nifNumero;
    private String direccion;
    private String nombrePadre;
    private String nombreMadre;

    public Nif() {
    }

    public Nif(String nifNumero, String direccion, String nombrePadre, String nombreMadre) {
        this.nifNumero = nifNumero;
        this.direccion = direccion;
        this.nombrePadre = nombrePadre;
        this.nombreMadre = nombreMadre;
    }
    
    public Nif(Nif n1) {
        this.nifNumero = n1.nifNumero;
        this.direccion = n1.direccion;
        this.nombrePadre = n1.nombrePadre;
        this.nombreMadre = n1.nombreMadre;
    }

    public String getNifNumero() {
        return nifNumero;
    }

    public void setNifNumero(String nifNumero) {
        this.nifNumero = nifNumero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }
    
    public void solicitarDatosNif() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Número de NIF (con letra):");
        this.setNifNumero(lector.nextLine());
        System.out.println("Dirección:");
        this.setDireccion(lector.nextLine());
        System.out.println("Nombre del padre:");
        this.setNombrePadre(lector.nextLine());
        System.out.println("Nombre de la madre:");
        this.setNombreMadre(lector.nextLine());
        lector.close();
    }

    void mostrarAtributosNif() {
        System.out.println("Número de nif: " + this.getNifNumero());
        System.out.println("Dirección: " + this.getDireccion());
        System.out.println("Nombre del padre: " + this.getNombrePadre());
        System.out.println("Nombre de la madre: " + this.getNombreMadre());
    }
}
