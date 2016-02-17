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
public abstract class Command {
    
    private TetrisLogic tetris;

    public Command() {
    }
        

    public Command(TetrisLogic tetris) {
        this.tetris = tetris;
    }

    public TetrisLogic getTetris() {
        return tetris;
    }
    
    
    
    public void runCommand() {
        
    }
}
