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
public class Menu {
    
    
    public Menu(){
    }
    
    public void mainMenu(){
        System.out.println("\n1 - Iniciate New Game");
        System.out.println("2 - Load Game");
        System.out.println("3 - Show Personal Scores");
        System.out.println("4 - TOP 10 Ranks");
        System.out.println("0 - Exit");
    }   
    
    public void welcomeMenu(User user){
        System.out.println("Hello " + user.getName());
        mainMenu();
    } 
    
    
    public void newGameMenu(){
        System.out.println("1 - Basic mode");
        System.out.println("2 - Advanced mode");
        System.out.println("0 - Return");
    }
    
    public void requestUserName(){
        System.out.println("Welcome to Blocku Doku\n\n");
        System.out.print("Enter your User name: ");
    }
    
    
    public void top10Menu(){
    
    }
    
    public void personalScoresMenu(){
        
    }
}
