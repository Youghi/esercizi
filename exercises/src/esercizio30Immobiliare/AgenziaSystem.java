package esercizio30Immobiliare;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenziaSystem {
	Scanner userIn;
	private ArrayList<Proprieta> properties = new ArrayList<Proprieta>();
	
	public AgenziaSystem (Scanner scan) {
		this.userIn = scan;
	}
	

	public void addProperty() {
		Proprieta property = null;
		System.out.println("tipo di immobile: " + "\n" + "1 - appartamento" + "\n"
				+ "2 - villa" + "\n" + "3 - capannone industriale" + "\n" + "0 - uscire");
		int ind = userIn.nextInt();
		switch (ind) {
		case 1:
			property = new Appartamento(userIn);
			property.setData();
			break;

		case 2:
			property = new Villa(userIn);
			property.setData();
			break;
		case 3:
			property = new Villa(userIn);
			property.setData();
			break;
		}
		properties.add(property);
	}

	public void sellProperty() {

	}

	public void viewPropertiesOnSale() {
		for (Proprieta property : properties) {
			System.out.println("***********");
			if (property instanceof Appartamento) {
				System.out.println("-----Tipo immobile : Appartamento");
			}else if (property instanceof Villa) {
				System.out.println("-----Tipo immobile : Villa");
			}else {
				System.out.println("-----Tipo immobile : Capannone industriale");
			}
			
			property.getData();
		}

	}

	public void viewSoldProperties() {

	}

}
