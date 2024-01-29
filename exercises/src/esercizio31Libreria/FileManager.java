package esercizio31Libreria;

import java.io.*;

import esercizio31Libreria.GenreEnum.genre;

public class FileManager {
	File file;
	private LibreriaSystem libreria;
	private String fileName = "data.txt";
//	private String fileRoot;
	
	public FileManager(LibreriaSystem libreria) {
		this.file = new File(fileName);
		this.libreria = libreria;
//		this.fileRoot = fileRoot;
	}
	
	public void writeFile () throws IOException {
		file.createNewFile();
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		for (Book book : libreria.books) {
			bw.write(book.getCode() + "\n");
			bw.write(book.getName() + "\n");
			bw.write(book.getReleaseYear() + "\n");
			bw.write(book.getGenere().toString() + "\n");
			bw.write(book.getAuthor().getName() + "\n");
			bw.write(book.getAuthor().getSurname() + "\n");
			bw.flush();
		}
		bw.close();
	}
	

	
	
	
	
	
	
	
	
	
}
