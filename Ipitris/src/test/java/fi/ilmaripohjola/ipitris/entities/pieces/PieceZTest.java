/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.entities.pieces;

import fi.ilmaripohjola.ipitris.entities.pieces.PieceZ;
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
public class PieceZTest {
    
    private PieceZ p;
    
    public PieceZTest() {
    }
    
    
    @Before
    public void setUp() {
        p = new PieceZ(Color.BLACK,1,1);
    }
    
    @Test
    public void constructorSetsPositionRight() {
        assertEquals("1,0", this.p.getBlocks()[0].toString());
        assertEquals("1,1", this.p.getBlocks()[1].toString());
        assertEquals("0,1", this.p.getBlocks()[2].toString());
        assertEquals("0,2", this.p.getBlocks()[3].toString());
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
        assertEquals("1,1", this.p.getBlocks()[0].toString());
        assertEquals("1,2", this.p.getBlocks()[1].toString());
        assertEquals("0,2", this.p.getBlocks()[2].toString());
        assertEquals("0,3", this.p.getBlocks()[3].toString());
    }
    
    @Test
    public void moveUpWorks() {
        p.moveUp();
        assertEquals("1,-1", this.p.getBlocks()[0].toString());
        assertEquals("1,0", this.p.getBlocks()[1].toString());
        assertEquals("0,0", this.p.getBlocks()[2].toString());
        assertEquals("0,1", this.p.getBlocks()[3].toString());
    }
    
    @Test
    public void moveLeftWorks() {
        p.moveLeft();
        assertEquals("0,0", this.p.getBlocks()[0].toString());
        assertEquals("0,1", this.p.getBlocks()[1].toString());
        assertEquals("-1,1", this.p.getBlocks()[2].toString());
        assertEquals("-1,2", this.p.getBlocks()[3].toString());
    }
    
    @Test
    public void moveRightWorks() {
        p.moveRight();
        assertEquals("2,0", this.p.getBlocks()[0].toString());
        assertEquals("2,1", this.p.getBlocks()[1].toString());
        assertEquals("1,1", this.p.getBlocks()[2].toString());
        assertEquals("1,2", this.p.getBlocks()[3].toString());
    }
    
    @Test
    public void rotateLeftWorksOnce() {
        p.rotateLeft();
        assertEquals("0,1", this.p.getBlocks()[0].toString());
        assertEquals("1,1", this.p.getBlocks()[1].toString());
        assertEquals("1,2", this.p.getBlocks()[2].toString());
        assertEquals("2,2", this.p.getBlocks()[3].toString());
    }
    
    @Test
    public void rotateLeftWorksTwice() {
        p.rotateLeft();
        p.rotateLeft();
        assertEquals("1,0", this.p.getBlocks()[0].toString());
        assertEquals("1,1", this.p.getBlocks()[1].toString());
        assertEquals("0,1", this.p.getBlocks()[2].toString());
        assertEquals("0,2", this.p.getBlocks()[3].toString());
    }
    
    @Test
    public void rotateRightWorksOnce() {
        p.rotateRight();
        assertEquals("0,1", this.p.getBlocks()[0].toString());
        assertEquals("1,1", this.p.getBlocks()[1].toString());
        assertEquals("1,2", this.p.getBlocks()[2].toString());
        assertEquals("2,2", this.p.getBlocks()[3].toString());
    }
    
    @Test
    public void rotateRightWorksTwice() {
        p.rotateRight();
        p.rotateRight();
        assertEquals("1,0", this.p.getBlocks()[0].toString());
        assertEquals("1,1", this.p.getBlocks()[1].toString());
        assertEquals("0,1", this.p.getBlocks()[2].toString());
        assertEquals("0,2", this.p.getBlocks()[3].toString());
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
