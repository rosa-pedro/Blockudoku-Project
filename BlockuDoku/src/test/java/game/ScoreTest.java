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

import game.User;

/**
 *
 * @author Storm
 */
public class ScoreTest {
    
    public ScoreTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getValue method, of class Score.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        User user = new User("Julia");
        Score<User> instance = new Score<>(user,528);
        int expResult = 528;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getElement method, of class Score.
     */
    @Test
    public void testGetElement() {
        System.out.println("getElement");
        User user = new User("Julia");
        Score<User> instance = new Score<>(user,528);
        Object expResult = user;
        Object result = instance.getElement();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compareTo method, of class Score.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        User user = new User("Julia");
        Score<User> instance = new Score<>(user,528);
        User user1 = new User("Julia");
        Score<User> instance1 = new Score<>(user,528);
        int expResult = 0;
        int result = instance.compareTo(instance1);
        assertEquals(expResult, result);
    }
    
}
