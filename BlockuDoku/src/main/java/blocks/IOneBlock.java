package blocks;

import game.Piece;
import game.PieceName;

/**
 * This class consists exclusively of void methods that help building IOneBlock
 * Piece
 *
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class IOneBlock extends Piece {

    /**
     * Constructor for class IOneBlock, creates a piece after the PieceName enum
     */
    public IOneBlock() {
        super(PieceName.I_ONE_BLOCK);
    }

    /**
     * Overrides the method buildPieceWithzeroRotation() to represent an
     * IOneBlock with zero degree rotation.
     */
    @Override
    public void buildPieceWithzeroRotation() {

        String[] coords = {"A1"};
        buildPiece(coords, coords[0]);
    }

    /**
     * Overrides the method buildPieceWithNinetyRotation() to represent an
     * IOneBlock with ninety degree rotation, since it's represented by only one
     * square this method recalls buildPieceWithzeroRotation().
     */
    @Override
    public void buildPieceWithNinetyRotation() {

        buildPieceWithzeroRotation();
    }

    /**
     * Overrides the method buildPieceWithHundredEightyRotation() to represent
     * an IOneBlock with hundred and eighty degree rotation, since it's
     * represented by only one square this method recalls
     * buildPieceWithzeroRotation().
     */
    @Override
    public void buildPieceWithHundredEightyRotation() {

        buildPieceWithzeroRotation();

    }

    /**
     * Overrides the method buildPieceWithTwoHundredSeventyRotation() to
     * represent an IOneBlock with two hundred and seventy degree rotation,
     * since it's represented by only one square this method recalls
     * buildPieceWithzeroRotation().
     */
    @Override
    public void buildPieceWithTwoHundredSeventyRotation() {

        buildPieceWithzeroRotation();
    }

}
