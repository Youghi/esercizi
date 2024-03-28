package webApp2;

import it.brujo.html.Create;
import it.brujo.html.Elem;
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

		String idStr = request.getParameter("id");

		if (idStr == null) {
			Elem div = Create.div();

			for (Docente d : elencoDocenti.getListaDocenti()) {
				Create.p().addClass("small_text").setText(d.getfName() + " " + d.getlName())
				.add(Create.a("?id=" + d.getId(), "  dettagli").addClass("small_text"))
						.addTo(div);

				Create.nl().addTo(div);
			}

			return div.writeToString();

		} else {
			int id = Integer.parseInt(idStr);
			Elem div = Create.div();
			Docente d = elencoDocenti.getDocenteById(id);
			Create.p().addClass("small_text").setText("id docente: " + d.getId()).addTo(div);
			Create.p().addClass("small_text").setText("nome: " + d.getfName()).addTo(div);
			Create.p().addClass("small_text").setText("cognome: " + d.getlName()).addTo(div);
			Create.a("/insegnanti.html", "indietro").addTo(div);
			return div.writeToString();
		}

//		String html =loadHtml("insegnanti.html");
//		return html;
	}

}
