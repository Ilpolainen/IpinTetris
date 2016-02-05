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
public class PieceSquareTest {
    
    PieceSquare pieceSquare;
    
    public PieceSquareTest() {
    }        
    
    @Before
    public void setUp() {
        pieceSquare = new PieceSquare(Color.BLACK, 3, 4);
    }
    
    @Test
    public void constructorSetsPositionRight() {
        assertEquals("3,3", this.pieceSquare.getBlocks()[0].toString());
        assertEquals("4,3", this.pieceSquare.getBlocks()[1].toString());
        assertEquals("3,4", this.pieceSquare.getBlocks()[2].toString());
        assertEquals("4,4", this.pieceSquare.getBlocks()[3].toString());
    }
    
    @Test
    public void constructorSetsColorRight() {
        Color color = pieceSquare.getColor();
        String colorString = color.toString();
        assertEquals("java.awt.Color[r=0,g=0,b=0]", colorString);
    }
    
    @Test
    public void moveDownWorks() {
        pieceSquare.moveDown();
        assertEquals("3,4", this.pieceSquare.getBlocks()[0].toString());
        assertEquals("4,4", this.pieceSquare.getBlocks()[1].toString());
        assertEquals("3,5", this.pieceSquare.getBlocks()[2].toString());
        assertEquals("4,5", this.pieceSquare.getBlocks()[3].toString());
    }
    
    @Test
    public void moveUpWorks() {
        pieceSquare.moveUp();
        assertEquals("3,2", this.pieceSquare.getBlocks()[0].toString());
        assertEquals("4,2", this.pieceSquare.getBlocks()[1].toString());
        assertEquals("3,3", this.pieceSquare.getBlocks()[2].toString());
        assertEquals("4,3", this.pieceSquare.getBlocks()[3].toString());
    }
    
    @Test
    public void moveLeftWorks() {
        pieceSquare.moveLeft();
        assertEquals("2,3", this.pieceSquare.getBlocks()[0].toString());
        assertEquals("3,3", this.pieceSquare.getBlocks()[1].toString());
        assertEquals("2,4", this.pieceSquare.getBlocks()[2].toString());
        assertEquals("3,4", this.pieceSquare.getBlocks()[3].toString());
    }
    
    @Test
    public void moveRightWorks() {
        pieceSquare.moveRight();
        assertEquals("4,3", this.pieceSquare.getBlocks()[0].toString());
        assertEquals("5,3", this.pieceSquare.getBlocks()[1].toString());
        assertEquals("4,4", this.pieceSquare.getBlocks()[2].toString());
        assertEquals("5,4", this.pieceSquare.getBlocks()[3].toString());
    }
    
    @Test
    public void rotateLeftWorksOnce() {
        pieceSquare.rotateLeft();
        assertEquals("3,3", this.pieceSquare.getBlocks()[0].toString());
        assertEquals("4,3", this.pieceSquare.getBlocks()[1].toString());
        assertEquals("3,4", this.pieceSquare.getBlocks()[2].toString());
        assertEquals("4,4", this.pieceSquare.getBlocks()[3].toString());
    }
    
    @Test
    public void rotateRightWorksOnce() {
        pieceSquare.rotateRight();
        assertEquals("3,3", this.pieceSquare.getBlocks()[0].toString());
        assertEquals("4,3", this.pieceSquare.getBlocks()[1].toString());
        assertEquals("3,4", this.pieceSquare.getBlocks()[2].toString());
        assertEquals("4,4", this.pieceSquare.getBlocks()[3].toString());
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
