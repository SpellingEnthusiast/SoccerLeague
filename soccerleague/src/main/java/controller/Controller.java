package controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Model;


public class Controller extends Model implements Serializable {
	/**
	 The Controller class has methods which act on the Model class, these methods are used by the GUI to provide various functionality to the application.
	 @author Vytautas Vosylius
	 @version 2.0
	 @since 03-04-2020 
	 */
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
	EntityManager em = emf.createEntityManager();
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Team> teams = new ArrayList<Team>();
	private ArrayList<League> leagues = new ArrayList<League>();
	private ArrayList<Manager> managers = new ArrayList<Manager>();

	/**
	 * 
	 */
	private static final long serialVersionUID = 8844043160047292023L;
	
	/**
	 The addLeague method creates a new League object and adds it to an arraylist of League objects.
	 * 
	 * @param name This is the first parameter to the addLeague method, it represents the league name.
	 */
	public void addLeague(String name) {
		leagues.add(new League(name));
	}
	
	
	/**
	 The addTeamToLeague method assigns a given team to a given league.
	 * 
	 * @param league This is the first parameter to the addTeamToLeague method, it represents the league name.
	 * @param team This is the second parameter to the addTeamToLeague method, it represents the team name.
	 */
	public void addTeamToLeague(String league, String team) {
		for (int i = 0; i < leagues.size(); i++) {
			if (leagues.get(i).getName().equals(league)) {
				for (int j = 0; j < teams.size(); j++) {
					if (teams.get(j).getName().equals(team)) {
						leagues.get(i).addTeam(teams.get(j));
					}
				}
			}
		}
	}
	
	/**
	 The listLeagues method builds a string of every league that exists on the system.
	 * @return String this returns all the leagues.
	 */
	public String listLeagues() {
		String tmp = "";
		for (int i = 0; i < leagues.size(); i++) {
			tmp += "League name: " + leagues.get(i).getName();
			tmp += "\nTeams in league: " + leagues.get(i).getTeams();
			tmp += "\n";
		}
		return tmp;
	}
	
	/**
	 The addTeam method creates a new Team object and adds it to an arraylist of Team objects.
	 * 
	 * @param name This is the first parameter to the addTeam method, it represents the team name.
	 * @param jersey_colour This is the second parameter to the addTeam method, it represents the team's jersey colour.
	 */
	public void addTeam(String name, String jersey_colour) {
		teams.add(new Team(name, jersey_colour));
	}
	
	/**
	 The listTeams method builds a string of every team that exists on the system.
	 * @return String this returns all of the teams.
	 */
	public String listTeams() {
		String tmp = "";
		for (int i = 0; i < this.teams.size(); i++) {
			tmp += this.teams.get(i).toString();
			tmp += "\n";
		}
		return tmp;
	}
	
	/**
	 The getPlayersInTeam method builds a string of every player that is present in a given team.
	 * 
	 * @param team This is the first parameter to the getPlayersInTeam method, it represents the team name.
	 * @return String  this returns all of the players in the team.
	 */
	public String getPlayersInTeam(String team) {
		String tmp = "";
		for (int i = 0; i < teams.size(); i++) {
			if (teams.get(i).getName().equals(team)){
				tmp += "Team name: " + teams.get(i).getName();
				tmp += "\n";
				tmp += "Manager name: " + teams.get(i).getManager();
				tmp += "\n";
				tmp += "Manager rating: " + teams.get(i).getManager().getStar_rating();
				for (int j = 0; j < players.size(); j++) {
					if (players.get(j).getTeam().equals(team)) {
						tmp += "\n" + players.get(j).getName() + "\n";
					}
				}
			}
		}
		return tmp;
	}
	
	/**
	 The addPlayer method creates a new Player object and adds it to an arraylist of Player objects.
	 * 
	 * @param name This is the first parameter for the addPlayer function, it represents the player name.
	 * @param phone This is the second parameter for the addPlayer function, it represents the player phone number.
	 * @param email This is the third parameter for the addPlayer function, it represents the player email.
	 * @param goals This is the fourth parameter for the addPlayer function, it represents the player goals.
	 * @param goalie This is the fifth parameter for the addPlayer function, it represents the player goalie status.
	 */
	public void addPlayer(String name, String phone, String email, int goals, boolean goalie) {
		players.add(new Player(name, phone, email, goals, goalie));
	}
	
	/**
	 The save method persists the soccer league information to a database.
	 *
	 */
	public void save() {
		
		for (int i = 0; i < players.size(); i++) {
			em.getTransaction().begin();
			em.persist(players.get(i));
			em.getTransaction().commit();
		}
		
		for (int i = 0; i < managers.size(); i++) {
			em.getTransaction().begin();
			em.persist(managers.get(i));
			em.getTransaction().commit();
		}
		
		for (int i = 0; i < teams.size(); i++) {
			em.getTransaction().begin();
			em.persist(teams.get(i));
			em.getTransaction().commit();
		}
		
		for (int i = 0; i < leagues.size(); i++) {
			em.getTransaction().begin();
			em.persist(leagues.get(i));
			em.getTransaction().commit();
		}
	}
	
