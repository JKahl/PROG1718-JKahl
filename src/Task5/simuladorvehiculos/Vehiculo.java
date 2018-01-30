package Task5.simuladorvehiculos;

/**
 * Clase que representa un <strong>vehículo</strong>.
 * <p>
 * Los objetos de esta clase contienen atributos que que permiten almacenar
 * información sobre:</p>
 * <ul>
 * <li><strong>Capacidad del depósito</strong> de combustible (litros).</li>
 * <li><strong>Consumo medio</strong> del vehículo (litros/100km).</li>
 * <li><strong>Estado del motor</strong> (<strong>encendido</strong> o <strong>apagado</strong>).</li>
 * <li><strong>Nivel de combustible</strong> actual (litros).</li>
 * <li><strong>Distancia recorrida</strong> desde que se arrancó el motor por última vez (y no se
 * ha apagado) (km).</li>
 * <li><strong>Distancia recorrida total</strong> desde que el objeto se creó (km).</li>
 * <li><strong>Combustible consumido</strong> desde que se arrancó el motor por última vez (y no
 * se ha apagado) (litros).</li>
 * <li><strong>Combustible total consumido</strong> desde que el objeto se creó (litros).</li>
 * </ul>
 * <p>
 * La clase también dispone de información general independiente de los objetos
 * concretos que se hayan creado. Es el caso de:</p>
 * <ul>
 * <li><strong>Distancia recorrida total</strong> por <strong>todos los vehículos</strong> que se hayan creado
 * hasta el momento (km).</li>
 * <li><strong>Combustible total consumido</strong> por <strong>todos los vehículos</strong> que se hayan creado
 * hasta el momento (litros).</li>
 * <li><strong>Número de vehículos</strong> con el <strong>motor encendido</strong> en el momento actual.</li>
 * </ul>
 * @author JKahl
 * @version 1.0
 */

public class Vehiculo {

    //Lista de variables
    double capacidadDeposito = 0.; // Capacidad máxima del depósito
    double consumoMedio = 0.; // Consumo medio del vehiculo litros/km
    boolean arrancado = false; // Motor encendido/apagado
    double nivelCombustible = 0.; // Nivel actual de combustible
    double distanciaRecorrida = 0.; // Cantidad de km recorridos desde que se arrancó por última vez
    double combustibleConsumido = 0.; // Consumo del vehículo desde que se ha arrancado por última vez
    double distanciaRecorridaTotal = 0.; // Distancia recorrida por el vehículo desde que se fabricó
    double combustibleConsumidoTotal = 0.; // Consumo total del vehículo desde que se fabricó
    static double distanciaRecorridaFlota = 0.;
    static double combustibleConsumidoFlota = 0.;
    static long numVehiculosArrancadosFlota = 0L;

    //Lista de constantes
    final double MIN_CONSUMO_MEDIO = 2.0;
    final double MAX_CONSUMO_MEDIO = 20.0;
    final double MIN_CAPACIDAD_DEPOSITO = 10.0;
    final double MAX_CAPACIDAD_DEPOSITO = 120.0;
    final double CONSUMO_COMBUSTIBLE_ARRANQUE = 0.02;
    final double CONSUMO_MEDIO_DEFAULT = 5.0;
    final double CAPACIDAD_DEPOSITO_DEFAULT = 50.0;

    /**
     * Método constructor con valores predeterminados.
     */
    public Vehiculo() {

        this.capacidadDeposito = CAPACIDAD_DEPOSITO_DEFAULT;
        this.consumoMedio = CONSUMO_MEDIO_DEFAULT;

    }

