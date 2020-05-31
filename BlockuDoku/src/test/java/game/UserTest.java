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
     * Test of loadGame method, of class User.
     */
    @Test
    public void testLoadGame() {
        System.out.println("loadGame");
        User instance = new User("Julia");
        boolean expResult = false;
        boolean result = instance.loadGame();
        assertEquals(expResult, result);
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
        Game game2 = instance.getGame();
        assertEquals(game, game2);
    }

    /**
     * Test of getGame method, of class User.
     */
    @Test
    public void testGetGame() {
        System.out.println("getGame");
        User instance = new User("Julia");
        Game game = new Game(GameMode.BASIC_MODE);
        instance.setGame(game);
        Game result = instance.getGame();
        assertEquals(game, result);
    }
    
}
