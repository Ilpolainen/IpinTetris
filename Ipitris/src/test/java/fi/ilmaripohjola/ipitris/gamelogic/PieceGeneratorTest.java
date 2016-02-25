/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.entities.Piece;
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
public class PieceGeneratorTest {
    
    private PieceGenerator generator;
    
    public PieceGeneratorTest() {
    }
    
    @Before
    public void setUp() {
        this.generator = new PieceGenerator(new Random(), 10);
    }
    
     @Test
    public void giveWorksAndHelpsCreateNewPieces() {
        for (int i = 0; i < 1000; i++) {
            generator.givePiece();
            assertEquals(Piece.class, generator.getNext().getClass().getSuperclass());
        }        
    }
    
    @Test
    public void makeNextWorks() {
        for (int i = 0; i < 1000; i++) {
            assertEquals(Piece.class, generator.makeNext().getClass().getSuperclass());
        }
    }
    
    @Test
    public void setColorsWorks() {
        generator.setColors(Color.red, Color.red, Color.red, Color.red, Color.red, Color.red, Color.red);
        Color[] colors = generator.getColors();
        for (int i = 0; i < colors.length; i++) {
            assertEquals(Color.red, colors[i]);
        }
    }
    
    @Test
    public void setColorWork() {
        generator.setColors(Color.red, Color.red, Color.red, Color.red, Color.red, Color.red, Color.red);
        generator.setColor(Color.yellow, 0);
        assertEquals(Color.yellow, generator.getColors()[0]);
    }
    
    @Test
    public void setTableWidthWorks() {
        generator.setTableWidth(6);
        assertEquals(6, this.generator.getTableWidth());
        assertNotEquals(5, generator.getNext().getX());
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
