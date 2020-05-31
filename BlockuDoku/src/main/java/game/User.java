/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;

/**
 *
 * @author Storm
 */
public class User implements Serializable {

    private String name;
    private Game game;
    private Scoreboard<Game> personalScores;

    public User(String name) {

        this.name = name;
        personalScores = new Scoreboard<>();

    }

    public boolean loadGame() {
        if (game != null) {
            game.play();
            System.out.println("Loading Game...");
            return true;
        } else {
            System.out.println("You don't have a game to load...");
            return false;
        }
    }

    public Scoreboard<Game> getPersonalScores() {
        return personalScores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    @Override
    public String toString() {
        return name + ": " + game;
    }
}
