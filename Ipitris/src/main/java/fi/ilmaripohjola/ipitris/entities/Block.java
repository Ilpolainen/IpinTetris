/**
 * Block contains and handles x and y coordinates and handles, and the color of the tetris game's square. Implements movable.
 */
package fi.ilmaripohjola.ipitris.entities;

import java.awt.Color;

/**
 * Block contains and handles x and y coordinates and handles, and the color of the tetris game's square. Implements movable.
 * @author omistaja
 */
public class Block implements Movable {

    private int x;
    private int y;
    private final Color color;
    
    /**
     * Constructs a Block with given values.
     * 
     * @param color The color of the Block given by caller.
     * @param x The x-coordinate of the Block given by caller.
     * @param y The y-coordinate of the block given by caller.
     */

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

    /**
     * Reduses Blocks y-coordinate by one. NOTE: Does not change it's position on the Table-array
     */
       
    @Override
    public void moveUp() {
        this.y = this.y - 1; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Increases Blocks y-coordinate by one. NOTE: Does not change it's position on the Table-array
     */
    
    @Override
    public void moveDown() {
        this.y = this.y + 1; //To change body of generated methods, choose Tools | Templates.
    }
    
     /**
     * Reduses Blocks x-coordinate by one. NOTE: Does not change it's position on the Table-array
     */

    @Override
    public void moveLeft() {
        this.x = this.x - 1; //To change body of generated methods, choose Tools | Templates.
    }

     /**
     * Increases Blocks X-coordinate by one. NOTE: Does not change it's position on the Table-array
     */
    
    @Override
    public void moveRight() {
        this.x = this.x + 1; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return this.x + "," + this.y; //To change body of generated methods, choose Tools | Templates.
    }
    
}
