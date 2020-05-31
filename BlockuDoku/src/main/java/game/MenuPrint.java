/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 * This class consists of method to help display the menu
 *
 *
 * @author Pedro Rosa - 190221015
 * @author Joao Cetano - 190221010
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

        System.out.println();
        System.out.println("Hello " + user.getName());
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

    public static void returnToMainMenu() {

        System.out.println("0 - Return");
        System.out.println();
        System.out.print("Choose a Menu Option: ");
    }
}
