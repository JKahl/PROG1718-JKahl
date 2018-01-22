package Task2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase permite saber entre los números introducidos, cuál es mayor, cuál es menor
 * y la diferencia existente entre el mayor y el menor.
 * @version 1.0
 * @author JKahl
 */

public class Ejercicio2 {
    
    /**
     * Este método maneja cuatro números, tres introducidos mediante consola por el usuario
     * y un cuarto número, almacenado en la variable D. En base a los datos introducidos
     * calcula el mayor de los cuatro números, el menor y la diferencia entre el mayor y el menor.
     * @param args Este método sirve para recibir los datos obtenidos por
     * consola y realizar la comparación con la variable D para proporcionar los resultados
     * especificados.
     * @exception InputMismatchException Se crea una expcepción para el caso en el
     * que el usuario del programa introduzca un valor no aceptado por la
     * declaración de variables, como podría ser una letra o un número con
     * decimal, ya que las variables han sido definidas de tipo int.
     *
     */

    public static void main(String[] args) {

        int D = 22;
        int a, b, c;
       

        try {

            Scanner entrada = new Scanner(System.in);
            System.out.println("Introduce tres números por favor\nIntroduce el primer número");
            a = entrada.nextInt();

            System.out.println("Introduce el segundo número");
            b = entrada.nextInt();

            System.out.println("Introduce el tercer número");
            c = entrada.nextInt();
            
             int menor = a;
             int mayor = a;

            if (mayor < b) {

                mayor = b;

            }
            if (mayor < c) {

                mayor = c;

            }
            if (mayor < D) {

                mayor = D;

            }
            if (menor > b){
                
                menor = b;
                
            }
            if (menor > c){
                
                menor = c;
                
            }
            if (menor > D){
                
                menor = D;
                
            }
            
            System.out.println("El número mayor es " + mayor);
            System.out.println ("El número menor es " + menor);
            System.out.println ("La diferencia entre el mayor y el menor de los números es " + (mayor-menor));

        }catch(InputMismatchException e){
            
            System.out.println("El valor introducido es incorrecto");
            
        }

    }
}
