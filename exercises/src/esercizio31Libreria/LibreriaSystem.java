package esercizio31Libreria;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import esercizio31Libreria.GenreEnum.genre;

//Aggiungi un nuovo libro" + "\n"
//+ "2 - Modifica dati di un libro" + "\n" + "3 - Visualizza tutti i libri" + "\n"
//+ "4 - Cerca un libro" + "\n" + "5 - Elimina un libro" + "\n" + "0 - uscire"

public class LibreriaSystem {
	Scanner userIn;
	ArrayList<Book> books = new ArrayList<Book>();
//	ArrayList<Author> authors = new ArrayList<Author>();

	public LibreriaSystem(Scanner userIn) {
		this.userIn = userIn;
	}

	public void addBook() {
		if (books.size()==0) {
			Book book = new Book (this, 1);
			book.setData();
			books.add(book);
		}else {
			Book book = new Book (this, (books.get(books.size()-1).getCode() + 1 ) );
			book.setData();
			books.add(book);
		}
	}

	public void viewBook() {
		if (books.size() != 0) {
			for (int i = 0; i < books.size(); i++) {
				books.get(i).getData();
				System.out.println("");
			}
		} else {
			System.out.println("Non ci sono libri nell'archivio");
		}
	}

	public void modifyBook() {
		if (books.size() != 0) {
			for (int i = 0; i < books.size(); i++) {
				books.get(i).getData();
				System.out.println("");
			}
			int ind = readInt("Inserire codice libro da modificare:");
			try {
				books.get(searachPositionByCode(ind)).modifyData();
			} catch (IllegalArgumentException e) {
				System.out.println("codice errato");
			}
		} else {
			System.out.println("Non ci sono libri nell'archivio");
		}
	}

	public void searchBook() {
		if (books.size() != 0) {
			int ind = readInt(("Operazioni disponibili: " + "\n" + "1 - ricerca per codice" + "\n" + "2 - ricerca per nome" + "\n" + "3 - ricerca per autore"
					+ "\n" + "4 - ricerca per genere"));
			switch (ind) {
			case 1:
				int code = readInt("Inserire codice libro da cercare:");
				System.out.println("Risultato ricerca per codice " + code + ":");
				try {
					books.get(searachPositionByCode(code)).getData();
				} catch (IllegalArgumentException e) {
					System.out.println("Non ci sono libri con questo codice");
				}
				break;
				
			case 2:
				String checkName = readLine("Inserire nome libro da cercare:");
				System.out.println("Risultato ricerca per nome " + checkName + ":");
				Boolean check = true;
				for (int i = 0; i < books.size(); i++) {
					if (books.get(i).getName().equalsIgnoreCase(checkName)) {
						books.get(i).getData();
						System.out.println("");
						check = false;
					}
				}
				System.out.println(check == true ? "Non ci sono libri con questo nome" : "");
				break;
				
			case 3:
				String AuthorName = readString("Inserire nome autore da cercare:");
				String AuthorSurame = readString("Cognome:");
				System.out.println("Risultato ricerca per autore " + AuthorName + " " + AuthorSurame + ":");
				check = true;
				for (int i = 0; i < books.size(); i++) {
					if (books.get(i).getAuthor().getName().equalsIgnoreCase(AuthorName)
							&& books.get(i).getAuthor().getSurname().equalsIgnoreCase(AuthorSurame)) {
						books.get(i).getData();
						System.out.println("");
						check = false;
					}
				}
				System.out.println(check == true ? "Non ci sono libri di questo autore" : "");
				break;
				
			case 4:
				System.out.println("Scegliere genere libro da cercare:");
				code = 0;
				for (genre gen : genre.values()) {
					System.out.println(code + ": " + gen);
					code++;
				}
				genre genere = null;
				switch (readInt("")) {
				case 0:
					genere = genre.ROMANZO;
					break;
				case 1:
					genere = genre.BIOGRAFIA;
					break;
				case 2:
					genere = genre.SAGGIO;
					break;
				case 3:
					genere = genre.RACCONTO;
					break;
				case 4:
					genere = genre.DIDATTICO;
					break;
				}
				System.out.println("Risultato ricerca per genere " + genere + ":");
				check = true;
				for (int i = 0; i < books.size(); i++) {
					if (books.get(i).getGenere() == genere) {
						books.get(i).getData();
						System.out.println("");
						check = false;
					}
				}
				System.out.println(check == true ? "Non ci sono libri di questo genere" : "");
				break;
			}
			System.out.println("");
			System.out.println("");
		}
	}

	public void deleteBook() {
		if (books.size() != 0) {
			for (int i = 0; i < books.size(); i++) {
				books.get(i).getData();
				System.out.println("");
			}
			try {
				books.remove(searachPositionByCode(readInt("Inserire codice libro da rimuovere:")));
				System.out.println("rimozione completata!");
			} catch (IllegalArgumentException e) {
				System.out.println("codice errato");
			}
		} else {
			System.out.println("Non ci sono libri nell'archivio");
		}
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

	
	public int searachPositionByCode(int code) {
		int ind = 0;
		if (checkCode(code)) {
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i).getCode() == code) {
					ind = i;
				}
			}
		}else {
			throw new IllegalArgumentException("codice errato");
		}
		return ind;
	}
	
	public Boolean checkCode(int code) {
		Boolean check = false;
		for (Book book : books) {
			if (book.getCode()==code) {
				check = true;
			}
		}
		return check;
	}

}
