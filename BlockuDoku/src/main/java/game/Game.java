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
    private Board board;
    private GameRound gameRound;
    private int gameScore;

    private boolean running;
    private boolean saved;

    public Game(GameMode gameMode) {

        this.board = new Board();
        this.gameRound = new GameRound(board, gameMode);
        this.gameScore = 0;

        this.running = true;
        this.saved = false;
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

    public void gameOver() {
        System.out.println("Game Over");
        setTime(LocalDateTime.now());
        gameScore = gameRound.getScore();
    }

    public boolean isOver() {
        return !running;
    }

    public boolean isSaved() {
        return saved;
    }
}
