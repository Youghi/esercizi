package webApp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	public Connection conn = null;
	
	
	
	
	
	public int queryToInt(String query) {
		int num= -1;
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_scuola", "SA", "");
			PreparedStatement preSt = conn.prepareStatement(query);
			ResultSet result = preSt.executeQuery();
			num = result.getInt(1);

		} catch (SQLException e) {
			System.out.println("qualcosa è andato storto nella connessione!/ query to int");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return num;
	}
	
	public void addObj(PreparedStatement preSt) {
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/server_scuola", "SA", "");
			preSt.execute();
			conn.commit();
			
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
	
}
