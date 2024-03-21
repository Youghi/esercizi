package esercizio31Libreria2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import esercizio31Libreria.GenreEnum.genre;

public class LibreriaSystem {
	DBManager dbm = new DBManager(this);
	Scanner userIn;
	ArrayList<Book> books = new ArrayList<Book>();
	ArrayList<Author> authors = new ArrayList<Author>();

	public LibreriaSystem(Scanner userIn) {
		this.userIn = userIn;
		dbm.init();
	}

	public void addBook() {
		Book book = new Book(this);
		book.setData();
	}

	public void viewBook() {
		dbm.viewAllBooks();
	}

	public void modifyData() {
		Boolean check = true;
		int ind;
		while (check) {
			ind = readInt(("Operazioni disponibili: " + "\n" + "1 - Modifica i dati di un libro" + "\n"
					+ "2 - Modifica i dati di un autore" + "\n" + "0 - uscire"));
			switch (ind) {
			case 1:
				modifyBook();
				break;

			case 2:
				modifyAuthor();
				break;

			case 0:
				check = false;
				break;
			}
			System.out.println("");
			System.out.println("");
		}
	}

	public void modifyBook() {
		switch (readString("Visualizzare lista libri? (Y/N)").toUpperCase()) {
		case "Y":
			dbm.viewAllBooks();
			break;
		case "N":
			break;
		}
		Boolean check = true;
		while (check) {
			int id = readInt("Inserire codice libro da modificare");
			try {
				dbm.compileBookFromInd(validatePk(id, 1)).modifyData();
				check = false;
			} catch (IllegalArgumentException e) {
				System.out.println("codice errato");
				check = true;
			}
		}
	}

	public void modifyAuthor() {
		switch (readString("Visualizzare lista autori? (Y/N)").toUpperCase()) {
		case "Y":
			dbm.viewAllAuthors();
			break;
		case "N":
			break;
		}
		Boolean check = true;
		while (check) {
			int id = readInt("Inserire codice libro da modificare");
			try {
				dbm.compileAuthorFromInd(validatePk(id, 2)).modifyData();
				check = false;
			} catch (IllegalArgumentException e) {
				System.out.println("codice errato");
				check = true;
			}
		}

	}

//	public void searchBook() {
//		if (books.size() != 0) {
//			int ind = readInt(("Operazioni disponibili: " + "\n" + "1 - ricerca per codice" + "\n"
//					+ "2 - ricerca per nome" + "\n" + "3 - ricerca per autore" + "\n" + "4 - ricerca per genere"));
//			switch (ind) {
//			case 1:
//				int code = readInt("Inserire codice libro da cercare:");
//				System.out.println("Risultato ricerca per codice " + code + ":");
//				try {
//
//				} catch (IllegalArgumentException e) {
//					System.out.println("Non ci sono libri con questo codice");
//				}
//				break;
//
//			case 2:
//				String checkName = readLine("Inserire nome libro da cercare:");
//				System.out.println("Risultato ricerca per nome " + checkName + ":");
//				Boolean check = true;
//				for (int i = 0; i < books.size(); i++) {
//					if (books.get(i).getName().equalsIgnoreCase(checkName)) {
//						books.get(i).getData();
//						System.out.println("");
//						check = false;
//					}
//				}
//				System.out.println(check == true ? "Non ci sono libri con questo nome" : "");
//				break;
//
//			case 3:
//				String AuthorName = readString("Inserire nome autore da cercare:");
//				String AuthorSurame = readString("Cognome:");
//				System.out.println("Risultato ricerca per autore " + AuthorName + " " + AuthorSurame + ":");
//				check = true;
//				for (int i = 0; i < books.size(); i++) {
//					if (books.get(i).getAuthor().getName().equalsIgnoreCase(AuthorName)
//							&& books.get(i).getAuthor().getSurname().equalsIgnoreCase(AuthorSurame)) {
//						books.get(i).getData();
//						System.out.println("");
//						check = false;
//					}
//				}
//				System.out.println(check == true ? "Non ci sono libri di questo autore" : "");
//				break;
//
//			case 4:
//				System.out.println("Scegliere genere libro da cercare:");
//				code = 0;
//				for (genre gen : genre.values()) {
//					System.out.println(code + ": " + gen);
//					code++;
//				}
//				genre genere = null;
//				switch (readInt("")) {
//				case 0:
//					genere = genre.ROMANZO;
//					break;
//				case 1:
//					genere = genre.BIOGRAFIA;
//					break;
//				case 2:
//					genere = genre.SAGGIO;
//					break;
//				case 3:
//					genere = genre.RACCONTO;
//					break;
//				case 4:
//					genere = genre.DIDATTICO;
//					break;
//				}
//				System.out.println("Risultato ricerca per genere " + genere + ":");
//				check = true;
//				for (int i = 0; i < books.size(); i++) {
//					if (books.get(i).getGenere() == genere) {
//						books.get(i).getData();
//						System.out.println("");
//						check = false;
//					}
//				}
//				System.out.println(check == true ? "Non ci sono libri di questo genere" : "");
//				break;
//			}
//			System.out.println("");
//			System.out.println("");
//		}
//	}

	public void deleteBook() {
		switch (readString("Visualizzare lista libri? (Y/N)").toUpperCase()) {
		case "Y":
			dbm.viewAllBooks();
			break;
		case "N":
			break;
		}
		int id = readInt("Inserire codice libro da eliminare");
		try {
			dbm.deleteById(validatePk(id, 1));
			System.out.println("rimozione completata!");
		} catch (IllegalArgumentException e) {
			System.out.println("codice errato");
		}

	}

	public String readString(String promt) {
		System.out.println(promt);
		return userIn.next().toUpperCase();
	}

	public String readLine(String promt) {
		userIn.nextLine();
		System.out.println(promt);
		return userIn.nextLine().toUpperCase();
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

	public int validatePk(int code, int selector) {
		int ind = 0;
		if (dbm.checkPk(code, selector)) {
			ind = code;
		} else {
			throw new IllegalArgumentException("codice errato");
		}
		return ind;
	}

}
