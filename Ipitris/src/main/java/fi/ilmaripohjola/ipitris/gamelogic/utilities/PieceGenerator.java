package fi.ilmaripohjola.ipitris.gamelogic.utilities;

import fi.ilmaripohjola.ipitris.application.logic.GameConfiguration;
import fi.ilmaripohjola.ipitris.entities.pieces.Piece;
import fi.ilmaripohjola.ipitris.entities.pieces.PieceI;
import fi.ilmaripohjola.ipitris.entities.pieces.PieceJ;
import fi.ilmaripohjola.ipitris.entities.pieces.PieceL;
import fi.ilmaripohjola.ipitris.entities.pieces.PieceS;
import fi.ilmaripohjola.ipitris.entities.pieces.PieceSquare;
import fi.ilmaripohjola.ipitris.entities.pieces.PieceT;
import fi.ilmaripohjola.ipitris.entities.pieces.PieceZ;
import java.awt.Color;
import java.util.Random;

/**
 * Is able for constructing random new Piece's subclass-objects and also is able
 * to show the next one coming.
 *
 * @author omistaja
 */
public class PieceGenerator {

    private final Random random;
    private Piece next;
    private final GameConfiguration configuration;

    /**
     * Constructor needs an integer to present the
     * width of table in order to construct pieces' x-coordinate correctly. Sets
     * up preset-colors.
     *
     * @param tableWidth int for determining the starting position of generated
     * Piece
     */
    public PieceGenerator(GameConfiguration configuration) {
        this.random = new Random();
        this.next = null;
        this.configuration = configuration;
    }

    
    /**
     * Optional constructor for testing purposes with fake random-class. Needs an object of Random -class and an int to present the
     * width of table in order to construct pieces' x-coordinate correctly. Sets
     * up preset-colors.
     *
     * @param random java.util.Random class object
     * @param tableWidth int for determining the starting position of generated
     * Piece
     */
    public PieceGenerator(Random random, GameConfiguration configuration) {
        
        this.random = random;
        this.next = null;
        this.configuration = configuration;
    }

    public Piece getNext() {
        return next;
    }


    /**
     * Returns a random Piece-object. For private use only.
     *
     * @return Piece
     */
    public Piece makeNext() {
        int i = random.nextInt(7000);
        i = i % 7;
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
        System.out.println("From PieceGenerator.givePiece() gift: " + gift.toString());
        return gift;
    }

    private Piece makeI() {
        PieceI piece = new PieceI(this.configuration.getColors()[0], this.configuration.getBoardWidth() / 2, 1);
        return piece;
    }

    private Piece makeSquare() {
        PieceSquare piece = new PieceSquare(this.configuration.getColors()[1], this.configuration.getBoardWidth() / 2 - 1, 3);
        return piece;
    }

    private Piece makeT() {
        PieceT piece = new PieceT(this.configuration.getColors()[2], this.configuration.getBoardWidth() / 2, 2);
        return piece;
    }

    private Piece makeL() {
        PieceL piece = new PieceL(this.configuration.getColors()[3], this.configuration.getBoardWidth() / 2 - 1, 2);
        return piece;
    }

    private Piece makeJ() {
        PieceJ piece = new PieceJ(this.configuration.getColors()[4], this.configuration.getBoardWidth() / 2, 2);
        return piece;
    }

    private Piece makeS() {
        PieceS piece = new PieceS(this.configuration.getColors()[5], this.configuration.getBoardWidth() / 2 - 1, 2);
        return piece;
    }

    private Piece makeZ() {
        PieceZ piece = new PieceZ(this.configuration.getColors()[6], this.configuration.getBoardWidth() / 2, 2);
        return piece;
    }
    
    public void reset() {
        next = this.givePiece();
    }
}
