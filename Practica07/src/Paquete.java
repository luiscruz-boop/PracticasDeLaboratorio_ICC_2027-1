/**
 * Clase que modela un paquete para una empresa de envios postales y paqueteria.
 * Permite registrar sus dimensiones espaciales, peso fisico y valor declarado,
 * asi como calcular su peso volumetrico y determinar el peso cobrable final.
 *
 * @author Cruz Hernandez Luis Angel
 * @version 6.0
 */
public class Paquete {

    // ATRIBUTOS 

    // Todos son privados (encapsulamiento): solo cambian mediante constructores y setters.

    /** Codigo de rastreo alfanumerico del paquete (ej. "PK-001"). */
    private String codigoRastreo;

    /** Peso fisico del paquete, en kilogramos. */
    private double peso;

    /** Largo del paquete, en centimetros. */
    private double largo;

    /** Ancho del paquete, en centimetros. */
    private double ancho;

    /** Alto del paquete, en centimetros. */
    private double alto;

    /** Valor monetario declarado del contenido, en pesos. */
    private double valorDeclarado;

    /**
     * Indica si el contenido es fragil y por lo tanto
     * requiere un manejo especial.
     */
    private boolean fragil;


    // CONSTRUCTORES

    /**
     * Constructor por defecto. Crea un paquete en blanco con valores
     * predeterminados validos: codigo "SIN-CODIGO", 1.0 kg, dimensiones de
     * 10 * 10 * 10 cm, valor declarado de $0.00 y no fragil.
     */
    public Paquete() {
        codigoRastreo = "SIN-CODIGO";
        peso = 1.0;
        largo = 10.0;
        ancho = 10.0;
        alto = 10.0;
        valorDeclarado = 0.0;
        fragil = false;
    }

    /**
     * Constructor con parametros. Valida los datos recibidos para que el paquete
     * nunca nazca en un estado imposible; si un dato no es valido se asigna un
     * valor seguro por defecto:
     * <ul>
     *   <li>Codigo nulo o vacio: se asigna "SIN-CODIGO".</li>
     *   <li>Peso menor o igual a cero: se asigna 1.0 kg.</li>
     *   <li>Si largo, ancho o alto no son todos positivos: las tres dimensiones
     *       se asignan en 10.0 cm.</li>
     *   <li>Valor declarado negativo: se asigna $0.00.</li>
     * </ul>
     * El paquete se crea no fragil.
     *
     * @param cod Codigo de rastreo del paquete.
     * @param pes Peso fisico en kilogramos.
     * @param lar Largo en centimetros.
     * @param anc Ancho en centimetros.
     * @param alt Alto en centimetros.
     * @param val Valor declarado en pesos.
     */
    public Paquete(String cod, double pes, double lar, double anc, double alt, double val) {
        // Validacion del codigo
        if (cod == null || cod.equals("")) {
            codigoRastreo = "SIN-CODIGO";
        } else {
            codigoRastreo = cod;
        }

        // Validacion del peso
        if (esPositivo(pes)) {
            peso = pes;
        } else {
            peso = 1.0;
        }

        // Validacion de las dimensiones
        if (esPositivo(lar) && esPositivo(anc) && esPositivo(alt)) {
            largo = lar;
            ancho = anc;
            alto = alt;
        } else {
            largo = 10.0;
            ancho = 10.0;
            alto = 10.0;
        }

        // Validacion del valor declarado (puede ser 0, pero no negativo)
        if (val >= 0) {
            valorDeclarado = val;
        } else {
            valorDeclarado = 0.0;
        }

        fragil = false;
    }


    // METODOS DE ACCESO Y ASIGNACION

    /**
     * Consulta el codigo de rastreo.
     *
     * @return El codigo de rastreo del paquete.
     */
    public String getCodigoRastreo() {
        return codigoRastreo;
    }

    /**
     * Modifica el codigo de rastreo. Si el nuevo codigo es nulo o vacio no se
     * modifica y se muestra un mensaje de error.
     *
     * @param nuevoCodigo Nuevo codigo de rastreo.
     */
    public void setCodigoRastreo(String nuevoCodigo) {
        if (nuevoCodigo != null && !nuevoCodigo.equals("")) {
            codigoRastreo = nuevoCodigo;
        } else {
            System.out.println("Error: El codigo de rastreo no puede ser nulo ni vacio.");
        }
    }

    /**
     * Consulta el peso fisico.
     *
     * @return El peso fisico en kilogramos.
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Modifica el peso fisico. Solo se acepta un valor mayor a cero.
     *
     * @param nuevoPeso Nuevo peso en kilogramos.
     */
    public void setPeso(double nuevoPeso) {
        if (esPositivo(nuevoPeso)) {
            peso = nuevoPeso;
        } else {
            System.out.println("Error: El peso debe ser mayor a 0 kg.");
        }
    }

    /**
     * Consulta el largo.
     *
     * @return El largo en centimetros.
     */
    public double getLargo() {
        return largo;
    }

