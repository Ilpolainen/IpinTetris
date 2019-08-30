/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.entities.pieces;

import fi.ilmaripohjola.ipitris.entities.pieces.PieceI;
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
public class PieceITest {
    
    PieceI pieceI;
    
    public PieceITest() {
    }        
    
    @Before
    public void setUp() {
        pieceI = new PieceI(Color.BLACK, 3, 4);
    }
    
    @Test
    public void constructorSetsPositionRight() {
        for (int i = 0; i < 4; i++) {
            assertEquals("3," + (i+3), this.pieceI.getBlocks()[i].toString());
        }
    }
    
    @Test
    public void constructorSetsColorRight() {
        Color color = pieceI.getColor();
        String colorString = color.toString();
        assertEquals("java.awt.Color[r=0,g=0,b=0]", colorString);
    }
    
    @Test
    public void moveDownWorks() {
        pieceI.moveDown();
        for (int i = 0; i < 4; i++) {
            assertEquals("3," + (i + 4), this.pieceI.getBlocks()[i].toString());
        }
    }
    
    @Test
    public void moveUpWorks() {
        pieceI.moveUp();
        for (int i = 0; i < 4; i++) {
            assertEquals("3," + (i + 2), this.pieceI.getBlocks()[i].toString());
        }
    }
    
    @Test
    public void moveLeftWorks() {
        pieceI.moveLeft();
        for (int i = 0; i < 4; i++) {
            assertEquals("2," + (i+3), this.pieceI.getBlocks()[i].toString());
        }
    }
    
    @Test
    public void moveRightWorks() {
        pieceI.moveRight();
        for (int i = 0; i < 4; i++) {
            assertEquals("4," + (i+3), this.pieceI.getBlocks()[i].toString());
        }
    }
    
    @Test
    public void rotateLeftWorksOnce() {
        pieceI.rotateLeft();
        for (int i = 0; i < 4; i++) {
            assertEquals((i + 2) + ",4", this.pieceI.getBlocks()[i].toString());
        }
    }
    
    @Test
    public void rotateRightWorksOnce() {
        pieceI.rotateRight();
        for (int i = 0; i < 4; i++) {
            assertEquals((i + 2) + ",4", this.pieceI.getBlocks()[i].toString());
        }
    }
        
    @Test
    public void rotateLeftWorksTwice() {
        pieceI.rotateLeft();
        pieceI.rotateLeft();
        for (int i = 0; i < 4; i++) {
            assertEquals("3," + (i+3), this.pieceI.getBlocks()[i].toString());
        }
    }
    
    @Test
    public void rotateRightWorksTwice() {
        pieceI.rotateRight();
        pieceI.rotateRight();
        for (int i = 0; i < 4; i++) {
            assertEquals("3," + (i+3), this.pieceI.getBlocks()[i].toString());
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
