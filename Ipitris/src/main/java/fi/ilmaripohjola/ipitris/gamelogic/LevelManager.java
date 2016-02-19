package fi.ilmaripohjola.ipitris.gamelogic;

/**
 * Counts points, level and rows destroyed in a tetris GameLogic's -state.
 *
 * @author omistaja
 */
public class LevelManager {

    private int points;
    private int level;
    private int rowsDestroyed;

    /**
     * Constructor set's all values to zero.
     */
    public LevelManager() {
        this.level = 0;
        this.points = 0;
        this.rowsDestroyed = 0;
    }

    public int getLevel() {
        return level;
    }

    public int getPoints() {
        return points;
    }

    public int getRowsDestroyed() {
        return rowsDestroyed;
    }

    /**
     * Increases level by one while keeping it in desired limit's (preset: min
     * 0, max 20).
     */
    public void levelUp() {
        if (this.level < 20) {
            this.level = this.level + 1;
        }
    }

    /**
     * Increases's rowsDestroyed by one, and call's levelUp() if rowsDestroyed
     * is 12+ since last levelUp.
     */
    public void increaseRowsDestroyed() {
        this.rowsDestroyed = this.rowsDestroyed + 1;
        if (this.rowsDestroyed >= (this.level + 1) * 12) {
            levelUp();
        }
    }

    /**
     * Increases points with given value.
     *
     * @param points The given value used to increase points.
     */
    public void increasePoints(int points) {
        if (points > 0) {
            this.points = this.points + points;
        }
    }
    
    /**
     * Sets all stats to zero.
     */

    public void reset() {
        this.points = 0;
        this.level = 0;
        this.rowsDestroyed = 0;
    }
}
