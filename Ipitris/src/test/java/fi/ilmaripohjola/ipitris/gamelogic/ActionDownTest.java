/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.application.logic.GameConfiguration;
import fi.ilmaripohjola.ipitris.gamelogic.utilities.PieceGenerator;
import fi.ilmaripohjola.ipitris.gamelogic.commands.ActionDown;
import fi.ilmaripohjola.ipitris.entities.Block;
import fi.ilmaripohjola.ipitris.entities.pieces.PieceI;
import fi.ilmaripohjola.ipitris.entities.GameTable;
import java.awt.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.testng.Assert.assertNotEquals;
import fi.ilmaripohjola.ipitris.gamelogic.commands.GameAction;

/**
 *
 * @author omistaja
 */
public class ActionDownTest {

    private GameState gameState;
    private GameTable gameTable;
    private GameAction commandDown;
    private PieceI pieceI;

    public ActionDownTest() {
    }

    @Before
    public void setUp() {
        this.gameTable = new GameTable(10, 25);
        this.gameState = new GameState(gameTable,new PieceGenerator(new GameConfiguration(10,25,30)));
        this.gameState.reset();
        this.commandDown = new ActionDown();
        this.pieceI = new PieceI(Color.BLACK, 0, 1);
        this.gameState.setCurrent(pieceI);
    }


    @Test
    public void runWorksNormally() {
        gameState.setCurrent(pieceI);
        pieceI.setY(1);
        commandDown.runAction(gameState);
        assertEquals(2, pieceI.getY());
    }

    @Test
    public void runCreatesNewCurrentIfCurrentPieceGoesOutOfBounds() {
        gameState.setCurrent(pieceI);
        for (int i = 0; i < 30; i++) {
            commandDown.runAction(gameState);
        }
        assertNotEquals(pieceI, gameState.getCurrent());
    }

    @Test
    public void runCausesACollosionEndsTheGameWhenNewPieceDoesNotFitInTheSreen() {
        for (int i = 0; i < 300; i++) {
            commandDown.runAction(gameState);
        }
        assertEquals(false, gameState.getContinues());
    }

    @Test
    public void runCallsDestroyRows() {
        for (int i = 0; i < 10; i++) {
            gameTable.getBlocks()[i][24] = new Block(Color.RED, i, 24);
        }
        gameTable.getBlocks()[0][24] = null;
        gameState.setCurrent(pieceI);
        for (int i = 0; i < 24; i++) {
            commandDown.runAction(gameState);
        }
        assertEquals(1, gameState.getLevelManager().getPoints());
    }
    
    @Test
    public void runCausesCollision() {
        System.out.println("____________________");
        System.out.println("COLLISION TEST START");
        System.out.println("____________________");
        this.gameState.setCurrent(pieceI);
        for (int i = 0; i < 10; i++) {
            gameTable.getBlocks()[i][8] = new Block(Color.red, 0, 6);
        }
        for (int i = 0; i < 10; i++) {
            commandDown.runAction(gameState);
        }
        System.out.println("____________________");
        System.out.println("COLLISION TEST START");
        System.out.println("____________________");
        assertNotEquals(pieceI, gameState.getCurrent());
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
