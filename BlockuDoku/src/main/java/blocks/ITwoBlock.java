/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import game.Piece;
import game.PieceName;

/** This class consists exclusively of void methods that help building ITwoBlock Piece
 * 
 *
 * @author Pedro Rosa - 190221015
 * @author Joao Cetano - 190221010
 */
public class ITwoBlock extends Piece{
    
    /** Constructor for class ITwoBlock, creates a piece after the PieceName enum
     */
    public ITwoBlock() {
        super(PieceName.I_TWO_BLOCK);
    }
    
    /** Overrides the method buildPieceWithzeroRotation() to represent an ITwoBlock
     * with zero degree rotation.
     */
    @Override
    public void buildPieceWithzeroRotation() {
        
        String[] coords = {"A1", "A2"};
        buildPiece(coords, coords[0]);
    }
    
    /** Overrides the method buildPieceWithzeroRotation() to represent an ITwoBlock
     * with zero degree rotation.
     */
    @Override
    public void buildPieceWithNinetyRotation() {
       
        String[] coords = {"A1", "B1"};
        buildPiece(coords, coords[0]);
    }
    
    /** Overrides the method buildPieceWithHundredEightyRotation() to represent an ITwoBlock
     * with hundred and eighty degree rotation, since this is the same as buildPieceWithzeroRotation()
     * the method is recalled.
     */
    @Override
    public void buildPieceWithHundredEightyRotation(){
        
        buildPieceWithzeroRotation();
        
    }
    
    /** Overrides the method buildPieceWithTwoHundredSeventyRotation() to represent an ITwoBlock
     * with two hundred and seventy degree rotation, since this is the same as buildPieceWithNinetyRotation()
     * the method is recalled.
     */
    @Override
    public void buildPieceWithTwoHundredSeventyRotation(){
      
        buildPieceWithNinetyRotation();
    }
}
