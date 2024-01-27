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
	ArrayList<Author> authors = new ArrayList<Author>();

	public LibreriaSystem(Scanner userIn) {
		this.userIn = userIn;
	}

	public void addBook() {
		Book book = new Book (this);
		book.setData();
		books.add(book);
	}

	public void viewBook() {
		if (books.size() != 0) {
			for (int i = 0; i < books.size(); i++) {
				System.out.println("------ Libro n° " + i);
				books.get(i).getData();
				System.out.println("");
			}
		} else {
			System.out.println("Non ci sono libri nell'archivio");
		}
	}

	public void modifyBook() {

	}

	public void searchBook() {
		int ind = readInt(("Operazioni disponibili: " + "\n" + "1 - ricerca per nome" + "\n" + "2 - ricerca per autore"
				+ "\n" + "3 - ricerca per genere"));
		switch (ind) {
		case 1:
			String checkName = readLine("Inserire nome libro da cercare:");
			System.out.println("Risultato ricerca per nome " + checkName + ":");
			Boolean check = true;
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i).getName().equalsIgnoreCase(checkName)) {
					System.out.println("------ Libro n° " + i);
					books.get(i).getData();
					System.out.println("");
					check = false;
				}
			}
			System.out.println(check == true ? "Non ci sono libri con questo nome" : "");
			break;

		case 2:
			String AuthorName = readString("Inserire nome autore da cercare:");
			String AuthorSurame = readString("Cognome:");
			System.out.println("Risultato ricerca per autore " + AuthorName + " " + AuthorSurame + ":");
			check = true;
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i).getAuthor().getName().equalsIgnoreCase(AuthorName)
						&& books.get(i).getAuthor().getSurname().equalsIgnoreCase(AuthorSurame)) {
					System.out.println("------ Libro n° " + i);
					books.get(i).getData();
					System.out.println("");
					check = false;
				}
			}
			System.out.println(check == true ? "Non ci sono libri di questo autore" : "");
			break;

		case 3:
			System.out.println("Scegliere genere libro da cercare:");
			int code = 0;
			for (genre gen : genre.values()) {
				System.out.println(code + ": " + gen);
				code++;
			}
			genre genere = null;
			switch (readInt("")) {
			case 0:
				genere = genre.Romanzo;
				break;
			case 1:
				genere = genre.Biografia;
				break;
			case 2:
				genere = genre.Saggio;
				break;
			case 3:
				genere = genre.Racconto;
				break;
			case 4:
				genere = genre.Didattico;
				break;
			}
			System.out.println("Risultato ricerca per genere " + genere + ":");
			check = true;
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i).getGenere() == genere) {
					System.out.println("------ Libro n° " + i);
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

	public void deleteBook() {
		if (books.size() != 0) {
			for (int i = 0; i < books.size(); i++) {
				System.out.println("------ Libro n° " + i);
				books.get(i).getData();
				System.out.println("");
			}
			books.remove(readInt("Selezionare numero libro da rimuovere:"));
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

}
