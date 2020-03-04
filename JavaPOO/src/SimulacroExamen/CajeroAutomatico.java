package SimulacroExamen;

import java.util.ArrayList;

public class CajeroAutomatico {

    //Atributos:
    private static int idUltimo = 0;
    private int idCajero;
    private int[][] listaBilletes = new int[7][2];
    private ArrayList<Tarjeta> listaTarjetas = new ArrayList<>();
    //Billetes en array (tamaño concreto), tarjetas en ArrayList (tamaño variable)

    //Constructores:
    public CajeroAutomatico() {
    }

    public CajeroAutomatico(int idCajero, int[][] listaBilletes, ArrayList<Tarjeta> listaTarjetas) {
        this.idCajero = idCajero;
        this.listaBilletes = listaBilletes;
        this.listaTarjetas = listaTarjetas;
    }

    public CajeroAutomatico(CajeroAutomatico ca1) {
        this.idCajero = ca1.idCajero;
        this.listaBilletes = ca1.listaBilletes;
        this.listaTarjetas = ca1.listaTarjetas;
    }

    //Métodos:
    //Método obligatorio que muestra los billetes de cajero: es específico de esta clase
    //Lo creo aquí y no en el menú principal.
    public void mostrarCajero() {
        System.out.println("Cajero con:");
        for (int i = 0; i < listaBilletes.length; i++) {
            System.out.println("   " + this.getListaBilletes()[i][1] + " billetes de " + this.getListaBilletes()[i][0] + " €");
        }
    }

    //Métodos propios, uno para añadir tarjetas a la lista y otro para buscar tarjetas en la lista
    public void agregarTarjeta(Tarjeta t1) {
        this.listaTarjetas.add(t1);
    }

    public Tarjeta buscarTarjeta(String nif, int pin) {
        Tarjeta miTarjeta = buscarTarjetaPorNif(nif);
        if (miTarjeta != null) {
            if (miTarjeta.getPinCliente() == pin) {
                return miTarjeta;
            }
            System.out.println("PIN incorrecto.");
        }
        return null;
    }

    public Tarjeta buscarTarjetaPorNif(String nif) {
        for (int i = 0; i < this.listaTarjetas.size(); i++) {
            if (this.listaTarjetas.get(i).getNifCliente().equals(nif)) {
                return this.listaTarjetas.get(i);
            }
            //No me hace falta un else porque el bucle ya me saca de aquí
        }
        System.out.println("NIF incorrecto.");
        return null;
    }

    //En los dos métodos siguientes hago las operaciones del punto d.
    public void sacarBilletes(int cantidad) throws ExcepcionCajero {
        int cantidadRestante = cantidad;
        //me creo una lista para ir guardando los billetes que puedo sacar
        int[][] listaBilletesFuera = new int[7][2];
        //Alternativa: con un for bonito, si cantidadRestante = 0, break. pero no!
        int icontador = 0;          //para igualar el while a un for
        while (cantidadRestante > 0 && icontador < listaBilletes.length) {
            listaBilletesFuera[icontador][0] = this.getListaBilletes()[icontador][0];
            listaBilletesFuera[icontador][1] = 0;
            while (cantidadRestante >= this.getListaBilletes()[icontador][0] && (this.getListaBilletes()[icontador][1] - listaBilletesFuera[icontador][1]) > 0) {
                cantidadRestante -= this.getListaBilletes()[icontador][0];
                listaBilletesFuera[icontador][1] += 1;
            }
            icontador++;
        }
        if (cantidadRestante != 0) {                //si la cantidad no es 0 este cálculo no me ha valido
            throw new ExcepcionCajero(cantidad);
        } else {                            //aquí quito los billetes de la lista y los imprimo
            System.out.println("Se entregarán:");
            for (int i = 0; i < listaBilletesFuera.length; i++) {
                this.listaBilletes[i][1] -= listaBilletesFuera[i][1];
                if (listaBilletesFuera[i][1] != 0) {
                    //Como modifico un valor de la lista no empleo el setter sino que accedo directa.
                    System.out.println("   " + listaBilletesFuera[i][1] + " billetes de " + listaBilletesFuera[i][0] + " €");
                }
            }
        }
    }

    //Realmente esto no es 100% necesario, el método anterior podría hacérmelo.
    //Pero lo quiero porque así tengo una primera comprobación simple en el main.
    public int contarBilletes() {
        int sumaBilletes = 0;
        for (int i = 0; i < listaBilletes.length; i++) {
            sumaBilletes += (this.getListaBilletes()[i][0] * this.getListaBilletes()[i][1]);
        }
        return sumaBilletes;
    }

    //Getters y setters:
    public int getIdCajero() {
        return idCajero;
    }

    //Tengo oque cambiar este setter para que el ID de cada cajero creado sea el último más 1
    public void setIdCajero() {
        idUltimo += 1;
        this.idCajero = idUltimo;
    }

    public int[][] getListaBilletes() {
        return listaBilletes;
    }

    public void setListaBilletes(int[][] listaBilletes) {
        this.listaBilletes = listaBilletes;
    }

    public ArrayList<Tarjeta> getListaTarjetas() {
        return listaTarjetas;
    }

    public void setListaTarjetas(ArrayList<Tarjeta> listaTarjetas) {
        this.listaTarjetas = listaTarjetas;
    }

}
