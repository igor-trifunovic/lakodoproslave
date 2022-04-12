package classes;

import models.Admin;

import java.sql.*;
import java.util.*;

public class AdminDAO {
	
	String db = "jdbc:mysql://localhost:3306/lakodoproslave";
	String user = "root";
	String pass = "";
	
	Connection con;
	Statement stmt;
	
	public void createConnection() {
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			}
			con = DriverManager.getConnection(db, user, pass);
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("Greška u uspostavljanju konekcije sa bazom.");
			e.printStackTrace();
		}
	}
	
	public boolean insertAdmin(Admin admin) throws SQLException {
		createConnection();
		String queryUser = "INSERT INTO user(username, password, roleName) "
						 + "VALUES('" + admin.getUsername() + "','"
						 + admin.getPassword() + "','" + admin.getRoleName() + "')";
		if(!stmt.execute(queryUser)) {
			String queryAdmin = "INSERT INTO admin(name, email) "
							   + "VALUES('" + admin.getName() + "','" + admin.getEmail() + "')";
			if(!stmt.execute(queryAdmin)) {
				return true;
			}
		}
		
		return false;
	}
	
	public List<Admin> getAllAdmins() {
	
		ArrayList<Admin> admins = new ArrayList<Admin>();
		
		try {
			createConnection();
			Statement stmt = con.createStatement();
			String upit = "SELECT a.username, a.name, a.email "
						+ "FROM admin a JOIN user u ON a.username = u.username";
			ResultSet rs = stmt.executeQuery(upit);
			
			while (rs.next()) {
				admins.add(new Admin(
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("roleName"),
					rs.getString("name"),
					rs.getString("email")
				));
			}
		} catch (SQLException e) {
			System.out.println("Greška u uspostavljanju veze sa bazom.");
			e.printStackTrace();
		}
		
		return admins;
	}
	
}