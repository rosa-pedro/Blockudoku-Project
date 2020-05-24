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

    ArrayList<Block> playableBlocks = new ArrayList<>();
    String[] commands;
    Menu menu;
    Block selectedBlock;
    
    boolean inserted = true;
    boolean removed = true;

    public GameRound(Board board, Parser p) {

        boolean finished = true;

        menu = new Menu();

        while (finished) {

            if (playableBlocks.isEmpty()) {
                generateBlocks();
            }
            showRound(board, playableBlocks);

            finished = play(p, board);
            
            BoardLogic.parseBoard(board);
            
            
        }
    }

    public boolean play(Parser p, Board board) {

        String input = p.readInput();

        while (!input.equalsIgnoreCase("return")) {

            commands = p.processGameCommand(input);

            Iterator<Block> itr = playableBlocks.iterator();

            while (itr.hasNext()) {

                selectedBlock = itr.next();
                removed = true;

                if (selectedBlock.getBlockName().equalsIgnoreCase(commands[0])) {

                    Piece piece = selectedBlock.getBlockPiece();

                    inserted = board.insertBlock(piece, commands[1]);

                    if (!inserted) {
                        removed = false;
                        continue;
                    }

                    itr.remove();
                } else {
                    removed = false;
                }
            }

            return true;
        }
        if (input.equalsIgnoreCase("return")) {
            menu.mainMenu();
            return false;
        }
        return true;
    }

    public void generateBlocks() {

        playableBlocks.add(new Block("A", new BlockGenerator().nextBlock()));
        playableBlocks.add(new Block("B", new BlockGenerator().nextBlock()));
        playableBlocks.add(new Block("C", new BlockGenerator().nextBlock()));
    }

    public void showRound(Board board, ArrayList<Block> playableBlocks) {
        System.out.println(board);

        for (int i = 0; i < playableBlocks.size(); i++) {
            System.out.println(playableBlocks.get(i));
        }
        
        if (!removed) {
            System.out.println("Enter a Valid Block\n");
        }
         
        if (!inserted) {
            System.out.println("Invalid position\n");
        }

        System.out.println("Type your next move (Block-ColumnLine) : ");
    }
}
