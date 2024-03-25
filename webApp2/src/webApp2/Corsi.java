package webApp2;

import it.brujo.jappsrv.Request;

public class Corsi extends Template{

	@Override
	public String body(Request request) {
		String html =loadHtml("corsi.html");
		return html;
	}

}
