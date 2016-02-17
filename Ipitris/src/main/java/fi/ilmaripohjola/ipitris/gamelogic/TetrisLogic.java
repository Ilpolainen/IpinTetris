/**
 * Logic is still a kind of a mess that tries to oversee the rules and logics of
 * tetris.
 */
package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.entities.Block;
import fi.ilmaripohjola.ipitris.entities.Piece;
import fi.ilmaripohjola.ipitris.entities.PieceI;
import fi.ilmaripohjola.ipitris.entities.Table;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import fi.ilmaripohjola.ipitris.entities.PieceS;

public class TetrisLogic {

    private Table table;
    private Piece current;
    private PieceGenerator generator;
    private boolean continues;
    private Command[] commands;
    private LimitGuard limitGuard;
    private LevelManager levelManager;

    public TetrisLogic(Table table, PieceGenerator generator) {
        this.table = table;        
        this.generator = generator;
        this.current = generator.givePiece();
        this.continues = true;
        this.commands = new Command[4];
        this.commands[0] = new CommandDown(this);
        this.commands[1] = new CommandLeft(this);
        this.commands[2] = new CommandRight(this);
        this.commands[3] = new CommandRotateRight(this);
        this.limitGuard = new LimitGuard();
        this.levelManager = new LevelManager();
    }

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

    public void setCommand(int i, Command command) {
        if (i < this.commands.length && i >= 0) {
            this.commands[i] = command;
        }
    }

    public int getLevel() {
        return this.levelManager.getLevel();
    }

    public int getPoints() {
        return this.levelManager.getPoints();
    }

    public void attachAndMakeNew() {
        Block[] currentBlocks = this.current.getBlocks();
        for (Block block : currentBlocks) {
            this.table.getBlocks()[block.getX()][block.getY()] = block;
        }
        this.current = generator.givePiece();
        if (this.limitGuard.connects(current, table)) {
            endGame();
        }
    }

    public void destroyRows() {
        ArrayList<Integer> rowsToDestroy = searchFullRows();
        int morePoints = 0;
        if (rowsToDestroy.size() == 1) {
            this.levelManager.increasePoints(1);
        }
        if (rowsToDestroy.size() == 2) {
            this.levelManager.increasePoints(3);
        }
        if (rowsToDestroy.size() == 3) {
            this.levelManager.increasePoints(5);
        }
        if (rowsToDestroy.size() == 4) {
            this.levelManager.increasePoints(8);
        }
        for (Integer row : rowsToDestroy) {
            destroyRow(row);
        }
    }

    public void destroyRow(int i) {
        for (int j = 0; j < table.getWidth(); j++) {
            this.table.getBlocks()[j][i] = null;
        }
        for (int j = i; j >= 0; j--) {
            for (int k = 0; k < table.getWidth(); k++) {
                if (this.table.getBlocks()[k][j] != null) {
                    this.table.getBlocks()[k][j].moveDown();
                    this.table.getBlocks()[k][j + 1] = this.table.getBlocks()[k][j];
                    this.table.getBlocks()[k][j] = null;
                }
            }
        }
    }

    public ArrayList<Integer> searchFullRows() {
        ArrayList<Integer> rowsToDestroy = new ArrayList<>();
        int piecesInRow = 0;
        for (int i = 0; i < table.getHeight(); i++) {
            for (int j = 0; j < table.getWidth(); j++) {
                if (this.table.getBlocks()[j][i] != null) {
                    piecesInRow++;
                }
            }
            if (piecesInRow == this.table.getWidth()) {
                rowsToDestroy.add(i);
                this.levelManager.increaseRowsDestroyed();
            }
            piecesInRow = 0;
        }
        return rowsToDestroy;
    }

    public void endGame() {
        this.continues = false;
    }
}
