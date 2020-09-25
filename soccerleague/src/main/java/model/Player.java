package model;

public class Player extends Person {

	public Player() {
		super();
	}

	private int goals;
	private boolean goalie;
	private Team team;
	
	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getGoals() {
		return goals;
	}
	
	public void setGoals(int goals) {
		this.goals = goals;
	}
	
	public boolean isGoalie() {
		return goalie;
	}
	
	public void setGoalie(boolean goalie) {
		this.goalie = goalie;
	}
	
	public String toString() {
		return " Name: " + this.getName() + "\n" + " Email: " + this.getEmail() + "\n" + " Phone Number:" + this.getPhone() + "\n" + " Goals Scored: " + this.goals + "\n" + " Goalie?: " + this.isGoalie();
	}
}
