/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Storm
 * @param <E>
 */
public class Score<E> implements Comparable<Score<E>> {

    private int score;
    private E element;

    /*
    public Score(E element, int value) {
        this.score = value;
        this.element = element;
    }*/
    
    public Score(E element) {
        this.score = 0;
        this.element = element;
    }
    
    public void addScore(int score){
        this.score += score;
    }
    
    public int getScore() {
        return score;
    }

    public E getElement() {
        return element;
    }

    @Override
    public int compareTo(Score<E> score) {
        return score.getScore() - this.score;
    }
}

