package operazioni;

public class MetaStringa implements ElaboraString{

	@Override
	public String elabora(String dato) {
		int mid = dato.length()/2;
		return dato.substring(0, dato.length()/2);
	}

}
