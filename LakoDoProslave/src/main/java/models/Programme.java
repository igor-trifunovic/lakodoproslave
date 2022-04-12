package models;

public class Programme {
	private int programmeID;
	private int gameRoom;
	private int animator;
	private int disco;
	private int drinks;
	private int food;
	
	public Programme(int programmeID, int gameRoom, int animator, int disco, int drinks, int food) {
		this.programmeID = programmeID;
		this.gameRoom = gameRoom;
		this.animator = animator;
		this.disco = disco;
		this.drinks = drinks;
		this.food = food;
	}

	public int getProgrammeID() {
		return programmeID;
	}

	public void setProgrammeID(int programmeID) {
		this.programmeID = programmeID;
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
}