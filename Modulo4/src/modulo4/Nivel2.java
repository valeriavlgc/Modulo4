package modulo4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Nivel2 {

	public static void main(String[] args) {
		
System.out.println("*****Nivel 2*****");

String[] platos = new String[10];
int[] precios = new int[10];
ArrayList<String> comanda = new ArrayList<String>();



mostrarMenu(platos,precios);
comanda = menuPedir(platos);	
int cuenta = buscarCoincidencia(comanda, platos, precios); 
calculoCuenta(cuenta);


	}
	
public static void mostrarMenu(String[] platos, int[] precios) {

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
	int i = 0;
		for(Map.Entry<String,Integer> entrada : menu.entrySet()) {
			platos[i] = entrada.getKey();
			precios[i] = entrada.getValue();		
			System.out.println((i+1) + ".- " + platos[i] + "........." + precios[i]+ "€" );		
			i++; 
		}	
}	
public static ArrayList<String> menuPedir(String[] platos)  {
Scanner sc = new Scanner(System.in);	
int opcion;	
int respuesta = 3;
ArrayList<String> comanda = new ArrayList<String>();
	
	do {
		System.out.println("Introduzca el número del plato que quiera pedir");
		opcion = sc.nextInt();
		sc.nextLine();
		
		//Comprobación de que el plato existe.
		try {
			 comanda.add(platos[opcion - 1]);
		}	
	    catch (ArrayIndexOutOfBoundsException e){
			System.out.println("El producto que ha introducido no existe.");
		}
		
        //Excepción manejada para evita que el programa se caiga cuando se introduce un tipo de dato erróneo.  
		do {
	
		 try {
	   		System.out.println("¿Quiere continuar pidiendo? 1 -> Si/ 0 -> No");
		    respuesta = sc.nextInt();		    		
		 } catch (InputMismatchException e) {
		    System.out.println("Ha introducido mal la respuesta.");	
		    //reseteo el valor de la respuesta porque en el nextInt no me captura otro tipo de dato erróneo y quedará almacenado
		    //en respuesta el valor de la vuelta anterior. 
		    respuesta = 3;
			//Si no vuelvo a poner el Scanner no coge la información del try. 
			sc = new Scanner(System.in);
		 }	
		
		} while (respuesta != 1 && respuesta != 0);
		
	} while (respuesta == 1);	
	
	 return comanda;
}
public static int buscarCoincidencia(ArrayList<String> comanda, String[] platos, int[] precios) {
int contador = 0, j = 0, cuenta = 0, i;

System.out.println("Usted ha pedido: ");

	for (i = 0; i < comanda.size(); i++) {
				
		while (j < platos.length && contador == 0) {
			if (comanda.get(i).equals(platos[j])) {
				  cuenta += precios[j];	
				  contador += 1;
				  System.out.print(platos[j] + ". ");
				}
			j++;
		}
			
		if(contador != 1) {
			System.out.println("El plato no existe.");
		}

		contador = 0;
		j = 0;
		
	}	
	
	
	
     return cuenta;	
}
public static void calculoCuenta(int cuenta) {
	
System.out.print("\nEl precio total a pagar es " + cuenta + "€.");

int[] dinero = {500,200,100,50,20,10,5,2,1};
int auxiliarDinero; //variable para guardar el billete o moneda que es antes de modificarlo.

System.out.println(" Deberá pagar con: ");

	for(int i = 0; i < dinero.length; i++) {
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


