/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.entities.Piece;
import fi.ilmaripohjola.ipitris.entities.PieceI;
import fi.ilmaripohjola.ipitris.entities.Table;
import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author omistaja
 */
public class LogicTest {
    
    Table t;
    Logic l;
    Piece p;
    Command c;
    
    public LogicTest() {
    }    
    
    @Before
    public void setUp() {
        t = new Table(10,20);
        l = new Logic(t);
        p = new PieceI(Color.BLACK,4,1);
        c = new CommandRotateLeft();
    }
    
    @Test
    public void constructorSetsCorrectTable() {
        assertEquals(t, l.getTable());
    }
    
    @Test
    public void constructorCreatesCurrentPiece() {
        assertNotEquals(l.getCurrent(), null);
    }
    
    @Test
    public void constructorSetsGameStatusContinues() {
        assertEquals(true, l.getContinues());
    }
    
    @Test
    public void constructorSetsLevelRight() {
        assertEquals(0, l.getLevel());
    }

    @Test
    public void constructorSetsPointsRight() {
        assertEquals(0, l.getPoints());
    }
    
    @Test
    public void constructorSetsCorrectlySizedPieceGenerator() {
        assertEquals(10, l.getGenerator().getTableWidth());
    }
    
    @Test
    public void constructorSetsRowsDestroyedRight() {
        assertEquals(0, l.getRowsDestroyed());
    }
    
    @Test
    public void constructorSetsCorrectCommands() {
        assertEquals(l.getCommands().length, 4);
        assertEquals(l.getCommands()[0].getClass(),CommandDown.class);
        assertEquals(l.getCommands()[1].getClass(),CommandLeft.class);
        assertEquals(l.getCommands()[2].getClass(),CommandRight.class);
        assertEquals(l.getCommands()[3].getClass(),CommandRotateRight.class);
    }
    
    @Test
    public void setCommandWorksNormally() {
        l.setCommand(0, c);
        assertEquals(CommandRotateLeft.class, c.getClass());
    }
    
    @Test
    public void setCommandsIgnoresNegativeInputs() {
        l.setCommand(-2, c);
        assertEquals(l.getCommands()[0].getClass(),CommandDown.class);
        assertEquals(l.getCommands()[1].getClass(),CommandLeft.class);
        assertEquals(l.getCommands()[2].getClass(),CommandRight.class);
        assertEquals(l.getCommands()[3].getClass(),CommandRotateRight.class);
    }
    
    @Test
    public void setCommandsIgnoresTooBigInputs() {
        int big = l.getCommands().length;
        l.setCommand(big, c);
        assertEquals(l.getCommands()[0].getClass(),CommandDown.class);
        assertEquals(l.getCommands()[1].getClass(),CommandLeft.class);
        assertEquals(l.getCommands()[2].getClass(),CommandRight.class);
        assertEquals(l.getCommands()[3].getClass(),CommandRotateRight.class);
    }
    
    @Test
    public void endGameWorks() {
        l.endGame();
        assertEquals(false, l.getContinues());
    }
    
    @Test
    public void attachAndMakeNewWorks() {        
        l.setCurrent(p);
        l.attachAndMakeNew();
        assertEquals(l.getTable().getBlocks()[4][0],p.getBlocks()[0]);
        assertEquals(l.getTable().getBlocks()[4][1],p.getBlocks()[1]);
        assertEquals(l.getTable().getBlocks()[4][2],p.getBlocks()[2]);
        assertEquals(l.getTable().getBlocks()[4][3],p.getBlocks()[3]);
        assertNotEquals(l.getCurrent(),p);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
