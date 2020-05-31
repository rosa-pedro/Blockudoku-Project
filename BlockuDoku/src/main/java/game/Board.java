/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

/** This class Creates and maintains the board
 * it's composed by a HashMap where the key is the string 
 * corresponding to the Coordinate and the value is the
 * Square corresponding to the coordinate 
 * 
 *
 * @author Pedro Rosa - 190221015
 * @author Joao Cetano - 190221010
 */
public class Board implements Serializable{
    
    private static final long serialVersionUID = 9873268974234L;
    
    private HashMap<String, Square> board;

    /**
     * Constructor for class Board
     * initializes the board HashMap
     * and calls the initializeBoard() method
     */
    public Board() {

        board = new HashMap<>();
        initializeBoard();
    }

    
    /**
     * Method to initialize the board,
     * fills the whole board with Squares that aren't visible 
     */
    public void initializeBoard() {

        String coord;

        for (int i = 1; i <= 9; i++) {

            for (int j = 0; j < 9; j++) {

                coord = getCoordinate(i, j);
                board.put(coord, new Square(false));
            }
        }
    }

    /**
     * Method to get a coordinate in our board
     * takes the row and column integers and
     * concats them into a String
     * 
     * @param row
     * @param column
     * @return String containing the coordinate
     */
    public String getCoordinate(int row, int column) {

        String key = String.valueOf((char) (65 + column));
        key = key.concat(String.valueOf(row));

        return key;
    }
    
    /**
     * Method to get a coordinate in our board
     * takes the row and column integers and
     * concats them into a String
     * 
     * @param row
     * @param column
     * @return String containing the coordinate
     */
    public String getCoordinate(int row, String column) {

        String key = column;
        key = key.concat(String.valueOf(row));

        return key;
    }
    
    /**
     * Takes a coordinate and change its visibility
     * 
     * @param coord the coordinate we choose to change visibility to 
     */
    private void changeCoordVisibility(String coord) {

        board.get(coord).changeVisibility();
    }

    
    /**
     * Method to insert a block into the board,
     * it takes the Piece and the Coordinates for 
     * the pivot coordinate and then changes the visibility 
     * of every block in order to display it 
     * 
     * @param block which we are inserting
     * @param coord coordinates of where we are inserting
     * @return true if successful  insert and false if the insert failed
     */
    public boolean insertBlock(Piece block, String coord) {

        HashSet<String> coords = convertBlockCoordsToBoardCoords(block, coord);

        if (!isValidInsertionCoords(coords)) {
            return false;
        }
        coords.forEach(c -> changeCoordVisibility(c));

        return true;
    }

    
    /**
     * Checks if the block is insertable, 
     * receives the coordinates of the block and the piece
     * it represents 
     * 
     * @param block which we are checking 
     * @param coord coordinates of where we are checking is its possible to insert
     * @return true if insertable false if not 
     */
    public boolean isBlockInsertable(Piece block, String coord) {

        HashSet<String> coords = convertBlockCoordsToBoardCoords(block, coord);

        if (!isValidInsertionCoords(coords)) {
            return false;
        }
        return true;
    }

    
    /**
     * Checks if the coordinates are within the board 
     * and if it isn't already visible 
     * 
     * @param coords coordinates that we are checking  
     * @return if the coordinates are valid or not
     */
    public boolean isValidInsertionCoords(HashSet<String> coords) {

        return coords.stream().allMatch(c -> board.containsKey(c) && !board.get(c).isVisible());
    }

    
    /**
     * Converts coordinates from Block to Board coordinates 
     * so that we can insert the block into the Board
     * 
     * @param block Block piece 
     * @param position String position we are inserting
     * @return coordinates to be inserted onto the board
     */
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

    /**
     * Changes the visibility of the inserted coordinates
     * this clearing the board
     * 
     * @param coords coordinates which we are clearing
     */
    public void clearBoard(HashSet<String> coords) {

        coords.stream().forEach(c -> changeCoordVisibility(c));
    }

    /**
     * Clears the board by changing every squares visibility 
     */
    public void clearBoard() {

        board.entrySet().stream().filter(c -> c.getValue().isVisible()).forEach(c -> changeCoordVisibility(c.getKey()));
    }
    
    /**
     * Takes a piece and checks if there is space left in the board for it to be inserted
     * 
     * @param piece we are trying to insert
     * @return true if there is enough space left for the piece and false if there isn't
     */
    public boolean isThereSpaceleftInTheBoard(Piece piece) {

        return board.entrySet().stream().anyMatch(e -> isBlockInsertable(piece, e.getKey()));
    }

    /**
     * Overrides the toString method to 
     * better display the board
     * 
     * @return formatted board in String
     */
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
