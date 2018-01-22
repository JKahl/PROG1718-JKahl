package Task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) {

        int ancho = 0;
        int alto = 0;
        int contador1 = 0;
        int contador2 = 0;

        Scanner entrada = new Scanner(System.in);

        do {

            try {

                System.out.println("Introduzca el alto del cuadrado");
                alto = entrada.nextInt();

                if (alto < 1 || alto > 20) {

                    throw new InputMismatchException("Los valores introducidos están fuera del rango contemplado");

                }

            } catch (InputMismatchException e) {

                System.out.println("El valor introducido no es un tipo entero");
                entrada.next();

            }

        } while (alto < 1 || alto > 20);

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

        } while (ancho < 1 || ancho > 20);

        int anchovar1 = ancho - 2;
        String primeraLinea = "";

        for (int i = 0; i < anchovar1; i++) {

            primeraLinea += "-";

        }
        System.out.println("+" + primeraLinea + "+");

        int anchovar2 = ancho - 3;
        //ToDo Revisar condicion de parada del for
        for (int i = 0; i <= alto; i++) {

            System.out.print("|*");

            if (i == 0 || i == (alto - 3)) {

                for (int j = 0; j <= ancho; j++) {

                    String cuerpo = "";
                    cuerpo = "*";
                    System.out.print(cuerpo);
                }
                }else{
                        
                        for (int j = 0; j<anchovar2 - 1; j++){
                       
                        String cuerpo2 = "";
                        cuerpo2= " "; //noentender
                        System.out.print(cuerpo2);
                        
                        }
                        System.out.print("*");
                        }
                System.out.println("|");

            }
          
        for (int i = 0; i < anchovar1; i++) {

            primeraLinea += "-";

        }
        System.out.println("+" + primeraLinea + "+");
    }
//
//                if (i == 0 || i == 20) {
//
//                } else if (j == 0 || j == 20) {
//
//                }
}



