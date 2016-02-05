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
public class PieceL extends Piece {

    public PieceL(Color color, int x, int y) {
        super(color, 4, x, y);
        super.blocks[0] = new Block(color, x, y - 1);
        super.blocks[1] = new Block(color, x, y);
        super.blocks[2] = new Block(color, x, y + 1);
        super.blocks[3] = new Block(color, x + 1, y + 1);
    }

//    @Override
//    public Block[] getBlocks() {
//        return this.blocks; 
//    }
//    
//    @Override
//    public void moveLeft() {
//         for (Block block : blocks) {
//            block.moveLeft();
//        }
//    }
//
//    @Override
//    public void moveRight() {
//        for (Block block : blocks) {
//            block.moveRight();
//        }
//    }
//
//     @Override
//    public void moveUp() {
//        for (Block block : blocks) {
//            block.moveUp();
//        }
//    }
//
//    @Override
//    public void moveDown() {
//        for (Block block : blocks) {
//            block.moveDown();
//        }
//    }
    @Override
    public void rotateRight() {
        if (asento == 1) {
            rotateRight1();
        } else if (asento == 2) {
            rotateRight2();
        } else if (asento == 3) {
            rotateRight3();
        } else if (asento == 4) {
            rotateRight4();
        }
    }

    protected void rotateRight1() {
        blocks[0].moveDown();
        blocks[0].moveRight();
        blocks[2].moveLeft();
        blocks[2].moveUp();
        blocks[3].moveLeft();
        blocks[3].moveLeft();
        asento = 2;
    }

    protected void rotateRight2() {
        blocks[0].moveDown();
        blocks[0].moveLeft();
        blocks[2].moveRight();
        blocks[2].moveUp();
        blocks[3].moveUp();
        blocks[3].moveUp();
        asento = 3;
    }

    protected void rotateRight3() {
        blocks[0].moveLeft();
        blocks[0].moveUp();
        blocks[2].moveRight();
        blocks[2].moveDown();
        blocks[3].moveRight();
        blocks[3].moveRight();
        asento = 4;
    }

    protected void rotateRight4() {
        blocks[0].moveRight();
        blocks[0].moveUp();
        blocks[2].moveLeft();
        blocks[2].moveDown();
        blocks[3].moveDown();
        blocks[3].moveDown();
        asento = 1;
    }

    @Override
    public void rotateLeft() {
        if (asento == 1) {
            rotateLeft1();
        } else if (asento == 2) {
            rotateLeft2();
        } else if (asento == 3) {
            rotateLeft3();
        } else if (asento == 4) {
            rotateLeft4();
        }

    }

    protected void rotateLeft1() {
        blocks[0].moveDown();
        blocks[0].moveLeft();
        blocks[2].moveRight();
        blocks[2].moveUp();
        blocks[3].moveUp();
        blocks[3].moveUp();
        asento = 4;
    }

    protected void rotateLeft2() {
        blocks[0].moveUp();
        blocks[0].moveLeft();
        blocks[2].moveRight();
        blocks[2].moveDown();
        blocks[3].moveRight();
        blocks[3].moveRight();
        asento = 1;
    }

    protected void rotateLeft3() {
        blocks[0].moveRight();
        blocks[0].moveUp();
        blocks[2].moveLeft();
        blocks[2].moveDown();
        blocks[3].moveDown();
        blocks[3].moveDown();
        asento = 2;
    }

    protected void rotateLeft4() {
        blocks[0].moveDown();
        blocks[0].moveRight();
        blocks[2].moveLeft();
        blocks[2].moveUp();
        blocks[3].moveLeft();
        blocks[3].moveLeft();
        asento = 3;
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
