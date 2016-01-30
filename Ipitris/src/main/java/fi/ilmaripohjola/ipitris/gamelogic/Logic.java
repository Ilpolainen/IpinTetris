/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.entities.Block;
import fi.ilmaripohjola.ipitris.entities.Piece;
import fi.ilmaripohjola.ipitris.entities.PieceI;
import fi.ilmaripohjola.ipitris.entities.Table;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author omistaja
 */
public class Logic {

    private Table table;
    private Piece current;
    private PieceGenerator generator;
    private boolean continues;

    public Logic(Table table) {
        this.table = table;
        this.generator = new PieceGenerator(new Random(), table.getWidth());
//        this.current = generator.givePiece();
        this.current = new PieceI(Color.BLUE,3,3);
        this.continues = true;
    }

    public void attachAndMakeNew() {
        Block[] currentBlocks = this.current.getBlocks();
        for (Block block : currentBlocks) {
            this.table.getBlocks()[block.getX()][block.getY()] = block;
        }
        this.current = generator.givePiece();
    }

    public boolean connects() {
        Block[] currentBlocks = this.current.getBlocks();        

        for (Block block : currentBlocks) {
            if (this.table.getBlocks()[block.getX()][block.getY()] == null) {
                return false;
            }
        }
        return true;
    }

    public boolean pieceWithinLimits() {
        Block[] currentBlocks = this.current.getBlocks();
        for (Block block : currentBlocks) {
            return blockWithinLimits(block.getX(), block.getY());
        }
        return false;
    }

    public boolean blockWithinLimits(int x, int y) {
        if (x < 0 || x >= this.table.getWidth()) {
            return false;
        }
        if (x < 0 || y >= this.table.getHeight()) {
            return false;
        }
        return true;
    }
    
    public void destroyRows() {
        ArrayList<Integer> rowsToDestroy = searchFullRows();
        for (Integer row : rowsToDestroy) {
            destroyRow(row);
        }
    }
    
    public void destroyRow(int i) {
        for (int j = 0; j < table.getWidth(); j++) {
            this.table.getBlocks()[j][i]=null;
        }
    }

    public ArrayList searchFullRows() {
        ArrayList<Integer> rowsToDestroy = new ArrayList<>();
        int piecesInRow = 0;
        for (int i = 0; i < table.getHeight()-4; i++) {
            for (int j = 0; j < table.getWidth(); j++) {
                if (this.table.getBlocks()[j][i]!= null) {
                    piecesInRow++;
                }
            }
            if (piecesInRow==this.table.getWidth()) {
                rowsToDestroy.add(i);
            }
            piecesInRow=0;
        }
        return rowsToDestroy;
    }
    
    public void moveLeft() {
        this.current.moveLeft();
        if (!pieceWithinLimits() || connects()) {
            this.current.moveRight();
        }
    }
    
    public void moveRight() {
        this.current.moveRight();
        if (!pieceWithinLimits() || connects()) {
            this.current.moveLeft();
        }
    }
    
    public void rotateLeft() {
        this.current.rotateLeft();
        if (!pieceWithinLimits() || connects()) {
            this.current.rotateRight();
        }
    }
    
    public void rotateRight() {
        this.current.rotateRight();
        if (!pieceWithinLimits() || connects()) {
            this.current.rotateLeft();
        }
    }
    
    public void moveDown() {
        this.current.moveDown();
        if (!pieceWithinLimits()) {
            this.current.moveUp();
            attachAndMakeNew();
        }
        if (connects()) {
            Block[] currentBlocks = this.current.getBlocks();
            this.current.moveUp();
            for (Block block : currentBlocks) {
                if (block.getY() < 0) {
                    endGame();
                }
            }            
            attachAndMakeNew();
        }
    }

    public Table getTable() {
        return table;
    }

    public Piece getCurrent() {
        return current;
    }
    
    public boolean getContinues() {
        return this.continues;
    }
    
    public void endGame() {
        this.continues = false;
    }
}
