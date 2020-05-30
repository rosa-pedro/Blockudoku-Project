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
public class Game implements Serializable {

    private static final long serialVersionUID = 9873268974234L;
    private LocalDateTime date;
    private boolean running;
    private Board board;
    private GameRound gameRound;
    private int gameScore;

    public Game(GameMode gameMode) {

        this.running = true;
        this.board = new Board();
        this.gameRound = new GameRound(board, gameMode);
        this.gameScore = 0;
    }

    public void setTime(LocalDateTime date) {
        this.date = date;
    }

    public String getTime() {
        return date.getDayOfMonth() + "/" + date.getMonthValue() + "  " + date.getHour() + ":" + date.getMinute();
    }

    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    public void addGameScore(int gameScore) {
        this.gameScore += gameScore;
    }

    public int getGameScore() {
        return gameScore;
    }

    public boolean play(Parser parser) {

        running = true;

        while (running) {

            try {

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

                Command moveCommand = parser.getGameCommand(command);

                gameRound.move(moveCommand);

            } catch (IllegalArgumentException e) {

                gameRound.setErrorMessage(e.getMessage());
            }
        }
        
        gameScore = gameRound.getScore();
        setTime(LocalDateTime.now());
        System.out.println("Game Over");
        return running;
    }
}
