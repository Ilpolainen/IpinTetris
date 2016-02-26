package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.entities.Block;

/**
 * an abstract class that recuire it's subclasses to have a TetrisLogic and a
 * run() -method. Is intented to be used so that run() causes changes in
 * TetrisLogic state.
 *
 * @author omistaja
 */
public abstract class Command {

    private Logic tetris;

    /**
     * A TetrisLogic -object given by caller.
     *
     * @param tetris a TetrisLogic -object given by caller
     */
    public Command(Logic tetris) {
        this.tetris = tetris;
    }

    public Logic getTetris() {
        return tetris;
    }

    /**
     * Causes implemented changes in TetrisLogic state.
     */
    public void runCommand() {

    }
}
