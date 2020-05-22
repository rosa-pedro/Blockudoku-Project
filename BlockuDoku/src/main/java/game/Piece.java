/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author rosap
 */
public abstract class Piece {

    private HashMap<String, Square> piece;
    
    private PieceName pieceName;

    private String pivot;
    private int rows;
    private int columns;

    public Piece(PieceName pieceName) {
        
        piece = new HashMap<>();
        
        this.pieceName = pieceName;
        
        this.pivot = "Unassigned Pivot";
        this.rows = 0;
        this.columns = 0;
        
        buildPieceWithRandomRotation();
    }
    
    public void buildPieceWithRandomRotation() {
        
        Random random = new Random();
        int number = random.nextInt(4);
        
        switch(number){
            
            case 1: buildPieceWithNinetyRotation();
                    break;
            
            case 2: buildPieceWithHundredEightyRotation();
                    break;
                    
            case 3: buildPieceWithTwoHundredSeventyRotation();
                    break;
                    
            default: buildPieceWithzeroRotation();
        }
    }
    
    public abstract void buildPieceWithzeroRotation();
    
    public abstract void buildPieceWithNinetyRotation();
    
    public abstract void buildPieceWithHundredEightyRotation();
    
    public abstract void buildPieceWithTwoHundredSeventyRotation();
    

    public void buildPiece(String coords[], String pivot) {

        this.pivot = pivot;
        
        initializePieceDimensions(coords);

        for (int i = 0; i < coords.length; i++) {
            
            piece.put(coords[i], new Square());
        }
    }

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
    
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= rows; i++) {
            String idx;
            for (int j = 0; j < columns; j++) {
                idx = String.valueOf((char) (65 + j));
                idx = idx.concat(String.valueOf(i));
                if (piece.containsKey(idx)) {
                    sb.append(piece.get(idx));
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public HashMap<String, Square> getPiece() {
        return piece;
    }

    public PieceName getPieceName() {
        return pieceName;
    }

    public String getPivot() {
        return pivot;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
