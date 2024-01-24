package esercizio31Libreria;

public class Author {
	private String name;
	private String surname;

	private LibreriaSystem libreria;

	public Author(LibreriaSystem libreria) {
		this.libreria = libreria;
	}

	public void setData() {
		System.out.println("---Autore");
		this.name = libreria.readString("Nome:");
		this.surname = libreria.readString("Cognome:");
	}

	public void getData() {
		System.out.println("Autore: " + this.name + " " + this.surname);
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
	
	
}
