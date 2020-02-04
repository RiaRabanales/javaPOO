package practica3e1;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        ArrayList<Cuenta> listaCuentas = crearCuentas();
       
        Scanner lector = new Scanner(System.in);
        System.out.println("Bienvenido.");
        
        boolean salir = false;
        
        while (salir == false) {
            System.out.println("Elija operación:");
            System.out.println("  1- Iniciar sesión");
            System.out.println("  2- Crear cuenta");
            System.out.println("  0- Salir");
            //quiero evitarme parseInt así que cojo datos en String:
            String opcionUsuario = lector.nextLine().trim();
            
            switch (opcionUsuario) {
                case "1":
                    int indiceUsuario = iniciarSesion(lector, listaCuentas);
                    if (indiceUsuario != -1) {
                        System.out.println("Bienvenido, cliente.");
                        desarrollarSesion(lector, listaCuentas, indiceUsuario);
                    } else {
                        System.out.println("Datos incorrectos.");
                    }
                    break;
                case "2":
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
    
    //aquí inicio la sesión y compruebo que la contraseña es la correcta:
    public static int iniciarSesion (Scanner lector, ArrayList<Cuenta> listaCuentas) {
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
    public static void desarrollarSesion (Scanner lector, ArrayList<Cuenta> listaCuentas, int indice) {
        System.out.println("Elija operación:");
        System.out.println("  1- Consulta cuenta");
        System.out.println("  2- Eliminación cuenta");
        System.out.println("  3- Ingreso");
        System.out.println("  4- Reintegro");
        System.out.println("  5- Transferencia");
        System.out.println("  0- Salir");
        //quiero evitarme parseInt así que cojo datos en String:
        String opcionUsuario2 = lector.nextLine().trim();

        boolean salir2 = false;
        double importe;
        switch (opcionUsuario2) {
            case "1":
                listaCuentas.get(indice).imprimirCuenta();
                break;
            case "2":
                listaCuentas.remove(listaCuentas.get(indice));
                System.out.println("Su cuenta ha sido eliminada.");    
                break;
            case "3":
                importe = solicitarCantidad(lector);
                listaCuentas.get(indice).ingresar(importe);
                System.out.println("La cantidad en cuenta es de €" + listaCuentas.get(indice).getSaldoCuenta());
                break;
            case "4":
                //no tengo que declarar de nuevo la variable importe
                importe = solicitarCantidad(lector);
                listaCuentas.get(indice).reintegrar(importe);
                System.out.println("La cantidad en cuenta es de €" + listaCuentas.get(indice).getSaldoCuenta());
                break;
            case "5":
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
                System.out.println("Fin.");
                break;
            default:
                System.out.println("Opción incorrecta.");
                break;
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
        System.out.println("Introduzca la contraseña.:");
        String nuevaContrasena = lector.nextLine();
        Cuenta nuevaCuenta = new Cuenta(nuevoNombre, nuevoNumero, 1.05, nuevoSaldo, nuevaContrasena);
        return nuevaCuenta;
    }
    
    
    //Para facilitar las llamadas me creo un método para solicitar cantidades.
    public static double solicitarCantidad(Scanner lector) {
      //traza:  System.out.println("entra en lector");
        System.out.println("Cantidad de la operación:");
        return Double.parseDouble(lector.nextLine());
    }

    
    public static int buscarCuenta(ArrayList<Cuenta> listaCuentas, String numCuenta) {
        for (int i = 0; i < listaCuentas.size(); i++) {
            if (listaCuentas.get(i).getNumeroCuenta().equals(numCuenta)) {
                return i;  
            }
        } 
        return -1;
    }
}
