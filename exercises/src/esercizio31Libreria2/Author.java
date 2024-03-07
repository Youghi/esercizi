package esercizio31Libreria2;

public class Author {
	private int authorId;
	private String name;
	private String surname;

	private LibreriaSystem libreria;

	public Author(LibreriaSystem libreria) {
		this.libreria = libreria;
	}
	
	public Author() {
		
	};

	public void setData() {
		System.out.println("---Autore");
		this.name = libreria.readString("Nome:");
		this.surname = libreria.readString("Cognome:");
		if (libreria.dbm.checkForAuthor(this)) {
			libreria.dbm.addNewAuthor(this);
		}
		this.authorId = libreria.dbm.getAuthorPk(this);
	}

	public void getData() {
		System.out.println("Autore: " + this.name + " " + this.surname);
		System.out.println("");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public void modifyAuthor () {
		Boolean check = true;
		while (check) {
			int ind = libreria.readInt(("Operazioni disponibili: " + "\n" + "1 - Modificare nome dell'autore" + "\n"
					+ "2 - Modificare cognome dell'autore:" + "\n" + "0 - uscire"));
			switch (ind) {
			case 1:
				System.out.println("Nome da modificare: " + this.name);
				setName(libreria.readLine("Inserire un nuovo nome: "));
				break;

			case 2:
				System.out.println("Cognome da modificare: " + this.surname);
				setSurname(libreria.readLine("Inserire un nuovo cognome: "));
				break;

			case 0:
				check = false;
				break;
			}
		}
	}
	
	
}
