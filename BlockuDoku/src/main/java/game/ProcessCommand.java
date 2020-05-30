/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.FileHandler.*;
import static game.Users.*;
import static game.Ranking.*;

/**
 *
 * @author Storm
 */
public class ProcessCommand {

    private boolean finished;
    public Parser parser;
    public Game game;
    public Score<Game> score;

    public ProcessCommand() {
        finished = false;
        parser = new Parser();
        game = null;
    }

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
