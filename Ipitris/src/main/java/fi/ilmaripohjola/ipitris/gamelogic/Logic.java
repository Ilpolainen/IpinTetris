package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.entities.Block;
import fi.ilmaripohjola.ipitris.entities.Piece;
import fi.ilmaripohjola.ipitris.entities.Table;

/**
 * Handles the rules and state of a tetris -game with the help of LimitGuard and
 * LevelManager.
 *
 * @author omistaja
 */
public class Logic {

    private Table table;
    private Piece current;
    private PieceGenerator generator;
    private boolean ended;
    private boolean continues;
    private Command[] commands;
    private LimitGuard limitGuard;
    private LevelManager levelManager;
    private RowManager rowManager;

    /**
     * Constructor set's up a tetris -game. It needs a table and a
     * PieceGenerator. Creates it's own commands.
     *
     * @param table A Table -object given by caller.
     * @param generator A PieceGenerator object given by caller.
     */
    public Logic(Table table, PieceGenerator generator) {
        this.table = table;
        this.generator = generator;
        this.current = generator.givePiece();
        this.continues = true;
        this.ended = false;
        this.commands = new Command[4];
        this.commands[0] = new CommandDown(this);
        this.commands[1] = new CommandLeft(this);
        this.commands[2] = new CommandRight(this);
        this.commands[3] = new CommandRotateRight(this);
        this.limitGuard = new LimitGuard();
        this.levelManager = new LevelManager();
        this.rowManager = new RowManager();
    }

    /**
     * Runs commands accordingly their given boolean values. For example if down
     * is true, it calls commands[0] wich is CommandDown in preset -state.
     *
     * @param down boolean to call commands[0]
     * @param left boolean to call commands[1]
     * @param right boolean to call commands[2]
     * @param space boolean to call commands[3]
     */
    public void update(boolean down, boolean left, boolean right, boolean space) {
        if (down) {
            this.commands[0].runCommand();
        }
        if (left) {
            this.commands[1].runCommand();
        }
        if (right) {
            this.commands[2].runCommand();
        }
        if (space) {
            this.commands[3].runCommand();
        }
    }

    public Table getTable() {
        return table;
    }

    public LimitGuard getLimitGuard() {
        return limitGuard;
    }

    public LevelManager getLevelManager() {
        return levelManager;
    }

    public RowManager getRowManager() {
        return rowManager;
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

    public Command[] getCommands() {
        return commands;
    }

    /**
     * Sets the Command in given index i in Command array to a new Command.
     *
     * @param i given arrayindex
     * @param command Command with which to replace the Command in given index.
     */
    public void setCommand(int i, Command command) {
        if (i < this.commands.length && i >= 0) {
            this.commands[i] = command;
        }
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

    public int getLevel() {
        return this.levelManager.getLevel();
    }

    public int getPoints() {
        return this.levelManager.getPoints();
    }

    /**
     * Attaches the blocks of Piece "current" in the Table -objects block array
     * and calls a new current from generator. Also ask's the LimitGuard if it's
     * time to end the game.
     */
    public void attachAndMakeNew() {
        Block[] currentBlocks = this.current.getBlocks();
        Block[][] tableBlocks = this.table.getBlocks();
        for (Block block : currentBlocks) {
            int x = block.getX();
            int y = block.getY();
            tableBlocks[x][y] = block;
        }
        this.current = generator.givePiece();
        if (this.limitGuard.connects(current, table)) {
            endGame();
        }
    }

    /**
     * Sets boolean continues false.
     */
    public void endGame() {
        this.ended = true;
        this.continues = false;
    }

    public boolean isEnded() {
        return ended;
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

    /**
     * Set's the table's blocks all null, calls levelmanager to reset all stats,
     * asks a new current from generator and at the end set's continues true.
     */
    public void start() {
        this.current = this.generator.givePiece();
        Block[][] tableBlocks = table.getBlocks();
        for (int i = 0; i < table.getWidth(); i++) {
            for (int j = 0; j < tableBlocks[0].length; j++) {
                tableBlocks[i][j] = null;
            }
        }
        this.levelManager.reset();
        continues = true;
        this.ended = false;
    }
}
