/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ips.blockudoku.game;

/**
 *
 * @author rosap
 */
public class Square {
    
    private boolean isVisible;
    
    public Square(Boolean isVisible){
        this.isVisible = isVisible;
    }
    
    @Override
    public String toString(){
        return "#";
    }
}
