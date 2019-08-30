package fi.ilmaripohjola.ipitris.gamelogic.commands;

import fi.ilmaripohjola.ipitris.gamelogic.GameState;
import fi.ilmaripohjola.ipitris.gamelogic.utilities.LimitGuard;

/**
 * Extends Command.
 *
 * @See Command
 * @author omistaja
 */
public class ActionLeft implements GameAction {

    /**
     * Watch reference from Piece.
     *
     * @see Piece
     * @param tetris a TetrisLogic -object given by caller
     */

    /**
     * Calls TerisLogic's current Piece's moveLeft, and handles exceptional
     * situations caused by the game state by using TetrisLogic's methods and
     * it's LimitGuard - situations like going out of bounds or collision with
     * other objects.
     */
    @Override
    public void runAction(GameState gameState)  {
        gameState.getCurrent().moveLeft();
        if (!LimitGuard.pieceWithinLimits(gameState.getCurrent(), gameState.getTable()) || LimitGuard.connects(gameState.getCurrent(), gameState.getTable())) {
            gameState.getCurrent().moveRight();
        }
    }
}
