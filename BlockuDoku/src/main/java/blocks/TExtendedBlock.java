package blocks;

import game.Piece;
import game.PieceName;

/**
 * This class consists exclusively of void methods that help building
 * TExtendedBlock Piece
 *
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class TExtendedBlock extends Piece {

    /**
     * Constructor for class TExtendedBlock, creates a piece after the PieceName
     * enum.
     */
    public TExtendedBlock() {
        super(PieceName.T_EXTENDED_BLOCK);
    }

    /**
     * Overrides the method buildPieceWithzeroRotation() to represent a
     * TExtendedBlock with zero degree rotation.
     */
    @Override
    public void buildPieceWithzeroRotation() {

        String[] coords = {"A1", "B1", "C1", "B2", "B3"};
        buildPiece(coords, coords[0]);
    }

    /**
     * Overrides the method buildPieceWithNinetyRotation() to represent a
     * TExtendedBlock with ninety degree rotation.
     */
    @Override
    public void buildPieceWithNinetyRotation() {

        String[] coords = {"C1", "A2", "B2", "C2", "C3"};
        buildPiece(coords, coords[1]);
    }

    /**
     * Overrides the method buildPieceWithHundredEightyRotation() to represent a
     * TExtendedBlock with hundred and seventy degree rotation.
     */
    @Override
    public void buildPieceWithHundredEightyRotation() {

        String[] coords = {"B1", "B2", "A3", "B3", "C3"};
        buildPiece(coords, coords[2]);

    }

    /**
     * Overrides the method buildPieceWithTwoHundredSeventyRotation() to
     * represent a TExtendedBlock with two hundred and seventy degree rotation
     */
    @Override
    public void buildPieceWithTwoHundredSeventyRotation() {

        String[] coords = {"A1", "A2", "B2", "C2", "A3"};
        buildPiece(coords, coords[0]);
    }

}
