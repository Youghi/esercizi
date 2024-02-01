package esercizio100Negozio;

import java.util.Scanner;

public class MainNegozio {

	public static void main(String[] args) {
		Scanner userIn = new Scanner(System.in);
		NegozioManager negozio = new NegozioManager(userIn);
		
switch (negozio.readInt("1 - Utente" + "\n" + "2 - Admin" + "\n" + "0 - Uscire")) {
case 1:
	String name = negozio.readString("Inserire Email:");
	String passwordClient = negozio.readString("Inserire password:");
//	negozio.clientManager.clientAuth(name, passwordClient);
	break;
	
case 2:
	int id = negozio.readInt("Inserire Codice ID:");
	String passwordAdmin = negozio.readString("Inserire password:");
//	negozio.adminManager.adminAuth(id, passwordAdmin);
	break;
	
case 0:
	
	break;

default:
	break;
}
		
	}

}
