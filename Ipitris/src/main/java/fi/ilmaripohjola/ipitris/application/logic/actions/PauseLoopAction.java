/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.application.logic.actions;

import fi.ilmaripohjola.ipitris.application.logic.Application;

/**
 *
 * @author Ilmari Pohjola
 */
public class PauseLoopAction extends ApplicationAction {

    public PauseLoopAction() {
        super.actionMessage = "TOGGLE PAUSE!";
    }

    @Override
    public void runAction(Application app) {
        super.runAction(app);
        app.getPlayState().pause();
    }   
}
