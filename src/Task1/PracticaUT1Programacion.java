package Task1;

import java.util.Scanner; //Se importa la utilidad scanner que permitirá a la aplicación leer valores desde consola

public class PracticaUT1Programacion {
    
    public static void main(String[] args) {
      
        double nota1, nota2, nota3, nota4, ponderacion; //Declaración de variables, tanto las notas individualmente, como la variable del cálculo de la ponderación

        System.out.println("Introduce las notas obtenidas\nIntroduce la primera nota"); 
        
        Scanner sc = new Scanner (System.in); // Se inicia el scanner
        nota1 = sc.nextDouble(); //Se introduce el primer valor para que el scanner lo lea, lo hará sucesivamente con todos los valores especificados en las variables
        System.out.println("Introduce la segunda nota"); //Se solicita mediante texto la siguiente variable, este proceso se sucederá con todas las variables de nota declaradas
        nota2 = sc.nextDouble();
        System.out.println("Introduzca la tercera nota");
        nota3 = sc.nextDouble();
        System.out.println("Introduzca la cuarta y última nota");
        nota4 = sc.nextDouble();
        sc.close(); //Comando para cerrar el scanner una vez introducidas todas las notas
        
        ponderacion = (nota1 * 0.2 + nota2 * 0.2) + (nota3 * 0.3 + nota4 * 0.3); //Se le aplica a la variable anteriormente declarada el cálculo pertinente
                                                                                 //El cálculo se realiza en base a las variables introducidas mediante el scanner
        
                                                                                 
        System.out.println("La ponderación de la nota es la siguiente " + ponderacion);
        //La consola muestra el resultado al final del programa
    
    }

}
