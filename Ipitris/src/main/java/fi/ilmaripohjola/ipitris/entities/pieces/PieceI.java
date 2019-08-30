package fi.ilmaripohjola.ipitris.entities.pieces;

import fi.ilmaripohjola.ipitris.entities.Block;
import java.awt.Color;

/**
 * a certain kind of subClass of Piece.
 * @author omistaja
 */
public class PieceI extends Piece {

    /**
     * Uses superclasses constructor and in addition set's blocks' x and y to
     * form a Tetris I-Piece.
     *
     * @param color the color of the piece
     * @param x the anchor x-value of the Piece
     * @param y the anchor y-value of the Piece
     */
    public PieceI(Color color, int x, int y) {
        super(color, 4, x, y);
        super.blocks[0] = new Block(color, x, y - 1);
        super.blocks[1] = new Block(color, x, y);
        super.blocks[2] = new Block(color, x, y + 1);
        super.blocks[3] = new Block(color, x, y + 2);
    }

    /**
     * Implements Superclasses method rotateRight in desired way.
     *
     * @See Piece
     */
    @Override
    public void rotateRight() {
        if (super.orientation == 1) {
            super.blocks[0].moveLeft();
            super.blocks[0].moveDown();
            super.blocks[2].moveRight();
            super.blocks[2].moveUp();
            super.blocks[3].moveRight();
            super.blocks[3].moveRight();
            super.blocks[3].moveUp();
            super.blocks[3].moveUp();
            super.orientation = 2;
        } else if (super.orientation == 2) {
            rotateLeft();
        }

    }

    /**
     * Implements Superclasses method rotateLeft in desired way.
     *
     * @See Piece
     */
    @Override
    public void rotateLeft() {
        if (super.orientation == 2) {
            super.blocks[0].moveUp();
            super.blocks[0].moveRight();
            super.blocks[2].moveLeft();
            super.blocks[2].moveDown();
            super.blocks[3].moveLeft();
            super.blocks[3].moveLeft();
            super.blocks[3].moveDown();
            super.blocks[3].moveDown();
            super.orientation = 1;
        } else if (super.orientation == 1) {
            rotateRight();
        }
    }

}
