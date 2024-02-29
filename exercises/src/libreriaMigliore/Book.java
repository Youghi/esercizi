package libreriaMigliore;


public class Book {
	private int code;
	private String name;
	private int releaseYear;
	private LibreriaSystem libreria;
	private Author author;
	private Genre genre;
	
	

	public Book(LibreriaSystem libreria) {
		this.libreria = libreria;
		this.author = new Author(libreria);
	}



	public Book(LibreriaSystem libreria, int code) {
		this.code = code;
		this.libreria = libreria;
		this.author = new Author(libreria);
	}

	
	
	public void setData() {
		this.name = libreria.readLine("Inserire titolo del libro:");
		setYear();
//		selectGenre();
		System.out.println("Inserire");
		author.setData();

	}

	public void getData() {
		System.out.println("------ Libro n° " + this.code);
		System.out.println("Titolo: " + name + "\n" + "Anno edizione: " + releaseYear + "\n" + "Genere: " + genre);
		author.getData();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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

	
	public Genre getGenre() {
		return genre;
	}


	private void setYear() {
		setReleaseYear(libreria.readInt("Inserire anno dell'edizione:"));
	}

	public void setGenere(String gen) {
		this.genre = Genre.valueOf(gen);
	}

	public void selectGenre() {
		System.out.println("Scegliere genere:");
		for (Genre gen : Genre.values()) {
			System.out.println(gen);
		}
		Boolean check = false;
		while (!check) {
			try {
				String gen = libreria.readString("").toUpperCase();
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
			int ind = libreria.readInt(("Operazioni disponibili: " + "\n" + "1 - Modificare titolo libro" + "\n"
					+ "2 - Modificare anno dell'edizione:" + "\n" + "3 - Modificare genere" + "\n"
					+ "4 - Modificare autore" + "\n" + "0 - uscire"));
			switch (ind) {
			case 1:
				System.out.println("Titolo da modificare: " + this.name);
				setName(libreria.readLine("Inserire un nuovo titolo: "));
				break;

			case 2:
				System.out.println("Anno dell'edizione da modificare: " + this.releaseYear);
				setReleaseYear(libreria.readInt("Inserire nuovo anno dell'edizione:"));
				break;

			case 3:
				System.out.println("Genere da modificare: " + this.genre);
				selectGenre();
				break;

			case 4:
				this.author.modifyAuthor();
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
