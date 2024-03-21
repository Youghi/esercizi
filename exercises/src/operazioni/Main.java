package operazioni;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Double> valori = new ArrayList<Double>();
		valori.add(4.5);
		valori.add(3.6);
		valori.add(12.8);
		valori.add(86.124);
		valori.add(-85.34);
		valori.add(75.83);
		valori.add(21.5);
		valori.add(24.1);
		
		double partenza = 2.2;
		
		ArrayList<Operazione> operazioni = new ArrayList<Operazione>();
		operazioni.add((a,b) -> a+b);
		operazioni.add(new Moltiplicazione());
		operazioni.add(new Strana());
		operazioni.add(new Somma());
		
		for (int i = 0; i < valori.size() && i<operazioni.size(); i++) {
			double nextV = valori.get(i);
			Operazione nextOp = operazioni.get(i); 
			
			System.out.println("nextV= " + nextV + "op= " + nextOp.getClass().getSimpleName());
			partenza = nextOp.operazione(partenza, nextV);
			System.out.println("partenza= " + partenza);
		}
		
	}

}
