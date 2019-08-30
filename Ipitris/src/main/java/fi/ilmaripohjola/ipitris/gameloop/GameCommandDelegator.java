/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gameloop;

import fi.ilmaripohjola.ipitris.gamelogic.GameState;
import fi.ilmaripohjola.ipitris.gamelogic.commands.ActionDown;
import fi.ilmaripohjola.ipitris.gamelogic.commands.ActionLeft;
import fi.ilmaripohjola.ipitris.gamelogic.commands.ActionRight;
import fi.ilmaripohjola.ipitris.gamelogic.commands.ActionRotateLeft;
import fi.ilmaripohjola.ipitris.gamelogic.commands.GameAction;
import fi.ilmaripohjola.ipitris.gamelogic.commands.GameCommand;
import java.util.EnumMap;
import java.util.EnumSet;

/**
 * PlayState is a state in the application, which can handle inputs given by a gameloop.
 * @author Ilmari Pohjola
 */
public class GameCommandDelegator  {
    private final EnumMap<GameCommand,GameAction> gameActions;
    private final GameState gameState;
    
    public GameCommandDelegator(GameState gameState) {
        
        this.gameState = gameState;
        this.gameActions = new EnumMap<>(GameCommand.class);
        this.gameActions.put(GameCommand.LEFT, new ActionLeft());
        this.gameActions.put(GameCommand.RIGHT, new ActionRight());
        this.gameActions.put(GameCommand.DOWN, new ActionDown());
        this.gameActions.put(GameCommand.ROTATE, new ActionRotateLeft());
        this.gameActions.put(GameCommand.TICK, new ActionDown());
    }
    
    
    /**
     *
     * @param commands
     */
   

    public void processInput(EnumSet<GameCommand> commands) {
        commands.forEach((GameCommand command) -> {
            if (this.gameActions.containsKey(command)) {
                this.gameActions.get(command).runAction(gameState);
            } else {
                System.out.print("Given command '" + command + "' is not supported by the current PlayState");
            }
        });   
    }
    
    public void resetGame() {
        this.gameState.reset();
    }
    
    public void addGameTime(double deltaTime) {
        this.gameState.addGameTime(deltaTime);
        if (this.gameState.getTime() > this.gameState.getTickTime()) {
            this.gameActions.get(GameCommand.DOWN).runAction(gameState);
            this.gameState.setTime(this.gameState.getTime()%this.gameState.getTickTime());
        }
    }
}
