package esercizioRubrica;

public class Records {
	private LogicManager logic;
	private int id;
	private String name;
	private String surname;
	private int num;
	
	public Records() {
		}
	
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
