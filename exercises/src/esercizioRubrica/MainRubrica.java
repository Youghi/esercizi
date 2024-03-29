package esercizioRubrica;

import java.util.Scanner;

public class MainRubrica {

	public static void main(String[] args) {
		Scanner userIn = new Scanner(System.in);
		LogicManager logic = new LogicManager(userIn);
		Boolean check = true;

		check = true;
		while (check) {
			int ind = logic.readInt(("Operazioni disponibili: " + "\n" + "1 - Cerca un contatto" + "\n"
					+ "2 - Visualizza tutti i contatti" + "\n" + "3 - Modifica i dati di un contatto" + "\n"
					+ "4 - Aggiungi un nuovo contatto" + "\n" + "5 - Elimina un contatto" + "\n" + "0 - uscire"));
			switch (ind) {
			case 1:
				logic.searchRecord();
				break;

			case 2:
				logic.dbManager.viewAllRecords();
				break;

			case 3:
				logic.modifyRecord();
				break;

			case 4:
				logic.addRecord();
				break;

			case 5:
				logic.deleteRecord();
				break;

			case 0:
				check = false;
			}
		}

	}

}
