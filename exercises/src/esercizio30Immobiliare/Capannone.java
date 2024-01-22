package esercizio30Immobiliare;

import java.util.Scanner;

//dall’altezza dell’edificio.

public class Capannone extends Proprieta {
	
Scanner userIn;

private double height;
	
	public Capannone(Scanner userIn) {
		this.userIn = userIn;
	}

	@Override
	public void setData() {
		super.setData();
		System.out.println("altezza del capannone: ");
		this.height = userIn.nextDouble();
	}

	@Override
	public void getData() {
		// TODO Auto-generated method stub
		super.getData();
	}
	
	
}
