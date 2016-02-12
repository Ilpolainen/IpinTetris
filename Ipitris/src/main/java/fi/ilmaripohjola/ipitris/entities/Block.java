/**
 * Block contains and handles x and y coordinates and handles, and the color of the tetris game's square. Implements movable.
 */
package fi.ilmaripohjola.ipitris.entities;

import java.awt.Color;

/**
 *
 * @author omistaja
 */
public class Block implements Movable {

    private int x;
    private int y;
    private Color color;

    public Block(Color color, int x, int y) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void moveUp() {
        this.y = this.y - 1; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveDown() {
        this.y = this.y + 1; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveLeft() {
        this.x = this.x - 1; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveRight() {
        this.x = this.x + 1; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return this.x + "," + this.y; //To change body of generated methods, choose Tools | Templates.
    }
    
}
