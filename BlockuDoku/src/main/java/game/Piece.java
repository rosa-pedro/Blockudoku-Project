/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * This class builds the piece based off its pieceName
 * by initialising a HashMap containing its Coordinates 
 * 
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public abstract class Piece implements Serializable {

    private HashMap<String, Square> piece;

    private PieceName pieceName;

    private String pivot;
    private int rows;
    private int columns;

    /**
     * Constructor for Piece, initialises the HashMap
     * sets the pieceName and initialises the other attributes 
     * with standard values 
     * @param pieceName 
     */
    public Piece(PieceName pieceName) {

        piece = new HashMap<>();

        this.pieceName = pieceName;

        this.pivot = "Unassigned Pivot";
        this.rows = 0;
        this.columns = 0;

        buildPieceWithRandomRotation();
    }

    /**
     * Generates a random number between [1,3] and uses it to 
     * randomize the rotation that the piece will be built with 
     * 
     */
    public void buildPieceWithRandomRotation() {

        Random random = new Random();
        int number = random.nextInt(4);

        switch (number) {

            case 1:
                buildPieceWithNinetyRotation();
                break;

            case 2:
                buildPieceWithHundredEightyRotation();
                break;

            case 3:
                buildPieceWithTwoHundredSeventyRotation();
                break;

            default:
                buildPieceWithzeroRotation();
        }
    }
    /**
     * Necessary abstract method for buildPieceWithzeroRotation()
     */
    public abstract void buildPieceWithzeroRotation();

    /**
     * Necessary abstract method for buildPieceWithNinetyRotation()
     */
    public abstract void buildPieceWithNinetyRotation();

    /**
     * Necessary abstract method for buildPieceWithHundredEightyRotation()
     */
    public abstract void buildPieceWithHundredEightyRotation();

    /**
     * Necessary abstract method for buildPieceWithTwoHundredSeventyRotation()
     */
    public abstract void buildPieceWithTwoHundredSeventyRotation();

    /**
     * Void method that builds the piece 
     * 
     * @param coords coordinates that map the Piece
     * @param pivot sets this as the pivot of the Piece
     */
    public void buildPiece(String coords[], String pivot) {

        this.pivot = pivot;

        initializePieceDimensions(coords);

        for (int i = 0; i < coords.length; i++) {

            piece.put(coords[i], new Square(true));
        }
    }
    
    /**
     * Gets the score that a piece would give
     * 
     * @param gameMode The GameMode is necessary as BASIC gives one point for each Square and 
     * ADVANCED gives two instead
     * @return int representing the calculated score
     */
    public int getPieceScore(GameMode gameMode){
    
        return (gameMode == GameMode.BASIC_MODE) ? piece.size() : 2 * piece.size();
    }

    /**
     * Initialises the matrix in which the piece will be put it initially 
     * ensuring that we won't use bigger matrixes than what is needed
     * @param coords Coordinates of the Piece
     */
    public void initializePieceDimensions(String coords[]) {

        Set<Character> rowsSet = new HashSet<Character>();
        Set<Character> columnsSet = new HashSet<Character>();

        for (int i = 0; i < coords.length; i++) {

            columnsSet.add(coords[i].charAt(0));
            rowsSet.add(coords[i].charAt(1));
        }

        rows = rowsSet.size();
        columns = columnsSet.size();
    }

    /**
     * Overrides toString() method to better display a piece
     * @return String
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        String key;

        for (int i = 1; i <= rows; i++) {

            for (int j = 0; j < columns; j++) {

                key = String.valueOf((char) (65 + j));
                key = key.concat(String.valueOf(i));

                if (piece.containsKey(key)) {

                    sb.append(piece.get(key) + " ");
                    
                } else {

                    sb.append("  ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
    
    
    /**
     * getter for Piece
     * @return returns a HashMap with the Coordinates as key and the corresponding Square
     * as the value of each key
     */
    public HashMap<String, Square> getPiece() {
        return piece;
    }

    /**
     * 
     * @return pieceName 
     */
    public PieceName getPieceName() {
        return pieceName;
    }

    /**
     * 
     * @return pivot
     */
    public String getPivot() {
        return pivot;
    }

    /**
     * 
     * @return rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * 
     * @return columns
     */
    public int getColumns() {
        return columns;
    }
}
