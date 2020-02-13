package practica5e1;

public class Empleado {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nif;
    private int edad;
    private double salario;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido1, String apellido2, String nif, int edad, double salario) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nif = nif;
        this.edad = edad;
        this.salario = salario;
    }
    
    public Empleado(Empleado e1) {
        this.nombre = e1.nombre;
        this.apellido1 = e1.apellido1;
        this.apellido2 = e1.apellido2;
        this.nif = e1.nif;
        this.edad = e1.edad;
        this.salario = e1.salario;
    }

    public String getNombre() {
        return nombre;
    }

    //Entiendo que quiero que la primera letra sea mayúscula y las demás minúsculas
    public void setNombre(String nombre) {
        this.nombre = nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1.substring(0,1).toUpperCase() + apellido1.substring(1).toLowerCase();
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2.substring(0,1).toUpperCase() + apellido2.substring(1).toLowerCase();
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getEdad() {
        return edad;
    }

    //En este caso el if es sólo garantía; la pregunta se reformula en los métodos
    public void setEdad(int edad) {
        if (edad >= 16) {
            this.edad = edad;
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public void mostrarAtributos() {
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Apellidos: " + this.getApellido1() + " " + this.getApellido2());
        System.out.println("Nif: " + this.getNif());
        System.out.println("Edad: " + this.getEdad());
        System.out.println("Salario: " + this.getSalario());
    }
    
    public void pedirAlta() {
        System.out.println("Nombre:");
        this.setNombre(MenuPrincipal.lector.nextLine());
        System.out.println("Primer apellido:");
        this.setApellido1(MenuPrincipal.lector.nextLine());
        System.out.println("Segundo apellido:");
        this.setApellido2(MenuPrincipal.lector.nextLine());
        System.out.println("NIF:");
        this.setNif(MenuPrincipal.lector.nextLine());
        do {
            System.out.println("Edad (16+):");    
            this.setEdad(Integer.parseInt(MenuPrincipal.lector.nextLine()));
        } while (getEdad() < 16);
        //OJO: esto funciona así porq int tiene valor default de 0 (si fuera String compararía con nulo)
        System.out.println("Salario:");
        this.setSalario(Integer.parseInt(MenuPrincipal.lector.nextLine()));
    }
}
