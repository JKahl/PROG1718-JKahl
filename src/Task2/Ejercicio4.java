package Task2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase permite, mediante la introducción de dos números, mostrar los nùmeros entre
 * el mayor y el menor y viceversa, y las medias de ambos.
 * @version 1.0
 * @author JKahl
 */

public class Ejercicio4 {
    
    /**
     * Este método permite mediante la introducción de dos números enteros, establecer
     * los números existentes entre ambos, ordenándolos de menor a mayor y viceversa, y estableciendo
     * la media entre ambos.
     * @param args Este método sirve para recibir los datos obtenidos por
     * consola y mediante una estructura do / if / else if, establecer los cálculos pertinentes
     * mostrando el resultado en consola.
     * @exception InputMismatchException Se crea una expcepción para el caso en el
     * que el usuario del programa introduzca un valor no aceptado por la
     * declaración de variables, como podría ser una letra o un número con
     * decimal, ya que las variables han sido definidas de tipo int.
     */

    public static void main(String[] args) {

        int a;
        int b;
        int numayor;
        int numenor;

        a = 0;
        b = 0;
        numayor = 0;
        numenor = 0;

        try {

            Scanner entrada = new Scanner(System.in);

            do {

                System.out.println("Introduzca el primer número");

                a = entrada.nextInt();

                System.out.println("Introduzca el segundo número");

                b = entrada.nextInt();

            } while (a == b);

            if (a > b) {

                numayor = a;
                numenor = b;

            } else if (b > a) {

                numayor = b;
                numenor = a;

            }

            int media = (numayor + numenor) / 2;

            System.out.println("La media entre los números introducidos es " + media);

            System.out.print("Lista ascentente desde " + numenor + " hasta " + media + ": ");

            while (numenor <= media) {

                System.out.print(numenor + " ");
                numenor++;

            }

            System.out.print("\nLista descentente desdfe " + numayor + " hasta " + media + ": ");

            while (numayor >= media) {

                System.out.print(numayor + " ");
                numayor--;

            }

        } catch (InputMismatchException e) {

            System.out.println("El valor introducido es incorrecto");

        }

    }
}
