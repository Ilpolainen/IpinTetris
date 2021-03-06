package fi.ilmaripohjola.ipitris.entities.pieces;

import fi.ilmaripohjola.ipitris.entities.Piece;
import fi.ilmaripohjola.ipitris.entities.Block;
import java.awt.Color;

/**
 * a certain kind of subClass of Piece.
 *
 * @author omistaja
 */
public class PieceSquare extends Piece {

    /**
     * Uses superclasses constructor and in addition set's blocks' x and y to
     * form a Tetris Square-Piece.
     *
     * @param color the color of the piece
     * @param x the anchor x-value of the Piece
     * @param y the anchor y-value of the Piece
     */
    public PieceSquare(Color color, int x, int y) {
        super(color, 4, x, y);
        super.blocks[0] = new Block(color, x, y - 1);
        super.blocks[1] = new Block(color, x + 1, y - 1);
        super.blocks[2] = new Block(color, x, y);
        super.blocks[3] = new Block(color, x + 1, y);
    }
}
