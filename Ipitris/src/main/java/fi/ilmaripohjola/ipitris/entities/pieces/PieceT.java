package fi.ilmaripohjola.ipitris.entities.pieces;

import fi.ilmaripohjola.ipitris.entities.Piece;
import fi.ilmaripohjola.ipitris.entities.Block;
import java.awt.Color;

/**
 * a certain kind of subClass of Piece.
 *
 * @author omistaja
 */
public class PieceT extends Piece {

    /**
     * Uses superclasses constructor and in addition set's blocks' x and y to
     * form a Tetris T-Piece.
     *
     * @param color the color of the piece
     * @param x the anchor x-value of the Piece
     * @param y the anchor y-value of the Piece
     */
    public PieceT(Color color, int x, int y) {
        super(color, 4, x, y);
        super.blocks[0] = new Block(color, x - 1, y);
        super.blocks[1] = new Block(color, x, y);
        super.blocks[2] = new Block(color, x, y + 1);
        super.blocks[3] = new Block(color, x + 1, y);
    }

    /**
     * Implements Superclasses method rotateRight in desired way.
     *
     * @See Piece
     */
    @Override
    public void rotateRight() {
        if (orientation == 1) {
            rotateRight1();
        } else if (orientation == 2) {
            rotateRight2();
        } else if (orientation == 3) {
            rotateRight3();
        } else if (orientation == 4) {
            rotateRight4();
        }
    }

    protected void rotateRight1() {
        blocks[0].moveUp();
        blocks[0].moveRight();
        blocks[2].moveLeft();
        blocks[2].moveUp();
        blocks[3].moveDown();
        blocks[3].moveLeft();
        orientation = 2;
    }

    protected void rotateRight2() {
        blocks[0].moveDown();
        blocks[0].moveRight();
        blocks[2].moveRight();
        blocks[2].moveUp();
        blocks[3].moveUp();
        blocks[3].moveLeft();
        orientation = 3;
    }

    protected void rotateRight3() {
        blocks[0].moveDown();
        blocks[0].moveLeft();
        blocks[2].moveRight();
        blocks[2].moveDown();
        blocks[3].moveUp();
        blocks[3].moveRight();
        orientation = 4;
    }

    protected void rotateRight4() {
        blocks[0].moveLeft();
        blocks[0].moveUp();
        blocks[2].moveLeft();
        blocks[2].moveDown();
        blocks[3].moveDown();
        blocks[3].moveRight();
        orientation = 1;
    }

    /**
     * Implements Superclasses method rotateLeft in desired way.
     *
     * @See Piece
     */
    @Override
    public void rotateLeft() {
        if (orientation == 1) {
            rotateLeft1();
        } else if (orientation == 2) {
            rotateLeft2();
        } else if (orientation == 3) {
            rotateLeft3();
        } else if (orientation == 4) {
            rotateLeft4();
        }
    }

    protected void rotateLeft1() {
        blocks[0].moveDown();
        blocks[0].moveRight();
        blocks[2].moveRight();
        blocks[2].moveUp();
        blocks[3].moveUp();
        blocks[3].moveLeft();
        orientation = 4;
    }

    protected void rotateLeft2() {
        blocks[0].moveDown();
        blocks[0].moveLeft();
        blocks[2].moveRight();
        blocks[2].moveDown();
        blocks[3].moveUp();
        blocks[3].moveRight();
        orientation = 1;
    }

    protected void rotateLeft3() {
        blocks[0].moveUp();
        blocks[0].moveLeft();
        blocks[2].moveLeft();
        blocks[2].moveDown();
        blocks[3].moveDown();
        blocks[3].moveRight();
        orientation = 2;
    }

    protected void rotateLeft4() {
        blocks[0].moveUp();
        blocks[0].moveRight();
        blocks[2].moveLeft();
        blocks[2].moveUp();
        blocks[3].moveDown();
        blocks[3].moveLeft();
        orientation = 3;
    }

//    @Override
//    public String toString() {
//        String asento = "Asento: " + "\n" + 
//                this.asento + "\n"
//                + "Koordinaatit: " + "\n" + 
//                "eka: (" + blocks[0].getX() + "," + blocks[0].getY() + ")" + "\n" +
//                "toka: (" + blocks[1].getX() + "," + blocks[1].getY() + ")" + "\n" +
//                "kolmas: (" + blocks[2].getX() + "," + blocks[2].getY() + ")" + "\n" +
//                "neljäs: (" + blocks[3].getX() + "," + blocks[3].getY() + ")" + "\n";
//        return asento;
//    }
}
