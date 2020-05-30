/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Storm
 */
public class GameRound implements Serializable {

    private static final long serialVersionUID = 9873268974234L;

    private Board board;
    private GameMode gameMode;
    private ArrayList<Block> roundBlocks;
    private int score;
    private String errorMessage;

    public GameRound(Board board, GameMode gameMode) {

        this.board = board;
        this.gameMode = gameMode;
        this.roundBlocks = new ArrayList<>();
        this.score = 0;
        this.errorMessage = "";
    }
    
    public Command validateCommand(Command command) throws GameIllegalArgumentException {

        if(command == null || !command.isCommandValid(board)){
            
            throw new GameIllegalArgumentException(ErrorCode.INVALID_COMMAND);
        }
        
        return command;
    }
    
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

    public boolean checkRound() {

        if (roundBlocks.isEmpty()) {
            generateBlocks();
        }
        score += BoardCleanUpLogic.cleanUpBoard(board);
        return !isGameOver();
    }

    public int getScore() {
        return score;
    }

    public boolean isGameOver() {

        return roundBlocks.stream().allMatch(b -> !board.isThereSpaceleftInTheBoard(b.getBlockPiece()));
    }

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
        
        if(!errorMessage.isBlank()) {
            System.out.println("WARNING:" + errorMessage + "\n");
            this.errorMessage = "";
        }

        System.out.print("Type your next move (Block-ColumnLine) :");
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
