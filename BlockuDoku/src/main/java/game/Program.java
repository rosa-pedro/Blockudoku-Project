/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import blocks.QBlock;
import blocks.IOneBlock;
import blocks.SBlock;
import blocks.QExtendedBlock;
import blocks.LBlock;
import blocks.ITwoBlock;
import blocks.ZBlock;
import blocks.LMaximumBlock;
import blocks.TExtendedBlock;
import blocks.IThreeBlock;
import blocks.TBlock;
import blocks.LMinimumBlock;
import blocks.JBlock;
import blocks.IBlock;
import java.util.ArrayList;

/**
 *
 * @author rosap
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Blocos ########################\n");

        ArrayList<Piece> pieces = new ArrayList<>();

        pieces.add(new IBlock());
        pieces.add(new QBlock());
        pieces.add(new TBlock());
        pieces.add(new LBlock());
        pieces.add(new JBlock());
        pieces.add(new SBlock());
        pieces.add(new ZBlock());
        pieces.add(new IOneBlock());
        pieces.add(new ITwoBlock());
        pieces.add(new IThreeBlock());
        pieces.add(new LMinimumBlock());
        pieces.add(new LMaximumBlock());
        pieces.add(new TExtendedBlock());
        pieces.add(new QExtendedBlock());

        System.out.println("Blocos:\n");
        
        pieces.forEach(p -> {
            System.out.println(p.getPieceName());
            System.out.println(p);
        });
        
        System.out.println("Board ########################\n");
        
        Board board = new Board();
        
        System.out.println(board);
        
        Piece piece = BlockGenerator.nextBlock();
        
        if(!board.insertBlock(piece, "D4")) {
            System.out.println("Deu Asneira Capitão!!!");
        };
        
        System.out.println(board);
        
        if(!board.insertBlock(piece, "E5")) {
            System.out.println("Deu Asneira Capitão!!!");
        };
        
        System.out.println(board);
        
        if(!board.insertBlock(piece, "C1")) {
            System.out.println("Deu Asneira Capitão!!!");
        };
        
        System.out.println(board);
        
        
        //

        /*
        boolean finished = false;
        
        Parser p1 = new Parser();
        User user = new User("Maleque");
        ProcessCommand pc = new ProcessCommand();
        Menu m1 = new Menu();

        while(!finished){
           m1.welcomeMenu(user);
           finished = pc.processCommand(user, p1.readInput(), m1.getMenuState());

        }
        
         */
    }

}
