package model;

import java.util.ArrayList;

public class Team {	

	private String name;
	private Manager manager;
	private String jersey_colour;
	private ArrayList<Player> players = new ArrayList<Player>();

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Manager getManager() {
		return this.manager;
	}
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public String getJersey_colour() {
		return this.jersey_colour;
	}
	
	public void setJersey_colour(String jersey_colour) {
		this.jersey_colour = jersey_colour;
	}
	
	public void addPlayer(Player p) {
		players.add(p);
	}
	
	public void removePlayer(Player p) {
		players.remove(p);
	}
	
	public void getPlayers() {
		System.out.println("Team name: " + this.getName());
		System.out.println("Manager name: " + this.getManager());
		System.out.println("Manager rating: *" + this.getManager().getStar_rating());
		System.out.println("-----------");
		for (int i = 0; i < this.players.size(); i++) {
			System.out.println(this.players.get(i).toString());
			System.out.println(" -------------");
		}
	}
	
	public String toString() {
		return "Team name: " + this.name;
	}
}
