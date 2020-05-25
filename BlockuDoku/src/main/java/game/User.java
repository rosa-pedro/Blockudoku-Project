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
public class User implements Serializable{
    
    private String name;
    private Game game;
    
    private Scoreboard<Game> personalScores; 
    
    //ArrayList<Score<User>> personalScores = new ArrayList<>();
    
    public User(String name){
        this.name = name;
        personalScores = new Scoreboard();
    }   

    public void addPersonalScore(Game game, int score){
        if(game != null){
            Score gameScore = new Score(game);
            gameScore.addScore(score);
        personalScores.insertScore(new Score(game));
        }
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setGame(Game game){
        this.game = game;
    }
    
    public Scoreboard getScoreboard(){
        return personalScores;
    }
    
    public Game getGame(){
        return game;
    }
}
