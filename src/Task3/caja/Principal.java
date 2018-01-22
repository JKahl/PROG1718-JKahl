package Task3.caja;

import Task3.caja.Caja.Material;
import Task3.utilidades.ES;
import java.util.Scanner;

/**
 * Clase principal del programa, que consiste en un bucle do-while que estar�
 * iterando continuamente mientras que el usuario no introduzca un 0.
 *
 * @author
 */
public class Principal {

   
    public static void main(String[] args) {

        int respuesta = 1;
        int ancho, alto, materialOpt;
        char caracter;
        Material material;

        //Apertura del bucle
        while (respuesta == 1) {
            // Escribir por pantalla: Primero vamos a crear la caja.
            ES.msgln("Primero vamos a crear la caja.");
            // Pedir por teclado el car�cter con el que se dibujar� la caja
            caracter = ES.leeCaracter("Escriba un caracter para dibujar la caja");
            // Pedir por teclado el n�mero de columnas que tendr� la caja
            alto = ES.leeEntero("Escribe el alto de la caja");
            // Pedir por teclado el n�mero de filas que tendr� la caja
            ancho = ES.leeEntero("Escribe el ancho que tendrá la caja");
            // Pedir el tipo de material de la caja.
            materialOpt = ES.leeEntero("Escribe el material de la caja (1-> Madera 2-> Corcho, 3-> Plastico, 4-> Carton)");
            // Pasar el entero introducido al tipo enumerado correspondiente 
            material = Caja.enteroAmaterial(materialOpt);
            // Usar el constructor con par�metros pas�ndole los valores le�dos por teclado
            Caja constructor = new Caja(alto, ancho, caracter, material);
            // Usar toString para mostrar los valores del objeto reci�n creado
            ES.msgln(constructor.toString());

            // Dibujar la caja con el m�todo apropiado
            constructor.dibujar();
            // Leer un valor entero por teclado para aumentar la altura de la caja 
            ES.leeEntero("Si quiere aumentar el ancho de la caja, especifique un número");
            // usando el m�todo creado para tal efecto.
            constructor.aumentarAnchura(ancho);
            // Escribir los datos de la caja.
            ES.msgln("Estos son los nuevos datos de la caja:");
            ES.msgln(constructor.toString());
            // Dibujar de nuevo la caja
            constructor.dibujar();
            // Informamos sobre que vamos a girar la caja
            ES.msgln("Ahora el programa girará la caja automáticamente");
            // Aplicar el m�todo de giro
            constructor.girarCaja();
            // Escribir los datos de la caja.
            ES.msgln("Los nuevos datos de la caja son:");
            ES.msgln(constructor.toString());
            // Dibujar de nuevo la caja
            constructor.dibujar();
            // Pedir por teclado un 1 para seguir iterando o un 0 para terminar la ejecuci�n
            respuesta = ES.leeEntero("Si quiere continuar con la ejecución del programa introduzca un 1, en caso contrario, introduzca un 0");
            // Cierre del bucle
      
        }
    }
}
