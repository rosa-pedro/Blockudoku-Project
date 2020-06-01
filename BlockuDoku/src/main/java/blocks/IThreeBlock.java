package blocks;

import game.Piece;
import game.PieceName;

/**
 * This class consists exclusively of void methods that help building
 * IThreeBlock Piece
 *
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class IThreeBlock extends Piece {

    /**
     * Constructor for class IThreeBlock, creates a piece after the PieceName
     * enum.
     */
    public IThreeBlock() {
        super(PieceName.I_THREE_BLOCK);
    }

    /**
     * Overrides the method buildPieceWithzeroRotation() to represent an
     * IThreeBlock with zero degree rotation.
     */
    @Override
    public void buildPieceWithzeroRotation() {

        String[] coords = {"A1", "A2", "A3"};
        buildPiece(coords, coords[0]);
    }

    /**
     * Overrides the method buildPieceWithNinetyRotation() to represent an
     * IThreeBlock with ninety degree rotation.
     */
    @Override
    public void buildPieceWithNinetyRotation() {

        String[] coords = {"A1", "B1", "C1"};
        buildPiece(coords, coords[0]);
    }

    /**
     * Overrides the method buildPieceWithHundredEightyRotation() to represent
     * an IThreeBlock with hundred and eighty degree rotation, since this is the
     * same as buildPieceWithzeroRotation() the method is recalled.
     */
    @Override
    public void buildPieceWithHundredEightyRotation() {

        buildPieceWithzeroRotation();

    }

    /**
     * Overrides the method buildPieceWithTwoHundredSeventyRotation() to
     * represent an IThreeBlock with two hundred and seventy degree rotation
     */
    @Override
    public void buildPieceWithTwoHundredSeventyRotation() {

        buildPieceWithNinetyRotation();
    }

}
