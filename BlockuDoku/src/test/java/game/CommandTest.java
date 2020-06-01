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
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class CommandTest {
    public CommandTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getBlockCommand method, of class Command.
     */
    @Test
    public void testGetBlockCommand() {
        System.out.println("getBlockCommand");
        Command instance = new Command("A","C4");
        String expResult = "A";
        String result = instance.getBlockCommand();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCoordCommand method, of class Command.
     */
    @Test
    public void testGetCoordCommand() {
        System.out.println("getCoordCommand");
        Command instance = new Command("A","C4");
        String expResult = "C4";
        String result = instance.getCoordCommand();
        assertEquals(expResult, result);
    }

    /**
     * Test of isBlockCommandValid method, of class Command.
     */
    @Test
    public void testIsBlockCommandValid() {
        System.out.println("isBlockCommandValid");
        Command instance =  new Command("A","C4");
        boolean expResult = true;
        boolean result = instance.isBlockCommandValid();
        assertEquals(expResult, result);
    }

    /**
     * Test of isCoordCommandvalid method, of class Command.
     */
    @Test
    public void testIsCoordCommandvalid() {
        System.out.println("isCoordCommandvalid");
        Board board = new Board();
        Command instance = new Command("A","C4");
        boolean expResult = true;
        boolean result = instance.isCoordCommandvalid(board);
        assertEquals(expResult, result);
    }

    /**
     * Test of isCommandValid method, of class Command.
     */
    @Test
    public void testIsCommandValid() {
        System.out.println("isCommandValid");
        Board board = new Board();
        Command instance = new Command("A","C4");
        boolean expResult = true;
        boolean result = instance.isCommandValid(board);
        assertEquals(expResult, result);
    }
    
}
