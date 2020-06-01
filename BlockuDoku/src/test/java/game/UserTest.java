/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Storm
 */
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = new User("Julia");
        String expResult = "Julia";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGame method, of class User.
     */
    @Test
    public void testSetGame() {
        System.out.println("setGame");
        Game game = new Game(GameMode.BASIC_MODE);
        User instance = new User("Julia");
        instance.setGame(game);
        Game expResult = instance.getGame();
        assertEquals(expResult,game);
    }

    /**
     * Test of getGame method, of class User.
     */
    @Test
    public void testGetGame() {
        System.out.println("getGame");
        Game game = new Game(GameMode.BASIC_MODE);
        User instance = new User("Julia");
        instance.setGame(game);
        Game result = instance.getGame();
        assertEquals(game, result);
    }

    
}
