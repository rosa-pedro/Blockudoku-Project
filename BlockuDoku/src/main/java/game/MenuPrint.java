/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Users.*;

/** This class consists of method to help display the menu
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
        System.out.println("\n1 - Iniciate New Game");
        System.out.println("2 - Load Game");
        System.out.println("3 - Show Personal Scores");
        System.out.println("4 - TOP 10 Ranks");
        System.out.println("0 - Exit");
    }

    /**
     * Displays all the information regarding the welcome menu
     */
    public static void welcomeMenu(User user) {
        System.out.println("Hello " + user.getName());
        mainMenu();
    }

    /**
     * Displays all the information regarding the new game menu
     */
    public static void newGameMenu() {
        System.out.println("1 - Basic mode");
        System.out.println("2 - Advanced mode");
        System.out.println("0 - Return");
    }

    /**
     * Displays all the information regarding the request of a users name
     */
    public static void requestUserName() {
        System.out.println("Welcome to Blocku Doku\n\n");
        System.out.print("Enter your User name: ");
    }

    public static void top10Menu() {

    }

    public static void personalScoresMenu() {

    }

    /**
     * Checks if there is an existing user with the given name and
     * returns it
     * 
     * @param userName of the user we are checking
     * @return the user if match found, new user if  no match found
     */
    public static User selectUser(String userName) {

        User user = null;

        if (checkExistingUser(userName)) {
            System.out.println("\nLoading User...\n");
            user = getExistingUser(userName);

        } else {
            System.out.println("\nCreating new User...\n");
            User newUser = new User(userName);
            addUser(newUser);
            return newUser;
        }

        return user;
    }
}
