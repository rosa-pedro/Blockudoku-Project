/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Storm
 */
public class Block {
    String blockName;
    Piece piece;
    
    public Block(String name, Piece piece){
        blockName = name;
        this.piece = piece;
    }
    
    public Piece getBlockPiece(){
        return piece;
    }
    
    public String getBlockName(){
        return blockName;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Block " + blockName + "\n");
        sb.append(piece);
        //sb.append("\n");
        return sb.toString();
    }
}
