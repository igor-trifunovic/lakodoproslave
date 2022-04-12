package models;

public class Agency {
	private int agencyID;
	private String name;
	private String city;
	private String address;
	private String phone;
	private String image;
	private String about;
	private int programmeID;
	
	public Agency() {}
	
	public Agency(int agencyID, String name, String city, String address, String phone, String image, String about, int programmeID) {
		this.agencyID = agencyID;
		this.name = name;
		this.city = city;
		this.address = address;
		this.phone = phone;
		this.image = image;
		this.about = about;
		this.programmeID = programmeID;
	}

	public int getAgencyID() {
		return agencyID;
	}

	public void setAgencyID(int agencyID) {
		this.agencyID = agencyID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public int getProgrammeID() {
		return programmeID;
	}

	public void setProgrammeID(int programmeID) {
		this.programmeID = programmeID;
	}
}