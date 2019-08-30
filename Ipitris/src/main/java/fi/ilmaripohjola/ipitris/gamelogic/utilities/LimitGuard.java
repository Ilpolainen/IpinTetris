package fi.ilmaripohjola.ipitris.gamelogic.utilities;

import fi.ilmaripohjola.ipitris.entities.Block;
import fi.ilmaripohjola.ipitris.entities.pieces.Piece;
import fi.ilmaripohjola.ipitris.entities.GameTable;

/**
 * Check's TetrisLogic's current Piece is in desired limit's.
 *
 * @author omistaja
 */
public class LimitGuard {

    /**
     * Checks if the given table has indexes given by x- and y- coordinates.
     *
     * @param x an int to present the x-value of an object given by caller
     * @param y an int to present the y-value of an object given by caller
     * @param table a Table -object that indexes the gives x and y values are
     * compared to.
     * @return Returns false if table[y][x] is outOfBounds.
     */
    public static boolean blockWithinLimits(int x, int y, GameTable table) {
        if (x < 0 || x >= table.getWidth()) {
            return false;
        }
        if (y < 0 || y >= table.getHeight()) {
            return false;
        }
        return true;
    }

    /**
     * Calls blockWithinLimits for every block's x and y -coordinate in
     * current's blockarray.
     *
     * @param current a Piece -object whose blocks are compared to given Table's
     * blocks.
     * @param table a Table -object whose blocks are compared to given Piece's
     * blocks-
     * @return If any of those calls return false. This method returns false.
     * Otherwise true.
     */
    public static boolean pieceWithinLimits(Piece current, GameTable table) {
        Block[] currentBlocks = current.getBlocks();
        for (Block block : currentBlocks) {
            if (!blockWithinLimits(block.getX(), block.getY(), table)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if any block in current's -blocarray has the same x- and y- values
     * with any block in table's -blockarray.
     *
     * @param current Piece current given by caller.
     * @param table Table given by caller.
     * @return Returns true if some of them have the same values.
     */
    public static boolean connects(Piece current, GameTable table) {
        Block[] currentBlocks = current.getBlocks();
        for (Block block : currentBlocks) {
            if (table.getBlocks()[block.getX()][block.getY()] != null) {
                return true;
            }
        }
        return false;
    }
}
