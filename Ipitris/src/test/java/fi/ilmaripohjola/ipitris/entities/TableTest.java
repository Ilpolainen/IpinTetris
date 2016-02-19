/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.entities;

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
public class TableTest {
    
    Table table;
    Table wrong;
    Table negat;
    
    public TableTest() {
    }
    
    
    @Before
    public void setUp() {
        table = new Table(10, 20);
        wrong = new Table(2,2);
        negat = new Table(-2,-6);
    }
    
    @Test
    public void constructorSetsNormalHeightWidth() {
        assertEquals(10, table.getWidth());
    }
    
    @Test
    public void constructorSetsNormalHeightRight() {
        assertEquals(20, table.getHeight());
    }
    
    @Test
    public void constructorSetsWrongHeightRight() {        
        assertEquals(4, wrong.getHeight());
    }
    
    @Test
    public void constructorSetsWrongWidthRight() {        
        assertEquals(3, wrong.getWidth());
    }
    
    @Test
    public void constructorSetsNegativeHeightRight() {        
        assertEquals(4, negat.getHeight());
    }
    
    @Test
    public void constructorSetsNegativeWidthRight() {        
        assertEquals(3, negat.getWidth());
    }
    
    @Test
    public void constructorSetsArraySizeRight() {
        assertEquals(10, table.getBlocks().length);
        assertEquals(3, wrong.getBlocks().length);
        assertEquals(3, negat.getBlocks().length);        
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
