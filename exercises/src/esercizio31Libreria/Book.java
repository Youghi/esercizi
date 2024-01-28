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

	public void modifyData() {
		Boolean check = true;
		while (check) {
			int ind = libreria.readInt(("Operazioni disponibili: " + "\n" + "1 - Modificare nome libro" + "\n"
					+ "2 - Modificare anno dell'edizione:" + "\n" + "3 - Modificare genere" + "\n"
					+ "4 - Modificare autore" + "\n" + "5 - Elimina un libro" + "\n" + "0 - uscire"));
			switch (ind) {
			case 1:

				break;

			case 2:

				break;

			case 3:

				break;

			case 4:

				break;

			case 5:

				break;

			case 0:
				check = false;
				break;
			}
			System.out.println("");
			System.out.println("");
		}
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	

}
