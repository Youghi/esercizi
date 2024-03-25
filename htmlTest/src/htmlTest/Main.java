package htmlTest;

import it.brujo.html.Create;
import it.brujo.html.Elem;
import it.brujo.html.Fragment;
import it.brujo.html.Parser;
import it.brujo.html.Part;
import it.brujo.html.Query;

public class Main {

	public static void main(String[] args) {
		Elem p1 = Create.p().setText("prova");
		p1.addAttr("class", "pippo");

		Elem span1 = Create.span().setText("prova span");
		p1.addText(" ");
		p1.add(span1);

		System.out.println(p1.writeToString());
		
		
		//*************al contrario *************************
	
		
		String htmlStr = "<div>ciao<p>hello</p></div>";
		Fragment frag = Parser.parseHtml(htmlStr);
		Query query = new Query(frag);
		query.filterName("p").elem().addAttr("style", "color: red");
		System.out.println(frag.writeToString());
	}

}
