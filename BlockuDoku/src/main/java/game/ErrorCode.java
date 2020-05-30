/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author rosap
 */
public enum ErrorCode {
    
    INVALID_ROUND_BLOCK, INVALID_COMMAND, INVALID_BLOCK_INSERTION;
    
    @Override
    public String toString(){
        switch(this){
            case INVALID_ROUND_BLOCK:
                return "Invalid Block";
            case INVALID_BLOCK_INSERTION:
                return "Invalid Block Insertion";
            default:
                return "Invalid Command";
        }
    }
}
