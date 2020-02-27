package practica6e2;

public class Primitiva extends Apuesta {
    //Atributos:
    private int[] listaNumeros = new int[6];
    private int aciertos = 0;
    
    //Constructores:
    public Primitiva() {
    }

    public Primitiva(String nombre, String apellidos, int numeroApuesta, int[] listaNumeros, int aciertos) {
        super(nombre, apellidos, numeroApuesta);
        this.listaNumeros = listaNumeros;
        this.aciertos = aciertos;
    }

    public Primitiva(Primitiva p1) {
        super(p1);
        this.listaNumeros = p1.listaNumeros;
        this.aciertos = p1.aciertos;
    }
    
    //Métodos:
    @Override
    public void mostrarApuesta() {
        super.mostrarApuesta();
        System.out.println("      Números de primitiva: " + this.getListaNumeros());
        //TODO plantear para imprimir esto bonito
        System.out.println("      Aciertos: " + this.getAciertos());
    }
    
    @Override
    public void rellenarApuesta() {
        super.rellenarApuesta();
        //TODO completar
    }
    
    //Getters y setters:
    public int[] getListaNumeros() {
        return listaNumeros;
    }

    public void setListaNumeros(int[] listaNumeros) {
        this.listaNumeros = listaNumeros;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }
        
}
