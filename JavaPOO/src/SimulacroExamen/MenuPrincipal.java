package SimulacroExamen;

import java.util.Scanner;

public class MenuPrincipal {

    //Declaro un lector estático para usar siempre.
    //Es una variable pero quiero que sea protegida para poder acceder desde las demás clases del paquete.
    protected static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        CajeroAutomatico cajero = iniciarCajero();

        //No quiero separar el menú principal del main, así que no creo método aparte.
        boolean salir = false;
        while (salir == false) {
            System.out.println("_____________________");
            System.out.println("Billetes:");
            cajero.mostrarCajero();
            System.out.println("_____________________");
            System.out.println("Opciones de menú:");
            System.out.println("   1- sacar dinero");
            System.out.println("   2- salir");
            System.out.println("Introduce opción:");
            int opcion = Integer.parseInt(lector.nextLine().trim());
            System.out.println("_____________________");

            switch (opcion) {
                case 1:
                    sacarDinero(cajero);
                    break;
                case 2:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        }
    }

    //Ayuda. Utiliza este código en tu programa principal: quiero separarlo de lo demás.
    public static CajeroAutomatico iniciarCajero() {
        int[][] carga_billetes = {{500, 10}, {200, 0}, {100, 0}, {50, 27},
        {20, 0}, {10, 18}, {5, 25}};
        CajeroAutomatico micajero = new CajeroAutomatico();
        micajero.setListaBilletes(carga_billetes);
        TarjetaDebito mitarj1 = new TarjetaDebito("33888999m", 1111, "Jorge", "Lorenzo", 20000);
        TarjetaCredito mitarj2 = new TarjetaCredito("34888999m", 2222, "Rafa", "Nadal", 1000, 5000);
        micajero.agregarTarjeta(mitarj1); //añade una tarjeta a la lista de tarjetas
        micajero.agregarTarjeta(mitarj2);
        return micajero;
    }

    //Método sacarDinero, que desarrollará el proceso general
    public static void sacarDinero(CajeroAutomatico cajero) {
        System.out.println("Introduce NIF:");
        String posibleCliente = lector.nextLine();
        System.out.println("Introduce PIN:");
        int posiblePin = Integer.parseInt(lector.nextLine().trim());
        //Creo objeto clase padre, y almaceno los tipos de los hijos, sean los que sean
        Tarjeta miTarjeta = cajero.buscarTarjeta(posibleCliente, posiblePin);
        if (miTarjeta != null) {
            try {
                System.out.println("Introduce cantidad para sacar:");
                int cantidad = Integer.parseInt(lector.nextLine().trim());
                if (miTarjeta.comprobarSaldoDisponible(cantidad) == true) {
                    if (cajero.contarBilletes() < cantidad) {
                        throw new ExcepcionCajero(cantidad);
                    } else {
                        cajero.sacarBilletes(cantidad);
                        //Lo de arriba puede lanzarme excepción; si lo hace no me entra abajo.
                        miTarjeta.disminuirSaldoDisponible(cantidad);
                    }
                }
            } catch (ExcepcionCajero e) {
                System.out.println(e.getMensajeExcepcion());
            }
        }

    }

}
