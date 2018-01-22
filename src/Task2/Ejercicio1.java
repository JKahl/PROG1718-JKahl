package Task2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase permite saber cuántos números son menores a una constante "D"
 * preestablecida, mediante la comparativa con contadores.
 *
 * @version 1.0
 * @author JKahl
 */
public class Ejercicio1 {

    /**
     * Este método realiza una comparativa mediante contador de los números
     * introducidos por consola con la variable predefinida D para saber
     * cuáles de los números son mayores a dicha variable.
     * @param args Este método sirve para recibir los datos obtenidos por
     * consola y realizar a su vez una comparativa con una constante predefinida
     * como D.
     * @exception InputMismatchException Se crea una expcepción para el caso en el
     * que el usuario del programa introduzca un valor no aceptado por la
     * declaración de variables, como podría ser una letra o un número con
     * decimal, ya que las variables han sido definidas de tipo int.
     *
     */
    public static void main(String[] args) {

        /**
         * Se declaran las variables y los contadores que operarán las
         * comparativas pertinentes.
         */
        int D = 22;
        int contador = 0;
        int numero = 0;

        try {

            /**
             * Se introducen los números por consola mediante la utilidad
             * scanner. Si al introducir un número por consola, éste es mayor a
             * la constante preestablecida "D", el contador suma uno.
             */
            Scanner entrada = new Scanner(System.in);
            System.out.println("Introduzca 3 números\nIntroduzca el primer número");
            numero = entrada.nextInt();
            if (D > numero) {

                contador++;

            }

            System.out.println("Introduzca otro número");
            numero = entrada.nextInt();
            if (D > numero) {

                contador++;
            }

            System.out.println("Introduzca el último número");
            numero = entrada.nextInt();
            if (D > numero) {

                contador++;
            }
            entrada.close();

            /**
             * Tras haber leído todos los números y almacenado en el contador
             * los datos pertinentes, mediante una estructura if / else if, y
             * tomando la información recopilada por los contadores, se
             * determina cuántos números son menores a la variable "D". Se
             * muestra un mensaje en consola para cada resultado posible.
             */
            if (contador == 3) {

                System.out.println("TRES NUMEROS SON MENORES QUE " + D);

            } else if (contador == 2) {

                System.out.println("DOS NUMEROS SON MENORES QUE " + D);

            } else if (contador == 1) {

                System.out.println("UN NÚMERO ES MENOR QUE " + D);

            } else {

                System.out.println("NO HAY NÚMEROS MENORES A " + D);

            }

          
        } catch (InputMismatchException e) {

            System.out.println("El valor introducido es incorrecto");

        }

    }

}
