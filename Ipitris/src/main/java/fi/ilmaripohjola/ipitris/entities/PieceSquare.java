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
public class PieceSquare extends Piece {
    private Color color;
    private Block[] blocks;
    private int asento;

    public PieceSquare(Color color) {
        super(color);
    }
    
    

    public PieceSquare(Color color, int x, int y) {
        this.color = color;
        this.blocks = new Block[4];
        this.blocks[0] = new Block(color, x, y - 1);
        this.blocks[1] = new Block(color, x + 1, y - 1);
        this.blocks[2] = new Block(color, x, y);
        this.blocks[3] = new Block(color, x + 1, y);
        this.asento = 1;
    }

    public int getAsento() {
        return asento;
    }

    public Block[] getBlocks() {
        return blocks;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void moveDown() {
        for (Block block : blocks) {
            block.moveDown();
        }
 //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveUp() {
        for (Block block : blocks) {
            block.moveUp();
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
    public void moveLeft() {
        for (Block block : blocks) {
            block.moveLeft();
        }
 //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rotateRight() {
    }

    @Override
    public void rotateLeft() {
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
