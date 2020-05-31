/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import java.io.Serializable;

/** This class represents a Block used in game, a block is composed of its name 
 * and of the Piece it's represented by.
 * 
 *
 * @author Pedro Rosa - 190221015
 * @author Joao Cetano - 190221010
 */
public class Block implements Serializable {
    String blockName;
    Piece piece;
    
    /**
     * Constructor for class Block
     * 
     * @param name name of the Block
     * @param piece piece of the Block
     */
    public Block(String name, Piece piece){
        blockName = name;
        this.piece = piece;
    }
    
    /**
     * Getter for piece 
     * 
     * @return piece
     */
    public Piece getBlockPiece(){
        return piece;
    }
    
    /**
     * Getter for block name
     * 
     * @return blockName String containing the blocks name
     */
    public String getBlockName(){
        return blockName;
    }
    
    
    /**
     * Overrides toString method to return a better representation 
     * 
     * @return formatted String
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Block " + blockName + "\n");
        sb.append(piece);
        return sb.toString();
    }
}
