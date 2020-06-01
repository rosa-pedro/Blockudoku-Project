package blocks;

import game.Piece;
import game.PieceName;

/**
 * This class consists exclusively of void methods that help building QBlock
 * Piece
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class QBlock extends Piece {

    /**
     * Constructor for class QBlock, creates a piece after the PieceName enum.
     */
    public QBlock() {

        super(PieceName.Q_BLOCK);
    }

    /**
     * Overrides the method buildPieceWithzeroRotation() to represent a QBlock
     * with zero degree rotation.
     */
    @Override
    public void buildPieceWithzeroRotation() {

        String[] coords = {"A1", "A2", "B1", "B2"};
        buildPiece(coords, coords[0]);
    }

    /**
     * Overrides the method buildPieceWithHundredEightyRotation() to represent a
     * QBlock with hundred and seventy degree rotation, since the QBlock is
     * shaped like a square its rotation is redundant this
     * buildPieceWithzeroRotation() is recalled.
     */
    @Override
    public void buildPieceWithNinetyRotation() {

        buildPieceWithzeroRotation();
    }

    /**
     * Overrides the method buildPieceWithHundredEightyRotation() to represent a
     * QBlock with hundred and seventy degree rotation, since the QBlock is
     * shaped like a square its rotation is redundant this
     * buildPieceWithzeroRotation() is recalled.
     */
    @Override
    public void buildPieceWithHundredEightyRotation() {

        buildPieceWithzeroRotation();

    }

    /**
     * Overrides the method buildPieceWithTwoHundredSeventyRotation() to
     * represent a QBlock with two hundred and seventy degree rotation, since
     * the QBlock is shaped like a square its rotation is redundant this
     * buildPieceWithzeroRotation() is recalled.
     */
    @Override
    public void buildPieceWithTwoHundredSeventyRotation() {

        buildPieceWithzeroRotation();
    }
}
