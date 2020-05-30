
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.HashMap;
import java.util.HashSet;

/** This class consists of static methods 
 * 
 *
 * @author Pedro Rosa - 190221015
 * @author Joao Cetano - 190221010
 */
public class BoardCleanUpLogic {

    /**
     * Method that cleans up the board
     * by checking if there are any completed Squares
     * Rows or Columns and returns the according points
     * 
     * @param board the board we are applying the method to
     * @return the score gathered by cleaning up the board
     */
    public static int cleanUpBoard(Board board) {
        
        int scoreBycleanUp = 0;
        
        HashSet<String> toBeCleanUp = getFullSquares(board);
        toBeCleanUp.addAll(getFullRows(board));
        toBeCleanUp.addAll(getFullColumns(board));

        if (!toBeCleanUp.isEmpty()) {
            
            scoreBycleanUp = getCleanUpBoardScore(board, toBeCleanUp);
            board.clearBoard(toBeCleanUp);
            
        }
        return scoreBycleanUp;
    }
    
    /**
     * Converts the score from cleaning up the board into points 
     * 
     * @param board the board we are applying the method to
     * @param toBeCleanUp HashSet containing the Columns Rows and Squares 
     * @return the numerical score attached to the Squares cleared
     */
    public static int getCleanUpBoardScore(Board board, HashSet<String> toBeCleanUp){
        
        int numberOfFullSquares = (getFullSquares(board).size())/9;
        int scoreByCleanUp = toBeCleanUp.size()*4 + numberOfFullSquares*10;
        
        return scoreByCleanUp;
    }

    /**
     * Gets the row assigned to the int value
     * 
     * @param board board we are using the method in 
     * @param row the row we want to get
     * @return HashSet containing the coordinates of the Squares in the row 
     */
    public static HashSet<String> getRowSection(Board board, int row) {

        HashSet<String> rowSectionCoords = new HashSet<>();
        String coord;

        for (int i = 0; i < 9; i++) {

            coord = board.getCoordinate(row, i);
            rowSectionCoords.add(coord);
        }
        return rowSectionCoords;
    }
    
    /**
     * Gets the rows that are fully filled 
     * 
     * @param board we are using the method in 
     * @return HashSet containing the  rows that are full
     */
    public static HashSet<String> getFullRows(Board board) {

        HashMap<String, Square> boardCoords = board.getCoords();
        HashSet<String> fullRows = new HashSet<>();
        HashSet<String> rowSection = new HashSet<>();

        for (int i = 1; i <= 9; i++) {

            rowSection = getRowSection(board, i);

            if (rowSection.stream().allMatch(c -> boardCoords.get(c).isVisible())) {
                fullRows.addAll(rowSection);
            }
        }
        return fullRows;
    }
    
    /**
     * Gets the column assigned to the String value
     * 
     * @param board board we are using the method in 
     * @param column the column we want to get
     * @return HashSet containing the coordinates of the Squares in the column 
     */
    public static HashSet<String> getColumnSection(Board board, String column) {

        HashSet<String> columnSectionCoords = new HashSet<>();
        String coord;

        for (int i = 1; i <= 9; i++) {

            coord = board.getCoordinate(i, column);
            columnSectionCoords.add(coord);
        }
        return columnSectionCoords;
    }
    
    /**
     * Gets the columns that are fully filled 
     * 
     * @param board we are using the method in 
     * @return HashSet containing the  columns that are full
     */
    public static HashSet<String> getFullColumns(Board board) {

        HashMap<String, Square> boardCoords = board.getCoords();
        HashSet<String> fullColumns = new HashSet<>();
        HashSet<String> columnSection = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            columnSection = getColumnSection(board, String.valueOf((char) (65 + i)));

            if (columnSection.stream().allMatch(c -> boardCoords.get(c).isVisible())) {
                fullColumns.addAll(columnSection);
            }
        }
        return fullColumns;
    }

    /**
     * Gets the square section, a square is defined by the first coordinate(top left)
     * and last cord (bottom right)
     * 
     * @param board where we are using the method in 
     * @param firstCoord of the square
     * @param lastCoord of the square
     * @return HashSet contain the squares coordinates
     */
    public static HashSet<String> getSquareSection(Board board, String firstCoord, String lastCoord) {

        HashSet<String> squareSectionCoords = new HashSet<>();
        String coord;

        int firstColumn = (int) (firstCoord.charAt(0) - 'A');
        int firstRow = Integer.parseInt(String.valueOf(firstCoord.charAt(1)));

        int lastColumn = (int) (lastCoord.charAt(0) - 'A');
        int lastRow = Integer.parseInt(String.valueOf(lastCoord.charAt(1)));

        for (int i = firstRow; i <= lastRow; i++) {

            for (int j = firstColumn; j <= lastColumn; j++) {

                coord = board.getCoordinate(i, j);
                squareSectionCoords.add(coord);
            }
        }
        return squareSectionCoords;
    }
    
    /**
     * Gets the squares that are fully filled 
     * 
     * @param board we are using the method in 
     * @return HashSet containing the squares that are full
     */
    public static HashSet<String> getFullSquares(Board board) {

        HashMap<String, Square> boardCoords = board.getCoords();
        HashSet<String> fullSquares = new HashSet<>();

        String firstCoord, secondCoord;

        for (int i = 1; i <= 9; i = i + 3) {

            for (int j = 0; j < 9; j = j + 3) {

                firstCoord = board.getCoordinate(i, j);
                secondCoord = board.getCoordinate(i + 2, j + 2);

                HashSet<String> squareSection = getSquareSection(board, firstCoord, secondCoord);

                if (squareSection.stream().allMatch(c -> boardCoords.get(c).isVisible())) {
                    fullSquares.addAll(squareSection);
                }
            }
        }
        return fullSquares;
    }
}
