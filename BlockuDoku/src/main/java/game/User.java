package game;

import java.io.Serializable;

/**
 * This class represents the User, his name, current game and his Scoreboard of
 * personalScores
 *
 * @author Pedro Rosa - 190221015
 * @author Joao Cetano - 190221010
 */
public class User implements Serializable {

    private String name;
    private Game game;
    private Scoreboard<Game> personalScores;

    public User(String name) {

        this.game = null;
        this.name = name;
        this.personalScores = new Scoreboard<>();

    }

    public Scoreboard<Game> getPersonalScores() {
        return personalScores;
    }

    public String getName() {
        return name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    @Override
    public String toString() {
        return name + ":  " + personalScores.getHighestScore().getElement();
    }
}
