/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.application.logic;

import fi.ilmaripohjola.ipitris.gamelogic.commands.GameCommand;
import java.awt.Color;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;
import java.util.HashMap;

/**
 *
 * @author Ilmari Pohjola
 */
public class GameConfiguration {
    private int boardHeight;
    private int boardWidth;
    private int scale;
    public final HashMap<Integer,GameCommand> keyConfiguration;
    public final Color[] colors;

    public GameConfiguration(int boardWidth, int boardHeight, int scale) {
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        this.scale = scale;
        this.keyConfiguration = new HashMap<>();
        this.keyConfiguration.put(VK_DOWN,GameCommand.DOWN);
        this.keyConfiguration.put(VK_UP,GameCommand.ROTATE);
        this.keyConfiguration.put(VK_LEFT, GameCommand.LEFT);
        this.keyConfiguration.put(VK_RIGHT, GameCommand.RIGHT);
        this.colors = new Color[7];
        this.colors[0] = Color.RED;
        this.colors[1] = Color.BLUE;
        this.colors[2] = Color.GREEN;
        this.colors[3] = Color.CYAN;
        this.colors[4] = Color.ORANGE;
        this.colors[5] = Color.YELLOW;
        this.colors[6] = Color.MAGENTA;
    }

    public void setKey(Integer keyCode,GameCommand command) {        
        int temp = -1;
        for (Integer kCode : this.keyConfiguration.keySet()) {
            if (command.equals(this.keyConfiguration.get(kCode))) {
                temp = kCode;
            }
        }
        if (temp >= 0) {
            this.keyConfiguration.remove(temp);
        }
        if (this.keyConfiguration.containsKey(keyCode)) {
            System.out.println("WARNING: There exists already an action for this key! Please choose another key!");
        } else {
            this.keyConfiguration.put(keyCode, command);
        }  
    }
    
    public void setColor(int i, Color color) {
        this.colors[i] = color;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public void setBoardWidth(int boardWidth) {
        this.boardWidth = boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public GameCommand getGameCommand(int keyCode) {
        return this.keyConfiguration.get(keyCode);
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public Color[] getColors() {
        return colors;
    }

    
}
