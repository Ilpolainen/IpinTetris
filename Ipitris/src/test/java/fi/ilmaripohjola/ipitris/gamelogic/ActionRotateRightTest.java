/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.application.logic.GameConfiguration;
import fi.ilmaripohjola.ipitris.gamelogic.utilities.PieceGenerator;
import fi.ilmaripohjola.ipitris.gamelogic.commands.ActionRotateRight;
import fi.ilmaripohjola.ipitris.entities.pieces.PieceI;
import fi.ilmaripohjola.ipitris.entities.GameTable;
import fi.ilmaripohjola.ipitris.gamelogic.commands.ActionLeft;
import fi.ilmaripohjola.ipitris.gamelogic.commands.ActionRight;
import java.awt.Color;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import fi.ilmaripohjola.ipitris.gamelogic.commands.GameAction;

/**
 *
 * @author omistaja
 */
public class ActionRotateRightTest {
    
    public ActionRotateRightTest() {
    }
    
    private GameState gameState;
    private GameTable table;
    private PieceI pieceI;
    private GameAction actionRotateRight;
    private GameAction actionLeft;
    private GameAction actionRight;

    @Before
    public void setUp() {
        table = new GameTable(10, 20);
        this.gameState = new GameState(this.table,new PieceGenerator(new GameConfiguration(10,25,30)));
        pieceI = new PieceI(Color.BLACK, 4, 1);
        gameState.setCurrent(pieceI);
        actionRotateRight = new ActionRotateRight();
        this.actionLeft = new ActionLeft();
        this.actionRight = new ActionRight();
    }
    
    @Test
    public void runWorksNormally() {
        actionRotateRight.runAction(gameState);
        assertEquals(2, pieceI.getAsento());
    }
    
    @Test
    public void runDoesNotRotateWhenItIsImpossible() {
        this.actionLeft.runAction(gameState);
        this.actionLeft.runAction(gameState);
        this.actionLeft.runAction(gameState);
        this.actionLeft.runAction(gameState);
        this.actionLeft.runAction(gameState);        
        actionRotateRight.runAction(gameState);
        assertEquals(1, pieceI.getAsento());
        for (int i = 0; i < 10; i++) {
            this.actionRight.runAction(gameState);
        }
        actionRotateRight.runAction(gameState);
        assertEquals(1, pieceI.getAsento());
    }

    
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
