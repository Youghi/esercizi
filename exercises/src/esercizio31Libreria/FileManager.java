package esercizio31Libreria;

import java.io.*;

import esercizio31Libreria.GenreEnum.genre;

public class FileManager {
	File file;
	private LibreriaSystem libreria;
	private String fileName = "dataLibreria.txt";
	private String fileRoot;
	
	public FileManager(LibreriaSystem libreria, String fileRoot) {
		this.libreria = libreria;
		this.fileRoot = fileRoot;
		this.file = new File(fileRoot + fileName);
	}
	
	public void writeFile () throws IOException {
		file.createNewFile();
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		for (Book book : libreria.books) {
			bw.write("check" + "\n");
			bw.write(book.getCode() + "\n");
			bw.write(book.getName() + "\n");
			bw.write(book.getReleaseYear() + "\n");
			bw.write(book.getGenere().toString() + "\n");
			bw.write(book.getAuthor().getName() + "\n");
			bw.write(book.getAuthor().getSurname() + "\n");
			bw.flush();
		}
		bw.close();
		System.out.println("I dati sono stati salvati.");
	}
	
	public void readLibraryData () throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while (line!=null) {
			Book book = new Book(libreria);
			book.setCode(Integer.parseInt(br.readLine()));
			book.setName(br.readLine());
			book.setReleaseYear(Integer.parseInt(br.readLine()));
			book.setGenere(br.readLine());
			book.getAuthor().setName(br.readLine());
			book.getAuthor().setSurname(br.readLine());
			libreria.books.add(book);
			line = br.readLine();
		}
		br.close();
		System.out.println("I dati sono stati caricati!");
//		Integer.parseInt(Stringa);
	}
	
	
	
	
	public void deleteFile () throws IOException {
		file.delete();
		System.out.println("File vecchio cancellato.");
	}
	

	
	
	
	
	
	
	
	
	
}
