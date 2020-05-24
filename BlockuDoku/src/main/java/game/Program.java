/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import blocks.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author rosap
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        boolean finished = false;

        User user1 = new User("Maleque");
        User user2 = new User("Leleque");
        User user3 = new User("Jaleque");

        Menu m1 = new Menu();

        Score<User> sc1 = new Score(user1);
        Score<User> sc2 = new Score(user2);
        Score<User> sc3 = new Score(user3);

        sc1.addScore(12);
        sc2.addScore(52);
        sc3.addScore(223);
        
        Parser p1 = new Parser();
        m1.welcomeMenu(user1);
        ProcessCommand pc = new ProcessCommand();
        Scoreboard s1 = new Scoreboard();

        while(!finished){
           finished = pc.processMenu(user1, p1.readInput());
        }
        
    }

}
