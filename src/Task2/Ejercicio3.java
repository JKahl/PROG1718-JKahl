package Task2;

import java.util.Scanner;

/**
 * Esta clase permite discernir mediante los datos numéricos introducidos, el día
 * y mes introducido, asignando los nombres correspondientes a los números.
 * @version 1.0
 * @author JKahl
 */

public class Ejercicio3 {

     /**
     * Este método mediante una estructura switch, permite asignar valores de mes y día
     * a los números introducidos por consola y alñadirle una cadena de texto adicional
     * al resultado.
     * @param args Este método sirve para recibir los datos obtenidos por
     * consola y mediante una estructura switch discernir el mes y el día al que 
     * corresponde cada número, mostrándolo a su vez por consola.
     * @default Se crea una expcepción asociada al caso en el que se introduzca un valor
     * incorrecto por consola, especificando en el resultado en éste caso "día desconocido"
     * o "mes desconocido".
     */
    
    public static void main(String[] args) {

        int dia;
        int mes;
        String diaactual;
        String mesactual;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce un día y un mes\nIntroduce el día de la semana (1-7)");
        dia = entrada.nextInt();
        System.out.println("Introduce el mes del año (1-12)");
        mes = entrada.nextInt();

        switch (dia) {

            
            case 1:

               diaactual = "Lunes";

                break;

            case 2:

                diaactual = "Martes";

                break;

            case 3:

                diaactual = "Miércoles";

                break;

            case 4:

                diaactual = "Jueves";

                break;

            case 5:

                diaactual = "Viernes";

                break;

            case 6:

                diaactual = "Sábado";

                break;

            case 7:

                diaactual = "Domingo";

                break;

            default:
                diaactual= "Día desconocido";
                System.out.println("La opción no es correcta");

        }

        switch (mes) {
            
            case 1:
                
                mesactual = "Enero";
                
                break;
             
            case 2:
                
                mesactual = "Febrero";
                
                break;
                
            case 3:
                
                mesactual = "Marzo";
                
                break;
                
            case 4:
                
                mesactual = "Abril";
                
                break;
                
            case 5:
                
                mesactual = "Mayo";
                
                break;
                
            case 6:
                
                mesactual = "Junio";
                
                break;
                
            case 7:
                
                mesactual = "Julio";
                
                break;
                
            case 8:
                
                mesactual= "Agosto";
                
                break;
                
            case 9:
                
                mesactual = "Septiembre";
                
                break;
            
            case 10:
                
                mesactual = "Octubre";
                
                break;
                
            case 11:
                
                mesactual = "Noviembre";
                
                break;
                
            case 12:
                
                mesactual = "Diciembre";
                
                break;
                
            default:
                mesactual = "Día desconocido";
                System.out.println("La opción no es correcta");
        }
        
        System.out.println("En un " + diaactual + " de " + mesactual + " brillaba el sol");
        
    }

}
