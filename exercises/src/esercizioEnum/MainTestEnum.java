package esercizioEnum;

import java.util.Scanner;

import esercizioEnum.Citta.citta;
import esercizioEnum.PuntiCardinali.punti;

public class MainTestEnum {

	public static void main(String[] args) {
		Scanner userIn = new Scanner(System.in);
		citta cittaFissa = citta.Roma;
		citta cittaVar = null;
		punti punto;
		String ind = "";
		while (!ind.equalsIgnoreCase("esc")) {
			System.out.println("scrivi quale città:     /esc per uscire");
			for (citta citt : citta.values()) {
				if (citt != citta.valueOf("Roma")) {
					System.out.println(citt);
				}
			}
			ind = userIn.next();
			if (!ind.equalsIgnoreCase("esc")) {
				cittaVar = citta.valueOf(ind);
				switch (cittaVar) {
				case Londra:
					punto = punti.sud;
					System.out.println(cittaFissa + " si trova a " + punto + " rispetto a " + cittaVar);
					break;
				case New_York:
					punto = punti.est;
					System.out.println(cittaFissa + " si trova a " + punto + " rispetto a " + cittaVar);
					break;
				case Tokyo:
					punto = punti.ovest;
					System.out.println(cittaFissa + " si trova a " + punto + " rispetto a " + cittaVar);
					break;
				case Durban:
					punto = punti.nord;
					System.out.println(cittaFissa + " si trova a " + punto + " rispetto a " + cittaVar);
					break;
				default:
					break;

				}

			} else {
				System.out.println("ciao!");
			}
		}
		userIn.close();
	}

}
