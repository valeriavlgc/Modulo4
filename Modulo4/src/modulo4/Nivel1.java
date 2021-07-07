package modulo4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Nivel1 {

	public static void main(String[] args) {

fase1();
fase2();
fase3(); 


	}

public static void fase1(){
	String[] platos = new String[10];
	int[] precios = new int[10];
	int cuenta;	
	int billete5 = 5, billete10 = 10, billete20 = 20, billete50 = 50, billete100 = 100, billete200 = 200, billete500 = 500;
	double moneda10= 0.1, moneda20 = 0.2, moneda50 = 0.5, moneda1 = 1, moneda2 = 2;
	System.out.println("*****Fase 1 completada*****");
}	

public static void fase2() {
System.out.println("*****Fase 2*****");

Scanner sc = new Scanner(System.in);	

String[] platos = new String[10];
int[] precios = new int[10];
int opcion, continuacion = 2;	
String respuesta;
ArrayList<String> comanda = new ArrayList<String>();

//HashMap con menú
HashMap<String,Integer> menu = new HashMap<String,Integer>();

menu.put("Huevos rotos con jamón",14);
menu.put("Hamburguesa con patatas",8);
menu.put("Gazpacho",10);
menu.put("Crema de calabaza",7);
menu.put("Arroz negro",15);
menu.put("Paella",11);
menu.put("Revuelto de ajetes y gambas",9);
menu.put("Cocido montañés",10);
menu.put("Costilla",12);
menu.put("Parrillada de verduras",10);


int i = 0;

//Bucle for para rellenar arrays a partir del Hashmap y mostrar en pantalla el menú a la vez.
//Conseguir que aparezcan los precios a la misma altura. 
		for(Map.Entry<String,Integer> entrada : menu.entrySet()) {
			platos[i] = entrada.getKey();
			precios[i] = entrada.getValue();		
			System.out.println((i+1) + ".- " + platos[i] + "........." + precios[i]+ "€" );		
			i++; 
		}

//Bucle para pedir platos hasta que el cliente decida parar.		
	do {
		System.out.println("Introduzca el número del plato que quiera pedir");
		opcion = sc.nextInt();
		sc.nextLine();
		comanda.add(platos[opcion - 1]);
				
		System.out.println("¿Quiere continuar pidiendo? S/N");
		respuesta = sc.nextLine();
	
			if (respuesta.charAt(0) == ('S') || respuesta.charAt(0) == ('s')) {
				continuacion = 1;	
			} else if (respuesta.charAt(0) == ('N') || respuesta.charAt(0) == ('n')) {
				continuacion = 0;
		    }    
	 } while (continuacion == 1);
		
}

public static void fase3() {
System.out.println("*****Fase 3*****");

Scanner sc = new Scanner(System.in);	
int opcion, continuacion = 2, i = 0;
int cuenta = 0;	
String respuesta;

String[] platos = new String[10];
int[] precios = new int[10];

ArrayList<String> comanda = new ArrayList<String>();
//HashMap con platos del menú.
HashMap<String,Integer> menu = new HashMap<String,Integer>();

menu.put("Huevos rotos con jamón",14);
menu.put("Hamburguesa con patatas",8);
menu.put("Gazpacho",10);
menu.put("Crema de calabaza",7);
menu.put("Arroz negro",15);
menu.put("Paella",11);
menu.put("Revuelto de ajetes y gambas",9);
menu.put("Cocido montañés",10);
menu.put("Costilla",12);
menu.put("Parrillada de verduras",10);

//Bucle for para rellenar arrays a partir del Hashmap y mostrar en pantalla el menú a la vez.
	for(Map.Entry<String,Integer> entrada : menu.entrySet()) {
		platos[i] = entrada.getKey();
		precios[i] = entrada.getValue();		
		System.out.println((i+1) + ".- " + platos[i] + "........." + precios[i]+ "€" );		
		i++; 
	}

//Bucle para pedir platos hasta que el cliente decida parar.	
	do {
		System.out.println("Introduzca el número del plato que quiera pedir");
		opcion = sc.nextInt();
		sc.nextLine();
		
		//try {
		comanda.add(platos[opcion - 1]);
			
			/*} catch (Exception e){
				System.out.println("El producto que ha introducido no existe.");
			}*/
	
		System.out.println("¿Quiere continuar pidiendo? S/N");
		respuesta = sc.nextLine();
		
			if (respuesta.charAt(0) == ('S') || respuesta.charAt(0) == ('s')) {
				continuacion = 1;	
			} else if (respuesta.charAt(0) == ('N') || respuesta.charAt(0) == ('n')) {
				continuacion = 0;
			  }    
		
	} while (continuacion == 1);

	
int contador = 0, j = 0;
//Bucle anidado para buscar coincidencia entre cada plato que se ha pedido entre los elementos del array de platos inicial 
	for (i = 0; i < comanda.size(); i++) {
		
		while (j < platos.length && contador == 0) {
			if (comanda.get(i).equals(platos[j])) {
				  cuenta += precios[j];	
				  contador += 1;
				}
			j++;
		}
			
		if(contador != 1) {
			System.out.println("El plato no existe.");
		}

		contador = 0;
		
	}

System.out.println("El precio total a pagar es " + (int)cuenta + " €.");

//Calculo de billetes y monedas con los que pagar.
int[] dinero = {500,200,100,50,20,10,5,2,1};
int auxiliarDinero; //variable para guardar el billete o moneda que es antes de modificarlo.

System.out.println("Deberá pagar con: ");

	for(i = 0; i < dinero.length; i++) {
		auxiliarDinero = dinero[i];
		dinero[i] = cuenta/dinero[i];
		
		if (auxiliarDinero > 2) {
		
			if(dinero[i] >= 1 ) {
				System.out.println(dinero[i] + " billete/s de " + auxiliarDinero + "€.");
			 }
			
	    } else {
			
			if((int)(dinero[i]) >= 1 ) {
				System.out.println(dinero[i] + " moneda/s de " + auxiliarDinero + "€.");
			 }
		 }
		
		cuenta = cuenta%auxiliarDinero;
		
	}

}

}




