
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;



/**
 *
 * @author rosap
 */
public class Ranking {
    private static Scoreboard<User> userHighScores = new Scoreboard();
    
    public Ranking() {
        
    }
    
    public static void addUserHighScore(Score score){
        if(score != null){
        userHighScores.insertScore(score);
        }
    }
    
    public static Scoreboard getScoreboard(){
        return userHighScores;
    }
}
