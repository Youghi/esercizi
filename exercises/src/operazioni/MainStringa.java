package operazioni;

import java.util.ArrayList;
import java.util.Scanner;

public class MainStringa {

	public static void main(String[] args) {
		Scanner userIn = new Scanner(System.in);
		System.out.println("scrivi: ");
		String s = userIn.nextLine();
		ArrayList<ElaboraString> operazioni = new ArrayList<ElaboraString>();
		operazioni.add(new TrovaVocali());
		operazioni.add(dato -> dato.replaceAll("\\s", ""));
		operazioni.add(dato -> dato.substring(0, dato.length() / 2));
		int ind = 9;
		System.out.println("1 per vedere le vocali\n2 per cancellare gli spazi\n3 per vedere metà stringa");
		while (ind!=0) {
			ind = userIn.nextInt();
			switch (ind) {
			case 1:
				printElaborato(operazioni.get(ind-1), s);
				break;
			case 2:
				printElaborato(operazioni.get(ind-1), s);
				break;
			case 3:
				printElaborato(operazioni.get(ind-1), s);
				break;
				
			default:
				break;
			}
		}

		

	}

	public static void printElaborato(ElaboraString es, String dato) {
		System.out.println(es.elabora(dato));
	}

}
