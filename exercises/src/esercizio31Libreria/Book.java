package esercizio31Libreria;

import java.io.IOException;

import esercizio31Libreria.GenreEnum.genre;

public class Book {
	private String name;
	private int releaseYear;
	private genre genere;
	private LibreriaSystem libreria;
	private Author author;

	public Book(LibreriaSystem libreria) {
		this.libreria = libreria;
		this.author = new Author(libreria);
	}

	
	
	public void setData() {
		this.name = libreria.readString("Inserire nome libro:");
		this.releaseYear = libreria.readInt("Inserire anno dell'edizione:");
		System.out.println("Inserire");
		author.setData();
		System.out.println("Scegliere genere:");
		for (genre gen : genre.values()) {
			System.out.println(gen);
		}
		try {
			genere = genre.valueOf(libreria.readString(""));			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}
	
	public void getData() {
		System.out.println("Titolo: " + name + "\n" + "Anno edizione: " + releaseYear + "\n" + "Genere: " + genere);
		author.getData();
	}

}
