package game;

import java.util.HashMap;
import java.util.HashSet;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import game.Board.*;
import game.Block;
import blocks.*;

/**
 *
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class BoardTest {

    public BoardTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getCoordinate method, of class Board.
     */
    @Test
    public void testGetCoordinate_int_int() {
        System.out.println("getCoordinate");
        int row = 1;
        int column = 0;
        Board instance = new Board();
        String expResult = "A1";
        String result = instance.getCoordinate(row, column);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCoordinate method, of class Board.
     */
    @Test
    public void testGetCoordinate_int_String() {
        System.out.println("getCoordinate");
        int row = 1;
        String column = "A";
        Board instance = new Board();
        String expResult = "A1";
        String result = instance.getCoordinate(row, column);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidInsertionCoords method, of class Board.
     */
    @Test
    public void testIsValidInsertionCoords() {
        System.out.println("isValidInsertionCoords");
        Piece piece = new IBlock();
        Board instance = new Board();

        HashSet<String> coords = instance.convertBlockCoordsToBoardCoords(piece, "d5");

        boolean expResult = false;
        boolean result = instance.isValidInsertionCoords(coords);
        assertEquals(expResult, result);
    }

    /**
     * Test of isThereSpaceleftInTheBoard method, of class Board.
     */
    @Test
    public void testIsThereSpaceleftInTheBoard() {
        System.out.println("isThereSpaceleftInTheBoard");
        Piece piece = new IBlock();
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isThereSpaceleftInTheBoard(piece);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Board.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Board instance = new Board();

        StringBuilder sb = new StringBuilder();
        String coord;

        sb.append(" |A|B|C|D|E|F|G|H|I\n");

        for (int i = 1; i <= 9; i++) {

            sb.append(i);

            for (int j = 0; j < 9; j++) {

                coord = instance.getCoordinate(i, j);
                sb.append("|" + instance.getCoords().get(coord));
            }
            sb.append("\n");
        }
        String expResult = sb.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
