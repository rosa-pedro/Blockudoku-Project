
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 * This class serves to parse Commands and to act as an intermediate
 * between the menu and the user inputs
 * 
 *
 * @author Pedro Rosa - 190221015
 * @author Joao Cetano - 190221010
 */
public class Menu {

    private boolean finished;
    public Parser parser;
    public Game game;
    Scoreboard<User> gameScoreboard;
    Users listOfUsers;
    ArrayList<User> usersArray;

    public Game testGame;

    /**
     * Constructor for Menu, initialises parser, the ArrayList and the ScoreBoard
     * 
     * 
     * @param listOfUsers assigns the listOfUsers
     */
    public Menu(Users listOfUsers) {
        finished = false;
        parser = new Parser();
        this.listOfUsers = listOfUsers;

        ArrayList<User> usersArray = new ArrayList<>();

        gameScoreboard = new Scoreboard<>();

    }
    
    /**
     * ProcessCommand receives the User and his input 
     * and then calls other method based on the input it has received 
     * 
     * @param user User playing the game
     * @param input Input from the User
     * @return true until the game is closed
     */
    public boolean processCommand(User user, String input) {

        switch (input.trim()) {
            case "1":
                System.out.println("New game");
                MenuPrint.newGameMenu();
                String secondInput = parser.readInput();
                switch (secondInput.trim()) {
                    case "1":
                        System.out.println("Entered Basic mode");
                        startNewGame(GameMode.BASIC_MODE, user);
                        break;
                    case "2":
                        System.out.println("Entered Advanced mode");
                        startNewGame(GameMode.ADVANCED_MODE, user);
                        break;
                    case "0":
                        System.out.println("Returned to Main Menu");
                        MenuPrint.mainMenu();
                        break;
                    default:
                        System.out.println("Invalid command");
                        return finished;
                }
                break;
            case "2":

                System.out.println("Loading game");
                user.loadGame();
                gameUpdate(user);
                break;
            case "3":
                System.out.println(user.getPersonalScores().toString());
                break;
            case "4":

                usersArray = listOfUsers;

                //listOfUsers.getUsers().forEach(u -> ranking.addUserHighScore(u.getHighScore()));
                //usersArray.forEach(u -> ranking.addUserHighScore(u.getHighScore()));
                for (int i = 0; i < usersArray.size(); i++) {

                    User u = usersArray.get(i);

                    if (!u.getPersonalScores().isEmpty()) {
                        gameScoreboard.insertScore(u, u.getPersonalScores().getHighestScore().getValue());
                    }

                }

                System.out.println(gameScoreboard);
                
                gameScoreboard.clear();

                break;
            case "0":
                System.out.println("Exit");
                finished = true;
                break;
            default:
                System.out.println("Invalid command");
                return finished;
        }

        return finished;
    }

    /**
     * Method starts a new game based on the given GameMode 
     * and assigns the game to the provided User
     * 
     * @param gameMode to start the Game with
     * @param user User we assign the game to
     */
    public void startNewGame(GameMode gameMode, User user) {
        game = new Game(gameMode);
        game.play();
        if (game.isOver()) {
            user.setGame(game);
            user.getPersonalScores().insertScore(game, game.getGameScore());
        }

        MenuPrint.mainMenu();
    }
    
    /**
     * Updates the Users game and gameScore
     * 
     * @param user User we are updating 
     */
    public void gameUpdate(User user) {
        user.setGame(game);
        user.getPersonalScores().insertScore(game, game.getGameScore());
        MenuPrint.mainMenu();
    }

    
    /**
     * Method to select User, we check the listOfUsers for any matching userNames,
     * if match found we return the same user if not we create a new one and add
     * it to the list.
     * 
     * @param userName userName we are checking
     * @param listOfUsers List of all Users
     * @return the User we found or created 
     */
    public static User selectUser(String userName, Users listOfUsers) {

        User user = listOfUsers.getUser(userName);

        if (user != null) {
            System.out.println("Loading User...");

        } else {
            System.out.println("Creating new User...");
            User newUser = new User(userName);
            listOfUsers.add(newUser);
            return newUser;
        }

        return user;
    }
    
    /**
     * returns gameScoreboard
     * 
     * @return gameScoreboard
     */
    public Scoreboard<User> getGameScoreboard() {
        return gameScoreboard;
    }

    
    
}

