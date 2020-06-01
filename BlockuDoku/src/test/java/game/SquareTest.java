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
public class SquareTest {
    
    public SquareTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of changeVisibility method, of class Square.
     */
    @Test
    public void testChangeVisibility() {
        System.out.println("changeVisibility");
        Square instance = new Square(true);
        instance.changeVisibility();
        boolean expResult = false;
        boolean result = instance.isVisible();
        assertEquals(expResult,result);
    }

    /**
     * Test of isVisible method, of class Square.
     */
    @Test
    public void testIsVisible() {
        System.out.println("isVisible");
        Square instance = new Square(true);
        boolean expResult = true;
        boolean result = instance.isVisible();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Square.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Square instance = new Square(true);
        String expResult = "#";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
