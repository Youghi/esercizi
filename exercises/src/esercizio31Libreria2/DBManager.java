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
	
	public void viewAllAuthors() {
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_libreria", "SA", "");
			PreparedStatement preSt = conn.prepareStatement(
					"select * from author");
			ResultSet result = preSt.executeQuery();
			Author author = new Author();

			while (result.next()) {
				author.setAuthorId(result.getInt(1));
				author.setName(result.getString(2));
				author.setSurname(result.getString(3));

				author.getData();
			}
		} catch (SQLException e) {
			System.out.println("qualcosa è andato storto nella connessione! /viewAllAuthors");
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

	public void updateBookData(Book book, int ind) {

		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_libreria", "SA", "");
			PreparedStatement preSt;

			switch (ind) {
			case 1:
				preSt = conn.prepareStatement("UPDATE book SET NAME=? WHERE PK_BOOK_ID = ?;");
				preSt.setString(1, book.getName());
				preSt.setInt(2, book.getCode());

				preSt.execute();
				conn.commit();
				break;

			case 2:
				preSt = conn.prepareStatement("UPDATE book SET release_year=? WHERE PK_BOOK_ID = ?;");
				preSt.setInt(1, book.getReleaseYear());
				preSt.setInt(2, book.getCode());

				preSt.execute();
				conn.commit();
				break;

			case 3:
				preSt = conn.prepareStatement("UPDATE book SET fk_genre_id=? WHERE PK_BOOK_ID = ?;");
				preSt.setInt(1, book.genreId());
				preSt.setInt(2, book.getCode());

				preSt.execute();
				conn.commit();
				break;

			default:
				break;
			}
			System.out.println("I dati sono stati aggiornati nel database.");
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

	public void updateAuthorData(Author author, int ind) {

		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_libreria", "SA", "");
			PreparedStatement preSt;

			switch (ind) {
			case 1:
				preSt = conn.prepareStatement("UPDATE author SET NAME=? WHERE PK_AUTHOR_ID = ?;");
				preSt.setString(1, author.getName());
				preSt.setInt(2, author.getAuthorId());

				preSt.execute();
				conn.commit();
				break;

			case 2:
				preSt = conn.prepareStatement("UPDATE author SET SURNAME=? WHERE PK_AUTHOR_ID = ?;");
				preSt.setString(1, author.getSurname());
				preSt.setInt(2, author.getAuthorId());

				preSt.execute();
				conn.commit();
				break;

			default:
				break;
			}
			System.out.println("I dati sono stati aggiornati nel database.");
		} catch (SQLException e) {
			System.out.println("qualcosa è andato storto nella connessione! /updateAuthorData");
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

	public Book compileBookFromInd(int ind) {
		Book book = new Book(libreria);
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_libreria", "SA", "");
			PreparedStatement preSt = conn.prepareStatement("select book.pk_book_id, book.name, book.release_year, genre.type, author.pk_author_id, author.name, author.surname from book join author on book.fk_author_id=author.pk_author_id join genre on book.fk_genre_id=pk_genre_id where book.pk_book_id=?");
			preSt.setInt(1, ind);
			ResultSet result = preSt.executeQuery();
			while (result.next()) {
				book.setCode(result.getInt(1));
				book.setName(result.getString(2));
				book.setReleaseYear(result.getInt(3));
				book.setGenere(result.getString(4));
				book.getAuthor().setAuthorId(result.getInt(5));
				book.getAuthor().setName(result.getString(6));
				book.getAuthor().setSurname(result.getString(7));
			}
		} catch (SQLException e) {
			System.out.println("qualcosa è andato storto nella connessione! /compileBookFromInd");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return book;
	}
	
	public Author compileAuthorFromInd(int ind) {
		Author author = new Author(libreria);
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_libreria", "SA", "");
			PreparedStatement preSt = conn.prepareStatement("select * from author where pk_author_id=?");
			preSt.setInt(1, ind);
			ResultSet result = preSt.executeQuery();
			while (result.next()) {
				author.setAuthorId(result.getInt(1));
				author.setName(result.getString(2));
				author.setSurname(result.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("qualcosa è andato storto nella connessione! /compileBookFromInd");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return author;
	}
//
	public void deleteById(int id) {
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_libreria", "SA", "");
			PreparedStatement preSt = conn.prepareStatement("DELETE FROM book WHERE pk_book_id=?");
			preSt.setInt(1, id);
			preSt.execute();
			conn.commit();
			System.out.println("Libro eliminato dal database");
		} catch (SQLException e) {
			System.out.println("qualcosa è andato storto nella connessione! /deleteById");
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

	// if one of pk from book list == given code, metod returns true else returns
	// false
	public Boolean checkPk(int code, int ind) {
		Boolean check = false;
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_libreria", "SA", "");
			PreparedStatement preSt;
			ResultSet result;
			switch (ind) {
			case 1:
				preSt = conn.prepareStatement("select pk_book_id from book");
				result = preSt.executeQuery();
				while (result.next()) {
					int pk = result.getInt(1);
					if (pk == code) {
						check = true;
					}
				}
				break;

			case 2:
				preSt = conn.prepareStatement("select pk_author_id from author");
				result = preSt.executeQuery();
				while (result.next()) {
					int pk = result.getInt(1);
					if (pk == code) {
						check = true;
					}
				}
				break;

			default:
				break;
			}

		} catch (SQLException e) {
			System.out.println("qualcosa è andato storto nella connessione!/checkPk");
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
	
	

}
