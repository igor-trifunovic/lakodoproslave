package classes;

import models.Reservation;
import java.sql.*;
import java.util.*;

public class ReservationDAO {
	
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
	
	public boolean insert(Reservation reservation) throws SQLException {
		try {
			createConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String insertReservation = "INSERT INTO reservation(name, phone, email, date, "
				+ "start_time, end_time, gameRoom, animator, disco, drinks, food, agencyID) "
				+ "VALUES('" + reservation.getName() + "', '" + reservation.getPhone()+"', '" + reservation.getEmail() + "', '"
				+ reservation.getDate() + "', '" + reservation.getStartTime() + "', '"
				+ reservation.getEndTime() + "', '" + reservation.getGameRoom() + "', '"
				+ reservation.getAnimator() + "', '" + reservation.getDisco() + "', '" + reservation.getDrinks() + "', '"
				+ reservation.getFood() + "', '" + reservation.getAgencyID() + "'";

		if(!stmt.execute(insertReservation)) {
			return false;
		}
		return true;
	}
	
	public List<Reservation> getByUsername(String name) {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();

		try {
			createConnection();
			String resQuery = "SELECT * FROM reservation WHERE name='" + name + "'";
			ResultSet rs = stmt.executeQuery(resQuery);

			while (rs.next()) {
				reservations.add(new Reservation(rs.getInt("reservationID"), rs.getString("name"),
						rs.getString("phone"), rs.getString("email"),
						rs.getString("date"), rs.getString("start_time"),
						rs.getString("end_time"), rs.getInt("gameRoom"),
						rs.getInt("animator"), rs.getInt("disco"),
						rs.getInt("drinks"), rs.getInt("food"), rs.getInt("agencyID")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return reservations;
	}
	
	public List<Reservation> getAllReservations() {
		List<Reservation> allReservations = new ArrayList<Reservation>();
		
		try {
			createConnection();
			String upit = "SELECT * FROM Reservation";
			ResultSet rs = stmt.executeQuery(upit);
			
			while(rs.next()) {
				allReservations.add(new Reservation(
						rs.getInt("reservationID"),
						rs.getString("name"),
						rs.getString("phone"),
						rs.getString("email"),
						rs.getString("date"),
						rs.getString("start_time"),
						rs.getString("end_time"),
						rs.getInt("gameRoom"),
						rs.getInt("animator"),
						rs.getInt("disco"),
						rs.getInt("drinks"),
						rs.getInt("food"),
						rs.getInt("agencyID")
				));
			}
		} catch(SQLException e) {
			System.out.println("Greška u uspostavljanju konekcije sa bazom.");
			e.printStackTrace();
		}
		
		return allReservations;
	}
}