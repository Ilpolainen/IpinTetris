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
public class CommandLeft extends Command {



    public CommandLeft(Logic tetris) {
        super(tetris);
    }
    
    
    
    @Override
    public void runCommand() {
        super.getTetris().getCurrent().moveLeft();
        if (!super.getTetris().pieceWithinLimits() || super.getTetris().connects()) {
            super.getTetris().getCurrent().moveRight();
        }
    }
    
    
}