    /**
     * Método constructor con los parámetros fueltank y averagefuelspending que
     * además incorpora una estructura if/else if para delimitar los posibles
     * valores de entrada y lanzar una excepción en caso de que no se cumplan
     * los requisitos del enunciado.
     *
     * @param capacidadDeposito
     * @param consumoMedio
     * @throws java.lang.IllegalArgumentException - Si alguno de los parámetros está fuera del rango permitido.
     */
    public Vehiculo(double consumoMedio, double capacidadDeposito) {

        if (capacidadDeposito < 10 || capacidadDeposito > 120) {

            throw new IllegalArgumentException("Los valores introducidos se encuentran fuera del rango designado");

        }

        if (consumoMedio < 2.0 || consumoMedio > 20) {

            throw new IllegalArgumentException("Los valores introducidos se encuentran fuera del rango designado");

        }

        this.capacidadDeposito = capacidadDeposito;
        this.consumoMedio = consumoMedio;
    }

    /**
     * Getter de la capacidad del vehículo.
     * 
     * @return Devuelve el valor de la capacidad del vehículo.
     */
    
    public double getCapacidadDeposito() {
        return capacidadDeposito;
    }

    /**
     * Getter del consumo medio del vehículo.
     * 
     * @return Devuelve el valor del consumo medio.
     */
    
    public double getConsumoMedio() {
        return consumoMedio;
    }

    /**
     * Getter booleano del estado arrancado del objeto vehículo.
     *
     * @return El estado del motor del vehículo.
     */
    public boolean isArrancado() {
        return arrancado;
    }

    /**
     * Getter del nivel de combustible del vehiculo
     *
     * @return Devuelve el valor del nivel de combustible
     */
    public double getNivelCombustible() {
        return nivelCombustible;
    }

    /**
     * Getter de la distancia recorrida.
     *
     * @return Valor de la distancia recorrida.
     */
    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    /**
     * Getter del combustible consumido.
     *
     * @return Valor del combustible consumido.
     */
    public double getCombustibleConsumido() {
        return combustibleConsumido;
    }

    /**
     * Getter de la distancia recorrida total.
     *
     * @return El valor de la distancia recorrida total.
     */
    public double getDistanciaRecorridaTotal() {
        return distanciaRecorridaTotal;
    }

    /**
     * Getter del combustible consumido total.
     *
     * @return Valor del combustible consumido total.
     */
    public double getCombustibleConsumidoTotal() {
        return combustibleConsumidoTotal;
    }

    /**
     * Getter de la distancia total recorrida de la flota.
     *
     * @return Distancia total recorrida de la flota.
     */
    public static double getDistanciaRecorridaFlota() {
        return distanciaRecorridaFlota;
    }

    /**
     * Getter del consumo de combustible de la flota.
     *
     * @return Total del combustible consumido por la flota
     */
    public static double getCombustibleConsumidoFlota() {
        return combustibleConsumidoFlota;
    }

    /**
     * Getter del número de coches de la flota que están arrancados.
     *
     * @return Número de coches de la flota arrancados
     */
    public static long getNumVehiculosArrancadosFlota() {
        return numVehiculosArrancadosFlota;
    }

    /**
     * Método repostar que mediante cáclulos entre variables realiza dos
     * comprobaciones: Si el repostaje excede o no la capacidad máxima del
     * vehículo, retornando una excepción en caso afirmativo, o si el repostaje
     * se realiza con el vehículo encendido, momento en el que otra excepción
     * paraliza la ejecución del método.
     *
     * @param repostajeLitros
     * @throws java.lang.IllegalStateException - Si el motor está arrancado.
     * java.lang.IllegalArgumentException - Si la cantidad de combustible que se
     * intenta repostar es superior a la que puede admitir el depósito en ese
     * momento. El depósito se llenará completamente pero se producirá un
     * rebosamiento.
     */
    public void repostar(double repostajeLitros) {

        double disponible = capacidadDeposito - nivelCombustible;
        double excesoLitros = 0.;

        if (repostajeLitros > disponible) {

            excesoLitros = repostajeLitros - disponible;

            nivelCombustible += (repostajeLitros - excesoLitros);

            throw new IllegalArgumentException("Error: Depósito lleno. Se ha desbordado el combustible en" + excesoLitros + "litros.");

        } else if (arrancado == true) {

            throw new IllegalStateException("Error: Se intentó repostar con el motor encendido. No se ha repostado.");

        } else {

            nivelCombustible = nivelCombustible + repostajeLitros;

        }

    }

