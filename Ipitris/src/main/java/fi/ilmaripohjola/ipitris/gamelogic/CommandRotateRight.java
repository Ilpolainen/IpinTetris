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

    private Logic tetris;
    
    public CommandRotateRight() {
    }

    public CommandRotateRight(Logic tetris) {        
        this.tetris = tetris;        
    }
    
    
    
    @Override
    public void runCommand() {
        tetris.getCurrent().rotateRight();
        if (!tetris.pieceWithinLimits() || tetris.connects()) {
            this.tetris.getCurrent().rotateLeft();
        } //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
