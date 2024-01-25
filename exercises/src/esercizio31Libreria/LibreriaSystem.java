package esercizio31Libreria;

import java.util.ArrayList;
import java.util.Scanner;

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
		for (int i = 0; i < books.size(); i++) {
			System.out.println("------ Libro n° " + i);
			books.get(i).getData();
			System.out.println("");
		}
	}

	public void modifyBook() {

	}

	public void searchBook() {

	}

	public void deleteBook() {

	}

	public String readString(String promt) {
		System.out.println(promt);
		return userIn.nextLine();
	}

	public int readInt(String promt) {
		System.out.println(promt);
		return userIn.nextInt();
	}

}
