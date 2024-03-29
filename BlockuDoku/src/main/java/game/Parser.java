package game;

import java.util.Scanner;

/**
 * This class serves as the input reader for the program
 *
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
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
