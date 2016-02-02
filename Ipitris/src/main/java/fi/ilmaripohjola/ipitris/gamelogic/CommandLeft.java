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

    private Logic tetris;

    public CommandLeft(Logic tetris) {
        this.tetris=tetris;
    }
    
    
    
    @Override
    public void runCommand() {
        this.tetris.getCurrent().moveLeft();
        if (!tetris.pieceWithinLimits() || tetris.connects()) {
            tetris.getCurrent().moveRight();
        }
    }
    
    
}
