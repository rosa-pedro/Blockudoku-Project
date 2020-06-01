package game;

/**
 * This class serves to parse Commands and to act as an intermediate between the
 * menu and the user inputs
 *
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class Menu {

    private Parser parser;
    private Scoreboard<User> gameScoreboard;
    private Users listOfUsers;
    private User currentUser;

    /**
     * Constructor for Menu, initialises parser, the ArrayList and the
     * ScoreBoard
     *
     *
     * @param listOfUsers assigns the listOfUsers
     */
    public Menu(Users listOfUsers) {

        this.parser = new Parser();
        this.gameScoreboard = new Scoreboard<>();
        this.listOfUsers = listOfUsers;
        this.currentUser = null;
    }

    /**
     * This method validates the username by checking if its blank or null
     *
     * @param username to be checked
     * @return username if valid
     * @throws GameIllegalArgumentException according to the error
     */
    public String validateUsername(String username) throws GameIllegalArgumentException {

        if (username == null) {
            throw new GameIllegalArgumentException(ErrorCode.USERNAME_CANT_BE_NULL);
        }
        if (username.isBlank()) {
            throw new GameIllegalArgumentException(ErrorCode.USERNAME_CANT_BE_EMPTY);
        }

        return username;
    }

    /**
     * Method to display the WelcomeMenu
     */
    public void WelcomeMenu() {

        while (true) {

            try {

                MenuPrint.requestUserName();
                String username = validateUsername(parser.readInput().toLowerCase());
                this.currentUser = readUser(username);
                MenuPrint.welcomeMenu(currentUser);
                break;

            } catch (IllegalArgumentException e) {

                System.out.println("\n" + e.getMessage() + " please try again!");
            }
        }
    }

    /**
     * Takes a userName and goes though the list of users
     *
     * @param userName username we are creating or getting
     * @return the User matching the name, or a newly created user
     */
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

    /**
     * ProcessCommand receives the User and his input and then calls other
     * method based on the input it has received
     *
     * @param user User playing the game
     * @param input Input from the User
     * @return true until the game is closed
     */
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

    /**
     * Method to display the New Game Menu
     *
     */
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

    /**
     * Method to display the top10 ranking menu
     */
    public void printTop10RankingMenu() {

        System.out.println("\nEntered to the Top 10 Ranking!");
        printScoreboard(getTop10RankingToString());

    }

    /**
     * Method to display the personal scores menu
     */
    public void printPersonalScoresMenu() {

        System.out.println("\nEntered to the Personal Score!");
        printScoreboard(getPersonalScoresToString());

    }

    /**
     * Method to display the scoreboard
     *
     * @param scoreboard scoreboard we are displaying
     */
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

    /**
     * Method to return a String containing the TOP10 Ranking
     *
     * @return String object
     */
    public String getTop10RankingToString() {

        listOfUsers.stream()
                .filter(u -> !u.getPersonalScores().isEmpty())
                .forEach(u -> gameScoreboard.insertScore(u, u.getPersonalScores().getHighestScore().getValue()));

        String scoreboard = gameScoreboard.toString();
        gameScoreboard.clear();

        return scoreboard;
    }

    /**
     * Method to return a String containing the Personal Scores Ranking
     *
     * @return String object
     */
    public String getPersonalScoresToString() {
        return currentUser.getPersonalScores().toString();
    }

    /**
     * Void method initializes a new game based on the gameMode it receives
     *
     * @param gameMode to start the game with
     */
    public void InitializeNewGame(GameMode gameMode) {

        Game game = new Game(gameMode);
        currentUser.setGame(game);

        game.play(parser);
        System.out.println("\nReturned to the Main Menu!");

        checkGame(game);
    }

    /**
     * Method to load game, if a user has a game to load, if not it'll create a
     * new one
     *
     */
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

    /**
     * Method to check where the game isOver or if the game is to be saved
     *
     * @param game Game to be checked
     */
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
