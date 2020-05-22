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
public class QExtendedBlock extends Piece {

    public QExtendedBlock() {
        super(PieceName.Q_EXTENDED_BLOCK);
    }
    
    @Override
    public void buildPieceWithzeroRotation() {
        
        String[] coords = {"A1", "B1", "C1", "A2", "B2", "C2", "A3", "B3", "C3"};
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
