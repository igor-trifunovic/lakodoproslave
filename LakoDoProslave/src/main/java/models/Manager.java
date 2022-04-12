package models;

public class Manager extends User {
	private String name;
	private String email;
	private String phone;
	private int agencyID;
	
	public Manager(String username, String password, String roleName, String name, String email, String phone, int agencyID) {
		super(username, password, roleName);
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.agencyID = agencyID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAgencyID() {
		return agencyID;
	}

	public void setAgencyID(int agencyID) {
		this.agencyID = agencyID;
	}
}