/**
 * Abstract class Piece controls different amount of Blocks, and it's meant to be a controllable object in tetris.
 */

package fi.ilmaripohjola.ipitris.entities;

import java.awt.Color;

public abstract class Piece implements Movable {

    private Color color;
    protected Block[] blocks;
    protected int asento;
    private int x;
    private int y;

    public Piece() {
    }

    public Piece(Color color, int size, int x, int y) {
        this.color = color;
        this.blocks = new Block[size];
        this.asento = 1;
        this.x = x;
        this.y = y;
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

    public void rotateLeft() {

    }

    public void rotateRight() {

    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void moveUp() {
        for (Block block : blocks) {
            block.moveUp();
        }
        this.y = this.y - 1;
    }

    @Override
    public void moveDown() {
        for (Block block : blocks) {
            block.moveDown();
        }
        this.y = this.y + 1;
    }

    @Override
    public void moveRight() {
        for (Block block : blocks) {
            block.moveRight();
        }
        this.x = this.x + 1;
    }

    @Override
    public void moveLeft() {
        for (Block block : blocks) {
            block.moveLeft();
        }
        this.x = this.x - 1;
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
