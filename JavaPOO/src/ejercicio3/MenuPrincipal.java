package ejercicio3;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        //para probar voy a crear dos cuentas:
        Cuenta c1 = new Cuenta ("Maria", "00001", 0.21, 800);
        Cuenta c2 = new Cuenta(c1);
        c2.setNumeroCuenta("00002");
        
        Scanner lector = new Scanner(System.in);
        
        System.out.println("Bienvenido, " + c1.getNombreCliente() + " con cuenta " + c1.getNumeroCuenta());
        
        boolean salir = false;
        while (salir == false) {
            System.out.println("Elija operación:");
            System.out.println("  1- Ingreso");
            System.out.println("  2- Reintegro");
            System.out.println("  3- Transferencia a mi otra cuenta");
            System.out.println("  4- Salir");
            //quiero evitarme parseInt así que cojo datos en String:
            String opcionUsuario = lector.nextLine().trim();
            double importe;
            switch (opcionUsuario) {
                case "1":
                    importe = solicitarCantidad(lector);
                    c1.ingresar(importe);
                    System.out.println("La cantidad en cuenta es de €" + c1.getSaldoCuenta());
                    break;
                case "2":
                    //no tengo que declarar de nuevo la variable importe
                    importe = solicitarCantidad(lector);
                    c1.reintegrar(importe);
                    System.out.println("La cantidad en cuenta es de €" + c1.getSaldoCuenta());
                    break;
                case "3":
                    importe = solicitarCantidad(lector);
                    c1.transferir(c2, importe);
                    System.out.println("La cantidad en cuenta principal es de €" + c1.getSaldoCuenta());
                    System.out.println("La cantidad en cuenta secundaria es de €" + c2.getSaldoCuenta());
                    break;
                case "4":
                    salir = true;
                    System.out.println("Fin.");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }
        }
        lector.close();    
    }
    
    //Para facilitar las llamadas me creo un método para solicitar cantidades.
    public static double solicitarCantidad(Scanner lector) {
      //traza:  System.out.println("entra en lector");
        System.out.println("Cantidad de la operación:");
        return Double.parseDouble(lector.nextLine());
    }
}
