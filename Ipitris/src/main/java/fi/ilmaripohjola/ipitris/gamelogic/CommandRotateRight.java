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
public class CommandRotateRight extends Command {

    public CommandRotateRight(Logic tetris) {        
        super(tetris);        
    }
    
    @Override
    public void runCommand() {
        super.getTetris().getCurrent().rotateRight();
        if (!super.getTetris().pieceWithinLimits() || super.getTetris().connects()) {
            super.getTetris().getCurrent().rotateLeft();
        } //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
