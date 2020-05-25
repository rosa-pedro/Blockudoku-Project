/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Storm
 */
public class Game<E> implements Serializable{
    
    private E element;
    private String name;
    
    public Game(E element ){
        this.element = element;
        name = "gamezao";
    }
    
    
    public E getElement(){
        return element;
    }
    
    public String getName(){
        return name;
    }
}
