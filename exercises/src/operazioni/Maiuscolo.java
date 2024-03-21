package operazioni;

public class Maiuscolo implements ElaboraString{

	@Override
	public String elabora(String dato) {
		
		return dato.toUpperCase();
	}

	
}
