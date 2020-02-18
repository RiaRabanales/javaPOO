package practica5e2;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {
    //Variables que necesito en todas las clases
    public static Scanner lector = new Scanner(System.in);
    public static int contadorLicencia;

    public static void main(String[] args) {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

        boolean salir = false;
        while (salir == false) {
            System.out.println("______________________________");
            System.out.println("Menú principal:");
            System.out.println("  1- Alta vehiculo");
            System.out.println("  2- Buscar vehiculos");
            System.out.println("  3- Solicitar taxi");
            System.out.println("  4- Liberar taxi");
            System.out.println("  5- Mostrar vehiculos");
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
                    solicitarTaxi(listaVehiculos);
                    break;
                case 4:
                    cancelarTaxi(listaVehiculos);
                    //TODO: completar
                    break;
                case 5:
                    mostrarListaVehiculos(listaVehiculos);
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
                System.out.println("Empleado incorrecto.");
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
    
    public static void mostrarListaVehiculos (ArrayList<Vehiculo> listaVehiculos) {
        System.out.println("Vehículos dados de alta:");
        System.out.println("______________________________");
        for (int i = 0; i < listaVehiculos.size(); i++) {
            listaVehiculos.get(i).mostrarVehiculo();
        }
    }
    
    public static void procesoBusqueda(ArrayList<Vehiculo> listaVehiculos) {
        System.out.println("Elección de búsqueda:");
        System.out.println("  -1: por id");
        System.out.println("  -2: por matricula");
        String opcionBusqueda = lector.nextLine();
        Vehiculo vehiculoEncontrado = new Vehiculo();
        if (opcionBusqueda.equals("1")) {
            vehiculoEncontrado = buscarVehiculoId(listaVehiculos);
        } else if (opcionBusqueda.equals("2")) {
            vehiculoEncontrado = buscarVehiculoMatricula(listaVehiculos);
        } else {
            System.out.println("Opción incorrecta");
        }
        if (vehiculoEncontrado == null) {
            System.out.println("No se ha encontrado este vehículo.");
        } else {
            vehiculoEncontrado.mostrarVehiculo();
        }
    }
    
    public static Vehiculo buscarVehiculoId(ArrayList<Vehiculo> listaVehiculos) {
        System.out.println("Introducir ID para buscar:");
        int idVehiculo = Integer.parseInt(lector.nextLine().trim());
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getId() == idVehiculo) {
                return listaVehiculos.get(i);
            }
        }
        return null;
    }
    
    public static Vehiculo buscarVehiculoMatricula(ArrayList<Vehiculo> listaVehiculos) {
        System.out.println("Introducir matrícula para buscar:");
        String matriculaVehiculo = lector.nextLine().trim().toUpperCase();
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getMatricula().equals(matriculaVehiculo)) {
                return listaVehiculos.get(i);
            }
        }
        return null;
    }
    
    public static void solicitarTaxi(ArrayList<Vehiculo> listaVehiculos) {
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i) instanceof Taxi) {
                //esto lo podía hacer con un && en vez de anidar condiciones
                if (((Taxi)listaVehiculos.get(i)).isOcupado() == false) {
                    ((Taxi)listaVehiculos.get(i)).setOcupado(true);
                    System.out.println("Se ha reservado el taxi con  id " + 
                            listaVehiculos.get(i).getId() + " y matrícula " +
                            listaVehiculos.get(i).getMatricula());
                }
            }
        }
    }
    
    public static void cancelarTaxi(ArrayList<Vehiculo> listaVehiculos) {
        System.out.println("Datos del taxi.");
        Taxi miTaxi = (Taxi)buscarVehiculoId(listaVehiculos);
        if (miTaxi != null && miTaxi.isOcupado() == true) {
            miTaxi.setOcupado(false);
            //pero esto no me lo cambia en la lista! replantear
            System.out.println("Se ha cancelado la reserva del taxi con  id " + 
                miTaxi.getId() + " y matrícula " + miTaxi.getMatricula());
        } else {
            System.out.println("Operación imposible.");
        }
    }
}
