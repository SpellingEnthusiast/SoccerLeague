package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


public class Model {
	
	@Entity
	@Table(name = "League")
	public static class League implements Serializable {
		
		public League(){}
		/**
		 * 
		 */
		private static final long serialVersionUID = 3806766747398190439L;
		public League(String name) {
			super();
			this.name = name;
		}
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int ID;
		public int getID() {
			return ID;
		}

		public void setID(int iD) {
			ID = iD;
		}

		private String name;
		@Transient
		private ArrayList<Team> teams = new ArrayList<Team>();

		public ArrayList<Team> getTeams() {
			return teams;
		}

		public void addTeam(Team team) {
			teams.add(team);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public String toString() {
			return "League name: " + this.name;
		}
		
	}
	
	@Entity
	@Table(name = "Manager")
	public static class Manager implements Serializable{
		
		public Manager(){}
		/**
		 * 
		 */
		private static final long serialVersionUID = 671911069638241143L;
		public Manager(String name, String phone, String email, LocalDate dob, int star_rating) {
			super();
			this.name = name;
			this.phone = phone;
			this.email = email;
			this.dob = dob;
			this.star_rating = star_rating;
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

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int ID;
		public int getID() {
			return ID;
		}

		public void setID(int iD) {
			ID = iD;
		}
		private String name;
		private String phone;
		private String email;
		private LocalDate dob;
		private int star_rating;
		private String team;

		public String getTeam() {
			return team;
		}

		public void setTeam(String team) {
			this.team = team;
		}

		public String getName() {
			return this.name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public LocalDate getDob() {
			return this.dob;
		}
		
		public void setDob(LocalDate dob) {
			this.dob = dob;
		}
		
		public int getStar_rating() {
			return this.star_rating;
		}
		
		public void setStar_rating(int star_rating) {
			this.star_rating = star_rating;
		}
		
		public String toString() {
			return "Name: " + this.getName() + "\n" + "Phone number: " + this.getPhone() + "\n" + "Email: " + this.getEmail() + "\n" + "DOB: " + this.getDob() + "\n" + "Star rating: " + this.getStar_rating() +  "\n"  + this.getTeam() + "\n"; 
		}

	}

	@Entity
	@Table(name = "Player")
	public static class Player implements Serializable {
		
		public Player(){}

	
		/**
		 * 
		 */
		private static final long serialVersionUID = 2973296284442202804L;

		public Player(String name, String phone, String email, int goals, boolean goalie) {
			super();
			this.name = name;
			this.phone = phone;
			this.email = email;
			this.goals = goals;
			this.goalie = goalie;
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

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int ID;
		
		public void setID(int iD) {
			ID = iD;
		}
		
		public int getID() {
			return ID;
		}

		private String name;
		private String phone;
		private String email;
		private int goals;
		private boolean goalie;
		private String team;
		
		public String getTeam() {
			return this.team;
		}

		public void setTeam(String team) {
			this.team = team;
		}

		public int getGoals() {
			return this.goals;
		}
		
		public void setGoals(int goals) {
			this.goals = goals;
		}
		
		public boolean isGoalie() {
			return this.goalie;
		}
		
		public void setGoalie(boolean goalie) {
			this.goalie = goalie;
		}
		
		public String toString() {
			return " Name: " + this.getName() + "\n" + " Email: " + this.getEmail() + "\n" + " Phone Number:" + this.getPhone() + "\n" + " Goals Scored: " + this.goals + "\n" + " Goalie?: " + this.isGoalie() + "\n" + this.getTeam() + "\n";
		}
	}
	
	@Entity
	@Table(name = "Team")
	public static class Team implements Serializable {	
		
		public Team(){}
		/**
		 * 
		 */
		private static final long serialVersionUID = -6472973199139062445L;
		public Team(String name, String jersey_colour) {
			super();
			this.name = name;
			this.jersey_colour = jersey_colour;
		}

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int ID;
		public int getID() {
			return ID;
		}

		public void setID(int iD) {
			ID = iD;
		}
		private String name;
		@Transient
		private Manager manager;
		private String jersey_colour;
		@Transient
		private ArrayList<Player> players = new ArrayList<Player>();

		public ArrayList<Player> getPlayers() {
			return players;
		}

		public void setPlayers(ArrayList<Player> players) {
			this.players = players;
		}

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
		
		public String toString() {
			return "Team name: " + this.name + "\nJersey colour: " + this.jersey_colour + "";
		}
	}


}
