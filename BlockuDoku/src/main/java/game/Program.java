/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author rosap
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Users loadedUsers = UsersFileHandler.readFile("save.bin");
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

        loadedUsers.addUser(user1);
        loadedUsers.addUser(user2);
        loadedUsers.addUser(user3);
         */
        //Ranking ranking = new Ranking();
        //loadedUsers.getUsers().forEach(u -> ranking.addUserHighScore(u.getHighScore()));
        //System.out.println(ranking.getHighScoreBoard().toStringGame());
        /*
        boolean finished = false;
        Parser parser = new Parser();
        Menu menu = new Menu(loadedUsers);

        MenuPrint.requestUserName();
        User selectedUser = menu.selectUser(parser.readInput(), loadedUsers);
        MenuPrint.welcomeMenu(selectedUser);

        while (!finished) {

            String command = parser.readInput();
            finished = menu.processCommand(selectedUser, command);
        }

        menu.getGameScoreboard().clear();

        UsersFileHandler.saveFile(loadedUsers, "save.bin");

    

         */
    }
}