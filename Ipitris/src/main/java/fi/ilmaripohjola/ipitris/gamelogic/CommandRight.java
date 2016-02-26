package fi.ilmaripohjola.ipitris.gamelogic;

/**
 * Extends Command.
 *
 * @See Command
 * @author omistaja
 */
public class CommandRight extends Command {

    /**
     * Watch reference from Piece.
     *
     * @see Piece
     * @param tetris a TetrisLogic -object given by caller
     */
    public CommandRight(Logic tetris) {
        super(tetris);
    }

    /**
     * Calls TerisLogic's current Piece's moveRight, and handles exceptional
     * situations caused by the game state by using TetrisLogic's methods and
     * it's LimitGuard - situations like going out of bounds or collision with
     * other objects.
     */
    @Override
    public void runCommand() {
        super.getTetris().getCurrent().moveRight();
        if (!super.getTetris().getLimitGuard().pieceWithinLimits(super.getTetris().getCurrent(), super.getTetris().getTable()) || super.getTetris().getLimitGuard().connects(super.getTetris().getCurrent(), super.getTetris().getTable())) {
            super.getTetris().getCurrent().moveLeft();
        } //To change body of generated methods, choose Tools | Templates.
    }

}
