package blocks;

import game.Piece;
import game.PieceName;

/**
 * This class consists exclusively of void methods that help building JBlock
 * Piece
 *
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class JBlock extends Piece {

    /**
     * Constructor for class JBlock, creates a piece after the PieceName enum.
     */
    public JBlock() {
        super(PieceName.J_BLOCK);
    }

    /**
     * Overrides the method buildPieceWithzeroRotation() to represent a JBlock
     * with zero degree rotation.
     */
    @Override
    public void buildPieceWithzeroRotation() {

        String[] coords = {"B1", "B2", "B3", "A3"};
        buildPiece(coords, coords[3]);
    }

    /**
     * Overrides the method buildPieceWithNinetyRotation() to represent a JBlock
     * with ninety degree rotation.
     */
    @Override
    public void buildPieceWithNinetyRotation() {

        String[] coords = {"A1", "A2", "B2", "C2"};
        buildPiece(coords, coords[0]);
    }

    /**
     * Overrides the method buildPieceWithHundredEightyRotation() to represent a
     * JBlock with hundred and seventy degree rotation.
     */
    @Override
    public void buildPieceWithHundredEightyRotation() {

        String[] coords = {"A1", "B1", "A2", "A3"};
        buildPiece(coords, coords[0]);

    }

    /**
     * Overrides the method buildPieceWithTwoHundredSeventyRotation() to
     * represent a JBlock with two hundred and seventy degree rotation
     */
    @Override
    public void buildPieceWithTwoHundredSeventyRotation() {

        String[] coords = {"A1", "B1", "C1", "C2"};
        buildPiece(coords, coords[0]);
    }

}
