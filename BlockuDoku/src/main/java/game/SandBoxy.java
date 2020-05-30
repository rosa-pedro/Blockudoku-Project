/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.MenuPrint.*;
import static game.Users.*;
import static game.Ranking.*;
import static game.FileHandler.*;
import java.time.LocalDateTime;

/**
 *
 * @author Storm
 */
public class SandBoxy {

    public static void main(String[] args) {
        
        Users users = new Users();
        users = readSerializedFile("poggers2.bin");
        
        boolean finished = false;
        Parser parser = new Parser();
        ProcessCommand pc = new ProcessCommand();
       
        
        /*
        User user1 = new User("Maleque");
        User user2 = new User("Leleque");
        User user3 = new User("Jaleque");
        
        Game game1 = new Game(GameMode.BASIC_MODE);
        game1.setTime(LocalDateTime.now());
        Game game2 = new Game(GameMode.BASIC_MODE);
        game2.setTime(LocalDateTime.now());
        Game game3 = new Game(GameMode.BASIC_MODE);
        game3.setTime(LocalDateTime.now());
        Game game4 = new Game(GameMode.BASIC_MODE);
        game4.setTime(LocalDateTime.now());
        Game game5 = new Game(GameMode.BASIC_MODE);
        game5.setTime(LocalDateTime.now());
        Game game6 = new Game(GameMode.BASIC_MODE);
        game6.setTime(LocalDateTime.now());
        Game game7 = new Game(GameMode.BASIC_MODE);
        game7.setTime(LocalDateTime.now());
        Game game8 = new Game(GameMode.BASIC_MODE);
        game8.setTime(LocalDateTime.now());
        /*
        user1.addPersonalScore(game3, 13);
        user1.setGame(game3);
        user1.addPersonalScore(game4, 203);
        user2.addPersonalScore(game5, 72);
        user3.addPersonalScore(game6, 23);
        
        users.addUser(user1);
        //users.addUser(selectedUser);
        users.addUser(user2);
        users.addUser(user3);*/
        
        

        requestUserName();
        User selectedUser = selectUser(parser.readInput());
        welcomeMenu(selectedUser);
        
        //selectedUser.addPersonalScore(game1, 23);
        //selectedUser.addPersonalScore(game2, 133);
        
        while(!finished){
            finished = pc.processMenu(selectedUser, parser.readInput());
        }
        
        
        /*
        addUserHighScore(user1.getHighScore());
        addUserHighScore(user2.getHighScore());
        addUserHighScore(user3.getHighScore());
        addUserHighScore(selectedUser.getHighScore());*/
        
        //saveFile(users,"poggers2.bin");
        //System.out.println(getHighScoreBoard().toStringGame());
        
        
        
    }

}
