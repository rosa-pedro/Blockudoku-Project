
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author rosap
 */
public class GameLogic {
    private static Scoreboard<User> userHighScores = new Scoreboard();
    
    public GameLogic() {
        
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
