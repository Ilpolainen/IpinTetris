package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.gamelogic.utilities.LimitGuard;
import fi.ilmaripohjola.ipitris.gamelogic.utilities.PieceGenerator;
import fi.ilmaripohjola.ipitris.entities.Block;
import fi.ilmaripohjola.ipitris.entities.pieces.Piece;
import fi.ilmaripohjola.ipitris.entities.GameTable;

/**
 * Handles the rules and state of a tetris -game with the help of LimitGuard and
 * LevelManager.
 *
 * @author omistaja
 */
public class GameState {

    private double time;
    private double tickTime;
    private final GameTable table;
    private Piece current;
    private final PieceGenerator generator;
    private boolean ended;
    private boolean continues;
    private final LevelProgress levelProgress;

    /**
     * Constructor set's up a tetris -game.It needs a table and a
 PieceGenerator. Creates it's own commands.
     *
     * @param table A Table -object given by caller.
     */
    public GameState(GameTable table, PieceGenerator pieceGenerator) {
        this.time = 0;
        this.tickTime = 1000;
        this.table = table;
        this.generator = pieceGenerator;
        this.current = null;
        this.levelProgress = new LevelProgress();
    }

    /**
     * Runs commands accordingly their given boolean values. For example if down
     * is true, it calls commands[0] which is CommandDown in preset -state.
     *
     * @param down boolean to call commands[0]
     * @param left boolean to call commands[1]
     * @param right boolean to call commands[2]
     * @param space boolean to call commands[3]
     */

     /**
     * Set's the table's blocks all null, calls LevelProgress to reset all stats,
     * asks a new current from generator and at the end set's continues true.
     */   
    public void reset() {
        this.time = 0;
        this.tickTime = 1000;
        this.current = this.generator.givePiece();
        this.table.reset();
        this.levelProgress.reset();
        this.continues = true;
        this.ended = false;
    }

    

    /**
     * Updates the table size with given width and height values. NOTE: Current
     * Piece array will be destroyed.
     *
     * @param width desired new table width
     * @param height desired new table height
     */
    public void setTable(int width, int height) {
        this.table.setTable(width, height);
    }


    /**
     * Attaches the blocks of Piece "current" in the Table -objects block array
     * and calls a new current from generator. Also ask's the LimitGuard if it's
     * time to end the game.
     */
    

    /**
     * Sets boolean continues false.
     */
    public void endGame() {
        this.ended = true;
        this.continues = false;
    }

    /**
     * Sets continues parameter true.
     */
    public void unPause() {
        this.continues = true;
    }

    /**
     * Sets continues parameter false.
     */
    public void pause() {
        this.continues = false;
    }
 
    public GameTable getTable() {
        return table;
    }

    public LevelProgress getLevelManager() {
        return levelProgress;
    }

    public void setCurrent(Piece current) {
        this.current = current;
    }

    public Piece getCurrent() {
        return current;
    }

    public PieceGenerator getGenerator() {
        return generator;
    }

    public boolean getContinues() {
        return this.continues;
    }

    public boolean isEnded() {
        return ended;
    }
    
    public int getLevel() {
        return this.levelProgress.getLevel();
    }

    public int getPoints() {
        return this.levelProgress.getPoints();
    }

    public void addGameTime(double deltaTime) {
        this.time = this.time + deltaTime;
    }

    public void setTime(double time) {
        this.time = time;
    }

    
    public double getTime() {
        return time;
    }

    public double getTickTime() {
        return tickTime;
    }

    public void setTickTime(double tickTime) {
        this.tickTime = tickTime;
    }
    
}
