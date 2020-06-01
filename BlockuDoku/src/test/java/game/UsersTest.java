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
public class UsersTest {
    
    public UsersTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getUser method, of class Users.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        String userName = "Julia";
        User instance1 = new User("Julia");
        Users instance = new Users();
        instance.add(instance1);
        User expResult = instance1;
        User result = instance.getUser(userName);
        assertEquals(expResult, result);
    }
    
}
