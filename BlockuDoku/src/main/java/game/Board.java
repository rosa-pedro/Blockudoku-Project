/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rosap
 */
public class Board {

    private HashMap<String, Square> board;

    public Board() {

        board = new HashMap<>();

        initializeBoard();
    }

    public void initializeBoard() {

        String key;

        for (int i = 1; i <= 9; i++) {

            for (int j = 0; j < 9; j++) {

                key = String.valueOf((char) (65 + j));
                key = key.concat(String.valueOf(i));

                board.put(key, new Square(false));
            }
        }
    }
    
    
    public void changeSquareVisibility(String position) {
        
        board.get(position).changeVisibility();
    }
    
    public boolean insertBlock(Piece block, String position) {
        
        HashMap<String, Square> blockCoords = block.getPiece();
        String pivot = block.getPivot();
        
        int columnDiff = position.charAt(0) - pivot.charAt(0);
        int rowDiff = position.charAt(1) - pivot.charAt(1);
        
        String boardPosition;
        
        for(String s : blockCoords.keySet()) {
            
            boardPosition = String.valueOf((char)(s.charAt(0) + columnDiff));
            boardPosition = boardPosition.concat(String.valueOf((char)(s.charAt(1) + rowDiff)));
            
            changeSquareVisibility(boardPosition);
        }
        
        return true;
    }
    
    
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        String key;

        sb.append(" |A|B|C|D|E|F|G|H|I\n");

        for (int i = 1; i <= 9; i++) {

            sb.append(i);

            for (int j = 0; j < 9; j++) {

                key = String.valueOf((char) (65 + j));
                key = key.concat(String.valueOf(i));

                sb.append("|" + board.get(key));

            }

            sb.append("\n");
        }

        return sb.toString();
    }

}
