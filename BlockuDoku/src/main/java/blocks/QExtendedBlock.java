/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import game.Piece;
import game.PieceName;

/** This class consists exclusively of void methods that help building QExtendedBlock Piece
 * 
 *
 * @author Pedro Rosa - 190221015
 * @author Joao Cetano - 190221010
 */
public class QExtendedBlock extends Piece {
    
    /** Constructor for class QExtendedBlock, creates a piece after the PieceName enum.
     */
    public QExtendedBlock() {
        super(PieceName.Q_EXTENDED_BLOCK);
    }
    
    /** Overrides the method buildPieceWithzeroRotation() to represent a QExtendedBlock
     * with zero degree rotation.
     */
    @Override
    public void buildPieceWithzeroRotation() {
        
        String[] coords = {"A1", "B1", "C1", "A2", "B2", "C2", "A3", "B3", "C3"};
        buildPiece(coords, coords[0]);
    }
    
    /** Overrides the method buildPieceWithHundredEightyRotation() to represent a QExtendedBlock
     * with hundred and seventy degree rotation, since the QExtendedBlock is shaped like a square its 
     * rotation is redundant this buildPieceWithzeroRotation() is recalled.
     */
    @Override
    public void buildPieceWithNinetyRotation() {
       
        buildPieceWithzeroRotation();
    }
    
    /** Overrides the method buildPieceWithHundredEightyRotation() to represent a QExtendedBlock
     * with hundred and seventy degree rotation, since the QExtendedBlock is shaped like a square its 
     * rotation is redundant this buildPieceWithzeroRotation() is recalled.
     */
    @Override
    public void buildPieceWithHundredEightyRotation(){
        
        buildPieceWithzeroRotation();
        
    }
    
    /** Overrides the method buildPieceWithTwoHundredSeventyRotation() to represent a QExtendedBlock
     * with two hundred and seventy degree rotation, since the QExtendedBlock is shaped like a square its 
     * rotation is redundant this buildPieceWithzeroRotation() is recalled.
     */
    @Override
    public void buildPieceWithTwoHundredSeventyRotation(){
      
        buildPieceWithzeroRotation();
    }
    
}
