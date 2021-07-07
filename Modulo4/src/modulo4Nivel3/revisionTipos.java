package modulo4Nivel3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class revisionTipos extends Exception {
	public revisionTipos() {}
	public revisionTipos(String mensaje) {
		super(mensaje);
	}

public static int getIntException() throws revisionTipos {
	    Scanner sc = new Scanner(System.in);
	    try {
	       return sc.nextInt();
	    } catch(InputMismatchException e) {
	        throw new revisionTipos();
	    }
}
}

