package fi.ilmaripohjola.ipitris.entities;

import java.awt.Color;

/**
 * a certain kind of subClass of Piece.
 *
 * @author omistaja
 */
public class PieceJ extends Piece {

    /**
     * Uses superclasses constructor and in addition set's blocks' x and y to
     * form a Tetris J-Piece.
     *
     * @param color the color of the piece
     * @param x the anchor x-value of the Piece
     * @param y the anchor y-value of the Piece
     */
    public PieceJ(Color color, int x, int y) {
        super(color, 4, x, y);
        super.blocks[0] = new Block(color, x, y - 1);
        super.blocks[1] = new Block(color, x, y);
        super.blocks[2] = new Block(color, x, y + 1);
        super.blocks[3] = new Block(color, x - 1, y + 1);

    }

    /**
     * Implements Superclasses method rotateRight in desired way.
     *
     * @See Piece
     */
    @Override
    public void rotateRight() {
        if (asento == 1) {
            rotateRight1();
        } else if (asento == 2) {
            rotateRight2();
        } else if (asento == 3) {
            rotateRight3();
        } else if (asento == 4) {
            rotateRight4();
        }
    }

    protected void rotateRight1() {
        blocks[0].moveDown();
        blocks[0].moveRight();
        blocks[2].moveLeft();
        blocks[2].moveUp();
        blocks[3].moveUp();
        blocks[3].moveUp();
        asento = 2;
    }

    protected void rotateRight2() {
        blocks[0].moveDown();
        blocks[0].moveLeft();
        blocks[2].moveRight();
        blocks[2].moveUp();
        blocks[3].moveRight();
        blocks[3].moveRight();
        asento = 3;
    }

    protected void rotateRight3() {
        blocks[0].moveLeft();
        blocks[0].moveUp();
        blocks[2].moveRight();
        blocks[2].moveDown();
        blocks[3].moveDown();
        blocks[3].moveDown();
        asento = 4;
    }

    protected void rotateRight4() {
        blocks[0].moveRight();
        blocks[0].moveUp();
        blocks[2].moveLeft();
        blocks[2].moveDown();
        blocks[3].moveLeft();
        blocks[3].moveLeft();
        asento = 1;
    }

    /**
     * Implements Superclasses method rotateLeft in desired way.
     *
     * @See Piece
     */
    @Override
    public void rotateLeft() {
        if (asento == 1) {
            rotateLeft1();
        } else if (asento == 4) {
            rotateLeft2();
        } else if (asento == 3) {
            rotateLeft3();
        } else if (asento == 2) {
            rotateLeft4();
        }
    }

    protected void rotateLeft1() {
        blocks[0].moveDown();
        blocks[0].moveLeft();
        blocks[2].moveRight();
        blocks[2].moveUp();
        blocks[3].moveRight();
        blocks[3].moveRight();
        asento = 4;
    }

    protected void rotateLeft2() {
        blocks[0].moveDown();
        blocks[0].moveRight();
        blocks[2].moveUp();
        blocks[2].moveLeft();
        blocks[3].moveUp();
        blocks[3].moveUp();
        asento = 3;
    }

    protected void rotateLeft3() {
        blocks[0].moveRight();
        blocks[0].moveUp();
        blocks[2].moveLeft();
        blocks[2].moveDown();
        blocks[3].moveLeft();
        blocks[3].moveLeft();
        asento = 2;
    }

    protected void rotateLeft4() {
        blocks[0].moveUp();
        blocks[0].moveLeft();
        blocks[2].moveDown();
        blocks[2].moveRight();
        blocks[3].moveDown();
        blocks[3].moveDown();
        asento = 1;
    }
}
