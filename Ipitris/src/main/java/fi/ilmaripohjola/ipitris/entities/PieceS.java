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
public class PieceS extends Piece {

    

     

    public PieceS(Color color, int x, int y) {
        super(color, 4, x, y);
        super.blocks[0] = new Block(color, x, y - 1);
        super.blocks[1] = new Block(color, x, y);
        super.blocks[2] = new Block(color, x + 1, y);
        super.blocks[3] = new Block(color, x + 1, y + 1);        
    }
    
//    @Override
//    public Block[] getBlocks() {
//        return this.blocks; 
//    }
//
//    @Override
//    public void moveUp() {
//        for (Block block : blocks) {
//            block.moveUp();
//        }
////To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void moveDown() {
//        for (Block block : blocks) {
//            block.moveDown();
//        }
//        //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void moveLeft() {
//        for (Block block : blocks) {
//            block.moveLeft();
//        }
//        //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void moveRight() {
//        for (Block block : blocks) {
//            block.moveRight();
//        }
//    }

    @Override
    public void rotateLeft() {
        if (asento == 1) {
            blocks[0].moveLeft();
            blocks[0].moveDown();
            blocks[2].moveUp();
            blocks[2].moveLeft();
            blocks[3].moveUp();
            blocks[3].moveUp();
            asento = 2;
        } else if (asento == 2) {
            blocks[0].moveRight();
            blocks[0].moveUp();
            blocks[2].moveDown();
            blocks[2].moveRight();
            blocks[3].moveDown();
            blocks[3].moveDown();
            asento = 1;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rotateRight() {
        rotateLeft(); //To change body of generated methods, choose Tools | Templates.
    }

}
