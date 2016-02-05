/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gameengine;

import fi.ilmaripohjola.ipitris.entities.Table;
import fi.ilmaripohjola.ipitris.gamelogic.Logic;
import fi.ilmaripohjola.ipitris.utilities.Renderer;
import fi.ilmaripohjola.ipitris.utilities.Updatable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Clock;
import javax.swing.Timer;

/**
 *
 * @author omistaja
 */
public class GameLoop extends Timer implements ActionListener {

    private Logic tetris;
    private Updatable updatable;
    private boolean continues;
    private int round;    
   

    public GameLoop(Logic tetris, Updatable updatable) {
        super(20, null);
        this.tetris = tetris;
        this.continues = true;        
        this.updatable = updatable;
        addActionListener(this);
        setInitialDelay(100);
        this.round=0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        if (this.tetris.getContinues() == false) {            
            updatable.updateNow();
            this.stop();               
            }
        if (this.round==21-tetris.getLevel()) {   
            tetris.getCommands()[0].runCommand();
            this.round=0;
        } else {
            this.round=this.round+1;
        }        
        updatable.updateNow();               
    }

    
    
    
    
    
}
