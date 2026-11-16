# Práctica 7: Introducción a la Programación Orientada a Objetos
**Introducción a las Ciencias de la Computación (Semestre 2027-1)**  
**Facultad de Ciencias, UNAM**

## Descripción del proyecto

Es un sistema para una empresa de entrega de paquetes. Se modeló un **paquete** como clase (`Paquete`), con su código de rastreo, peso físico (kg), dimensiones (cm) y valor declarado (pesos); sus atributos son privados y se protegen con constructores y setters que validan los datos. `Paquete` sabe calcular su peso volumétrico y su peso cobrable. Las reglas del negocio (validar un paquete, cotizar el envío con tarifa escalonada y decidir si requiere seguro) no guardan datos propios, así que viven en la clase de utilería `CotizadorEnvio`, con métodos `static`. Como propuesta personal se agregó el atributo `fragil` y el método `calcularCargoFragil()` (cargo de $50 + 2 % del valor declarado para paquetes frágiles). `PruebaPaqueteria` contiene los casos de prueba y casos borde.

Estructura de la carpeta:

```
Practica07/
├── README.md
├── src/   Paquete.java, CotizadorEnvio.java, PruebaPaqueteria.java
├── bin/   archivos .class
└── doc/   documentación HTML generada con javadoc
```

---

## Comandos para compilar, ejecutar y documentar

Comandos que se utilizan desde la terminal (ubicado en la raíz de tu carpeta de trabajo):

### 1. Compilación
```bash
javac -d bin src/*.java
```

### 2. Ejecución
```bash
java -cp bin PruebaPaqueteria
```

### 3. Generación de documentación Javadoc
```bash
javadoc -private -d doc -encoding UTF-8 src/*.java
```
