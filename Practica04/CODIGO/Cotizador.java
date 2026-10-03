public class Cotizador{
	public static void main (String [] args) {

		/*
		* Bueno cada uno de estos términos los aplicamos
		* en el laboratorio y llegamos a cada uno de ellos
		* a traves de la actividad que estabamos realizando
		*/
        String nombreCliente = "Robbie Valentino";
        char clasificacionCliente = 'E';
        int precioProducto = 12899;
        double tasaAnual = 0.15;
        int plazoMeses = 21;
        double plazoAnios = plazoMeses / 12.0;
        double interes = precioProducto * tasaAnual * plazoAnios;
        double totalAPagar = precioProducto + interes;

        /*
        * Bueno en esta primera parte soloo agregue lo que nos faltaba y que
        * no cubrimos en el laboratorio, el cual solo fue agregar 
        * cuanto iba a pagar el cliente cada mes
        */
        double mensualidad = totalAPagar / plazoMeses;

        System.out.println("===Cotizador señor Pines===");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Tiene una Clasificacion tipo: " + clasificacionCliente);
        /*
        * Bueno aqui implemente los printf, los cuales me ayudaron a que el valor
        * no saliera con muchos digitos y que se leyera como si
        * estuvieras recibiendo un ticket de compra
        */
        System.out.printf("Precio total a pagar: $%.2f\n", totalAPagar);
        System.out.printf("Intereses en la compra: $%.2f\n", interes);
        System.out.printf("Debe usted pagar cada mes: $%.2f\n", mensualidad);
        /*
        * Esto ya fue un extra para que se sintiera un poco más amigable 
        * la cosa y solo fue agregarle dos textos más como si
        * fuera lo que viene al final de una compra
        */
        System.out.println("===Cumple con el pago cada mes===");
        System.out.println("===Gracias por confiar en la Cabaña del Misterio===");
    }
}