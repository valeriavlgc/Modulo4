package modulo4Nivel3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RevisionTipos extends Exception {
	public RevisionTipos() {}
	public RevisionTipos(String mensaje) {
		super(mensaje);
	}

public static int getIntException() throws RevisionTipos {
	    Scanner sc = new Scanner(System.in);
	    try {
	       return sc.nextInt();
	    } catch(InputMismatchException e) {
	        throw new RevisionTipos();
	    }
}
}