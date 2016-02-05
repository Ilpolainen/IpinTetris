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

    public PieceGenerator(Random random, int tableWidth) {
        this.random = random;
        this.tableWidth = tableWidth;
    }

    
    
    public Piece givePiece() {
        int i = random.nextInt(1);        
        if (i==1) {
            return makeI();
        } if (i==1) {
            return makeSquare();
        } if (i==2) {
            return makeT();
        } if (i==0) {
            return makeL();
        } if (i==4) {
            return makeJ();
        } if (i==5) {
            return makeS();
        } if (i==6) {
            return makeZ();
        }
        return null;
    }
    
    private Piece makeI() {
        PieceI piece = new PieceI(Color.RED, this.tableWidth/2, 1);
        return piece;
    }
    
    private Piece makeSquare() {
        PieceSquare piece = new PieceSquare(Color.BLUE, this.tableWidth/2, 3);
        return piece;
    }
    
    private Piece makeT() {
        PieceT piece = new PieceT(Color.GREEN, this.tableWidth/2, 3);
        return piece;
    }
    
    private Piece makeL() {
        PieceL piece = new PieceL(Color.CYAN, this.tableWidth/2, 2);
        return piece;
    }
    
    private Piece makeJ() {
        PieceJ piece = new PieceJ(Color.ORANGE, this.tableWidth/2, 2);
        return piece;
    }
    
    private Piece makeS() {
        PieceS piece = new PieceS(Color.YELLOW, this.tableWidth/2, 3);
        return piece;
    }
    
    private Piece makeZ() {
        PieceZ piece = new PieceZ(Color.MAGENTA, this.tableWidth/2, 3);
        return piece;
    }
}
