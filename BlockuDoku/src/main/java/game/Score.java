/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Storm
 * @param <E>
 */
public class Score<E> implements Comparable<Score<E>> , Serializable{
    
    private static final long serialVersionUID = 9873268974234L;
    private int score;
    private E element;
    private LocalDateTime time;
    private String userName;
    
    /*
    public Score(E element, int value) {
        this.score = value;
        this.element = element;
    }*/
    
    public Score(E element){
        this.score = 0;
        this.element = element;
    }
    
    public Score(E element, int score, String userName){
        this.element = element;
        this.score =  score;
        this.userName = userName;
    }         
    
    public void addScore(int score){
        this.score = this.score + score;
        time = LocalDateTime.now();
    }
    
    public int getScore() {
        return score;
    }

    public E getElement() {
        return element;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public LocalDateTime getTime(){
        return time;
    }

    @Override
    public int compareTo(Score<E> score) {
        return score.getScore() - this.score;
    }
}

