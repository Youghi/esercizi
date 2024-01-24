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

	}

	public void viewBook() {

	}

	public void modifyBook() {

	}

	public void searchBook() {

	}

	public void deleteBook() {

	}

	public String readString(String promt) {
		System.out.println(promt);
		return userIn.next();
	}

	public int readInt(String promt) {
		System.out.println(promt);
		return userIn.nextInt();
	}

}
