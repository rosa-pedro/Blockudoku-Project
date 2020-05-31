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
public class Menu {

    private Parser parser;
    private Scoreboard<User> gameScoreboard;
    private Users listOfUsers;
    private User currentUser;

    public Menu(Users listOfUsers) {

        this.parser = new Parser();
        this.gameScoreboard = new Scoreboard<>();
        this.listOfUsers = listOfUsers;
        this.currentUser = null;
    }

    public void WelcomeMenu() {

        MenuPrint.requestUserName();
        this.currentUser = readUser(parser.readInput().toLowerCase());
        MenuPrint.welcomeMenu(currentUser);
    }

    public User readUser(String userName) {

        User user = listOfUsers.getUser(userName);

        if (user != null) {
            System.out.println("\nLoading User...");

        } else {
            System.out.println("\nCreating new User...");
            User newUser = new User(userName);
            listOfUsers.add(newUser);
            return newUser;
        }
        return user;
    }

    public boolean mainMenu() {

        MenuPrint.mainMenu();
        String input = parser.readInput();

        switch (input) {
            case "1":
                newGameMenu();
                break;
            case "2":
                loadGame();
                break;
            case "3":
                printPersonalScoresMenu();
                break;
            case "4":
                printTop10RankingMenu();
                break;
            case "0":
                System.out.println("\nExited the game!");
                return true;
            default:
                System.out.println("\nInvalid command!");
        }
        return false;
    }

    public void newGameMenu() {

        System.out.println("\nEntered to the New Game Menu!");

        while (true) {

            MenuPrint.newGameMenu();
            String input = parser.readInput();

            switch (input) {
                case "1":
                    System.out.println("\nEntered Basic mode!");
                    InitializeNewGame(GameMode.BASIC_MODE);
                    return;
                case "2":
                    System.out.println("\nEntered Advanced mode!");
                    InitializeNewGame(GameMode.ADVANCED_MODE);
                    return;
                case "0":
                    System.out.println("\nReturned to the Main Menu!");
                    return;
                default:
                    System.out.println("\nInvalid command!");
                    break;
            }
        }
    }

    public void printTop10RankingMenu() {

        System.out.println("\nEntered to the Top 10 Ranking!");
        printScoreboard(getTop10RankingToString());

    }

    public void printPersonalScoresMenu() {

        System.out.println("\nEntered to the Personal Score!");
        printScoreboard(getPersonalScoresToString());

    }

    public void printScoreboard(String scoreboard) {

        while (true) {

            System.out.println();
            System.out.println(scoreboard);
            MenuPrint.returnToMainMenu();

            String input = parser.readInput();

            if (input.equals("0")) {
                System.out.println("\nReturned to the Main Menu!");
                break;
            }

            System.out.println("\nInvalid command!");
        }
    }

    public String getTop10RankingToString() {

        listOfUsers.stream()
                .filter(u -> !u.getPersonalScores().isEmpty())
                .forEach(u -> gameScoreboard.insertScore(u, u.getPersonalScores().getHighestScore().getValue()));

        String scoreboard = gameScoreboard.toString();
        gameScoreboard.clear();

        return scoreboard;
    }

    public String getPersonalScoresToString() {
        return currentUser.getPersonalScores().toString();
    }

    public void InitializeNewGame(GameMode gameMode) {

        Game game = new Game(gameMode);
        currentUser.setGame(game);
        game.play(parser);
        System.out.println("\nReturned to the Main Menu!");

        checkGame(game);
    }

    public void loadGame() {

        Game game = currentUser.getGame();

        if (game == null) {
            System.out.println("\nYou don't have a game to load...");
            return;
        }

        System.out.println("\nLoading Game...");
        game.play(parser);
        System.out.println("\nReturned to the Main Menu!");

        checkGame(game);
    }

    public void checkGame(Game game) {

        if (game.isOver()) {

            currentUser.getPersonalScores().insertScore(game, game.getGameScore());
            currentUser.setGame(null);
        }

        if (!game.isToBeSaved()) {
            currentUser.setGame(null);
        }
    }
}
