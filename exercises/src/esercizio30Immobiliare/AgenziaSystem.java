package esercizio30Immobiliare;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenziaSystem {
	Scanner userIn;
	private ArrayList<Proprieta> properties = new ArrayList<Proprieta>();
	private ArrayList<Venduti> sales = new ArrayList<Venduti>();

	public AgenziaSystem(Scanner scan) {
		this.userIn = scan;
	}

	public void addProperty() {
		Proprieta property = null;
		System.out.println("tipo di immobile: " + "\n" + "1 - appartamento" + "\n" + "2 - villa" + "\n"
				+ "3 - capannone industriale" + "\n" + "0 - uscire");
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
			property = new Capannone(userIn);
			property.setData();
			break;
		}
		properties.add(property);
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}

	public void sellProperty() {
		Venduti sale = new Venduti(userIn);

		System.out.println("Tipo di immobile da vendere?: " + "\n" + "1 - appartamento" + "\n" + "2 - villa" + "\n"
				+ "3 - capannone industriale");
		int ind = userIn.nextInt();
		int code;
		switch (ind) {
		case 1:
			for (int i = 0; i < properties.size(); i++) {
				if (properties.get(i) instanceof Appartamento) {
					System.out.println("**** Appartamento N° " + i + " ****");
					properties.get(i).getData();
				}
			}
			System.out.println("selezionare numero immobile: ");
			code = userIn.nextInt();
			sale.setData(properties.get(code));
			sales.add(sale);
			properties.remove(code);
			break;

		case 2:
			for (int i = 0; i < properties.size(); i++) {
				if (properties.get(i) instanceof Villa) {
					System.out.println("**** Villa N° " + i + " ****");
					properties.get(i).getData();
				}
			}
			System.out.println("selezionare numero immobile: ");
			code = userIn.nextInt();
			sale.setData(properties.get(code));
			sales.add(sale);
			properties.remove(code);
			break;
			
		case 3:
			for (int i = 0; i < properties.size(); i++) {
				if (properties.get(i) instanceof Capannone) {
					System.out.println("**** Capannone N° " + i + " ****");
					properties.get(i).getData();
				}
			}
			System.out.println("selezionare numero immobile: ");
			code = userIn.nextInt();
			sale.setData(properties.get(code));
			sales.add(sale);
			properties.remove(code);
			break;
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}

	public void viewPropertiesOnSale() {
		for (Proprieta property : properties) {
			System.out.println("***********");
			if (property instanceof Appartamento) {
				System.out.println("-----Tipo immobile : Appartamento");
			} else if (property instanceof Villa) {
				System.out.println("-----Tipo immobile : Villa");
			} else {
				System.out.println("-----Tipo immobile : Capannone industriale");
			}

			property.getData();
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}

	public void viewSoldProperties() {
		for (Venduti sale : sales) {
			if (sale.getProperty() instanceof Appartamento) {
				System.out.println("-----Tipo immobile : Appartamento");
			} else if (sale.getProperty() instanceof Villa) {
				System.out.println("-----Tipo immobile : Villa");
			} else {
				System.out.println("-----Tipo immobile : Capannone industriale");
			}
			sale.getData();
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}

}
