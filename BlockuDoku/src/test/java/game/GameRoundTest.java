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
public class GameRoundTest {
    
    public GameRoundTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    

    /**
     * Test of checkRound method, of class GameRound.
     */
    @Test
    public void testCheckRound() {
        System.out.println("checkRound");
        Board board =  new Board();
        GameRound instance = new GameRound(board, GameMode.BASIC_MODE);
        boolean expResult = true;
        boolean result = instance.checkRound();
        assertEquals(expResult, result);
    }

    /**
     * Test of getScore method, of class GameRound.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Board board =  new Board();
        GameRound instance = new GameRound(board, GameMode.BASIC_MODE);
        int expResult = 0;
        int result = instance.getScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of isGameOver method, of class GameRound.
     */
    @Test
    public void testIsGameOver() {
        System.out.println("isGameOver");
        Board board =  new Board();
        GameRound instance = new GameRound(board, GameMode.BASIC_MODE);
        boolean expResult = true;
        boolean result = instance.isGameOver();
        assertEquals(expResult, result);
    }

}
