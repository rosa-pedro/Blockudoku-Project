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
public class LBlock extends Piece {

    /**
     * Constructor for class LBlock, creates a piece after the PieceName enum.
     */
    public LBlock() {
        super(PieceName.L_BLOCK);
    }

    /**
     * Overrides the method buildPieceWithzeroRotation() to represent a LBlock
     * with zero degree rotation.
     */
    @Override
    public void buildPieceWithzeroRotation() {

        String[] coords = {"A1", "A2", "A3", "B3"};
        buildPiece(coords, coords[0]);
    }

    /**
     * Overrides the method buildPieceWithNinetyRotation() to represent a LBlock
     * with ninety degree rotation.
     */
    @Override
    public void buildPieceWithNinetyRotation() {

        String[] coords = {"A1", "B1", "C1", "A2"};
        buildPiece(coords, coords[0]);
    }

    /**
     * Overrides the method buildPieceWithHundredEightyRotation() to represent a
     * LBlock with hundred and seventy degree rotation.
     */
    @Override
    public void buildPieceWithHundredEightyRotation() {

        String[] coords = {"A1", "B1", "B2", "B3"};
        buildPiece(coords, coords[0]);

    }

    /**
     * Overrides the method buildPieceWithTwoHundredSeventyRotation() to
     * represent a LBlock with two hundred and seventy degree rotation
     */
    @Override
    public void buildPieceWithTwoHundredSeventyRotation() {

        String[] coords = {"A2", "B2", "C2", "C1"};
        buildPiece(coords, coords[0]);
    }

}
