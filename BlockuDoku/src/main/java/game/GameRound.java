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

    public GameRound(Board board, Parser p) {

        boolean finished = true;

        menu = new Menu();
        
        playableBlocks.add(new Block("A", new BlockGenerator().nextBlock()));
        playableBlocks.add(new Block("B", new BlockGenerator().nextBlock()));
        playableBlocks.add(new Block("C", new BlockGenerator().nextBlock()));
        
        
        showRound(board, playableBlocks);
        
        while (finished) {
            finished = play(p, board);
        }
    }

    public boolean play(Parser p, Board board) {
        
        String  input = p.readInput();
        boolean finished = false;
        boolean removed = false;
        
        while (!input.equalsIgnoreCase("return")) {
            
            commands = p.processGameCommand(input);
            
             Iterator<Block> itr = playableBlocks.iterator();
            
            while (itr.hasNext()) {
                selectedBlock = itr.next();
                if (selectedBlock.getBlockName().equals(commands[0])) {
                    itr.remove();
                    showRound(board, playableBlocks);
                    
                }
            }
            if(!removed){
                System.out.println("Enter a Valid Block\n"); 
            }
            
            return finished = true;
        }
        if (input.equalsIgnoreCase("return")) {
            menu.mainMenu();
            return finished;
        }
        return finished = true;
    }

    public void showRound(Board board, ArrayList<Block> playableBlocks) {
        System.out.println(board);

        for (int i = 0; i < playableBlocks.size() ; i++) {
            System.out.println(playableBlocks.get(i));
        }

        System.out.print("\nType your next move (Block-ColumnLine) : ");
    }
}
