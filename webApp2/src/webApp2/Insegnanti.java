package webApp2;

import it.brujo.html.Create;
import it.brujo.html.Elem;
import it.brujo.html.Fragment;
import it.brujo.html.Parser;
import it.brujo.html.Query;
import it.brujo.jappsrv.Request;

public class Insegnanti extends Template {
	// service è un'interfaccia funzionale con solo una funzione
//	@Override
//	public Void apply(Request request) {
//		super.apply(request);
//		request.write("questa è la pagina insegnanti");
//		
//		return null;
//	}

	@Override
	public String body(Request request) {

		App2Data app2Data = (App2Data) request.application().data();
		ElencoDocenti elencoDocenti = app2Data.getElencoDocenti();

		String html = loadHtml("insegnanti.html");
		Fragment htmlFrag = Parser.parseHtml(html);
		Query htmlQuery = new Query(htmlFrag);

		Elem divInsegnanti = htmlQuery.filterId("insegnanti").elem();

		if (request.getParameter("invia") != null) {
			addIns(request, elencoDocenti);
		}

		String idStr = request.getParameter("idIns");

		if (idStr == null) {
			return creaElencoIns(elencoDocenti, divInsegnanti, htmlFrag);
		} else {
			return creaDettaglioIns(elencoDocenti, idStr, divInsegnanti);
		}

	}

	
	
	public void addIns(Request request, ElencoDocenti elencoDocenti) {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String conome = request.getParameter("cognome");
		Docente d = new Docente(id, nome, conome);
		elencoDocenti.addDocente(d);
	}

	
	
	public String creaElencoIns(ElencoDocenti elencoDocenti, Elem divInsegnanti, Fragment htmlFrag) {
		Elem div = Create.div();

		for (Docente d : elencoDocenti.getListaDocenti()) {
			Create.p().addClass("small_text").setText(d.getfName() + " " + d.getlName())
					.add(Create.a("?idIns=" + d.getId(), "  dettagli").addClass("small_text")).addTo(div);

			Create.nl().addTo(div);
		}
		divInsegnanti.setHtml(div.writeToString());
		return htmlFrag.writeToString();
	}
	
	
	public String creaDettaglioIns(ElencoDocenti elencoDocenti, String idStr, Elem divInsegnanti){
		
		int id = Integer.parseInt(idStr);
		Elem div = Create.div();
		Docente d = elencoDocenti.getDocenteById(id);
		Create.p().addClass("small_text").setText("id docente: " + d.getId()).addTo(div);
		Create.p().addClass("small_text").setText("nome: " + d.getfName()).addTo(div);
		Create.p().addClass("small_text").setText("cognome: " + d.getlName()).addTo(div);
		Create.a("/insegnanti.html", "indietro").addTo(div);
		divInsegnanti.setHtml(div.writeToString());
		return div.writeToString();
	}
	
	
	
}
