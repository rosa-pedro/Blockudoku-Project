/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

/**
 *
 * @author Storm
 */
public class Program {

    public static void main(String[] args) {

        String filename = "save.bin";
        boolean existsFile = Files.exists(Paths.get(filename));

        Users loadedUsers = UsersFileHandler.readFile(filename);

        if (!existsFile) {

            User user1 = new User("Maleque");
            User user2 = new User("Leleque");
            User user3 = new User("Jaleque");
            User user4 = new User("Rosa");
            User user5 = new User("João");
            User user6 = new User("Kaleque");

            Game game1 = new Game(GameMode.BASIC_MODE);
            game1.setTime(LocalDateTime.now());
            Game game2 = new Game(GameMode.BASIC_MODE);
            game2.setTime(LocalDateTime.now());
            Game game3 = new Game(GameMode.ADVANCED_MODE);
            game3.setTime(LocalDateTime.now());
            Game game4 = new Game(GameMode.BASIC_MODE);
            game4.setTime(LocalDateTime.now());
            Game game5 = new Game(GameMode.ADVANCED_MODE);
            game5.setTime(LocalDateTime.now());
            Game game6 = new Game(GameMode.ADVANCED_MODE);
            game6.setTime(LocalDateTime.now());
            Game game7 = new Game(GameMode.BASIC_MODE);
            game7.setTime(LocalDateTime.now());
            Game game8 = new Game(GameMode.BASIC_MODE);
            game8.setTime(LocalDateTime.now());
            Game game9 = new Game(GameMode.BASIC_MODE);
            game9.setTime(LocalDateTime.now());
            Game game10 = new Game(GameMode.ADVANCED_MODE);
            game10.setTime(LocalDateTime.now());
            Game game11 = new Game(GameMode.ADVANCED_MODE);
            game11.setTime(LocalDateTime.now());

            user1.getPersonalScores().insertScore(game1, 13);
            user1.getPersonalScores().insertScore(game2, 54);
            user2.getPersonalScores().insertScore(game3, 72);
            user2.getPersonalScores().insertScore(game4, 34);
            user3.getPersonalScores().insertScore(game5, 254);
            user3.getPersonalScores().insertScore(game6, 130);
            user3.getPersonalScores().insertScore(game7, 2);
            user4.getPersonalScores().insertScore(game8, 78);
            user4.getPersonalScores().insertScore(game9, 17);
            user5.getPersonalScores().insertScore(game10, 91);
            user6.getPersonalScores().insertScore(game11, 174);

            loadedUsers.add(user1);
            loadedUsers.add(user2);
            loadedUsers.add(user3);
            loadedUsers.add(user4);
            loadedUsers.add(user5);
            loadedUsers.add(user6);

        }

        boolean finished = false;
        Menu menu = new Menu(loadedUsers);

        menu.WelcomeMenu();

        while (!finished) {

            finished = menu.mainMenu();
        }

        UsersFileHandler.saveFile(loadedUsers, filename);
    }
}
