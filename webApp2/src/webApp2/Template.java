package webApp2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import it.brujo.html.Elem;
import it.brujo.html.Fragment;
import it.brujo.html.Parser;
import it.brujo.html.Query;
import it.brujo.jappsrv.Request;
import it.brujo.jappsrv.Service;

public abstract class Template implements Service{

	@Override
	public Void apply(Request request) {
//		request.write("QUESTO E L'HEADER Nuovo\n");
//		request.write("\nQUESTO E FOOTER");
		
//		Path p = Path.of("C:\\Users\\Windows\\Desktop\\JAVA\\webApp2\\html\\template.html");
//		String html = null;
//
//		try {
//			html = Files.readString(p);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		String html = loadHtml("template.html");
		
		// fragment trasforma html in oggetti java
		Fragment htmlFrag = Parser.parseHtml(html);
		//permette di usare fragment
		Query htmlQuery = new Query(htmlFrag);
		
		
		Elem contentsDiv = htmlQuery.filterId("contents").elem();
		
		String body = body(request);
//		html = html.replace("content", body);
		contentsDiv.setHtml(body);
		
		htmlQuery.filterId("test").elem().setHtml("<img src=\"/static/java.png\">");
		
		request.write(htmlFrag.writeToString());
		
		
		return null;
	}

	public abstract String body(Request request);
	
	public String loadHtml(String fileName) {
		Path p = Path.of(Main.DIR_FILES_HTML).resolve(fileName);
		String html = null;

		try {
			html = Files.readString(p);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return html;
	}
	
}
