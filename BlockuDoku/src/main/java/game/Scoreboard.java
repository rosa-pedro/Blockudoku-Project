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

/**
 *
 * @author rosap
 */
public class Scoreboard<E> implements Serializable {

    ArrayList<Score<E>> scoreboard;
    private E element;

    public Scoreboard() {
        this.scoreboard = new ArrayList<>();
    }

    public void insertScore(E element, int score) {

        if (element != null) {
            scoreboard.add(new Score<>(element, score));
        }
    }

    public Score getHighestScore() {

        return (scoreboard.isEmpty()) ? null : Collections.max(scoreboard);
    }

    public ArrayList<Score<E>> getScoreboard() {
        return scoreboard;
    }

    public E getElement() {
        return element;
    }

    public boolean isEmpty() {

        return scoreboard.isEmpty();
    }

    public void clear() {
        scoreboard.clear();
    }

    @Override
    public String toString() {

        Collections.sort(scoreboard);

        StringBuilder sb = new StringBuilder();

        sb.append("------ Ranking ------\n");

        Iterator it = scoreboard.iterator();

        int position = 1;
        while (position <= 10) {

            if (it.hasNext()) {

                Score<E> score = (Score<E>) it.next();

                sb.append(position + " - " + score.getElement().toString() + " -\t    " + score.getValue() + "\n");
            } else {

                sb.append(position + " -\n");
            }
            position++;
        }

        return sb.toString();
    }
}
