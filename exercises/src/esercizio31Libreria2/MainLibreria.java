package esercizio31Libreria2;

import java.util.Scanner;

public class MainLibreria {

	public static void main(String[] args) {
		Scanner userIn = new Scanner(System.in);
		
		LibreriaSystem libreria = new LibreriaSystem(userIn);
		Boolean check = true;
		int ind;
		while (check) {
			ind = libreria.readInt(("Operazioni disponibili: " + "\n" + "1 - Aggiungi un nuovo libro" + "\n"
					+ "2 - Modifica dati di un libro" + "\n" + "3 - Visualizza tutti i libri" + "\n"
					+ "4 - Cerca un libro" + "\n" + "5 - Elimina un libro" + "\n" + "0 - uscire"));
			switch (ind) {
			case 1:
				libreria.addBook();
				break;

			case 2:
				libreria.modifyData();
				break;

			case 3:
				libreria.viewBook();
				break;

			case 4:
				libreria.searchBook();
				break;

			case 5:
				libreria.deleteBook();
				break;

			case 0:
				check = false;
				break;
			}
			System.out.println("");
			System.out.println("");
		}

	}

}