	/**
	 The load method loads the soccer league information from a database.
	 *@throws SQLException The database was configured incorrectly or not running.
	 */
	public void load() throws SQLException {
		Connection soccer=DriverManager.getConnection("jdbc:mysql://localhost:3306/soccerleague?serverTimezone=GMT","root","toor");
	    Statement stmt = soccer.createStatement();
	    ResultSet rs1=stmt.executeQuery("SELECT * FROM Player"); 
	    int count = 0;
	    while(rs1.next()) {
		count++;
	    }
	    
	    for (int i = 1; i <= count; i++) {
	    	players.add(em.find(Player.class, i));
	    }
	    
	    ResultSet rs2=stmt.executeQuery("select * from manager"); 
	    count = 0;
	    while(rs2.next()) {
		count++;
	    }
	    
	    for (int i = 1; i <= count; i++) {
	    	managers.add(em.find(Manager.class, i));
	    }
	    
	    ResultSet rs3=stmt.executeQuery("select * from league"); 
	    count = 0;
	    while(rs3.next()) {
		count++;
	    }
	    
	    for (int i = 1; i <= count; i++) {
	    	leagues.add(em.find(League.class, i));
	    }
	    
	    ResultSet rs4=stmt.executeQuery("select * from team"); 
	    count = 0;
	    while(rs4.next()) {
		count++;
	    }
	    
	    for (int i = 1; i <= count; i++) {
	    	teams.add(em.find(Team.class, i));
	    }
	    

	    
	}
	
	/**
	 The removePlayer method removes an existing player from the system.
	 * 
	 * @param player This is the first parameter to the removePlayer method, it represents the player name.
	 */
	public void removePlayer(String player) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getName().equals(player)) {
				players.remove(i);
			}
		}
	}
	
	
	/**
	 The addPlayerToTeam method assigns a given player to a given team.
	 * 
	 * @param team This is the first parameter to the addPlayerToTeam method, it represents the team name.
	 * @param player This is the second parameter to the addPlayerToTeam method, it represents the player name.
	 */
	public void addPlayerToTeam(String team, String player) {
		for (int i = 0; i < teams.size(); i++) {
			if (teams.get(i).getName().equals(team)) {
				for (int j = 0; j < players.size(); j++) {
					if (players.get(j).getName().equals(player)) {
						players.get(j).setTeam(teams.get(i).getName());
					}
				}
			}
		}
	}
	
	/**
	 The viewPlayerStats method creates a string which details all of the players statistics.
	 * @param player_name This is the first parameter to the viewPlayerStats method, it represents the player name.
	 * @return String this returns the player stats.
	 */
	public String viewPlayerStats(String player_name) {
		String tmp = "";
		
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getName().equals(player_name)){
				tmp += "Player name: " +  players.get(i).getName() + "Goals: " + players.get(i).getGoals();
			}
		}
		
		return tmp;
	}
	
	/**
	 The listPlayers method creates a string which details all of the players, ordered by name in alphabetical order.
	 * @return String this returns the players in the system.
	 */
	public String listPlayers() {
		Comparator<Player> compareByName = (Player p1, Player p2) -> 
		p1.getName().compareTo(p2.getName());
		Collections.sort(players, compareByName);
		
		String tmp = "";
		for (int i = 0; i < players.size(); i++) {
			tmp += players.get(i).toString();
		}
		return tmp;
	}
	
	/**
	 The addManager method creates a Manager object and adds it to an arraylist of Manager objects.
	 * @param name This is the first parameter to the addManager method, it represents the manager name.
	 * @param phone This is the second parameter to the addManager method, it represents the manager phone number.
	 * @param email This is the third parameter to the addManager method, it represents the manager email.
	 * @param dob This is the fourth parameter to the addManager method, it represents the manager date of birth.
	 * @param star_rating This is the fifth parameter to the addManager method, it represents the manager star rating.
	 */
	public void addManager(String name, String phone, String email, LocalDate dob, int star_rating) {
		managers.add(new Manager(name, phone, email, dob, star_rating));
	}
	
	/**
	 The removeManager method removes a manager from the arraylist of managers.
	 * @param manager_name This is the first parameter to the removeManager method, it represents the manager name.
	 */
	public void removeManager(String manager_name) {
		for (int i = 0; i < managers.size(); i++) {
			if (managers.get(i).getName().equals(manager_name)){
				managers.remove(i);
			}
		}
	}
	
	/**
	 The listManagers method builds a string of every manager that exists on the system, ordered by name in alphabetical order.
	 * @return String this returns all of the managers.
	 */
	public String listManagers() {
		Comparator<Manager> compareByName = (Manager m1, Manager m2) -> 
		m1.getName().compareTo(m2.getName());
		Collections.sort(managers, compareByName);
		
		String tmp = "";
		for (int i = 0; i < managers.size(); i++) {
			tmp += managers.get(i).toString();
		}
		return tmp;
	}
	
	/**
	 The addManagerToTeam method assigns a given manager to a given team.
	 * 
	 * @param team This is the first parameter to the addManagerToTeam method, it represents the team name.
	 * @param manager This is the second parameter to the addManagerToTeam method, it represents the manager name.
	 */
	public void addManagerToTeam(String team, String manager) {
		for (int i = 0; i < teams.size(); i++) {
			if (teams.get(i).getName().equals(team)) {
				for (int j = 0; j < managers.size(); j++) {
					if (managers.get(j).getName().equals(manager)) {
						teams.get(i).setManager(managers.get(j));
						managers.get(j).setTeam(teams.get(i).getName());
					}
				}
			}
		}
	}
	
}
