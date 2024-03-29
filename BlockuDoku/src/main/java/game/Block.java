package game;

import java.io.Serializable;

/**
 * This class represents a Block used in game, a block is composed of its name
 * and of the Piece it's represented by.
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class Block implements Serializable {

    private String blockName;
    private Piece piece;

    /**
     * Constructor for class Block
     *
     * @param name name of the Block
     * @param piece piece of the Block
     */
    public Block(String name, Piece piece) {
        blockName = name;
        this.piece = piece;
    }

    /**
     * Getter for piece
     *
     * @return piece
     */
    public Piece getBlockPiece() {
        return piece;
    }

    /**
     * Getter for block name
     *
     * @return blockName String containing the blocks name
     */
    public String getBlockName() {
        return blockName;
    }

    /**
     * Overrides toString method to return a better representation
     *
     * @return formatted String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Block " + blockName + "\n");
        sb.append(piece);
        return sb.toString();
    }
}
