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
import javax.swing.Timer;

/**
 *
 * @author omistaja
 */
public class GameEngine extends Timer implements ActionListener {

    private Logic tetris;
    private Updatable updatable;
    private boolean continues;

    public GameEngine(Table table, Updatable updatable) {
        super(25, null);
        this.continues = true;
        this.tetris = new Logic(table);
        this.updatable = updatable;
        addActionListener(this);
        setInitialDelay(1000);
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        updatable.updateNow();
        if (this.tetris.getContinues() == false) {
            return;
        }

    }
}
