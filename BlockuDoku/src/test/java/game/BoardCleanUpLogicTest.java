/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.HashSet;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import game.Block;
import blocks.*;
import game.Board;
import static game.BoardCleanUpLogic.getFullColumns;
import static game.BoardCleanUpLogic.getFullRows;
import static game.BoardCleanUpLogic.getFullSquares;
/**
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class BoardCleanUpLogicTest {
    
    public BoardCleanUpLogicTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of cleanUpBoard method, of class BoardCleanUpLogic.
     */
    @Test
    public void testCleanUpBoard() {
        System.out.println("cleanUpBoard");
        Board board = new Board();
        Block block = new Block("A", new QExtendedBlock());
        board.insertBlock(block.getBlockPiece(), "A1");
        int expResult = 46;
        int result = BoardCleanUpLogic.cleanUpBoard(board);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCleanUpBoardScore method, of class BoardCleanUpLogic.
     */
    @Test
    public void testGetCleanUpBoardScore() {
        System.out.println("getCleanUpBoardScore");
        Board board = new Board();
        
        HashSet<String> toBeCleanUp = getFullSquares(board);
        toBeCleanUp.addAll(getFullRows(board));
        toBeCleanUp.addAll(getFullColumns(board));
        
        int expResult = 0;
        int result = BoardCleanUpLogic.getCleanUpBoardScore(board, toBeCleanUp);
        assertEquals(expResult, result);
    }
    
}
