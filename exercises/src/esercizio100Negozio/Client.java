package esercizio100Negozio;

import java.util.ArrayList;

public class Client extends User {
	final private String eMail;
	private String password;
	private double balance;
	private ArrayList<Products> cart = new ArrayList<Products>();
	public Client(String eMail) {
		super();
		this.eMail = eMail;
	}


}
