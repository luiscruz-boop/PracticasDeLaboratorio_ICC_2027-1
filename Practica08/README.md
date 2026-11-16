# Práctica 8 (Mini-Lab): La Clase Punto
**Introducción a las Ciencias de la Computación (Semestre 2027-1)**  
**Facultad de Ciencias, UNAM**

---

## Datos del alumno

- **Nombre completo:** [Cruz Hernandez Luis Angel]
- **Número de cuenta:** [121003056]
- **Correo institucional:** [luisangelcruz@ciencias.unam.mx]

---

## Descripción de la práctica

> Se construyo una clase de un punto en el plano cartesiano bidimensional (2D) para representar a X y Y, Para proteger los datos, los atributos se hicieron privados (private) y se crearon sus getters y setters. Además, se hicieron dos constructores usando this (uno vacío que lo pone en el origen (0,0) y otro que recibe coordenadas iniciales). Además se programaron los cálculos correspondientes para hacer el punto: moverse de lugar (desplazar), medir qué tan lejos está de otro (distancia), encontrar la mitad entre dos puntos (puntoMedio), saber en qué zona del plano está (cuadrante) y revisar si tres puntos forman una línea recta (estanAlineados). Por último ya solo se tuvo que adaptar dos métodos de JAVA que fueron: toString() para poder imprimir el punto bonito como "(x, y)" y equals() para poder comparar si dos puntos están en el mismo lugar. También se cuidó que el programa no tronara si le pasaban valores vacíos (null) y se usó un margen de tolerancia para evitar errores con decimales (double). 

---

## Comandos para compilar, ejecutar y documentar

Ejecuta los siguientes comandos desde la terminal ubicado en la raíz de esta carpeta:

### 1. Compilación
```bash
<javac -d bin src/*.java>
```

### 2. Ejecución de la verificación
```bash
<java -cp bin PruebaPunto>
```

### 3. Generación de documentación Javadoc
```bash
<javadoc -d doc -author -version src/Punto.java>
```

---

## Evidencia de ejecución

Copia y pega aquí el resumen final que mostró tu terminal al ejecutar `PruebaPunto`:

```text
[================================================================================
  ICC 2027-1 | VERIFICACION AUTOMATIZADA: CLASE PUNTO (MINI-LAB 8)
================================================================================

>>> 1. PROBANDO CONSTRUCTORES Y GETTERS:
  [OK] Constructor por omision inicializa en (0.0, 0.0)
  [OK] Constructor con parametros inicializa en (3.0, 4.0)

>>> 2. PROBANDO SETTERS:
  [OK] Setters modifican correctamente las coordenadas

>>> 3. PROBANDO METODO DESPLAZAR:
  [OK] desplazar(1.5, -1.0) actualiza a (3.5, 2.0)

>>> 4. PROBANDO DISTANCIA EUCLIDIANA:
  [OK] Distancia de (0.0, 0.0) a (3.0, 4.0) es 5.0
  [OK] Distancia de (1.0, 2.0) a (4.0, 6.0) es 5.0
  [OK] Distancia con referencia null regresa -1.0

>>> 5. PROBANDO PUNTO MEDIO (OBJETO RETORNADO):
  [OK] Punto medio entre (1.0, 2.0) y (4.0, 6.0) es (2.5, 4.0)
  [OK] Punto medio con null regresa null

>>> 6. PROBANDO DETERMINACION DE CUADRANTES:
  [OK] Cuadrante de (5.0, 8.0) es I
  [OK] Cuadrante de (-3.0, 4.0) es II
  [OK] Cuadrante de (-2.0, -7.0) es III
  [OK] Cuadrante de (6.0, -1.0) es IV
  [OK] Cuadrante de (0.0, 5.0) en eje es 0
  [OK] Cuadrante del origen (0.0, 0.0) es 0

>>> 7. PROBANDO METODO toString():
  [OK] toString() de (3.0, 4.0) devuelve "(3.0, 4.0)"

>>> 8. PROBANDO METODO EQUALS (IDENTIDAD VS CONTENIDO):
  [OK] p1.equals(new Punto(3.0, 4.0)) retorna true
  [OK] p1.equals(new Punto(3.0, 4.1)) retorna false
  [OK] p1.equals(null) retorna false de forma segura

>>> 9. PROBANDO COLINEALIDAD (RETO: TRES PUNTOS EN UNA RECTA):
  [OK] (1,1), (2,2) y (5,5) estan alineados
  [OK] (1,1), (2,2) y (5,6) NO estan alineados

================================================================================
  RESUMEN DE PRUEBAS: 21 / 21 pruebas superadas con exito.
  ¡FELICIDADES! Todos los metodos de la clase Punto funcionan correctamente.
================================================================================]
```

---

## Preguntas de reflexión (1.0 punto)

1. **¿Por qué el método `puntoMedio` crea y regresa un nuevo objeto `Punto`, mientras que `desplazar` modifica al mismo objeto que recibe el mensaje?**
   > [Porque desplazar sirve para mover el mismo punto que llama al método, cambiando directamente sus coordenadas x y y. En cambio, puntoMedio solo calcula la mitad entre dos puntos sin mover ninguno de los originales, por lo que necesita crear (new) y devolver un tercer objeto Punto con ese resultado.]

2. **Al ejecutar `p1.distancia(p2)`, ¿a qué objeto en memoria hace referencia `this` y cómo accede el método a las coordenadas de `p2`?**
   > [this hace referencia al objeto p1, que es el que recibe la llamada al método y del cual tomamos sus atributos directamente (this.x y this.y). Por otro lado, p2 llega como parámetro (otroPunto) y accedemos a sus coordenadas mediante sus métodos públicos getX() y getY() para respetar el encapsulamiento.]

3. **Observa el archivo `PruebaPunto.java`: ¿por qué los atributos `pruebasExitosas`, `totalPruebas` y el método `verificar` están declarados como `static`? ¿Qué ocurriría si les quitáramos la palabra `static` y los llamáremos desde `main`? Menciona además dos métodos estáticos de las bibliotecas estándar de Java que utilizaste en `Punto.java`.**
   > [Son static porque pertenecen a la clase PruebaPunto y no a un objeto en particular, lo que permite usarlos sin tener que hacer new PruebaPunto(). Si les quitáramos static, el código marcaría un error de compilación porque main es un método estático y no puede llamar directamente a variables o métodos que dependan de una instancia. Dos métodos estáticos que ocupé en Punto.java son Math.sqrt() y Math.abs().]
