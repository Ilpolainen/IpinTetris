package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.entities.Piece;
import fi.ilmaripohjola.ipitris.entities.GameTable;

/**
 * GameState is presenting the current "worldstate" in the game world.
 * It is essentially a passive class that is used by GameCommands. 
 * The only small function it has, in addition to getters and setters, 
 * is the reset() -command, which wraps the resetting of all it's components
 * into a single function. 
 * @author omistaja
 */
public class GameState {

    private final double initialTickLength;
    private double time;
    private double tickLength;
    private final GameTable table;
    private Piece current;
    private final PieceGenerator generator;
    private boolean gameOver;
    private boolean continues;
    private final LevelProgress levelProgress;

    /**
     * .
     *
     * @param table A Table -object given by caller.
     * @param pieceGenerator
     */
    public GameState(GameTable table, PieceGenerator pieceGenerator) {
        this.time = 0;
        this.levelProgress = new LevelProgress();
        this.initialTickLength = 1000;
        this.tickLength = 3*this.initialTickLength/(2*this.levelProgress.getLevel() + 2);
        this.table = table;
        this.generator = pieceGenerator;
        this.generator.reset();
        this.current = null;
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
     * @param width
     * @param height
     */   
    public void reset(int width, int height) {
        this.time = 0;
        this.generator.reset();
        this.current = this.generator.givePiece();
        this.current = this.generator.givePiece();
        this.table.setTable(width, height);
        this.levelProgress.reset();
        this.tickLength = 3*this.initialTickLength/(2*this.levelProgress.getLevel() + 2);
        this.continues = true;
        this.gameOver = false;
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
        this.gameOver = true;
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

    public LevelProgress getLevelProgress() {
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
        return gameOver;
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
        return tickLength;
    }

    public void setTickTime(double tickTime) {
        this.tickLength = tickTime;
    }
    
    
}
