package ejerciciov1;

import java.util.Scanner;

public class Persona {

    //Aquí los atributos:
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private String nif;

    //Aquí los constructores. Primero el vacío:
    public Persona() {
    }
    
    //para crear constructores: alt+insert
    public Persona(String nombre, String apellido1, String apellido2, int edad, String nif) {
        //this.nombre = nombre.toUpperCase(); es (sin centralizar el criterio) igual que:
        this.setNombre(nombre);
        //el uso de este setter es ejemplo de encapsulación; aporta fiabilidad
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        this.nif = nif;
    }

    //Aquí el constructor copia.
    public Persona(Persona p1) {
        this.nombre = p1.nombre;
        this.apellido1 = p1.apellido1;
        this.apellido2 = p1.apellido2;
        this.edad = p1.edad;
        this.nif = p1.nif;
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
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
        //el lector.nextInt() lee sólo el íntegro; no el retorno; tengo que usar parse
        System.out.println("NIF:");
        this.setNif(lector.nextLine());
        System.out.println("Gracias.");
        //Y cierro el escaner:
        lector.close();
    }

    void mostrarAtributos() {
        //Cuando vaya a usar esto lo usará un objeto concreto; uso 'this'
        //así, por ejemplo, llamaré: maria.mostrarAtributos()
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Primer apellido: " + this.getApellido1());
        System.out.println("Segundo apellido: " + this.getApellido2());
        System.out.println("Edad: " + this.getEdad());
        System.out.println("NIF: " + this.getNif());
    }

}
