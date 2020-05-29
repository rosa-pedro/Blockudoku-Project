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

    private static final long serialVersionUID = 4L;
    //private E element;
    private LocalDateTime date;
    private boolean running;
    private Board board;
    private GameRound gameRound;

    public Game(GameMode gameMode) {

        this.running = true;
        this.board = new Board();
        //this.gameMode = gameMode;
        this.gameRound = new GameRound(board, gameMode);
    }

    public void setTime(LocalDateTime date) {
        this.date = date;
    }

    public String getTime() {
        return date.getDayOfMonth() + "/" + date.getMonthValue() + "  " + date.getHour() + ":" + date.getMinute();
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

            String[] moveCommand = parser.processGameCommand(command);

            gameRound.move(moveCommand);
        }
        return running;

    }
}
