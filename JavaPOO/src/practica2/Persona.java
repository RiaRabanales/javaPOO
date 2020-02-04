package practica2;

import java.util.Scanner;

public class Persona {

    //Aquí los atributos:
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private Nif infNif;

    //Aquí los constructores. Primero el vacío:
    public Persona() {
    }
    
    //para crear constructores: ALT + INSERT
    public Persona(String nombre, String apellido1, String apellido2, int edad, String nif, String nifNumero, String direccion, String nombrePadre, String nombreMadre) {
        //this.nombre = nombre.toUpperCase(); es (sin centralizar el criterio) igual que:
        this.setNombre(nombre);
        //el uso de este setter es ejemplo de encapsulación; aporta fiabilidad
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        //entiendo que quiero también los cuatro parámetros del nif:
        //pero podría crearlo con el constructor vacío = new Nif();
        this.infNif = new Nif(nifNumero, direccion, nombrePadre, nombreMadre);
        //para rellenar automático dentro de paréntesis: CTRL + SPACE
        //otra formulación: this.setNif(new Nif(nifNumero, direccion, nombrePadre, nombreMadre));
    }

    //Aquí el constructor copia.
    public Persona(Persona p1) {
        this.nombre = p1.nombre;
        this.apellido1 = p1.apellido1;
        this.apellido2 = p1.apellido2;
        this.edad = p1.edad;
        //Aquí hago copia del objeto NIF cada atributo, no igualando la referencia en memoria
        this.infNif = new Nif(p1.infNif);
    }

    //Aquí los getters y setters:
    public String getNombre() {
        return nombre;
    }

    //Todos los nombres tienen que estar en mayúscula:
    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public Nif getInfNif() {
        return infNif;
    }

    public void setInfNif(Nif intNif) {
        this.infNif = intNif;
    }

    //Aquí los métodos concretos:
    public void solicitarDatos() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Nombre:");
        this.setNombre(lector.nextLine());
        System.out.println("Primer apellido");
        this.setApellido1(lector.nextLine());
        System.out.println("Segundo apellido;");
        this.setApellido2(lector.nextLine());
        System.out.println("Edad:");
        this.setEdad(Integer.parseInt(lector.nextLine()));
        System.out.println("NIF:");
        //aquí paso de infNif nulo a un objeto nif vacío, y así puedo llamar a sus funciones
        this.setInfNif(new Nif());
        this.getInfNif().solicitarDatosNif();
        System.out.println("Gracias.");
        lector.close();
    }

    void mostrarAtributos() {
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Primer apellido: " + this.getApellido1());
        System.out.println("Segundo apellido: " + this.getApellido2());
        System.out.println("Edad: " + this.getEdad());
        this.getInfNif().mostrarAtributosNif();
    }

}
