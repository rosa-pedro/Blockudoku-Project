/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.HashMap;
import java.util.HashSet;

/** This class serves to format String inputs into commands used 
 * in game 
 * 
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class Command {
    
    private String blockCommand;
    private String coordCommand;

    /**
     * Constructor for Command class,
     * takes two string and turns them into a Command
     * 
     * @param blockCommand String for the Block
     * @param coordCommand String for the Coordinates
     */
    public Command(String blockCommand, String coordCommand) {
        
        this.blockCommand = blockCommand.toUpperCase();
        this.coordCommand = coordCommand.toUpperCase();
    }
    
    /**
     * getter for block command
     * 
     * @return blockCommand 
     */
    public String getBlockCommand(){
        return blockCommand;
    }
    
    /**
     * getter for CoordCommand
     * 
     * @return coordCommand 
     */
    public String getCoordCommand(){
        return coordCommand;
    }
    
    /**
     * Checks if the Command corresponds to a valid Block 
     * 
     * @return true if the Block is valid, false if not 
     */
    public boolean isBlockCommandValid(){
        
        return blockCommand.equals("A") || blockCommand.equals("B") || blockCommand.equals("C");
    }
    
    /**
     * Checks if the coordCommand is within the boards scope
     * 
     * @param board
     * @return true if the command is valid, false if the coordCommand does not exist within the board
     */
    public boolean isCoordCommandvalid(Board board){
        
        HashMap<String, Square> boardCoords = board.getCoords();
        return boardCoords.containsKey(coordCommand);
    }
    
    /**
     * Uses isBlockCommandValid() and isCoordCommandvalid(board)
     * to check if the command object is valid
     * 
     * @param board
     * @return true if valid, false if not
     */
    public boolean isCommandValid(Board board){

        return isBlockCommandValid() && isCoordCommandvalid(board);
    }
}
