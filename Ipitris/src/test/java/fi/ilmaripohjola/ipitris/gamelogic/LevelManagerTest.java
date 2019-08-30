/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gamelogic;

import fi.ilmaripohjola.ipitris.gamelogic.LevelProgress;
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
public class LevelManagerTest {

    private LevelProgress lm;

    public LevelManagerTest() {
    }

    @Before
    public void setUp() {
        lm = new LevelProgress();
    }

    @Test
    public void constructorSetsPointsRight() {
        assertEquals(0, lm.getPoints());
    }

    @Test
    public void constructorSetsLevelRight() {
        assertEquals(0, lm.getLevel());
    }

    @Test
    public void constructorSetsRowsDestroyedRight() {
        assertEquals(0, lm.getRowsDestroyed());
    }

    @Test
    public void levellingUpNormallyOnce() {
        lm.levelUp();
        assertEquals(1, lm.getLevel());
    }

    @Test
    public void levellingUpNormallyManyTimes() {
        lm.levelUp();
        lm.levelUp();
        lm.levelUp();
        assertEquals(3, lm.getLevel());
    }

    @Test
    public void levellingUpDoesNotGoOverTwenty() {
        for (int i = 0; i < 30; i++) {
            lm.levelUp();
        }
        assertEquals(20, lm.getLevel());
    }

    @Test
    public void increasePointsWorksWithCorrectInputOnce() {
        lm.increasePoints(7);
        assertEquals(7, lm.getPoints());
    }

    @Test
    public void increasePointsWorksWithCorrectInputManyTimes() {
        lm.increasePoints(7);
        lm.increasePoints(9);
        lm.increasePoints(19);
        assertEquals(35, lm.getPoints());
    }

    @Test
    public void increasePointsNeglectsNegativeInput() {
        lm.increasePoints(-3);
        assertEquals(0, lm.getPoints());
    }

    @Test
    public void increaseRowsDestroyedWorksOnce() {
        lm.increaseRowsDestroyed();
        assertEquals(1, lm.getRowsDestroyed());
    }

    @Test
    public void increaseRowsDestroyedWorksManyTimes() {
        lm.increaseRowsDestroyed();
        lm.increaseRowsDestroyed();
        lm.increaseRowsDestroyed();
        lm.increaseRowsDestroyed();
        assertEquals(4, lm.getRowsDestroyed());
    }

    @Test
    public void increaseRowsDestroyeUpdatesLevel() {
        for (int i = 0; i < 11; i++) {
            lm.increaseRowsDestroyed();
        }
        assertEquals(0, lm.getLevel());
        lm.increaseRowsDestroyed();
        assertEquals(1, lm.getLevel());
        for (int i = 0; i < 14; i++) {
            lm.increaseRowsDestroyed();
        }
        assertEquals(2, lm.getLevel());
    }
}
