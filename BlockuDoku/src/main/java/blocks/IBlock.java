package blocks;

import game.Piece;
import game.PieceName;

/**
 * This class consists exclusively of void methods that help building the IBlock
 * Piece
 *
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class IBlock extends Piece {

    /**
     * Constructor for class IBlock, creates a piece after the PieceName enum
     *
     */
    public IBlock() {

        super(PieceName.I_BLOCK);
    }

    /**
     * Overrides the method buildPieceWithzeroRotation() to represent an IBlock
     * with zero degree rotation.
     *
     */
    @Override
    public void buildPieceWithzeroRotation() {

        String[] coords = {"A1", "A2", "A3", "A4"};
        buildPiece(coords, coords[0]);
    }

    /**
     * Overrides the method buildPieceWithNinetyRotation() to represent an
     * IBlock with Ninety degree rotation.
     *
     */
    @Override
    public void buildPieceWithNinetyRotation() {

        String[] coords = {"A1", "B1", "C1", "D1"};
        buildPiece(coords, coords[0]);
    }

    /**
     * Overrides the method buildPieceWithHundredEightyRotation() to represent
     * an IBlock with hundred and eighty degree rotation.
     *
     */
    @Override
    public void buildPieceWithHundredEightyRotation() {

        buildPieceWithzeroRotation();
    }

    /**
     * Overrides the method buildPieceWithTwoHundredSeventyRotation() to
     * represent an IBlock with two hundred and seventy degree rotation.
     *
     */
    @Override
    public void buildPieceWithTwoHundredSeventyRotation() {

        buildPieceWithNinetyRotation();
    }
}
