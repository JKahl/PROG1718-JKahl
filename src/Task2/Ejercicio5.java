package Task2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase permite mediante estructura while e if la creación de un rectángulo
 * conformado por símbolos.
 * @version 1.0
 * @author JKahl
 */

public class Ejercicio5 {

    /**
     * Este método mediante comparativas entre los números introducidos por consola
     * realiza la representación de un rectángulo mediante símbolos.
     * @param args Este método se encarga, utilizando método while / if, de crear
     * rangos posibles entre los números introducidos, y una asignación de símbolos
     * para los valores de ancho y alto introducidos, para mostrar finalmente por consola
     * el rectángulo.
     * @exception InputMismatchException Se crea una expcepción para el caso en el
     * que el usuario del programa introduzca un valor no aceptado por la
     * declaración de variables, como podría ser una letra o un número con
     * decimal, ya que las variables han sido definidas de tipo int.
     *
     */
    
    public static void main(String[] args) {

        int alto = 0;
        int ancho = 0;
        int contador1 = 0;
        int contador2 = 0;
        int contador3 = 0;

        Scanner entrada = new Scanner(System.in);

        do {

            try {

                System.out.println("Introduzca el alto del cuadrado");
                alto = entrada.nextInt();

                if (alto < 1 || alto > 10) {

                    throw new InputMismatchException("Los valores introducidos están fuera del rango contemplado");

                }

            } catch (InputMismatchException e) {

                System.out.println("El valor introducido no es un tipo entero");
                entrada.next();

            }

        } while (alto < 1 || alto > 10);

        do {

            try {

                System.out.println("Introduzca el ancho del cuadrado");
                ancho = entrada.nextInt();

                if (ancho < 1 || ancho > 10) {

                    throw new InputMismatchException("Los valores introducidos están fuera del rango contemplado");

                }

            } catch (InputMismatchException e) {

                System.out.println("El valor introducido no es un tipo entero");
                entrada.next();

            }

        } while (ancho < 1 || ancho > 10);

        String asterisco = "";
        String guion = "";

        while (contador1 < alto) {

            if (contador1 % 2 == 0) {

                while (contador2 < ancho) {

                    asterisco += "*";
                    contador2++;

                }

                System.out.println(asterisco);

            } else {

                while (contador3 < ancho) {

                    guion += "-";
                    contador3++;

                }

                System.out.println(guion);

            }
            contador1++;
        }

    }
}
