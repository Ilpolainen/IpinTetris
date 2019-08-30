/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.UI.utilities.setkeycommands;

import fi.ilmaripohjola.ipitris.application.logic.Application;
import fi.ilmaripohjola.ipitris.application.logic.actions.ApplicationAction;

/**
 *
 * @author Ilmari Pohjola
 */
public class StartGameAction extends ApplicationAction{

    private boolean running;
    
    public StartGameAction() {
        super.actionMessage = "Starting Game";
        this.running = false;
    }

    @Override
    public void runAction(Application app) {
        super.runAction(app);
        app.getConfigurationState().setInActive(app);
        if (this.running) {
            app.getPlayState().setActive(app);
        } else {
            app.getPlayState().start(app);
            this.running = true;
        }  
    }
}
