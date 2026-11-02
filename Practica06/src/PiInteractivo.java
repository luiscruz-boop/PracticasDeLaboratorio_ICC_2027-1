import java.util.Scanner;

/**
 * Estimacion de pi con dardos (metodo Monte Carlo).
 *
 * El usuario decide cuantos dardos se lanzan
 * y el programa valida lo que escribe.
 */
public class PiInteractivo {
	public static void main (String [] args) {

		Scanner sc = new Scanner(System.in);

		// == 1. PEDIR Y VALIDAR LA CANTIDAD DE DARDOS ==
		int dardosTotales = 0;
		boolean valido = false;

		// El ciclo se repite hasta tener un entero mayor que cero.
		while (!valido) {
			System.out.print("Cuantos dardos quieres lanzar? ");

			//hasNextInt() solo "mira" si lo siguiente es un int, sin leerlo.
			// Nos da false con texto, con decimales (3.5) y con numeros que no
			//caben en un int (99999999999), asi que cubre esos tres errores. 
			if (sc.hasNextInt()) {
				dardosTotales = sc.nextInt();
				sc.nextLine(); // se come el Enter que quedo pendiente

				// El tipo es correcto, falta revisar que tenga sentido.
				if (dardosTotales > 0) {
					valido = true;
				} else {
					System.out.println("Error: la cantidad debe ser mayor que cero.");
				}
			} else {
				sc.nextLine(); // descarta lo que escribio el usuario
				System.out.println("Error: eso no es un numero entero valido "
						+ "(sin decimales, sin letras y que no sea demasiado grande).");
			}
		}

		// == 2. LANZAR LOS DARDOS ==
		int dardosLanzados = 0;
		int dardosDentro = 0;

		while (dardosLanzados < dardosTotales) {
			// Un dardo es un punto (x, y) con coordenadas entre 0 y 1.
			double x = Math.random ();
			double y = Math.random ();

			// Por Pitagoras, el punto esta dentro del cuarto de circulo
			// si su distancia al origen es menor o igual que 1.
			if  (x * x + y * y <= 1) {
				dardosDentro++;
			}

			dardosLanzados++;
		}

		// == 3. CALCULAR Y MOSTRAR RESULTADOS ==
		// 4.0 (y no 4) fuerza division con decimales; con enteros se perderian.
		double estimacionPi = 4.0 * dardosDentro / dardosTotales;

		System.out.printf("Dardos lanzados: %d%n", dardosTotales);
		System.out.printf("Dardos dentro del círculo: %d%n", dardosDentro);
		System.out.printf("Aproximación de Pi: %.6f%n", estimacionPi);
	}
}