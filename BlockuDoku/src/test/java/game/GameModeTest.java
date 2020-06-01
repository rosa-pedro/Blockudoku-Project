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
public class GameModeTest {

    public GameModeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of toString method, of class GameMode.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GameMode instance = GameMode.BASIC_MODE;
        String expResult = "Basic mode";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
