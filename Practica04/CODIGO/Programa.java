	/*
	* En estas primeras dos líneas se coloca el public class porque estamos
	* iniciando el código y esto nos indica el nombre que debe llevar el archivo y
	* debe ser igual a la hora de colocarlo en la terminal ya que si no no compilaria
	* después la siguiente línea que abarca varias cosas, no esque esten colocadas
	+ asi porque si, si no que esa es la estructura que debe tener el código 
	* para que se pueda leer bien y se compile bien
	*/
public class Programa{	
	/*
	* Agregando tambien aqui que las llaves estan siendo ocupadas porque asi le
	* damos el funcionamiento que en este public va a contener tales cosas
	* y por eso se colocan esas llaves al fina de cada una de las líneas
	*/
	public static void main(String[] args) {
	
	/*
	* En esta primera sección estamos asignando variables para
	* ocuparlas más adelante, en esta primera línea agregamos
	* la variable String lo que indica que vamos a tener una
	* secuencia de caracteres
	*/
	String producto = "Laptop para la carrera";
	// int nos indica que vamos agregar un dato númerico
	int precio = 15000;
	int descuento = 3000;
	// double nos indica que vamos agregar un valor númerico pero en decimal
	double meses = 18.0;

	/*
	* Esta siguiente sección de system.out.println es para que en la terminal aparezca
	* nuestros datos y como queremos que se represente y se escriba cuando lo compilemos
	* Para empezar se coloca un titulo más como presentación
	*/
	System.out.println("=== Ficha de compra ===");
	/* 
	* Es importante colocar comillas a la hora de escribir porque si no
	* java lo detectaria como otra cosa y no como tal nuestro mensaje
	* que estamos escribiendo, tambien hay que poner los parentesis ya que
	* estos nos ayudan a delimitar que se va a realizar en ese print
	*/ 
	System.out.println("- Producto : " + producto);	
	System.out.println("- Precio con descuento : " + (precio - descuento));
	System.out.println("- Plazo de pago en anios : " + (meses / 12.0));
	/*
	* Indicamos con los parentesis que tanto va abarcar una operación
	* o si queremos una operación en concreto se colocan los parentesis
	* para determinar que primero necesitamos que se haga esa operación
	* y ya luego se realice lo demas
	*/ 
	System.out.println("- Pago mensual : " + ((precio - descuento) / meses));
	System.out.println("=== Fin de la ficha ===");
	/* 
	* Ya para finalizar es importanten que para
	* cada indicación se coloca el punto y coma al final
	* eso indica que hasta ahi termina la indicación que le estamos dando
	*/
	}
}