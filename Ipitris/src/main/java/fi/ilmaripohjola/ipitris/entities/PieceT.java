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
public class PieceT extends Piece {
    
    private Color color;
    private Block[] blocks;
    private int asento;


    public PieceT(Color color, int x, int y) {
        this.color = color;
        this.blocks = new Block[4];
        this.blocks[0] = new Block(color, x - 1, y-1);
        this.blocks[1] = new Block(color, x, y - 1);
        this.blocks[2] = new Block(color, x, y);
        this.blocks[3] = new Block(color, x + 1, y - 1);
        this.asento = 1;
    }
    
    @Override
    public Block[] getBlocks() {
        return this.blocks; 
    }
    
    @Override
    public void moveLeft() {
         for (Block block : blocks) {
            block.moveLeft();
        }
    }

    @Override
    public void moveRight() {
        for (Block block : blocks) {
            block.moveRight();
        }
    }

     @Override
    public void moveUp() {
        for (Block block : blocks) {
            block.moveUp();
        }
    }

    @Override
    public void moveDown() {
        for (Block block : blocks) {
            block.moveDown();
        }
    }

    @Override
    public void rotateRight() {
        if (this.asento==1) {
            blocks[0].moveUp();
            blocks[0].moveRight();
            blocks[2].moveLeft();
            blocks[2].moveUp();
            blocks[3].moveDown();
            blocks[3].moveLeft();
            this.asento = 2;
        } else if (this.asento==2) {
            blocks[0].moveDown();
            blocks[0].moveRight();
            blocks[2].moveRight();
            blocks[2].moveUp();
            blocks[3].moveUp();
            blocks[3].moveLeft();
            this.asento = 3;
        } else if (this.asento==3) {
            blocks[0].moveDown();
            blocks[0].moveLeft();
            blocks[2].moveRight();
            blocks[2].moveDown();
            blocks[3].moveUp();
            blocks[3].moveRight();
            this.asento=4;
        } else if (this.asento==4) {
            blocks[0].moveLeft();
            blocks[0].moveUp();
            blocks[2].moveLeft();
            blocks[2].moveDown();
            blocks[3].moveDown();
            blocks[3].moveRight();
            this.asento=1;
        }
    }

    @Override
    public void rotateLeft() {
        if (this.asento==1) {
            blocks[0].moveDown();
            blocks[0].moveRight();
            blocks[2].moveRight();
            blocks[2].moveUp();
            blocks[3].moveUp();
            blocks[3].moveLeft();            
            this.asento = 4;
        } else if (this.asento==2) {
            blocks[0].moveDown();
            blocks[0].moveLeft();
            blocks[2].moveRight();
            blocks[2].moveDown();
            blocks[3].moveUp();
            blocks[3].moveRight();
            this.asento = 1;
        } else if (this.asento==3) {
            blocks[0].moveUp();
            blocks[0].moveLeft();
            blocks[2].moveLeft();
            blocks[2].moveDown();
            blocks[3].moveDown();
            blocks[3].moveRight();
            this.asento=2;
        } else if (this.asento==4) {
            blocks[0].moveUp();
            blocks[0].moveRight();
            blocks[2].moveLeft();
            blocks[2].moveUp();
            blocks[3].moveDown();
            blocks[3].moveLeft();
            this.asento=3;
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
