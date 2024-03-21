package operazioni;

public class TrovaVocali implements ElaboraString {

	@Override
	public String elabora(String dato) {
		String result = "";
		for (int i = 0; i < dato.length(); i++) {
			if (dato.charAt(i) == 'a' || dato.charAt(i) == 'e' || dato.charAt(i) == 'i' || dato.charAt(i) == 'o'
					|| dato.charAt(i) == 'u' || dato.charAt(i) == 'è' || dato.charAt(i) == 'é' || dato.charAt(i) == 'à'
					|| dato.charAt(i) == 'ù' || dato.charAt(i) == 'ò') {
				result = result + dato.charAt(i) + " ";
			}
		}
		return result;
	}

}
