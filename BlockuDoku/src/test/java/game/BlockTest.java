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
import game.Block;
import blocks.*;
/**
 *
 * @author Storm
 */
public class BlockTest {
    
    public BlockTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getBlockPiece method, of class Block.
     */
    @Test
    public void testGetBlockPiece() {
        System.out.println("getBlockPiece");
        Piece piece = new IBlock();
        Block instance = new Block("A", piece);
        Piece expResult = piece;
        Piece result = instance.getBlockPiece();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBlockName method, of class Block.
     */
    @Test
    public void testGetBlockName() {
        System.out.println("getBlockName");
        Block instance = new Block("A", new IBlock());
        String expResult = "A";
        String result = instance.getBlockName();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Block.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Block instance = new Block("A", new IBlock());
        
        StringBuilder sb = new StringBuilder();
        sb.append("Block " + "A" + "\n");
        sb.append(instance.getBlockPiece());
        String expResult = sb.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
