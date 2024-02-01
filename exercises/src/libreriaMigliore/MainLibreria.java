package libreriaMigliore;
import java.util.ArrayList;

import javax.swing.*;
public class MainLibreria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> x = new ArrayList<String>();
		ArrayList<String> z = new ArrayList<String>();
		z.add("blabla");
		x.add("blablaaaa");
		ArrayList<ArrayList<String>> y = new ArrayList<ArrayList<String>>();
		y.add(x);
		y.add(z);
		System.out.println(y.get(0).get(0) + "\n" + y.get(1).get(0));
	}

}
