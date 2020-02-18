package practica3e2;

import java.util.Scanner;

public class Autor {
    //Atributos:
    private String nombreAutor;
    private String apellidosAutor;
    private boolean generoAutor;
    //TODO: investigar enums para trabajar con hombre/mujer
    //por ahora true = hombre, false = mujer
    private int anoNacimiento;

    //Constructores:
    public Autor() {
    }

    public Autor(String nombreAutor, String apellidosAutor, boolean generoAutor, int anoNacimiento) {
        this.nombreAutor = nombreAutor;
        this.apellidosAutor = apellidosAutor;
        this.generoAutor = generoAutor;
        this.anoNacimiento = anoNacimiento;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getApellidosAutor() {
        return apellidosAutor;
    }

    public void setApellidosAutor(String apellidosAutor) {
        this.apellidosAutor = apellidosAutor;
    }

    public boolean getGeneroAutor() {
        return generoAutor;
    }

    public void setGeneroAutor(boolean generoAutor) {
        this.generoAutor = generoAutor;
    }

    public int getAnoNacimiento() {
        return anoNacimiento;
    }

    public void setAnoNacimiento(int anoNacimiento) {
        this.anoNacimiento = anoNacimiento;
    }

    //Métodos:
    void introducirAutor() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Nombre de autor:");
        this.setNombreAutor(lector.nextLine());
        System.out.println("Apellido de autor:");
        this.setApellidosAutor(lector.nextLine());
        System.out.println("¿Es hombre? Y/N");
        String genero = lector.nextLine().trim();
        if (genero.equals("Y") || genero.equals("y")) {
            this.setGeneroAutor(true);
        } else if (genero.equals("N") || genero.equals("n")) {
            this.setGeneroAutor(false);
        } else {
            //TODO: bucle para que siempre me de opciones
            System.out.println("Valor incorrecto. Por defecto consideraremos que es varón.");
            this.setGeneroAutor(true);
        }
        System.out.println("Año de nacimiento de autor:");
        this.setAnoNacimiento(Integer.parseInt(lector.nextLine()));
    }

    void imprimirAutor() {
        System.out.println("Autor: " + this.getNombreAutor() + " " + this.getApellidosAutor());
        if (this.getGeneroAutor() == true) {
            System.out.println("(" + this.getAnoNacimiento() + ", varón)");
        } else {
            System.out.println("(" + this.getAnoNacimiento() + ", mujer)");
        }
    }
    
    
}








//como es muy simple lo creo en esta misma clase
enum generoAutor {
    HOMBRE,
    MUJER
}
