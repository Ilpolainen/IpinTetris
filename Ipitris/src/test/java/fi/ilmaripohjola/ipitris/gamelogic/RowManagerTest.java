package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.application.logic.GameConfiguration;
import fi.ilmaripohjola.ipitris.gamelogic.utilities.RowManager;
import fi.ilmaripohjola.ipitris.entities.Block;
import fi.ilmaripohjola.ipitris.entities.GameTable;
import fi.ilmaripohjola.ipitris.gamelogic.utilities.PieceGenerator;
import java.awt.Color;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.testng.Assert.assertNotEquals;

/**
 *
 * @author omistaja
 */
public class RowManagerTest {

    private final GameTable t;
    private final LevelProgress l;
    private final GameState gameState;
    
    public RowManagerTest() {;
        t = new GameTable(25, 10);
        gameState = new GameState(t,new PieceGenerator(new GameConfiguration(25,10,30)));
        l = gameState.getLevelProgress();
    }

    @Before
    public void setUp() {
        gameState.reset(25,10);
    }

    @Test
    public void searchFullRowsReturnsEmptyListWithNothingToDestroy() {
        assertEquals(0, RowManager.searchFullRows(l, t).size());
    }

    @Test
    public void searchFullRowsFindsCorrectRows() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < t.getWidth(); j++) {
                t.getBlocks()[j][i] = new Block(Color.BLACK, j, i);
            }
        }
        ArrayList<Integer> AL = RowManager.searchFullRows(l, t);
        for (int i = 0; i < 4; i++) {
            assertEquals((Integer) i, AL.get(i));
        }
    }

    @Test
    public void destroyRowWorks() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < t.getWidth(); j++) {
                t.getBlocks()[j][i] = new Block(Color.BLACK, j, i);
            }
        }
        RowManager.destroyRow(3, t);
        for (int i = 0; i < t.getWidth(); i++) {
            assertEquals(t.getBlocks()[i][0], null);
        }
        for (int i = 0; i < t.getWidth(); i++) {
            for (int j = 1; j < 4; j++) {
                assertNotEquals(t.getBlocks()[i][j], null);
            }

        }
    }

    @Test
    public void destroyRowsWorks() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < t.getWidth(); j++) {
                t.getBlocks()[j][i] = new Block(Color.BLACK, j, i);
            }
        }
        RowManager.destroyRows(gameState);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < t.getWidth(); j++) {
                assertEquals(t.getBlocks()[j][i], null);
            }
        }
        assertEquals(8, l.getPoints());
    }

    @Test
    public void pointsCountingMatches() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < t.getWidth(); j++) {
                t.getBlocks()[j][i] = new Block(Color.BLACK, j, i);
            }
        }
        RowManager.destroyRows(gameState);
        assertEquals(5, l.getPoints());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < t.getWidth(); j++) {
                t.getBlocks()[j][i] = new Block(Color.BLACK, j, i);
            }
        }
        RowManager.destroyRows(gameState);
        assertEquals(8, l.getPoints());
        for (int i = 0; i < t.getWidth(); i++) {
            t.getBlocks()[i][0] = new Block(Color.BLACK, i, 0);
        }
        RowManager.destroyRows(gameState);
        assertEquals(9, l.getPoints());
    }
}
