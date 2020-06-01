/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * This class Serves as helper implementing the Comparable Interface
 * in order to help us sort our Lists
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class Score<E> implements Comparable<Score<E>>, Serializable {

    private int value;
    private E element;

    private LocalDateTime time;

    /**
     * Constructor receives and sets an E element and an int value
     * 
     * @param element Element to be set
     * @param value value to be set
     */
    public Score(E element, int value) {
        this.value = value;
        this.element = element;
    }

    /**
     * Getter for value 
     * 
     * @return int value
     */
    public int getValue() {
        return value;
    }

    /**
     * Getter for element
     * @return E element
     */
    public E getElement() {
        return element;
    }
    
    /**
     * Getter for time
     * 
     * @return LocalDateTime time
     */
    public LocalDateTime getTime() {
        return time;
    }

    
    /**
     * Override compareTo() in order to order the Score object based off their
     * int value
     * 
     * @param score we are ordering
     * @return int difference between Objects allows us to determine if one is greater than the other
     */
    @Override
    public int compareTo(Score<E> score) {
        return score.getValue() - this.value;
    }
}
