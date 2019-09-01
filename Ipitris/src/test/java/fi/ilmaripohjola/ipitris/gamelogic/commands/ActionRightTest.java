/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gamelogic.commands;

import fi.ilmaripohjola.ipitris.application.logic.GameConfiguration;
import fi.ilmaripohjola.ipitris.entities.Block;
import fi.ilmaripohjola.ipitris.entities.pieces.PieceI;
import fi.ilmaripohjola.ipitris.entities.GameTable;
import fi.ilmaripohjola.ipitris.gamelogic.GameState;
import fi.ilmaripohjola.ipitris.gamelogic.commands.ActionRight;
import fi.ilmaripohjola.ipitris.gamelogic.PieceGenerator;
import java.awt.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author omistaja
 */
public class ActionRightTest {
    
    GameTable table;
    GameState gameState;
    ActionRight actionRight = new ActionRight();
    PieceI pieceI;

    public ActionRightTest() {
    }

    @Before
    public void setUp() {
        table = new GameTable(10, 20);
        this.gameState = new GameState(this.table,new PieceGenerator(new GameConfiguration(10,25,30)));
        pieceI = new PieceI(Color.BLACK, 8, 1);
        gameState.setCurrent(pieceI);
    }

    @Test
    public void moveRightWorksNormally() {
        actionRight.runAction(gameState);
        for (int i = 0; i < 4; i++) {
            assertEquals(9, pieceI.getBlocks()[i].getX());            
            assertEquals(0, pieceI.getBlocks()[0].getY());
            assertEquals(1, pieceI.getBlocks()[1].getY());
            assertEquals(2, pieceI.getBlocks()[2].getY());
            assertEquals(3, pieceI.getBlocks()[3].getY());
        }
    }
    
    @Test
    public void moveRightDontExceedTableLimits() {
        this.actionRight.runAction(gameState);
        this.actionRight.runAction(gameState);
        this.actionRight.runAction(gameState);
        for (int i = 0; i < 4; i++) {
            assertEquals(9, pieceI.getBlocks()[i].getX());            
            assertEquals(0, pieceI.getBlocks()[0].getY());
            assertEquals(1, pieceI.getBlocks()[1].getY());
            assertEquals(2, pieceI.getBlocks()[2].getY());
            assertEquals(3, pieceI.getBlocks()[3].getY());
        }
    }
    
    @Test
    public void moveRightDontCrossOtherBlocks() {
        table.getBlocks()[2][9]=new Block(Color.BLACK,0,0);
        this.actionRight.runAction(gameState);
        for (int i = 0; i < 4; i++) {
            assertEquals(9, pieceI.getBlocks()[i].getX());            
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
