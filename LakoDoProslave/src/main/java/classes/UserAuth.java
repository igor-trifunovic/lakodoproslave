package classes;

import java.sql.*;
import models.User;

public class UserAuth {
	
	String db = "jdbc:mysql://localhost:3306/lakodoproslave";
	String userdb = "root";
	String pass = "";
	
	Connection con;
	Statement stmt;
	
	public void createConnection() throws Exception {
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			}
			con = DriverManager.getConnection(db, userdb, pass);
			stmt = con.createStatement();
			System.out.println("Uspostavljanje konekcije sa bazom - " + con);
		} catch (SQLException e) {
			System.out.println("Greška u uspostavljanju konekcije sa bazom, proverite ulazne parametre.");
			e.printStackTrace();
		}
	}
	
	public User authenticateUser(String username, String password) throws Exception {
		
		createConnection();
		
		User user = null;
		
		String upit = "SELECT * FROM user "
					+ "WHERE username = '" + username + "' "
					+ "AND password = '" + password + "'";
		ResultSet rs = stmt.executeQuery(upit);
		
		if (rs.next()) {
			user = new User(rs.getString("username"), 
							rs.getString("password"), 
							rs.getString("roleName"));
		}
		
		return user;
	}
	
	public boolean checkIfUsernameExists(String username) throws Exception {
		
		createConnection();
		boolean exists = true;
		
		String upit = "SELECT * FROM user "
					+ "WHERE username = '" + username + "'";
		ResultSet rs = stmt.executeQuery(upit);
		
		if(rs.next()) {
			return exists;
		}
		
		return !exists;
	}
}