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

	public void addNewBook(Book book) {
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_libreria", "SA", "");
			PreparedStatement preSt = conn.prepareStatement(
					"insert into book (name, fk_author_id, fk_genre_id, release_year) values (?, ?, ?, ?)");
			preSt.setString(1, book.getName());
			preSt.setInt(2, book.getAuthor().getAuthorId());
			preSt.setInt(3, book.genreId());
			preSt.setInt(4, book.getReleaseYear());

			preSt.execute();
			conn.commit();
			System.out.println("Libro inserito nel database");
		} catch (SQLException e) {
			System.out.println("qualcosa è andato storto nella connessione!/addNewBook");
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

	public void addNewAuthor(Author author) {
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_libreria", "SA", "");
			PreparedStatement preSt = conn.prepareStatement("insert into author(name, surname) values(?,?)");
			preSt.setString(1, author.getName());
			preSt.setString(2, author.getSurname());

			preSt.execute();
			conn.commit();
			System.out.println("Nuovo autore inserito nel database");
		} catch (SQLException e) {
			System.out.println("qualcosa è andato storto nella connessione!/addNewAuthor");
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

	public void viewAllBooks() {
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_libreria", "SA", "");
			PreparedStatement preSt = conn.prepareStatement(
					"select book.pk_book_id, book.name, book.release_year, author.pk_author_id, author.name, author.surname, genre.type from book join author on book.fk_author_id=author.pk_author_id join genre on book.fk_genre_id=pk_genre_id order by book.pk_book_id");
			ResultSet result = preSt.executeQuery();
			Book book = new Book();

			while (result.next()) {
				book.setCode(result.getInt(1));
				book.setName(result.getString(2));
				book.setReleaseYear(result.getInt(3));
				book.getAuthor().setAuthorId(result.getInt(4));
				book.getAuthor().setName(result.getString(5));
				book.getAuthor().setSurname(result.getString(6));
				book.setGenere(result.getString(7));
				book.getData();
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

//	public void updateRecord(Records record, int ind) {
//
//		try {
//			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_rubrica", "SA", "");
//			PreparedStatement preSt;
//
//			switch (ind) {
//			case 1:
//				preSt = conn.prepareStatement("UPDATE record SET name = ? WHERE id = ?;");
//				preSt.setString(1, record.getName());
//				preSt.setInt(2, record.getId());
//
//				preSt.execute();
//				conn.commit();
//				break;
//
//			case 2:
//				preSt = conn.prepareStatement("UPDATE record SET surname = ? WHERE id = ?;");
//				preSt.setString(1, record.getSurname());
//				preSt.setInt(2, record.getId());
//
//				preSt.execute();
//				conn.commit();
//				break;
//
//			case 3:
//				preSt = conn.prepareStatement("UPDATE record SET num = ? WHERE id = ?;");
//				preSt.setLong(1, record.getNum());
//				preSt.setInt(2, record.getId());
//
//				preSt.execute();
//				conn.commit();
//				break;
//
//			default:
//				break;
//			}
//		} catch (SQLException e) {
//			System.out.println("qualcosa è andato storto nella connessione!");
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//	}
//
	//DA RIFARE CON LA QUERY CHE RICEVE PK_BOOK_ID!!!! NON SERVE COMPILARE TUTTA LA ARRAY!!!
	public void compileBookArray() {
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_rubrica", "SA", "");
			PreparedStatement preSt = conn.prepareStatement(
					"select book.pk_book_id, book.name, book.release_year, genre.type, author.pk_author_id, author.name, author.surname from book join author on book.fk_author_id=author.pk_author_id join genre on book.fk_genre_id=pk_genre_id order by book.pk_book_id");
			ResultSet result = preSt.executeQuery();
			while (result.next()) {
				Book book = new Book(libreria);
				book.setCode(result.getInt(1));
				book.setName(result.getString(2));
				book.setReleaseYear(result.getInt(3));
				book.setGenere(result.getString(4));
				book.getAuthor().setAuthorId(result.getInt(5));
				
				libreria.books.add(book);
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
//
//	public void deleteById(int id) {
//		try {
//			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_rubrica", "SA", "");
//			PreparedStatement preSt = conn.prepareStatement("DELETE FROM record WHERE id=?");
//			preSt.setInt(1, id);
//			preSt.execute();
//			conn.commit();
//			System.out.println("Contatto eliminato dal database");
//		} catch (SQLException e) {
//			System.out.println("qualcosa è andato storto nella connessione!");
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//	}
//
//	public int returnLastId() {
//		int id = 0;
//		try {
//			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_rubrica", "SA", "");
//			PreparedStatement preSt = conn.prepareStatement("CALL IDENTITY()");
//			ResultSet result = preSt.executeQuery();
//			id = result.getInt(1);
//
//		} catch (SQLException e) {
//			System.out.println("qualcosa è andato storto nella connessione!");
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return id;
//	}

	// controllo se l'autore è presente in database dati nome e cognome
	public Boolean checkForAuthor(Author author) {
		Boolean check = false;
		int count = 0;
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_libreria", "SA", "");
			PreparedStatement preSt = conn
					.prepareStatement("select count(*) from AUTHOR where NAME = ? and SURNAME = ? ");
			preSt.setString(1, author.getName());
			preSt.setString(2, author.getSurname());
			ResultSet result = preSt.executeQuery();
			result.next();
			count = result.getInt(1);
			if (count == 0) {
				check = true;
			}

		} catch (SQLException e) {
			System.out.println("qualcosa è andato storto nella connessione!/checkForAuthor");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return check;
	}

	// metodo che torna la pk dell'autore per usi successivi
	public int getAuthorPk(Author author) {
		int pk = 0;
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_libreria", "SA", "");
			PreparedStatement preSt = conn
					.prepareStatement("select pk_author_id from AUTHOR where NAME = ? and SURNAME = ? ");
			preSt.setString(1, author.getName());
			preSt.setString(2, author.getSurname());
			ResultSet result = preSt.executeQuery();
			while (result.next()) {
				pk = result.getInt(1);
			}

		} catch (SQLException e) {
			System.out.println("qualcosa è andato storto nella connessione!/getAuthorPk");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return pk;
	}

}
