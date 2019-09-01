/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gamelogic.utilities;

import fi.ilmaripohjola.ipitris.application.logic.GameConfiguration;
import fi.ilmaripohjola.ipitris.gamelogic.PieceGenerator;
import fi.ilmaripohjola.ipitris.entities.Piece;
import java.awt.Color;
import org.junit.After;
import org.junit.Before;
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
        this.generator = new PieceGenerator(new GameConfiguration(10,25,30));
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
  
    @After
    public void tearDown() {
    }

}
