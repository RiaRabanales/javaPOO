package practica6e2;

//Entiendo que también es una especialización de Apuesta
public class Quiniela extends Apuesta {
    
    //Atributos:
    private int[] listaQuiniela = new int[15];
    //TODO: los valores los controlaré o por excepciones o por un enum
    private int aciertos = 0;
    
    //Constructores:
    public Quiniela() {
    }

    public Quiniela(String nombre, String apellidos, int numeroApuesta, int[] listaQuiniela, int aciertos) {
        super(nombre, apellidos, numeroApuesta);
        this.listaQuiniela = listaQuiniela;
        this.aciertos = aciertos;
    }
    
    public Quiniela(Quiniela q1) {
        super(q1);
        this.listaQuiniela = q1.listaQuiniela;
        this.aciertos = q1.aciertos;
    }
    
    //Métodos
    @Override
    public void mostrarApuesta() {
        super.mostrarApuesta();
        System.out.println("      Valores de quiniela: " + this.getListaQuiniela());
        //TODO plantear para imprimir esto bonito
        System.out.println("      Aciertos: " + this.getAciertos());
    }
    
    @Override
    public void rellenarApuesta() {
        super.rellenarApuesta();
        //TODO completar
    }
    
    //Getters y setters:
    public int[] getListaQuiniela() {
        return listaQuiniela;
    }

    public void setListaQuiniela(int[] listaQuiniela) {
        this.listaQuiniela = listaQuiniela;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }
    
}
