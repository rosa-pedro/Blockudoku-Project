/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Storm
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }


    /**
     * Test of getGameScore method, of class Game.
     */
    @Test
    public void testGetGameScore() {
        System.out.println("getGameScore");
        Game instance = new Game(GameMode.BASIC_MODE);
        int expResult = 0;
        int result = instance.getGameScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of isOver method, of class Game.
     */
    @Test
    public void testIsOver() {
        System.out.println("isOver");
        Game instance = new Game(GameMode.BASIC_MODE);
        boolean expResult = false;
        boolean result = instance.isOver();
        assertEquals(expResult, result);
    }

    /**
     * Test of isSaved method, of class Game.
     */
    @Test
    public void testIsSaved() {
        System.out.println("isSaved");
        Game instance = new Game(GameMode.BASIC_MODE);
        boolean expResult = false;
        boolean result = instance.isSaved();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Game.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Game instance = new Game(GameMode.BASIC_MODE);
        instance.setTime(LocalDateTime.now());
        String expResult = instance.getTime();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
