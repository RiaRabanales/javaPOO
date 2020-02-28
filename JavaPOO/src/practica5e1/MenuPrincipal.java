//crear constructor copia
package practica5e1;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {

    //Primero me declaro las variables de clase:
    public static Scanner lector = new Scanner(System.in);
    private static ArrayList<Empleado> listaEmpleado = new ArrayList<>();

    //Programa principal:
    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println(" ");
            System.out.println("Menú principal:");
            System.out.println("  1- Alta");
            System.out.println("  2- Mostrar datos");
            System.out.println("  3- Mostrar todos los empleados");
            System.out.println("  4- Mostrar todos los comerciales");
            System.out.println("  5- Mostrar todos los repartidores");
            System.out.println("  0- Salir");
            int opcionPrincipal = Integer.parseInt(lector.nextLine().trim());
            System.out.println(" ");

            switch (opcionPrincipal) {
                case 1:
                    procesoAlta();
                    break;
                case 2:
                    procesoMostrar();
                    break;
                case 3:
                    mostrarEmpleados();
                    break;
                case 4:
                    mostrarComerciales();
                    break;
                case 5:
                    mostrarRepartidores();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        }
    }

    public static void procesoAlta() {
        String opcionEmpleado = seleccionarEmpleado();
        switch (opcionEmpleado) {
            case "G":
                Empleado e1 = new Empleado();
                e1.pedirAlta();
                listaEmpleado.add(e1);
                break;
            case "C":
                Comercial c1 = new Comercial();
                c1.pedirAlta();
                listaEmpleado.add(c1);
                break;
            case "R":
                Repartidor r1 = new Repartidor();
                r1.pedirAlta();
                listaEmpleado.add(r1);
                break;
            default:
                System.out.println("Empleado incorrecto.");
        }
    }

    public static void procesoMostrar() {
        Empleado miEmpleado = buscarEmpleadoPorNif();
        if (miEmpleado == null) {
            System.out.println("Empleado inexistente.");
        } else {
            //Nota: si tuviera que ver si es de un tipo u otro, es interesante 'instanceof'
            miEmpleado.mostrarAtributos();
        }
    }

    public static String seleccionarEmpleado() {
        System.out.println("Tipo de empleado:");
        System.out.println("  G- Genérico");
        System.out.println("  C- Comercial");
        System.out.println("  R- Repartidor");
        return lector.nextLine().trim().toUpperCase();
    }

    public static Empleado buscarEmpleadoPorNif() {
        System.out.println("NIF a buscar:");
        String posibleNif = lector.nextLine().trim();
        for (int i = 0; i < listaEmpleado.size(); i++) {
            if (listaEmpleado.get(i).getNif().equals(posibleNif)) {
                return listaEmpleado.get(i);
            }
        }
        return null;
    }
    
    public static void mostrarRepartidores() {
        System.out.println("Lista de repartidores:");
        for (int i = 0; i < listaEmpleado.size(); i++) {
            if (listaEmpleado.get(i) instanceof Repartidor) {
                listaEmpleado.get(i).mostrarAtributos();           
            }
        }
    }
    
    public static void mostrarComerciales() {
        System.out.println("Lista de comerciales:");
        for (int i = 0; i < listaEmpleado.size(); i++) {
            if (listaEmpleado.get(i) instanceof Comercial) {
                listaEmpleado.get(i).mostrarAtributos();           
            }
        }
    }
    
    public static void mostrarEmpleados() {
        System.out.println("Lista de empleados:");
        for (int i = 0; i < listaEmpleado.size(); i++) {
            if (!(listaEmpleado.get(i) instanceof Repartidor) && !(listaEmpleado.get(i) instanceof Comercial)) {
                listaEmpleado.get(i).mostrarAtributos();           
            }
        }
    }
}
