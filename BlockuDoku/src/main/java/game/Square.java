package game;

import java.io.Serializable;

/**
 * This class represents a Square, several Squares will be used to fill up the
 * Board
 *
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class Square implements Serializable {

    private boolean isVisible;

    /**
     * Constructor for Square, sets the isVisible attribute
     *
     * @param isVisible used to set isVisible attribute
     */
    public Square(Boolean isVisible) {

        this.isVisible = isVisible;
    }

    /**
     * Changes the value of isVisible to its opposite
     *
     */
    public void changeVisibility() {

        isVisible = (isVisible) ? false : true;
    }

    /**
     * Getter for isVisible()
     *
     * @return boolean isVisible
     */
    public boolean isVisible() {
        return isVisible;
    }

    /**
     * Overrides the toString() method to display # if visible, . if not
     *
     * @return String object
     */
    @Override
    public String toString() {
        return isVisible ? "#" : ".";
    }
}
