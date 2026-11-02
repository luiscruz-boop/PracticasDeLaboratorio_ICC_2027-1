import java.util.Scanner;

/**
 * Convierte a binario un numero entero que elige el usuario.
 *
 * Metodo: dividir entre 2 repetidamente; los residuos, leidos del ultimo
 * al primero, son el numero en binario. Ejemplo con 26:
 * 26/2=13 r0, 13/2=6 r1, 6/2=3 r0, 3/2=1 r1, 1/2=0 r1  ->  11010
 */
public class BinarioInteractivo {

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		boolean otraVez = true; // controla si se repite todo el programa

		// Ciclo exterior: se repite mientras el usuario quiera convertir mas numeros.
		while (otraVez) {
			int numero = -1;
			boolean valido = false;

			// == 1. PEDIR Y VALIDAR EL NUMERO ==
			while (!valido) {
				System.out.print("Escribe un numero entero (0 o mayor): ");

				// hasNextInt() rechaza texto, decimales y numeros demasiado grandes.
				if (sc.hasNextInt()) {
					numero = sc.nextInt();
					sc.nextLine(); // limpia el Enter pendiente

					// Tipo correcto; ahora se revisa que no sea negativo.
					if (numero >= 0) {
						valido = true;
					} else {
						System.out.println("Error: el numero no puede ser negativo.");
					}
				} else {
					sc.nextLine(); // descarta lo escrito
					System.out.println("Error: eso no es un numero entero valido "
							+ "(sin decimales, sin letras y que no sea demasiado grande).");
				}
			}

			// == 2. CONVERSION A BINARIO ==
			int original = numero; // copia, porque 'numero' se va a ir reduciendo
			String binario = "";

			// Caso especial: con 0 el ciclo de abajo no entra y quedaria vacio.
			if (numero == 0) {
				binario = "0";
			}

			while (numero > 0) {
				// El residuo se pega AL FRENTE: el primer residuo es el bit
				// menos significativo y debe quedar a la derecha.
				binario = (numero % 2) + binario;
				numero = numero / 2; // division entera
			}

			System.out.println("El numero " + original + " en binario es: " + binario);

			// == 3. PREGUNTAR SI SE REPITE ==
			System.out.print("Quieres convertir otro numero? (s/n): ");
			char respuesta = sc.next().charAt(0); // primera letra de lo escrito
			sc.nextLine();

			// Solo 's' o 'S' continua; cualquier otra cosa termina el programa.
			if (respuesta != 's' && respuesta != 'S') {
				otraVez = false;
				System.out.println("Hasta luego!");
			}
		}
	}
}