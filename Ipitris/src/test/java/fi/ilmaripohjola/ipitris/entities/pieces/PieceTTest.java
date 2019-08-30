/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.entities.pieces;

import fi.ilmaripohjola.ipitris.entities.pieces.PieceT;
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
public class PieceTTest {
    
    PieceT p;
    
    public PieceTTest() {
    }
    
    
    @Before
    public void setUp() {
        p = new PieceT(Color.BLACK,1,1);
    }
    
    @Test
    public void constructorSetsPositionRight() {
        assertEquals("0,1", this.p.getBlocks()[0].toString());
        assertEquals("1,1", this.p.getBlocks()[1].toString());
        assertEquals("1,2", this.p.getBlocks()[2].toString());
        assertEquals("2,1", this.p.getBlocks()[3].toString());
    }
    
    @Test
    public void constructorSetsColorRight() {
        Color color = p.getColor();
        String colorString = color.toString();
        assertEquals("java.awt.Color[r=0,g=0,b=0]", colorString);
    }
    
    @Test
    public void moveDownWorks() {
        p.moveDown();
        assertEquals("0,2", this.p.getBlocks()[0].toString());
        assertEquals("1,2", this.p.getBlocks()[1].toString());
        assertEquals("1,3", this.p.getBlocks()[2].toString());
        assertEquals("2,2", this.p.getBlocks()[3].toString());
    }
    
    @Test
    public void moveUpWorks() {
        p.moveUp();
        assertEquals("0,0", this.p.getBlocks()[0].toString());
        assertEquals("1,0", this.p.getBlocks()[1].toString());
        assertEquals("1,1", this.p.getBlocks()[2].toString());
        assertEquals("2,0", this.p.getBlocks()[3].toString());
    }
    
    @Test
    public void moveLeftWorks() {
        p.moveLeft();
        assertEquals("-1,1", this.p.getBlocks()[0].toString());
        assertEquals("0,1", this.p.getBlocks()[1].toString());
        assertEquals("0,2", this.p.getBlocks()[2].toString());
        assertEquals("1,1", this.p.getBlocks()[3].toString());
    }
    
    @Test
    public void moveRightWorks() {
        p.moveRight();
        assertEquals("1,1", this.p.getBlocks()[0].toString());
        assertEquals("2,1", this.p.getBlocks()[1].toString());
        assertEquals("2,2", this.p.getBlocks()[2].toString());
        assertEquals("3,1", this.p.getBlocks()[3].toString());
    }
    
    @Test
    public void rotateLeftWorksOnce() {
        p.rotateLeft();
        assertEquals("1,2", this.p.getBlocks()[0].toString());
        assertEquals("1,1", this.p.getBlocks()[1].toString());
        assertEquals("2,1", this.p.getBlocks()[2].toString());
        assertEquals("1,0", this.p.getBlocks()[3].toString());
    }
    
    @Test
    public void rotateLeftWorksTwice() {
        p.rotateLeft();
        p.rotateLeft();
        assertEquals("2,1", this.p.getBlocks()[0].toString());
        assertEquals("1,1", this.p.getBlocks()[1].toString());
        assertEquals("1,0", this.p.getBlocks()[2].toString());
        assertEquals("0,1", this.p.getBlocks()[3].toString());
    }
    
    @Test
    public void rotateLeftWorksThreeTimes() {
        p.rotateLeft();
        p.rotateLeft();
        p.rotateLeft();
        assertEquals("1,0", this.p.getBlocks()[0].toString());
        assertEquals("1,1", this.p.getBlocks()[1].toString());
        assertEquals("0,1", this.p.getBlocks()[2].toString());
        assertEquals("1,2", this.p.getBlocks()[3].toString());
    }
    
    @Test
    public void rotateLeftWorksFourTimes() {
        p.rotateLeft();
        p.rotateLeft();
        p.rotateLeft();
        p.rotateLeft();
        assertEquals("0,1", this.p.getBlocks()[0].toString());
        assertEquals("1,1", this.p.getBlocks()[1].toString());
        assertEquals("1,2", this.p.getBlocks()[2].toString());
        assertEquals("2,1", this.p.getBlocks()[3].toString());
    }
    
    @Test
    public void rotateRightWorksOnce() {
        p.rotateRight();
        assertEquals("1,0", this.p.getBlocks()[0].toString());
        assertEquals("1,1", this.p.getBlocks()[1].toString());
        assertEquals("0,1", this.p.getBlocks()[2].toString());
        assertEquals("1,2", this.p.getBlocks()[3].toString());
    }
    
    @Test
    public void rotateRightWorksTwice() {
        p.rotateRight();
        p.rotateRight();
        assertEquals("2,1", this.p.getBlocks()[0].toString());
        assertEquals("1,1", this.p.getBlocks()[1].toString());
        assertEquals("1,0", this.p.getBlocks()[2].toString());
        assertEquals("0,1", this.p.getBlocks()[3].toString());
    }
    
     @Test
    public void rotateRightWorksThreeTimes() {
        p.rotateRight();
        p.rotateRight();
        p.rotateRight();
        assertEquals("1,2", this.p.getBlocks()[0].toString());
        assertEquals("1,1", this.p.getBlocks()[1].toString());
        assertEquals("2,1", this.p.getBlocks()[2].toString());
        assertEquals("1,0", this.p.getBlocks()[3].toString());
    }
    
     @Test
    public void rotateRightWorksFourTimes() {
        p.rotateRight();
        p.rotateRight();
        p.rotateRight();
        p.rotateRight();
        assertEquals("0,1", this.p.getBlocks()[0].toString());
        assertEquals("1,1", this.p.getBlocks()[1].toString());
        assertEquals("1,2", this.p.getBlocks()[2].toString());
        assertEquals("2,1", this.p.getBlocks()[3].toString());
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
