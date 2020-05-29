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
public enum GameMode {
    
    BASIC_MODE, ADVANCED_MODE;
    
    @Override
    public String toString(){
        
        switch(this) {
            case BASIC_MODE: return "Basic mode";
            
            default: return "Advanced mode";
        }
    }
}
