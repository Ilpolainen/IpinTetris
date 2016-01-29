/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.entities;

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
public class BlockTest {
    
    Block b = new Block(Color.BLACK,1,1);
    
    public BlockTest() {
    }
        
    @Before
    public void setUp() {
        
    }
    
    @Test
    public void constructorSetsCoordinatesRight() {
        assertEquals("1,1", b.getX() + "," + b.getY());
    }
    
    @Test
    public void constructorSetsColorRight() {
        Color color = b.getColor();
        String colorString = color.toString();
        assertEquals("java.awt.Color[r=0,g=0,b=0]", colorString);
    }
    
    @Test
    public void moveDownWorks() {
        b.moveDown();
        assertEquals("1,2", b.getX() + "," + b.getY());
    }
    
    @Test
    public void moveUpWorks() {
        b.moveUp();
        assertEquals("1,0", b.getX() + "," + b.getY());
    }
    
    @Test
    public void moveLeftWorks() {
        b.moveLeft();
        assertEquals("0,1", b.getX() + "," + b.getY());
    }
    
    @Test
    public void moveRightWorks() {
        b.moveRight();
        assertEquals("2,1", b.getX() + "," + b.getY());
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
