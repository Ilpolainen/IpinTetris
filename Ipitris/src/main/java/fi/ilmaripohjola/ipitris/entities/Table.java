package fi.ilmaripohjola.ipitris.entities;

/**
 * Contains an array of blocks and constructs it correctly to meet the
 * recuirements of tetris-board.
 *
 * @author omistaja
 */
public class Table {

    private int width;
    private int height;
    private Block[][] blocks;

    /**
     * Sets a new array of blocks with given width and height and make's sure
     * the numbers aren't too small for tetris.
     *
     * @param width the width of the block array of the table
     * @param height the height - 4 of the block array of the table
     */
    public Table(int width, int height) {
        if (width < 3) {
            width = 3;
        }
        this.width = width;
        if (height < 4) {
            height = 4;
        }
        this.height = height;
        this.blocks = new Block[width][height + 4];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Block[][] getBlocks() {
        return blocks;
    }

    /**
     * Updates the Tables eidth and height attributes and constructs a new Block
     * -array to replace the Tables former block -array.
     *
     * @param width int table width
     * @param height int table height
     */
    public void setTable(int width, int height) {
        if (width < 3) {
            width = 3;
        }
        this.width = width;
        if (height < 4) {
            height = 4;
        }
        this.height = height;
        this.blocks = new Block[width][height + 4];
    }
}
