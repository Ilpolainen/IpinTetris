package fi.ilmaripohjola.ipitris.entities;

import fi.ilmaripohjola.ipitris.entities.Block;
import fi.ilmaripohjola.ipitris.entities.Movable;
import java.awt.Color;

/**
 * Abstract class Piece controls different amount of Blocks, and it's meant to
 * be a controllable object in tetris. Implements movable.
 */
public abstract class Piece implements Movable {

    private final Color color;
    protected Block[] blocks;
    protected int orientation;
    private int x;
    private int y;

    /**
     * Constructor enables it's subclasses to set their color, size, x-coordinat
     * and y-coordinate at desired values.
     *
     * @param color the color of the Piece
     * @param size the block amount of the Piece's block array
     * @param x the anchor x-value of the Piece
     * @param y the anchor y-value of the Piece
     */
    public Piece(Color color, int size, int x, int y) {
        this.color = color;
        this.blocks = new Block[size];
        this.orientation = 1;
        this.x = x;
        this.y = y;
    }

    public int getAsento() {
        return orientation;
    }

    public Block[] getBlocks() {
        return blocks;
    }

    public Color getColor() {
        return color;
    }

    /**
     * All Piece's subclasses must implement somekind of method called
     * rotateLeft() which is intented to use so that it changes object's block's
     * x- and y-values to present a 90 degree roation to the left.
     */
    public void rotateLeft() {

    }

    /**
     * All Piece's subclasses must implement somekind of method called
     * rotateLeft() wich is intented to use so that it changes object's block's
     * x- and y-values to present a 90 degree roation to the right.
     */
    public void rotateRight() {

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Overrides Movables moveUp by calling moveUp for every block in Piece's
     * Array.
     */
    @Override
    public void moveUp() {
        for (Block block : blocks) {
            block.moveUp();
        }
        this.y = this.y - 1;
    }

    /**
     * Overrides Movables moveDown by calling moveDown for every block in
     * Piece's Array.
     */
    @Override
    public void moveDown() {
        for (Block block : blocks) {
            block.moveDown();
        }
        this.y = this.y + 1;
    }

    /**
     * Overrides Movables moveRight by calling moveRight for every block in
     * Piece's Array.
     */
    @Override
    public void moveRight() {
        for (Block block : blocks) {
            block.moveRight();
        }
        this.x = this.x + 1;
    }

    /**
     * Overrides Movables moveLeft by calling moveLeft for every block in
     * Piece's Array.
     */
    @Override
    public void moveLeft() {
        for (Block block : blocks) {
            block.moveLeft();
        }
        this.x = this.x - 1;
    }

    @Override
    public String toString() {
        String result = "\n Color: " + this.color +  "Orientation: " + "\n"
                + this.orientation + "\n"
                + "Coordinates: " + "\n"
                + "first block: (" + blocks[0].getX() + "," + blocks[0].getY() + ")" + "\n"
                + "second block: (" + blocks[1].getX() + "," + blocks[1].getY() + ")" + "\n"
                + "third block: (" + blocks[2].getX() + "," + blocks[2].getY() + ")" + "\n"
                + "fourth block: (" + blocks[3].getX() + "," + blocks[3].getY() + ")" + "\n";
        return result;
    }
}
