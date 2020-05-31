/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Storm
 */
public class MenuPrint {

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

    public static void welcomeMenu(User user) {

        System.out.println();
        System.out.println("Hello " + user.getName());
    }

    public static void newGameMenu() {

        System.out.println();
        System.out.println("1 - Basic mode");
        System.out.println("2 - Advanced mode");
        System.out.println("0 - Return");
        System.out.println();
        System.out.print("Choose a Game Difficulty: ");
    }

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
