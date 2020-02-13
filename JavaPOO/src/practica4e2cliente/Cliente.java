package practica4e2cliente;

import java.util.ArrayList;

public class Cliente {

    //Atributos:
    private String nombreCliente;
    private String apellido1Cliente;
    private String dniCliente;
    private int telfCliente;
    private ArrayList<Pelicula> reservasCliente = new ArrayList<>();

    //Constructores:
    public Cliente() {
    }

    public Cliente(String nombreCliente, String apellido1Cliente, String dniCliente, int telfCliente, ArrayList<Pelicula> reservasCliente) {
        this.nombreCliente = nombreCliente;
        this.apellido1Cliente = apellido1Cliente;
        this.dniCliente = dniCliente;
        this.telfCliente = telfCliente;
        this.reservasCliente = reservasCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellido1Cliente() {
        return apellido1Cliente;
    }

    public void setApellido1Cliente(String apellido1Cliente) {
        this.apellido1Cliente = apellido1Cliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public int getTelfCliente() {
        return telfCliente;
    }

    public void setTelfCliente(int telfCliente) {
        this.telfCliente = telfCliente;
    }

    public ArrayList<Pelicula> getReservasCliente() {
        return reservasCliente;
    }

    public void setReservasCliente(ArrayList<Pelicula> reservasCliente) {
        this.reservasCliente = reservasCliente;
    }

    //A partir de aquí están mis métodos:
    public void insertarCliente() {
        System.out.println("Introducir nombre:");
        this.setNombreCliente(MenuPrincipal.lector.nextLine());
        System.out.println("Introducir apellido:");
        this.setApellido1Cliente(MenuPrincipal.lector.nextLine());
        System.out.println("Introducir DNI:");
        this.setDniCliente(MenuPrincipal.lector.nextLine());
        System.out.println("Introducir teléfono:");
        this.setTelfCliente(Integer.parseInt(MenuPrincipal.lector.nextLine()));
    }

    public void mostrarCliente() {
        System.out.println("Nombre: " + this.getNombreCliente());
        System.out.println("Apellido: " + this.getApellido1Cliente());
        System.out.println("DNI: " + this.getDniCliente());
        System.out.println("Teléfono: " + this.getTelfCliente());
    }

    public void introducirReserva(Pelicula reservaPelicula) {
        this.getReservasCliente().add(reservaPelicula);
    }

    public void mostrarReservaCliente() {
        System.out.println("Películas reservadas por " + this.getNombreCliente());
        for (int i = 0; i < this.getReservasCliente().size(); i++) {
            System.out.print(this.getReservasCliente().get(i).getTitulo());
            if (i == this.getReservasCliente().size()) {
                System.out.println(".");
            } else {
                System.out.print(", ");
            }
        }
        //revisar que este es el formato que quiero
    }

    //Aquí busco si una peli está en la lista de pelis reservadas de un cliente:
    public boolean buscarReservaCliente(int id) {
        boolean idEncontrado = false;
        for (int i = 0; i < this.getReservasCliente().size(); i++) {
            if (this.getReservasCliente().get(i).getId() == id) {
                idEncontrado = true;
            }
        }
        //TODO: cambiar esto por un while    
        return idEncontrado;
    }

}
