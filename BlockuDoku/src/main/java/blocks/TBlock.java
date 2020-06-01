package blocks;

import game.Piece;
import game.PieceName;

/**
 * This class consists exclusively of void methods that help building TBlock
 * Piece
 *
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class TBlock extends Piece {

    /**
     * Constructor for class TBlock, creates a piece after the PieceName enum.
     */
    public TBlock() {

        super(PieceName.T_BLOCK);
    }

    /**
     * Overrides the method buildPieceWithzeroRotation() to represent a TBlock
     * with zero degree rotation.
     */
    @Override
    public void buildPieceWithzeroRotation() {

        String[] coords = {"A1", "B1", "C1", "B2"};
        buildPiece(coords, coords[0]);
    }

    /**
     * Overrides the method buildPieceWithHundredEightyRotation() to represent a
     * TBlock with hundred and seventy degree rotation.
     */
    @Override
    public void buildPieceWithNinetyRotation() {

        String[] coords = {"B1", "A2", "B2", "B3"};
        buildPiece(coords, coords[1]);
    }

    /**
     * Overrides the method buildPieceWithHundredEightyRotation() to represent a
     * TBlock with hundred and seventy degree rotation.
     */
    @Override
    public void buildPieceWithHundredEightyRotation() {

        String[] coords = {"A1", "A2", "B2", "A3"};
        buildPiece(coords, coords[0]);
    }

    /**
     * Overrides the method buildPieceWithTwoHundredSeventyRotation() to
     * represent a TBlock with two hundred and seventy degree rotation.
     */
    @Override
    public void buildPieceWithTwoHundredSeventyRotation() {

        String[] coords = {"B1", "A2", "B2", "C2"};
        buildPiece(coords, coords[1]);
    }

}
