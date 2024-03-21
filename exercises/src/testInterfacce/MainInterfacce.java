package testInterfacce;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainInterfacce {

	public static void main(String[] args) {

		ArrayList<Cosa> listaDiCose = new ArrayList<Cosa>();
		listaDiCose.add(new Cosa(2, "bbb"));
		listaDiCose.add(new Cosa(12, "aaa"));
		listaDiCose.add(new Cosa(66, "ccc"));
		listaDiCose.add(new Cosa(66, "ccc"));
		listaDiCose.add(new Cosa(66, "aaa"));
		listaDiCose.add(new Cosa(66, "bb"));
		listaDiCose.add(new Cosa(5, "cosetta"));
		
		ArrayList<Integer> interi = new ArrayList<Integer>();
		interi.add(135);
		interi.add(642);
		interi.add(334);
		interi.add(112);
		interi.add(86);
		interi.add(953);
		interi.add(134);
		
		Collections.sort(interi);
		
		 for (Integer i : interi) {
			System.out.println(i);
		}
		
		Collections.sort(listaDiCose);
		
		
		
		for (Cosa cosa : listaDiCose) {
			System.out.println(cosa.toString());
		}
	}

}
