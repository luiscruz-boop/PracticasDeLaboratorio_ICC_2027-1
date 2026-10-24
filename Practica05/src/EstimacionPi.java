public class EstimacionPi {
	public static void main (String [] args) {

		int dardosTotales = 1000000;
		int dardosLanzados = 0;
		int dardosDentro = 0;

		while (dardosLanzados < dardosTotales) {
			double x = Math.random ();
			double y = Math.random ();
			
			if  (x * x + y * y <= 1) {
				dardosDentro++;
			}
				
			dardosLanzados++;
		}
			double estimacionPi = 4.0 * dardosDentro / dardosTotales;

		System.out.printf("Dardos lanzados: %d%n", dardosTotales);
		System.out.printf("Dardos dentro del cicrculo: %d%n", dardosDentro);
		System.out.printf("Aproximación de Pi: %.6f%n", estimacionPi);
	}
}