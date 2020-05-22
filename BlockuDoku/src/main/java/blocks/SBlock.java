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
public class SBlock extends Piece{

    public SBlock() {
        super(PieceName.S_BLOCK);
    }
    
    @Override
    public void buildPieceWithzeroRotation() {
        
        String[] coords = {"B1", "C1", "A2", "B2"};
        buildPiece(coords, coords[2]);
    }
    
    @Override
    public void buildPieceWithNinetyRotation() {
       
        String[] coords = {"A1", "A2", "B2", "B3"};
        buildPiece(coords, coords[0]);
    }
    
    @Override
    public void buildPieceWithHundredEightyRotation(){
        
        buildPieceWithNinetyRotation();
        
    }
    
    @Override
    public void buildPieceWithTwoHundredSeventyRotation(){
      
        buildPieceWithNinetyRotation();
    }
}
