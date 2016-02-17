/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author omistaja
 */
public class PieceGenerator {

    private Random random;
    private int tableWidth;
    private Piece next;
    private Color[] colors;

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

    public void setColors(Color i, Color square, Color t, Color l, Color j, Color s, Color z) {
        this.colors[0] = i;
        this.colors[1] = square;
        this.colors[2] = t;
        this.colors[3] = l;
        this.colors[4] = j;
        this.colors[5] = s;
        this.colors[6] = z;
    }

    public Color[] getColors() {
        return colors;
    }    

    public int getTableWidth() {
        return tableWidth;
    }

    public Piece getNext() {
        return next;
    }

    private Piece makeNext() {
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
