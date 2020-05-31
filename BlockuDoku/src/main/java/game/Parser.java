/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Scanner;

/**
 * This class serves as the input reader for the program
 *
 *
 * @author Pedro Rosa - 190221015
 * @author Joao Cetano - 190221010
 */
public class Parser {

    private Scanner sc;

    /**
     * Constructor initiates the Scanner
     */
    public Parser() {
        sc = new Scanner(System.in);
    }

    /**
     * Static method to read input
     *
     * @return next line written by the user
     */
    public String readInput() {
        return sc.nextLine().trim();
    }

    /**
     * Takes a string and converts it to a Command object
     *
     * @param input String we are converting
     * @return new Command object based off the string
     */
    public Command getGameCommand(String input) {

        String in = input;
        String[] arrOfStr = in.split("-");

        Command command = null;

        if (arrOfStr.length == 2) {
            command = new Command(arrOfStr[0], arrOfStr[1]);
        }

        return command;
    }

}
