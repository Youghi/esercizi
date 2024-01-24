package esercizio31Libreria;

import esercizio31Libreria.GenreEnum.genre;

public class Book {
	private String name;
	private int releaseYear;
	private genre genere;
	private LibreriaSystem libreria;
	private Author author = new Author(libreria);

	public Book(LibreriaSystem libreria) {
		this.libreria = libreria;
	}

	public void setData() {
		this.name = libreria.readString("Inserire nome libro:");
		System.out.println("Inserire");
		author.setData();
		System.out.println("Scegliere genere:");
		for (genre gen : genre.values()) {
			System.out.println(gen);
		}
		genere = genre.valueOf(libreria.readString(""));

	}

}
