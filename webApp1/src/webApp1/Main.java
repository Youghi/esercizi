package webApp1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import it.brujo.html.Create;
import it.brujo.html.Elem;
import it.brujo.html.Fragment;
import it.brujo.html.Parser;
import it.brujo.html.Query;
import it.brujo.jappsrv.AppServer;
import it.brujo.jappsrv.Application;
import it.brujo.jappsrv.ApplicationData;
import it.brujo.jappsrv.Request;
import it.brujo.jappsrv.urimapper.UriEntry;
import it.brujo.jappsrv.urimapper.UriEntry.Uri;
import it.brujo.jappsrv.urimapper.UriMapper;

public class Main {

	public static void main(String[] args) {
		System.out.println("starting....");

//		questo è un metodo diverso di istanziare classi specifici che è configurato all'interno di esse
		AppServer appServer = AppServer.conf().withServerHome(Path.of("C:\\Users\\Windows\\Desktop\\appserver"))
				.build();

		appServer.httpServer().addListenAddr(8088, false);

// lamda function per questioni di tempistica
		Application app1 = appServer.server().addApplication("app1", () -> new ApplicationData());

		UriMapper uriMapper = new UriMapper();

		app1.addService(uriMapper);

		// aggiungo una pagina inserendo id, metodo, uri al mapper
		uriMapper.add(UriEntry.create("home", Main::home, Uri.mono("/home.html")));
		uriMapper.add(UriEntry.create("pagina", Main::pagina, Uri.mono("/pag.html")));
		uriMapper.add(UriEntry.create("trieste", Main::trieste, Uri.mono("/trieste.html")));
		appServer.start();

	}

	public static Void home(Request req) {
		// req fa vedere l'uri che sto chiamando dal browser
		System.out.println("uri=" + req.getUri());

		Path p = Path.of("C:\\Users\\Windows\\Desktop\\JAVA\\webApp1\\html\\home.html");
		String html = null;
		
		try {
			html=Files.readString(p);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Parser htmlParser = new Parser();
		
		Fragment frag = htmlParser.parse(html);
		Query query = new Query(frag);
		query.filterId("targetMe").setText("questo testo è stato generato dal pharser");
		
		req.write(frag.writeToString());
//		req.write("\n" + "<p>eccoci!! <b>BENVENUTO NELLA HOME</b></p>");
		return null;
	}
	
	public static Void trieste(Request req) {
		// req fa vedere l'uri che sto chiamando dal browser
		System.out.println("uri=" + req.getUri());

		Path p = Path.of("C:\\Users\\Windows\\Desktop\\HTML\\esercizi\\public\\esercizio_trieste.html");
		String html = null;
		
		try {
			html=Files.readString(p);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		req.write(html);
//		req.write("\n" + "<p>eccoci!! <b>BENVENUTO NELLA HOME</b></p>");
		return null;
	}

	public static Void pagina(Request req) {
		// req fa vedere l'uri che sto chiamando dal browser
		System.out.println("uri=" + req.getUri());
		Elem div = Create.div().add(Create.p()
				.setText("ciao questo è un testo generato ")
				.add(Create.span()
						.setText("questo è uno span generato ")
						.addStyle("font-weight:bold;")));

		for (int i = 0; i < 5; i++) {
			div.add(Create.p().setText("riga n: " + i));
		}
		
		req.write(div.writeToString());
		return null;
	}

}
