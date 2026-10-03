public class Cotizador{
	public static void main (String [] args) {

        String nombreCliente = "Robbie Valentino";
        char clasificacionCliente = 'E';
        int precioProducto = 12899;
        double tasaAnual = 0.15;
        int plazoMeses = 21;
        double plazoAnios = plazoMeses / 12.0;
        double interes = precioProducto * tasaAnual * plazoAnios;
        double totalAPagar = precioProducto + interes;
        double mensualidad = totalAPagar / plazoMeses;

        System.out.println("===Cotizador señor Pines===");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Tiene una Clasificacion tipo: " + clasificacionCliente);
        System.out.printf("Precio total a pagar: $%.2f\n", totalAPagar);
        System.out.printf("Intereses en la compra: $%.2f\n", interes);
        System.out.printf("Debe usted pagar cada mes: $%.2f\n", mensualidad);
        System.out.println("===Cumple con el pago cada mes===");
        System.out.println("===Gracias por confiar en la Cabaña del Misterio===");
    }
}