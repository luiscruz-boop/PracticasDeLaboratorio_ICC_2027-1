/**
 * Programa de prueba para verificar el correcto funcionamiento de las clases
 * {@link Paquete} y {@link CotizadorEnvio}.
 *
 * @author Cruz Hernandez Luis Angel 
 * @version 3.0
 */
public class PruebaPaqueteria {

    /**
     * Metodo principal: crea los paquetes de prueba y muestra en consola los
     * resultados de cada caso junto con el valor esperado.
     *
     * @param args Argumentos de la linea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
    
        System.out.println("  PRUEBAS DEL SISTEMA DE ENVIOS POSTALES (PRACTICA 7) ");

        // CASO 1: Paquete estandar pequeno (peso fisico domina)
        // Datos requeridos: codigo "PK-001", peso 3.5 kg, dimensiones 20*15*10 cm,
        // valor declarado $800.0 pesos.
        
        System.out.println("- Caso 1: Paquete pequeno estandar -");
        Paquete p1 = new Paquete("PK-001", 3.5, 20, 15, 10, 800.0);
        mostrarDetallePaquete(p1);
        System.out.println("Es valido?: " + CotizadorEnvio.esPaqueteValido(p1));
        System.out.printf("Costo de envio cotizado: $%.2f (Esperado: $120.00)\n", CotizadorEnvio.cotizarEnvio(p1));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p1));
        System.out.println();

        // CASO 2: Paquete liviano pero voluminoso (peso volumetrico domina)
        // Datos requeridos: codigo "PK-002", peso 2.0 kg, dimensiones 50*40*50 cm,
        // valor declarado $1500.0 pesos.
        
        System.out.println("- Caso 2: Paquete voluminoso (volumen predomina) -");
        Paquete p2 = new Paquete("PK-002", 2.0, 50, 40, 50, 1500.0);
        mostrarDetallePaquete(p2);
        if (CotizadorEnvio.esPaqueteValido(p2)) {
            System.out.printf("Peso volumetrico calculado: %.2f kg\n", p2.calculaPesoVolumetrico());
            System.out.printf("Peso cobrable final: %.2f kg\n", p2.obtenerPesoCobrable());
        }
        System.out.printf("Costo de envio cotizado: $%.2f (Esperado: $425.00)\n", CotizadorEnvio.cotizarEnvio(p2));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p2));
        System.out.println();

        // CASO 3: Paquete de alto valor comercial (requiere seguro por monto)
        // Datos requeridos: codigo "PK-003", peso 4.0 kg, dimensiones 30*25*20 cm,
        // valor declarado $6500.0 pesos.
        
        System.out.println("- Caso 3: Paquete de alto valor monetario -");
        Paquete p3 = new Paquete("PK-003", 4.0, 30, 25, 20, 6500.0);
        mostrarDetallePaquete(p3);
        System.out.printf("Costo de envio: $%.2f\n", CotizadorEnvio.cotizarEnvio(p3));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p3) + " (Esperado: true)");
        System.out.println();

        // CASO 4: Paquete sobredimensionado (arista > 60 cm o suma > 150 cm)
        // Datos requeridos: codigo "PK-004", peso 5.0 kg, dimensiones 70*30*20 cm,
        // valor declarado $1200.0 pesos.
        
        System.out.println("- Caso 4: Paquete sobredimensionado -");
        Paquete p4 = new Paquete("PK-004", 5.0, 70, 30, 20, 1200.0);
        mostrarDetallePaquete(p4);
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p4) + " (Esperado: true por dimensiones)");
        System.out.println();

        
        // CASO 5: Validacion de referencia nula (null)
        
        System.out.println("- Caso 5: Validacion de referencia nula (null) -");
        Paquete pNulo = null;
        System.out.println("Es valido un paquete null?: " + CotizadorEnvio.esPaqueteValido(pNulo) + " (Esperado: false)");
        System.out.printf("Cotizacion de un paquete null: $%.2f (Esperado: -1.00)\n", CotizadorEnvio.cotizarEnvio(pNulo));
        System.out.println("Requiere seguro un paquete null?: " + CotizadorEnvio.requiereSeguro(pNulo) + " (Esperado: false)");
        System.out.println();

        // CASO 6: PRUEBAS DE TU METODO PERSONAL
        // Metodo propuesto: Paquete.calcularCargoFragil()
        //   cargo = 50 + 2% del valor declarado (solo si el paquete es fragil)
        
        System.out.println("        PRUEBAS PROPUESTA PERSONAL              ");

        // 6.1 Paquete NO fragil: el cargo debe ser $0.00
        System.out.println("- Caso 6.1: Paquete no fragil -");
        Paquete p5 = new Paquete("PK-005", 3.0, 20, 20, 20, 2500.0);
        mostrarDetallePaquete(p5);
        System.out.println("Es fragil?: " + p5.isFragil());
        System.out.printf("Cargo por manejo fragil: $%.2f (Esperado: $0.00)\n", p5.calcularCargoFragil());
        System.out.println();

        // 6.2 El mismo paquete, ahora marcado como fragil: 50 + 0.02 * 2500 = 100
        System.out.println("- Caso 6.2: Mismo paquete marcado como fragil -");
        p5.setFragil(true);
        System.out.println("Es fragil?: " + p5.isFragil());
        System.out.printf("Cargo por manejo fragil: $%.2f (Esperado: $100.00)\n", p5.calcularCargoFragil());
        double total = CotizadorEnvio.cotizarEnvio(p5) + p5.calcularCargoFragil();
        System.out.printf("Envio $%.2f + cargo fragil $%.2f = Total $%.2f (Esperado: $220.00)\n",
                CotizadorEnvio.cotizarEnvio(p5), p5.calcularCargoFragil(), total);
        System.out.println();

        // 6.3 Caso borde: fragil con valor declarado $0 -> solo la parte fija
        System.out.println("- Caso 6.3: Caso borde, fragil con valor declarado $0 -");
        Paquete p6 = new Paquete("PK-006", 1.0, 10, 10, 10, 0.0);
        p6.setFragil(true);
        System.out.printf("Cargo por manejo fragil: $%.2f (Esperado: $50.00)\n", p6.calcularCargoFragil());
        System.out.println();

        // 6.4 Caso borde: fragil de alto valor
        System.out.println("- Caso 6.4: Fragil de alto valor ($20,000) -");
        Paquete p7 = new Paquete("PK-007", 2.0, 30, 30, 30, 20000.0);
        p7.setFragil(true);
        System.out.printf("Cargo por manejo fragil: $%.2f (Esperado: $450.00)\n", p7.calcularCargoFragil());
        System.out.println();


        // CASO 7: CASOS BORDE Y VALIDACIONES (pruebas adicionales)

        System.out.println("        CASOS BORDE Y VALIDACIONES                    ");

        // 7.1 Constructor por defecto: es un objeto valido (no es lo mismo que null)
        System.out.println("- Caso 7.1: Constructor por defecto -");
        Paquete pDefecto = new Paquete();
        mostrarDetallePaquete(pDefecto);
        System.out.println("Es valido?: " + CotizadorEnvio.esPaqueteValido(pDefecto) + " (Esperado: true)");
        System.out.printf("Costo de envio: $%.2f (Esperado: $120.00)\n", CotizadorEnvio.cotizarEnvio(pDefecto));
        System.out.println();

        // 7.2 Constructor con datos invalidos: se asignan valores seguros
        System.out.println("- Caso 7.2: Constructor con datos invalidos -");
        Paquete pMalo = new Paquete("", -5.0, 0, -3, 10, -100.0);
        mostrarDetallePaquete(pMalo);
        System.out.println("Valor declarado: " + pMalo.getValorDeclarado() + " (Esperado: 0.0)");
        System.out.println();

        // 7.3 Setters con validacion: el valor invalido no cambia el objeto
        System.out.println("- Caso 7.3: Setters con datos invalidos -");
        Paquete pSet = new Paquete("PK-008", 2.0, 10, 10, 10, 100.0);
        pSet.setPeso(-2.0);
        pSet.setLargo(0);
        pSet.setValorDeclarado(-1.0);
        pSet.setCodigoRastreo(null);
        System.out.println("Despues de los errores: " + pSet);
        System.out.println();

        // 7.4 Bordes de la tarifa escalonada (peso cobrable exacto)
        System.out.println("- Caso 7.4: Bordes de la tarifa (dimensiones 10x10x10, vol. 0.2 kg) -");
        Paquete b1 = new Paquete("B-5", 5.0, 10, 10, 10, 100.0);
        Paquete b2 = new Paquete("B-15", 15.0, 10, 10, 10, 100.0);
        Paquete b3 = new Paquete("B-155", 15.5, 10, 10, 10, 100.0);
        Paquete b4 = new Paquete("B-16", 16.0, 10, 10, 10, 100.0);
        System.out.printf("5.0 kg  -> $%.2f (Esperado: $120.00)\n", CotizadorEnvio.cotizarEnvio(b1));
        System.out.printf("15.0 kg -> $%.2f (Esperado: $300.00)\n", CotizadorEnvio.cotizarEnvio(b2));
        System.out.printf("15.5 kg -> $%.2f (Esperado: $312.50)\n", CotizadorEnvio.cotizarEnvio(b3));
        System.out.printf("16.0 kg -> $%.2f (Esperado: $325.00)\n", CotizadorEnvio.cotizarEnvio(b4));
        System.out.println();

        // 7.5 Bordes del seguro (justo en el limite NO requiere; apenas arriba SI)
        System.out.println("- Caso 7.5: Bordes del seguro -");
        Paquete s1 = new Paquete("S-1", 2.0, 20, 20, 20, 3000.0);
        Paquete s2 = new Paquete("S-2", 2.0, 20, 20, 20, 3000.01);
        Paquete s3 = new Paquete("S-3", 2.0, 60, 50, 40, 100.0);
        Paquete s4 = new Paquete("S-4", 2.0, 61, 10, 10, 100.0);
        Paquete s5 = new Paquete("S-5", 2.0, 60, 50, 41, 100.0);
        System.out.println("Valor $3000.00          -> " + CotizadorEnvio.requiereSeguro(s1) + " (Esperado: false)");
        System.out.println("Valor $3000.01          -> " + CotizadorEnvio.requiereSeguro(s2) + " (Esperado: true)");
        System.out.println("60x50x40 (arista y suma justo en el limite) -> " + CotizadorEnvio.requiereSeguro(s3) + " (Esperado: false)");
        System.out.println("61x10x10 (arista 61)    -> " + CotizadorEnvio.requiereSeguro(s4) + " (Esperado: true)");
        System.out.println("60x50x41 (suma 151)     -> " + CotizadorEnvio.requiereSeguro(s5) + " (Esperado: true)");
        System.out.println();
    }

    /**
     * Metodo auxiliar para imprimir en consola los datos basicos de un paquete.
     * Utiliza los metodos de acceso (getters) implementados en la clase Paquete.
     *
     * @param p Paquete a imprimir.
     */
    private static void mostrarDetallePaquete(Paquete p) {
        if (!CotizadorEnvio.esPaqueteValido(p)) {
            System.out.println("  [Paquete no valido o no instanciado]");
            return;
        }
        System.out.println("  Codigo: " + p.getCodigoRastreo());
        System.out.println("  Peso fisico: " + p.getPeso() + " kg");
        System.out.println("  Dimensiones (largo x ancho x alto): "
                + p.getLargo() + " x " + p.getAncho() + " x " + p.getAlto() + " cm");
        System.out.println("  Valor declarado: $" + p.getValorDeclarado());
    }
}