    /**
     * Método que sirve para arrancar el Vehiculo. Contempla en el código
     * distintos escenarios y los trata individualmente conforme al enunciado de
     * la tarea.
     *
     * @throws IllegalStateException - Si el motor está ya encendido o si en el
     * depósito no hay suficiente combustible para arrancar.
     */
    public void arrancar() {

        if (isArrancado() == true) {

            throw new IllegalStateException("Error: El motor ya se encuentra arrancado.");

        } else if (isArrancado() == false && nivelCombustible > CONSUMO_COMBUSTIBLE_ARRANQUE) {

            this.arrancado = true;
            nivelCombustible = nivelCombustible - CONSUMO_COMBUSTIBLE_ARRANQUE;
            combustibleConsumidoFlota = combustibleConsumidoFlota + CONSUMO_COMBUSTIBLE_ARRANQUE;
            combustibleConsumidoTotal = combustibleConsumidoTotal + CONSUMO_COMBUSTIBLE_ARRANQUE;
            combustibleConsumido = combustibleConsumido + CONSUMO_COMBUSTIBLE_ARRANQUE;
            numVehiculosArrancadosFlota = numVehiculosArrancadosFlota + 1;

        } else if (nivelCombustible < CONSUMO_COMBUSTIBLE_ARRANQUE) {

            throw new IllegalStateException("Error: Depósito vacío. Se intentó arrancar sin combustible suficiente.");

        }

    }

    /**
     * Hace que el vehículo realice un trayecto de una determinada cantidad de
     * kilómetros que se pasarán como parámetro.
     *
     * @param distanciaRecorrida
     * @throws java.lang.IllegalStateException - Si está el motor apagado. Para
     * poder realizar un trayecto el motor del vehículo debe estar arrancado.
     * java.lang.IllegalArgumentException - Si no hay combustible suficiente
     * para recorrer esa distancia. En tal caso se consume todo el depósito, se
     * recorre la distancia que sea posible, y se apaga el motor. También se
     * puede producir esta excepción si la distancia proporcionada es negativa.
     */
    public void realizarTrayecto(double distanciaRecorrida) {

        if (isArrancado() == false) {

            throw new IllegalStateException("Error: Se intentó realizar un trayecto con el motor apagado. No se ha avanzado.");

        } else if (distanciaRecorrida < 0) {

            throw new IllegalArgumentException("Error: Se intentó realizar un trayecto negativo.");

        } else if (nivelCombustible < (distanciaRecorrida * (consumoMedio / 100))) {
            //Actualizaciones Distancia
            this.distanciaRecorrida = ((nivelCombustible * 100) / consumoMedio) + this.distanciaRecorrida;
            this.distanciaRecorridaTotal = ((nivelCombustible * 100) / consumoMedio) + this.distanciaRecorridaTotal;
            distanciaRecorridaFlota = ((nivelCombustible * 100) / consumoMedio) + distanciaRecorridaFlota;
            //Actualizaciones Combustible
            this.combustibleConsumido = nivelCombustible + this.combustibleConsumido;
            this.combustibleConsumidoTotal = nivelCombustible + this.combustibleConsumidoTotal;
            combustibleConsumidoFlota = nivelCombustible + combustibleConsumidoFlota;
            double antiguoNivel = this.nivelCombustible;
            this.nivelCombustible = 0;
            //Apagar motor, ya que el vehículo no tiene combustible
            apagar();

            throw new IllegalArgumentException("Error: No se ha podido finalizar el trayecto completamente. Depósito vacío. Han faltado por recorrer"
                    + String.format("%.2f", (distanciaRecorrida - ((antiguoNivel / this.consumoMedio) * 100))) + " km.");
        } else {
            //Actualizaciones Distancia
            this.distanciaRecorrida = this.distanciaRecorrida + distanciaRecorrida;
            this.distanciaRecorridaTotal = distanciaRecorrida + this.distanciaRecorridaTotal;
            distanciaRecorridaFlota = distanciaRecorrida + distanciaRecorridaFlota;
            //Actualizaciones Combustible
            this.combustibleConsumido = (distanciaRecorrida * (this.consumoMedio / 100)) + this.combustibleConsumido;
            this.combustibleConsumidoTotal = (distanciaRecorrida * (this.consumoMedio / 100)) + this.combustibleConsumidoTotal;
            combustibleConsumidoFlota = (distanciaRecorrida * (this.consumoMedio / 100)) + combustibleConsumidoFlota;
            this.nivelCombustible = this.nivelCombustible - ((distanciaRecorrida * (this.consumoMedio)) / 100);
        }

    }

