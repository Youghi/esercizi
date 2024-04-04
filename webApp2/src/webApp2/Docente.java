package webApp2;

import java.util.ArrayList;

public class Docente extends DBManager {
	ArrayList<ElaboraStatement> operazioniSt = new ArrayList<ElaboraStatement>();
	
	private int id;
	private String fName;
	private String lName;
	public Docente(int id, String fName, String lName) {
		super();
		this.fName = fName;
		this.lName = lName;
		addObj(null);
		this.id = queryToInt("CALL IDENTITY()");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	
public void compilaStatements() {
	operazioniSt.add(prepSt) -> {
				prepSt.setString(1, fName);
				prepSt.setString(2, lName);
	};
}	
	
	
}
