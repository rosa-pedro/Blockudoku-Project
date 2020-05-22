/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import game.Piece;
import game.PieceName;

/**
 *
 * @author rosap
 */
public class LMaximumBlock extends Piece {

    public LMaximumBlock() {
        super(PieceName.L_MAXIMUM_BLOCK);
    }
    
    @Override
    public void buildPieceWithzeroRotation() {
        
        String[] coords = {"A1", "A2", "A3", "B3", "C3"};
        buildPiece(coords, coords[0]);
    }
    
    @Override
    public void buildPieceWithNinetyRotation() {
       
        String[] coords = {"A1", "B1", "C1", "A2", "A3"};
        buildPiece(coords, coords[0]);
    }
    
    @Override
    public void buildPieceWithHundredEightyRotation(){
        
        String[] coords = {"A1", "B1", "C1", "C2", "C3"};
        buildPiece(coords, coords[0]);
        
    }
    
    @Override
    public void buildPieceWithTwoHundredSeventyRotation(){
      
        String[] coords = {"C1", "C2", "A3", "B3", "C3"};
        buildPiece(coords, coords[2]);
    }

    
}
