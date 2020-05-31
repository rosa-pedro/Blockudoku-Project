/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.MenuPrint.*;
import java.time.LocalDateTime;

/**
 *
 * @author Storm
 */
public class SandBoxy {

    public static void main(String[] args) {
        /*
        Users users = new Users();
        Users loadedUsers = readFile("poggers2.bin");
        
        boolean finished = false;
        Parser parser = new Parser();
        ProcessCommand pc = new ProcessCommand();*/
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
        
        
        user1.addPersonalScore(game3, 13);
        user1.setGame(game3);
        user1.addPersonalScore(game4, 203);
        user2.addPersonalScore(game5, 72);
        user3.addPersonalScore(game6, 23);
        
        users.addUser(user1);
        //users.addUser(selectedUser);
        users.addUser(user2);
        users.addUser(user3);
        
        ^*/

        //Users users = new Users();
        //System.out.println(listOfUsers);
        //String filename = "save.bin";
        //UserFileHandler.saveFile(listOfUsers, filename);
        // Users newListOfUsers = UsersFileHandler.readFile("save.bin");
        //user1.addPersonalScore(game1, 13);
        //user2.addPersonalScore(game2, 72);
        //user3.addPersonalScore(game3, 23);
        Users loadedUsers = UsersFileHandler.readFile("save.bin");
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
        
        user1.setGame(game1);
        user2.setGame(game2);
        user3.setGame(game3);

        user1.getPersonalScores().insertScore(game1, 13);
        user2.getPersonalScores().insertScore(game2, 72);
        user3.getPersonalScores().insertScore(game3, 23);

        loadedUsers.add(user1);
        loadedUsers.add(user2);
        loadedUsers.add(user3);
        */
        
        
        //Ranking ranking = new Ranking();
        //loadedUsers.getUsers().forEach(u -> ranking.addUserHighScore(u.getHighScore()));
        //System.out.println(ranking.getHighScoreBoard().toStringGame());
        boolean finished = false;
        Parser parser = new Parser();
        //ProcessCommand pc = new ProcessCommand(loadedUsers);
        Menu menu = new Menu(loadedUsers);

        requestUserName();
        User selectedUser = menu.selectUser(parser.readInput(), loadedUsers);
        MenuPrint.welcomeMenu(selectedUser);

        while (!finished) {

            String command = parser.readInput();
            finished = menu.processCommand(selectedUser, command);
        }

        menu.getGameScoreboard().clear();

        UsersFileHandler.saveFile(loadedUsers, "save.bin");

        /*
        selectedUser.addPersonalScore(game1, 23);
        selectedUser.addPersonalScore(game2, 133);
        
        addUserHighScore(user1.getHighScore());
        addUserHighScore(user2.getHighScore());
        addUserHighScore(user3.getHighScore());
        addUserHighScore(selectedUser.getHighScore());*/
        //System.out.println(getHighScoreBoard().toStringGame());
        //saveFile(users,"poggers2.bin");
        /*
        Users listOfUsers = new Users();

        User user1 = new User("Maleque");
        User user2 = new User("Leleque");
        User user3 = new User("Jaleque");

        listOfUsers.addUser(user1);
        listOfUsers.addUser(user2);
        listOfUsers.addUser(user3);

        Game game1 = new Game(GameMode.BASIC_MODE);
        game1.setTime(LocalDateTime.now());
        Game game2 = new Game(GameMode.BASIC_MODE);
        game2.setTime(LocalDateTime.now());
        Game game3 = new Game(GameMode.BASIC_MODE);
        game3.setTime(LocalDateTime.now());

        user1.addPersonalScore(game1, 13);
        user2.addPersonalScore(game2, 72);
        user3.addPersonalScore(game3, 23);

        System.out.println(listOfUsers);

        String filename = "save.bin";

        UsersFileHandler.saveFile(listOfUsers, filename);

        Users newListOfUsers = UsersFileHandler.readFile("save.bin");
        
         */
        //System.out.println(newListOfUsers);
        // Ranking ranking = new Ranking();
        //newListOfUsers.getUsers().forEach(u -> ranking.addUserHighScore(u.getHighScore()));
        //ranking.getHighScoreBoard();
        //user1.getHighScore();
        //ranking.addUserHighScore(user1.getHighScore());
        //ranking.addUserHighScore(user2.getHighScore());
        //ranking.addUserHighScore(user3.getHighScore());
        //System.out.println(ranking.getHighScoreBoard().toStringGame());
    }

}
