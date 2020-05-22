/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.HashMap;

/**
 *
 * @author rosap
 */
public abstract class Piece {

    private HashMap<String, Square> piece;
    private String pivot;

    public Piece(String pivot) {
        piece = new HashMap<>();
        this.pivot = pivot;
    }

    public void addSquare(String coords) {
        piece.put(coords, new Square(true));
    }

    ;
    
    abstract public void buildPiece();

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 5; i++) {
            String idx;
            for (int j = 0; j < 5; j++) {
                idx = "" + (char) (65 + j);
                idx = idx.concat("" + i);
                if (piece.containsKey(idx)) {
                    sb.append(piece.get(idx));
                } else {
                    sb.append(" ");
                }
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
