import java.util.Scanner;

/**
 * Programa final para la Cabana del Misterio del Senor Pines.
 *
 * Ahora los datos los escribe el usuario
 * y todo se valida. Estructura del programa:
 *   1. Registro del cliente: cada dato se pide en un ciclo hasta que sea valido.
 *   2. Calculo de la tasa aplicada segun el tipo de cliente.
 *   3. Menu con limite de 5 operaciones efectivas y 3 errores de menu.
 *   4. Resumen final, sin importar por que termino el programa.
 */
public class CabanaDelMisterio {
    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        // Limites del menu (variables normales, no cambian durante el programa).
        int maxOperaciones = 8;
        int maxErrores = 3;

        // == 1. REGISTRO DEL CLIENTE ==
        // Patron de cada dato: pedir -> validar tipo -> validar sentido -> repetir si falla.

        String nombreCliente = "";
        char tipoCliente = ' ';
        double capital = 0.0;
        double tasaAnual = 0.0;
        int plazoMeses = 0;
        boolean datoValido = false; // se reutiliza como bandera en cada ciclo

        // El nombre va primero: asi no queda ningun Enter pendiente que
        // nextLine() pudiera leer como si fuera un nombre vacio.
        // Se repite mientras el nombre este vacio.
        while (nombreCliente.equals("")) {
            System.out.print("Nombre completo del cliente: ");
            nombreCliente = sc.nextLine();
            if (nombreCliente.equals("")) {
                System.out.println("Error: el nombre no puede estar vacio.");
            }
        }

        // Tipo de cliente: next().charAt(0) toma la primera letra de lo que
        // escriba el usuario; nextLine() limpia el resto del renglon.
        // Solo se acepta P, E o R (mayuscula).
        while (!datoValido) {
            System.out.print("Tipo de cliente (P = preferente, E = estandar, R = riesgoso): ");
            tipoCliente = sc.next().charAt(0);
            sc.nextLine();
            if (tipoCliente == 'P' || tipoCliente == 'E' || tipoCliente == 'R') {
                datoValido = true;
            } else {
                System.out.println("Error: el tipo de cliente debe ser 'P', 'E' o 'R'.");
            }
        }

        // Capital: debe ser un numero (hasNextDouble) y mayor que cero.
        datoValido = false;
        while (!datoValido) {
            System.out.print("Capital del prestamo: ");
            if (sc.hasNextDouble()) {
                capital = sc.nextDouble();
                sc.nextLine(); // limpia el Enter pendiente
                if (capital > 0) {
                    datoValido = true;
                } else {
                    System.out.println("Error: el capital debe ser mayor que 0.");
                }
            } else {
                sc.nextLine(); // descarta el texto invalido
                System.out.println("Error: el capital debe ser un numero.");
            }
        }

        // Tasa anual base: numero, no negativo (una tasa de 0 si es posible).
        datoValido = false;
        while (!datoValido) {
            System.out.print("Tasa anual base (en %): ");
            if (sc.hasNextDouble()) {
                tasaAnual = sc.nextDouble();
                sc.nextLine();
                if (tasaAnual >= 0) {
                    datoValido = true;
                } else {
                    System.out.println("Error: la tasa anual no puede ser negativa.");
                }
            } else {
                sc.nextLine();
                System.out.println("Error: la tasa anual debe ser un numero.");
            }
        }

        // Plazo: entero de meses (hasNextInt rechaza 8.5) y mayor que cero.
        datoValido = false;
        while (!datoValido) {
            System.out.print("Plazo en meses: ");
            if (sc.hasNextInt()) {
                plazoMeses = sc.nextInt();
                sc.nextLine();
                if (plazoMeses > 0) {
                    datoValido = true;
                } else {
                    System.out.println("Error: el plazo debe ser de al menos 1 mes.");
                }
            } else {
                sc.nextLine();
                System.out.println("Error: el plazo debe ser un numero entero de meses.");
            }
        }

