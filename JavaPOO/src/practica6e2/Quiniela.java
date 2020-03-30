package practica6e2;

//Entiendo que también es una especialización de Apuesta
import java.util.Arrays;

public class Quiniela extends Apuesta {
    
    //Constantes:
    public static final int ARRAYLENG = 15;
    
    //Atributos:
    private String[] listaQuiniela = new String[ARRAYLENG];
    private int aciertos = 0;

    //Constructores:
    public Quiniela() {
    }

    public Quiniela(String nombre, String apellidos, String[] listaQuiniela, int aciertos) {
        super(nombre, apellidos);
        this.listaQuiniela = listaQuiniela;
        this.aciertos = aciertos;
    }
    
    public Quiniela(String nombre, String apellidos) {
        super(nombre, apellidos);
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
    
    public void rellenarApuestaQuiniela() {
        String[] miListaQuiniela = new String[ARRAYLENG];
        for (int i = 0; i < ARRAYLENG; i++) {
            String resultado;
            do {
                System.out.println("Introduce 1-x-2 para el partido " + (i + 1) + " de " + ARRAYLENG + ":");
                resultado = SimulacionLoteria.lector.nextLine().trim().toLowerCase();
            } while (!resultado.equals("x") && !resultado.equals("1") && !resultado.equals("2"));
            //Esta cosilla complicada de leer podría pasarla a un método aparte, p.ej. esValorValido()
            miListaQuiniela[i] = resultado;
        }
        this.setListaQuiniela(miListaQuiniela);
    }
    
    //genero una quiniela aleatoria para la simulación:
    public static String[] generarQuiniela() {
        String[] miArray = new String[ARRAYLENG];
        for (int i = 0; i < ARRAYLENG; i++) {
            int valor;
            //CUIDADO: los valores en una primitiva no se pueden repetir
            valor = (int)(Math.random() * 2);
            if (valor == 0) {
                miArray[i] = "x";
            } else if (valor == 1) {
                miArray[i] = "1";
            } else {
                miArray[i] = "2";
            }   
        }
        return miArray;
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
