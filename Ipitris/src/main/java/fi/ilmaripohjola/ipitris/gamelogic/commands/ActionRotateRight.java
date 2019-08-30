package fi.ilmaripohjola.ipitris.gamelogic.commands;

import fi.ilmaripohjola.ipitris.gamelogic.GameState;
import fi.ilmaripohjola.ipitris.gamelogic.utilities.LimitGuard;

/**
 * Extends Command.
 *
 * @See Command
 * @author omistaja
 */
public class ActionRotateRight implements GameAction {

    /**
     * Watch reference from Piece.
     *
     * @see Piece
     * @param tetris a TetrisLogic -object given by caller
     */
    
    /**
     * Calls TerisLogic's current Piece's rotateRight, and handles exceptional
     * situations caused by the game state by using TetrisLogic's methods and
     * it's LimitGuard - situations like going out of bounds or collision with
     * other objects.
     * @param gamestate
     */
    @Override
    public void runAction(GameState gamestate) {
        gamestate.getCurrent().rotateRight();
        if (!LimitGuard.pieceWithinLimits(gamestate.getCurrent(), gamestate.getTable()) || LimitGuard.connects(gamestate.getCurrent(), gamestate.getTable())) {
            gamestate.getCurrent().rotateLeft();
        }
    }

}
