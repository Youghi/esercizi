package esercizio30Immobiliare;

import java.util.Scanner;

public abstract class Proprieta {
	private double surface;
	private double price;
	private Venditore seller;
	
	
	Scanner userIn = new Scanner(System.in);
	
	public void setData() {
		this.seller = new Venditore(userIn);
		System.out.println("inserire dati del venditore:");
		this.seller.setData();
		System.out.println("inserire superficie:");
		this.surface = userIn.nextDouble();
		System.out.println("inserire prezzo:");
		this.price = userIn.nextDouble();
	}
	
	public void getData() {
		System.out.println("-----Venditore:");
		this.seller.getData();
		System.out.println("**********");
		System.out.println("superficie: " + this.surface + " Mq"+  "\n" + "prezzo: " + this.price + " $");
	}
	
	

}
