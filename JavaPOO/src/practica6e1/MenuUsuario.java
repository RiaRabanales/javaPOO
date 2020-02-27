package practica6e1;

import java.util.Scanner;
import practica6e1.excepciones.NoVolumeException;
import practica6e1.excepciones.ZeroValueException;

public class MenuUsuario {

    public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("________________________");
            System.out.println(" CALCULADORA DE FIGURAS");
            System.out.println("________________________");
            System.out.println("  1- INTRODUCIR CARACTERISTICAS");
            System.out.println("  2- INTRODUCIR VOLUMEN");
            System.out.println("  3- INTRODUCIR AREA");
            System.out.println("  0- SALIR");
            String opcion1 = lector.nextLine().trim();
            switch (opcion1) {
                case "1":
                    menuPorCaracteristicas();
                    break;
                case "2":
                    try {
                        menuPorVolumen();
                    } catch (NumberFormatException e) {
                        System.out.println("Los datos de volumen introducidos son incorrectos.");
                    }
                    break;
                case "3":
                    menuPorArea();
                    break;
                case "0":
                    salir = true;
                    break;
                default:
                    System.out.println("IMPOSIBLE");
            }
        }
    }

    public static void menuPorCaracteristicas() {
        try {
            switch (seleccionFigura()) {
                case "1":
                    System.out.println("Introduce lado (en cm):");
                    //Pruebo si lo puedo llamar directo
                    Cubo miCubo = new Cubo(solicitarDato());
                    miCubo.imprimirCaracteristicas();
                    break;
                case "2":
                    System.out.println("Introduce altura:");
                    double altura = solicitarDato();
                    System.out.println("Introduce radio:");
                    Cilindro miCilindro = new Cilindro(altura, solicitarDato());
                    miCilindro.imprimirCaracteristicas();
                    break;
                case "3":
                    System.out.println("Introduce radio:");
                    Esfera miEsfera = new Esfera(solicitarDato());
                    miEsfera.imprimirCaracteristicas();
                    break;
                case "4":
                    System.out.println("Introduce radio:");
                    Circulo miCirculo = new Circulo(solicitarDato());
                    miCirculo.imprimirCaracteristicas();
                    break;
                default:
                    System.out.println("IMPOSIBLE. VUELTA AL MENU PRINCIPAL.");
            }
        } catch (ZeroValueException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void menuPorArea() throws NumberFormatException {
        //Creo y llamo al método solicitarArea() porque lo pide el enunciado, 
        //porque realmente usaría solicitarDato y controlaria allí excepciones
        double area = 0;
                
        try {
            area = solicitarArea();
        } catch (NumberFormatException e) {
            //Podría controlarla aquí pero el enunciado me pide en el main
            throw e;
        }
  
        switch (seleccionFigura()) {
            case "1":
                Cubo miCubo = new Cubo();
                miCubo.calcularCaracteristicasPorArea(area);
                break;
            case "2":
                Cilindro miCilindro = new Cilindro();
                miCilindro.calcularCaracteristicasPorArea(area);
                break;
            case "3":
                Esfera miEsfera = new Esfera();
                miEsfera.calcularCaracteristicasPorArea(area);
                break;
            case "4":
                Circulo miCirculo = new Circulo();
                miCirculo.calcularCaracteristicasPorArea(area);
                break;
            default:
                System.out.println("IMPOSIBLE. VUELTA AL MENU PRINCIPAL.");
        }
    }
    
    public static void menuPorVolumen() {
        //Creo y llamo al método solicitarArea() porque lo pide el enunciado, 
        //porque realmente usaría solicitarDato y controlaria allí excepciones
        double volumen = solicitarVolumen();
        switch (seleccionFigura()) {
            case "1":
                Cubo miCubo = new Cubo();
                miCubo.calcularCaracteristicasPorVolumen(volumen);
                break;
            case "2":
                Cilindro miCilindro = new Cilindro();
                miCilindro.calcularCaracteristicasPorVolumen(volumen);
                break;
            case "3":
                Esfera miEsfera = new Esfera();
                miEsfera.calcularCaracteristicasPorVolumen(volumen);
                break;
            case "4":
                Circulo miCirculo = new Circulo();
                try {
                    miCirculo.calcularCaracteristicasPorVolumen(volumen);
                } catch (NoVolumeException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("IMPOSIBLE. VUELTA AL MENU PRINCIPAL.");
        }
    }
    
    public static String seleccionFigura() {
        System.out.println("ELIGE FIGURA:");
        System.out.println("________________________");
        System.out.println("  1- CUBO");
        System.out.println("  2- CILINDRO");
        System.out.println("  3- ESFERA");
        System.out.println("  4- CIRCULO");
        System.out.println("________________________");
        System.out.println("ELIGE: ");
        String opcion = lector.nextLine().trim();
        System.out.println("________________________");
        return opcion;
    }

    //Funciona como solicitarVolumen pero me gusta más esta formulación (me evita el warning)
    //Como ZeroValue... no hereda de runtime es obligatorio hacerle el throw
    public static double solicitarDato() throws ZeroValueException{
        try {
            double valor = Double.parseDouble(lector.nextLine());
            if (valor == 0) {
                throw new ZeroValueException();
            }
            return valor;
        } catch (NumberFormatException e){
            System.out.println("No se ha introducido un número.");
            System.out.println("Usa '.' para separar enteros de decimales.");
        }
        return solicitarDato();
    }
    
    //En el caso de la solicitud de datos del área, debe elevar la excepción hasta el main, 
    //y allí mostrar el mensaje correspondiente.
    public static double solicitarArea() throws NumberFormatException {
        double area = 0;
        try {
            System.out.println("Introduce área en cm2:");
            area = Double.parseDouble(lector.nextLine()); 
        } catch (NumberFormatException e){
            throw e;
        }
        return area;
    }
    
    //En el caso de la solicitud de datos por volumen, debe volver a solicitar los datos de nuevo.
    //No me hace falta throws porque lo manejo dentro, no tengo que lanzar nada fuera.
    public static double solicitarVolumen() {
        double volumen = 0;
        try {
            System.out.println("Introduce área en cm2:");
            volumen = Double.parseDouble(lector.nextLine()); 
        } catch (NumberFormatException e){
            System.out.println("No se ha introducido un número.");
            System.out.println("Usa '.' para separar enteros de decimales.");
            volumen = solicitarVolumen();
        }
        return volumen;
    }

}
