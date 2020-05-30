/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author rosap
 */
public class Command {
    
    private String blockCommand;
    private String coordCommand;

    public Command(String blockCommand, String coordCommand) {
        
        this.blockCommand = blockCommand.toUpperCase();
        this.coordCommand = coordCommand.toUpperCase();
    }
    
    public String getBlockCommand(){
        return blockCommand;
    }
    
    public String getCoordCommand(){
        return coordCommand;
    }
    
    public boolean isBlockCommandValid(){
        
        return blockCommand.equals("A") || blockCommand.equals("B") || blockCommand.equals("C");
    }
    
    public boolean isCoordCommandvalid(Board board){
        
        HashMap<String, Square> boardCoords = board.getCoords();
        return boardCoords.containsKey(coordCommand);
    }
    
    public boolean isCommandValid(Board board){

        return isBlockCommandValid() && isCoordCommandvalid(board);
    }
}
