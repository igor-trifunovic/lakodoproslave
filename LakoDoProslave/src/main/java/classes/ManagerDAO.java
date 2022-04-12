package classes;

import models.Manager;

import java.sql.*;
import java.util.*;

public class ManagerDAO {
	
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
			Connection con = DriverManager.getConnection(db, user, pass);
			stmt = con.createStatement();
			System.out.println("Uspostavljanje konekcije sa bazom - " + con);
		} catch (SQLException e) {
			System.out.println("Greška u uspostavljanju konekcije sa bazom.");
			e.printStackTrace();
		}
	}
	
	public boolean insertManager(Manager manager) throws SQLException {
		createConnection();
		String queryUser = "INSERT INTO user(username, password, roleName) "
						 + "VALUES('" + manager.getUsername() + "','"
						 + manager.getPassword() + "','" + manager.getRoleName() + "')";
		if (!stmt.execute(queryUser)) {
			String queryManager = "INSERT INTO manager(username, name, email, phone, agencyID) "
							   + "VALUES('" + manager.getUsername() + "','" + manager.getName() + "','" + manager.getEmail() + "','" 
							   + manager.getPhone() + "','" + manager.getAgencyID() + "')";
			if(!stmt.execute(queryManager)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void updateManager(Manager manager) {
		try {
			createConnection();
			
			stmt.executeUpdate("UPDATE manager "
					+ "SET username = '" + manager.getUsername()+"', "
					+ "name = '" + manager.getName()+"', "
					+ "email = '" + manager.getEmail() + "', "
					+ "phone = '" + manager.getPhone() + "', "
					+ "agencyID = '" + manager.getAgencyID() + "'"
					+ " WHERE username = '" + manager.getUsername() + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Manager getManagerByUsername(String user)
	{
		Manager manager = null;
		try {
			createConnection();
			
			String upit = "SELECT m.username, password, roleName, name, email, phone, agencyID "
						+ "FROM Manager m JOIN User u on m.username = u.username "
						+ "WHERE m.username = '" + user + "'";
			ResultSet rs = stmt.executeQuery(upit);
			
			if(rs.next())
			{
				manager = new Manager(rs.getString("username"), 
						rs.getString("password"),
						rs.getString("roleName"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("phone"),
						rs.getInt("agencyID")
				);		
			}
			
			return manager;
			
		} catch (Exception e) {
			e.printStackTrace();
			return manager;
		}
	}
	
	public void deleteManagerByUsername(String username) {
		try {
			createConnection();
			String deleteUser = "DELETE FROM user WHERE username='" + username + "'";
			String deleteManager = "DELETE FROM manager WHERE username='" + username + "'";
			stmt.executeUpdate(deleteUser);
			stmt.executeUpdate(deleteManager);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Manager> getAllManagers() {
		List<Manager> managers = new ArrayList<Manager>();
		
		try {
			createConnection();
			String upit = "SELECT m.username, password, roleName, name, email, phone, agencyID "
						+ "FROM manager m JOIN user u ON m.username = u.username";
			ResultSet rs = stmt.executeQuery(upit);
			
			while (rs.next()) {
				managers.add(new Manager(
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("roleName"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("phone"),
						rs.getInt("agencyID")
				));
			}
			
			return managers;
		} catch (SQLException e) {
			System.out.println("Greška u uspostavljanju veze sa bazom.");
			e.printStackTrace();
			return null;
		}
	}
	
}