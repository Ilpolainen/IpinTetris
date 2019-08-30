package fi.ilmaripohjola.ipitris.entities.pieces;

import fi.ilmaripohjola.ipitris.entities.Block;
import java.awt.Color;

/**
 * a certain kind of subClass of Piece.
 *
 * @author omistaja
 */
public class PieceZ extends Piece {

    /**
     * Uses superclasses constructor and in addition set's blocks' x and y to
     * form a Tetris Z-Piece.
     *
     * @param color the color of the piece
     * @param x the anchor x-value of the Piece
     * @param y the anchor y-value of the Piece
     */
    public PieceZ(Color color, int x, int y) {
        super(color, 4, x, y);
        super.blocks[0] = new Block(color, x, y - 1);
        super.blocks[1] = new Block(color, x, y);
        super.blocks[2] = new Block(color, x - 1, y);
        super.blocks[3] = new Block(color, x - 1, y + 1);
    }

    /**
     * Implements Superclasses method rotateLeft in desired way.
     *
     * @See Piece
     */
    @Override
    public void rotateLeft() {
        if (orientation == 1) {
            blocks[0].moveLeft();
            blocks[0].moveDown();
            blocks[2].moveDown();
            blocks[2].moveRight();
            blocks[3].moveRight();
            blocks[3].moveRight();
            orientation = 2;
        } else if (orientation == 2) {
            blocks[0].moveRight();
            blocks[0].moveUp();
            blocks[2].moveUp();
            blocks[2].moveLeft();
            blocks[3].moveLeft();
            blocks[3].moveLeft();
            orientation = 1;
        }
    }

    /**
     * Implements Superclasses method rotateRight in desired way.
     *
     * @See Piece
     */
    @Override
    public void rotateRight() {
        rotateLeft();
    }
}
