/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.entities.Block;

/**
 *
 * @author omistaja
 */
public class CommandDown extends Command {

    private Logic tetris;

    public CommandDown() {
    }
    
    

    public CommandDown(Logic tetris) {
        this.tetris=tetris;
    }
        

    @Override
    public void runCommand() {
        this.tetris.getCurrent().moveDown();
        if (this.tetris.connects()) {
            Block[] currentBlocks = this.tetris.getCurrent().getBlocks();
            this.tetris.getCurrent().moveUp();
            for (Block block : currentBlocks) {
                if (block.getY() < 4) {
                    this.tetris.endGame();
                }
            }
            if (this.tetris.getContinues() != false) {
                this.tetris.attachAndMakeNew();
                this.tetris.destroyRows();
            }
        }
        if (!this.tetris.pieceWithinLimits()) {
            this.tetris.getCurrent().moveUp();
            this.tetris.attachAndMakeNew();
            this.tetris.destroyRows();
        }

    }

}
