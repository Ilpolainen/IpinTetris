/**
 * PieceI is a certain kind of Piece
 */
package fi.ilmaripohjola.ipitris.entities;

import java.awt.Color;

/**
 *
 * @author omistaja
 */
public class PieceI extends Piece {

    public PieceI(Color color, int x, int y) {
        super(color, 4, x, y);
        super.blocks[0] = new Block(color, x, y - 1);
        super.blocks[1] = new Block(color, x, y);
        super.blocks[2] = new Block(color, x, y + 1);
        super.blocks[3] = new Block(color, x, y + 2);
    }

    @Override
    public void rotateRight() {
        if (super.asento == 1) {
            super.blocks[0].moveLeft();
            super.blocks[0].moveDown();
            super.blocks[2].moveRight();
            super.blocks[2].moveUp();
            super.blocks[3].moveRight();
            super.blocks[3].moveRight();
            super.blocks[3].moveUp();
            super.blocks[3].moveUp();
            super.asento = 2;
        } else if (super.asento == 2) {
            rotateLeft();
        }

    }

    @Override
    public void rotateLeft() {
        if (super.asento == 2) {
            super.blocks[0].moveUp();
            super.blocks[0].moveRight();
            super.blocks[2].moveLeft();
            super.blocks[2].moveDown();
            super.blocks[3].moveLeft();
            super.blocks[3].moveLeft();
            super.blocks[3].moveDown();
            super.blocks[3].moveDown();
            super.asento = 1;
        } else if (super.asento == 1) {
            rotateRight();
        }
    }

}
