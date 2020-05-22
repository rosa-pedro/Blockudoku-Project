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
public class ITwoBlock extends Piece{

    public ITwoBlock() {
        super(PieceName.I_TWO_BLOCK);
    }
    
    @Override
    public void buildPieceWithzeroRotation() {
        
        String[] coords = {"A1", "A2"};
        buildPiece(coords, coords[0]);
    }
    
    @Override
    public void buildPieceWithNinetyRotation() {
       
        String[] coords = {"A1", "B1"};
        buildPiece(coords, coords[0]);
    }
    
    @Override
    public void buildPieceWithHundredEightyRotation(){
        
        buildPieceWithzeroRotation();
        
    }
    
    @Override
    public void buildPieceWithTwoHundredSeventyRotation(){
      
        buildPieceWithNinetyRotation();
    }
}
