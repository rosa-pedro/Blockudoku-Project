/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Storm
 */
public class GameRound {

    private boolean inserted;
    private boolean blockFound;
    private Board board;
    private GameMode gameMode;
    private ArrayList<Block> roundBlocks;

    public GameRound(Board board, GameMode gameMode) {

        this.inserted = false;
        this.blockFound = true;
        this.board = board;
        this.gameMode = gameMode;
        this.roundBlocks = new ArrayList<>();
    }

    public void move(String[] commands) {

        Iterator itr = roundBlocks.iterator();
        Block itrBlock;

        while (itr.hasNext()) {
            itrBlock = (Block) itr.next();

            if (itrBlock.getBlockName().equals(commands[0])) {
                blockFound = true;
                Piece piece = itrBlock.getBlockPiece();
                inserted = board.insertBlock(piece, commands[1]);
                
                if (inserted) {
                    itr.remove();
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
        BoardCleanUpLogic.cleanUpBoard(board);
        return !isGameOver();
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

        System.out.println(board);

        for (int i = 0; i < roundBlocks.size(); i++) {
            System.out.println(roundBlocks.get(i));
        }

        if (!inserted || !blockFound) {
            System.out.println("Invalid Move\n");
        }

        System.out.print("Type your next move (Block-ColumnLine) : ");
    }
}
