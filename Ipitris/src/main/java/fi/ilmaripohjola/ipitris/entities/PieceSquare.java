/**
 * PieceSquare is a certain kind of Piece
 */
package fi.ilmaripohjola.ipitris.entities;

import java.awt.Color;

/**
 *
 * @author omistaja
 */
public class PieceSquare extends Piece {
    
    public PieceSquare(Color color, int x, int y) {
        super(color, 4, x, y);
        super.blocks[0] = new Block(color, x, y - 1);
        super.blocks[1] = new Block(color, x + 1, y - 1);
        super.blocks[2] = new Block(color, x, y);
        super.blocks[3] = new Block(color, x + 1, y);
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
