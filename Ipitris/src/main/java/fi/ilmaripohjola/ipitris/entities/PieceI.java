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

    public PieceI(Color color) {
        super(color);
    }
    
    /**
     *
     * @param color
     * @param x
     * @param y
     */
    public PieceI(Color color, int x, int y) {
        this.color = color;
        this.blocks = new Block[4];
        this.blocks[0] = new Block(color,x, y - 1);
        this.blocks[1] = new Block(color,x, y);
        this.blocks[2] = new Block(color,x, y + 1);
        this.blocks[3] = new Block(color,x, y + 2);
        this.asento = 1;
    }

    @Override
    public Block[] getBlocks() {
        return blocks;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void rotateRight() {
        if (this.asento == 1) {
            blocks[0].moveLeft();
            blocks[0].moveDown();
            blocks[2].moveRight();
            blocks[2].moveUp();
            blocks[3].moveRight();
            blocks[3].moveRight();
            blocks[3].moveUp();
            blocks[3].moveUp();
            this.asento = 2;
        } else if (this.asento == 2) {
            rotateLeft();
            this.asento = 1;
        } 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rotateLeft() {
        if (this.asento == 2) {
            blocks[0].moveUp();
            blocks[0].moveRight();
            blocks[2].moveLeft();
            blocks[2].moveDown();
            blocks[3].moveLeft();
            blocks[3].moveLeft();
            blocks[3].moveDown();
            blocks[3].moveDown();
            this.asento = 1;
        } else if (this.asento == 1) {
            rotateRight();
            this.asento = 2;
        } 
    }

    @Override
    public void moveUp() {
        for (Block block : blocks) {
            block.moveUp();
        }
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveDown() {
        for (Block block : blocks) {
            block.moveDown();
        }
 //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveLeft() {
        for (Block block : blocks) {
            block.moveLeft();
        }
 //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveRight() {
        for (Block block : blocks) {
            block.moveRight();
        }
 //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public String toString() {
        String palautus = "Asento: " + "\n" + 
                this.asento + "\n"
                + "Koordinaatit: " + "\n" + 
                "eka: (" + blocks[0].getX() + "," + blocks[0].getY() + ")" + "\n" +
                "toka: (" + blocks[1].getX() + "," + blocks[1].getY() + ")" + "\n" +
                "kolmas: (" + blocks[2].getX() + "," + blocks[2].getY() + ")" + "\n" +
                "neljäs: (" + blocks[3].getX() + "," + blocks[3].getY() + ")" + "\n";
        return palautus;
    }
}

/**
 *
 *

 */
    
   