    /**
     * Método que comrpueba si el vehículo está arrancado o no. De estarlo,
     * reinicia las variables correspondientes a la sesión distanciaRecorrida y
     * combustibleConsumido a 0 y apaga el motor. En caso contrario se lanza una
     * excepción.
     *
     * @exception IllegalStateException - Si el motor ya está apagado.
     */
    public void apagar() {

        if (isArrancado() == true) {

            this.arrancado = false;
            distanciaRecorrida = 0;
            combustibleConsumido = 0;
            numVehiculosArrancadosFlota = numVehiculosArrancadosFlota - 1;

        } else if (isArrancado() == false) {

            throw new IllegalStateException("Error: El motor ya se encuentra apagado.");

        }

    }

    /**
     * Método toString que representa la información proporcionada por el resto
     * de métodos.
     *
     * @return
     * <p>
     * Cadena que representa el estado actual del vehículo proporcionando la
     * siguiente información:</p>
     * <ol>
     * <li><strong>Estado del motor</strong> (<strong>encendido</strong> o
     * <strong>apagado</strong>).</li>
     * <li><strong>Nivel del depósito de combustible</strong>.</li>
     * <li><strong>Distancia recorrida</strong> desde que se ha arrancado (si es
     * que el motor está arrancado, pues si está apagado será obviamente
     * cero).</li>
     * <li><strong>Consumo realizado</strong> desde que se ha arrancado (si es
     * que el motor está arrancado, pues si está apagado será obviamente
     * cero).</li>
     * </ol>
     * <p>
     * <strong>El formato de salida</strong> será del siguiente tipo: </p>
     * <pre>Motor: XXX - Deposito: YYY - Dist: ZZZ - Consumo: VVV</pre>
     * <p>
     * donde XXX podrá ser encendido o apagado; YYY será el nivel del depósito
     * expresado en litros y con dos decimales; ZZZ será la distancia recorrida
     * expresada en kilómetros y con dos decimales, y VVV el consumo expresado
     * en litros y con dos decimales.</p>
     * <p>
     * Algunos ejemplos de este <code>String</code> de salida podrían ser:</p>
     * <ul>
     * <li><pre>Motor: apagado   - Depósito:   0,00 - Dist:     0,00 - Consumo:     0,00</pre></li>
     * <li><pre>Motor: arrancado - Depósito:   4,98 - Dist:     0,00 - Consumo:     0,02</pre></li>
     * <li><pre>Motor: arrancado - Depósito:   4,23 - Dist:    15,00 - Consumo:     0,77</pre></li>
     * <li><pre>Motor: apagado   - Depósito:   4,23 - Dist:     0,00 - Consumo:     0,00</pre></li>
     * <li><pre>Motor: arrancado - Depósito:   4,68 - Dist:    10,00 - Consumo:     0,32</pre></li>
     * </ul>
     */
    public String toString() {

        StringBuilder estadoMotor = new StringBuilder();
        if (isArrancado() == true) {

            estadoMotor.append("arrancado");

        } else {
            estadoMotor.append("apagado");
        }

        StringBuilder cadena = new StringBuilder("Motor: ");
        cadena.append(estadoMotor);
        cadena.append(" - Deposito: ");
        cadena.append((String.format("%.2f", this.nivelCombustible)));
        cadena.append(" - Dist: ");
        cadena.append(this.distanciaRecorrida);
        cadena.append(" - Consumo: ");
        cadena.append((String.format("%.2f", this.combustibleConsumido)));

        return cadena.toString();
    }

}
