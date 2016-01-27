package fi.ilmaripohjola.ipitris.entities;

import java.awt.Color;

public abstract class Piece implements Movable {
    
    private Color color;
    private Block[] blocks;

    public Piece(Color color) {
        this.color = color;
        this.blocks = null;
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