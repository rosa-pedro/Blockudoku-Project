package game;

import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class GameTest {

    public GameTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of setTime method, of class Game.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        LocalDateTime date = LocalDateTime.now();
        Game instance = new Game(GameMode.BASIC_MODE);
        instance.setTime(date);
        String expResult = date.getHour() + ":" + date.getMinute() + " " + date.getDayOfMonth() + "/" + date.getMonthValue();
        assertEquals(expResult, instance.getTime());
    }

    /**
     * Test of getTime method, of class Game.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        LocalDateTime date = LocalDateTime.now();
        Game instance = new Game(GameMode.BASIC_MODE);
        instance.setTime(date);
        String expResult = date.getHour() + ":" + date.getMinute() + " " + date.getDayOfMonth() + "/" + date.getMonthValue();
        assertEquals(expResult, instance.getTime());
    }

    /**
     * Test of getGameScore method, of class Game.
     */
    @Test
    public void testGetGameScore() {
        System.out.println("getGameScore");
        Game instance = new Game(GameMode.BASIC_MODE);
        int expResult = 0;
        int result = instance.getGameScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of isOver method, of class Game.
     */
    @Test
    public void testIsOver() {
        System.out.println("isOver");
        Game instance = new Game(GameMode.BASIC_MODE);
        boolean expResult = false;
        boolean result = instance.isOver();
        assertEquals(expResult, result);
    }

    /**
     * Test of isToBeSaved method, of class Game.
     */
    @Test
    public void testIsToBeSaved() {
        System.out.println("isToBeSaved");
        Game instance = new Game(GameMode.BASIC_MODE);
        boolean expResult = false;
        boolean result = instance.isToBeSaved();
        assertEquals(expResult, result);
    }

}
