package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents an in-game round where the player selects the blocks
 * and where he wants to insert them within the board
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class GameRound implements Serializable {

    private Board board;
    private GameMode gameMode;
    private ArrayList<Block> roundBlocks;
    private int score;
    private String errorMessage;

    /**
     * Constructor for GameRound takes the board we are playing in and the
     * GameMode that the game will be set to
     *
     * @param board
     * @param gameMode
     */
    public GameRound(Board board, GameMode gameMode) {

        this.board = board;
        this.gameMode = gameMode;
        this.roundBlocks = new ArrayList<>();
        this.score = 0;
        this.errorMessage = "";
    }

    /**
     * Method to validate the Command it receives
     *
     * @param command received
     * @return the Command if it's valid
     * @throws GameIllegalArgumentException if the command is invalid
     */
    public Command validateCommand(Command command) throws GameIllegalArgumentException {

        if (command == null || !command.isCommandValid(board)) {

            throw new GameIllegalArgumentException(ErrorCode.INVALID_COMMAND);
        }

        return command;
    }

    /**
     * Takes the command and removes the given block from the three playable
     * blocks each round has adds to the gameScore
     *
     * @param command Command we are using
     * @throws GameIllegalArgumentException when the Command has Blocks out of
     * bound or is trying to insert Blocks in invalid coordinates
     */
    public void move(Command command) throws GameIllegalArgumentException {

        Command c = validateCommand(command);

        Iterator itr = roundBlocks.iterator();
        Block itrBlock;

        while (itr.hasNext()) {
            itrBlock = (Block) itr.next();

            if (itrBlock.getBlockName().equals(c.getBlockCommand())) {
                Piece piece = itrBlock.getBlockPiece();

                if (board.insertBlock(piece, c.getCoordCommand())) {
                    itr.remove();
                    score += piece.getPieceScore(gameMode);
                    return;
                }
                throw new GameIllegalArgumentException(ErrorCode.INVALID_BLOCK_INSERTION);
            }
        }
        throw new GameIllegalArgumentException(ErrorCode.INVALID_ROUND_BLOCK);
    }

    /**
     * checks if the round is over if all blocks have been inserted it'll
     * generate new ones
     *
     * @return
     */
    public boolean checkRound() {

        if (roundBlocks.isEmpty()) {
            generateBlocks();
        }
        score += BoardCleanUpLogic.cleanUpBoard(board);
        return !isGameOver();
    }

    /**
     *
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * returns if the game is over or not by checking if there is space left in
     * the board for any of the remaining to be inserted pieces in the round
     *
     * @return true if unable to play more, false if the game can continue
     */
    public boolean isGameOver() {

        return roundBlocks.stream().allMatch(b -> !board.isThereSpaceleftInTheBoard(b.getBlockPiece()));
    }

    /**
     * Generates the three new blocks based on the current GameMode
     */
    public void generateBlocks() {

        if (gameMode == GameMode.BASIC_MODE) {
            roundBlocks.add(new Block("A", new BlockGenerator().nextBasicBlock()));
            roundBlocks.add(new Block("B", new BlockGenerator().nextBasicBlock()));
            roundBlocks.add(new Block("C", new BlockGenerator().nextBasicBlock()));
        } else {
            roundBlocks.add(new Block("A", new BlockGenerator().nextAdvancedBlock()));
            roundBlocks.add(new Block("B", new BlockGenerator().nextAdvancedBlock()));
            roundBlocks.add(new Block("C", new BlockGenerator().nextAdvancedBlock()));
        }
    }

    /**
     * Prints out the elements needed to display and play a round
     */
    public void showRound() {

        System.out.println();

        System.out.println(board);

        if (score > 0) {
            System.out.println("Score: " + score + "\n");
        }

        System.out.println("Blocks to play:");

        for (int i = 0; i < roundBlocks.size(); i++) {
            System.out.println(roundBlocks.get(i));
        }

        if (!errorMessage.isBlank()) {
            System.out.println("WARNING: " + errorMessage + "\n");
            this.errorMessage = "";
        }

        System.out.print("Type your next move (Block-ColumnLine): ");
    }

    /**
     * Setter for error message
     *
     * @param errorMessage
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
