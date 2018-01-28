package Task4.sopasdeletras;

import java.util.regex.*;

/**
 * Clase sopasdeletras que contiene los métodos que operarán la clase principal
 * adjunta al ejercicio.
 *
 * @author Javier Martos Ortega
 * @version 1.0
 */
public class SopaLetras {

// Declaración de las variables que operarán los métodos y del array multidimensional.    
    int numFilas = 0;
    int numColumnas = 0;
    char letra;
    public char[][] cuadricula; //hola soy una declaracion de array

    /**
     * Enumerado de las posiciones que puede tomar las palabras dentro del array
     *
     */
    public enum Direccion {

        HORIZONTAL, VERTICAL, DIAGONAL1, DIAGONAL2

    }

    /**
    * Getter para obtener la entrada de filas almacenada en la variable numFilas.
    * @return numFilas
     */
    public int getNumFilas() {
        return numFilas;
    }
    /**
     * Getter que obtiene la entrada de columnas almacenada en la variable numColumnas
     * @return numColumnas
     */
    public int getNumColumnas() {
        return numColumnas;
    }
    /**
     * Getter que obtiene la entrada de letra almacenada en la variable letra.
     * @return letra
     */
    public char getLetra() {
        return letra;
    }

    
    /**
     * Método constructor que generará una sopa de letras de un tamaño predefinido.
     * Incluye en el método el generador de caracteres aleatorios mediante la clase math.
     */
    public SopaLetras() {

        this.numColumnas = 10;
        this.numFilas = 10;
        cuadricula = new char[numFilas][numColumnas];
        for (int i = 0; i < cuadricula.length; i++) {
            for (int j = 0; j < cuadricula[i].length; j++) {
                double randomletter = 65 + (Math.random() * 26);
                cuadricula[i][j] = (char) randomletter;
            }
        }
    }
    /**
     * Método constructor principal que se encargará de montar el armazón de la sopa
     * de letras. Incluye el generador de caracteres aleatorios dentro del constructor.
     * @param numColumnas
     * @param numFilas 
     */
    public SopaLetras(int numColumnas, int numFilas) {

        this.numColumnas = numColumnas;
        this.numFilas = numFilas;
        cuadricula = new char[numFilas][numColumnas];
        for (int i = 0; i < cuadricula.length; i++) {
            for (int j = 0; j < cuadricula[i].length; j++) {
                double randomletter = 65 + (Math.random() * 26);
                cuadricula[i][j] = (char) randomletter;
            }
        }
    }
    /**
     * Método que mediante comparativa de variables y, utilizando el enumerado anterior,
     * comprueba que la palabra introducida por el usuario por consola, efectivamente
     * cabe en el tamaño designado previamente, evitando errores.
     * @param entrada
     * @param numFilas
     * @param numColumnas
     * @param direction
     * @return back Variable booleana de control
     */
    public boolean compruebaSiCabe(String entrada, int numFilas, int numColumnas, Direccion direction) {

        boolean back = false;

        if (entrada.length() <= numFilas) {

            back = true;
        } else if (entrada.length() <= numColumnas) {

            back = true;
            //cogemos la direccion diagonal 1 y la comparamos primero con las columnas respecto a la entrada y después tres cuartos con las filas
        } else if (direction.equals(direction.DIAGONAL1) && getNumColumnas() > (numColumnas + entrada.length()) && getNumFilas() > (numFilas + entrada.length())) {

            back = true;

        } else if (direction.equals(direction.DIAGONAL2) && getNumColumnas() > (numColumnas + entrada.length()) && -1 <= (numFilas - entrada.length())) {

            back = true;

        }

        return back;

    }
    /**
     * Método que, mediante expresiones regulares, establece un patrón a recibir
     * por consola, delimitando los caracteres a introducir y su número.
     * @param entrada
     * @return back Variable booleana de control
     */

    public static boolean compruebaSiEsValida(String entrada) {

        Pattern patron = Pattern.compile("^([a-zA-Z_0-9_-]{2,20})$");
        Matcher match = patron.matcher(entrada);
        boolean back = true;

        if (!match.find()) {

            back = false;

        }

        return back;
    }
    
    /**
     * Método que mediante una estructura anidada de if y for, establece la posición
     * donde va a ir colocada la palabra, tomando en cuenta tanto la posición cardinal
     * de la misma, como la forma en la que se colocará referenciando al enumerado de Direccion.
     * @param entrada
     * @param numFilas
     * @param numColumnas
     * @param direction 
     */
    
    public void colocaPalabra(String entrada, int numFilas, int numColumnas, Direccion direction) {

        compruebaSiCabe(entrada, numFilas, numColumnas, direction);
        compruebaSiEsValida(entrada);

        if (direction.equals(direction.HORIZONTAL)) {

            for (int i = 0; i < entrada.length(); i++) {

                cuadricula[numFilas][numColumnas + i] = entrada.charAt(i);

            }

        } else if (direction.equals(direction.VERTICAL)) {

            for (int i = 0; i < entrada.length(); i++) {

                cuadricula[numFilas + i][numColumnas] = entrada.charAt(i);

            }

        } else if (direction.equals(direction.DIAGONAL1)) {

            for (int i = 0; i < entrada.length(); i++) {

                cuadricula[numFilas + i][numColumnas + 1] = entrada.charAt(i);
            }
        } else if (direction.equals(direction.DIAGONAL2)) {

            for (int i = 0; i < entrada.length(); i++) {

                cuadricula[numFilas - i][numColumnas + i] = entrada.charAt(i);

            }

        }

    }

    /**
     * Método que escoge la posición a colocar la palabra en base a lo
     * introducido por el usuario por consola
     * Direction se inicializa a null para que el código no pete.
     * @param entrada
     * @return Direction Variable asociada al enumerado anterior.
     */
    public static Direccion enteroADireccion(int entrada) {

        Direccion direction = null;

        switch (entrada) {

            case 1:

                direction = Direccion.HORIZONTAL;
                break;

            case 2:

                direction = Direccion.VERTICAL;
                break;

            case 3:

                direction = Direccion.DIAGONAL1;
                break;

            case 4:

                direction = Direccion.DIAGONAL2;
                break;

        }

        return direction;

    }

    /**
     * Método que mediante formateo de caracteres y estructuras for anidadas
     * reservará los espacios necsarios para dar a la caja de la sopa de letras
     * el aspecto requerido por el enunciado de la práctica.
     * @return paint1.tostring() Es el stringbuilder encargado de pintar la estructura.
     */
    public String toString() {

        StringBuilder paint1 = new StringBuilder();
        StringBuilder paint2 = new StringBuilder();

        for (int i = 0; i < numColumnas; i++) {

            switch (i) {

                case 0:

                    paint1.append(String.format("%6d", i));
                    break;
                default:

                    paint1.append(String.format("%3d", i));
            }

        }
        for (int i = 0; i < numColumnas; i++) {

            if (i == 0) {
                paint2.append(String.format("\n%2s+", ""));
            }
            paint2.append("---");

        }
        paint2.append("--+");
        paint1.append(paint2);

        for (int i = 0; i < cuadricula.length; i++) {

            paint1.append(String.format("\n%2d|", i));

            for (int j = 0; j < cuadricula[i].length; j++) {

                paint1.append(String.format("%3s", cuadricula[i][j]));
            }

            paint1.append(String.format("%3s", "|"));
        }

        paint1.append(paint2);
        return paint1.toString();
    }
}
