/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gamelogic;

/**
 *
 * @author omistaja
 */
public class LevelManager {

    private int points;
    private int level;
    private int rowsDestroyed;

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

    public void levelUp() {
        if (this.level < 20) {
            this.level = this.level + 1;
        }
    }

    

    public void increaseRowsDestroyed() {
        this.rowsDestroyed = this.rowsDestroyed + 1;
        if (this.rowsDestroyed >= (this.level + 1) * 12) {
            levelUp();
        }
    }

    public void increasePoints(int points) {
        if (points > 0) {
            this.points = this.points + points;
        }        
    }
}
