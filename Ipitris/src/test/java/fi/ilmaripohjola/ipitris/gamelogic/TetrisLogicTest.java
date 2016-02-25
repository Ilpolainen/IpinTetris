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
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author omistaja
 */
public class TetrisLogicTest {
    
    Table t;
    TetrisLogic l;
    Piece p;
    Command c;
    
    public TetrisLogicTest() {
    }    
    
    @Before
    public void setUp() {
        t = new Table(10,20);
        Random random = new Random();
        PieceGenerator generator = new PieceGenerator(random, 10);
        l = new TetrisLogic(t, generator);
        p = new PieceI(Color.BLACK,4,1);
        c = new CommandRotateLeft(l);
        l.setCurrent(p);
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
        assertEquals(0, l.getLevelManager().getRowsDestroyed());
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
    public void costructorCreatesGeneratorRowManagerLevelManageAndLimitGuard() {
        assertNotEquals(null, l.getLimitGuard());
        assertNotEquals(null, l.getLevelManager());
        assertNotEquals(null, l.getRowManager());        
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
    
    @Test
    public void levelUpWorks() {
        l.getLevelManager().levelUp();
        assertEquals(1, l.getLevel());
    }
    
    @Test
    public void levelStopsAt20() {
        for (int i = 0; i < 30; i++) {
            l.getLevelManager().levelUp();
        }
        assertEquals(20, l.getLevel());
    }
    
    @Test
    public void resetDoesAllThatItNeedsToDo () {
        l.getCommands()[0].runCommand();
        l.getCommands()[0].runCommand();
        l.getCommands()[0].runCommand();
        l.getCommands()[0].runCommand();
        l.getCommands()[3].runCommand();
        for (int i = 0; i < 10; i++) {
            l.getCommands()[0].runCommand();
        }
        for (int i = 0; i < 30; i++) {
            l.getLevelManager().increasePoints(5);
        }
        l.restart();
        assertEquals(0, l.getPoints());
        assertEquals(0, l.getLevel());
        assertEquals(0, l.getLevelManager().getRowsDestroyed());
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                assertEquals(null, t.getBlocks()[i][j]);
            }
        }
    }
    
    @Test
    public void updateCallsRightControls() {
        l.update(false, true, false, false);
        assertEquals(1, l.getCurrent().getAsento());
        assertEquals(1, l.getCurrent().getY());
        assertEquals(3, l.getCurrent().getX());
        l.update(true, false, true, true);
        assertEquals(2, l.getCurrent().getAsento());
        assertEquals(2, l.getCurrent().getY());
        assertEquals(4, l.getCurrent().getX());
    }
    
    @Test
    public void setTableWorksRight() {
        this.l.setTable(4, 5);
        assertEquals(4, t.getWidth());
        assertEquals(5, t.getHeight());
    }
    
    @Test
    public void setTableWorksWithNegativeInput() {
        this.l.setTable(-1, -3);
        assertEquals(3, t.getWidth());
        assertEquals(4, t.getHeight());
    }
}
