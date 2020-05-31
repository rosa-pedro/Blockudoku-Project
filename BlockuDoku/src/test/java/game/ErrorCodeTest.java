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
public class ErrorCodeTest {
    
    public ErrorCodeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of toString method, of class ErrorCode.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ErrorCode instance = ErrorCode.INVALID_BLOCK_INSERTION;
        String expResult = "Invalid Block Insertion";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
