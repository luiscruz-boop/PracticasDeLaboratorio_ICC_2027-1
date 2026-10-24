public class PrecisionPi {
    public static void main(String[] args) {
    
        double tolerancia = 0.001;
    
        int dardosLanzados = 0;
        int dardosDentro = 0;

        double estimacionPi = 0.0;

        double error = Math.abs(estimacionPi - Math.PI);

        
        while (error >= tolerancia) {
            double x = Math.random();
            double y = Math.random();

            if (x * x + y * y <= 1) {
                dardosDentro++;
            }
            dardosLanzados++;
            
            estimacionPi = 4.0 * dardosDentro / dardosLanzados;
            
            error = Math.abs(estimacionPi - Math.PI);
        }

        System.out.printf("Tolerancia: %s%n", tolerancia);
        System.out.printf("Dardos necesarios: %d%n", dardosLanzados);
        System.out.printf("Estimacion de pi: %.6f%n", estimacionPi);
        System.out.printf("Error: %.6f%n", error);
    }
}
