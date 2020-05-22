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
public class LMinimumBlock extends Piece{

    public LMinimumBlock() {
        super(PieceName.L_MINIMUM_BLOCK);
    }
    
    @Override
    public void buildPieceWithzeroRotation() {
        
        String[] coords = {"A1", "A2", "B2"};
        buildPiece(coords, coords[0]);
    }
    
    @Override
    public void buildPieceWithNinetyRotation() {
       
        String[] coords = {"A1", "B1", "A2"};
        buildPiece(coords, coords[0]);
    }
    
    @Override
    public void buildPieceWithHundredEightyRotation(){
        
        String[] coords = {"A1", "B1", "B2"};
        buildPiece(coords, coords[0]);
        
    }
    
    @Override
    public void buildPieceWithTwoHundredSeventyRotation(){
      
        String[] coords = {"B1", "A2", "B2"};
        buildPiece(coords, coords[1]);
    }
    
}
