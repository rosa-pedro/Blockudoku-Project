package blocks;

import game.Piece;
import game.PieceName;

/**
 * This class consists exclusively of void methods that help building
 * LMinimumBlock Piece
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class LMinimumBlock extends Piece {

    /**
     * Constructor for class LMinimumBlock, creates a piece after the PieceName
     * enum.
     */
    public LMinimumBlock() {
        super(PieceName.L_MINIMUM_BLOCK);
    }

    /**
     * Overrides the method buildPieceWithzeroRotation() to represent a
     * LMinimumBlock with zero degree rotation.
     */
    @Override
    public void buildPieceWithzeroRotation() {

        String[] coords = {"A1", "A2", "B2"};
        buildPiece(coords, coords[0]);
    }

    /**
     * Overrides the method buildPieceWithNinetyRotation() to represent a
     * LMinimumBlock with ninety degree rotation.
     */
    @Override
    public void buildPieceWithNinetyRotation() {

        String[] coords = {"A1", "B1", "A2"};
        buildPiece(coords, coords[0]);
    }

    /**
     * Overrides the method buildPieceWithHundredEightyRotation() to represent a
     * LMinimumBlock with hundred and seventy degree rotation.
     */
    @Override
    public void buildPieceWithHundredEightyRotation() {

        String[] coords = {"A1", "B1", "B2"};
        buildPiece(coords, coords[0]);

    }

    /**
     * Overrides the method buildPieceWithTwoHundredSeventyRotation() to
     * represent a LMinimumBlock with two hundred and seventy degree rotation
     */
    @Override
    public void buildPieceWithTwoHundredSeventyRotation() {

        String[] coords = {"B1", "A2", "B2"};
        buildPiece(coords, coords[1]);
    }

}
