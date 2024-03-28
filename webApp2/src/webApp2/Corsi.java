package webApp2;


import it.brujo.html.Create;
import it.brujo.html.Elem;
import it.brujo.jappsrv.Request;

public class Corsi extends Template{

	@Override
	public String body(Request request) {
		
		
		
		System.out.println("var = " + request.getParameter("var"));
		String idCorso = request.getParameter("var");
		
		//carico dal database i dati del corso ricevuto
		Elem div = Create.div().add(Create.p().setText("corso " + idCorso));
		
		return div.writeToString();
		
		
		
		
		
		
//		String html =loadHtml("corsi.html");
//		return html;
	}

}
