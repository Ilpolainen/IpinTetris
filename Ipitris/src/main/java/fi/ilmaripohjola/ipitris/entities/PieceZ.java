/**
 * PieceZ is a certain kind of Piece
 */
package fi.ilmaripohjola.ipitris.entities;

import java.awt.Color;

/**
 *
 * @author omistaja
 */
public class PieceZ extends Piece {
         
    public PieceZ(Color color, int x, int y) {
        super(color, 4, x, y);
        super.blocks[0] = new Block(color, x, y - 1);
        super.blocks[1] = new Block(color, x, y);
        super.blocks[2] = new Block(color, x - 1, y);
        super.blocks[3] = new Block(color, x - 1, y + 1);
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

//    @Override
//    public String toString() {
//        String asento = "Asento: " + "\n"
//                + this.asento + "\n"
//                + "Koordinaatit: " + "\n"
//                + "eka: (" + blocks[0].getX() + "," + blocks[0].getY() + ")" + "\n"
//                + "toka: (" + blocks[1].getX() + "," + blocks[1].getY() + ")" + "\n"
//                + "kolmas: (" + blocks[2].getX() + "," + blocks[2].getY() + ")" + "\n"
//                + "neljäs: (" + blocks[3].getX() + "," + blocks[3].getY() + ")" + "\n";
//        return asento;
//    }
}
