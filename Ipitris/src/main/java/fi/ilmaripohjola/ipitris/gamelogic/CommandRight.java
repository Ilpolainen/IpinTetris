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

    private Logic tetris;
    
    public CommandRight() {
    }

    public CommandRight(Logic tetris) {
        this.tetris = tetris;
    }
    
    
    @Override
    public void runCommand() {
        tetris.getCurrent().moveRight();
        if (!tetris.pieceWithinLimits() || tetris.connects()) {
            tetris.getCurrent().moveLeft();
        } //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
