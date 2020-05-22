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
    
    private String menuState;
    public Menu(){
    }
    
    public void welcomeMenu(User user){
        menuState = "welcome";
        System.out.println("Hello " + user.getName());
        System.out.println("\n\n 1 - Iniciate New Game");
        System.out.println("2 - Load Game");
        System.out.println("3 - Show Personal Scores");
        System.out.println("4 - TOP 10 Ranks");
        System.out.println("0 - Exit");
    }   
    
    public void newGameMenu(){
        menuState = "newGame";
        System.out.println("1 - Basic mode");
        System.out.println("2 - Advanced mode");
        System.out.println("0 - Return");
    }
    
    public void top10Menu(){
    
    }
    
    public void personalScoresMenu(){
        
    }
    
    public String getMenuState(){
        return menuState;
    }
}
