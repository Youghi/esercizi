package esercizioFile;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class GestioneFile {
	File file;
	
	public GestioneFile (String nomeFile) {
		this.file = new File(nomeFile);
	}
	
	
	public void scriviFile (String text) throws IOException{
		FileWriter fw = new FileWriter(file, true);
		fw.append(text + "\n");
		fw.close();
	}
	
	public void leggiFile () throws IOException {
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
			while (linea != null) {
				System.out.println(linea + "\n");
				linea = br.readLine();
			}
			br.close();
	}
	
	public void deleteLine () throws IOException {
		
	}
	
	public void deleteFile () throws IOException {
		file.delete();
	}
	
	
	
}
