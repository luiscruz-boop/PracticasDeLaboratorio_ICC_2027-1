public class CotizadorPines {
    public static void main(String [] args) {

        String nombreCliente = "Robbie Valentino";
        char tipoCliente = 'E';
        double capital = 12899.0;
        double tasaAnual = 15.0;
        int plazoMeses = 21;

        boolean datosValidos = true;

        if (capital <= 0) {
            System.out.println("Error: el capital debe ser mayor que 0");
            datosValidos = false;
        }
        if (tasaAnual < 0) {
            System.out.println("Error: la tasa anual no puede ser negativa");
            datosValidos = false;
        }
        if (plazoMeses <= 0) {
            System.out.println("Error: el plazo debe ser de al menos 1 mes");
            datosValidos = false;
        }
        if (tipoCliente != 'P' && tipoCliente != 'E' && tipoCliente != 'R') {
            System.out.println("Error: el tipo de cliente debe ser 'P', 'E' o 'R'.");
            datosValidos = false;
        }

        double tasaAplicada = 0.0;

        if (datosValidos) {

            if (tipoCliente == 'P') {
                tasaAplicada = tasaAnual - 2;
            } else if (tipoCliente == 'E') {
                tasaAplicada = tasaAnual;
            } else {
                tasaAplicada = tasaAnual + 3;
            }
        

            double plazoAnios = plazoMeses / 12.0;
            double interes = capital * (tasaAplicada / 100) * plazoAnios;
            double totalApagar = capital + interes;
            double mensualidad = totalApagar / plazoMeses;

            System.out.println("\n+++++ Cotizador de La Cabana del Misterio +++++\n");
            System.out.println("--- Datos del cliente ---");
            System.out.printf("Cliente: %s%n", nombreCliente);
            System.out.printf("Clasificacion: %c%n", tipoCliente);
            System.out.println();
            System.out.println("--- Datos del prestamo ---");
            System.out.printf("Prestamo: $ %.2f%n", capital);
            System.out.printf("Tasa Aplicada = %.0f%%%n", tasaAplicada);
            System.out.printf("Mensualidad = $ %.2f%n", mensualidad);
            System.out.println("Meses de pago = " + plazoMeses);
            System.out.println();
            System.out.println("--- Resultado ---");
            System.out.printf("Interés simple = $ %.2f%n", interes);
            System.out.printf("Total con interés simple = $ %.2f%n", totalApagar);
            System.out.println();
        }

        double tasaMensual = tasaAplicada / 100 / 12;
        double saldo = capital;

        System.out.println();
        System.out.println("+++ Saldo mes por mes +++");

        for (int mes = 1; mes <= plazoMeses; mes++) {
            saldo = saldo * (1 + tasaMensual);
            System.out.printf("En el mes %d se tiene un saldo de %.2f%n", mes, saldo);
        }

        double totalCompuesto = saldo;
        double interesCompuesto = totalCompuesto - capital;

        double totalFormula = capital * Math.pow(1 + tasaMensual, plazoMeses);

        System.out.println();
        System.out.printf("Interes compuesto = $ %.2f%n", interesCompuesto);
        System.out.printf("Total con el interes compuesto = $ %.2f%n", totalCompuesto);
        System.out.printf("Total con la formula (Math.pow) = $ %.2f%n", totalFormula);
    }
}