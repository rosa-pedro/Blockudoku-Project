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
 * @author Storm
 */
public class User implements Serializable{
    
    private static final long serialVersionUID = 9873268974234L;
    private String name;
    private Game game;
    
    private Scoreboard<Game> personalScores; 
    
    //ArrayList<Score<User>> personalScores = new ArrayList<>();

    
    public User(String name){
        
        this.name = name;
        personalScores = new Scoreboard();
        
    }   

    
    public boolean loadGame(){
        if(game != null){
            game.play();
            System.out.println("Loading Game...");
            return true;
        }else {
            System.out.println("You don't have a game to load...");
            return false;
        }
    }
    
    
    public String getPersonalGameList(){
        
        return personalScores.toStringGame();
    }
    
    public void addPersonalScore(Game game, int score){
        
        if(game != null){
            Score<Game> gameScore = new Score<>(game);
            gameScore.addScore(score);
            gameScore.setUserName(name);
            game.setGameScore(score);
            personalScores.insertScore(gameScore);
        }
    }
    
    public void addPersonalScore(Score<Game> score){
        personalScores.insertScore(score);
    }
    
    public Score getHighScore(){
        
        /*ArrayList scores = personalScores.getScoreboard();
        Score score = (Score)scores.get(0);*/
        
        Score score = (Score)personalScores.getScoreboard().get(0);
        
        //int max = score.getScore();
        
        for (int i = 1; i < personalScores.getScoreboard().size(); i++) {
            
            Score tmp = (Score)personalScores.getScoreboard().get(i);
            
            if(tmp.getScore()>score.getScore()){
                
                score = tmp;
            }
        }
        
        return score;
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
