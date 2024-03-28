package webApp2;

import it.brujo.jappsrv.Request;

public class Home extends Template {

//	@Override
//	public Void apply(Request request) {
//		super.apply(request);
//		request.write("questa è la home");
//		
//		return null;
//	}

	@Override
	public String body(Request request) {

		if (request.getParameter("invia") != null) {
			System.out.println("nome: " + request.getParameter("nome"));
			
			
			int id= Integer.parseInt(request.getParameter("id"));
			String nome = request.getParameter("nome");
			String conome = request.getParameter("cognome");
			
			Docente d = new Docente(id, nome, conome);
			
			App2Data app2Data = (App2Data) request.application().data();
			ElencoDocenti elencoDocenti = app2Data.getElencoDocenti();
			
			elencoDocenti.addDocente(d);
			
		}

		String html = loadHtml("home.html");
		return html;

	}

}
