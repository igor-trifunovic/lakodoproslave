package classes;

import models.Client;

import java.sql.*;
import java.util.*;

public class ClientDAO {
	
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
	
	public boolean insertClient(Client client) throws SQLException {
		String queryUser = "INSERT INTO user(username, password, roleName) "
						 + "VALUES('" + client.getUsername() + "','"
						 + client.getPassword() + "','" + client.getRoleName() + "')";
		if (!stmt.execute(queryUser)) {
			String queryClient = "INSERT INTO client(username, name, email, phone) "
							   + "VALUES('" + client.getUsername() + "','" + client.getName() + "','" + client.getEmail() + "','" 
							   + client.getPhone() + "')";
			if(stmt.execute(queryClient)) {
				return false;
			}
		}
		return true;
	}
	
	public void updateClient(Client client) {
		try {
			createConnection();
			
			String updateQuery = "UPDATE client "
					+ "SET username = '" + client.getUsername() + "', "
					+ "name = '" + client.getName()+"', "
					+ "email = '" + client.getEmail() + "', "
					+ "phone = '" + client.getPhone() + "' "
					+ "WHERE username = '" + client.getUsername() + "'";
			stmt.executeUpdate(updateQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteClientByUserName(String username) {
		try {
			createConnection();
			String deleteUser = "DELETE FROM user WHERE username = '" + username + "'";
			String deleteClient = "DELETE FROM client WHERE client = '" + username + "'";
			stmt.executeUpdate(deleteUser);
			stmt.executeUpdate(deleteClient);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public Client getClientByUsername(String username) {
		Client client = null;
		try {
			createConnection();
			
			String upit = "SELECT c.username, password, roleName, name, email, phone "
						+ "FROM Client c JOIN User u on c.username = u.username "
						+ "WHERE c.username = '" + username + "'";
			ResultSet rs = stmt.executeQuery(upit);
			
			if(rs.next())
			{
				client = new Client(rs.getString("username"), 
						rs.getString("password"),
						rs.getString("roleName"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("phone")
				);		
			}
			
			return client;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
		return client;
	}
	
	public List<Client> getAllClients() {
		List<Client> allClients = new ArrayList<Client>();
		
		try {
			createConnection();
			String upit = "SELECT c.username, password, roleName, name, email, phone "
						+ "FROM client c JOIN user u ON c.username = u.username";
			ResultSet rs = stmt.executeQuery(upit);
			
			while(rs.next()) {
				allClients.add(new Client(
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("roleName"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("phone")
				));
			}
		} catch(SQLException e) {
			System.out.println("Greška u uspostavljanju konekcije sa bazom.");
			e.printStackTrace();
		}
		
		return allClients;
	}
	
	public boolean checkIfEmailExists(String email) throws Exception {
		
		createConnection();
		boolean exists = true;
		
		String upit = "SELECT * FROM client "
					+ "WHERE email = '" + email + "'";
		ResultSet rs = stmt.executeQuery(upit);
		
		if(rs.next()) {
			return exists;
		} else {
			return !exists;
		}
	}
}