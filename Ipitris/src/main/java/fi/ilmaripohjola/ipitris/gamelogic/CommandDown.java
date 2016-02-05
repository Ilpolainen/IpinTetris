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

    public CommandDown(Logic tetris) {
        super(tetris);
    }
        

    @Override
    public void runCommand() {
        super.getTetris().getCurrent().moveDown();
        if (super.getTetris().connects()) {
            Block[] currentBlocks = super.getTetris().getCurrent().getBlocks();
            super.getTetris().getCurrent().moveUp();
            for (Block block : currentBlocks) {
                if (block.getY() < 4) {
                    super.getTetris().endGame();
                }
            }
            if (super.getTetris().getContinues() != false) {
                super.getTetris().attachAndMakeNew();
                super.getTetris().destroyRows();
            }
        }
        if (!super.getTetris().pieceWithinLimits()) {
            super.getTetris().getCurrent().moveUp();
            super.getTetris().attachAndMakeNew();
            super.getTetris().destroyRows();
        }

    }

}
