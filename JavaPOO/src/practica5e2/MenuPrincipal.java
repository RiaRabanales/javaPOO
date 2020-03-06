package practica5e2;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {

    //Variables que necesito en todas las clases
    public static Scanner lector = new Scanner(System.in);
    private static ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("______________________________");
            System.out.println("Menú principal:");
            System.out.println("  1- Alta vehiculo");
            System.out.println("  2- Buscar vehiculos");
            System.out.println("  3- Solicitar taxi");
            System.out.println("  4- Liberar taxi");
            System.out.println("  5- Mostrar vehiculos");
            System.out.println("  6- Contar vehículos en la aplicación");
            System.out.println("  0- Salir");
            int opcionPrincipal = Integer.parseInt(lector.nextLine().trim());
            System.out.println("______________________________");

            switch (opcionPrincipal) {
                case 1:
                    procesoAlta(listaVehiculos);
                    break;
                case 2:
                    procesoBusqueda(listaVehiculos);
                    break;
                case 3:
                    Taxi.solicitarTaxi(listaVehiculos);
                    break;
                case 4:
                    Taxi.cancelarTaxi(listaVehiculos);
                    break;
                case 5:
                    Vehiculo.mostrarListaVehiculos(listaVehiculos);
                    break;
                case 6:
                    mostrarNumVehiculos();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        }
    }

    public static void procesoAlta(ArrayList<Vehiculo> listaVehiculos) {
        String opcionEmpleado = seleccionarTipoVehiculo();
        switch (opcionEmpleado) {
            case "1":
                Vehiculo v1 = new Vehiculo();
                v1.altaVehiculo();
                listaVehiculos.add(v1);
                break;
            case "2":
                Taxi t1 = new Taxi();
                t1.altaVehiculo();
                listaVehiculos.add(t1);
                break;
            case "3":
                Autobus a1 = new Autobus();
                a1.altaVehiculo();
                listaVehiculos.add(a1);
                break;
            case "4":
                Vtc vtc1 = new Vtc();
                vtc1.altaVehiculo();
                listaVehiculos.add(vtc1);
                break;
            default:
                System.out.println("Opción incorrecta.");
        }
    }

    public static String seleccionarTipoVehiculo() {
        System.out.println("Tipo de vehículo:");
        System.out.println("  1- Genérico");
        System.out.println("  2- Taxi");
        System.out.println("  3- Autobús");
        System.out.println("  4- VTC");
        return lector.nextLine().trim();
    }

    public static void procesoBusqueda(ArrayList<Vehiculo> listaVehiculos) {
        System.out.println("Elección de búsqueda:");
        System.out.println("  -1: por ID");
        System.out.println("  -2: por matricula");
        String opcionBusqueda = lector.nextLine();
        Vehiculo vehiculoEncontrado = new Vehiculo();
        if (opcionBusqueda.equals("1")) {
            vehiculoEncontrado = Vehiculo.buscarVehiculoPorId(listaVehiculos);
        } else if (opcionBusqueda.equals("2")) {
            vehiculoEncontrado = Vehiculo.buscarVehiculoPorMatricula(listaVehiculos);
        } else {
            System.out.println("Opción incorrecta");
        }
        if (vehiculoEncontrado == null) {
            System.out.println("No se ha encontrado este vehículo.");
        } else {
            vehiculoEncontrado.mostrarVehiculo();
        }
    }

    public static void mostrarNumVehiculos() {
        System.out.println("En esta aplicacion se guardan " + Vehiculo.getNumVehiculos() + " vehículos.");
    }
}
