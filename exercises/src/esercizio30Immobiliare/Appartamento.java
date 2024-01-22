package esercizio30Immobiliare;

import java.util.Scanner;

//piano in cui si trovano, numero
//appartamenti nel palazzo, se dotati di cantina e box,

public class Appartamento extends Proprieta {

	Scanner userIn;

	private int numOfApp;
	private int floor;
	private Boolean garage;

	public Appartamento(Scanner userIn) {
		this.userIn = userIn;
	}

	@Override
	public void setData() {
		super.setData();
		System.out.println("inserire numero degli appartamenti nel palazzo: ");
		this.numOfApp = userIn.nextInt();
		System.out.println("inserire piano: ");
		this.floor = userIn.nextInt();
		System.out.println("garage incluso? (Y/N) ");
		String answ = userIn.next();
		if (answ.equalsIgnoreCase("Y")) {
			this.garage = true;
		} else {
			this.garage = false;
		}
	}

	@Override
	public void getData() {
		super.getData();
		System.out.println("numero degli appartamenti nel palazzo: " + this.numOfApp);
		System.out.println("piano: " + this.floor);
		System.out.println("garage incluso: ");
		if (garage) {
			System.out.println("      si");
		}else {
			System.out.println("      no");
		}
	}

}