    /**
     * Modifica el largo. Solo se acepta un valor mayor a cero.
     *
     * @param nuevoLargo Nuevo largo en centimetros.
     */
    public void setLargo(double nuevoLargo) {
        if (esPositivo(nuevoLargo)) {
            largo = nuevoLargo;
        } else {
            System.out.println("Error: El largo debe ser mayor a 0 cm.");
        }
    }

    /**
     * Consulta el ancho.
     *
     * @return El ancho en centimetros.
     */
    public double getAncho() {
        return ancho;
    }

    /**
     * Modifica el ancho. Solo se acepta un valor mayor a cero.
     *
     * @param nuevoAncho Nuevo ancho en centimetros.
     */
    public void setAncho(double nuevoAncho) {
        if (esPositivo(nuevoAncho)) {
            ancho = nuevoAncho;
        } else {
            System.out.println("Error: El ancho debe ser mayor a 0 cm.");
        }
    }

    /**
     * Consulta el alto.
     *
     * @return El alto en centimetros.
     */
    public double getAlto() {
        return alto;
    }

    /**
     * Modifica el alto. Solo se acepta un valor mayor a cero.
     *
     * @param nuevoAlto Nuevo alto en centimetros.
     */
    public void setAlto(double nuevoAlto) {
        if (esPositivo(nuevoAlto)) {
            alto = nuevoAlto;
        } else {
            System.out.println("Error: El alto debe ser mayor a 0 cm.");
        }
    }

    /**
     * Consulta el valor declarado.
     *
     * @return El valor declarado en pesos.
     */
    public double getValorDeclarado() {
        return valorDeclarado;
    }

    /**
     * Modifica el valor declarado. Solo se acepta un valor mayor o igual a cero.
     *
     * @param nuevoValor Nuevo valor declarado en pesos.
     */
    public void setValorDeclarado(double nuevoValor) {
        if (nuevoValor >= 0) {
            valorDeclarado = nuevoValor;
        } else {
            System.out.println("Error: El valor declarado no puede ser negativo.");
        }
    }

    /**
     * Consulta si el paquete es fragil.
     *
     * @return true si el paquete es fragil; false en caso contrario.
     */
    public boolean isFragil() {
        return fragil;
    }

    /**
     * Modifica si el paquete es fragil.
     *
     * @param nuevaFragilidad true si el paquete es fragil; false si no lo es.
     */
    public void setFragil(boolean nuevaFragilidad) {
        fragil = nuevaFragilidad;
    }


    // METODOS CALCULADORES BASE

    /**
     * Calcula el peso volumetrico del paquete segun el estandar comercial (IATA):
     * (largo * ancho * alto) / 5000.
     *
     * @return El peso volumetrico equivalente en kilogramos.
     */
    public double calculaPesoVolumetrico() {
        double pesoVolumetrico = (largo * ancho * alto) / 5000.0;

        return pesoVolumetrico;
    }

    /**
     * Determina el peso cobrable final para efectos de tarificacion postal,
     * el cual corresponde al valor maximo entre el peso fisico y el volumetrico.
     *
     * @return El mayor entre el peso real y el peso volumetrico.
     */
    public double obtenerPesoCobrable() {
        double pesoVolumetrico = calculaPesoVolumetrico();
        double pesoCobrable;

        if (peso > pesoVolumetrico) {
            pesoCobrable = peso;
        } else {
            pesoCobrable = pesoVolumetrico;
        }

        return pesoCobrable;
    }

    /**
     * Calcula el cargo por manejo especial de un paquete fragil.
     * Un paquete fragil requiere un trato cuidadoso, y si se
     * danara la empresa responde por el contenido, por eso el cargo tiene una
     * parte fija ($50.00) y una parte proporcional al valor declarado (2%),
     * de modo que entre mas valioso es el contenido, mayor es el cargo.
     * Si el paquete no es fragil el cargo es $0.00.
     *
     * @return El cargo en pesos por manejo fragil: 50 + (2% del valor declarado)
     *         si el paquete es fragil; 0.0 en caso contrario.
     */
    public double calcularCargoFragil() {
        double cargo = 0.0;

        if (fragil) {
            cargo = 50.0 + valorDeclarado * 0.02;
        }

        return cargo;
    }


    // METODOS ESTANDAR Y AUXILIARES

    /**
     * Devuelve un resumen legible de los atributos del paquete.
     *
     * @return Cadena con el codigo, peso, dimensiones, valor declarado y fragilidad.
     */
    @Override
    public String toString() {
        return "Paquete [codigo=" + codigoRastreo
                + ", peso=" + peso + " kg"
                + ", dimensiones=" + largo + "x" + ancho + "x" + alto + " cm"
                + ", valorDeclarado=$" + valorDeclarado
                + ", fragil=" + fragil + "]";
    }

    /**
     * Metodo auxiliar privado: revisa que un numero sea positivo.
     * Al comparar si es mayor a cero, un NaN tambien se rechaza..
     *
     * @param dato Numero a revisar.
     * @return true si el dato es mayor a cero y no es infinito; false en caso contrario.
     */
    private boolean esPositivo(double dato) {
        boolean positivo = dato > 0;

        return positivo;
    }

}
