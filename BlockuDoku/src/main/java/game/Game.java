/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Storm
 */
public class Game<E> {
    private E element;
    
    
    public Game(E element ){
        this.element = element;
    }
    
    
    public E getElement(){
        return element;
    }
}
