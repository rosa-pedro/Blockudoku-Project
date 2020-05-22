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
public class TBlock extends Piece{

    public TBlock() {
        
        super(PieceName.T_BLOCK);
    }
    
    @Override
    public void buildPieceWithzeroRotation() {
        
        String[] coords = {"A1", "B1", "C1", "B2"};
        buildPiece(coords, coords[0]);
    }
    
    @Override
    public void buildPieceWithNinetyRotation() {
       
        String[] coords = {"B1", "A2", "B2", "B3"};
        buildPiece(coords, coords[1]);
    }
    
    @Override
    public void buildPieceWithHundredEightyRotation(){
        
        String[] coords = {"A1", "A2", "B2", "A3"};
        buildPiece(coords, coords[0]);
    }
    
    @Override
    public void buildPieceWithTwoHundredSeventyRotation(){
      
        String[] coords = {"B1", "A2", "B2", "C2"};
        buildPiece(coords, coords[1]);
    }
    
}
