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
    //public GameRound gr1;
    //public Board board;

    public Game game;
    public Score<Game> score;

    public Game testGame;

    public ProcessCommand() {
        finished = false;
        parser = new Parser();
        //board = new Board();

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
                user.loadGame();
                gameUpdate(user);
                break;
            case "3":
                System.out.println(user.getPersonalGameList());
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
        if (game.isOver()) {
            score = new Score<>(game, game.getGameScore(), user.getName());
            user.setGame(game);
            user.addPersonalScore(score);
        }
        MenuPrint.mainMenu();
    }

    public void gameUpdate(User user) {
        user.setGame(game);
        user.addPersonalScore(score);
        MenuPrint.mainMenu();
    }

}
