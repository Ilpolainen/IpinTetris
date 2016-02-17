/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.entities.Block;
import fi.ilmaripohjola.ipitris.entities.Piece;
import fi.ilmaripohjola.ipitris.entities.Table;

/**
 *
 * @author omistaja
 */
public class LimitGuard {

    public boolean connects(Block[] currentBlocks, Block[][] table) {
        for (Block block : currentBlocks) {
            if (table[block.getX()][block.getY()] != null) {
                return true;
            }
        }
        return false;
    }

    public boolean blockWithinLimits(int x, int y, Table table) {
        if (x < 0 || x >= table.getWidth()) {
            return false;
        }
        if (y < 0 || y >= table.getHeight()) {
            return false;
        }
        return true;
    }

    public boolean pieceWithinLimits(Piece current, Table table) {
        Block[] currentBlocks = current.getBlocks();
        for (Block block : currentBlocks) {
            if (!blockWithinLimits(block.getX(), block.getY(), table)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean connects(Piece current, Table table) {
        Block[] currentBlocks = current.getBlocks();
        for (Block block : currentBlocks) {
            if (table.getBlocks()[block.getX()][block.getY()] != null) {
                return true;
            }
        }
        return false;
    }
}
