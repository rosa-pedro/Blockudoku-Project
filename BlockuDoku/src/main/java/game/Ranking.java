
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 *
 * @author rosap
 */
public class Ranking {

    private static Scoreboard<User> userHighScores = new Scoreboard();

    public Ranking() {

    }

    public static void addUserHighScore(Score score) {
        if (score != null) {
            userHighScores.insertScore(score);
        }
    }

    public static Scoreboard getHighScoreBoard() {
        return userHighScores;
    }

    public static void addAllHighScoresFromList(ArrayList<User> users) {
        if (users != null || users.size() > 0) {
            for (int i = 0; i < users.size(); i++) {
                addUserHighScore(users.get(i).getHighScore());
            }
        }
    }
}
