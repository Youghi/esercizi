package esercizio30Immobiliare;

import java.util.Scanner;

public class Venditore {
	Scanner userIn;
	private String name;
	private String dateOfBirth;
	private Boolean dipendenteAgg;

	public Venditore(Scanner scan) {
		this.userIn = scan;
	}

	public void setData() {
		System.out.println("inserire nome: ");
		this.name = userIn.next();
		System.out.println("inserire data di nascita(gg.mm.aaaa): ");
		this.dateOfBirth = userIn.next();
		System.out.println("dipendente agenzia? (Y/N) ");
		String answ = userIn.next();
		if (answ.equalsIgnoreCase("Y")) {
			this.dipendenteAgg = true;
		} else {
			this.dipendenteAgg = false;
		}
	}

	public void getData() {
		System.out.println("nome: " + this.name);
		System.out.println("data di nascita: " + this.dateOfBirth);
		if (dipendenteAgg) {
			System.out.println("dipendente dell'agenzia");
		}else {
			System.out.println("venditore privato");
		}
	}

}
