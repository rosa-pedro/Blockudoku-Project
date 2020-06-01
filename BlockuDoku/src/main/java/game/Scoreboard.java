/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/** This class Stores the ArrayList of scores of type
 * Score<E>
 *
 * @author Pedro Rosa - 190221015
 * @author Joao Cetano - 190221010
 */
public class Scoreboard<E> implements Serializable {

    ArrayList<Score<E>> scoreboard;
    private E element;
    
    /**
     * Initialises the scoreboard ArrayList()
     */
    public Scoreboard() {
        this.scoreboard = new ArrayList<>();
    }

    /**
     * Creates a Score Object based off the element and score and inserts it into 
     * the scoreboard
     * 
     * @param element E
     * @param score int
     */
    public void insertScore(E element, int score) {

        if (element != null) {
            scoreboard.add(new Score<>(element, score));
        }
    }

    /**
     * Getter for HighestScore in the scoreboard List
     * 
     * @return highest Score object
     */
    public Score getHighestScore() {

        return (scoreboard.isEmpty()) ? null : Collections.min(scoreboard);
    }

    /**
     * Getter for scoreboard
     *  
     * @return ArrayList<Score<E>> scoreboard
     */
    public ArrayList<Score<E>> getScoreboard() {
        return scoreboard;
    }
    
    /**
     * Getter for element
     * 
     * @return E element
     */
    public E getElement() {
        return element;
    }

    /**
     * Returns true if scoreboard is empty, false if not 
     * 
     * @return true if empty, false if not 
     */
    public boolean isEmpty() {

        return scoreboard.isEmpty();
    }

    /**
     * Clears the scoreboard
     * 
     */
    public void clear() {
        scoreboard.clear();
    }

    /**
     * Overrides the to String method in order to better present the scoreboard
     * 
     * @return String object 
     */
    @Override
    public String toString() {

        Collections.sort(scoreboard);

        StringBuilder sb = new StringBuilder();

        sb.append("------------ Scoreboard ------------\n");

        Iterator it = scoreboard.iterator();

        int position = 1;
        while (position <= 10) {

            if (it.hasNext()) {

                Score<E> score = (Score<E>) it.next();
                sb.append(String.format("%d - %-26s - %3d \n", position, score.getElement().toString(), score.getValue()));
                
            } else {

                sb.append(position + " -\n");
            }
            position++;
        }

        return sb.toString();
    }
}
