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
public class ProcessCommand {

    private Menu menu;
    private boolean finished;
    public Parser p1;
    public GameRound gr1;
    public Board board;

    public ProcessCommand() {
        menu = new Menu();
        finished = false;
        p1 = new Parser();
        board = new Board();
        
    }
    
    
    
    

    public boolean processMenu(User user, String input) {
        
        switch (input.trim()) {
            case "1":
                System.out.println("New game");
                menu.newGameMenu();
                String secondInput = p1.readInput();
                switch (secondInput.trim()) {
                    case "1":
                        System.out.println("Entered Basic mode");
                        //p1.processGameCommand(p1.readInput());
                        gr1 = new GameRound(board,p1);
                        break;
                    case "2":
                        System.out.println("Entered Advanced mode");
                        break;
                    case "0":
                        System.out.println("Returned to Main Menu");
                        menu.mainMenu();
                        break;
                    default:
                        System.out.println("Invalid command");
                        return finished;
                    }
                break;
            case "2":
                System.out.println("Load game");
                break;
            case "3":
                System.out.println("Personal scores");
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
