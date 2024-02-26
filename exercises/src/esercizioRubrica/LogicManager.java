package esercizioRubrica;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LogicManager {
	DBManager dbManager = new DBManager(this);
	private Scanner userIn;
	ArrayList<Records> records = new ArrayList<Records>();

	public LogicManager(Scanner userIn) {
		this.userIn = userIn;
		dbManager.init();
	}

	public void addRecord() {
		Records record = new Records(this);
		record.setData();
		dbManager.addNew(record);
	}

	public void modifyRecord() {
		switch (readString("Visualizzare lista contatti? (Y/N)").toUpperCase()) {
		case "Y":
			dbManager.viewAllRecords();
			break;
		case "N":
			break;
		}

		int id = readInt("Inserire id del contatto da modificare");
		dbManager.compileArray();
		try {
			records.get(searachPositionById(id)).modifyData();
		} catch (IllegalArgumentException e) {
			System.out.println("codice errato");
		}
		records.clear();
	}

	public void searchRecord() {
		dbManager.compileArray();
		if (records.size() != 0) {
			int ind = readInt(("Operazioni disponibili: " + "\n" + "1 - ricerca per id" + "\n" + "2 - ricerca per nome"
					+ "\n" + "3 - ricerca per cognome" + "\n" + "4 - ricerca per numero telefonico"));
			switch (ind) {
			case 1:
				int code = readInt("Inserire id del contatto da cercare:");
				System.out.println("Risultato ricerca per codice " + code + ":");
				try {
					records.get(searachPositionById(code)).getData();
				} catch (IllegalArgumentException e) {
					System.out.println("Non ci sono contatti con questo id");
				}
				break;

			case 2:
				String checkName = readLine("Inserire nome contatto da cercare:");
				System.out.println("Risultato ricerca per nome " + checkName + ":");
				Boolean check = true;
				for (int i = 0; i < records.size(); i++) {
					if (records.get(i).getName().equalsIgnoreCase(checkName)) {
						records.get(i).getData();
						System.out.println("");
						check = false;
					}
				}
				System.out.println(check == true ? "Non ci sono contatti con questo nome" : "");
				break;

			case 3:
				String checkSurname = readLine("Inserire cognome contatto da cercare:");
				System.out.println("Risultato ricerca per cognome " + checkSurname + ":");
				check = true;
				for (int i = 0; i < records.size(); i++) {
					if (records.get(i).getSurname().equalsIgnoreCase(checkSurname)) {
						records.get(i).getData();
						System.out.println("");
						check = false;
					}
				}
				System.out.println(check == true ? "Non ci sono contatti con questo cognome" : "");
				break;

			case 4:
				long checkNum = readLong("Inserire numero telefonico da cercare:");
				System.out.println("Risultato ricerca per cognome " + checkNum + ":");
				check = true;
				for (int i = 0; i < records.size(); i++) {
					if (records.get(i).getNum() == checkNum) {
						records.get(i).getData();
						System.out.println("");
						check = false;
					}
				}
				System.out.println(check == true ? "Non ci sono contatti con questo numero" : "");
				break;
			}
			System.out.println("");
			System.out.println("");
		}
		records.clear();
	}

	public void deleteRecord() {
		switch (readString("Visualizzare lista contatti? (Y/N)").toUpperCase()) {
		case "Y":
			dbManager.viewAllRecords();
			break;
		case "N":
			break;
		}
		int id = readInt("Inserire id del contatto da eliminare");
		dbManager.deleteById(id);
	}

	// metodo per trovare la posizione del mio record dato un id
	public int searachPositionById(int id) {
		int ind = 0;
		if (checkCode(id)) {
			for (int i = 0; i < records.size(); i++) {
				if (records.get(i).getId() == id) {
					ind = i;
				}
			}
		} else {
			throw new IllegalArgumentException("codice errato");
		}
		return ind;
	}

	// metodo che stabilische che id dato esiste
	public Boolean checkCode(int id) {
		Boolean check = false;
		for (Records record : records) {
			if (record.getId() == id) {
				check = true;
			}
		}
		return check;
	}

	public String readString(String promt) {
		System.out.println(promt);
		return userIn.next();
	}

	public String readLine(String promt) {
		userIn.nextLine();
		System.out.println(promt);
		return userIn.nextLine();
	}

	public int readInt(String promt) {
		System.out.println(promt);
		Boolean check = false;
		int data = 0;
		while (!check) {
			try {
				data = userIn.nextInt();
				check = true;
			} catch (InputMismatchException e) {
				System.out.println("Input errato, riprovare:");
				check = false;
				userIn.next();
			}
		}
		return data;
	}

	public long readLong(String promt) {
		System.out.println(promt);
		Boolean check = false;
		long data = 0;
		while (!check) {
			try {
				data = userIn.nextLong();
				check = true;
			} catch (InputMismatchException e) {
				System.out.println("Input errato, riprovare:");
				check = false;
				userIn.next();
			}
		}
		return data;
	}

}
