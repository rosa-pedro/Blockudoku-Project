/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;

/**
 *
 * @author rosap
 */
public class Square implements Serializable{
    
    private static final long serialVersionUID = 9873268974234L;
    
    private boolean isVisible;
    
    public Square(Boolean isVisible){
        
        this.isVisible = isVisible;
    }
    
    public void changeVisibility() {
        
        isVisible = (isVisible) ? false : true;
    }

    public boolean isVisible() {
        return isVisible;
    }
    
    @Override
    public String toString(){
        return isVisible ? "#" : ".";
    }
}
