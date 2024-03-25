package webApp2;

import it.brujo.jappsrv.Request;

public class Insegnanti extends Template {
	//service è un'interfaccia funzionale con solo una funzione
//	@Override
//	public Void apply(Request request) {
//		super.apply(request);
//		request.write("questa è la pagina insegnanti");
//		
//		return null;
//	}

	@Override
	public String body(Request request) {
		String html =loadHtml("insegnanti.html");
		return html;
	}

}
