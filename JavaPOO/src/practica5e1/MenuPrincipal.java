//crear constructor copia
package practica5e1;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {

    public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Empleado> listaEmpleado = new ArrayList<>();

        boolean salir = false;
        while (salir == false) {
            System.out.println(" ");
            System.out.println("Menú principal:");
            System.out.println("  1- Alta");
            System.out.println("  2- Mostrar datos");
            System.out.println("  0- Salir");
            int opcionPrincipal = Integer.parseInt(lector.nextLine().trim());
            System.out.println(" ");

            switch (opcionPrincipal) {
                case 1:
                    procesoAlta(listaEmpleado);
                    break;
                case 2:
                    procesoMostrar(listaEmpleado);
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        }
    }

    public static void procesoAlta(ArrayList<Empleado> listaEmpleado) {
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

    public static void procesoMostrar(ArrayList<Empleado> listaEmpleado) {
        int indiceEmpleado = buscarNifEmpleado(listaEmpleado);
        if (indiceEmpleado == -1) {
            System.out.println("Empleado inexistente.");
        } else {
            //Nota: si tuviera que ver si es de un tipo u otro, es interesante 'instanceof'
            listaEmpleado.get(indiceEmpleado).mostrarAtributos();
        }
    }

    public static String seleccionarEmpleado() {
        System.out.println("Tipo de empleado:");
        System.out.println("  G- Genérico");
        System.out.println("  C- Comercial");
        System.out.println("  R- Repartidor");
        return lector.nextLine().trim().toUpperCase();
    }

    public static int buscarNifEmpleado(ArrayList<Empleado> listaEmpleado) {
        System.out.println("NIF a buscar:");
        String posibleNif = lector.nextLine().trim();
        for (int i = 0; i < listaEmpleado.size(); i++) {
            if (listaEmpleado.get(i).getNif().equals(posibleNif)) {
                return i;
            }
        }
        return -1;
    }
}
