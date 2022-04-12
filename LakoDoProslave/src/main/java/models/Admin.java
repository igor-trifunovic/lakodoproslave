package models;

public class Admin extends User {
	private String name;
	private String email;
	
	public Admin(String username, String password, String roleName, String name, String email) {
		super(username, password, roleName);
		this.name = name;
		this.email = email;
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
}