/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 *
 * @author Storm
 */
public class User {
    
    private String name;
    private Game game;
    private Scoreboard personalScoreBoard;
    
    ArrayList<Score<User>> personalScores = new ArrayList<>();
    
    public User(String name){
        this.name = name;
    }   

    public void addPersonalScore(Score score){
        if(score != null){
        personalScores.add(score);
        }
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setGame(Game game){
        
    }
    
    
    
    public Game getGame(){
        return game;
    }
}
