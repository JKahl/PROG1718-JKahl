/*
* Práctica 3 Programación
* @author JKahl
* @version 1.0
 */
package Task3.caja;
/**
 * Clase para controlar los parámetros del objeto caja
 * @author Javier
 */
public class Caja {

    int alto;
    int ancho;
    char caracter;
    Material material;

    /**
     * Se establecen los posibles valores que puede tomar la variable material,
     * mediante un enumerado
     */
    public enum Material {

        MADERA, CORCHO, PLASTICO, CARTON

    }

    /**
     * Getter Alto
     *
     * @return alto
     */
    public int getAlto() {
        return alto;
    }
    
    /**
     * Setter Alto
     * @param alto 
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }
    
    /**
     * Getter Ancho
     * @return ancho
     */
    public int getAncho() {
        return ancho;
    }
    
    /**
     * Setter Ancho
     * @param ancho 
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
    /**
     * Getter Caracter
     * @return caracter
     */
    public char getCaracter() {
        return caracter;
    }
    
    /**
     * Setter Caracter
     * @param caracter 
     */
    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    /**
     * Establece valores por defecto para pintar la caja en caso en el que el
     * usuario del programa no introdujese valores.
     */
    public Caja() {

        this.alto = 2;
        this.ancho = 5;
        this.material = Material.CORCHO;
        this.caracter = '*';

    }

    /**
     * Método cuya utilizad es inicializar los atributos del objeto CAJA cuando
     * sea necesario
     *
     * @param alto Es el número de filas que tendrá la caja
     * @param ancho Es el número de columnas que tendrá la caja
     * @param caracter Almacenará el carácter designado por el usuario para
     * pintar la caja
     * @param material Es la variable que almacenará el material del que estará
     * compuesto la caja
     */
    public Caja(int alto, int ancho, char caracter, Material material) {

        this.alto = alto;
        this.ancho = ancho;
        this.caracter = caracter;
        this.material = material;
    }

    /**
     * Método string que devolverá un string indicando los valores de la caja
     *
     * @return Línea de texto con los datos obtenidos de la consulta de los
     * getter y los setter
     *
     */
    public String toString() {

        return "La caja se dibuja con el caracter " + getCaracter() + " y se dibujará con: " + getAncho() + "  columnas y  " + getAlto() + " filas. El material de la caja es: " + this.material;

    }

    /**
     * Método dibujar que será el encargado de imprimir las instrucciones dadas
     * por el usuario en la pantalla de forma correcta. El valor devuelto por el
     * return es la caja pintada.
     */
    public void dibujar() {

        String caja = "";

        for (int i = 0; i < getAlto(); i++) {

            for (int a = 0; a < getAncho(); a++) {

                caja += getCaracter();

            }

            System.out.println(caja);
            caja = "";

        }

        
    }

    /**
     * Método boolean con una variable entrada asignada que contendrá el valor
     * que el usuario indique para aumentar el ancho de la caja. Mediante el
     * comparador booleano establecemos un false si el usuario no introduce un
     * valor, y un true en caso opuesto. Según la interacción del usuario se
     * aumentará el ancho en la medida designada por el mismo.
     *
     * @param entrada Variable que almacena el dato introducido por el usuario
     * ante la pregunta de si quiere aumentar el ancho de la caja o no.
     *
     * @return ok Valor booleano que devuelve el programa y que por defecto es
     * "false".
     *
     */
    public boolean aumentarAnchura(int entrada) {

        boolean ok = false;

        if (entrada == 0) {

            ok = false;

        } else if (entrada > 0) {

            ok = true;

            setAncho(entrada + getAncho());
        }

        return ok;

    }

    /**
     * Método que mediante dos variables nuevas, asignadas a los getter de alto
     * y ancho intercambiará los valores entre ambas variables, permitiendo que
     * la caja gire si el usuario lo ordena por consola.
     */
    
    public void girarCaja() {

        int ancho2 = getAlto();
        int alto2 = getAncho();

        setAlto(ancho2);
        setAncho(alto2);

    }

    /**
     * Método que utiliza una estructura switch para escoger el material
     * que conformará la caja que pintará el programa. Asigna a cada material
     * posible un número, y también designa un caso "default" para la situación
     * en la que se designe cualquier otro valor que no sea 1-4.
     * 
     * @param entrada Variable reutilizada que se encarga de almacenar el valor
     * introducido por el usuario ante la pregunta de elegir un material.
     * 
     * @return material2 Valor que tomará una de las opciones preestablecidas
     * por el método tras la ejecución de la estructura switch.
     */
    
    public static Material enteroAmaterial(int entrada) {

        Material material2;

        switch (entrada) {

            case 1:

                material2 = Material.MADERA;

                break;

            case 2:

                material2 = Material.CORCHO;
                break;

            case 3:

                material2 = Material.PLASTICO;
                break;

            case 4:

                material2 = Material.CARTON;
                break;

            default:
                material2 = Material.MADERA;

        }

        return material2;

    }

}
