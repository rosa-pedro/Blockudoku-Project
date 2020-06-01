/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import game.Piece;
import game.PieceName;

/** This class consists exclusively of void methods that help building SBlock Piece
 * 
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class SBlock extends Piece{

    /** Constructor for class SBlock, creates a piece after the PieceName enum.
     */
    public SBlock() {
        super(PieceName.S_BLOCK);
    }
    
    /** Overrides the method buildPieceWithzeroRotation() to represent a SBlock
     * with zero degree rotation.
     */
    @Override
    public void buildPieceWithzeroRotation() {
        
        String[] coords = {"B1", "C1", "A2", "B2"};
        buildPiece(coords, coords[2]);
    }
    
     /** Overrides the method buildPieceWithNinetyRotation() to represent a SBlock
     * with ninety degree rotation.
     */
    @Override
    public void buildPieceWithNinetyRotation() {
       
        String[] coords = {"A1", "A2", "B2", "B3"};
        buildPiece(coords, coords[0]);
    }
    
    /** Overrides the method buildPieceWithHundredEightyRotation() to represent a SBlock
     * with hundred and seventy degree rotation, since the SBlock is shaped like an s laid
     * on its side whether it has suffered hundred and eighty or no rotation is indifferent
     * thus the buildPieceWithzeroRotation() method is recalled.
     */
    @Override
    public void buildPieceWithHundredEightyRotation(){
        
        buildPieceWithzeroRotation();
        
    }
    
    /** Overrides the method buildPieceWithHundredEightyRotation() to represent a SBlock
     * with hundred and seventy degree rotation, since the SBlock is shaped like an s laid
     * on its side whether it has suffered two hundred and seventy or ninety rotation is indifferent
     * thus the buildPieceWithNinetyRotation() method is recalled.
     */
    @Override
    public void buildPieceWithTwoHundredSeventyRotation(){
      
        buildPieceWithNinetyRotation();
    }
}
