package classes;

import java.sql.*;
import java.util.*;
import models.Programme;
import models.Agency;

public class ProgrammeDAO {
	
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
	
	public void insert(Programme programme) {
		try {
			createConnection();

			stmt.executeUpdate(
					"INSERT INTO programme(programmeID, gameRoom, animator, disco, drinks, food) "
							+ "VALUES " + "('" + programme.getProgrammeID() + "','" 
							+ programme.getGameRoom() + "','" 
							+ programme.getAnimator() + "','" 
							+ programme.getDisco() + "','" 
							+ programme.getDrinks() + "','" 
							+ programme.getFood() + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Programme getByProgrammeID(String programmeID) throws SQLException {
		try {
			createConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Programme p = null;
		String programmeQuery = "SELECT * from programme where programmeID = '" + programmeID + "'";
		ResultSet rs = stmt.executeQuery(programmeQuery);

		while (rs.next()) {
			p = new Programme(
					rs.getInt("programmeID"), 
					rs.getInt("gameRoom"),
					rs.getInt("animator"), 
					rs.getInt("disco"), 
					rs.getInt("drinks"),
					rs.getInt("food")
			);		
		}
		
		return p;
	}
		
	public List<Programme> getAllProgrammes() {
		List<Programme> allProgrammes = new ArrayList<Programme>();
		
		try {
			createConnection();
			String upit = "SELECT * FROM Programme";
			ResultSet rs = stmt.executeQuery(upit);
			while(rs.next()) {
				allProgrammes.add(new Programme(
							rs.getInt("programmeID"),
							rs.getInt("gameRoom"),
							rs.getInt("animator"),
							rs.getInt("disco"),
							rs.getInt("drinks"),
							rs.getInt("food")
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allProgrammes;
	}
	
	public Programme getProgrammeByAgencyID(Agency agency) {
		Programme programme = null;
		
		try {
			createConnection();
			String upit = "SELECT * FROM Programme p "
						+ "JOIN Agency a "
						+ "ON p.programmeID = a.programmeID "
						+ "WHERE p.programmeID =" + agency.getProgrammeID();
			ResultSet rs = stmt.executeQuery(upit);
			
			while(rs.next()) {
				programme = new Programme(
							rs.getInt("programmeID"),
							rs.getInt("gameRoom"),
							rs.getInt("animator"),
							rs.getInt("disco"),
							rs.getInt("drinks"),
							rs.getInt("food")
						);
			}
			
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return programme;
	}
	
	public void updateProgramme(Programme programme) {
		try {
			createConnection();

			stmt.executeUpdate("UPDATE programme SET "
					+ "osnovni='" + programme.getGameRoom() + "',"
					+ "gaziraniSok='" + programme.getAnimator() + "',"
					+ "negaziraniSok='" + programme.getDisco() + "',"
					+ "klovn='" + programme.getDrinks() + "',"
					+ "diskoteka='" + programme.getFood()+"',"
					+ " WHERE ponudaID='" + programme.getProgrammeID());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}