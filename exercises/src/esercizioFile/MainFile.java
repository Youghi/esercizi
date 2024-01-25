package esercizioFile;

import java.io.*;
import java.util.Scanner;

public class MainFile {

	public static void main(String[] args) {
		GestioneFile file1 = new GestioneFile("C:/Users/Windows/Desktop/datafile/Prova.txt");
		String daStampare = ("bla bla bla");
		Scanner userIn = new Scanner (System.in);
		try {
			file1.scriviFile(daStampare);
		} catch (IOException e) {
			System.out.println("qualcosa non va");
			e.printStackTrace();
		}

		// leggo file e mostro a video

		try {

			file1.leggiFile();

		} catch (IOException e) {
			System.out.println("qualcosa non va");
			e.printStackTrace();
		}
		
		System.out.println("cancellare? 1 si 2 no");
		int i = userIn.nextInt();
		if (i == 1) {
			try {
				file1.deleteFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("file cancellato");
		}
		
		

	}

}
