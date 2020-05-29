/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import static game.FileHandler.*;
import static game.Users.*;
import static game.Ranking.*;

/**
 *
 * @author Storm
 */
public class ProcessCommand {

    private boolean finished;
    public Parser parser;
    public GameRound gr1;
    public Board board;
    
    public Game game;

    public Game testGame;
    
    public ProcessCommand() {
        finished = false;
        parser = new Parser();
        board = new Board();
        
    }
    
    
    public boolean processMenu(User user, String input) {
        
        switch (input.trim()) {
            case "1":
                System.out.println("New game");
                MenuPrint.newGameMenu();
                String secondInput = parser.readInput();
                switch (secondInput.trim()) {
                    case "1":
                        System.out.println("Entered Basic mode");
                        //p1.processGameCommand(p1.readInput());
                        //gr1 = new GameRound(board,p1);
                        game = new Game(GameMode.BASIC_MODE);
                        game.play(parser);
                        MenuPrint.mainMenu();
                        break;
                    case "2":
                        System.out.println("Entered Advanced mode");
                        break;
                    case "0":
                        System.out.println("Returned to Main Menu");
                        MenuPrint.mainMenu();
                        break;
                    default:
                        System.out.println("Invalid command");
                        return finished;
                    }
                break;
            case "2":
                
                System.out.println("Loading game");
                
                user.loadGame();
                break;
            case "3":
                System.out.println("Personal scores");
                System.out.println(user.getPersonalGameList());
                break;
            case "4":
                System.out.println("TOP10 ranking");
                
                break;
            case "0":
                System.out.println("Exit");
                finished = true;
            break;
            default:
                System.out.println("Invalid command");
                return finished;
        }
        
        return finished;
    }

    
    
    
    
}
