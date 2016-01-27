/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.entities;

import java.awt.Color;

/**
 *
 * @author omistaja
 */
public class PieceI extends Piece {

    private Color color;
    private Block[] blocks;
    private int asento;

    public PieceI(Color color, int x, int y) {
        super(color);
        this.blocks = new Block[4];
        this.blocks[0] = new Block(x, y, color);
        this.blocks[1] = new Block(x, y + 1, color);
        this.blocks[2] = new Block(x, y + 2, color);
        this.blocks[3] = new Block(x, y + 3, color);
        this.asento = 1;
    }

    public Block[] getBlocks() {
        return blocks;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void rotateRight() {
        if (this.asento == 1) {
            blocks[0].moveRight();
            blocks[0].moveRight();
            blocks[0].moveDown();
            blocks[1].moveRight();
            blocks[2].moveLeft();
            blocks[3].moveLeft();
            blocks[3].moveLeft();
            blocks[3].moveUp();
            this.asento = 2;
        } else if (this.asento == 2) {
            blocks[0].moveLeft();
            blocks[0].moveDown();
            blocks[0].moveDown();
            blocks[1].moveDown();
            blocks[2].moveRight();
            blocks[3].moveUp();
            blocks[3].moveRight();
            blocks[3].moveRight();
            this.asento = 3;
        } else if (this.asento == 3) {
            blocks[0].moveUp();
            blocks[0].moveLeft();
            blocks[0].moveLeft();
            blocks[1].moveLeft();
            blocks[2].moveDown();
            blocks[3].moveDown();
            blocks[3].moveDown();
            blocks[3].moveRight();
            this.asento = 4;
        } else if (this.asento == 4) {
            blocks[0].moveRight();
            blocks[0].moveUp();
            blocks[0].moveUp();
            blocks[1].moveUp();
            blocks[2].moveLeft();
            blocks[3].moveLeft();
            blocks[3].moveLeft();
            blocks[3].moveDown();
            this.asento = 1;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rotateLeft() {
        if (this.asento == 1) {
            blocks[0].moveLeft();
            blocks[0].moveDown();
            blocks[0].moveDown();
            blocks[1].moveDown();
            blocks[2].moveRight();
            blocks[3].moveRight();
            blocks[3].moveRight();
            blocks[3].moveUp();
            this.asento = 4;
        } else if (this.asento == 2) {
            blocks[0].moveUp();
            blocks[0].moveLeft();
            blocks[0].moveLeft();
            blocks[1].moveLeft();
            blocks[2].moveDown();
            blocks[3].moveDown();
            blocks[3].moveDown();
            blocks[3].moveRight();
            this.asento = 1;
        } else if (this.asento == 3) {
            blocks[0].moveUp();
            blocks[0].moveUp();
            blocks[0].moveRight();
            blocks[1].moveUp();
            blocks[2].moveLeft();
            blocks[3].moveDown();
            blocks[3].moveLeft();
            blocks[3].moveLeft();
            this.asento = 2;
        } else if (this.asento == 4) {
            blocks[0].moveRight();
            blocks[0].moveRight();
            blocks[0].moveDown();
            blocks[1].moveRight();
            blocks[2].moveUp();
            blocks[3].moveUp();
            blocks[3].moveUp();
            blocks[3].moveLeft();
            this.asento = 3;
        }
    }

    @Override
    public String toString() {
        String asento = "Asento: " + "\n" + 
                this.asento + "\n"
                + "Koordinaatit: " + "\n" + 
                "eka: (" + blocks[0].getX() + "," + blocks[0].getY() + ")" + "\n" +
                "toka: (" + blocks[1].getX() + "," + blocks[1].getY() + ")" + "\n" +
                "kolmas: (" + blocks[2].getX() + "," + blocks[2].getY() + ")" + "\n" +
                "neljäs: (" + blocks[3].getX() + "," + blocks[3].getY() + ")" + "\n";
        return asento;
    }
}

/**
 *
 *

 */
    
   

