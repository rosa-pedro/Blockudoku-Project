/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author rosap
 */
public class Board implements Serializable{
    
    private static final long serialVersionUID = 9873268974234L;
    
    private HashMap<String, Square> board;

    public Board() {

        board = new HashMap<>();
        initializeBoard();
    }

    public void initializeBoard() {

        String coord;

        for (int i = 1; i <= 9; i++) {

            for (int j = 0; j < 9; j++) {

                coord = getCoordinate(i, j);
                board.put(coord, new Square(false));
            }
        }
    }

    public String getCoordinate(int row, int column) {

        String key = String.valueOf((char) (65 + column));
        key = key.concat(String.valueOf(row));

        return key;
    }

    public String getCoordinate(int row, String column) {

        String key = column;
        key = key.concat(String.valueOf(row));

        return key;
    }

    public void changeCoordVisibility(String coord) {

        board.get(coord).changeVisibility();
    }

    public boolean insertBlock(Piece block, String coord) {

        HashSet<String> coords = convertBlockCoordsToBoardCoords(block, coord);

        if (!isValidInsertionCoords(coords)) {
            return false;
        }
        coords.forEach(c -> changeCoordVisibility(c));

        return true;
    }

    public boolean isBlockInsertable(Piece block, String coord) {

        HashSet<String> coords = convertBlockCoordsToBoardCoords(block, coord);

        if (!isValidInsertionCoords(coords)) {
            return false;
        }
        return true;
    }

    public boolean isValidInsertionCoords(HashSet<String> coords) {

        return coords.stream().allMatch(c -> board.containsKey(c) && !board.get(c).isVisible());
    }

    public HashSet<String> convertBlockCoordsToBoardCoords(Piece block, String position) {

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

    public void clearBoard(HashSet<String> coords) {

        coords.stream().forEach(c -> changeCoordVisibility(c));
    }

    public void clearBoard() {

        board.entrySet().stream().filter(c -> c.getValue().isVisible()).forEach(c -> changeCoordVisibility(c.getKey()));
    }

    public boolean isThereSpaceleftInTheBoard(Piece piece) {

        return board.entrySet().stream().anyMatch(e -> isBlockInsertable(piece, e.getKey()));
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        String coord;

        sb.append(" |A|B|C|D|E|F|G|H|I\n");

        for (int i = 1; i <= 9; i++) {

            sb.append(i);

            for (int j = 0; j < 9; j++) {

                coord = getCoordinate(i, j);
                sb.append("|" + board.get(coord));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public HashMap<String, Square> getCoords() {
        return board;
    }
}
