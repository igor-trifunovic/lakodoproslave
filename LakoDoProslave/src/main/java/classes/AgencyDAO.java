package classes;

import models.Agency;

import java.sql.*;
import java.util.*;

public class AgencyDAO {
	
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
			System.out.println("Uspostavljanje konekcije sa bazom - " + con);
		} catch (SQLException e) {
			System.out.println("Greška u uspostavljanju konekcije sa bazom.");
			e.printStackTrace();
		}
	}
	
	public Agency getAgencyByAgencyId(String agencyID) {
		Agency agency = null;
		
		try {
			createConnection();
			
			String agencyQuery = "SELECT * FROM agency where agencyID = '" + agencyID + "'";
			ResultSet rs = stmt.executeQuery(agencyQuery);
			
			if(rs.next()) {
				agency = new Agency(
					rs.getInt("agencyID"), 
					rs.getString("name"),
					rs.getString("city"), 
					rs.getString("address"),
					rs.getString("phone"),
					rs.getString("image"),
					rs.getString("about"),
					rs.getInt("programmeID")
			);}
			
			return agency;
			
		} catch (Exception e) {
			e.printStackTrace();
			return agency;
		}
	}
	
	public void updateAgency(Agency agency) {
		try {
			createConnection();
			String updateAgencyQuery = "UPDATE agency "
					+ "SET username = '" + agency.getAgencyID() + "', "
					+ "name = '" + agency.getName() + "', "
					+ "email = '" + agency.getCity() + "', "
					+ "phone = '" + agency.getAddress() + "', "
					+ "points = '" + agency.getPhone() + "', "
					+ "about = " + agency.getAbout() + "', "
					+ "programmeID = " + agency.getProgrammeID() + "', "
					+ "WHERE agencyID = '" + agency.getAgencyID() + "'";
			stmt.executeUpdate(updateAgencyQuery);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void deleteAgencyByID(int agencyID) {
		try {
			createConnection();
			String deleteAgency = "DELETE FROM agency WHERE agencyID = '" + agencyID + "'";
			stmt.executeQuery(deleteAgency);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public List<Agency> getAllAgencies() {
		List<Agency> agencije = new ArrayList<Agency>();
		
		try {
			createConnection();
			String upit = "SELECT * FROM Agency";
			ResultSet rs = stmt.executeQuery(upit);

			while(rs.next()) {
				agencije.add(new Agency(
						rs.getInt("agencyID"),
						rs.getString("name"),
						rs.getString("city"),
						rs.getString("address"),
						rs.getString("phone"),
						rs.getString("image"),
						rs.getString("about"),
						rs.getInt("programmeID")
				));
			}
		} catch (SQLException e) {
			System.out.println("Greška u uspostavljanju veze sa bazom.");
			e.printStackTrace();
		}
		return agencije;
	}
	
}