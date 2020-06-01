/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/** This class hosts the GameMode enum and its toString() method
 * 
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public enum GameMode {
    
    BASIC_MODE, ADVANCED_MODE;
    
    /**
     * Overrides the toString() method
     * to return a String object
     * 
     * @return 
     */
    @Override
    public String toString(){
        
        switch(this) {
            case BASIC_MODE: return "Basic mode";
            
            default: return "Advanced mode";
        }
    }
}
