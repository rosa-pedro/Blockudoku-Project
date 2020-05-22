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
public class Square {
    
    private boolean isVisible;
    
    public Square(Boolean isVisible){
        
        this.isVisible = isVisible;
    }
    
    public void changeVisibility() {
        
        isVisible = (isVisible) ? false : true;
    }
    
    @Override
    public String toString(){
        return isVisible ? "#" : ".";
    }
}
