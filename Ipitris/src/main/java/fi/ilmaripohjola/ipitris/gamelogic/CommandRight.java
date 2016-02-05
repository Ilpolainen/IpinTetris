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
public class CommandRight extends Command {
    
    public CommandRight() {
    }

    public CommandRight(Logic tetris) {
         super(tetris);
    }
    
    
    @Override
    public void runCommand() {
        super.getTetris().getCurrent().moveRight();
        if (!super.getTetris().pieceWithinLimits() || super.getTetris().connects()) {
            super.getTetris().getCurrent().moveLeft();
        } //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
