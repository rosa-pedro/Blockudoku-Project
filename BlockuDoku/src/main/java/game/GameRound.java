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

    private boolean inserted;
    private boolean blockFound;
    private boolean isCommandValid;
    private Board board;
    private GameMode gameMode;
    private ArrayList<Block> roundBlocks;
    private int score;

    public GameRound(Board board, GameMode gameMode) {

        this.inserted = false;
        this.blockFound = true;
        this.isCommandValid = true;
        this.board = board;
        this.gameMode = gameMode;
        this.roundBlocks = new ArrayList<>();
        this.score = 0;
    }

    /*public boolean checkMove(Command command){
        return command.isCommandvalid(board);
    }*/
       
    public void move(Command command) {
        
        if(!command.isCommandValid(board)){
            isCommandValid = false;
            return;
        }

        Iterator itr = roundBlocks.iterator();
        Block itrBlock;

        while (itr.hasNext()) {
            itrBlock = (Block) itr.next();

            if (itrBlock.getBlockName().equals(command.getBlockCommand())) {
                
                blockFound = true;
                Piece piece = itrBlock.getBlockPiece();
                inserted = board.insertBlock(piece, command.getCoordCommand());
                
                if (inserted) {
                    itr.remove();
                    score += piece.getPieceScore(gameMode);
                }
                return;
            }
        }
        blockFound = false;
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
        
        /*if(score > 0){
            System.out.println("Score: " + score);
        }*/
        
        System.out.println(board);
        
        if(score > 0){
            System.out.println("Score: " + score + "\n");
        }
        
        System.out.println("Blocks to play:");

        for (int i = 0; i < roundBlocks.size(); i++) {
            System.out.println(roundBlocks.get(i));
        }

        if (!inserted || !blockFound) {
            System.out.println("Invalid Move\n");
        }
        
        if(isCommandValid) {
            System.out.println("Invalid Command");
        }

        System.out.print("Type your next move (Block-ColumnLine) :");
        //System.out.println(isCommandValid?"":"(Invalid Command)");
    }
}
