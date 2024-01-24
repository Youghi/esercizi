package esercizio30Immobiliare;

import java.util.Scanner;
public class Venduti {
	Scanner userIn;
	
	private String dateOfSell;
	private Acquirente buyer;
	private Proprieta property;
	
	public Venduti(Scanner userIn) {
		this.userIn = userIn;
	}

	public void setData(Proprieta property) {
		System.out.println("inserire data dell'acquisto: ");
		this.dateOfSell = userIn.next();
		this.property = property;
		this.buyer =  new Acquirente(userIn);
		System.out.println("inserire dati del acquirente:");
		this.buyer.setData();
	}
	
	public void getData () {
		System.out.println("****************");
		System.out.println("data dell'acquisto: " + this.dateOfSell);
		if (this.property instanceof Appartamento) {
			System.out.println("-----Tipo immobile : Appartamento");
		}else if (this.property instanceof Villa) {
			System.out.println("-----Tipo immobile : Villa");
		}else {
			System.out.println("-----Tipo immobile : Capannone industriale");
		}
		this.property.getData();
		System.out.println("-----Acquirente:");
		this.buyer.getData();
	}

	public String getDateOfSell() {
		return dateOfSell;
	}

	public void setDateOfSell(String dateOfSell) {
		this.dateOfSell = dateOfSell;
	}

	public Acquirente getBuyer() {
		return buyer;
	}

	public void setBuyer(Acquirente buyer) {
		this.buyer = buyer;
	}

	public Proprieta getProperty() {
		return property;
	}

	public void setProperty(Proprieta property) {
		this.property = property;
	}
	
}

