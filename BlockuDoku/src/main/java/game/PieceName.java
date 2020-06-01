/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/** This enum represents all the possible PieceNames
 * 
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public enum PieceName {
    I_BLOCK, Q_BLOCK, T_BLOCK, L_BLOCK, J_BLOCK, S_BLOCK, Z_BLOCK, 
    I_ONE_BLOCK, I_TWO_BLOCK, I_THREE_BLOCK, L_MINIMUM_BLOCK, 
    L_MAXIMUM_BLOCK, T_EXTENDED_BLOCK, Q_EXTENDED_BLOCK;
    
    
    /**
     * Overrides the toString() method in order to return a String object corresponding
     * to the enum value
     * 
     * @return String object
     */
    @Override
    public String toString(){
        
        switch(this) {
            case I_BLOCK: return "I Block";
            
            case Q_BLOCK: return "Q Block";
            
            case T_BLOCK: return "T Block";
            
            case L_BLOCK: return "L Block";
            
            case J_BLOCK: return "J Block";
            
            case S_BLOCK: return "S Block";
            
            case Z_BLOCK: return "Z Block";
            
            case I_ONE_BLOCK: return "I One Block";
            
            case I_TWO_BLOCK: return "I Two Block";
            
            case I_THREE_BLOCK: return "I Three Block";
            
            case L_MINIMUM_BLOCK: return "L Minimum Block";
            
            case L_MAXIMUM_BLOCK: return "L Maximum Block";
            
            case T_EXTENDED_BLOCK: return "T Extended Block";
            
            case Q_EXTENDED_BLOCK: return "Q Extended Block";
            
            default: return "None";
        }
    }
    
}
