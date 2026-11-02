# Práctica 6 --- Entrada de datos y cierre de la Cabaña del Misterio

Introducción a Ciencias de la Computación, Facultad de Ciencias, UNAM.

Este proyecto contiene tres programas:

- **PiInteractivo**: Aproxima el valor de pi con el método Monte Carlo lanzando
  dardos; el usuario elige cuántos (Actividad 1.1). Rechaza texto, decimales,
  números demasiado grandes, cero y negativos.
- **BinarioInteractivo**: Convierte a binario un número entero no negativo que
  elige el usuario y pregunta si quiere convertir otro (Actividad 1.2).
- **CabanaDelMisterio**: Programa final del señor Pines. Pide y valida los datos
  del cliente y ofrece un menú con cinco opciones (interés simple, interés
  compuesto, comparar ambos, cambiar el capital y salir). Termina al elegir la
  opción 0, al completar 5 operaciones efectivas o al cometer 3 errores en el
  menú (Parte 2 completa).

## Estructura

```
Practica06/
|-- Readme.md (este documento)
|-- src/    código fuente (.java)
|-- bin/    archivos compilados (.class)
|-- docs/   reporte en pdf
    |-- images/   capturas de pantalla de las ejecuciones
```

## Cómo compilar y ejecutar

Desde la carpeta `Practica06`:

```
javac -d bin src/*.java
```
Para compilar todos los archivos en `src/` y guardar el resultado en `bin/`.

```
java -cp bin PiInteractivo
java -cp bin BinarioInteractivo
java -cp bin CabanaDelMisterio
```
Para ejecutar el *bytecode* de la clase elegida.

**Nota:** en todas las ejecuciones se escribe un solo dato por renglón y se
presiona Enter después de cada uno.

## Ejemplos de ejecución

**PiInteractivo** (primero una entrada inválida y luego una válida)
```
Cuantos dardos quieres lanzar? hola
Error: eso no es un numero entero valido (sin decimales, sin letras y que no sea demasiado grande).
Cuantos dardos quieres lanzar? 1000000
Dardos lanzados: 1000000
Dardos dentro del círculo: 785344
Aproximación de Pi: 3.141376
```
*(Los valores cambian en cada ejecución porque los dardos son aleatorios.)*

**BinarioInteractivo**
```
Escribe un numero entero (0 o mayor): 26
El numero 26 en binario es: 11010
Quieres convertir otro numero? (s/n): n
Hasta luego!
```

**CabanaDelMisterio** (Robbie, opción 1 y salir con la opción 0)
```
Nombre completo del cliente: Robbie Valentino
Tipo de cliente (P = preferente, E = estandar, R = riesgoso): E
Capital del prestamo: 12899
Tasa anual base (en %): 15
Plazo en meses: 21

##### Sistema de prestamos de la Cabaña del misterio #####
> Las operaciones disponibles son
1) Cotizar con interes simple.
2) Cotizar con interes compuesto.
3) Comparar interes simple y compuesto.
4) Cambiar el capital del prestamo.
0) Salir.
> Por favor, elige una opción: 1

### Opción 1 : Cotización de interés simple ###

- Nombre : Robbie Valentino
- Tipo de cliente : Estándar
- Capital del préstamo : 12899.00
- Tasa anual : 15.00
- Plazo en meses : 21

> Interés simple = 3385.99
> Total a pagar = 16284.99
> Mensualidad = 775.48

(el menú vuelve a aparecer)
> Por favor, elige una opción: 0

===== Resumen =====
Cliente: Robbie Valentino
Operaciones efectivas: 1
Errores en el menú: 0
Capital final del préstamo: 12899.00
Motivo de término: El usuario eligió salir
```

## Algunos valores que verifican que el programa esta bien

Con los datos de Robbie (Robbie Valentino, tipo E, capital $12,899, tasa 15 %,
plazo 21 meses) en `CabanaDelMisterio`:

| Dato | Valor esperado |
| ------------- | ------------- |
| Tasa aplicada | 15 % |
| Interés simple | $3385.99 |
| Total con interés simple | $16284.99 |
| Interés compuesto | $3844.71 |
| Total con interés compuesto | $16743.71 |
| Diferencia entre intereses | $458.72 (el compuesto es mayor) |

Si con la opción 4 se cambia el capital a $18,499:

| Dato | Valor esperado |
| ------------- | ------------- |
| Interés simple | $4855.99 |
| Total con interés simple | $23354.99 |
| Interés compuesto | $5513.86 |
| Total con interés compuesto | $24012.86 |
| Diferencia entre intereses | $657.87 |
