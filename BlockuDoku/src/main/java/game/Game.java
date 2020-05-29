/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Storm
 */
public class Game {

    private boolean running;
    private Board board;
    //private GameMode gameMode;
    private GameRound gameRound;

    public Game(GameMode gameMode) {

        this.running = true;
        this.board = new Board();
        //this.gameMode = gameMode;
        this.gameRound = new GameRound(board, gameMode);
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
