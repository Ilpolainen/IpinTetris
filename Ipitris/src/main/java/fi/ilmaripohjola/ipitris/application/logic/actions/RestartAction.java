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
public class RestartAction extends ApplicationAction{
    public RestartAction() {
        super.actionMessage = "Restarting Game";
    }

    @Override
    public void runAction(Application app) {
        app.getPlayState().restart(app);
    }
}
