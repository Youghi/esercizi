package esercizio30Immobiliare;

import java.util.Scanner;

public class MainAgenzia {

	public static void main(String[] args) {
		Scanner userIn = new Scanner(System.in);
		AgenziaSystem immSystem = new AgenziaSystem(userIn);
		
		int ind = 9;
		while (ind != 0) {
			System.out.println("operazioni disponibili: " + "\n" + "1 - aggiungi una proprietà in vendita" + "\n"
					+ "2 - vendi una proprietà" + "\n" + "3 - visualizza le proprietà in vendita" + "\n"
					+ "4 - visualizza le proprietà vendute" + "\n" + "0 - uscire");
			ind = userIn.nextInt();
			switch (ind) {
			case 1:
				immSystem.addProperty();
				break;

			case 2:
				immSystem.sellProperty();
				break;
			case 3:
				immSystem.viewPropertiesOnSale();
				break;
			case 4:
				immSystem.viewSoldProperties();
				break;
			case 0:
				break;
			}
		}
		userIn.close();

	}

}
