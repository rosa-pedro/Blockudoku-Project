/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import blocks.*;
import java.util.ArrayList;
import java.util.HashSet;

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

        IBlock iBlock = new IBlock();
        System.out.println(iBlock);

        pieces.forEach(p -> {
            System.out.println(p.getPieceName());
            System.out.println(p);
        });

        System.out.println("Board ########################\n");

        Board board = new Board();

        System.out.println(board);

        Piece piece = BlockGenerator.nextBlock();

        if (!board.insertBlock(piece, "D4")) {
            System.out.println("Deu Asneira Capitão!!!");
        };

        System.out.println(board);

        if (!board.insertBlock(piece, "E5")) {
            System.out.println("Deu Asneira Capitão!!!");
        };

        System.out.println(board);

        if (!board.insertBlock(piece, "C1")) {
            System.out.println("Deu Asneira Capitão!!!");
        };

        System.out.println(board);

        board.changeSquareVisibility("A8");
        board.changeSquareVisibility("B8");
        board.changeSquareVisibility("C8");
        board.changeSquareVisibility("D8");
        board.changeSquareVisibility("E8");
        board.changeSquareVisibility("F8");
        board.changeSquareVisibility("G8");
        board.changeSquareVisibility("H8");
        board.changeSquareVisibility("I8");

        board.changeSquareVisibility("A9");
        board.changeSquareVisibility("B9");
        board.changeSquareVisibility("C9");
        board.changeSquareVisibility("D9");
        board.changeSquareVisibility("E9");
        board.changeSquareVisibility("F9");
        board.changeSquareVisibility("G9");
        board.changeSquareVisibility("H9");
        board.changeSquareVisibility("I9");

        System.out.println(board);

        GameLogic gameLogic = new GameLogic();

        HashSet<Integer> fullRows = gameLogic.getFullRows(board);

        fullRows.forEach(r -> System.out.println(r));

        board.clearRow(9);

        System.out.println(board);

        board.changeSquareVisibility("I1");
        board.changeSquareVisibility("I2");
        board.changeSquareVisibility("I3");
        board.changeSquareVisibility("I4");
        board.changeSquareVisibility("I5");
        board.changeSquareVisibility("I6");
        board.changeSquareVisibility("I7");
        //board.changeSquareVisibility("I8");
        board.changeSquareVisibility("I9");

        System.out.println(board);

        HashSet<String> fullColumns = gameLogic.getFullColumns(board);

        fullColumns.forEach(c -> System.out.println(c));

        board.clearColumn("I");

        System.out.println(board);

        board.clearBoard();

        System.out.println(board);

        HashSet<String> squareCoords1 = board.getBoardSquare("A1", "H3");

        squareCoords1.forEach(c -> System.out.println(c));

        squareCoords1.forEach(c -> board.changeSquareVisibility(c));

        System.out.println(board);

        HashSet<String> squareCoords2 = board.getBoardSquare("A4", "H8");

        squareCoords2.forEach(c -> board.changeSquareVisibility(c));

        System.out.println(board);
        
        System.out.println(gameLogic.canInsertBlockInBoard(board, piece));

        HashSet<String> fullSquares = gameLogic.getFullSquares(board);

        board.clearBoard(fullSquares);

        System.out.println(board);

        System.out.println(gameLogic.canInsertBlockInBoard(board, piece));
        
        
        //

        /*

        boolean finished = false;
        
        Parser p1 = new Parser();
        User user = new User("Maleque");
        ProcessCommand pc = new ProcessCommand();
        Menu m1 = new Menu();
        m1.welcomeMenu(user);
        
        while(!finished){
           finished = pc.processCommand(user, p1.readInput(), m1.getMenuState());
        }
         */
    }

}
