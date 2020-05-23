/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author Storm
 */
public class Scoreboard {
   ArrayList<Score<User>> scoreboard = new ArrayList<>();
   
   public Scoreboard(){
       scoreboard = new ArrayList<>();
   }
   /*
   public void insertScore(User user, int score){
       if(user != null){
           scoreboard.add(new Score<>(user, score));
       }
   }*/
   
   public void insertScore(Score score){
       scoreboard.add(score);
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
                Score<User> score = (Score<User>) it.next();
                sb.append(position + " - " + score.getElement().getName() + ":\t    " + score.getScore() + "\n");
            } else {
                sb.append(position + " -\n");
            }
            position++;
        }
       
        return sb.toString();
    }
}
