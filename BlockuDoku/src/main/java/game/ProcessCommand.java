/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import static game.Users.*;
import static game.Ranking.*;

/**
 * This class serves to parse Commands and to act as an intermediate
 * between the menu and the user inputs
 * 
 *
 * @author Pedro Rosa - 190221015
 * @author Joao Cetano - 190221010
 */
public class ProcessCommand {

    private boolean finished;
    public Parser parser;
    public Game game;
    public Score<Game> score;

    /**
     * Constructor for ProccessCommand
     */
    public ProcessCommand() {
        finished = false;
        parser = new Parser();
        game = null;
    }

    /**
     * ProcessMenu receives the User and his input 
     * and then calls other method based on the input it has received 
     * 
     * @param user User playing the game
     * @param input Input from the User
     * @return true until the game is closed
     */
    public boolean processMenu(User user, String input) {

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
                loadGame(user);
                //gameUpdate(user);
                MenuPrint.mainMenu();
                break;
            case "3":
                System.out.println(user.getPersonalGameList());
                MenuPrint.mainMenu();
                break;
            case "4":
                addAllHighScoresFromList(getUsersList());
                System.out.println(getHighScoreBoard().toStringGame());

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
     * Initialises a new Game based on the GameMode and the User playing
     * 
     * @param gameMode GameMode to be played in 
     * @param user User playing
     */
    public void startNewGame(GameMode gameMode, User user) {

        game = new Game(gameMode);
        game.play();

        if (game.isSaved()) {
            user.setGame(game);
        }

        if (game.isOver()) {
            score = new Score<>(game, game.getGameScore(), user.getName());
            user.addPersonalScore(score);
            user.setGame(null);
        }

        game = null;

        MenuPrint.mainMenu();
    }

    /**
     * Loads the current game if the User has an ongoing valid game 
     * @param user 
     */
    public void loadGame(User user) {
        
        if (user.hasGameSaved()) {
            
            System.out.println("Loading Game...");
            user.getGame().play();
            
            
            if (user.getGame().isOver()) {
                
                score = new Score<>(game, game.getGameScore(), user.getName());
                user.addPersonalScore(score);
                user.setGame(null);
            }
            
        } else {
            
            System.out.println("You don't have a game to load...");
            
        }
    }
}
