package esercizio31Libreria;

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
		this.name = libreria.readLine("Inserire nome libro:");
		setYear();
		selectGenre();
		System.out.println("Inserire");
		author.setData();

	}

	public void getData() {
		System.out.println("Titolo: " + name + "\n" + "Anno edizione: " + releaseYear + "\n" + "Genere: " + genere);
		author.getData();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public genre getGenere() {
		return genere;
	}

	private void setYear() {
		setReleaseYear(libreria.readInt("Inserire anno dell'edizione:"));
	}

	public void setGenere(String gen) throws IllegalArgumentException {
		this.genere = genre.valueOf(gen);
	}

	public void selectGenre() {
		System.out.println("Scegliere genere:");
		for (genre gen : genre.values()) {
			System.out.println(gen);
		}
		Boolean check = false;
		while (!check) {
			try {
				String gen = libreria.readString("");
				setGenere(gen);
				check = true;
			} catch (IllegalArgumentException e) {
				System.out.println("genere errato, riprovare:");
				check = false;
			}

		}
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	

}
