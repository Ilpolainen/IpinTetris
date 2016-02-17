/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gamelogic;

/**
 *
 * @author omistaja
 */
public class CommandRotateLeft extends Command {

    public CommandRotateLeft() {
    }

    public CommandRotateLeft(TetrisLogic tetris) {
        super(tetris);
    }
    
    
    
    @Override
    public void runCommand() {
        super.getTetris().getCurrent().rotateLeft();
        if (!super.getTetris().getLimitGuard().pieceWithinLimits(super.getTetris().getCurrent(), super.getTetris().getTable()) || super.getTetris().getLimitGuard().connects(super.getTetris().getCurrent(), super.getTetris().getTable())) {
            super.getTetris().getCurrent().rotateRight();
        }
    }
    
   
}
