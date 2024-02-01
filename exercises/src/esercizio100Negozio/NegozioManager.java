package esercizio100Negozio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NegozioManager {
	Scanner userIn;

	public NegozioManager(Scanner userIn) {
		super();
		this.userIn = userIn;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String readString(String promt) {
		System.out.println(promt);
		return userIn.next();
	}

	public String readLine(String promt) {
		userIn.nextLine();
		System.out.println(promt);
		return userIn.nextLine();
	}

	public int readInt(String promt) {
		System.out.println(promt);
		Boolean check = false;
		int data = 0;
		while (!check) {
			try {
				data = userIn.nextInt();
				check = true;
			} catch (InputMismatchException e) {
				System.out.println("Input errato, riprovare:");
				check = false;
				userIn.next();
			}
		}
		return data;
	}
	
	
}
