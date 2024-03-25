package webApp2;

import it.brujo.jappsrv.Request;

public class Home extends Template{

//	@Override
//	public Void apply(Request request) {
//		super.apply(request);
//		request.write("questa è la home");
//		
//		return null;
//	}

	@Override
	public String body(Request request) {
		String html =loadHtml("home.html");
		return html;
		
	}

	
	
}
