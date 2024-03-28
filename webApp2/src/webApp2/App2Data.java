package webApp2;

import it.brujo.jappsrv.ApplicationData;

public class App2Data extends ApplicationData{

	ElencoDocenti elencoDocenti = new ElencoDocenti();
	
	public App2Data() {
		super();
	}
	
	public ElencoDocenti getElencoDocenti() {
		return elencoDocenti;
	}
	
	
}
