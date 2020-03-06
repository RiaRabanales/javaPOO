package practica5e2;

import java.util.ArrayList;

public class Vehiculo {

    private static int numVehiculos = 0;
    //campo para controlar el num. de instancias totales    
    private int id;
    private String matricula;
    private String modelo;
    private int potencia;

    public Vehiculo() {
    }

    public Vehiculo(int id, String matricula, String modelo, int potencia) {
        this.id = id;
        this.setMatricula(matricula);
        this.setModelo(modelo);
        this.potencia = potencia;
    }

    public Vehiculo(Vehiculo v1) {
        this.id = v1.id;
        this.matricula = v1.matricula;
        this.modelo = v1.modelo;
        this.potencia = v1.potencia;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        numVehiculos += 1;
        this.id = numVehiculos;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula.toUpperCase();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo.substring(0, 1).toUpperCase() + modelo.substring(1).toLowerCase();
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        if (potencia >= 20) {
            this.potencia = potencia;
        }
    }

    public static int getNumVehiculos() {
        return numVehiculos;
    }

    //Métodos propios:
    public void altaVehiculo() {
        this.setId();
        System.out.println("Introducir:");
        System.out.println("  -matrícula:");
        this.setMatricula(MenuPrincipal.lector.nextLine());
        System.out.println("  -modelo:");
        this.setModelo(MenuPrincipal.lector.nextLine());
        //no quiero hacer la comprobación de la potencia por setter.
        do {
            System.out.println("  -potencia:");
            this.setPotencia(Integer.parseInt(MenuPrincipal.lector.nextLine()));
        } while (this.getPotencia() < 0);
    }

    public void mostrarVehiculo() {
        System.out.println("Vehículo con ID " + this.getId() + "-");
        System.out.println("  -matrícula: " + this.getMatricula());
        System.out.println("  -modelo: " + this.getModelo());
        System.out.println("  -potencia: " + this.getPotencia());
    }

    public static void mostrarListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        System.out.println("Vehículos dados de alta:");
        System.out.println("______________________________");
        for (int i = 0; i < listaVehiculos.size(); i++) {
            listaVehiculos.get(i).mostrarVehiculo();
        }
    }

    public static Vehiculo buscarVehiculoPorId(ArrayList<Vehiculo> listaVehiculos) {
        System.out.println("Introducir ID para buscar:");
        int idVehiculo = Integer.parseInt(MenuPrincipal.lector.nextLine().trim());
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getId() == idVehiculo) {
                return listaVehiculos.get(i);
            }
        }
        return null;
    }

    public static Vehiculo buscarVehiculoPorMatricula(ArrayList<Vehiculo> listaVehiculos) {
        System.out.println("Introducir matrícula para buscar:");
        String matriculaVehiculo = MenuPrincipal.lector.nextLine().trim().toUpperCase();
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getMatricula().equals(matriculaVehiculo)) {
                return listaVehiculos.get(i);
            }
        }
        return null;
    }
}
