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
public class JBlock extends Piece{
    
    public JBlock() {
        super(PieceName.J_BLOCK);
    }
    
    @Override
    public void buildPieceWithzeroRotation() {
        
        String[] coords = {"B1", "B2", "B3", "A3"};
        buildPiece(coords, coords[3]);
    }
    
    @Override
    public void buildPieceWithNinetyRotation() {
       
        String[] coords = {"A1", "A2", "B2", "C2"};
        buildPiece(coords, coords[0]);
    }
    
    @Override
    public void buildPieceWithHundredEightyRotation(){
        
        String[] coords = {"A1", "B1", "A2", "A3"};
        buildPiece(coords, coords[0]);
        
    }
    
    @Override
    public void buildPieceWithTwoHundredSeventyRotation(){
      
        String[] coords = {"A1", "B1", "C1", "C2"};
        buildPiece(coords, coords[0]);
    }
    
}
