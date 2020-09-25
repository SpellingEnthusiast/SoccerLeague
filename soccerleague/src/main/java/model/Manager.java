package model;

public class Manager extends Person {

	public Manager() {
		super();
	}

	private String dob; // datatype could be different?
	private int star_rating;
	private Team team;

	public String getTeam() {
		return "Manager: " + super.getName() + " " + "Manages: " + this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getName() {
		return super.getName();
	}
	
	public void setName(String name) {
		super.setName(name);
	}
	
	public String getDob() {
		return this.dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public int getStar_rating() {
		return star_rating;
	}
	
	public void setStar_rating(int star_rating) {
		this.star_rating = star_rating;
	}
	
	public String toString() {
		return super.getName();
	}

}
