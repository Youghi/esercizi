package webApp2;

import it.brujo.jappsrv.Request;

public class Iscrizioni extends Template{

	@Override
	public String body(Request request) {
		String html =loadHtml("iscrizioni.html");
		return html;
	}

}
