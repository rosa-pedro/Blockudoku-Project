package game;

/**
 * This class consists of method to help display the menu
 *
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class MenuPrint {

    /**
     * Displays all the information regarding the main menu
     */
    public static void mainMenu() {

        System.out.println();
        System.out.println("1 - Initialize New Game");
        System.out.println("2 - Load Game");
        System.out.println("3 - Show Personal Scores");
        System.out.println("4 - TOP 10 Ranks");
        System.out.println("0 - Exit");
        System.out.println();
        System.out.print("Choose a Menu Option: ");
    }

    /**
     * Displays all the information regarding the welcome menu
     */
    public static void welcomeMenu(User user) {

        String username = user.getName();

        System.out.println();
        System.out.println("Hello " + username.substring(0, 1).toUpperCase() + username.substring(1));
    }

    /**
     * Displays all the information regarding the new game menu
     */
    public static void newGameMenu() {

        System.out.println();
        System.out.println("1 - Basic mode");
        System.out.println("2 - Advanced mode");
        System.out.println("0 - Return");
        System.out.println();
        System.out.print("Choose a Game Difficulty: ");
    }

    /**
     * Displays all the information regarding the request of a users name
     */
    public static void requestUserName() {

        System.out.println();
        System.out.println("Welcome to BlockuDoku");
        System.out.println();
        System.out.print("Enter your User Name: ");
    }

    /**
     * Displays information exclusively related to returning to the main menu
     */
    public static void returnToMainMenu() {

        System.out.println("0 - Return");
        System.out.println();
        System.out.print("Choose a Menu Option: ");
    }
}
