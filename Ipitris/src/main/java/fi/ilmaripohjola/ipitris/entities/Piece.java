package fi.ilmaripohjola.ipitris.entities;

import java.awt.Color;

public abstract class Piece implements Movable {
    
    private Color color;
    private Block[] blocks;
    int x;
    int y;

    public Piece() {
    }        
    
    public Piece(Color color) {
        this.color = color;                
    }

    public Piece(Color color, int x, int y) {
        this.color = color;
        this.blocks = new Block[4];
        this.x = x;
        this.y = y;
    }
    
    

    public Block[] getBlocks() {
        return blocks;
    }

    public Color getColor() {
        return color;
    }
    
    
    
    public void rotateLeft(){
        
    }
    
    public void rotateRight(){
        
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
    public void moveRight() {
        for (Block block : blocks) {
            block.moveRight();
        }
    }
    
    @Override
    public void moveLeft(){
        for (Block block : blocks) {
            block.moveLeft();
        }
    } 
    
    
    
    
    
}