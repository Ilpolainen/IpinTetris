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
import fi.ilmaripohjola.ipitris.entities.PieceS;
/**
 *
 * @author omistaja
 */
public class Logic {

    private Table table;
    private Piece current;
    private PieceGenerator generator;
    private boolean continues;
    private int level;
    private int points;
    private int rowsDestroyed;
    private Command[] commands;

    public Logic(Table table) {
        this.table = table;
        this.generator = new PieceGenerator(new Random(), table.getWidth());
        this.current = generator.givePiece();        
        this.rowsDestroyed = 0;
        this.continues = true;
        this.level = 0;
        this.points = 0;
        this.commands = new Command[4];
        this.commands[0] = new CommandDown(this);
        this.commands[1] = new CommandLeft(this);
        this.commands[2] = new CommandRight(this);
        this.commands[3] = new CommandRotateRight(this);
    }

    public Command[] getCommands() {
        return commands;
    }

    public void setCommands(Command[] commands) {
        this.commands = commands;
    }

    public int getPoints() {
        return points;
    }
    
    

    public void attachAndMakeNew() {
        Block[] currentBlocks = this.current.getBlocks();
        for (Block block : currentBlocks) {
            this.table.getBlocks()[block.getX()][block.getY()] = block;
        }
        this.current = generator.givePiece();
        if (this.connects()) {
            endGame();
        }
        
    }
    
    public void checkLevel() {
        if (this.rowsDestroyed > (this.level+1) * 12) {
            this.level = this.level + 1;
        }
    }

    public boolean connects() {
        Block[] currentBlocks = this.current.getBlocks();        

        for (Block block : currentBlocks) {
            if (this.table.getBlocks()[block.getX()][block.getY()] != null) {
                return true;
            }
        }
        return false;
    }

    public boolean pieceWithinLimits() {
        Block[] currentBlocks = this.current.getBlocks();
        for (Block block : currentBlocks) {
            if (!blockWithinLimits(block.getX(),block.getY())) {
                return false;
            }
        }
        return true;
    }

    public boolean blockWithinLimits(int x, int y) {
        if (x < 0 || x >= this.table.getWidth()) {
            return false;
        }
        if (y < 0 || y >= this.table.getHeight()) {
            return false;
        }
        return true;
    }
    
    
    
    public void destroyRows() {
        ArrayList<Integer> rowsToDestroy = searchFullRows();
        int morePoints = 0;
        if (rowsToDestroy.size()==1) {
            points = points + 1;
        }
        if (rowsToDestroy.size()==2) {
            points = points + 3;
        }
        if (rowsToDestroy.size()==3) {
            points = points + 5;
        }
        if (rowsToDestroy.size()==4) {
            points = points + 8;
        }
        for (Integer row : rowsToDestroy) {
            destroyRow(row);            
        }
    }
    
    public void destroyRow(int i) {
        for (int j = 0; j < table.getWidth(); j++) {
            this.table.getBlocks()[j][i]=null;
        }
        for (int j = i; j >= 0; j--) {
            for (int k = 0; k < table.getWidth(); k++) {
                if (this.table.getBlocks()[k][j]!=null) {
                    this.table.getBlocks()[k][j].moveDown();
                    this.table.getBlocks()[k][j+1]=this.table.getBlocks()[k][j];
                    this.table.getBlocks()[k][j]=null;
                }
            }
        }
        checkLevel();
    }

    public ArrayList searchFullRows() {
        ArrayList<Integer> rowsToDestroy = new ArrayList<>();
        int piecesInRow = 0;
        for (int i = 0; i < table.getHeight(); i++) {
            for (int j = 0; j < table.getWidth(); j++) {
                if (this.table.getBlocks()[j][i]!= null) {
                    piecesInRow++;
                }
            }
            if (piecesInRow==this.table.getWidth()) {
                rowsToDestroy.add(i);
                this.rowsDestroyed = this.rowsDestroyed + 1; 
            }
            piecesInRow=0;
        }
        
        return rowsToDestroy;
    }
    
    
    
//    public void moveRight() {
//        this.current.moveRight();
//        if (!pieceWithinLimits() || connects()) {
//            this.current.moveLeft();
//        }
//    }
    
//    public void moveLeft() {
//        this.current.moveLeft();
//        if (!pieceWithinLimits() || connects()) {
//            this.current.moveRight();
//        }
//    }
    
//    public void rotateLeft() {
//        this.current.rotateLeft();
//        if (!pieceWithinLimits() || connects()) {
//            this.current.rotateRight();
//        }
//    }
    
//    public void rotateRight() {
//        this.current.rotateRight();
//        if (!pieceWithinLimits() || connects()) {
//            this.current.rotateLeft();
//        }
//    }
    
    
//    public void moveDown() {
//        this.current.moveDown();        
//        if (connects()) {
//            Block[] currentBlocks = this.current.getBlocks();
//            this.current.moveUp();
//            for (Block block : currentBlocks) {
//                if (block.getY() < 4) {
//                    endGame();
//                }
//            }
//            if (continues!=false) {
//                attachAndMakeNew();
//                destroyRows();
//            }                        
//        }
//        if (!pieceWithinLimits()) {
//            this.current.moveUp();
//            attachAndMakeNew();
//            destroyRows();
//        }
//        
//    }

    public int getLevel() {
        return this.level;
    }

    public void setSpeed(int level) {
        if (level < 0) {
            level = 0;
        } 
        if (level>20) {
            level = 20;
        }
        this.level= level ;
    }
    
    public void levelUp() {
        if (this.level<20) {
            this.level = this.level+1;
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
