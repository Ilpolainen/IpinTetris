/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.entities.Block;
import fi.ilmaripohjola.ipitris.entities.PieceI;
import fi.ilmaripohjola.ipitris.entities.Table;
import java.awt.Color;
import java.util.Random;
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
public class CommandLeftTest {

    Table t;
    Logic l;
    PieceI p;

    public CommandLeftTest() {
    }

    @Before
    public void setUp() {
        Random random = new Random();
        PieceGenerator generator = new PieceGenerator(random, 10);
        t = new Table(10, 20);
        l = new Logic(t, generator);
        p = new PieceI(Color.BLACK, 1, 1);
        l.setCurrent(p);
    }

    @Test
    public void moveLeftWorksNormally() {
        l.getCommands()[1].runCommand();
        for (int i = 0; i < 1; i++) {
            assertEquals(0, p.getBlocks()[i].getX());            
            assertEquals(0, p.getBlocks()[0].getY());
            assertEquals(1, p.getBlocks()[1].getY());
            assertEquals(2, p.getBlocks()[2].getY());
            assertEquals(3, p.getBlocks()[3].getY());
        }
    }
    
    @Test
    public void moveLeftDontExceedTableLimits() {
        l.getCommands()[1].runCommand();
        l.getCommands()[1].runCommand();
        for (int i = 0; i < 4; i++) {
            assertEquals(0, p.getBlocks()[i].getX());            
            assertEquals(0, p.getBlocks()[0].getY());
            assertEquals(1, p.getBlocks()[1].getY());
            assertEquals(2, p.getBlocks()[2].getY());
            assertEquals(3, p.getBlocks()[3].getY());
        }
    }
    
    @Test
    public void moveLeftDontCrossOtherBlocks() {
        t.getBlocks()[0][0]=new Block(Color.BLACK,0,0);
        l.getCommands()[1].runCommand();
        for (int i = 0; i < 4; i++) {
            assertEquals(1, p.getBlocks()[i].getX());            
            assertEquals(0, p.getBlocks()[0].getY());
            assertEquals(1, p.getBlocks()[1].getY());
            assertEquals(2, p.getBlocks()[2].getY());
            assertEquals(3, p.getBlocks()[3].getY());
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
