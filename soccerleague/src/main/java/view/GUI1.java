package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets; 
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text; 
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import controller.Controller;         

public class GUI1 extends Application {
	private Controller controller;
   @Override 
   public void start(Stage stage) throws FileNotFoundException { 
	  controller = new Controller();
	   
      //Creating Text stuff for team management
      Text team_name = new Text("Team name: ");       
      Text jersey = new Text("Jersey Colour: ");
      final TextField team_nameT = new TextField();       
      final TextField jerseyT = new TextField();
      final TextArea summaryTeamArea = new TextArea("Teams to be displayed");
      
      //Creating text stuff for player management
      Text player_name = new Text("Player name: ");
      Text player_phone = new Text("Phone Number: ");
      Text player_email = new Text("Email: ");
      Text player_goals = new Text("Goals: ");
      Text player_goalie = new Text("Goalie? (True/False): ");
      Text player_team_name = new Text("Team name: ");
      
      final TextField player_nameT = new TextField();       
      final TextField player_phoneT = new TextField();
      final TextField player_emailT = new TextField();
      final TextField player_goalsT = new TextField();
      final TextField player_goalieT = new TextField();
      final TextField player_team_nameT = new TextField("Only used when adding player to a team button is pressed/displaying by team.");
      
      final TextArea summaryPlayerArea = new TextArea("Players to be displayed");
      
      
      //Creating text stuff for manager management
      Text manager_name = new Text("Manager name: ");
      Text manager_phone = new Text("Manager phone number: ");
      Text manager_email = new Text("Manager email: ");
      Text manager_dob = new Text("Manager DOB: ");
      Text manager_star_rating = new Text("Manager star rating (1-10): ");
      Text manager_team_name = new Text("Manager team name: ");
      
      final TextField manager_nameT = new TextField();       
      final TextField manager_phoneT = new TextField();
      final TextField manager_emailT = new TextField();
      final DatePicker manager_dobT = new DatePicker(); 
      final TextField manager_star_ratingT = new TextField();
      final TextField manager_team_nameT = new TextField("Only used when adding a manager to a team button is pressed.");
      
      final TextArea summaryManagerArea = new TextArea("Managers to be displayed");
      
      //Creating text stuff for league management
      Text league_name = new Text("League name: ");
      Text league_team_name = new Text("Team name: ");
      
      final TextField league_nameT = new TextField();  
      final TextField league_team_nameT = new TextField("Only used when adding a team to a league"); 
      
      final TextArea summaryLeagueArea = new TextArea("Leagues to be displayed");
      
      //Creating Buttons for Team management
      Button addteam = new Button("Add team"); 
      Button removeteam = new Button("Remove team");  
      Button listteam = new Button("List teams"); 
      Button load = new Button("Load");
      Button save = new Button("Save");
      Button exit = new Button("Exit");
      
      //Creating buttons for Player Management
      Button addplayer = new Button("Add Player"); 
      Button addplayertoteam = new Button("Add Player to team");
      Button removeplayer = new Button("Remove Player");  
      Button listplayers = new Button("List Players"); 
      Button listplayersbyteam = new Button("List players in team");
      Button viewplayerstats = new Button("View player stats");
      
      //Creating buttons for Manager management
      Button addmanager = new Button("Add Manager"); 
      Button addmanagertoteam = new Button("Add Manager to team");
      Button listmanagers = new Button("List managers");
      Button removemanager = new Button("Remove Manager"); 
      
      //Creating buttons for League management
      Button addleague = new Button("Create League");
      Button addTeamToLeague = new Button("Add team to league");
      Button listleagues = new Button("List leagues");
      
      
      //Making the buttons do things in Team Management
      
      EventHandler<ActionEvent> addbutton = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
        	 controller.addTeam(team_nameT.getText(), jerseyT.getText());
          } 
      }; 

      EventHandler<ActionEvent> listbutton = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
        	  summaryTeamArea.setText(controller.listTeams());
          } 
      }; 
      
      EventHandler<ActionEvent> savebutton = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
        	  controller.save();
          } 
      }; 
      
      EventHandler<ActionEvent> loadbutton = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
        	  try {
				controller.load();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
          } 
      }; 
      
      addteam.setOnAction(addbutton);
      save.setOnAction(savebutton);
      load.setOnAction(loadbutton);
      listteam.setOnAction(listbutton);
      
    //Making the buttons do things in Player Management
      
      EventHandler<ActionEvent> addplayerbutton = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
        	 controller.addPlayer(player_nameT.getText(), player_phoneT.getText(), player_emailT.getText(), Integer.parseInt(player_goalsT.getText()), Boolean.getBoolean(player_goalieT.getText()));
        	 
          } 
      }; 
      
      EventHandler<ActionEvent> removeplayerbutton = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
        	 controller.removePlayer(player_nameT.getText());
        	 
          } 
      }; 
      
      
      EventHandler<ActionEvent> listplayersbutton = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
        	 summaryPlayerArea.setText(controller.listPlayers());
    
          } 
      }; 
      
      EventHandler<ActionEvent> viewplayerstatsbutton = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
        	 summaryPlayerArea.setText(controller.viewPlayerStats(player_nameT.getText()));
        	 
          } 
      }; 
      
      EventHandler<ActionEvent> listplayersbyteambutton = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
        	 summaryPlayerArea.setText(controller.getPlayersInTeam(player_team_nameT.getText()));
    
          } 
      }; 
      
      EventHandler<ActionEvent> addplayertoteambutton = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
        	 controller.addPlayerToTeam(player_team_nameT.getText(), player_nameT.getText());
    
          } 
      }; 
      
      
      addplayer.setOnAction(addplayerbutton);
      removeplayer.setOnAction(removeplayerbutton);
      addplayertoteam.setOnAction(addplayertoteambutton);
      listplayers.setOnAction(listplayersbutton);
      viewplayerstats.setOnAction(viewplayerstatsbutton);
      listplayersbyteam.setOnAction(listplayersbyteambutton);
      
      
      
      //Making the buttons do things in manager management
      
      EventHandler<ActionEvent> addmanagerbutton = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
        	 controller.addManager(manager_nameT.getText(), manager_phoneT.getText(), manager_emailT.getText(), manager_dobT.getValue(), Integer.parseInt(manager_star_ratingT.getText()));
    
          } 
      }; 
      
      EventHandler<ActionEvent> removemanagerbutton = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
        	 controller.removeManager(manager_nameT.getText());
    
          } 
      }; 
      
      EventHandler<ActionEvent> addmanagertoteambutton = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
        	 controller.addManagerToTeam(manager_team_nameT.getText(), manager_nameT.getText());
    
          } 
      }; 
      
      EventHandler<ActionEvent> listmanagersbutton = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
        	 summaryManagerArea.setText(controller.listManagers());
    
          } 
      }; 
      
      addmanager.setOnAction(addmanagerbutton);
      removemanager.setOnAction(removemanagerbutton);
      addmanagertoteam.setOnAction(addmanagertoteambutton);
      listmanagers.setOnAction(listmanagersbutton);
      
      //Making the buttons do things in league management area
      
      EventHandler<ActionEvent> addleaguebutton = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
        	 controller.addLeague(league_nameT.getText());
    
          } 
      }; 
      
      EventHandler<ActionEvent> listleaguesbutton = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
        	 summaryLeagueArea.setText(controller.listLeagues());
    
          } 
      }; 
      
      EventHandler<ActionEvent> addTeamToLeagueButton = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
        	 controller.addTeamToLeague(league_nameT.getText(), league_team_nameT.getText());
    
          } 
      }; 
      
      addleague.setOnAction(addleaguebutton);
      addTeamToLeague.setOnAction(addTeamToLeagueButton);
      listleagues.setOnAction(listleaguesbutton);

      //Creating a Grid Pane for Team management area
      GridPane gridPaneTeam = new GridPane();    
      gridPaneTeam.setMinSize(400, 300);  
      gridPaneTeam.setPadding(new Insets(10, 10, 10, 10)); 
      gridPaneTeam.setVgap(5); 
      gridPaneTeam.setHgap(5);  
      
 	 //Creating tabs
      TabPane tp = new TabPane();

      Tab tab1 = new Tab("Team Management");
      Tab tab2 = new Tab("Player Management");
      Tab tab3 = new Tab("Manager Management");
      Tab tab4 = new Tab("League Management");
   
      tab1.setClosable(false);
      tab2.setClosable(false);
      tab3.setClosable(false);
      tab4.setClosable(false);

      tp.getTabs().add(tab1);
      tp.getTabs().add(tab2);
      tp.getTabs().add(tab3);
      tp.getTabs().add(tab4);
      
      //Creating a new VBOX to store tabbedpane
      VBox tabbedPane = new VBox(tp);
       
      //Arranging all the nodes in the team management area
      gridPaneTeam.add(team_name, 0, 0); 
      gridPaneTeam.add(team_nameT, 1, 0); 
      gridPaneTeam.add(jersey, 0, 1);
      gridPaneTeam.add(jerseyT, 0, 2);
      gridPaneTeam.add(addteam, 0, 4); 
      gridPaneTeam.add(removeteam, 1, 4);
      gridPaneTeam.add(listteam, 2, 4);
      gridPaneTeam.add(summaryTeamArea, 1, 6);
      gridPaneTeam.add(load, 0, 7);
      gridPaneTeam.add(save, 1, 7);
      gridPaneTeam.add(exit, 3, 7);
      
      //Creating a new gridpane which will serve the player management area
      GridPane gridPanePlayer = new GridPane();    
      gridPanePlayer.setMinSize(800, 400);  
      gridPanePlayer.setPadding(new Insets(10, 10, 10, 10)); 
      gridPanePlayer.setVgap(5); 
      gridPanePlayer.setHgap(5);  
      

      //setting content of player management tab
      gridPanePlayer.add(player_name, 0, 0); 
      gridPanePlayer.add(player_nameT, 1, 0); 
      gridPanePlayer.add(player_phone, 0, 1);
      gridPanePlayer.add(player_phoneT, 1, 1);
      gridPanePlayer.add(player_email, 0, 2);
      gridPanePlayer.add(player_emailT, 1, 2);
      gridPanePlayer.add(player_goals, 0, 3);
      gridPanePlayer.add(player_goalsT, 1, 3);
      gridPanePlayer.add(player_goalie, 0, 4);
      gridPanePlayer.add(player_goalieT, 1, 4);
      gridPanePlayer.add(player_team_name, 0, 5);
      gridPanePlayer.add(player_team_nameT, 1, 5);
      gridPanePlayer.add(addplayer, 0, 6); 
      gridPanePlayer.add(addplayertoteam, 0, 7); 
      gridPanePlayer.add(removeplayer, 0, 8);
      gridPanePlayer.add(listplayers, 0, 9);
      gridPanePlayer.add(listplayersbyteam, 0, 10);
      gridPanePlayer.add(viewplayerstats, 0, 11);
      gridPanePlayer.add(summaryPlayerArea, 1, 6);
      
      //Creating a new gridpane which will serve the manager management area
      GridPane gridPaneManager = new GridPane();    
      gridPaneManager.setMinSize(800, 400);  
      gridPaneManager.setPadding(new Insets(10, 10, 10, 10)); 
      gridPaneManager.setVgap(5); 
      gridPaneManager.setHgap(5);  
      
      //Arranging nodes in the manager management area
      gridPaneManager.add(manager_name, 0, 0); 
      gridPaneManager.add(manager_nameT, 1, 0); 
      gridPaneManager.add(manager_phone, 0, 1);
      gridPaneManager.add(manager_phoneT, 1, 1);
      gridPaneManager.add(manager_email, 0, 2);
      gridPaneManager.add(manager_emailT, 1, 2);
      gridPaneManager.add(manager_dob, 0, 3);
      gridPaneManager.add(manager_dobT, 1, 3);
      gridPaneManager.add(manager_star_rating, 0, 4);
      gridPaneManager.add(manager_star_ratingT, 1, 4);
      gridPaneManager.add(manager_team_name, 0, 5);
      gridPaneManager.add(manager_team_nameT, 1, 5);
      gridPaneManager.add(addmanager, 0, 6); 
      gridPaneManager.add(addmanagertoteam, 0, 7); 
      gridPaneManager.add(removemanager, 0, 8);
      gridPaneManager.add(listmanagers, 0, 9);
      gridPaneManager.add(summaryManagerArea, 1, 6);
      
      //Creating a Grid Pane which will serve league management area
      GridPane gridPaneLeague = new GridPane();    
      gridPaneLeague.setMinSize(400, 300);  
      gridPaneLeague.setPadding(new Insets(10, 10, 10, 10)); 
      gridPaneLeague.setVgap(5); 
      gridPaneLeague.setHgap(5);  
      
      //Arranging nodes in the league management area
      gridPaneLeague.add(league_name, 0, 0); 
      gridPaneLeague.add(league_nameT, 1, 0); 
      gridPaneLeague.add(league_team_name, 0, 1);
      gridPaneLeague.add(league_team_nameT, 0, 2);
      gridPaneLeague.add(addleague, 0, 4); 
      gridPaneLeague.add(addTeamToLeague, 1, 4);
      gridPaneLeague.add(listleagues, 2, 4);
      gridPaneLeague.add(summaryLeagueArea, 1, 6);
      
      //Setting content of tabs
      tab1.setContent(gridPaneTeam);
      tab2.setContent(gridPanePlayer);
      tab3.setContent(gridPaneManager);
      tab4.setContent(gridPaneLeague);
      
      //Displaying stage
      Scene scene = new Scene(tabbedPane);
      stage.setTitle("Soccer League Manager"); 
      stage.setScene(scene);
      stage.show(); 
      
   }      
   public static void main(String args[]){ 
      launch(args); 
   } 
}