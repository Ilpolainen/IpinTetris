package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.entities.Piece;
import fi.ilmaripohjola.ipitris.entities.PieceI;
import fi.ilmaripohjola.ipitris.entities.PieceJ;
import fi.ilmaripohjola.ipitris.entities.PieceL;
import fi.ilmaripohjola.ipitris.entities.PieceS;
import fi.ilmaripohjola.ipitris.entities.PieceSquare;
import fi.ilmaripohjola.ipitris.entities.PieceT;
import fi.ilmaripohjola.ipitris.entities.PieceZ;
import java.awt.Color;
import java.util.Random;

/**
 * Is able for constructing random new Piece's subclass-objects and also is able
 * to show the next one coming.
 *
 * @author omistaja
 */
public class PieceGenerator {

    private Random random;
    private int tableWidth;
    private Piece next;
    private Color[] colors;

    /**
     * Constructor needs an object of Random -class and an int to present the
     * width of table in order to construct pieces' x-coordinate correctly. Sets
     * up preset-colors.
     *
     * @param random java.util.Random class object
     * @param tableWidth int for determining the starting position of generated
     * Piece
     */
    public PieceGenerator(Random random, int tableWidth) {
        this.random = random;
        this.tableWidth = tableWidth;
        this.next = null;
        this.colors = new Color[7];
        this.colors[0] = Color.RED;
        this.colors[1] = Color.BLUE;
        this.colors[2] = Color.GREEN;
        this.colors[3] = Color.CYAN;
        this.colors[4] = Color.ORANGE;
        this.colors[5] = Color.YELLOW;
        this.colors[6] = Color.MAGENTA;
    }

    /**
     * Sets color values to new Piece -objects in given color-order.
     *
     * @param i Color to be used with PieceI
     * @param square Color to be used with PieceSquare
     * @param t Color to be used with PieceT
     * @param l Color to be used with PieceL
     * @param j Color to be used with PieceJ
     * @param s Color to be used with PieceS
     * @param z Color to be used with PieceZ
     */
    public void setColors(Color i, Color square, Color t, Color l, Color j, Color s, Color z) {
        this.colors[0] = i;
        this.colors[1] = square;
        this.colors[2] = t;
        this.colors[3] = l;
        this.colors[4] = j;
        this.colors[5] = s;
        this.colors[6] = z;
    }

    /**
     * Sets color to a Piece width given index.
     *
     * @param color desired Piece color
     * @param i Piece index
     */
    public void setColor(Color color, int i) {
        this.colors[i] = color;
    }

    public Piece getNext() {
        return next;
    }

    public Color[] getColors() {
        return colors;
    }

    public int getTableWidth() {
        return tableWidth;
    }

    /**
     * Sets the width, that PieceConstructor uses to set correct starting
     * position for the Pieces.
     *
     * @param tableWidth desired new tablewidth value
     */
    public void setTableWidth(int tableWidth) {
        this.tableWidth = tableWidth;
        this.next = this.makeNext();
    }

    /**
     * Returns a random Piece-object. For private use only.
     *
     * @return Piece
     */
    public Piece makeNext() {
        int i = random.nextInt(7);
        Piece newNext = null;
        if (i == 0) {
            newNext = makeI();
        }
        if (i == 1) {
            newNext = makeSquare();
        }
        if (i == 2) {
            newNext = makeT();
        }
        if (i == 3) {
            newNext = makeL();
        }
        if (i == 4) {
            newNext = makeJ();
        }
        if (i == 5) {
            newNext = makeS();
        }
        if (i == 6) {
            newNext = makeZ();
        }
        return newNext;
    }

    /**
     * Constructs a new random Piece -object, set's it next and returns previous
     * next one.
     *
     * @return Piece previous next
     */
    public Piece givePiece() {
        if (next == null) {
            next = this.makeNext();
        }
        Piece gift = next;
        next = this.makeNext();
        return gift;
    }

    private Piece makeI() {
        PieceI piece = new PieceI(this.colors[0], this.tableWidth / 2, 1);
        return piece;
    }

    private Piece makeSquare() {
        PieceSquare piece = new PieceSquare(this.colors[1], this.tableWidth / 2 - 1, 3);
        return piece;
    }

    private Piece makeT() {
        PieceT piece = new PieceT(this.colors[2], this.tableWidth / 2, 2);
        return piece;
    }

    private Piece makeL() {
        PieceL piece = new PieceL(this.colors[3], this.tableWidth / 2 - 1, 2);
        return piece;
    }

    private Piece makeJ() {
        PieceJ piece = new PieceJ(this.colors[4], this.tableWidth / 2, 2);
        return piece;
    }

    private Piece makeS() {
        PieceS piece = new PieceS(this.colors[5], this.tableWidth / 2 - 1, 2);
        return piece;
    }

    private Piece makeZ() {
        PieceZ piece = new PieceZ(this.colors[6], this.tableWidth / 2, 2);
        return piece;
    }
}
