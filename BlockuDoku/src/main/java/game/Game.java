/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

/**
 *
 * @author Storm
 */
public class Game implements Serializable{
    
    private static final long serialVersionUID = 9873268974234L;
    private LocalDateTime date;
    private boolean running;
    private Board board;
    private GameRound gameRound;
    private int gameScore;
    //private Score<Game> gameScore;

    public Game(GameMode gameMode) {

        this.running = true;
        this.board = new Board();
        //this.gameMode = gameMode;
        //this.gameScore = new Score<>(this, 0);
        this.gameRound = new GameRound(board, gameMode);
        this.gameScore = 0;
    }

    public void setTime(LocalDateTime date) {
        this.date = date;
    }

    public String getTime() {
        return date.getDayOfMonth() + "/" + date.getMonthValue() + "  " + date.getHour() + ":" + date.getMinute();
    }
    
    public void setGameScore(int gameScore){
        this.gameScore =  gameScore;
    }
    
    public void addGameScore(int gameScore){
        this.gameScore += gameScore;
    }
    
    public int getGameScore(){
        return gameScore;
    }

    public boolean play(Parser parser) {

        while (running) {

            running = gameRound.checkRound();
            gameRound.showRound();

            if (!running) {
                break;
            }

            String command = parser.readInput();

            if (command.equalsIgnoreCase("cancel")) {
                running = false;
                break;
            }
            
            

            //String[] moveCommand = parser.getGameCommand(command);
            Command moveCommand = parser.getGameCommand(command);

            gameRound.move(moveCommand);
            //gameScore = gameRound.move(moveCommand);
            //gameRound.clearScore();
        }
        gameScore = gameRound.getScore();
        setTime(LocalDateTime.now());
        System.out.println("Game Over");
        return running;

    }
}
