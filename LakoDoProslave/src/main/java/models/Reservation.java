package models;

public class Reservation {
    private int reservationID;
    private String name;
    private String phone;
    private String email;
    private String date;
    private String startTime;
    private String endTime;
    private int gameRoom;
    private int animator;
    private int disco;
    private int drinks;
    private int food;
    private int agencyID;
    
	public Reservation(int reservationID, String name, String phone, String email, String date, String startTime, String endTime, int gameRoom, int animator,
			int disco, int drinks, int food, int agencyID) {
		this.reservationID = reservationID;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.gameRoom = gameRoom;
		this.animator = animator;
		this.disco = disco;
		this.drinks = drinks;
		this.food = food;
		this.agencyID = agencyID;
	}

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getGameRoom() {
		return gameRoom;
	}

	public void setGameRoom(int gameRoom) {
		this.gameRoom = gameRoom;
	}

	public int getAnimator() {
		return animator;
	}

	public void setAnimator(int animator) {
		this.animator = animator;
	}

	public int getDisco() {
		return disco;
	}

	public void setDisco(int disco) {
		this.disco = disco;
	}

	public int getDrinks() {
		return drinks;
	}

	public void setDrinks(int drinks) {
		this.drinks = drinks;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}
	
	public int getAgencyID() {
		return agencyID;
	}

	public void setAgencyID(int agencyID) {
		this.agencyID = agencyID;
	}
}