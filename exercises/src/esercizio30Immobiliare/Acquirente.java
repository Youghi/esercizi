package esercizio30Immobiliare;

import java.util.ArrayList;
import java.util.Scanner;

public class Acquirente {

	Scanner userIn;
	private String name;
	private String dateOfBirth;
	public Acquirente(Scanner scan) {
		this.userIn = scan;
	}

	public void setData() {
		System.out.println("inserire nome: ");
		this.name = userIn.next();
		System.out.println("inserire data di nascita(gg.mm.aaaa): ");
		this.dateOfBirth = userIn.next();
	}

	public void getData() {
		System.out.println("nome: " + this.name);
		System.out.println("data di nascita: " + this.dateOfBirth);
	}
	
}
