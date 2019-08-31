package fi.ilmaripohjola.ipitris.gamelogic.commands;
import fi.ilmaripohjola.ipitris.entities.Block;
import fi.ilmaripohjola.ipitris.gamelogic.GameState;
import fi.ilmaripohjola.ipitris.gamelogic.utilities.LimitGuard;
import fi.ilmaripohjola.ipitris.gamelogic.utilities.RowManager;

/**
 * Extends Command.
 *
 * @See Command
 * @author omistaja
 */
public class ActionDown implements GameAction {
    /**
     * Watch reference from Piece.
     *
     * @see Piece
     * @param tetris a TetrisLogic -object given by caller
     */
    
    public ActionDown()  {
    }

    /**
     * Calls TerisLogic's current Piece's moveDown, and handles exceptional
     * situations caused by the game state by using TetrisLogic's methods and
     * it's LimitGuard - situations like hitting ground or collision with other
     * objects causing possibly even ending the game.
     * @param gameState
     */
    @Override
    public void runAction(GameState gameState) {   
        gameState.getCurrent().moveDown();
            if (LimitGuard.connects(gameState.getCurrent(), gameState.getTable())) {
            Block[] currentBlocks = gameState.getCurrent().getBlocks();
            gameState.getCurrent().moveUp();
            for (Block block : currentBlocks) {
                if (block.getY() < 4) {
                    gameState.endGame();
                }
            }
            if (gameState.getContinues()) {
                this.attachAndMakeNew(gameState);
                RowManager.destroyRows(gameState);
            }
        }
        if (!LimitGuard.pieceWithinLimits(gameState.getCurrent(), gameState.getTable())) {
            gameState.getCurrent().moveUp();
            this.attachAndMakeNew(gameState);
            RowManager.destroyRows(gameState);
        }
    }
    
    public void attachAndMakeNew(GameState gamestate) {
         for (Block block : gamestate.getCurrent().getBlocks()) {
            int x = block.getX();
            int y = block.getY();
            gamestate.getTable().getBlocks()[x][y] = block;
        }
        gamestate.setCurrent(gamestate.getGenerator().givePiece());
        if (LimitGuard.connects(gamestate.getCurrent(), gamestate.getTable())) {
            gamestate.endGame();
        }
    }
}
