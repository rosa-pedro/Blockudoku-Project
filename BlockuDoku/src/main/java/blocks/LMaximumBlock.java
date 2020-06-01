/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import game.Piece;
import game.PieceName;

/** This class consists exclusively of void methods that help building IThreeBlock Piece
 * 
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class LMaximumBlock extends Piece {

    /** Constructor for class LMaximumBlock, creates a piece after the PieceName enum.
     */
    public LMaximumBlock() {
        super(PieceName.L_MAXIMUM_BLOCK);
    }
    
    /** Overrides the method buildPieceWithzeroRotation() to represent a LMaximumBlock
     * with zero degree rotation.
     */
    @Override
    public void buildPieceWithzeroRotation() {
        
        String[] coords = {"A1", "A2", "A3", "B3", "C3"};
        buildPiece(coords, coords[0]);
    }
    
    /** Overrides the method buildPieceWithNinetyRotation() to represent a LMaximumBlock
     * with ninety degree rotation.
     */
    @Override
    public void buildPieceWithNinetyRotation() {
       
        String[] coords = {"A1", "B1", "C1", "A2", "A3"};
        buildPiece(coords, coords[0]);
    }
    
    /** Overrides the method buildPieceWithHundredEightyRotation() to represent a LMaximumBlock
     * with hundred and seventy degree rotation.
     */
    @Override
    public void buildPieceWithHundredEightyRotation(){
        
        String[] coords = {"A1", "B1", "C1", "C2", "C3"};
        buildPiece(coords, coords[0]);
        
    }
    
    /** Overrides the method buildPieceWithTwoHundredSeventyRotation() to represent a LMaximumBlock
     * with two hundred and seventy degree rotation
     */
    @Override
    public void buildPieceWithTwoHundredSeventyRotation(){
      
        String[] coords = {"C1", "C2", "A3", "B3", "C3"};
        buildPiece(coords, coords[2]);
    }

    
}
