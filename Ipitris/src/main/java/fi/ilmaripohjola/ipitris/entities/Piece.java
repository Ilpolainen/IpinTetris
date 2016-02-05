package fi.ilmaripohjola.ipitris.entities;

import java.awt.Color;

public abstract class Piece implements Movable {
    
    private Color color;
    protected Block[] blocks;
    protected int asento;
    

    public Piece() {
    }        
    
    public Piece(Color color, int size ,int x, int y) {
        this.color = color;         
        this.blocks = new Block[size];        
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
    
    @Override
    public String toString() {
        String palautettava = "Asento: " + "\n"
                + this.asento + "\n"
                + "Koordinaatit: " + "\n"
                + "eka: (" + blocks[0].getX() + "," + blocks[0].getY() + ")" + "\n"
                + "toka: (" + blocks[1].getX() + "," + blocks[1].getY() + ")" + "\n"
                + "kolmas: (" + blocks[2].getX() + "," + blocks[2].getY() + ")" + "\n"
                + "neljäs: (" + blocks[3].getX() + "," + blocks[3].getY() + ")" + "\n";
        return palautettava;
    }
    
    
    
    
    
}