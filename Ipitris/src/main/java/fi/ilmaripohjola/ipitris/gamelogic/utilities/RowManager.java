package fi.ilmaripohjola.ipitris.gamelogic.utilities;

import fi.ilmaripohjola.ipitris.entities.Block;
import fi.ilmaripohjola.ipitris.entities.GameTable;
import fi.ilmaripohjola.ipitris.gamelogic.LevelProgress;
import java.util.ArrayList;

/**
 * Helps GameLogic -class to handle row -events like searching and destroying
 * them.
 *
 * @author omistaja
 */
public class RowManager {

    /**
     * Calls destroyRow for every row with index in the index-list given by call
     * searchFullRows, and calls levelmanager to handle scoring and levelling
     * accordingly.
     *
     * @param levelManager The LevelManager whose points are updated while
     * destroying rows.
     * @param table The table whose rows are affected.
     */
    public static void destroyRows(LevelProgress levelManager, GameTable table) {
        ArrayList<Integer> rowsToDestroy = searchFullRows(levelManager, table);
        if (rowsToDestroy.size() == 1) {
            levelManager.increasePoints(1);
        }
        if (rowsToDestroy.size() == 2) {
            levelManager.increasePoints(3);
        }
        if (rowsToDestroy.size() == 3) {
            levelManager.increasePoints(5);
        }
        if (rowsToDestroy.size() == 4) {
            levelManager.increasePoints(8);
        }
        for (Integer row : rowsToDestroy) {
            destroyRow(row, table);
        }
    }

    /**
     * Set's given row's block array's blocks null. And moves all blocks with
     * smaller y-coordinate in the table one step down.
     *
     * @param i the rownumber to destroy
     * @param table The Table whose row is to be destroyed.
     */
    public static void destroyRow(int i, GameTable table) {
        Block[][] blocks = table.getBlocks();
        for (int j = 0; j < table.getWidth(); j++) {
            blocks[j][i] = null;
        }
        for (int j = i; j >= 0; j--) {
            for (int k = 0; k < table.getWidth(); k++) {
                if (blocks[k][j] != null) {
                    blocks[k][j].moveDown();
                    blocks[k][j + 1] = table.getBlocks()[k][j];
                    blocks[k][j] = null;
                }
            }
        }
    }

    /**
     * Searches every row in Tables block array with no null values, and adds
     * it's row-index to a list.
     *
     * @param levelManager The LevelManager, whose destroyedRows is updated
     * after collecting the correct rows.
     * @param table The Table whose rows are effected.
     * @return The list of indexes of rows with no null block -values.
     */
    public static ArrayList<Integer> searchFullRows(LevelProgress levelManager, GameTable table) {
        ArrayList<Integer> rowsToDestroy = new ArrayList<>();
        int piecesInRow = 0;
        for (int i = 0; i < table.getHeight(); i++) {
            for (int j = 0; j < table.getWidth(); j++) {
                if (table.getBlocks()[j][i] != null) {
                    piecesInRow++;
                }
            }
            if (piecesInRow == table.getWidth()) {
                rowsToDestroy.add(i);
                levelManager.increaseRowsDestroyed();
            }
            piecesInRow = 0;
        }
        return rowsToDestroy;
    }
}
