/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.application.logic.actions;

import fi.ilmaripohjola.ipitris.application.logic.actions.ApplicationAction;
import fi.ilmaripohjola.ipitris.UI.utilities.setkeycommands.StartGameAction;

/**
 *
 * @author Ilmari Pohjola
 */
public enum ApplicationCommand {
    START_GAME(new StartGameAction()),
    PAUSE_GAME(new PauseLoopAction()),
    RESTART_GAME(new RestartAction()),
    QUIT_GAME(new QuitGameAction()),
    EXIT_APPLICATION(new ExitAction());
    
    private final ApplicationAction applicationAction;

    ApplicationCommand(ApplicationAction applicationAction) {
        this.applicationAction = applicationAction;
    }

    public ApplicationAction getApplicationAction() {
        return applicationAction;
    }
    
    
}
