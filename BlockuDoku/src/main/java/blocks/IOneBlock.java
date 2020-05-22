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
public class IOneBlock  extends Piece{

    public IOneBlock() {
        super(PieceName.I_ONE_BLOCK);
    }
    
     @Override
    public void buildPieceWithzeroRotation() {
        
        String[] coords = {"A1"};
        buildPiece(coords, coords[0]);
    }
    
    @Override
    public void buildPieceWithNinetyRotation() {
       
        buildPieceWithzeroRotation();
    }
    
    @Override
    public void buildPieceWithHundredEightyRotation(){
        
        buildPieceWithzeroRotation();
        
    }
    
    @Override
    public void buildPieceWithTwoHundredSeventyRotation(){
      
        buildPieceWithzeroRotation();
    }
    
}
