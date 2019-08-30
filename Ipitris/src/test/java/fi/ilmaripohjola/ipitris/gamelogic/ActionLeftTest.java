/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.application.logic.GameConfiguration;
import fi.ilmaripohjola.ipitris.entities.Block;
import fi.ilmaripohjola.ipitris.entities.pieces.PieceI;
import fi.ilmaripohjola.ipitris.entities.GameTable;
import fi.ilmaripohjola.ipitris.gamelogic.commands.ActionLeft;
import java.awt.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import fi.ilmaripohjola.ipitris.gamelogic.commands.GameAction;
import fi.ilmaripohjola.ipitris.gamelogic.utilities.PieceGenerator;

/**
 *
 * @author omistaja
 */
public class ActionLeftTest {

    GameTable table;
    GameState gameState;
    GameAction actionLeft;
    PieceI pieceI;

    public ActionLeftTest() {
    }

    @Before
    public void setUp() {
        this.table = new GameTable(10, 20);
        this.gameState = new GameState(this.table,new PieceGenerator(new GameConfiguration(10,25,30)));
        this.actionLeft = new ActionLeft();
        pieceI = new PieceI(Color.BLACK, 1, 1);
        gameState.setCurrent(pieceI);
    }

    @Test
    public void moveLeftWorksNormally() {
        this.actionLeft.runAction(gameState);
        for (int i = 0; i < 1; i++) {
            assertEquals(0, pieceI.getBlocks()[i].getX());            
            assertEquals(0, pieceI.getBlocks()[0].getY());
            assertEquals(1, pieceI.getBlocks()[1].getY());
            assertEquals(2, pieceI.getBlocks()[2].getY());
            assertEquals(3, pieceI.getBlocks()[3].getY());
        }
    }
    
    @Test
    public void moveLeftDontExceedTableLimits() {
        this.actionLeft.runAction(gameState);
        this.actionLeft.runAction(gameState);
        for (int i = 0; i < 4; i++) {
            assertEquals(0, pieceI.getBlocks()[i].getX());            
            assertEquals(0, pieceI.getBlocks()[0].getY());
            assertEquals(1, pieceI.getBlocks()[1].getY());
            assertEquals(2, pieceI.getBlocks()[2].getY());
            assertEquals(3, pieceI.getBlocks()[3].getY());
        }
    }
    
    @Test
    public void moveLeftDontCrossOtherBlocks() {
        table.getBlocks()[0][0]=new Block(Color.BLACK,0,0);
        this.actionLeft.runAction(gameState);
        for (int i = 0; i < 4; i++) {
            assertEquals(1, pieceI.getBlocks()[i].getX());            
            assertEquals(0, pieceI.getBlocks()[0].getY());
            assertEquals(1, pieceI.getBlocks()[1].getY());
            assertEquals(2, pieceI.getBlocks()[2].getY());
            assertEquals(3, pieceI.getBlocks()[3].getY());
        }
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
