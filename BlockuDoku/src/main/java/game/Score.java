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
public class Score<E> implements Comparable<Score<E>>, Serializable {

    private int value;
    private E element;

    private LocalDateTime time;

    public Score(E element, int value) {
        this.value = value;
        this.element = element;
    }

    public int getValue() {
        return value;
    }

    public E getElement() {
        return element;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public int compareTo(Score<E> score) {
        return score.getValue() - this.value;
    }
}
