package webApp2;

import java.nio.file.Path;

import it.brujo.jappsrv.AppServer;
import it.brujo.jappsrv.Application;
import it.brujo.jappsrv.ApplicationData;
import it.brujo.jappsrv.urimapper.UriEntry;
import it.brujo.jappsrv.urimapper.UriMapper;
import it.brujo.jappsrv.urimapper.UriEntry.Uri;

public class Main {

	public final static String DIR_FILES_BASE = "C:\\Users\\Windows\\Desktop\\JAVA\\webApp2";
	public final static String DIR_FILES_HTML = DIR_FILES_BASE + "\\html";
	public final static String DIR_FILES_STATIC = DIR_FILES_BASE + "\\static";
	public static void main(String[] args) {

		System.out.println("starting....");

		AppServer appServer = AppServer.conf().withServerHome(Path.of("C:\\Users\\Windows\\Desktop\\appserver"))
				.build();

		appServer.httpServer().addListenAddr(8088, false);

		Application app2 = appServer.server().addApplication("app2", () -> new ApplicationData());

		
		UriMapper uriMapper = new UriMapper();
		app2.addService(uriMapper);

		uriMapper.add(UriEntry.create("home", new Home() , Uri.mono("/") ));
		uriMapper.add(UriEntry.create("corsi", new Corsi() , Uri.mono("/corsi.html") ));
		uriMapper.add(UriEntry.create("iscrizioni", new Iscrizioni() , Uri.mono("/iscrizioni.html") ));
		uriMapper.add(UriEntry.create("insegnanti", new Insegnanti(), Uri.mono("/insegnanti.html")));
		
		uriMapper.addStaticFileDir("static", Path.of(DIR_FILES_BASE), "/static/");
		
		
		appServer.start();
		
		
		
	}

}
