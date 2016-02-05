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
public class PieceLTest {
    
   PieceL pieceL;
    
    public PieceLTest() {
    }
    
   
    
    @Before
    public void setUp() {
        this.pieceL = new  PieceL(Color.BLACK, 2, 2);
    }
    
    @Test
    public void constructorSetsPositionRight() {
        assertEquals("2,1", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("2,3", this.pieceL.getBlocks()[2].toString());
        assertEquals("3,3", this.pieceL.getBlocks()[3].toString());
    }
    
    @Test
    public void constructorSetsColorRight() {
        Color color = pieceL.getColor();
        String colorString = color.toString();
        assertEquals("java.awt.Color[r=0,g=0,b=0]", colorString);
    }

    

    @Test
    public void moveDownWorks() {
        pieceL.moveDown();
        assertEquals("2,2", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,3", this.pieceL.getBlocks()[1].toString());
        assertEquals("2,4", this.pieceL.getBlocks()[2].toString());
        assertEquals("3,4", this.pieceL.getBlocks()[3].toString());
    }

    @Test
    public void moveUpWorks() {
        pieceL.moveUp();
        assertEquals("2,0", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,1", this.pieceL.getBlocks()[1].toString());
        assertEquals("2,2", this.pieceL.getBlocks()[2].toString());
        assertEquals("3,2", this.pieceL.getBlocks()[3].toString());
    }

    @Test
    public void moveLeftWorks() {
        pieceL.moveLeft();
        assertEquals("1,1", this.pieceL.getBlocks()[0].toString());
        assertEquals("1,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("1,3", this.pieceL.getBlocks()[2].toString());
        assertEquals("2,3", this.pieceL.getBlocks()[3].toString());
    }

    @Test
    public void moveRightWorks() {
        pieceL.moveRight();
        assertEquals("3,1", this.pieceL.getBlocks()[0].toString());
        assertEquals("3,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("3,3", this.pieceL.getBlocks()[2].toString());
        assertEquals("4,3", this.pieceL.getBlocks()[3].toString());
    }

    @Test
    public void rotateRight1Works() {
        pieceL.rotateRight1();
        assertEquals("3,2", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("1,2", this.pieceL.getBlocks()[2].toString());
        assertEquals("1,3", this.pieceL.getBlocks()[3].toString());
    }

    @Test
    public void rotateRight2Works() {
        pieceL.rotateRight1();
        pieceL.rotateRight2();
        assertEquals("2,3", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("2,1", this.pieceL.getBlocks()[2].toString());
        assertEquals("1,1", this.pieceL.getBlocks()[3].toString());
    }

    @Test
    public void rotateRight3Works() {
        pieceL.rotateRight1();
        pieceL.rotateRight2();
        pieceL.rotateRight3();
        assertEquals("1,2", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("3,2", this.pieceL.getBlocks()[2].toString());
        assertEquals("3,1", this.pieceL.getBlocks()[3].toString());
    }

    @Test
    public void rotateRight4Works() {
        pieceL.rotateRight1();
        pieceL.rotateRight2();
        pieceL.rotateRight3();
        pieceL.rotateRight4();
        assertEquals("2,1", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("2,3", this.pieceL.getBlocks()[2].toString());
        assertEquals("3,3", this.pieceL.getBlocks()[3].toString());
    }

    @Test
    public void rotateRightWorks() {
        pieceL.rotateRight();
        assertEquals("3,2", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("1,2", this.pieceL.getBlocks()[2].toString());
        assertEquals("1,3", this.pieceL.getBlocks()[3].toString());
        pieceL.rotateRight();
        assertEquals("2,3", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("2,1", this.pieceL.getBlocks()[2].toString());
        assertEquals("1,1", this.pieceL.getBlocks()[3].toString());
        pieceL.rotateRight();
        assertEquals("1,2", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("3,2", this.pieceL.getBlocks()[2].toString());
        assertEquals("3,1", this.pieceL.getBlocks()[3].toString());
        pieceL.rotateRight();
        assertEquals("2,1", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("2,3", this.pieceL.getBlocks()[2].toString());
        assertEquals("3,3", this.pieceL.getBlocks()[3].toString());
    }

    @Test
    public void rotateLeft1Works() {
        pieceL.rotateLeft1();
        assertEquals("1,2", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("3,2", this.pieceL.getBlocks()[2].toString());
        assertEquals("3,1", this.pieceL.getBlocks()[3].toString());

    }

    @Test
    public void rotateLeft2Works() {
        pieceL.rotateLeft1();
        pieceL.rotateLeft4();
        assertEquals("2,3", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("2,1", this.pieceL.getBlocks()[2].toString());
        assertEquals("1,1", this.pieceL.getBlocks()[3].toString());
    }

    @Test
    public void rotateLeft3Works() {
        pieceL.rotateLeft1();
        pieceL.rotateLeft4();
        pieceL.rotateLeft3();
        assertEquals("3,2", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("1,2", this.pieceL.getBlocks()[2].toString());
        assertEquals("1,3", this.pieceL.getBlocks()[3].toString());
    }

    @Test
    public void rotateLeft4Works() {
        pieceL.rotateLeft1();
        pieceL.rotateLeft4();
        pieceL.rotateLeft3();
        pieceL.rotateLeft2();
        assertEquals("2,1", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("2,3", this.pieceL.getBlocks()[2].toString());
        assertEquals("3,3", this.pieceL.getBlocks()[3].toString());
    }

    public void rotateLeftWorks() {
        pieceL.rotateLeft();
        assertEquals("1,2", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("3,2", this.pieceL.getBlocks()[2].toString());
        assertEquals("3,1", this.pieceL.getBlocks()[3].toString());
        pieceL.rotateLeft();
        assertEquals("2,3", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("2,1", this.pieceL.getBlocks()[2].toString());
        assertEquals("1,1", this.pieceL.getBlocks()[3].toString());
        pieceL.rotateLeft();
        assertEquals("3,2", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("1,2", this.pieceL.getBlocks()[2].toString());
        assertEquals("1,3", this.pieceL.getBlocks()[3].toString());
        pieceL.rotateLeft();
        assertEquals("2,1", this.pieceL.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceL.getBlocks()[1].toString());
        assertEquals("2,3", this.pieceL.getBlocks()[2].toString());
        assertEquals("3,3", this.pieceL.getBlocks()[3].toString());
    }


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
