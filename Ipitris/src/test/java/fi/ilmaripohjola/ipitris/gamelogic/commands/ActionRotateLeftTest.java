/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gamelogic.commands;

import fi.ilmaripohjola.ipitris.application.logic.GameConfiguration;
import fi.ilmaripohjola.ipitris.gamelogic.commands.ActionRotateLeft;
import fi.ilmaripohjola.ipitris.entities.pieces.PieceI;
import fi.ilmaripohjola.ipitris.entities.GameTable;
import fi.ilmaripohjola.ipitris.gamelogic.GameState;
import fi.ilmaripohjola.ipitris.gamelogic.commands.ActionLeft;
import fi.ilmaripohjola.ipitris.gamelogic.commands.ActionRight;
import fi.ilmaripohjola.ipitris.gamelogic.PieceGenerator;
import java.awt.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author omistaja
 */
public class ActionRotateLeftTest {

    public ActionRotateLeftTest() {
    }

    private GameState gameState;
    private GameTable table;
    private PieceI p;
    private ActionRotateLeft lr;
    private ActionRight actionRight;
    private ActionLeft actionLeft;

    @Before
    public void setUp() {

        table = new GameTable(10, 20);
        this.gameState = new GameState(this.table,new PieceGenerator(new GameConfiguration(10,25,30)));
        p = new PieceI(Color.BLACK, 4, 1);
        gameState.setCurrent(p);
        lr = new ActionRotateLeft();  
        this.actionLeft = new ActionLeft();
        this.actionRight = new ActionRight();
    }
    
    @Test
    public void runWorksNormally() {
        lr.runAction(gameState);
        assertEquals(2, p.getAsento());
    }
    
    @Test
    public void runDoesNotRotateWhenItIsImpossible() {
        this.actionLeft.runAction(gameState);
        this.actionLeft.runAction(gameState);
        this.actionLeft.runAction(gameState);
        this.actionLeft.runAction(gameState);
        this.actionLeft.runAction(gameState);        
        lr.runAction(gameState);
        assertEquals(1, p.getAsento());
        for (int i = 0; i < 10; i++) {
            this.actionRight.runAction(gameState);
        }
        lr.runAction(gameState);
        assertEquals(1, p.getAsento());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
