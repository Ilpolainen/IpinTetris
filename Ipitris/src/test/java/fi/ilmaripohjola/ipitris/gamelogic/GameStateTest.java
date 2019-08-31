/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.application.logic.GameConfiguration;
import fi.ilmaripohjola.ipitris.gamelogic.utilities.PieceGenerator;
import fi.ilmaripohjola.ipitris.gamelogic.commands.ActionRotateRight;
import fi.ilmaripohjola.ipitris.gamelogic.commands.ActionLeft;
import fi.ilmaripohjola.ipitris.gamelogic.commands.ActionRight;
import fi.ilmaripohjola.ipitris.gamelogic.commands.ActionRotateLeft;
import fi.ilmaripohjola.ipitris.gamelogic.commands.ActionDown;
import fi.ilmaripohjola.ipitris.entities.pieces.Piece;
import fi.ilmaripohjola.ipitris.entities.pieces.PieceI;
import fi.ilmaripohjola.ipitris.entities.GameTable;
import java.awt.Color;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.testng.Assert.assertNotEquals;
import fi.ilmaripohjola.ipitris.gamelogic.commands.GameAction;

/**
 *
 * @author omistaja
 */
public class GameStateTest {
    
    GameConfiguration configuration;
    GameTable table;
    GameState gameState;
    PieceI pieceI;
    GameAction rotateLeft;
    GameAction down;
    GameAction right;
    GameAction left;
    
    public GameStateTest() {
    }    
    
    @Before
    public void setUp() {
        table = new GameTable(10,20);
        this.configuration = new GameConfiguration(10,25,30);
        this.gameState = new GameState(this.table,new PieceGenerator(configuration));
        pieceI = new PieceI(Color.BLACK,4,1);
        rotateLeft = new ActionRotateLeft();
        down = new ActionDown();
        left = new ActionLeft();
        right = new ActionRight();
        gameState.setCurrent(pieceI);
    }
    
    @Test
    public void constructorSetsCorrectTable() {
        assertEquals(table, gameState.getTable());
    }
    
    @Test
    public void constructorCreatesCurrentPiece() {
        assertNotEquals(gameState.getCurrent(), null);
    }
    
    @Test
    public void constructorSetsGameStatusContinues() {
        assertEquals(false, gameState.getContinues());
    }
    
    @Test
    public void constructorSetsLevelRight() {
        assertEquals(0, gameState.getLevel());
    }

    @Test
    public void constructorSetsPointsRight() {
        assertEquals(0, gameState.getPoints());
    }
    
    @Test
    public void constructorSetsRowsDestroyedRight() {
        assertEquals(0, gameState.getLevelProgress().getRowsDestroyed());
    }
    
    
    @Test
    public void costructorCreatesLevelManager() {
        assertNotEquals(null, gameState.getLevelProgress());        
    }
    
    
    @Test
    public void endGameWorks() {
        gameState.endGame();
        assertEquals(false, gameState.getContinues());
    }
    
    @Test
    public void levelUpWorks() {
        gameState.getLevelProgress().levelUp();
        assertEquals(1, gameState.getLevel());
    }
    
    @Test
    public void levelStopsAt20() {
        for (int i = 0; i < 30; i++) {
            gameState.getLevelProgress().levelUp();
        }
        assertEquals(20, gameState.getLevel());
    }
    
    @Test
    public void resetDoesAllThatItNeedsToDo () {
        this.down.runAction(gameState);
        this.down.runAction(gameState);
        this.down.runAction(gameState);
        this.down.runAction(gameState);
        this.rotateLeft.runAction(gameState);
        for (int i = 0; i < 10; i++) {
            this.down.runAction(gameState);
        }
        for (int i = 0; i < 30; i++) {
            gameState.getLevelProgress().increasePoints(5);
        }
        gameState.reset(10, 25);
        assertEquals(0, gameState.getPoints());
        assertEquals(0, gameState.getLevel());
        assertEquals(0, gameState.getLevelProgress().getRowsDestroyed());
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                assertEquals(null, table.getBlocks()[i][j]);
            }
        }
    }
    
    @Test
    public void setTableWorksRight() {
        this.gameState.setTable(4, 5);
        assertEquals(4, table.getWidth());
        assertEquals(5, table.getHeight());
    }
    
    @Test
    public void setTableWorksWithNegativeInput() {
        this.gameState.setTable(-1, -3);
        assertEquals(3, table.getWidth());
        assertEquals(4, table.getHeight());
    }
}
