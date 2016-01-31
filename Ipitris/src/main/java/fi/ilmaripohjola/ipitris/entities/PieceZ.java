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
public class PieceZ extends Piece {
    
    private Color color;
    private Block[] blocks;
    private int asento;

    public PieceZ(Color color) {
        super(color);
    }
    
    

    public PieceZ(Color color, int x, int y) {
        super(color);
        this.blocks = new Block[4];
        this.blocks[0] = new Block(color, x, y - 1);
        this.blocks[1] = new Block(color, x, y);
        this.blocks[2] = new Block(color, x - 1, y);
        this.blocks[3] = new Block(color, x - 1, y + 1);
        this.asento = 1;
    }

    public int getAsento() {
        return asento;
    }

    @Override
    public Block[] getBlocks() {
        return blocks; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getColor() {
        return color; //To change body of generated methods, choose Tools | Templates.
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
    }

    @Override
    public void rotateLeft() {
        if (asento == 1) {
            blocks[0].moveLeft();
            blocks[0].moveDown();
            blocks[2].moveDown();
            blocks[2].moveRight();
            blocks[3].moveRight();
            blocks[3].moveRight();            
            asento = 2;
        } else if (asento == 2) {
            blocks[0].moveRight();
            blocks[0].moveUp();
            blocks[2].moveUp();
            blocks[2].moveLeft();
            blocks[3].moveLeft();
            blocks[3].moveLeft();
            asento = 1;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rotateRight() {
        rotateLeft(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        String asento = "Asento: " + "\n"
                + this.asento + "\n"
                + "Koordinaatit: " + "\n"
                + "eka: (" + blocks[0].getX() + "," + blocks[0].getY() + ")" + "\n"
                + "toka: (" + blocks[1].getX() + "," + blocks[1].getY() + ")" + "\n"
                + "kolmas: (" + blocks[2].getX() + "," + blocks[2].getY() + ")" + "\n"
                + "neljäs: (" + blocks[3].getX() + "," + blocks[3].getY() + ")" + "\n";
        return asento;
    }
}
