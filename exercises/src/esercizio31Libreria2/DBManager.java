package esercizio31Libreria2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	private Connection conn = null;
	private LibreriaSystem libreria;

	public DBManager(LibreriaSystem libreria) {
		this.libreria = libreria;
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

	public void addNew(Book book) {
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_libreria", "SA", "");
			PreparedStatement preSt = conn.prepareStatement("insert into book (name, fk_author_id, fk_genre_id,release_year) values (?,?,?,?)");
			preSt.setString(1, book.getName());
			preSt.setInt(2, record.getSurname());
			preSt.setInt(3, book.genreId());
			preSt.setInt(3, book.getReleaseYear());

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

	}
	
	public void addAuthor(Author author) {
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_libreria", "SA", "");
			PreparedStatement preSt = conn.prepareStatement("insert into record(name, surname, num) values(?,?,?)");
			preSt.setString(1, record.getName());
			preSt.setString(2, record.getSurname());
			preSt.setLong(3, record.getNum());

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
				long num = result.getLong(4);

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

	public void updateRecord(Records record, int ind) {

		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_rubrica", "SA", "");
			PreparedStatement preSt;

			switch (ind) {
			case 1:
				preSt = conn.prepareStatement("UPDATE record SET name = ? WHERE id = ?;");
				preSt.setString(1, record.getName());
				preSt.setInt(2, record.getId());

				preSt.execute();
				conn.commit();
				break;

			case 2:
				preSt = conn.prepareStatement("UPDATE record SET surname = ? WHERE id = ?;");
				preSt.setString(1, record.getSurname());
				preSt.setInt(2, record.getId());

				preSt.execute();
				conn.commit();
				break;

			case 3:
				preSt = conn.prepareStatement("UPDATE record SET num = ? WHERE id = ?;");
				preSt.setLong(1, record.getNum());
				preSt.setInt(2, record.getId());

				preSt.execute();
				conn.commit();
				break;

			default:
				break;
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

	public void compileArray() {
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_rubrica", "SA", "");
			PreparedStatement preSt = conn.prepareStatement("select * from record");
			ResultSet result = preSt.executeQuery();
			while (result.next()) {
				Records record = new Records(logic);
				record.setId(result.getInt(1));
				record.setName(result.getString(2));
				record.setSurname(result.getString(3));
				record.setNum(result.getLong(4));
				logic.records.add(record);
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

	public void deleteById(int id) {
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_rubrica", "SA", "");
			PreparedStatement preSt = conn.prepareStatement("DELETE FROM record WHERE id=?");
			preSt.setInt(1, id);
			preSt.execute();
			conn.commit();
			System.out.println("Contatto eliminato dal database");
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
