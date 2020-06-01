/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/** This enum represents the error codes used for error control
 * 
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public enum ErrorCode {
    
    INVALID_ROUND_BLOCK, INVALID_COMMAND, INVALID_BLOCK_INSERTION, 
    USERNAME_CANT_BE_NULL, USERNAME_CANT_BE_EMPTY;
    
    /**
     * Overrides the toString() method in order to return a 
     * string corresponding to the error
     * 
     * @return String related to the enum value
     */
    
    @Override
    public String toString(){
        switch(this){
            case INVALID_ROUND_BLOCK:
                return "Invalid Block";
            case INVALID_BLOCK_INSERTION:
                return "Invalid Block Insertion";
            case USERNAME_CANT_BE_NULL:
                return "Username can't be null";
            case USERNAME_CANT_BE_EMPTY:
                return "Username can't be empty";
            default:
                return "Invalid Command";
        }
    }
}
