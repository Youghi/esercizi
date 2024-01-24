package esercizio30Immobiliare;

import java.util.Scanner;

//giardino e da quanti piani sono costituite.

public class Villa extends Proprieta {

Scanner userIn;

private int floors;
private Boolean garden;
	
	public Villa(Scanner userIn) {
		this.userIn = userIn;
	}

	@Override
	public void setData() {
		super.setData();
		System.out.println("quanti piani?: ");
		this.floors = userIn.nextInt();
		System.out.println("giardino? (Y/N) ");
		String answ = userIn.next();
		if (answ.equalsIgnoreCase("Y")) {
			this.garden = true;
		} else {
			this.garden = false;
		}
	}

	@Override
	public void getData() {
		super.getData();
		System.out.println("numero piani: " + this.floors + "\n" + "giardino:" + (this.garden == true  ? "si" : "no"));
		
	}
	
	
	
}
