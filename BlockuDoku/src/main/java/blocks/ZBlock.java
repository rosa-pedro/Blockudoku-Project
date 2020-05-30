/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import game.Piece;
import game.PieceName;

/** This class consists exclusively of void methods that help building ZBlock Piece
 * 
 *
 * @author Pedro Rosa - 190221015
 * @author Joao Cetano - 190221010
 */
public class ZBlock extends Piece{

    /** Constructor for class ZBlock, creates a piece after the PieceName enum.
     */
    public ZBlock() {
        super(PieceName.Z_BLOCK);
    }
    
    /** Overrides the method buildPieceWithzeroRotation() to represent a ZBlock
     * with zero degree rotation.
     */
    @Override
    public void buildPieceWithzeroRotation() {
        
        String[] coords = {"A1", "B1", "B2", "C2"};
        buildPiece(coords, coords[0]);
    }
    
    /** Overrides the method buildPieceWithNinetyRotation() to represent a ZBlock
     * with ninety degree rotation.
     */
    @Override
    public void buildPieceWithNinetyRotation() {
       
        String[] coords = {"B1", "A2", "B2", "A3"};
        buildPiece(coords, coords[1]);
    }
    
    /** Overrides the method buildPieceWithHundredEightyRotation() to represent a ZBlock
     * with hundred and seventy degree rotation.
     */
    @Override
    public void buildPieceWithHundredEightyRotation(){
        
        buildPieceWithzeroRotation();
        
    }
    
    /** Overrides the method buildPieceWithTwoHundredSeventyRotation() to represent a ZBlock
     * with two hundred and seventy degree rotation
     */
    @Override
    public void buildPieceWithTwoHundredSeventyRotation(){
      
        buildPieceWithNinetyRotation();
    }
    
}
