package esercizio30Immobiliare;

import java.util.Scanner;

public abstract class Proprieta {
	private double surface;
	private double price;
	
	Scanner userIn = new Scanner(System.in);
	
	public void setData() {
		System.out.println("inserire superficie:");
		this.surface = userIn.nextDouble();
		System.out.println("inserire prezzo:");
		this.price = userIn.nextDouble();
	}
	
	public void getData() {
		System.out.println("superficie: " + this.surface + "\n" + "prezzo: " + this.price);
	}
	
	

}
