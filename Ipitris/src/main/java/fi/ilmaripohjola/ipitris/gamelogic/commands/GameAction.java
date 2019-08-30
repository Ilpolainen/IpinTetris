package fi.ilmaripohjola.ipitris.gamelogic.commands;
import fi.ilmaripohjola.ipitris.gamelogic.GameState;

/**
 * an abstract class that recuire it's subclasses to have a TetrisLogic and a
 * run() -method.Is intented to be used so that runCommand() causes changes in
 GameLogic state.
 *
 * @author omistaja
 * 
 */
@FunctionalInterface
public interface GameAction {

    /**
     * Causes implemented changes in TetrisLogic state.
     * @param gameState
     */
    public void runAction(GameState gameState);
}
