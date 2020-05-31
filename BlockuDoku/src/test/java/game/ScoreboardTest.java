/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Storm
 */
public class ScoreboardTest {
    
    public ScoreboardTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of insertScore method, of class Scoreboard.
     */
    @Test
    public void testInsertScore() {
        System.out.println("insertScore");
        Object element = null;
        int score = 0;
        Scoreboard instance = new Scoreboard();
        instance.insertScore(element, score);
    }

    /**
     * Test of getHighestScore method, of class Scoreboard.
     */
    @Test
    public void testGetHighestScore() {
        System.out.println("getHighestScore");
        
        Scoreboard instance = new Scoreboard();
        //System.out.println(instance);
        
        User user = new User("Julia");
        Score<User> instance1 = new Score<>(user,528);
        /*
        User user2 = new User("Julia");
        Score<User> instance2 = new Score<>(user2,545);
        
        instance.insertScore(user, 528);*/
        instance.insertScore(user, 545);
        Score result = instance.getHighestScore();
        assertEquals(545, result.getValue());
    }

    /**
     * Test of getScoreboard method, of class Scoreboard.
     */
    @Test
    public void testGetScoreboard() {
        System.out.println("getScoreboard");
        Scoreboard instance = new Scoreboard();
        ArrayList<Score<User>> expResult = instance.scoreboard;
        ArrayList<Score<User>> result = instance.getScoreboard();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class Scoreboard.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Scoreboard instance = new Scoreboard();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of clear method, of class Scoreboard.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Scoreboard instance = new Scoreboard();
        User user = new User("Julia");
        Score<User> instance1 = new Score<>(user,528);
        instance.insertScore(instance1, 1000);
        instance.clear();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
}
