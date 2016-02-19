package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.entities.Block;
import fi.ilmaripohjola.ipitris.entities.Table;
import java.awt.Color;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author omistaja
 */
public class RowManagerTest {

    private Table t;
    private RowManager r;
    private LevelManager l;

    public RowManagerTest() {
        r = new RowManager();
        t = new Table(25, 10);
        l = new LevelManager();
    }

    @Before
    public void setUp() {
    }

    @Test
    public void searchFullRowsReturnsEmptyListWithNothingToDestroy() {
        assertEquals(0, r.searchFullRows(l, t).size());
    }

    @Test
    public void searchFullRowsFindsCorrectRows() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < t.getWidth(); j++) {
                t.getBlocks()[j][i] = new Block(Color.BLACK, j, i);
            }
        }
        ArrayList<Integer> AL = r.searchFullRows(l, t);
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
        r.destroyRow(3, t);
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
        r.destroyRows(l, t);
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
        r.destroyRows(l, t);
        assertEquals(5, l.getPoints());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < t.getWidth(); j++) {
                t.getBlocks()[j][i] = new Block(Color.BLACK, j, i);
            }
        }
        r.destroyRows(l, t);
        assertEquals(8, l.getPoints());
        for (int i = 0; i < t.getWidth(); i++) {
            t.getBlocks()[i][0] = new Block(Color.BLACK, i, 0);
        }
        r.destroyRows(l, t);
        assertEquals(9, l.getPoints());
    }
}