        // == 2. TASA APLICADA ==
        // Igual que en la Practica 5: preferente -2 puntos, estandar igual,
        // riesgoso +3 puntos. Tambien se guarda el nombre legible del tipo.
        double tasaAplicada = 0.0;
        String nombreTipo = "";

        if (tipoCliente == 'P') {
            tasaAplicada = tasaAnual - 2;
            nombreTipo = "Preferente";
        } else if (tipoCliente == 'E') {
            tasaAplicada = tasaAnual;
            nombreTipo = "Estándar";
        } else {
            tasaAplicada = tasaAnual + 3;
            nombreTipo = "Riesgoso";
        }

        // Si el descuento de un cliente preferente dejara la tasa negativa
        // (por ejemplo, tasa base de 1%), se usa 0: no tiene sentido una tasa < 0.
        if (tasaAplicada < 0) {
            tasaAplicada = 0;
        }

        // == 3. MENU ==
        int operaciones = 0;      // operaciones efectivas realizadas (opciones 1 a 4)
        int errores = 0;          // opciones invalidas en el menu (no cuentan los reintentos del registro)
        boolean continuar = true; // el menu se repite mientras sea true
        String motivo = "";       // por que termino, para el resumen

        while (continuar) {
            System.out.println();
            System.out.println("##### Sistema de prestamos de la Cabaña del Misterio #####");
            System.out.println("> Las operaciones disponibles son");
            System.out.println("1) Cotizar con interes simple.");
            System.out.println("2) Cotizar con interes compuesto.");
            System.out.println("3) Comparar interes simple y compuesto.");
            System.out.println("4) Cambiar el capital del prestamo.");
            System.out.println("0) Salir.");
            System.out.print("> Por favor, elige una opción: ");

            // -1 significa "no hay opcion valida": si el usuario escribe algo que
            // no es entero, la opcion se queda en -1 y cae en la rama de error.
            int opcion = -1;
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
            }
            sc.nextLine(); // siempre se limpia el renglon (tambien si habia texto)

