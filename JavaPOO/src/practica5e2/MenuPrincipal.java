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
                    solicitarTaxi(listaVehiculos);
                    break;
                case 4:
                    cancelarTaxi(listaVehiculos);
                    break;
                case 5:
                    mostrarListaVehiculos(listaVehiculos);
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
    
    public static void mostrarListaVehiculos (ArrayList<Vehiculo> listaVehiculos) {
        System.out.println("Vehículos dados de alta:");
        System.out.println("______________________________");
        for (int i = 0; i < listaVehiculos.size(); i++) {
            listaVehiculos.get(i).mostrarVehiculo();
        }
    }
    
    public static void procesoBusqueda(ArrayList<Vehiculo> listaVehiculos) {
        System.out.println("Elección de búsqueda:");
        System.out.println("  -1: por ID");
        System.out.println("  -2: por matricula");
        String opcionBusqueda = lector.nextLine();
        Vehiculo vehiculoEncontrado = new Vehiculo();
        if (opcionBusqueda.equals("1")) {
            vehiculoEncontrado = buscarVehiculoPorId(listaVehiculos);
        } else if (opcionBusqueda.equals("2")) {
            vehiculoEncontrado = buscarVehiculoPorMatricula(listaVehiculos);
        } else {
            System.out.println("Opción incorrecta");
        }
        if (vehiculoEncontrado == null) {
            System.out.println("No se ha encontrado este vehículo.");
        } else {
            vehiculoEncontrado.mostrarVehiculo();
        }
    }
    
    public static Vehiculo buscarVehiculoPorId(ArrayList<Vehiculo> listaVehiculos) {
        System.out.println("Introducir ID para buscar:");
        int idVehiculo = Integer.parseInt(lector.nextLine().trim());
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getId() == idVehiculo) {
                return listaVehiculos.get(i);
            }
        }
        return null;
    }
    
    public static Vehiculo buscarVehiculoPorMatricula(ArrayList<Vehiculo> listaVehiculos) {
        System.out.println("Introducir matrícula para buscar:");
        String matriculaVehiculo = lector.nextLine().trim().toUpperCase();
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getMatricula().equals(matriculaVehiculo)) {
                return listaVehiculos.get(i);
            }
        }
        return null;
    }
    
    //Recorro la lista para buscar taxis, variable para saber si lo encuentro
    public static void solicitarTaxi(ArrayList<Vehiculo> listaVehiculos) {
        boolean taxiEncontrado = false;
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i) instanceof Taxi) {
                //esto lo podía hacer con un && en vez de anidar condiciones
                if (((Taxi)listaVehiculos.get(i)).isOcupado() == false) {
                    ((Taxi)listaVehiculos.get(i)).setOcupado(true);
                    taxiEncontrado = true;
                    System.out.println("Se ha reservado el taxi con  ID " + 
                            listaVehiculos.get(i).getId() + " y matrícula " +
                            listaVehiculos.get(i).getMatricula());
                }
            }
        }
        if (!taxiEncontrado) {
            System.out.println("En estos momentos no hay taxis disponibles.");
        }
    }
    
    public static void cancelarTaxi(ArrayList<Vehiculo> listaVehiculos) {
        System.out.println("Datos del taxi.");
        int indice = listaVehiculos.indexOf(buscarVehiculoPorId(listaVehiculos));
        //cuidado: cuando veamos try-catch volver para arreglar casos de retorno null
        //NullPointerException supongo?
        if (((Taxi)(listaVehiculos.get(indice))).isOcupado()) {
            ((Taxi)(listaVehiculos.get(indice))).setOcupado(false);
            System.out.println("Se ha cancelado la reserva del taxi con  ID " + 
                    ((Taxi)(listaVehiculos.get(indice))).getId() + " y matrícula " + 
                    ((Taxi)(listaVehiculos.get(indice))).getMatricula());
        }
    }
    
    public static void mostrarNumVehiculos() {
        System.out.println("En esta aplicacion se guardan " + Vehiculo.getNumVehiculos() + " vehículos.");
    }   
}
