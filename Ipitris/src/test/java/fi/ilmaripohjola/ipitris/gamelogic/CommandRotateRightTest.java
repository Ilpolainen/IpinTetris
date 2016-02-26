/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gamelogic;

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
public class CommandRotateRightTest {
    
    public CommandRotateRightTest() {
    }
    
    private Logic tl;
    private Table t;
    private PieceGenerator g;
    private PieceI p;
    private CommandRotateRight rr;

    @Before
    public void setUp() {
        Random random = new Random();
        PieceGenerator generator = new PieceGenerator(random, 10);
        t = new Table(10, 20);
        tl = new Logic(t, generator);
        p = new PieceI(Color.BLACK, 4, 1);
        tl.setCurrent(p);
        rr = new CommandRotateRight(tl);       
    }
    
    @Test
    public void runWorksNormally() {
        rr.runCommand();
        assertEquals(2, p.getAsento());
    }
    
    @Test
    public void runDoesNotRotateWhenItIsImpossible() {
        tl.getCommands()[1].runCommand();
        tl.getCommands()[1].runCommand();
        tl.getCommands()[1].runCommand();
        tl.getCommands()[1].runCommand();
        tl.getCommands()[1].runCommand();        
        rr.runCommand();
        assertEquals(1, p.getAsento());
        for (int i = 0; i < 10; i++) {
            tl.getCommands()[2].runCommand();
        }
        rr.runCommand();
        assertEquals(1, p.getAsento());
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
