package fi.ilmaripohjola.ipitris.entities.pieces;

import fi.ilmaripohjola.ipitris.entities.Block;
import java.awt.Color;

/**
 * a certain kind of subClass of Piece.
 *
 * @author omistaja
 */
public class PieceL extends Piece {

    /**
     * Uses superclasses constructor and in addition set's blocks' x and y to
     * form a Tetris L-Piece.
     *
     * @param color the color of the piece
     * @param x the anchor x-value of the Piece
     * @param y the anchor y-value of the Piece
     */
    public PieceL(Color color, int x, int y) {
        super(color, 4, x, y);
        super.blocks[0] = new Block(color, x, y - 1);
        super.blocks[1] = new Block(color, x, y);
        super.blocks[2] = new Block(color, x, y + 1);
        super.blocks[3] = new Block(color, x + 1, y + 1);
    }

    /**
     * Implements Superclasses method rotateRight in desired way.
     *
     * @See Piece
     */
    @Override
    public void rotateRight() {
        switch (orientation) {
            case 1:
                rotateRight1();
                break;
            case 2:
                rotateRight2();
                break;
            case 3:
                rotateRight3();
                break;
            case 4:
                rotateRight4();
                break;
            default:
                break;
        }
    }

    protected void rotateRight1() {
        blocks[0].moveDown();
        blocks[0].moveRight();
        blocks[2].moveLeft();
        blocks[2].moveUp();
        blocks[3].moveLeft();
        blocks[3].moveLeft();
        orientation = 2;
    }

    protected void rotateRight2() {
        blocks[0].moveDown();
        blocks[0].moveLeft();
        blocks[2].moveRight();
        blocks[2].moveUp();
        blocks[3].moveUp();
        blocks[3].moveUp();
        orientation = 3;
    }

    protected void rotateRight3() {
        blocks[0].moveLeft();
        blocks[0].moveUp();
        blocks[2].moveRight();
        blocks[2].moveDown();
        blocks[3].moveRight();
        blocks[3].moveRight();
        orientation = 4;
    }

    protected void rotateRight4() {
        blocks[0].moveRight();
        blocks[0].moveUp();
        blocks[2].moveLeft();
        blocks[2].moveDown();
        blocks[3].moveDown();
        blocks[3].moveDown();
        orientation = 1;
    }

    /**
     * Implements Superclasses method rotateLeft in desired way.
     *
     * @See Piece
     */
    @Override
    public void rotateLeft() {
        switch (orientation) {
            case 1:
                rotateLeft1();
                break;
            case 2:
                rotateLeft2();
                break;
            case 3:
                rotateLeft3();
                break;
            case 4:
                rotateLeft4();
                break;
            default:
                break;
        }

    }

    protected void rotateLeft1() {
        blocks[0].moveDown();
        blocks[0].moveLeft();
        blocks[2].moveRight();
        blocks[2].moveUp();
        blocks[3].moveUp();
        blocks[3].moveUp();
        orientation = 4;
    }

    protected void rotateLeft2() {
        blocks[0].moveUp();
        blocks[0].moveLeft();
        blocks[2].moveRight();
        blocks[2].moveDown();
        blocks[3].moveRight();
        blocks[3].moveRight();
        orientation = 1;
    }

    protected void rotateLeft3() {
        blocks[0].moveRight();
        blocks[0].moveUp();
        blocks[2].moveLeft();
        blocks[2].moveDown();
        blocks[3].moveDown();
        blocks[3].moveDown();
        orientation = 2;
    }

    protected void rotateLeft4() {
        blocks[0].moveDown();
        blocks[0].moveRight();
        blocks[2].moveLeft();
        blocks[2].moveUp();
        blocks[3].moveLeft();
        blocks[3].moveLeft();
        orientation = 3;
    }

}
