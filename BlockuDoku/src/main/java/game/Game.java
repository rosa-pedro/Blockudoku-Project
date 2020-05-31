/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.time.LocalDateTime;


/** This class contains the parts that make up the game
 *
 * @author Pedro Rosa - 190221015
 * @author Joao Cetano - 190221010
 */
public class Game implements Serializable {

    private LocalDateTime date;
    private Board board;
    private GameRound gameRound;
    private int gameScore;

    private boolean running;
    private boolean saved;
    
    /**
     * Constructor for game,
     * initialises the Board
     * and starts a new GameRound
     * with the score at 0
     * 
     * @param gameMode selects the GameMode to start the game with
     */
    public Game(GameMode gameMode) {

        this.board = new Board();
        this.gameRound = new GameRound(board, gameMode);
        this.gameScore = 0;

        this.running = true;
        this.saved = false;
    }
    
    /**
     * Method to start the game, initiates the gameRound and
     * starts receiving and parsing user inputs
     * if the user cancels or saves it'll exit the method,
     * if the game is completed it'll display gameOver()
     * 
     * 
     */
    public void play() {

        running = true;

        while (true) {

            try {

                running = gameRound.checkRound();
                gameRound.showRound();

                if (!running) {
                    break;
                }

                String command = Parser.readInput();

                if (command.equalsIgnoreCase("cancel")) {
                    return;
                }
                if (command.equalsIgnoreCase("save")) {
                    saved = true;
                    return;
                }

                Command moveCommand = Parser.getGameCommand(command);

                gameRound.move(moveCommand);

            } catch (IllegalArgumentException e) {

                gameRound.setErrorMessage(e.getMessage());
            }
        }
        
        gameOver();
    }
    
    /**
     * method to signal that the game is over 
     */
    public void gameOver() {
        System.out.println("\nGame Over");
        System.out.println("Score: " + gameScore);
        setTime(LocalDateTime.now());
        gameScore = gameRound.getScore();
    }

    /**
     * setter for the date of the Game
     * @param date 
     */
    public void setTime(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Getter for the time of the Game
     * 
     * @return  time in d/M hh:mm
     */
    public String getTime() {
        return date.getDayOfMonth() + "/" + date.getMonthValue() + " " + date.getHour() + ":" + date.getMinute();
    }

    /**
     * getter for gameScore
     * 
     * @return the games score
     */
    public int getGameScore() {
        return gameScore;
    }

    /**
     * Checks if the game is over
     * @return true if games is not running, false if the game is still running
     */
    public boolean isOver() {
        return !running;
    }

    /**
     * 
     * @return true if the game is saved  
     */
    public boolean isSaved() {
        return saved;
    }
    
    @Override
    public String toString() {
        return getTime();
    }
}
