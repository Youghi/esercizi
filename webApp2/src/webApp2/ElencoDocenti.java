package webApp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ElencoDocenti {

	ArrayList<Docente> listaDocenti = new ArrayList<Docente>();

	public ElencoDocenti() {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_scuola", "SA", "");
			PreparedStatement preSt = conn.prepareStatement("select * from docente");
			ResultSet rs = preSt.executeQuery();

			while (rs.next()) {
				listaDocenti.add(new Docente(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

		} catch (SQLException e) {
			System.out.println("qualcosa è andato storto nella connessione al DB!");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public ArrayList<Docente> getListaDocenti() {
		return listaDocenti;
	}

	public Docente getDocenteById(int id) {
		for (Docente docente : listaDocenti) {
			if (docente.getId() == id) {
				return docente;
			}
		}
		return null;
	}

	public void addDocente(Docente d) {
		listaDocenti.add(d);
	}

}
