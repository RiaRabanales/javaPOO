package practica6e2;

//Entiendo que también es una especialización de Apuesta
import java.util.Arrays;

public class Quiniela extends Apuesta {

    //Atributos:
    private String[] listaQuiniela = new String[15];
    //TODO: los valores los controlaré o por excepciones o por un enum
    private int aciertos = 0;

    //Constructores:
    public Quiniela() {
    }

    public Quiniela(String nombre, String apellidos, int numeroApuesta, String[] listaQuiniela, int aciertos) {
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
        System.out.println("      Valores de quiniela: " + Arrays.toString(this.getListaQuiniela()));
        //TODO plantear para imprimir esto bonito
        System.out.println("      Aciertos: " + this.getAciertos());
    }

    @Override
    public void rellenarApuesta() {
        if ((this.getNombre() == null) && (this.getApellidos() == null)) {
            super.rellenarApuesta();
        }
        this.setListaQuiniela(crearApuestaQuiniela());
    }

    public String[] crearApuestaQuiniela() {
        String[] miListaQuiniela = new String[15];
        for (int i = 0; i < miListaQuiniela.length; i++) {
            String resultado;
            do {
                System.out.println("Introduce 1-x-2 para el partido " + (i + 1) + ":");
                resultado = SimulacionLoteria.lector.nextLine().trim().toLowerCase();
            } while (!resultado.equals("x") && !resultado.equals("1") & !resultado.equals("2"));
            miListaQuiniela[i] = resultado;
        }
        return miListaQuiniela;
    }
    
    //Getters y setters:
    public String[] getListaQuiniela() {
        return listaQuiniela;
    }

    public void setListaQuiniela(String[] listaQuiniela) {
        this.listaQuiniela = listaQuiniela;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

}