            if (opcion < 0 || opcion > 4) {
                // -- Opcion invalida: cuenta como error --
                errores++;
                System.out.println("Opción no válida. Errores en el menú: " + errores + " de " + maxErrores);
                if (errores == maxErrores) {
                    System.out.println("Se alcanzó el límite de errores.");
                    motivo = "Límite de errores en el menú";
                    continuar = false;
                }
            } else if (opcion == 0) {
                // -- Salir: no cuenta como operacion --
                motivo = "El usuario eligió salir";
                continuar = false;
            } else {
                // -- Opciones 1 a 4: operacion efectiva --

                // Los calculos van aqui para usar siempre el
                // capital actual, que la opcion 4 puede haber cambiado.

                // Interes simple: capital * tasa * anios
                double plazoAnios = plazoMeses / 12.0;
                double interes = capital * (tasaAplicada / 100) * plazoAnios;
                double totalApagar = capital + interes;
                double mensualidad = totalApagar / plazoMeses;

                // Datos del cliente que se muestran en las cotizaciones 1 y 2.
                if (opcion == 1 || opcion == 2) {
                    System.out.println();
                    if (opcion == 1) {
                        System.out.println("### Opción 1 : Cotización de interés simple ###");
                    } else {
                        System.out.println("### Opción 2 : Cotización de interés compuesto ###");
                    }
                    System.out.println();
                    System.out.println("- Nombre : " + nombreCliente);
                    System.out.println("- Tipo de cliente : " + nombreTipo);
                    System.out.printf("- Capital del préstamo : %.2f%n", capital);
                    System.out.printf("- Tasa anual : %.2f%n", tasaAplicada);
                    System.out.println("- Plazo en meses : " + plazoMeses);
                    System.out.println();
                }

                if (opcion == 1) {
                    // Cotizacion con interes simple.
                    System.out.printf("> Interés simple = %.2f%n", interes);
                    System.out.printf("> Total a pagar = %.2f%n", totalApagar);
                    System.out.printf("> Mensualidad = %.2f%n", mensualidad);

                } else if (opcion == 2 || opcion == 3) {
                    // Interes compuesto: cada mes el saldo crece
                    // tasaMensual sobre el saldo del mes anterior. Las opciones 2 y 3
                    // lo necesitan; solo la 2 imprime el detalle mes por mes.
                    double tasaMensual = tasaAplicada / 100 / 12;
                    double saldo = capital;

                    for (int mes = 1; mes <= plazoMeses; mes++) {
                        saldo = saldo * (1 + tasaMensual);
                        if (opcion == 2) {
                            System.out.printf("> Mes %d = %.2f%n", mes, saldo);
                        }
                    }

                    double totalCompuesto = saldo;
                    double interesCompuesto = totalCompuesto - capital; // lo ganado, sin el capital

                    if (opcion == 2) {
                        // El total tambien se comprueba con la formula directa (Math.pow).
                        double totalFormula = capital * Math.pow(1 + tasaMensual, plazoMeses);

                        System.out.println();
                        System.out.printf("> Interés compuesto = %.2f%n", interesCompuesto);
                        System.out.printf("> Total a pagar = %.2f%n", totalCompuesto);
                        System.out.printf("> Total con la fórmula (Math.pow) = %.2f%n", totalFormula);
                    } else {
                        // Opcion 3: comparar ambos intereses.
                        System.out.println();
                        System.out.println("### Opción 3 : Comparación de intereses ###");
                        System.out.println();
                        System.out.printf("> Interés simple = %.2f%n", interes);
                        System.out.printf("> Interés compuesto = %.2f%n", interesCompuesto);
                        double diferencia = Math.abs(interesCompuesto - interes);
                        System.out.printf("> La diferencia entre ellos es de %.2f%n", diferencia);
                        if (interesCompuesto > interes) {
                            System.out.println("> El interés compuesto es mayor.");
                        } else if (interes > interesCompuesto) {
                            System.out.println("> El interés simple es mayor.");
                        } else {
                            System.out.println("> Ambos intereses son iguales.");
                        }
                    }

                } else {
                    // Opcion 4: cambiar el capital, con la misma validacion del registro.
                    // Los reintentos de este ciclo no suman al contador de errores del menu.
                    datoValido = false;
                    while (!datoValido) {
                        System.out.print("Nuevo capital del préstamo: ");
                        if (sc.hasNextDouble()) {
                            capital = sc.nextDouble();
                            sc.nextLine();
                            if (capital > 0) {
                                datoValido = true;
                            } else {
                                System.out.println("Error: el capital debe ser mayor que 0.");
                            }
                        } else {
                            sc.nextLine();
                            System.out.println("Error: el capital debe ser un numero.");
                        }
                    }
                    System.out.printf("Capital actualizado a %.2f%n", capital);
                }

                // La operacion se realizo, asi que cuenta como efectiva.
                // Se revisa el limite despues de mostrar el resultado.
                operaciones++;
                if (operaciones == maxOperaciones) {
                    System.out.println();
                    System.out.println("Se alcanzó el límite de operaciones.");
                    motivo = "Límite de operaciones";
                    continuar = false;
                }
            }
        }

        // == 4. RESUMEN FINAL ==
        // Se llega aqui por cualquiera de los tres motivos de termino.
        System.out.println();
        System.out.println("===== Resumen =====");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Operaciones efectivas: " + operaciones);
        System.out.println("Errores en el menú: " + errores);
        System.out.printf("Capital final del préstamo: %.2f%n", capital);
        System.out.println("Motivo de término: " + motivo);
        System.out.println("Gracias por visitar la Cabaña del Misterio. ¡Adiós!");
    }
}