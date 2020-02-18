/* 
 * Práctica 3: clase Cuenta con programa principal. 
 * Esto es directamente la versión 2 (arrayList, iniciarSesion, codigoPin como contraseña, etc).
 */
package practica3e1;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        //decido crear mi lista aquí para que se me inicialice con el programa
        ArrayList<Cuenta> listaCuentas = crearCuentas();

        Scanner lector = new Scanner(System.in);
        System.out.println("Bienvenido.");

        boolean salir = false;

        //podría sacar el menú a un método externo pero por no liarme con el lector, no
        while (salir == false) {
            System.out.println("Elija operación:");
            System.out.println("  1- Iniciar sesión");
            System.out.println("  2- Crear cuenta");
            System.out.println("  0- Salir");
            //quiero evitarme parseInt así que cojo datos en String:
            String opcionUsuario = lector.nextLine().trim();

            switch (opcionUsuario) {
                case "1":                   //iniciar sesion
                    int indiceUsuario = iniciarSesion(lector, listaCuentas);
                    if (indiceUsuario != -1) {
                        System.out.println("Bienvenido, cliente.");
                        desarrollarSesion(lector, listaCuentas, indiceUsuario);
                    } else {
                        System.out.println("Datos incorrectos.");
                    }
                    break;
                case "2":                   //crear cuenta
                    Cuenta nuevaCuenta = crearCuenta(lector, listaCuentas);
                    listaCuentas.add(nuevaCuenta);
                    break;
                case "0":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        }
        lector.close();
    }

    //aquí inicio la sesión y compruebo que la contraseña es la correcta.
    //devuelvo el índice de la cuenta (o -1):
    public static int iniciarSesion(Scanner lector, ArrayList<Cuenta> listaCuentas) {
        int indice = -1;
        System.out.println("Introduzca su número de cuenta (formato 10001+):");
        String numCuenta = lector.nextLine().trim();
        System.out.println("Introduzca su contraseña (vegetal*):");
        String numContrasena = lector.nextLine().trim();
        int pseudoIndice = buscarCuenta(listaCuentas, numCuenta);
        if (listaCuentas.get(pseudoIndice).getContrasena().equals(numContrasena)) {
            indice = pseudoIndice;
        }
        return indice;
    }

    //aquí la desarrollo:
    public static void desarrollarSesion(Scanner lector, ArrayList<Cuenta> listaCuentas, int indice) {
        boolean salir2 = false;
        double importe;

        while (salir2 == false) {
            System.out.println(" ");
            System.out.println("Elija operación:");
            System.out.println("  1- Consulta cuenta");
            System.out.println("  2- Eliminación cuenta");
            System.out.println("  3- Ingreso");
            System.out.println("  4- Reintegro");
            System.out.println("  5- Transferencia");
            System.out.println("  0- Volver al menú principal");
            //quiero evitarme parseInt así que cojo datos en String:
            String opcionUsuario2 = lector.nextLine().trim();

            switch (opcionUsuario2) {
                case "1":                   //consultar cuenta
                    listaCuentas.get(indice).imprimirCuenta();
                    break;
                case "2":                   //eliminar cuenta, no lo pide el enunciado
                    listaCuentas.remove(listaCuentas.get(indice));
                    System.out.println("Su cuenta ha sido eliminada.");
                    break;
                case "3":                   //ingreso
                    importe = solicitarCantidad(lector);
                    listaCuentas.get(indice).ingresar(importe);
                    System.out.println("La cantidad en cuenta es de €" + listaCuentas.get(indice).getSaldoCuenta());
                    break;
                case "4":                   //reintegro
                    //no tengo que declarar de nuevo la variable importe
                    importe = solicitarCantidad(lector);
                    listaCuentas.get(indice).reintegrar(importe);
                    System.out.println("La cantidad en cuenta es de €" + listaCuentas.get(indice).getSaldoCuenta());
                    break;
                case "5":                   //transferencia
                    System.out.println("Introduzca el número de cuenta de destino (formato 10001+):");
                    String numCuenta2 = lector.nextLine().trim();
                    //TODO: confirmar que la cuenta existe antes de pedir los datos
                    int indice2 = buscarCuenta(listaCuentas, numCuenta2);
                    importe = solicitarCantidad(lector);
                    listaCuentas.get(indice).transferir(listaCuentas.get(indice2), importe);
                    System.out.println("La cantidad en cuenta principal es de €" + listaCuentas.get(indice).getSaldoCuenta());
                    System.out.println("La cantidad en cuenta secundaria es de €" + listaCuentas.get(indice2).getSaldoCuenta());
                    break;
                case "0":
                    salir2 = true;
                    System.out.println("Vuelta al menú principal.");
                    System.out.println(" ");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }
        }
    }

    //Quiero pretender que tengo ya datos de cuentas iniciales:
    public static ArrayList<Cuenta> crearCuentas() {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        cuentas.add(new Cuenta("Alberto", "10001", 1.85, 950, "pepino"));
        cuentas.add(new Cuenta("Maria", "10001", 1.05, 900, "pepino"));
        cuentas.add(new Cuenta("Pepe", "10002", 2.05, 1990, "pepino"));
        cuentas.add(new Cuenta("Marta", "10003", 1.85, 490, "pepino"));
        cuentas.add(new Cuenta("Gemma", "10004", 1.05, 970, "pepino"));
        cuentas.add(new Cuenta("Sergio", "10005", 1.30, 1250, "pepino"));
        return cuentas;
    }

    public static Cuenta crearCuenta(Scanner lector, ArrayList<Cuenta> listaCuentas) {
        String nuevoNumero = Integer.toString((listaCuentas.size() + 10011));
        //TODO: pasar esto a un método en cuenta
        System.out.println("Introduzca tu nombre:");
        String nuevoNombre = lector.nextLine();
        System.out.println("Introduzca la cantidad: ");
        double nuevoSaldo = Double.parseDouble(lector.nextLine());
        System.out.println("Introduzca la contraseña:");
        String nuevaContrasena = lector.nextLine();
        Cuenta nuevaCuenta = new Cuenta(nuevoNombre, nuevoNumero, 1.05, nuevoSaldo, nuevaContrasena);
        System.out.println("Cuenta creada. Número de cuenta: " + nuevaCuenta.getNumeroCuenta());
        return nuevaCuenta;
    }

    //Para facilitar las llamadas me creo un método para solicitar cantidades.
    public static double solicitarCantidad(Scanner lector) {
        //traza:  System.out.println("entra en lector");
        System.out.println("Cantidad de la operación:");
        return Double.parseDouble(lector.nextLine());
    }

    //Función buscador para poder reutilizar cuando necesite:
    public static int buscarCuenta(ArrayList<Cuenta> listaCuentas, String numCuenta) {
        for (int i = 0; i < listaCuentas.size(); i++) {
            if (listaCuentas.get(i).getNumeroCuenta().equals(numCuenta)) {
                return i;
            }
        }
        return -1;
    }
}
