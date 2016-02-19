
package fi.ilmaripohjola.ipitris.entities;

/**
 * Interface, that is intented to use so that the four methods change the x- and y-values of an entity.
 * 
 * @author omistaja
 */
public interface Movable {
    
    /**
     * Intented for reducing entitys y-coordinate(s) by one.
     */
    public void moveUp();
    /**
     * Intented for increasing entitys y-coordinate(s) by one.
     */
    public void moveDown();
    /**
     * Intented for reducing entitys x-coordinate(s) by one.
     */
    public void moveLeft();
    /**
     * Intented for increasing entitys x-coordinate(s) by one.
     */
    public void moveRight();
}

