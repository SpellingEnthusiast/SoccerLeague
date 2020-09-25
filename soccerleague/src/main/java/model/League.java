package model;
import java.util.ArrayList;

public class League {
	private String name;
	private ArrayList<Team> teams = new ArrayList<Team>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addTeam(Team t) {
		teams.add(t);
	}
	
	public void removeTeam(Team t) {
		teams.remove(t);
	}
	
	public void getTeams() {
		for (int i = 0; i < this.teams.size(); i++) {
			System.out.println(this.teams.get(i).getName().toString());
		}
	}
	
	public String toString() {
		return "League name: " + this.name;
	}
	

}
