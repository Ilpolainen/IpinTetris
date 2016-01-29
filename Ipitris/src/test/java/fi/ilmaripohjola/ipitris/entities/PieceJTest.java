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
public class PieceJTest {

    PieceJ pieceJ;

    public PieceJTest() {
    }

    @Before
    public void setUp() {
        pieceJ = new PieceJ(Color.BLACK, 2, 2);
    }

    @Test
    public void constructorSetsColorRight() {
        Color color = pieceJ.getColor();
        String colorString = color.toString();
        assertEquals("java.awt.Color[r=0,g=0,b=0]", colorString);
    }

    @Test
    public void constructorSetsPositionRight() {
        assertEquals("2,1", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("2,3", this.pieceJ.getBlocks()[2].toString());
        assertEquals("1,3", this.pieceJ.getBlocks()[3].toString());
    }

    @Test
    public void moveDownWorks() {
        pieceJ.moveDown();
        assertEquals("2,2", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,3", this.pieceJ.getBlocks()[1].toString());
        assertEquals("2,4", this.pieceJ.getBlocks()[2].toString());
        assertEquals("1,4", this.pieceJ.getBlocks()[3].toString());
    }

    @Test
    public void moveUpWorks() {
        pieceJ.moveUp();
        assertEquals("2,0", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,1", this.pieceJ.getBlocks()[1].toString());
        assertEquals("2,2", this.pieceJ.getBlocks()[2].toString());
        assertEquals("1,2", this.pieceJ.getBlocks()[3].toString());
    }

    @Test
    public void moveLeftWorks() {
        pieceJ.moveLeft();
        assertEquals("1,1", this.pieceJ.getBlocks()[0].toString());
        assertEquals("1,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("1,3", this.pieceJ.getBlocks()[2].toString());
        assertEquals("0,3", this.pieceJ.getBlocks()[3].toString());
    }

    @Test
    public void moveRightWorks() {
        pieceJ.moveRight();
        assertEquals("3,1", this.pieceJ.getBlocks()[0].toString());
        assertEquals("3,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("3,3", this.pieceJ.getBlocks()[2].toString());
        assertEquals("2,3", this.pieceJ.getBlocks()[3].toString());
    }

    @Test
    public void rotateRight1Works() {
        pieceJ.rotateRight1();
        assertEquals("3,2", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("1,2", this.pieceJ.getBlocks()[2].toString());
        assertEquals("1,1", this.pieceJ.getBlocks()[3].toString());
    }

    @Test
    public void rotateRight2Works() {
        pieceJ.rotateRight1();
        pieceJ.rotateRight2();
        assertEquals("2,3", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("2,1", this.pieceJ.getBlocks()[2].toString());
        assertEquals("3,1", this.pieceJ.getBlocks()[3].toString());
    }

    @Test
    public void rotateRight3Works() {
        pieceJ.rotateRight1();
        pieceJ.rotateRight2();
        pieceJ.rotateRight3();
        assertEquals("1,2", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("3,2", this.pieceJ.getBlocks()[2].toString());
        assertEquals("3,3", this.pieceJ.getBlocks()[3].toString());
    }

    @Test
    public void rotateRight4Works() {
        pieceJ.rotateRight1();
        pieceJ.rotateRight2();
        pieceJ.rotateRight3();
        pieceJ.rotateRight4();
        assertEquals("2,1", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("2,3", this.pieceJ.getBlocks()[2].toString());
        assertEquals("1,3", this.pieceJ.getBlocks()[3].toString());
    }

    @Test
    public void rotateRightWorks() {
        pieceJ.rotateRight();
        assertEquals("3,2", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("1,2", this.pieceJ.getBlocks()[2].toString());
        assertEquals("1,1", this.pieceJ.getBlocks()[3].toString());
        pieceJ.rotateRight();
        assertEquals("2,3", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("2,1", this.pieceJ.getBlocks()[2].toString());
        assertEquals("3,1", this.pieceJ.getBlocks()[3].toString());
        pieceJ.rotateRight();
        assertEquals("1,2", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("3,2", this.pieceJ.getBlocks()[2].toString());
        assertEquals("3,3", this.pieceJ.getBlocks()[3].toString());
        pieceJ.rotateRight();
        assertEquals("2,1", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("2,3", this.pieceJ.getBlocks()[2].toString());
        assertEquals("1,3", this.pieceJ.getBlocks()[3].toString());
    }

    @Test
    public void rotateLeft1Works() {
        pieceJ.rotateLeft1();
        assertEquals("1,2", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("3,2", this.pieceJ.getBlocks()[2].toString());
        assertEquals("3,3", this.pieceJ.getBlocks()[3].toString());

    }

    @Test
    public void rotateLeft2Works() {
        pieceJ.rotateLeft1();
        pieceJ.rotateLeft2();
        assertEquals("2,3", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("2,1", this.pieceJ.getBlocks()[2].toString());
        assertEquals("3,1", this.pieceJ.getBlocks()[3].toString());
    }

    @Test
    public void rotateLeft3Works() {
        pieceJ.rotateLeft1();
        pieceJ.rotateLeft2();
        pieceJ.rotateLeft3();
        assertEquals("3,2", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("1,2", this.pieceJ.getBlocks()[2].toString());
        assertEquals("1,1", this.pieceJ.getBlocks()[3].toString());
    }

    @Test
    public void rotateLeft4Works() {
        pieceJ.rotateLeft1();
        pieceJ.rotateLeft2();
        pieceJ.rotateLeft3();
        pieceJ.rotateLeft4();
        assertEquals("2,1", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("2,3", this.pieceJ.getBlocks()[2].toString());
        assertEquals("1,3", this.pieceJ.getBlocks()[3].toString());
    }

    public void rotateLeftWorks() {
        pieceJ.rotateLeft();
        assertEquals("1,2", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("3,2", this.pieceJ.getBlocks()[2].toString());
        assertEquals("3,3", this.pieceJ.getBlocks()[3].toString());
        pieceJ.rotateLeft();
        assertEquals("2,3", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("2,1", this.pieceJ.getBlocks()[2].toString());
        assertEquals("3,1", this.pieceJ.getBlocks()[3].toString());
        pieceJ.rotateLeft();
        assertEquals("3,2", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("1,2", this.pieceJ.getBlocks()[2].toString());
        assertEquals("1,1", this.pieceJ.getBlocks()[3].toString());
        pieceJ.rotateLeft();
        assertEquals("2,1", this.pieceJ.getBlocks()[0].toString());
        assertEquals("2,2", this.pieceJ.getBlocks()[1].toString());
        assertEquals("2,3", this.pieceJ.getBlocks()[2].toString());
        assertEquals("1,3", this.pieceJ.getBlocks()[3].toString());
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
