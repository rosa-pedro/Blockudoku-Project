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
public class LBlock extends Piece{

    public LBlock() {
        super(PieceName.L_BLOCK);
    }
    
    @Override
    public void buildPieceWithzeroRotation() {
        
        String[] coords = {"A1", "A2", "A3", "B3"};
        buildPiece(coords, coords[0]);
    }
    
    @Override
    public void buildPieceWithNinetyRotation() {
       
        String[] coords = {"A1", "B1", "C1", "A2"};
        buildPiece(coords, coords[0]);
    }
    
    @Override
    public void buildPieceWithHundredEightyRotation(){
        
        String[] coords = {"A1", "B1", "B2", "B3"};
        buildPiece(coords, coords[0]);
        
    }
    
    @Override
    public void buildPieceWithTwoHundredSeventyRotation(){
      
        String[] coords = {"A2", "B2", "C2", "C1"};
        buildPiece(coords, coords[0]);
    }
    
}
