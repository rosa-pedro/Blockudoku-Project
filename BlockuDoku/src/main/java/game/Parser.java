/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Scanner;

/**
 *
 * @author Storm
 */
public class Parser {
    static Scanner sc;

    public Parser() {
        sc = new Scanner(System.in);
    }

    public String readInput() {
        return sc.nextLine().trim();
    }

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
