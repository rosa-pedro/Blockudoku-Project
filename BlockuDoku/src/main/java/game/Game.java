package game;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * This class contains the parts that make up the game
 *
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class Game implements Serializable {

    private LocalDateTime date;
    private Board board;
    private GameRound gameRoundLogic;
    private int gameScore;

    private boolean running;
    private boolean saved;

    /**
     * Constructor for game, initialises the Board and starts a new
 GameRound with the score at 0
     *
     * @param gameMode selects the GameMode to start the game with
     */
    public Game(GameMode gameMode) {

        this.board = new Board();
        this.gameRoundLogic = new GameRound(board, gameMode);
        this.gameScore = 0;

        this.running = true;
        this.saved = false;
    }

    /**
     * Method to start the game, initiates the gameRoundLogic and starts
     * receiving and parsing user inputs if the user cancels or saves it'll exit
     * the method, if the game is completed it'll display gameOver()
     *
     *
     */
    public void play(Parser parser) {

        saved = false;
        running = true;

        while (true) {

            try {

                running = gameRoundLogic.checkRound();
                gameRoundLogic.showRound();

                if (!running) {
                    break;
                }

                String command = parser.readInput();

                if (command.equalsIgnoreCase("cancel")) {
                    return;
                }
                if (command.equalsIgnoreCase("save")) {
                    saved = true;
                    return;
                }

                Command moveCommand = parser.getGameCommand(command);

                gameRoundLogic.move(moveCommand);

            } catch (IllegalArgumentException e) {

                gameRoundLogic.setErrorMessage(e.getMessage());
            }
        }

        gameOver();
    }

    /**
     * method to signal that the game is over
     */
    public void gameOver() {

        gameScore = gameRoundLogic.getScore();
        System.out.println("\n");
        System.out.println("Game Over");
        System.out.println("Score: " + gameScore);
        setTime(LocalDateTime.now());
    }

    /**
     * setter for the date of the Game
     *
     * @param date
     */
    public void setTime(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Getter for the time of the Game
     *
     * @return time in d/M hh:mm
     */
    public String getTime() {
        return date.getHour() + ":" + date.getMinute() + " " + date.getDayOfMonth() + "/" + date.getMonthValue();
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
     *
     * @return true if games is not running, false if the game is still running
     */
    public boolean isOver() {
        return !running;
    }

    /**
     *
     * @return true if the game is saved
     */
    public boolean isToBeSaved() {
        return saved;
    }

    @Override
    public String toString() {
        return getTime();
    }
}
