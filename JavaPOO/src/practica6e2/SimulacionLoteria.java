package practica6e2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SimulacionLoteria {

    public static Scanner lector = new Scanner(System.in);
    private static ArrayList<Apuesta> listaApuestas = new ArrayList<>();
    //Estas son para las estadísticas: total de simulaciones
    private static int totalSimulacionPrimitiva = 0;
    private static int totalSimulacionQuiniela = 0;

    public static void main(String[] args) {

        boolean salir = false;
        while (salir == false) {
            System.out.println("");
            System.out.println("SIMULADOR DE LOTERÍA");
            try {
                //Quiero poder pedir el nombre cada vez para poder guardar en lista las apuestas de más de una persona
                System.out.println("");
                System.out.println("  1- crear apuesta primitiva");
                System.out.println("  2- crear apuesta quiniela");
                System.out.println("  3- realizar simulación");
                System.out.println("  4- ver apuestas realizadas");
                System.out.println("  5- ver estadísticas");
                System.out.println("  0- salir");
                String opcion = lector.nextLine().trim();

                String nombre1 = "";
                String apellido1 = "";

                if ((opcion.equals("1")) || (opcion.equals("2"))) {
                    System.out.println("Introduce tu nombre:");
                    nombre1 = pedirDatos();
                    System.out.println("Introduce tus apellidos:");
                    apellido1 = pedirDatos();
                }

                switch (opcion) {
                    case "1":
                        iniciarApuestaPrimitiva(nombre1, apellido1);
                        break;
                    case "2":
                        iniciarApuestaQuiniela(nombre1, apellido1);
                        break;
                    case "3":
                        realizarSimulacion();
                        break;
                    case "4":
                        verApuestas();
                        break;
                    case "5":
                        verEstadisticas();
                        break;
                    case "0":
                        salir = true;
                        break;
                    default:
                        System.out.println("ERROR. Elige de nuevo.");
                    //TODO: ver si esto lo podría arreglar con una excepcion
                }
            } catch (NoCapslockException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String pedirDatos() throws NoCapslockException {
        String miString = lector.nextLine().trim();
        if (comprobarMayusculas(miString) == false) {
            throw new NoCapslockException();
        }
        return miString;
    }

    public static boolean comprobarMayusculas(String palabra) {
        String palabra2 = palabra.toUpperCase();
        if (palabra2.equals(palabra)) {
            return true;
        }
        return false;
    }

    //Me gustaría más este método en la clase Primitiva, pero por el enunciado estará aquí.
    public static void iniciarApuestaPrimitiva(String nombre1, String apellido1) {
        boolean otraApuesta = true;
        while (otraApuesta == true) {
            Primitiva miPrimitiva = new Primitiva(nombre1, apellido1);
            miPrimitiva.rellenarApuestaPrimitiva();
            listaApuestas.add(miPrimitiva);
            System.out.println("¿Otra primitiva más? S/N");
            String opcionrepetir = lector.nextLine().trim().toUpperCase();
            if (!opcionrepetir.equals("S")) {
                otraApuesta = false;
            }
        }
    }

    public static void iniciarApuestaQuiniela(String nombre1, String apellido1) {
        boolean otraApuesta = true;
        while (otraApuesta == true) {
            Quiniela miQuiniela = new Quiniela(nombre1, apellido1);
            miQuiniela.rellenarApuestaQuiniela();
            listaApuestas.add(miQuiniela);
            System.out.println("¿Otra quiniela más? S/N");
            String opcionrepetir = lector.nextLine().trim().toUpperCase();
            if (!opcionrepetir.equals("S")) {
                otraApuesta = false;
            }
        }
    }

    //Proceso aquí: pido números, separo las apuestas en lista en dos sublistas (si una esta vacía no debo comparar nada de ese tipo),
    //comparo, doy resultados.
    public static void realizarSimulacion() {
        System.out.println("¿Cuántos sorteos de la primitiva quieres probar?");
        int numPrimitivas = Integer.parseInt(lector.nextLine());
        System.out.println("¿Cuántos sorteos de la quiniela quieres probar?");
        int numQuinielas = Integer.parseInt(lector.nextLine());

        ArrayList<Primitiva> listaPrimitivas = new ArrayList<>();
        ArrayList<Quiniela> listaQuinielas = new ArrayList<>();
        for (int i = 0; i < listaApuestas.size(); i++) {
            if (listaApuestas.get(i) instanceof Primitiva) {
                listaPrimitivas.add((Primitiva) listaApuestas.get(i));
            } else {
                listaQuinielas.add((Quiniela) listaApuestas.get(i));
            }
        }

        if (listaPrimitivas.isEmpty()) {
            System.out.println("No has jugado ninguna primitiva 'ganadora'; no se puede comparar.");
        } else {
            simularPrimitivas(numPrimitivas, listaPrimitivas);
            totalSimulacionPrimitiva += numPrimitivas;
        }

        if (listaQuinielas.isEmpty()) {
            System.out.println("No has jugado ninguna quiniela 'ganadora'; no se puede comparar.");
        } else {
            simularQuinielas(numQuinielas, listaQuinielas);
            totalSimulacionQuiniela += numQuinielas;
        }

        verEstadisticas();
    }

    //Todo lo que sigue podría ir en cada clase, pero me gusta más aquí por enlazar el código.
    public static void simularPrimitivas(int simulaciones, ArrayList<Primitiva> listaP) {
        boolean encontrado = false;
        for (int i = 0; i < simulaciones; i++) {
            int[] simulacionPrimitiva = Primitiva.generarPrimitiva();
            //traza: System.out.println(Arrays.toString(simulacionPrimitiva));
            for (int j = 0; j < listaP.size(); j++) {
                boolean igualdad = comprobarIgualdad(simulacionPrimitiva, listaP.get(j).getListaNumeros());
                if (igualdad) {
                    //recordar: aumento en 1 el número de aciertos de esa apuesta; va por valor de referencia
                    listaP.get(i).setAciertos(listaP.get(i).getAciertos() + 1);
                    System.out.println("Ganador encontrado en el intento " + i + " con la combinación " + Arrays.toString(simulacionPrimitiva));
                    encontrado = true;
                }
            }
        }
        if (encontrado == false) {
            System.out.println("Ninguna de las primitivas simuladas es ganadora.");
        }
    }

    public static void simularQuinielas(int simulaciones, ArrayList<Quiniela> listaQ) {
        boolean encontrado = false;
        for (int i = 0; i < simulaciones; i++) {
            String[] simulacionQuiniela = Quiniela.generarQuiniela();
            //traza: System.out.println(Arrays.toString(simulacionPrimitiva));
            for (int j = 0; j < listaQ.size(); j++) {
                boolean igualdad = comprobarIgualdad(simulacionQuiniela, listaQ.get(j).getListaQuiniela());
                if (igualdad) {
                    //recordar: aumento en 1 el número de aciertos de esa apuesta; va por valor de referencia
                    listaQ.get(i).setAciertos(listaQ.get(i).getAciertos() + 1);
                    System.out.println("Ganador encontrado en el intento " + i + " con la combinación " + Arrays.toString(simulacionQuiniela));
                    encontrado = true;
                }
            }
        }
        if (encontrado == false) {
            System.out.println("Ninguna de las quinielas simuladas es ganadora.");
        }
    }

    public static boolean comprobarIgualdad(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    //Hago overloading de este método. Oleoleyole.
    public static boolean comprobarIgualdad(String[] a, String[] b) {
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }
        return true;
    }

    public static void verApuestas() {
        for (int i = 0; i < listaApuestas.size(); i++) {
            if (listaApuestas.get(i) instanceof Primitiva) {
                System.out.println("Primitiva de " + listaApuestas.get(i).getNombre() + " " + listaApuestas.get(i).getApellidos()
                        + ": " + Arrays.toString(((Primitiva) listaApuestas.get(i)).getListaNumeros()));
            } else {
                System.out.println("Quiniela de " + listaApuestas.get(i).getNombre() + " " + listaApuestas.get(i).getApellidos()
                        + ": " + Arrays.toString(((Quiniela) listaApuestas.get(i)).getListaQuiniela()));
            }
        }
    }

    public static void verEstadisticas() {
        int aciertosPrimitiva = 0;
        int aciertosQuiniela = 0;
        for (int i = 0; i < listaApuestas.size(); i++) {
            if (listaApuestas.get(i) instanceof Primitiva) {
                aciertosPrimitiva += ((Primitiva) listaApuestas.get(i)).getAciertos();
            } else {
                aciertosQuiniela += ((Quiniela) listaApuestas.get(i)).getAciertos();
            }
        }
        try {
            System.out.println("Incluyendo la última simulación realizada, de un total de " + (totalSimulacionPrimitiva + totalSimulacionQuiniela)
                    + " simulaciones se han encontrado " + (aciertosPrimitiva + aciertosQuiniela) + " aciertos.");
            System.out.println("   -primitivas: " + totalSimulacionPrimitiva + " simulaciones, " + aciertosPrimitiva + " aciertos.");
            System.out.println("       porcentaje de acierto en primitivas: " + (totalSimulacionPrimitiva / aciertosPrimitiva) + "%");
        } catch (ArithmeticException ae) {
            System.out.println("   Todavía no es posible realizar cálculos de análisis porcentual (0% de aciertos).");
        }
        try {
            System.out.println("   -quinielas: " + totalSimulacionQuiniela + " simulaciones, " + aciertosQuiniela + " aciertos.");
            System.out.println("       porcentaje de acierto en quinielas: " + (totalSimulacionQuiniela / aciertosQuiniela) + "%");
            System.out.println("");
        } catch (ArithmeticException ae) {
            System.out.println("   Todavía no es posible realizar cálculos de análisis porcentual (0% de aciertos).");
        }
    }

}
