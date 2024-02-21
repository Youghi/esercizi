package esercizioRubrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBManager {
	private Connection conn = null;

	public DBManager() {
	}

	public void init() {
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			System.out.println("Connessione al Data Base stabilita");
		} catch (Exception e) {
			System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
			return;
		}
	}

	public int addNew(Records record) {
		try {

			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_rubrica", "SA", "");
			PreparedStatement preSt = conn.prepareStatement("insert into record(name, surname, num) values(?,?,?)");
			preSt.setString(1, record.getName());
			preSt.setString(2, record.getSurname());
			preSt.setInt(3, record.getNum());

			preSt.execute();
			conn.commit();
			System.out.println("Contatto inserito nel database");
		} catch (SQLException e) {

			System.out.println("qualcosa è andato storto nella connessione!");

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return returnLastId();
	}
	
	public void viewAllRecords() {
		
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_rubrica", "SA", "");
			PreparedStatement preSt = conn.prepareStatement("select * from record");
			ResultSet result = preSt.executeQuery();
			while (result.next()) {
				
				int id = result.getInt(1);
				String name = result.getString(2);
				String surName = result.getString(3);
				int num = result.getInt(4);
				
				System.out.println("------ Contatto n° " + id);
				System.out.println("Nome: " + name + "\n" + "Cognome: " + surName + "\n" + "Numero telefono: " + num);
				System.out.println("");
			}

		} catch (SQLException e) {
			System.out.println("qualcosa è andato storto nella connessione!");
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
	
	public ArrayList<Records> compileArray(ArrayList<Records> records) {
		
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_rubrica", "SA", "");
			PreparedStatement preSt = conn.prepareStatement("select * from record");
			ResultSet result = preSt.executeQuery();
			while (result.next()) {
				Records record = new Records();
				int id = result.getInt(1);
				String name = result.getString(2);
				String surName = result.getString(3);
				int num = result.getInt(4);
				
				System.out.println("------ Contatto n° " + id);
				System.out.println("Nome: " + name + "\n" + "Cognome: " + surName + "\n" + "Numero telefono: " + num);
				System.out.println("");
			}

		} catch (SQLException e) {
			System.out.println("qualcosa è andato storto nella connessione!");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return records;
	}

	public int returnLastId() {
		int id = 0;
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_rubrica", "SA", "");
			PreparedStatement preSt = conn.prepareStatement("CALL IDENTITY()");
			ResultSet result = preSt.executeQuery();
			id = result.getInt(1);

		} catch (SQLException e) {
			System.out.println("qualcosa è andato storto nella connessione!");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return id;
	}

}
