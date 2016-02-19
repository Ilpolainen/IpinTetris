package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.entities.Block;

/**
 * Extends Command.
 *
 * @See Command
 * @author omistaja
 */
public class CommandDown extends Command {
    /**
     * Watch reference from Piece.
     *
     * @see Piece
     * @param tetris a TetrisLogic -object given by caller
     */

    public CommandDown(TetrisLogic tetris) {
        super(tetris);
    }

    /**
     * Calls TerisLogic's current Piece's moveDown, and handles exceptional
     * situations caused by the game state by using TetrisLogic's methods and
     * it's LimitGuard - situations like hitting ground or collision with other
     * objects causing possibly even ending the game.
     */
    @Override
    public void runCommand() {
        super.getTetris().getCurrent().moveDown();
        if (super.getTetris().getLimitGuard().connects(super.getTetris().getCurrent(), super.getTetris().getTable())) {
            Block[] currentBlocks = super.getTetris().getCurrent().getBlocks();
            super.getTetris().getCurrent().moveUp();
            for (Block block : currentBlocks) {
                if (block.getY() < 4) {
                    super.getTetris().endGame();
                }
            }
            if (super.getTetris().getContinues() != false) {
                super.getTetris().attachAndMakeNew();
                super.getTetris().getRowManager().destroyRows(super.getTetris().getLevelManager(), super.getTetris().getTable());
            }
        }
        if (!super.getTetris().getLimitGuard().pieceWithinLimits(super.getTetris().getCurrent(), super.getTetris().getTable())) {
            super.getTetris().getCurrent().moveUp();
            super.getTetris().attachAndMakeNew();
            super.getTetris().getRowManager().destroyRows(super.getTetris().getLevelManager(), super.getTetris().getTable());
        }
    }

}
