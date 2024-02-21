package esercizioRubrica;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import esercizio31Libreria2.Book;


public class LogicManager {
	DBManager dbManager = new DBManager();
	private Scanner userIn;
	ArrayList<Records> records = new ArrayList<Records>();
	
	public LogicManager(Scanner userIn) {
		this.userIn = userIn;
		dbManager.init();
	}
	
	public void addRecord() {
			Records record = new Records(this);
			record.setData();
			record.setId(dbManager.addNew(record));
			records.add(record);
			
	}
	
	public void modifyRecord() {
		dbManager.viewAllRecords();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//metodo per trovare la posizione del mio record dato un id
	public int searachPositionById(int id) {
		int ind = 0;
		if (checkCode(id)) {
			for (int i = 0; i < records.size(); i++) {
				if (records.get(i).getId() == id) {
					ind = i;
				}
			}
		}else {
			throw new IllegalArgumentException("codice errato");
		}
		return ind;
	}
	
	//metodo che stabilische che id dato esiste
	public Boolean checkCode(int id) {
		Boolean check = false;
		for (Records record : records) {
			if (record.getId()==id) {
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

	
	
	
	
	
}
