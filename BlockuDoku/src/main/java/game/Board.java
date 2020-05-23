/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.HashMap;
import java.util.HashSet;

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

        HashSet<String> coords = parseBlockToBoardCoords(block, position);

        if (!verifyBlock(coords)) {
            return false;
        }

        coords.forEach(c -> changeSquareVisibility(c));

        return true;
    }
    
    public boolean canInsertBlock(Piece block, String position) {
        
        HashSet<String> coords = parseBlockToBoardCoords(block, position);

        if (!verifyBlock(coords)) {
            return false;
        }

        return true;
        
    }

    public boolean verifyBlock(HashSet<String> coords) {

        return coords.stream().allMatch(c -> board.containsKey(c) && !board.get(c).isVisible());
    }

    public HashSet<String> parseBlockToBoardCoords(Piece block, String position) {

        HashMap<String, Square> blockCoords = block.getPiece();
        String pivot = block.getPivot();

        int columnDifference = position.charAt(0) - pivot.charAt(0);
        int rowDifference = position.charAt(1) - pivot.charAt(1);

        HashSet<String> coords = new HashSet<>();
        String coord;

        for (String c : blockCoords.keySet()) {

            coord = String.valueOf((char) (c.charAt(0) + columnDifference));
            coord = coord.concat(String.valueOf((char) (c.charAt(1) + rowDifference)));

            coords.add(coord);
        }

        return coords;
    }
    
    public HashSet<String> getBoardSquare(String first, String last) {
        
        HashSet<String> boardSquare = new HashSet<>();
        String key;
        
        int firstColumn = (int)(first.charAt(0) - 'A');
        int firstRow = Integer.parseInt(String.valueOf(first.charAt(1)));
        
        int lastColumn = (int)(last.charAt(0) - 'A');
        int lastRow = Integer.parseInt(String.valueOf(last.charAt(1)));
        

        for (int i = firstRow; i <= lastRow; i++) {

            for (int j = firstColumn; j <= lastColumn; j++) {

                key = String.valueOf((char) (65 + j));
                key = key.concat(String.valueOf(i));

                boardSquare.add(key);
            }
        }
 
        return boardSquare;
    }
    
    public void clearBoard(HashSet<String> coords) {
        
        coords.stream().forEach(c -> changeSquareVisibility(c));
    }
    
    public void clearBoard() {
        
        board.entrySet().stream().filter(e -> e.getValue().isVisible()).forEach(e -> changeSquareVisibility(e.getKey()));
    }

    public void clearRow(Integer row) {

        String key;

        for (int i = 0; i < 9; i++) {

            key = String.valueOf((char) (65 + i));
            key = key.concat(String.valueOf(row));

            changeSquareVisibility(key);
        }
    }
    
    public void clearColumn(String column) {

        String key;

        for (int i = 1; i <= 9; i++) {

            key = String.valueOf(column);
            key = key.concat(String.valueOf(i));

            changeSquareVisibility(key);
        }
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

    public HashMap<String, Square> getCoords() {
        return board;
    }

}
