package esercizioRubrica;

public class Records {
	private LogicManager logic;
	private int id;
	private String name;
	private String surname;
	private int num;

	public Records(LogicManager logic) {
		this.logic = logic;
	}

	public void getData() {
		System.out.println("------ Contatto n° " + this.id);
		System.out.println("Nome: " + name + "\n" + "Cognome: " + surname + "\n" + "Numero telefono: " + num);
	}

	public void setData() {
		setName(logic.readString("Inserire nome del contatto:"));
		setSurname(logic.readString("Inserire cognome del contatto:"));
		setNum(logic.readInt("Inserire numero telefonico:"));
	}

	public void modifyData() {
		Boolean check = true;
		while (check) {
			int ind = logic.readInt(("Operazioni disponibili: " + "\n" + "1 - Modificare nome del contatto" + "\n"
					+ "2 - Modificare cognome del contatto:" + "\n" + "3 - Modificare numero di telefono del contatto"
					+ "\n" + "0 - uscire"));
			switch (ind) {
			case 1:
				System.out.println("Nome da modificare: " + this.name);
				setName(logic.readLine("Inserire un nuovo nome: "));
				logic.dbManager.updateRecord(this, ind);
				break;

			case 2:
				System.out.println("Cognome da modificare: " + this.surname);
				setSurname(logic.readLine("Inserire nuovo cognome:"));
				logic.dbManager.updateRecord(this, ind);
				break;

			case 3:
				System.out.println("Numero telefonicco da modificare: " + this.num);
				setNum(logic.readInt("Inserire un nuovo numero:"));
				logic.dbManager.updateRecord(this, ind);
				break;

			case 0:
				check = false;
				break;
			}
			System.out.println("");
			System.out.println("");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
