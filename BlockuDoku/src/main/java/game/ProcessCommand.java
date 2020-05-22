/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ips.blockudoku.game;

/**
 *
 * @author Storm
 */
public class ProcessCommand {

    private Menu menu;
    private boolean finished;
    //private String menuState;

    public ProcessCommand() {
        menu = new Menu();
        finished = false;
    }

    public boolean processCommand(User user, String input, String menuState) {

        if (menuState.contains("welcome")) {
            
            switch (input.trim()) {
                case "1":
                    System.out.println("New game");
                    menu.newGameMenu();
                case "2":
                    System.out.println("Load game");
                case "4":
                    System.out.println("TOP10 ranking");
                case "0":
                    System.out.println("Exit");
                    return finished = true;
                default:
                    System.out.println("Invalid command");
                    return finished;
            }
        } else if (menuState.contains("newGame")) {
            
               switch (input.trim()) {
                case "1":
                    System.out.println("Basic mode");
                    menu.newGameMenu();
                case "2":
                    System.out.println("Advanced mode");
                case "0":
                    System.out.println("Return");
                    menu.welcomeMenu(user);
            }

        }

        return finished;
    }

}
