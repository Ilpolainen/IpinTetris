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
public class CommandDownTest {

    private Logic tl;
    private Table t;
    private PieceGenerator g;
    private CommandDown c;
    private PieceI p;

    public CommandDownTest() {
    }

    @Before
    public void setUp() {
        this.t = new Table(10, 25);
        this.g = new PieceGenerator(new Random(), t.getWidth());
        this.tl = new Logic(t, g);
        this.c = new CommandDown(tl);
        this.p = new PieceI(Color.BLACK, 0, 1);
        tl.setCurrent(p);
    }

    @Test
    public void constructorSetsCorrectGameLogic() {
        assertEquals(tl, c.getTetris());
    }

    @Test
    public void runWorksNormally() {
        tl.setCurrent(p);
        p.setY(1);
        c.runCommand();
        assertEquals(2, p.getY());
    }

    @Test
    public void runCreatesNewCurrentIfCurrentPieceGoesOutOfBounds() {
        tl.setCurrent(p);
        System.out.println(tl.getCurrent());
        for (int i = 0; i < 30; i++) {
            c.runCommand();
        }
        System.out.println(tl.getCurrent());
        assertNotEquals(p, tl.getCurrent());
    }

    @Test
    public void runCausesACollosionEndsTheGameWhenNewPieceDoesNotFitInTheSreen() {
        for (int i = 0; i < 300; i++) {
            c.runCommand();
        }
        assertEquals(false, tl.getContinues());
    }

    @Test
    public void runCallsDestroyRows() {
        for (int i = 0; i < 10; i++) {
            t.getBlocks()[i][24] = new Block(Color.RED, i, 24);
        }
        t.getBlocks()[0][24] = null;
        tl.setCurrent(p);
        for (int i = 0; i < 24; i++) {
            c.runCommand();
        }
        assertEquals(1, tl.getLevelManager().getPoints());
    }
    
    @Test
    public void runCausesCollision() {
        for (int i = 0; i < 10; i++) {
            t.getBlocks()[i][8] = new Block(Color.red, 0, 6);
        }
        for (int i = 0; i < 8; i++) {
            c.runCommand();
        }
        assertNotEquals(p, tl.getCurrent());
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
